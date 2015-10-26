package by.bsu.project.general.lang;

/**
 * User: iason
 * Date: 29.01.15
 */
public class LangWrap {
    public enum Lang {
        JAVA(0), CPP(1), PASCAL(2);
        public int id;

        private Lang(int id) {
            this.id = id;
        }

        public int getId() {
            return id;
        }

        public String lang() {
            return name().toLowerCase();
        }
    }

    public static enum Type{
        NULL, ROOT, CLASS ,VAR , METHOD , JUMP, IDENT, ASSIGN,
        NUMBER_LITERAL, STRING_LITERAL , BOOL_LITERAL ,
        IF, ITERATION,
        METHOD_CALL, CONSTRUCTOR ,
        COMPARATOR, MATH_OPERATOR, TYPE
    }

    public static enum Operation {
        NULL, //empty
        ROOT(Type.ROOT),
        IDENT(Type.IDENT),
        CLASS_DECL(Type.CLASS),    //java, cpp
        SIMPLE_DECL, CLASS_NAME,  //cpp
        CLASS_CONTENT,
        VAR_DECLARATION(Type.VAR), VAR_DECLARATOR_LIST, VAR_DECLARATOR,
        FUNCTION_NAME, //cpp
        VAR,  //pascal
        TYPE, //cpp
        TYPE_NAME,
        NAME,
        FORMAL_PARAM_LIST,
        BLOCK_SCOPE,
        RETURN(Type.JUMP), JUMP_STATEMENT(Type.JUMP),
        RETURN_TYPE,
        FUNCTION_METHOD_DECL(Type.METHOD),    //java, cpp
        VOID_METHOD_DECL(Type.METHOD), //java
        FORMAL_PARAM_STD_DECL,
        PROCEDURE(Type.METHOD) ,     //pascal
        INT(Type.TYPE), CHAR(Type.TYPE), DOUBLE(Type.TYPE), BOOLEAN(Type.TYPE), FLOAT(Type.TYPE), STRING(Type.TYPE),
        QUALIFIED_TYPE_IDENT(Type.TYPE),
        ARRAY(Type.TYPE), //cpp
        EXPR, EXPR_STATEMENT,
        INIT,  //cpp
        ASSIGN(Type.ASSIGN) ,
        DECIMAL_LITERAL(Type.NUMBER_LITERAL), FLOATING_POINT_LITERAL(Type.NUMBER_LITERAL),
        STRING_LITERAL(Type.STRING_LITERAL), CHARACTER_LITERAL(Type.STRING_LITERAL),
        TRUE(Type.BOOL_LITERAL), FALSE(Type.BOOL_LITERAL) ,
        PLUS(Type.MATH_OPERATOR), MINUS(Type.MATH_OPERATOR) ,
        EQUAL(Type.COMPARATOR), NOT_EQUAL(Type.COMPARATOR),
        LOGICAL_AND(Type.COMPARATOR),
        POST_INC(Type.MATH_OPERATOR), POST_DEC(Type.MATH_OPERATOR),
        LESS_THAN(Type.COMPARATOR), GREATER_THAN(Type.COMPARATOR),
        CLASS_CONSTRUCTOR_CALL(Type.CONSTRUCTOR), NEW,
        LVAL, RVAL, FIELD,
        METHOD_CALL(Type.METHOD_CALL), ARGUMENT_LIST, DOT,
        CALLEE, ARGUMENT, //cpp
        CONDITION,
        PARENTESIZED_EXPR,
        IF(Type.IF), WHILE(Type.ITERATION), FOR(Type.ITERATION),
        FOR_INIT, FOR_UPDATE,FOR_CONDITION,
        ITERATION,
        TO;

        private Type type;

        private Operation() {
            this.type = Type.NULL;
        }

        private Operation(Type type) {
            this.type = type;
        }

        public Type getType() {
            return type;
        }
    }
}
