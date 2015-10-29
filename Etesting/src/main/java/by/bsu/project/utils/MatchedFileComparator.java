package by.bsu.project.utils;

import java.util.Comparator;

/**
 * User: iason
 * Date: 29.10.15
 */
public class MatchedFileComparator implements Comparator<int[]> {
    @Override
    public int compare(int[] list1, int[] list2) {
        return list2[2] - list1[2];
    }
}
