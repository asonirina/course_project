package by.bsu.project.utils;

import by.bsu.project.antlr.lang.LangFactory;
import by.bsu.project.antlr.tree.BaseParser;
import by.bsu.project.general.model.ProgramFilesEntity;
import org.antlr.runtime.CommonToken;
import org.apache.commons.lang.StringUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * User: iason
 * Date: 29.10.15
 */
public class CodeDiffUtil {
    private enum Order {
        DIRECT(4, 5, "#99EBC2"), REVERSE(5, 4, "#FF9999");
        private int i1;
        private int i2;
        private String color;

        private Order(int i1, int i2, String color) {
            this.i1 = i1;
            this.i2 = i2;
            this.color = color;
        }
    }

    public static String[] getHighlights(ProgramFilesEntity e1, ProgramFilesEntity e2, List<int[]> byteMap) {
        List<CompareIndex> indexes = new ArrayList<>();
        for (int i = 0; i < byteMap.size(); i++) {
            indexes.add(new CompareIndex(i, byteMap.get(i)));
        }


        String res[] = new String[2];
        res[0] = getTaggedString(e1, indexes,Order.DIRECT);
        res[1] = getTaggedString(e2, indexes, Order.REVERSE);
        return res;
    }

    public static String getTaggedString(ProgramFilesEntity e, List<CompareIndex> indexes,  Order o) {
        try {
            BaseParser parser = LangFactory.createParser(e.getLang());
            String tokens[] = parser.getTokens(e.getFile());

            for (CompareIndex index : indexes) {
                int arr[] = index.getIndexes();
                if (arr[o.i1] >= 0) {
                    if (arr[o.i2] == -1) {
                        tokens[arr[o.i1]] = String.format("<span style='background-color:%s;'>%s</span>", o.color, tokens[arr[o.i1]]);
                    } else if (arr[o.i2] > 0) {
                        tokens[arr[o.i1]] = String.format("<a onmouseout='returnBack(%d)' onmousemove='highlightMatches(%d)' name='%d'><span style='background-color:#FFFFB2;'>%s</span></a>",
                                index.getId(), index.getId(), index.getId(), tokens[arr[o.i1]]);
                    }
                } else {
                  //  break;
                }
            }

            return StringUtils.join(tokens);
        } catch (Exception ex) {
            return "";
        }
    }


}
