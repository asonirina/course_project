package by.bsu.project.antlr.util;

import org.apache.commons.lang.StringUtils;

/**
 * User: iason
 * Date: 02.02.15
 */
public class LevensteinDistanceHelper {
    public static int distance(String s1[], String s2[]) {
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
                    int cost = measure(s1[i - 1], s2[j - 1]);
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

    private static int measure(String a, String b) {
        if (!a.equals(b)) {
            return 1;
        }
        return 0;
    }

    public static void main(String[] args) {
        String s1 = "while ";
        String s2 = "for  ";
        System.out.println(1 - Math.exp(-0.2*distance(
                StringUtils.split(s1),
                StringUtils.split(s2))));
    }
}
