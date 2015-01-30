package by.bsu.project.antlr.lang;

import by.bsu.project.antlr.lang.LangWrap.Operation1;
import by.bsu.project.antlr.lang.LangWrap.Lang;
import org.apache.log4j.Logger;

import java.io.FileInputStream;
import java.util.Properties;

/**
 * User: iason
 * Date: 29.01.15
 */
public class OperationUtil {
    private static final Logger logger = Logger.getLogger(OperationUtil.class);

    static Operation1 matrix[][] = new Operation1[Lang.values().length][200];

    static {
        try {

            for (Lang lang : Lang.values()) {
                Properties props = new Properties();
                props.load(ClassLoader.getSystemResourceAsStream(lang.name().toLowerCase() + ".properties"));
                for (Operation1 op : Operation1.values()) {
                    String code = props.getProperty(op.name());
                    if (code != null) {
                        put(op, Integer.valueOf(code), lang);
                    }
                }
            }
        } catch (Exception ex) {
            logger.error(ex.getMessage());
        }
    }

    public static Operation1 get(Lang lang, int code) {
        if (matrix[lang.id][code] == null) return Operation1.NULL;
        return matrix[lang.id][code];
    }

    private static void put(Operation1 operation1, int code, Lang lang) {
        matrix[lang.id][code] = operation1;
    }
}
