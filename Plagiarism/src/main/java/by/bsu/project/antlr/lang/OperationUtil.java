package by.bsu.project.antlr.lang;

import by.bsu.project.antlr.lang.LangWrap.Operation1;
import by.bsu.project.antlr.lang.LangWrap.Lang;

import static by.bsu.project.antlr.lang.LangWrap.Lang.JAVA;
import static by.bsu.project.antlr.lang.LangWrap.Operation1.DECIMAL_LITERAL;
import static by.bsu.project.antlr.lang.LangWrap.Operation1.IDENT;

/**
 * User: iason
 * Date: 29.01.15
 */
public class OperationUtil {

    static Operation1 matrix[][] = new Operation1[Lang.values().length][200];

    static {
        put(DECIMAL_LITERAL, 167, JAVA);
        put(IDENT, 164, JAVA);
    }

    public static Operation1 get(Lang lang, int code) {
        if (matrix[lang.id][code] == null) return Operation1.NULL;
        return matrix[lang.id][code];
    }

    private static void put(Operation1 operation1, int code, Lang lang) {
        matrix[lang.id][code] = operation1;
    }
}
