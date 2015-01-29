package by.bsu.project.antlr.lang;

/**
 * User: iason
 * Date: 29.01.15
 */
public class LangWrap {
    public enum Lang {
        JAVA(0), CPP(1), PASCAL(2);
        int id;

        private Lang(int id) {
            this.id = id;
        }

        public int getId() {
            return id;
        }
    }


    public static enum Operation1 {
        NULL,
        DECIMAL_LITERAL,
        IDENT
    }
}
