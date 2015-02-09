package by.bsu.project.antlr.util;

import by.bsu.project.antlr.model.NodeDistance;
import by.bsu.project.antlr.model.TreeNode;
import org.apache.commons.lang.math.NumberUtils;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * User: iason
 * Date: 27.01.15
 */
public class TreeEditDistance {
    NodeDistance nd;
    List<TreeNode> t1;
    List<TreeNode> t2;
    private static int data = -1;

    private static void walkTreeLeft(TreeNode node) {
        for (TreeNode tn : node.getChildren())
            walkTreeLeft(tn);
        node.setI(data++);
    }

    public static void numerateTree(TreeNode node) {
        data = 0;
        walkTreeLeft(node);
    }

    public TreeEditDistance(NodeDistance nd, List<TreeNode> t1, List<TreeNode> t2) {
        this.nd = nd;
        this.t1 = t1;
        this.t2 = t2;
        numerateTree(this.t1.get(0));
        numerateTree(this.t2.get(0));
        Collections.sort(this.t1, new OrderComparator());
        Collections.sort(this.t2, new OrderComparator());
    }

    public double calculate() {
        double [][] td = new double[t1.size()][t2.size()];
        double [][] fd = new double[t1.size()][t2.size()];
        int[] L1 = lmld(t1.get(t1.size() - 1), new int[t1.size()]);
        int[] L2 = lmld(t2.get(t2.size() - 1), new int[t2.size()]);
        int KR1[] = kr(L1, getCountLeaves(t1));
        int KR2[] = kr(L2, getCountLeaves(t2));
        for (int i = 0; i<L1.length; i++) {
            L1[i]++;
        }
        for (int i = 0; i<L2.length; i++) {
            L2[i]++;
        }
        for (int s = 0; s < KR1.length; s++) {
            for (int t = 0; t < KR2.length; t++) {
                forestDist(KR1[s], KR2[t], L1, L2, t1.toArray(new TreeNode[0]), t2.toArray(new TreeNode[0]), td, fd);
            }
        }
        return td[t1.size() - 1][t2.size() - 1];
    }

    private void forestDist(int i, int j, int[] li, int[] lj, TreeNode[] nodes1, TreeNode[] nodes2, double [][] td, double [][] fd) {
        fd[li[i] - 1][lj[j] - 1] = 0;
        for (int di = li[i]; di <= i; di++)
            fd[di][lj[j] - 1] = fd[di - 1][lj[j] - 1] + nd.delete(nodes1[di], nodes2[lj[j] - 1]);
        for (int dj = lj[j]; dj <= j; dj++)
            fd[li[i] - 1][dj] =
                    fd[li[i] - 1][dj - 1] + nd.insert(nodes1[li[i] - 1], nodes2[dj]);
        for (int di = li[i]; di <= i; di++) {
            for (int dj = lj[j]; dj <= j; dj++) {
                if (li[di] == li[i] && lj[dj] == lj[j]) {
                    fd[di][dj] =
                            NumberUtils.min(new double[]{fd[di - 1][dj] + nd.delete(nodes1[di], nodes2[dj]),
                                    fd[di][dj - 1] + nd.insert(nodes1[di], nodes2[dj]),
                                    fd[di - 1][dj - 1] + nd.rename(nodes1[di], nodes2[dj])

                            });
                    td[di][dj] = fd[di][dj];
                } else fd[di][dj] =
                        NumberUtils.min(new double[]{fd[di - 1][dj] + nd.delete(nodes1[di], nodes2[dj]),
                                fd[di][dj - 1] + nd.insert(nodes1[di], nodes2[dj]),
                                fd[li[di] - 1][lj[dj] - 1] + td[di][dj]

                        });
            }
        }
    }

    private static int[] lmld(TreeNode v, int[] l) {
        for (TreeNode c : v.getChildren()) {
            l = lmld(c, l);
        }
        if (v.isLeaf()) {
            l[v.getI()] = v.getI();
        } else {
            TreeNode c1 = v.getChildren().get(0);
            l[v.getI()] = l[c1.getI()];
        }
        return l;
    }

    private static int[] kr(int[] l, int lc) {
        int kr[] = new int[lc];
        boolean visited[] = new boolean[l.length];
        for (boolean b : visited) {
            b = false;
        }
        int k = kr.length - 1;
        int i = l.length - 1;
        while (k >= 0) {
            if (!visited[l[i]]) {
                kr[k--] = i;
                visited[l[i]] = true;
            }
            i--;
        }
        Arrays.sort(kr);
        return kr;
    }

    private static int getCountLeaves(List<TreeNode> nodes) {
        int res = 0;
        for (TreeNode node : nodes) {
            if (node.isLeaf()) {
                res++;
            }
        }
        return res;
    }
}
