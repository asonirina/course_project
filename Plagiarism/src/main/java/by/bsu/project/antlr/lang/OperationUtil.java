package by.bsu.project.antlr.lang;

import by.bsu.project.general.lang.LangWrap.Operation;
import by.bsu.project.general.lang.LangWrap.Lang;
import org.antlr.runtime.tree.CommonTree;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.apache.log4j.Logger;

import java.util.Properties;

/**
 * User: iason
 * Date: 29.01.15
 */
public class OperationUtil {
    private static final Logger logger = Logger.getLogger(OperationUtil.class);

    static Operation matrix[][] = new Operation[Lang.values().length][200];

    static {
      init();
    }

    public static void init() {
        try {
            for (Lang lang : Lang.values()) {
                PropertiesConfiguration config = new PropertiesConfiguration(lang.name().toLowerCase() + ".properties");
                for (Operation op : Operation.values()) {
                    String code = config.getString(op.name());
                    if (code != null) {
                        put(op, Integer.valueOf(code), lang);
                    }
                }
            }
        } catch (Exception ex) {
            logger.error(ex.getMessage());
        }
    }

    private static Operation get(Lang lang, int code) {
        if (matrix[lang.id][code] == null) return Operation.NULL;
        return matrix[lang.id][code];
    }

    public static Operation get(Lang lang, CommonTree t) {
        return get(lang, t.getType());
    }

    private static void put(Operation operation1, int code, Lang lang) {
        matrix[lang.id][code] = operation1;
    }
}
