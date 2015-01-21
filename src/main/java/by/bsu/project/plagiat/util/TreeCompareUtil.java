package by.bsu.project.plagiat.util;

import by.bsu.project.CustomComparator;
import by.bsu.project.entity.ProgramFilesEntity;
import by.bsu.project.huffman.Huffman;
import by.bsu.project.plagiat.model.TreeHelper;
import by.bsu.project.plagiat.model.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * User: iason
 * Date: 10.05.14
 */
public class TreeCompareUtil {
    public static int checkTrees(List<ProgramFilesEntity> programs, List<TreeNode> tree) {
        String source[] = getTokenizedString(tree);
        int max = 0;
        for (ProgramFilesEntity entity : programs) {
            TreeHelper builder = new TreeHelper(String.valueOf(entity.getId()));
            List<TreeNode> nodes = builder.getTree(Huffman.expand(entity.getFile()));
            String arr[] = getTokenizedString(nodes);
            int sim = (int) (100 * Math.exp(- Math.pow(DLevenstein(source, arr), 2) / (source.length * arr.length)));
            if (max < sim) {
                max = sim;
            }
        }

        return max;
    }

    private static String[] getTokenizedString(List<TreeNode> list) {
        List<String> res = new ArrayList<>();
        Collections.sort(list, new CustomComparator());
        for (TreeNode node : list) {
            if (node.getOperation() != null) {
                res.add(node.getOperation());
            }
        }

        return res.toArray(new String[res.size()]);
    }


    private static int m(String a, String b) {
        if (!a.equals(b)) {
            return 1;
        }

        return 0;
    }
//
//    public static void main(String[] args) {
//        String arr1[] = new String[]{"a", "b", "c", "g", "r", "y", "u", "i"};
//        String arr2[] = new String[]{"s", "b", "c", "j", "g", "r", "y", "u", "i"};
//        System.out.println((int) (100 * Math.exp(-4 * Math.pow(DLevenstein(arr1, arr2), 2) / (arr1.length * arr2.length))));
//    }

    private static int DLevenstein(String s1[], String s2[]) {
        int m = s1.length, n = s2.length;
        int[] d1;
        int[] d2 = new int[n + 1];

        for (int i = 0; i <= n; i++)
            d2[i] = i;

        for (int i = 1; i <= m; i++) {
            d1 = d2;
            d2 = new int[n + 1];
            for (int j = 0; j <= n; j++) {
                if (j == 0) d2[j] = i;
                else {
                    int cost = m(s1[i - 1], s2[j - 1]);
                    if (d2[j - 1] < d1[j] && d2[j - 1] < d1[j - 1] + cost)
                        d2[j] = d2[j - 1] + 1;
                    else if (d1[j] < d1[j - 1] + cost)
                        d2[j] = d1[j] + 1;
                    else
                        d2[j] = d1[j - 1] + cost;
                }
            }
        }
        return d2[n];
    }
}
