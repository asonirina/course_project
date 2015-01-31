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
        NULL, //empty
        ROOT,
        DECIMAL_LITERAL,
        IDENT,
        CLASS_DECL,    //java, cpp
        SIMPLE_DECL,  //cpp
        CLASS_NAME,  //cpp
        CLASS_CONTENT,
        VAR_DECLARATION,
        VAR_DECLARATOR_LIST,
        VAR_DECLARATOR,
        VAR,  //pascal
        TYPE, //cpp
        TYPE_NAME,
        NAME
    }
}