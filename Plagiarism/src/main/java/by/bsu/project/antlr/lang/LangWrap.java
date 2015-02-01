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
        IDENT,
        CLASS_DECL,    //java, cpp
        SIMPLE_DECL, CLASS_NAME,  //cpp
        CLASS_CONTENT,
        VAR_DECLARATION, VAR_DECLARATOR_LIST, VAR_DECLARATOR,
        FUNCTION_NAME, //cpp
        VAR,  //pascal
        TYPE, //cpp
        TYPE_NAME,
        NAME,
        FORMAL_PARAM_LIST,
        BLOCK_SCOPE,
        RETURN_TYPE,
        FUNCTION_METHOD_DECL,    //java, cpp
        VOID_METHOD_DECL, //java
        FORMAL_PARAM_STD_DECL,
        PROCEDURE ,     //pascal
        INT, CHAR, DOUBLE, BOOLEAN, FLOAT, STRING,
        ARRAY, //cpp
        EXPR, EXPR_STATEMENT,
        INIT,  //cpp
        ASSIGN ,
        DECIMAL_LITERAL, STRING_LITERAL, CHARACTER_LITERAL, FLOATING_POINT_LITERAL,
        TRUE, FALSE ,
        PLUS, MINUS ,
        EQUAL, NOT_EQUAL,
        LOGICAL_AND,
        LESS_THAN, GREATER_THAN  ,
        CLASS_CONSTRUCTOR_CALL,
        LVAL, RVAL , FIELD
    }
}
