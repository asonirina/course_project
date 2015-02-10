package by.bsu.project.antlr.rted;

import by.bsu.project.antlr.model.TreeNode;
import by.bsu.project.antlr.model.TreeNodeDistanceMap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import static by.bsu.project.antlr.rted.RTEDConstants.LEFT;
import static by.bsu.project.antlr.rted.RTEDConstants.RIGHT;
import static by.bsu.project.antlr.rted.RTEDConstants.HEAVY;
import static by.bsu.project.antlr.rted.RTEDConstants.BOTH;

import static by.bsu.project.antlr.rted.RTEDConstants.POST2_SIZE;
import static by.bsu.project.antlr.rted.RTEDConstants.POST2_KR_SUM;
import static by.bsu.project.antlr.rted.RTEDConstants.POST2_REV_KR_SUM;
import static by.bsu.project.antlr.rted.RTEDConstants.POST2_DESC_SUM;
import static by.bsu.project.antlr.rted.RTEDConstants.POST2_PRE;
import static by.bsu.project.antlr.rted.RTEDConstants.POST2_PARENT;
import static by.bsu.project.antlr.rted.RTEDConstants.POST2_LABEL;
import static by.bsu.project.antlr.rted.RTEDConstants.KR;
import static by.bsu.project.antlr.rted.RTEDConstants.POST2_LLD;
import static by.bsu.project.antlr.rted.RTEDConstants.POST2_MIN_KR;
import static by.bsu.project.antlr.rted.RTEDConstants.RKR;
import static by.bsu.project.antlr.rted.RTEDConstants.RPOST2_RLD;
import static by.bsu.project.antlr.rted.RTEDConstants.RPOST2_MIN_RKR;
import static by.bsu.project.antlr.rted.RTEDConstants.RPOST2_POST;
import static by.bsu.project.antlr.rted.RTEDConstants.POST2_STRATEGY;
import static by.bsu.project.antlr.rted.RTEDConstants.PRE2_POST;


public class InfoTree {

    private List<TreeNode> inputTree;

    public int[][] info;
    private TreeNodeDistanceMap map;

    public boolean[][] nodeType; // store the type of a node: for every node stores three boolean values (L, R, H)
    
    // paths and rel subtrees are inside 2D arrays to be able to get them by paths/relsubtrees[L/R/H][node]
    private int[][] paths;
    private int[][][] relSubtrees;

    private int sizeTmp =           0; // temporal value of size of a subtree
    private int descSizesTmp =      0; // temporal value of sum of descendat sizes
    private int krSizesSumTmp =     0; // temporal value of sum of key roots sizes
    private int revkrSizesSumTmp =  0; // temporal value of sum of reversed hey roots sizes
    private int preorderTmp =       0; // temporal value of preorder
    
    private int currentNode = -1;
    
    // remembers if the trees order was switched during the recursion (in comparison with the order of input trees)
    private boolean switched = false;
    
    private int leafCount = 0;
    private int treeSize = 0;
    
    public InfoTree(List<TreeNode> aInputTree, TreeNodeDistanceMap aMap) {
        this.inputTree = aInputTree;
        this.treeSize = inputTree.size();
        this.info = new int[16][treeSize];
        Arrays.fill(info[POST2_PARENT], -1);
        Arrays.fill(info[POST2_MIN_KR], -1);
        Arrays.fill(info[RPOST2_MIN_RKR], -1);
        Arrays.fill(info[POST2_STRATEGY], -1);
        this.paths = new int[3][treeSize];
        Arrays.fill(paths[LEFT], -1);
        Arrays.fill(paths[RIGHT], -1);
        Arrays.fill(paths[HEAVY], -1);
        this.relSubtrees = new int[3][treeSize][];
        this.nodeType = new boolean[3][treeSize];
        this.map = aMap;
        this.currentNode = treeSize-1;
        gatherInfo(inputTree, -1);
        postTraversalProcessing();
    }

    public int getSize() {
        return treeSize;
    }
    
    public boolean ifNodeOfType(int postorder, int type) {
        return nodeType[type][postorder];
    }
    
    public boolean[] getNodeTypeArray(int type) {
        return nodeType[type];
    }
    
    public int getInfo(int infoCode, int nodesPostorder) {
        return info[infoCode][nodesPostorder];
    }
    
