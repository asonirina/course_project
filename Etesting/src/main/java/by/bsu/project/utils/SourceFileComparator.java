package by.bsu.project.utils;

import java.util.Comparator;
import java.util.List;

/**
 * User: iason
 * Date: 29.10.15
 */
public class SourceFileComparator implements Comparator<int[]> {
    @Override
    public int compare(int[] list1, int[] list2) {
        return list2[0] - list1[0];
    }
}
