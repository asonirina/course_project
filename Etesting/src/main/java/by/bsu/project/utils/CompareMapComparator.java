package by.bsu.project.utils;

import java.util.Comparator;

/**
 * User: iason
 * Date: 29.10.15
 */
public class CompareMapComparator implements Comparator<CompareIndex> {

    private int index;

    public CompareMapComparator(int index) {
        this.index = index;
    }
    @Override
    public int compare(CompareIndex i1, CompareIndex i2) {
        return i2.getIndexes()[index] - i1.getIndexes()[index];
    }


}