    public int[] getInfoArray(int infoCode) {
        return info[infoCode];
    }
    
    public int[] getNodeRelSubtrees(int pathType, int nodePostorder) {
        return relSubtrees[pathType][nodePostorder];
    }
    
    public int[] getPath(int pathType) {
        return paths[pathType];
    }

    public int getCurrentNode() {
        return currentNode;
    }

    public void setCurrentNode(int postorder) {
        currentNode = postorder;
    }
    
    private int gatherInfo(List<TreeNode> aT, int postorder) {
          return gatherInfo(aT.get(aT.size() - 1), postorder);
    }

    private int gatherInfo(TreeNode aT, int postorder) {
        int currentSize = 0;
        int childrenCount = 0;
        int descSizes = 0;
        int krSizesSum = 0;
        int revkrSizesSum = 0;
        int preorder = preorderTmp;
        
        int heavyChild = -1;
        int leftChild = -1;
        int rightChild = -1;
        int weight = -1;
        int maxWeight = -1;
        int currentPostorder = -1;
        int oldHeavyChild = -1;

        ArrayList heavyRelSubtreesTmp = new ArrayList();
        ArrayList leftRelSubtreesTmp = new ArrayList();
        ArrayList rightRelSubtreesTmp = new ArrayList();
        
        ArrayList<Integer> childrenPostorders = new ArrayList<Integer>();

        preorderTmp++;

        // enumerate over children of current node
        for (Iterator<TreeNode> e = aT.getChildren().iterator(); e.hasNext();) {
            childrenCount++;

            postorder = gatherInfo(e.next(), postorder);
            childrenPostorders.add(postorder);
            currentPostorder = postorder;

            // heavy path
            weight = sizeTmp+1;
            if (weight >= maxWeight) {
                maxWeight = weight;
                oldHeavyChild = heavyChild;
                heavyChild = currentPostorder;
            } else {
                heavyRelSubtreesTmp.add(currentPostorder);
            }
            if (oldHeavyChild != -1) {
                heavyRelSubtreesTmp.add(oldHeavyChild);
                oldHeavyChild = -1;
            }

            // left path
            if (childrenCount == 1) {
                leftChild = currentPostorder;
            } else {
                leftRelSubtreesTmp.add(currentPostorder);
            }

            // right path
            rightChild = currentPostorder;
            if (e.hasNext()) {
                rightRelSubtreesTmp.add(currentPostorder);
            }

            // subtree size
            currentSize += 1 + sizeTmp;

            descSizes += descSizesTmp;

            if (childrenCount > 1) {
                krSizesSum += krSizesSumTmp + sizeTmp+1;
            } else {
                krSizesSum += krSizesSumTmp;
                nodeType[LEFT][currentPostorder] = true;
            }

            if (e.hasNext()) {
                revkrSizesSum += revkrSizesSumTmp + sizeTmp + 1;
            } else {
                revkrSizesSum += revkrSizesSumTmp;
                nodeType[RIGHT][currentPostorder] = true;
            }
        }

        postorder++;

        int currentDescSizes = descSizes + currentSize + 1;
        info[POST2_DESC_SUM][postorder] = (currentSize+1)*(currentSize+1+3)/2-currentDescSizes;
        info[POST2_KR_SUM][postorder] = krSizesSum + currentSize+1;
        info[POST2_REV_KR_SUM][postorder] = revkrSizesSum + currentSize+1;

        // POST2_LABEL
        info[POST2_LABEL][postorder] = map.store(aT);
        
        // POST2_PARENT
        for (Integer i : childrenPostorders) {
            info[POST2_PARENT][i] = postorder;
        }
        
        // POST2_SIZE
        info[POST2_SIZE][postorder] = currentSize+1;
        if (currentSize == 0) {
            leafCount++;
        }

        // POST2_PRE
        info[POST2_PRE][postorder] = preorder;
        
        // PRE2_POST
        info[PRE2_POST][preorder] = postorder;
        
        // RPOST2_POST
        info[RPOST2_POST][treeSize-1-preorder] = postorder;

        // heavy path
        if (heavyChild != -1) {
            paths[HEAVY][postorder] = heavyChild;
            nodeType[HEAVY][heavyChild] = true;

            if (leftChild < heavyChild && heavyChild < rightChild) {
                info[POST2_STRATEGY][postorder] = BOTH;
            } else if (heavyChild == leftChild) {
                info[POST2_STRATEGY][postorder] = RIGHT;
            } else if (heavyChild == rightChild) {
                info[POST2_STRATEGY][postorder] = LEFT;
            }
        } else {
            info[POST2_STRATEGY][postorder] = RIGHT;
        }
        
        // left path
        if (leftChild != -1) {
            paths[LEFT][postorder] = leftChild;
        }
        // right path
        if (rightChild != -1) {
            paths[RIGHT][postorder] = rightChild;
        }

        // heavy/left/right relevant subtrees
        relSubtrees[HEAVY][postorder] = toIntArray(heavyRelSubtreesTmp);
        relSubtrees[RIGHT][postorder] = toIntArray(rightRelSubtreesTmp);
        relSubtrees[LEFT][postorder] = toIntArray(leftRelSubtreesTmp);

        descSizesTmp = currentDescSizes;
        sizeTmp = currentSize;
        krSizesSumTmp = krSizesSum;
        revkrSizesSumTmp = revkrSizesSum;

        return postorder;
    }
    
