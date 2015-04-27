package by.bsu.project.antlr.util;

import java.util.List;

/**
 * User: iason
 * Date: 27.01.15
 */
public class LinesAlignment {
    private static final int cost = 1;

    public static int diff(List<String> m1, List<String>m2) {
        int diffCount = DLevenstein(m1.toArray(new String[m1.size()]), m2.toArray(new String[m2.size()]));
        return (int)(100* Math.exp(-diffCount));
    }

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

    private static int m(String a, String b) {
        if (!a.equals(b)) {
            return 1;
        }
        return 0;
    }
}
