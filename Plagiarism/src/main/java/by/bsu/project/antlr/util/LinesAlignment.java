package by.bsu.project.antlr.util;

import org.apache.commons.lang.math.NumberUtils;

import java.util.List;

/**
 * User: iason
 * Date: 27.01.15
 */
public class LinesAlignment {
    private static final int m = 1;
    private static final int d = -1;
    private static final int g = -2;

    private String m1[];
    private String m2[];

    public LinesAlignment(String[] m1, String[] m2) {
        this.m1 = m1;
        this.m2 = m2;
    }

    public LinesAlignment(List<String> m1, List<String>m2) {
        this.m1 = m1.toArray(new String[m1.size()]);
        this.m2 = m1.toArray(new String[m2.size()]);
    }

    private static int score (String s1, String s2) {
        if(s1.equals(s2)) return m;
        else return d;
    }

    private int D(int i, int j) {
        if (i == 0) return 0;
        if (j == 0) return 0;
        return NumberUtils.max(new int[]{D(i - 1, j - 1) + score(m1[i], m2[j]),
                D(i - 1, j) + g,
                D(i, j - 1) + g,
                0});
    }

    public int diff() {
        return D(m1.length - 1, m2.length - 1);
    }
}