    private void postTraversalProcessing() {
        int nc1 = treeSize;
        info[KR] = new int[leafCount];
        info[RKR] = new int[leafCount];

        int nc = nc1;
        int lc = leafCount;
        int i = 0;
        
        // compute left-most leaf descendants
        // go along the left-most path, remember each node and assign to it the path's leaf
        // compute right-most leaf descendants (in reversed postorder)
        for (i = 0; i < treeSize; i++) {
            if (paths[LEFT][i] == -1) {
                info[POST2_LLD][i] = i;
            } else {
                info[POST2_LLD][i] = info[POST2_LLD][paths[LEFT][i]];
            }
            if (paths[RIGHT][i] == -1) {
                info[RPOST2_RLD][treeSize-1-info[POST2_PRE][i]] = (treeSize-1-info[POST2_PRE][i]);
            } else {
                info[RPOST2_RLD][treeSize-1-info[POST2_PRE][i]] = info[RPOST2_RLD][treeSize-1-info[POST2_PRE][paths[RIGHT][i]]];
            }
        }
                
        // compute key root nodes
        // compute reversed key root nodes (in revrsed postorder)
        boolean[] visited = new boolean[nc];
        boolean[] visitedR = new boolean[nc];
        Arrays.fill(visited, false);
        int k = lc - 1;
        int kR = lc - 1;
        for (i = nc - 1; i >= 0; i--) {
            if (!visited[info[POST2_LLD][i]]) {
                info[KR][k] = i;
                visited[info[POST2_LLD][i]] = true;
                k--;
            }
            if (!visitedR[info[RPOST2_RLD][i]]) {
                info[RKR][kR] = i;
                visitedR[info[RPOST2_RLD][i]] = true;
                kR--;
            }
        }
        
        // compute minimal key roots for every subtree
        // compute minimal reversed  key roots for every subtree (in reversed postorder)
        int parent = -1;
        int parentR = -1;
        for (i = 0; i < leafCount; i++) {
            parent = info[KR][i];
            while (parent > -1 && info[POST2_MIN_KR][parent] == -1) {
                info[POST2_MIN_KR][parent] = i;
                parent = info[POST2_PARENT][parent];
            }
            parentR = info[RKR][i];
            while (parentR > -1 && info[RPOST2_MIN_RKR][parentR] == -1) {
                info[RPOST2_MIN_RKR][parentR] = i;
                parentR = info[POST2_PARENT][info[RPOST2_POST][parentR]]; // get parent's postorder
                if (parentR > -1) {
                    parentR = treeSize - 1 - info[POST2_PRE][parentR]; // if parent exists get its rev. postorder
                }
            }
        }
    }
    
    public static int[] toIntArray(List<Integer> integers) {
        int[] ints = new int[integers.size()];
        int i = 0;
        for (Integer n : integers) {
            ints[i++] = n;
        }
        return ints;
    }

    public void setSwitched(boolean value) {
        switched = value;
    }
    public boolean isSwitched() {
        return switched;
    }
}