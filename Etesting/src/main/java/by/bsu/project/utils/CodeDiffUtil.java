package by.bsu.project.utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * User: iason
 * Date: 29.10.15
 */
public class CodeDiffUtil {
    private enum Order {
        DIRECT(0, 2, "#99EBC2"), REVERSE(2, 0, "#FF9999");
        private int i1;
        private int i2;
        private String color;

        private Order(int i1, int i2, String color) {
            this.i1 = i1;
            this.i2 = i2;
            this.color = color;
        }
    }

    public static String[] getHighlights(byte b1[], byte b2[], List<int[]> byteMap) {
        String res[] = new String[2];

        List<CompareIndex> indexes = new ArrayList<>();
        for (int i = 0; i < byteMap.size(); i++) {
            indexes.add(new CompareIndex(i, byteMap.get(i)));
        }
        Collections.sort(indexes, new CompareMapComparator(Order.DIRECT.i1));
        res[0] = getHighlightedString(b1, indexes, Order.DIRECT);

        Collections.sort(indexes, new CompareMapComparator(Order.REVERSE.i1));
        res[1] = getHighlightedString(b2, indexes, Order.REVERSE);

        return res;
    }

    private static String getHighlightedString(byte bytes[], List<CompareIndex> indexes, Order o) {
        String file = new String(bytes);
        for (CompareIndex index : indexes) {
            int arr[] = index.getIndexes();
            if (arr[o.i1] > 0) {
                String before = file.substring(0, arr[o.i1]);
                String diff = file.substring(arr[o.i1], arr[o.i1 + 1] + 1);
                String after = file.substring(arr[o.i1 + 1] + 1);

                if (arr[o.i2] == -1) {
                    diff = String.format("<span style='background-color:%s;'>%s</span>", o.color, diff);
                } else if (arr[o.i2] > 0) {
                    diff = String.format("<a onmouseout='returnBack(%d)' onmousemove='highlightMatches(%d)' name='%d'><span style='background-color:#FFFFB2;'>%s</span></a>",
                            index.getId(), index.getId(), index.getId(), diff);
                }
                file = before + diff + after;
            } else {
                break;
            }
        }
        return file;
    }
}
