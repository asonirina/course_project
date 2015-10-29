package by.bsu.project.utils;

/**
 * User: iason
 * Date: 29.10.15
 */
public class CompareIndex {
    private int id;
    private int[] indexes;

    CompareIndex(int id, int[] indexes) {
        this.id = id;
        this.indexes = indexes;
    }

    public int getId() {
        return id;
    }

    public int[] getIndexes() {
        return indexes;
    }
}
