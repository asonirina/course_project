package by.bsu.project.javacc.parser.pascal;

import by.bsu.project.javacc.general.ParseException;
import by.bsu.project.javacc.general.SimpleCharStream;
import by.bsu.project.javacc.model.Token;

import java.io.*;
import java.util.List;
import java.util.Vector;

public class JPascal implements JPascalConstants {
     public List<String> getNodes() {
         return token_source.getNodes();
     }

    Vector identifiers = new Vector();

    Vector procedures = new Vector();

     int lineNo = 1;

    public static void main(String args[]) throws Exception {
        JPascal parser;
        parser = new JPascal(new ByteArrayInputStream("program p1; begin end.".getBytes()));
        parser.Program();
    }

    public void generateReport(JPascal parser) {
        Token token;
        try {
            for (; ; ) {
                token = parser.getNextToken();
                out(String.format("line:%03d-%03d column:%03d-%03d kind:%-15s lexeme:%-50s",
                        token.beginLine, token.endLine, token.beginColumn, token.endColumn, kindOf(token), token.image));
                if (kindOf(token).equals("<EOF>")) {
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void out(String message) {
    }

    public void err(String message) {
        System.err.println(message);
    }

    public String kindOf(Token token) {
        return JPascalConstants.tokenImage[token.kind];
    }

    public void Program() throws ParseException {

        Token program = null;
        if (jj_2_2(2)) {
            jj_consume_token(PROGRAM);
            program = identifier();
            if (jj_2_1(2)) {
                jj_consume_token(LPAREN);
                identifier_list();
                jj_consume_token(RPAREN);
            } else {
                ;
            }
            jj_consume_token(SEMICOLON);
            block();
            jj_consume_token(DOT);
        } else if (jj_2_3(2)) {
            jj_consume_token(0);
            if (program != null) {
                out("program: " + program.image);
            } else {
                out("eof");
                out(String.format("errors"));
                out(String.format("%d tokens presents in table", identifiers.size()));
                System.exit(0);
            }
        } else {
            jj_consume_token(-1);
            throw new ParseException();
        }
    }

    public void block() throws ParseException {
        label_1:
        while (true) {
            if (jj_2_4(2)) {
                ;
            } else {
                break label_1;
            }
            parts();
        }
        compound_statement();
        out("block");
    }

    public void parts() throws ParseException {
        if (jj_2_5(2)) {
            label_declaration_part();
        } else if (jj_2_6(2)) {
            const_declaration_part();
        } else if (jj_2_7(2)) {
            type_declaration_part();
        } else if (jj_2_8(2)) {
            var_declaration_part();
        } else if (jj_2_9(2)) {
            subroutine_declaration_part();
        } else {
            jj_consume_token(-1);
            throw new ParseException();
        }
    }

    public void label_declaration_part() throws ParseException {
        jj_consume_token(LABEL);
        jj_consume_token(NUMBER);
        label_2:
        while (true) {
            if (jj_2_10(2)) {
                ;
            } else {
                break label_2;
            }
            jj_consume_token(COMMA);
            jj_consume_token(NUMBER);
        }
        jj_consume_token(SEMICOLON);
        out("label_declaration_part");
    }

    public void const_declaration_part() throws ParseException {
        jj_consume_token(CONST);
        const_definition();
        label_3:
        while (true) {
            if (jj_2_11(2)) {
                ;
            } else {
                break label_3;
            }
            jj_consume_token(SEMICOLON);
            const_definition();
        }
        jj_consume_token(SEMICOLON);
        out("const_declaration_part");
    }

    public void const_definition() throws ParseException {
        identifier();
        jj_consume_token(EQ);
        _const();
        out("const_definition");
    }

    public void type_declaration_part() throws ParseException {
        jj_consume_token(TYPE);
        type_definition();
        label_4:
        while (true) {
            if (jj_2_12(2)) {
                ;
            } else {
                break label_4;
            }
            jj_consume_token(SEMICOLON);
            type_definition();
        }
        jj_consume_token(SEMICOLON);
        out("type_declaration_part");
    }

    public void type_definition() throws ParseException {
        identifier();
        jj_consume_token(EQ);
        type();
        out("type_definition");
    }

    public void type() throws ParseException {
        if (jj_2_14(2)) {
            jj_consume_token(UPARROW);
            identifier();
        } else if (jj_2_15(2)) {
            identifier();
            jj_consume_token(LBRACKET);
            simple_type();
            label_5:
            while (true) {
                if (jj_2_13(2)) {
                    ;
                } else {
                    break label_5;
                }
                jj_consume_token(COMMA);
                simple_type();
            }
            jj_consume_token(RBRACKET);
            jj_consume_token(OF);
            identifier();
        } else if (jj_2_16(2)) {
            jj_consume_token(SETOF);
            simple_type();
        } else if (jj_2_17(2)) {
            jj_consume_token(RECORD);
            field_list();
            jj_consume_token(END);
        } else if (jj_2_18(2)) {
            simple_type();
            out("type");
        } else {
            jj_consume_token(-1);
            throw new ParseException();
        }
    }

    public void simple_type() throws ParseException {
        if (jj_2_20(2)) {
            identifier();
        } else if (jj_2_21(2)) {
            jj_consume_token(LPAREN);
            identifier();
            label_6:
            while (true) {
                if (jj_2_19(2)) {
                    ;
                } else {
                    break label_6;
                }
                jj_consume_token(COMMA);
                identifier();
            }
            jj_consume_token(RPAREN);
        } else if (jj_2_22(2)) {
            _const();
            jj_consume_token(DOTDOT);
            _const();
            out("simple_type");
        } else {
            jj_consume_token(-1);
            throw new ParseException();
        }
    }

    public void _const() throws ParseException {
        if (jj_2_26(2)) {
            jj_consume_token(STRING);
        } else if (jj_2_27(2)) {
            if (jj_2_25(2)) {
                if (jj_2_23(2)) {
                    jj_consume_token(PLUS);
                } else if (jj_2_24(2)) {
                    jj_consume_token(MINUS);
                } else {
                    jj_consume_token(-1);
                    throw new ParseException();
                }
            } else {
                ;
            }
            _const2();
            out("const");
        } else {
            jj_consume_token(-1);
            throw new ParseException();
        }
    }

    public void _const2() throws ParseException {
        if (jj_2_28(2)) {
            identifier();
        } else if (jj_2_29(2)) {
            jj_consume_token(NUMBER);
        } else {
            jj_consume_token(-1);
            throw new ParseException();
        }
    }

    public void field_list() throws ParseException {
        identifier_list();
        jj_consume_token(COLON);
        type();
        label_7:
        while (true) {
            if (jj_2_30(2)) {
                ;
            } else {
                break label_7;
            }
            jj_consume_token(SEMICOLON);
            identifier_list();
            jj_consume_token(COLON);
            type();
        }
        out("field_list");
    }

    public void var_declaration_part() throws ParseException {
        jj_consume_token(VAR);
        var_declaration();
        label_8:
        while (true) {
            if (jj_2_31(2)) {
                ;
            } else {
                break label_8;
            }
            jj_consume_token(SEMICOLON);
            var_declaration();
        }
        jj_consume_token(SEMICOLON);
        out("var_declaration_part");
    }

    public void var_declaration() throws ParseException {
        identifier_list();
        jj_consume_token(COLON);
        type();
        out("var_declaration");
    }

    public Vector identifier_list() throws ParseException {
        Vector identifier_list;
        identifier_list = new Vector();
        single_identifier(identifier_list);
        label_9:
        while (true) {
            if (jj_2_32(2)) {
                ;
            } else {
                break label_9;
            }
            jj_consume_token(COMMA);
            single_identifier(identifier_list);
        }
        out("identifier_list: " + identifier_list);
        {
            if ("" != null) return identifier_list;
        }
        throw new Error("Missing return statement in function");
    }

    public Token identifier() throws ParseException {
        Token identifier;
        identifier = jj_consume_token(IDENTIFIER);
        identifiers.add(identifier);
        {
            if ("" != null) return identifier;
        }
        throw new Error("Missing return statement in function");
    }

    public void single_identifier(Vector identifier_list) throws ParseException {
        Token identifier;
        identifier = identifier();
        if (identifier_list != null) {
            identifier_list.add(identifier);
        }
    }

    public void subroutine_declaration_part() throws ParseException {
        if (jj_2_35(2)) {
            procedure_declaration();
            if (jj_2_33(2)) {
                jj_consume_token(SEMICOLON);
            } else {
                ;
            }
        } else if (jj_2_36(2)) {
            function_declaration();
            if (jj_2_34(2)) {
                jj_consume_token(SEMICOLON);
            } else {
                ;
            }
            out("subroutine_declaration_part");
        } else {
            jj_consume_token(-1);
            throw new ParseException();
        }
    }

    public void procedure_declaration() throws ParseException {
        Token procedure;
        jj_consume_token(PROCEDURE);
        procedure = identifier();
        if (jj_2_37(2)) {
            formal_parameters();
        } else {
            ;
        }
        jj_consume_token(SEMICOLON);
        block();
        out("procedure_declaration: " + procedure);
        procedures.add(procedure);
    }

    public void function_declaration() throws ParseException {
        Token function;
        jj_consume_token(FUNCTION);
        function = identifier();
        if (jj_2_38(2)) {
            formal_parameters();
        } else {
            ;
        }
        jj_consume_token(COLON);
        if (jj_2_39(2)) {
            identifier();
        } else {
            ;
        }
        identifier();
        jj_consume_token(SEMICOLON);
        block();
        out("function_declaration: " + function);
        procedures.add(function);
    }

    public void formal_parameters() throws ParseException {
        jj_consume_token(LPAREN);
        param_section();
        label_10:
        while (true) {
            if (jj_2_40(2)) {
                ;
            } else {
                break label_10;
            }
            jj_consume_token(SEMICOLON);
            param_section();
        }
        jj_consume_token(RPAREN);
        out("formal_parameters");
    }

    public void param_section() throws ParseException {
        if (jj_2_42(2)) {
            if (jj_2_41(2)) {
                jj_consume_token(VAR);
            } else {
                ;
            }
            identifier_list();
            jj_consume_token(COLON);
            type();
        } else if (jj_2_43(2)) {
            jj_consume_token(FUNCTION);
            identifier_list();
            jj_consume_token(COLON);
            type();
        } else if (jj_2_44(2)) {
            jj_consume_token(PROCEDURE);
            identifier_list();
            out("param_section");
        } else {
            jj_consume_token(-1);
            throw new ParseException();
        }
    }

    public void compound_statement() throws ParseException {
        jj_consume_token(BEGIN);
        labeled_statement();
        label_11:
        while (true) {
            if (jj_2_45(2)) {
                ;
            } else {
                break label_11;
            }
            jj_consume_token(SEMICOLON);
            labeled_statement();
        }
        jj_consume_token(END);
        out("compound_statement");
    }

    public void labeled_statement() throws ParseException {
        if (jj_2_46(2)) {
            jj_consume_token(NUMBER);
            jj_consume_token(COLON);
        } else {
            ;
        }
        statement();
        out("labeled_statement");
    }

    public void statement() throws ParseException {
        if (jj_2_57(2)) {
            if (jj_2_47(2)) {
                assign_statement();
            } else if (jj_2_48(2)) {
                procedure_call();
            } else if (jj_2_49(2)) {
                if_statement();
            } else if (jj_2_50(2)) {
                case_statement();
            } else if (jj_2_51(2)) {
                while_statement();
            } else if (jj_2_52(2)) {
                repeat_statement();
            } else if (jj_2_53(2)) {
                for_statement();
            } else if (jj_2_54(2)) {
                with_statement();
            } else if (jj_2_55(2)) {
                goto_statement();
            } else if (jj_2_56(2)) {
                compound_statement();
            } else {
                jj_consume_token(-1);
                throw new ParseException();
            }
        } else {
            ;
        }
        out("statement");
    }

    public void assign_statement() throws ParseException {
        identifier();
        infipo();
        jj_consume_token(ASSIGN);
        expr();
        out("assign_statement");
    }

    public void procedure_call() throws ParseException {
        identifier();
        if (jj_2_58(2)) {
            jj_consume_token(LPAREN);
            expr_list();
            jj_consume_token(RPAREN);
        } else {
            ;
        }
        out("procedure_call");
    }

    public void if_statement() throws ParseException {
        jj_consume_token(IF);
        expr();
        jj_consume_token(THEN);
        statement();
        if (jj_2_59(2)) {
            jj_consume_token(ELSE);
            statement();
        } else {
            ;
        }
        out("if_statement");
    }

     public void while_statement() throws ParseException {
        jj_consume_token(WHILE);
        expr();
        jj_consume_token(DO);
        statement();
        out("while_statement");
    }

     public void repeat_statement() throws ParseException {
        jj_consume_token(REPEAT);
        statement();
        label_12:
        while (true) {
            if (jj_2_60(2)) {
                ;
            } else {
                break label_12;
            }
            jj_consume_token(SEMICOLON);
            statement();
        }
        jj_consume_token(UNTIL);
        expr();
        out("repeat_statement");
    }

     public void for_statement() throws ParseException {
        jj_consume_token(FOR);
        identifier();
        infipo();
        jj_consume_token(ASSIGN);
        expr();
        if (jj_2_61(2)) {
            jj_consume_token(TO);
        } else if (jj_2_62(2)) {
            jj_consume_token(DOWNTO);
        } else {
            jj_consume_token(-1);
            throw new ParseException();
        }
        expr();
        jj_consume_token(DO);
        statement();
        out("for_statement");
    }

     public void with_statement() throws ParseException {
        jj_consume_token(WITH);
        identifier();
        infipo();
        label_13:
        while (true) {
            if (jj_2_63(2)) {
                ;
            } else {
                break label_13;
            }
            jj_consume_token(COMMA);
            identifier();
            infipo();
        }
        jj_consume_token(DO);
        statement();
        out("with_statement");
    }

     public void case_statement() throws ParseException {
        jj_consume_token(CASE);
        expr();
        jj_consume_token(OF);
        _case();
        label_14:
        while (true) {
            if (jj_2_64(2)) {
                ;
            } else {
                break label_14;
            }
            jj_consume_token(SEMICOLON);
            _case();
        }
        jj_consume_token(END);
        out("case_statement");
    }

     public void _case() throws ParseException {
        if (jj_2_65(2)) {
            jj_consume_token(NUMBER);
        } else if (jj_2_66(2)) {
            identifier();
        } else {
            jj_consume_token(-1);
            throw new ParseException();
        }
        jj_consume_token(COLON);
        statement();
    }

     public void goto_statement() throws ParseException {
        jj_consume_token(GOTO);
        jj_consume_token(NUMBER);
        out("goto_statement");
    }

     public void infipo() throws ParseException {
        if (jj_2_68(2)) {
            jj_consume_token(LBRACKET);
            expr();
            label_15:
            while (true) {
                if (jj_2_67(2)) {
                    ;
                } else {
                    break label_15;
                }
                jj_consume_token(COMMA);
                expr();
            }
            jj_consume_token(RBRACKET);
            infipo();
        } else {
            ;
        }
    }

     public void expr_list() throws ParseException {
        expr();
        label_16:
        while (true) {
            if (jj_2_71(2)) {
                ;
            } else {
                break label_16;
            }
            jj_consume_token(COMMA);
            expr();
        }
        out("expr_list");
    }

     public void expr() throws ParseException {
        simple_expr();
        if (jj_2_72(2)) {
            relop();
            simple_expr();
        } else {
            ;
        }
        out("expr");
    }

     public void relop() throws ParseException {
        if (jj_2_73(2)) {
            jj_consume_token(EQ);
        } else if (jj_2_74(2)) {
            jj_consume_token(LT);
        } else if (jj_2_75(2)) {
            jj_consume_token(GT);
        } else if (jj_2_76(2)) {
            jj_consume_token(NE);
        } else if (jj_2_77(2)) {
            jj_consume_token(GE);
        } else if (jj_2_78(2)) {
            jj_consume_token(LE);
        } else if (jj_2_79(2)) {
            jj_consume_token(IN);
            out("relop");
        } else {
            jj_consume_token(-1);
            throw new ParseException();
        }
    }

     public void simple_expr() throws ParseException {
        if (jj_2_82(2)) {
            if (jj_2_80(2)) {
                jj_consume_token(PLUS);
            } else if (jj_2_81(2)) {
                jj_consume_token(MINUS);
            } else {
                jj_consume_token(-1);
                throw new ParseException();
            }
        } else {
            ;
        }
        term();
        label_17:
        while (true) {
            if (jj_2_83(2)) {
                ;
            } else {
                break label_17;
            }
            addop();
            term();
        }
        out("simple_expr");
    }

     public void addop() throws ParseException {
        if (jj_2_84(2)) {
            jj_consume_token(PLUS);
        } else if (jj_2_85(2)) {
            jj_consume_token(MINUS);
        } else if (jj_2_86(2)) {
            jj_consume_token(OR);
            out("addop");
        } else {
            jj_consume_token(-1);
            throw new ParseException();
        }
    }

     public void term() throws ParseException {
        factor();
        label_18:
        while (true) {
            if (jj_2_87(2)) {
                ;
            } else {
                break label_18;
            }
            mulop();
            factor();
        }
        out("term");
    }

     public void mulop() throws ParseException {
        if (jj_2_88(2)) {
            jj_consume_token(MULTIPLY);
        } else if (jj_2_89(2)) {
            jj_consume_token(DIVIDE);
        } else if (jj_2_90(2)) {
            jj_consume_token(DIV);
        } else if (jj_2_91(2)) {
            jj_consume_token(MOD);
        } else if (jj_2_92(2)) {
            jj_consume_token(AND);
            out("mulop");
        } else {
            jj_consume_token(-1);
            throw new ParseException();
        }
    }

     public void factor() throws ParseException {
        if (jj_2_93(2)) {
            jj_consume_token(NUMBER);
        } else if (jj_2_94(2)) {
            jj_consume_token(STRING);
        } else if (jj_2_95(2)) {
            identifier();
            jj_consume_token(LPAREN);
            expr_list();
            jj_consume_token(RPAREN);
        } else if (jj_2_96(2)) {
            identifier();
            infipo();
        } else if (jj_2_97(2)) {
            jj_consume_token(LPAREN);
            expr();
            jj_consume_token(RPAREN);
        } else if (jj_2_98(2)) {
            jj_consume_token(NOT);
            factor();
            out("factor");
        } else {
            jj_consume_token(-1);
            throw new ParseException();
        }
    }

     private boolean jj_2_1(int xla) {
        jj_la = xla;
        jj_lastpos = jj_scanpos = token;
        try {
            return !jj_3_1();
        } catch (LookaheadSuccess ls) {
            return true;
        } finally {
            jj_save(0, xla);
        }
    }

     private boolean jj_2_2(int xla) {
        jj_la = xla;
        jj_lastpos = jj_scanpos = token;
        try {
            return !jj_3_2();
        } catch (LookaheadSuccess ls) {
            return true;
        } finally {
            jj_save(1, xla);
        }
    }

     private boolean jj_2_3(int xla) {
        jj_la = xla;
        jj_lastpos = jj_scanpos = token;
        try {
            return !jj_3_3();
        } catch (LookaheadSuccess ls) {
            return true;
        } finally {
            jj_save(2, xla);
        }
    }

     private boolean jj_2_4(int xla) {
        jj_la = xla;
        jj_lastpos = jj_scanpos = token;
        try {
            return !jj_3_4();
        } catch (LookaheadSuccess ls) {
            return true;
        } finally {
            jj_save(3, xla);
        }
    }

     private boolean jj_2_5(int xla) {
        jj_la = xla;
        jj_lastpos = jj_scanpos = token;
        try {
            return !jj_3_5();
        } catch (LookaheadSuccess ls) {
            return true;
        } finally {
            jj_save(4, xla);
        }
    }

     private boolean jj_2_6(int xla) {
        jj_la = xla;
        jj_lastpos = jj_scanpos = token;
        try {
            return !jj_3_6();
        } catch (LookaheadSuccess ls) {
            return true;
        } finally {
            jj_save(5, xla);
        }
    }

     private boolean jj_2_7(int xla) {
        jj_la = xla;
        jj_lastpos = jj_scanpos = token;
        try {
            return !jj_3_7();
        } catch (LookaheadSuccess ls) {
            return true;
        } finally {
            jj_save(6, xla);
        }
    }

     private boolean jj_2_8(int xla) {
        jj_la = xla;
        jj_lastpos = jj_scanpos = token;
        try {
            return !jj_3_8();
        } catch (LookaheadSuccess ls) {
            return true;
        } finally {
            jj_save(7, xla);
        }
    }

     private boolean jj_2_9(int xla) {
        jj_la = xla;
        jj_lastpos = jj_scanpos = token;
        try {
            return !jj_3_9();
        } catch (LookaheadSuccess ls) {
            return true;
        } finally {
            jj_save(8, xla);
        }
    }

     private boolean jj_2_10(int xla) {
        jj_la = xla;
        jj_lastpos = jj_scanpos = token;
        try {
            return !jj_3_10();
        } catch (LookaheadSuccess ls) {
            return true;
        } finally {
            jj_save(9, xla);
        }
    }

     private boolean jj_2_11(int xla) {
        jj_la = xla;
        jj_lastpos = jj_scanpos = token;
        try {
            return !jj_3_11();
        } catch (LookaheadSuccess ls) {
            return true;
        } finally {
            jj_save(10, xla);
        }
    }

     private boolean jj_2_12(int xla) {
        jj_la = xla;
        jj_lastpos = jj_scanpos = token;
        try {
            return !jj_3_12();
        } catch (LookaheadSuccess ls) {
            return true;
        } finally {
            jj_save(11, xla);
        }
    }

     private boolean jj_2_13(int xla) {
        jj_la = xla;
        jj_lastpos = jj_scanpos = token;
        try {
            return !jj_3_13();
        } catch (LookaheadSuccess ls) {
            return true;
        } finally {
            jj_save(12, xla);
        }
    }

     private boolean jj_2_14(int xla) {
        jj_la = xla;
        jj_lastpos = jj_scanpos = token;
        try {
            return !jj_3_14();
        } catch (LookaheadSuccess ls) {
            return true;
        } finally {
            jj_save(13, xla);
        }
    }

     private boolean jj_2_15(int xla) {
        jj_la = xla;
        jj_lastpos = jj_scanpos = token;
        try {
            return !jj_3_15();
        } catch (LookaheadSuccess ls) {
            return true;
        } finally {
            jj_save(14, xla);
        }
    }

     private boolean jj_2_16(int xla) {
        jj_la = xla;
        jj_lastpos = jj_scanpos = token;
        try {
            return !jj_3_16();
        } catch (LookaheadSuccess ls) {
            return true;
        } finally {
            jj_save(15, xla);
        }
    }

     private boolean jj_2_17(int xla) {
        jj_la = xla;
        jj_lastpos = jj_scanpos = token;
        try {
            return !jj_3_17();
        } catch (LookaheadSuccess ls) {
            return true;
        } finally {
            jj_save(16, xla);
        }
    }

     private boolean jj_2_18(int xla) {
        jj_la = xla;
        jj_lastpos = jj_scanpos = token;
        try {
            return !jj_3_18();
        } catch (LookaheadSuccess ls) {
            return true;
        } finally {
            jj_save(17, xla);
        }
    }

     private boolean jj_2_19(int xla) {
        jj_la = xla;
        jj_lastpos = jj_scanpos = token;
        try {
            return !jj_3_19();
        } catch (LookaheadSuccess ls) {
            return true;
        } finally {
            jj_save(18, xla);
        }
    }

     private boolean jj_2_20(int xla) {
        jj_la = xla;
        jj_lastpos = jj_scanpos = token;
        try {
            return !jj_3_20();
        } catch (LookaheadSuccess ls) {
            return true;
        } finally {
            jj_save(19, xla);
        }
    }

     private boolean jj_2_21(int xla) {
        jj_la = xla;
        jj_lastpos = jj_scanpos = token;
        try {
            return !jj_3_21();
        } catch (LookaheadSuccess ls) {
            return true;
        } finally {
            jj_save(20, xla);
        }
    }

     private boolean jj_2_22(int xla) {
        jj_la = xla;
        jj_lastpos = jj_scanpos = token;
        try {
            return !jj_3_22();
        } catch (LookaheadSuccess ls) {
            return true;
        } finally {
            jj_save(21, xla);
        }
    }

     private boolean jj_2_23(int xla) {
        jj_la = xla;
        jj_lastpos = jj_scanpos = token;
        try {
            return !jj_3_23();
        } catch (LookaheadSuccess ls) {
            return true;
        } finally {
            jj_save(22, xla);
        }
    }

     private boolean jj_2_24(int xla) {
        jj_la = xla;
        jj_lastpos = jj_scanpos = token;
        try {
            return !jj_3_24();
        } catch (LookaheadSuccess ls) {
            return true;
        } finally {
            jj_save(23, xla);
        }
    }

     private boolean jj_2_25(int xla) {
        jj_la = xla;
        jj_lastpos = jj_scanpos = token;
        try {
            return !jj_3_25();
        } catch (LookaheadSuccess ls) {
            return true;
        } finally {
            jj_save(24, xla);
        }
    }

     private boolean jj_2_26(int xla) {
        jj_la = xla;
        jj_lastpos = jj_scanpos = token;
        try {
            return !jj_3_26();
        } catch (LookaheadSuccess ls) {
            return true;
        } finally {
            jj_save(25, xla);
        }
    }

     private boolean jj_2_27(int xla) {
        jj_la = xla;
        jj_lastpos = jj_scanpos = token;
        try {
            return !jj_3_27();
        } catch (LookaheadSuccess ls) {
            return true;
        } finally {
            jj_save(26, xla);
        }
    }

     private boolean jj_2_28(int xla) {
        jj_la = xla;
        jj_lastpos = jj_scanpos = token;
        try {
            return !jj_3_28();
        } catch (LookaheadSuccess ls) {
            return true;
        } finally {
            jj_save(27, xla);
        }
    }

     private boolean jj_2_29(int xla) {
        jj_la = xla;
        jj_lastpos = jj_scanpos = token;
        try {
            return !jj_3_29();
        } catch (LookaheadSuccess ls) {
            return true;
        } finally {
            jj_save(28, xla);
        }
    }

     private boolean jj_2_30(int xla) {
        jj_la = xla;
        jj_lastpos = jj_scanpos = token;
        try {
            return !jj_3_30();
        } catch (LookaheadSuccess ls) {
            return true;
        } finally {
            jj_save(29, xla);
        }
    }

     private boolean jj_2_31(int xla) {
        jj_la = xla;
        jj_lastpos = jj_scanpos = token;
        try {
            return !jj_3_31();
        } catch (LookaheadSuccess ls) {
            return true;
        } finally {
            jj_save(30, xla);
        }
    }

     private boolean jj_2_32(int xla) {
        jj_la = xla;
        jj_lastpos = jj_scanpos = token;
        try {
            return !jj_3_32();
        } catch (LookaheadSuccess ls) {
            return true;
        } finally {
            jj_save(31, xla);
        }
    }

     private boolean jj_2_33(int xla) {
        jj_la = xla;
        jj_lastpos = jj_scanpos = token;
        try {
            return !jj_3_33();
        } catch (LookaheadSuccess ls) {
            return true;
        } finally {
            jj_save(32, xla);
        }
    }

     private boolean jj_2_34(int xla) {
        jj_la = xla;
        jj_lastpos = jj_scanpos = token;
        try {
            return !jj_3_34();
        } catch (LookaheadSuccess ls) {
            return true;
        } finally {
            jj_save(33, xla);
        }
    }

     private boolean jj_2_35(int xla) {
        jj_la = xla;
        jj_lastpos = jj_scanpos = token;
        try {
            return !jj_3_35();
        } catch (LookaheadSuccess ls) {
            return true;
        } finally {
            jj_save(34, xla);
        }
    }

     private boolean jj_2_36(int xla) {
        jj_la = xla;
        jj_lastpos = jj_scanpos = token;
        try {
            return !jj_3_36();
        } catch (LookaheadSuccess ls) {
            return true;
        } finally {
            jj_save(35, xla);
        }
    }

     private boolean jj_2_37(int xla) {
        jj_la = xla;
        jj_lastpos = jj_scanpos = token;
        try {
            return !jj_3_37();
        } catch (LookaheadSuccess ls) {
            return true;
        } finally {
            jj_save(36, xla);
        }
    }

     private boolean jj_2_38(int xla) {
        jj_la = xla;
        jj_lastpos = jj_scanpos = token;
        try {
            return !jj_3_38();
        } catch (LookaheadSuccess ls) {
            return true;
        } finally {
            jj_save(37, xla);
        }
    }

     private boolean jj_2_39(int xla) {
        jj_la = xla;
        jj_lastpos = jj_scanpos = token;
        try {
            return !jj_3_39();
        } catch (LookaheadSuccess ls) {
            return true;
        } finally {
            jj_save(38, xla);
        }
    }

     private boolean jj_2_40(int xla) {
        jj_la = xla;
        jj_lastpos = jj_scanpos = token;
        try {
            return !jj_3_40();
        } catch (LookaheadSuccess ls) {
            return true;
        } finally {
            jj_save(39, xla);
        }
    }

     private boolean jj_2_41(int xla) {
        jj_la = xla;
        jj_lastpos = jj_scanpos = token;
        try {
            return !jj_3_41();
        } catch (LookaheadSuccess ls) {
            return true;
        } finally {
            jj_save(40, xla);
        }
    }

     private boolean jj_2_42(int xla) {
        jj_la = xla;
        jj_lastpos = jj_scanpos = token;
        try {
            return !jj_3_42();
        } catch (LookaheadSuccess ls) {
            return true;
        } finally {
            jj_save(41, xla);
        }
    }

     private boolean jj_2_43(int xla) {
        jj_la = xla;
        jj_lastpos = jj_scanpos = token;
        try {
            return !jj_3_43();
        } catch (LookaheadSuccess ls) {
            return true;
        } finally {
            jj_save(42, xla);
        }
    }

     private boolean jj_2_44(int xla) {
        jj_la = xla;
        jj_lastpos = jj_scanpos = token;
        try {
            return !jj_3_44();
        } catch (LookaheadSuccess ls) {
            return true;
        } finally {
            jj_save(43, xla);
        }
    }

     private boolean jj_2_45(int xla) {
        jj_la = xla;
        jj_lastpos = jj_scanpos = token;
        try {
            return !jj_3_45();
        } catch (LookaheadSuccess ls) {
            return true;
        } finally {
            jj_save(44, xla);
        }
    }

     private boolean jj_2_46(int xla) {
        jj_la = xla;
        jj_lastpos = jj_scanpos = token;
        try {
            return !jj_3_46();
        } catch (LookaheadSuccess ls) {
            return true;
        } finally {
            jj_save(45, xla);
        }
    }

     private boolean jj_2_47(int xla) {
        jj_la = xla;
        jj_lastpos = jj_scanpos = token;
        try {
            return !jj_3_47();
        } catch (LookaheadSuccess ls) {
            return true;
        } finally {
            jj_save(46, xla);
        }
    }

     private boolean jj_2_48(int xla) {
        jj_la = xla;
        jj_lastpos = jj_scanpos = token;
        try {
            return !jj_3_48();
        } catch (LookaheadSuccess ls) {
            return true;
        } finally {
            jj_save(47, xla);
        }
    }

     private boolean jj_2_49(int xla) {
        jj_la = xla;
        jj_lastpos = jj_scanpos = token;
        try {
            return !jj_3_49();
        } catch (LookaheadSuccess ls) {
            return true;
        } finally {
            jj_save(48, xla);
        }
    }

     private boolean jj_2_50(int xla) {
        jj_la = xla;
        jj_lastpos = jj_scanpos = token;
        try {
            return !jj_3_50();
        } catch (LookaheadSuccess ls) {
            return true;
        } finally {
            jj_save(49, xla);
        }
    }

     private boolean jj_2_51(int xla) {
        jj_la = xla;
        jj_lastpos = jj_scanpos = token;
        try {
            return !jj_3_51();
        } catch (LookaheadSuccess ls) {
            return true;
        } finally {
            jj_save(50, xla);
        }
    }

     private boolean jj_2_52(int xla) {
        jj_la = xla;
        jj_lastpos = jj_scanpos = token;
        try {
            return !jj_3_52();
        } catch (LookaheadSuccess ls) {
            return true;
        } finally {
            jj_save(51, xla);
        }
    }

     private boolean jj_2_53(int xla) {
        jj_la = xla;
        jj_lastpos = jj_scanpos = token;
        try {
            return !jj_3_53();
        } catch (LookaheadSuccess ls) {
            return true;
        } finally {
            jj_save(52, xla);
        }
    }

     private boolean jj_2_54(int xla) {
        jj_la = xla;
        jj_lastpos = jj_scanpos = token;
        try {
            return !jj_3_54();
        } catch (LookaheadSuccess ls) {
            return true;
        } finally {
            jj_save(53, xla);
        }
    }

     private boolean jj_2_55(int xla) {
        jj_la = xla;
        jj_lastpos = jj_scanpos = token;
        try {
            return !jj_3_55();
        } catch (LookaheadSuccess ls) {
            return true;
        } finally {
            jj_save(54, xla);
        }
    }

     private boolean jj_2_56(int xla) {
        jj_la = xla;
        jj_lastpos = jj_scanpos = token;
        try {
            return !jj_3_56();
        } catch (LookaheadSuccess ls) {
            return true;
        } finally {
            jj_save(55, xla);
        }
    }

     private boolean jj_2_57(int xla) {
        jj_la = xla;
        jj_lastpos = jj_scanpos = token;
        try {
            return !jj_3_57();
        } catch (LookaheadSuccess ls) {
            return true;
        } finally {
            jj_save(56, xla);
        }
    }

     private boolean jj_2_58(int xla) {
        jj_la = xla;
        jj_lastpos = jj_scanpos = token;
        try {
            return !jj_3_58();
        } catch (LookaheadSuccess ls) {
            return true;
        } finally {
            jj_save(57, xla);
        }
    }

     private boolean jj_2_59(int xla) {
        jj_la = xla;
        jj_lastpos = jj_scanpos = token;
        try {
            return !jj_3_59();
        } catch (LookaheadSuccess ls) {
            return true;
        } finally {
            jj_save(58, xla);
        }
    }

     private boolean jj_2_60(int xla) {
        jj_la = xla;
        jj_lastpos = jj_scanpos = token;
        try {
            return !jj_3_60();
        } catch (LookaheadSuccess ls) {
            return true;
        } finally {
            jj_save(59, xla);
        }
    }

     private boolean jj_2_61(int xla) {
        jj_la = xla;
        jj_lastpos = jj_scanpos = token;
        try {
            return !jj_3_61();
        } catch (LookaheadSuccess ls) {
            return true;
        } finally {
            jj_save(60, xla);
        }
    }

     private boolean jj_2_62(int xla) {
        jj_la = xla;
        jj_lastpos = jj_scanpos = token;
        try {
            return !jj_3_62();
        } catch (LookaheadSuccess ls) {
            return true;
        } finally {
            jj_save(61, xla);
        }
    }

     private boolean jj_2_63(int xla) {
        jj_la = xla;
        jj_lastpos = jj_scanpos = token;
        try {
            return !jj_3_63();
        } catch (LookaheadSuccess ls) {
            return true;
        } finally {
            jj_save(62, xla);
        }
    }

     private boolean jj_2_64(int xla) {
        jj_la = xla;
        jj_lastpos = jj_scanpos = token;
        try {
            return !jj_3_64();
        } catch (LookaheadSuccess ls) {
            return true;
        } finally {
            jj_save(63, xla);
        }
    }

     private boolean jj_2_65(int xla) {
        jj_la = xla;
        jj_lastpos = jj_scanpos = token;
        try {
            return !jj_3_65();
        } catch (LookaheadSuccess ls) {
            return true;
        } finally {
            jj_save(64, xla);
        }
    }

     private boolean jj_2_66(int xla) {
        jj_la = xla;
        jj_lastpos = jj_scanpos = token;
        try {
            return !jj_3_66();
        } catch (LookaheadSuccess ls) {
            return true;
        } finally {
            jj_save(65, xla);
        }
    }

     private boolean jj_2_67(int xla) {
        jj_la = xla;
        jj_lastpos = jj_scanpos = token;
        try {
            return !jj_3_67();
        } catch (LookaheadSuccess ls) {
            return true;
        } finally {
            jj_save(66, xla);
        }
    }

     private boolean jj_2_68(int xla) {
        jj_la = xla;
        jj_lastpos = jj_scanpos = token;
        try {
            return !jj_3_68();
        } catch (LookaheadSuccess ls) {
            return true;
        } finally {
            jj_save(67, xla);
        }
    }

     private boolean jj_2_69(int xla) {
        jj_la = xla;
        jj_lastpos = jj_scanpos = token;
        try {
            return !jj_3_69();
        } catch (LookaheadSuccess ls) {
            return true;
        } finally {
            jj_save(68, xla);
        }
    }

     private boolean jj_2_70(int xla) {
        jj_la = xla;
        jj_lastpos = jj_scanpos = token;
        try {
            return !jj_3_70();
        } catch (LookaheadSuccess ls) {
            return true;
        } finally {
            jj_save(69, xla);
        }
    }

     private boolean jj_2_71(int xla) {
        jj_la = xla;
        jj_lastpos = jj_scanpos = token;
        try {
            return !jj_3_71();
        } catch (LookaheadSuccess ls) {
            return true;
        } finally {
            jj_save(70, xla);
        }
    }

     private boolean jj_2_72(int xla) {
        jj_la = xla;
        jj_lastpos = jj_scanpos = token;
        try {
            return !jj_3_72();
        } catch (LookaheadSuccess ls) {
            return true;
        } finally {
            jj_save(71, xla);
        }
    }

     private boolean jj_2_73(int xla) {
        jj_la = xla;
        jj_lastpos = jj_scanpos = token;
        try {
            return !jj_3_73();
        } catch (LookaheadSuccess ls) {
            return true;
        } finally {
            jj_save(72, xla);
        }
    }

     private boolean jj_2_74(int xla) {
        jj_la = xla;
        jj_lastpos = jj_scanpos = token;
        try {
            return !jj_3_74();
        } catch (LookaheadSuccess ls) {
            return true;
        } finally {
            jj_save(73, xla);
        }
    }

     private boolean jj_2_75(int xla) {
        jj_la = xla;
        jj_lastpos = jj_scanpos = token;
        try {
            return !jj_3_75();
        } catch (LookaheadSuccess ls) {
            return true;
        } finally {
            jj_save(74, xla);
        }
    }

     private boolean jj_2_76(int xla) {
        jj_la = xla;
        jj_lastpos = jj_scanpos = token;
        try {
            return !jj_3_76();
        } catch (LookaheadSuccess ls) {
            return true;
        } finally {
            jj_save(75, xla);
        }
    }

     private boolean jj_2_77(int xla) {
        jj_la = xla;
        jj_lastpos = jj_scanpos = token;
        try {
            return !jj_3_77();
        } catch (LookaheadSuccess ls) {
            return true;
        } finally {
            jj_save(76, xla);
        }
    }

     private boolean jj_2_78(int xla) {
        jj_la = xla;
        jj_lastpos = jj_scanpos = token;
        try {
            return !jj_3_78();
        } catch (LookaheadSuccess ls) {
            return true;
        } finally {
            jj_save(77, xla);
        }
    }

     private boolean jj_2_79(int xla) {
        jj_la = xla;
        jj_lastpos = jj_scanpos = token;
        try {
            return !jj_3_79();
        } catch (LookaheadSuccess ls) {
            return true;
        } finally {
            jj_save(78, xla);
        }
    }

     private boolean jj_2_80(int xla) {
        jj_la = xla;
        jj_lastpos = jj_scanpos = token;
        try {
            return !jj_3_80();
        } catch (LookaheadSuccess ls) {
            return true;
        } finally {
            jj_save(79, xla);
        }
    }

     private boolean jj_2_81(int xla) {
        jj_la = xla;
        jj_lastpos = jj_scanpos = token;
        try {
            return !jj_3_81();
        } catch (LookaheadSuccess ls) {
            return true;
        } finally {
            jj_save(80, xla);
        }
    }

     private boolean jj_2_82(int xla) {
        jj_la = xla;
        jj_lastpos = jj_scanpos = token;
        try {
            return !jj_3_82();
        } catch (LookaheadSuccess ls) {
            return true;
        } finally {
            jj_save(81, xla);
        }
    }

     private boolean jj_2_83(int xla) {
        jj_la = xla;
        jj_lastpos = jj_scanpos = token;
        try {
            return !jj_3_83();
        } catch (LookaheadSuccess ls) {
            return true;
        } finally {
            jj_save(82, xla);
        }
    }

     private boolean jj_2_84(int xla) {
        jj_la = xla;
        jj_lastpos = jj_scanpos = token;
        try {
            return !jj_3_84();
        } catch (LookaheadSuccess ls) {
            return true;
        } finally {
            jj_save(83, xla);
        }
    }

     private boolean jj_2_85(int xla) {
        jj_la = xla;
        jj_lastpos = jj_scanpos = token;
        try {
            return !jj_3_85();
        } catch (LookaheadSuccess ls) {
            return true;
        } finally {
            jj_save(84, xla);
        }
    }

     private boolean jj_2_86(int xla) {
        jj_la = xla;
        jj_lastpos = jj_scanpos = token;
        try {
            return !jj_3_86();
        } catch (LookaheadSuccess ls) {
            return true;
        } finally {
            jj_save(85, xla);
        }
    }

     private boolean jj_2_87(int xla) {
        jj_la = xla;
        jj_lastpos = jj_scanpos = token;
        try {
            return !jj_3_87();
        } catch (LookaheadSuccess ls) {
            return true;
        } finally {
            jj_save(86, xla);
        }
    }

     private boolean jj_2_88(int xla) {
        jj_la = xla;
        jj_lastpos = jj_scanpos = token;
        try {
            return !jj_3_88();
        } catch (LookaheadSuccess ls) {
            return true;
        } finally {
            jj_save(87, xla);
        }
    }

     private boolean jj_2_89(int xla) {
        jj_la = xla;
        jj_lastpos = jj_scanpos = token;
        try {
            return !jj_3_89();
        } catch (LookaheadSuccess ls) {
            return true;
        } finally {
            jj_save(88, xla);
        }
    }

     private boolean jj_2_90(int xla) {
        jj_la = xla;
        jj_lastpos = jj_scanpos = token;
        try {
            return !jj_3_90();
        } catch (LookaheadSuccess ls) {
            return true;
        } finally {
            jj_save(89, xla);
        }
    }

     private boolean jj_2_91(int xla) {
        jj_la = xla;
        jj_lastpos = jj_scanpos = token;
        try {
            return !jj_3_91();
        } catch (LookaheadSuccess ls) {
            return true;
        } finally {
            jj_save(90, xla);
        }
    }

     private boolean jj_2_92(int xla) {
        jj_la = xla;
        jj_lastpos = jj_scanpos = token;
        try {
            return !jj_3_92();
        } catch (LookaheadSuccess ls) {
            return true;
        } finally {
            jj_save(91, xla);
        }
    }

     private boolean jj_2_93(int xla) {
        jj_la = xla;
        jj_lastpos = jj_scanpos = token;
        try {
            return !jj_3_93();
        } catch (LookaheadSuccess ls) {
            return true;
        } finally {
            jj_save(92, xla);
        }
    }

     private boolean jj_2_94(int xla) {
        jj_la = xla;
        jj_lastpos = jj_scanpos = token;
        try {
            return !jj_3_94();
        } catch (LookaheadSuccess ls) {
            return true;
        } finally {
            jj_save(93, xla);
        }
    }

     private boolean jj_2_95(int xla) {
        jj_la = xla;
        jj_lastpos = jj_scanpos = token;
        try {
            return !jj_3_95();
        } catch (LookaheadSuccess ls) {
            return true;
        } finally {
            jj_save(94, xla);
        }
    }

     private boolean jj_2_96(int xla) {
        jj_la = xla;
        jj_lastpos = jj_scanpos = token;
        try {
            return !jj_3_96();
        } catch (LookaheadSuccess ls) {
            return true;
        } finally {
            jj_save(95, xla);
        }
    }

     private boolean jj_2_97(int xla) {
        jj_la = xla;
        jj_lastpos = jj_scanpos = token;
        try {
            return !jj_3_97();
        } catch (LookaheadSuccess ls) {
            return true;
        } finally {
            jj_save(96, xla);
        }
    }

     private boolean jj_2_98(int xla) {
        jj_la = xla;
        jj_lastpos = jj_scanpos = token;
        try {
            return !jj_3_98();
        } catch (LookaheadSuccess ls) {
            return true;
        } finally {
            jj_save(97, xla);
        }
    }

     private boolean jj_3R_23() {
        if (jj_scan_token(CONST)) return true;
        if (jj_3R_27()) return true;
        return false;
    }

     private boolean jj_3R_22() {
        if (jj_scan_token(LABEL)) return true;
        if (jj_scan_token(NUMBER)) return true;
        return false;
    }

     private boolean jj_3_98() {
        if (jj_scan_token(NOT)) return true;
        if (jj_3R_60()) return true;
        return false;
    }

     private boolean jj_3_9() {
        if (jj_3R_26()) return true;
        return false;
    }

     private boolean jj_3_1() {
        if (jj_scan_token(LPAREN)) return true;
        if (jj_3R_19()) return true;
        return false;
    }

     private boolean jj_3_97() {
        if (jj_scan_token(LPAREN)) return true;
        if (jj_3R_53()) return true;
        return false;
    }

     private boolean jj_3_8() {
        if (jj_3R_25()) return true;
        return false;
    }

     private boolean jj_3_96() {
        if (jj_3R_20()) return true;
        if (jj_3R_54()) return true;
        return false;
    }

     private boolean jj_3_7() {
        if (jj_3R_24()) return true;
        return false;
    }

     private boolean jj_3_95() {
        if (jj_3R_20()) return true;
        if (jj_scan_token(LPAREN)) return true;
        return false;
    }

     private boolean jj_3_6() {
        if (jj_3R_23()) return true;
        return false;
    }

     private boolean jj_3_94() {
        if (jj_scan_token(STRING)) return true;
        return false;
    }

     private boolean jj_3_5() {
        if (jj_3R_22()) return true;
        return false;
    }

     private boolean jj_3R_21() {
        Token xsp;
        xsp = jj_scanpos;
        if (jj_3_5()) {
            jj_scanpos = xsp;
            if (jj_3_6()) {
                jj_scanpos = xsp;
                if (jj_3_7()) {
                    jj_scanpos = xsp;
                    if (jj_3_8()) {
                        jj_scanpos = xsp;
                        if (jj_3_9()) return true;
                    }
                }
            }
        }
        return false;
    }

     private boolean jj_3_93() {
        if (jj_scan_token(NUMBER)) return true;
        return false;
    }

     private boolean jj_3R_60() {
        Token xsp;
        xsp = jj_scanpos;
        if (jj_3_93()) {
            jj_scanpos = xsp;
            if (jj_3_94()) {
                jj_scanpos = xsp;
                if (jj_3_95()) {
                    jj_scanpos = xsp;
                    if (jj_3_96()) {
                        jj_scanpos = xsp;
                        if (jj_3_97()) {
                            jj_scanpos = xsp;
                            if (jj_3_98()) return true;
                        }
                    }
                }
            }
        }
        return false;
    }

     private boolean jj_3_92() {
        if (jj_scan_token(AND)) return true;
        return false;
    }

     private boolean jj_3_91() {
        if (jj_scan_token(MOD)) return true;
        return false;
    }

     private boolean jj_3_90() {
        if (jj_scan_token(DIV)) return true;
        return false;
    }

     private boolean jj_3_87() {
        if (jj_3R_59()) return true;
        if (jj_3R_60()) return true;
        return false;
    }

     private boolean jj_3_89() {
        if (jj_scan_token(DIVIDE)) return true;
        return false;
    }

     private boolean jj_3_88() {
        if (jj_scan_token(MULTIPLY)) return true;
        return false;
    }

     private boolean jj_3R_59() {
        Token xsp;
        xsp = jj_scanpos;
        if (jj_3_88()) {
            jj_scanpos = xsp;
            if (jj_3_89()) {
                jj_scanpos = xsp;
                if (jj_3_90()) {
                    jj_scanpos = xsp;
                    if (jj_3_91()) {
                        jj_scanpos = xsp;
                        if (jj_3_92()) return true;
                    }
                }
            }
        }
        return false;
    }

     private boolean jj_3_4() {
        if (jj_3R_21()) return true;
        return false;
    }

     private boolean jj_3_83() {
        if (jj_3R_57()) return true;
        if (jj_3R_58()) return true;
        return false;
    }

     private boolean jj_3R_58() {
        if (jj_3R_60()) return true;
        return false;
    }

     private boolean jj_3_3() {
        if (jj_scan_token(0)) return true;
        return false;
    }

     private boolean jj_3_86() {
        if (jj_scan_token(OR)) return true;
        return false;
    }

     private boolean jj_3_85() {
        if (jj_scan_token(MINUS)) return true;
        return false;
    }

     private boolean jj_3_84() {
        if (jj_scan_token(PLUS)) return true;
        return false;
    }

     private boolean jj_3R_57() {
        Token xsp;
        xsp = jj_scanpos;
        if (jj_3_84()) {
            jj_scanpos = xsp;
            if (jj_3_85()) {
                jj_scanpos = xsp;
                if (jj_3_86()) return true;
            }
        }
        return false;
    }

     private boolean jj_3_2() {
        if (jj_scan_token(PROGRAM)) return true;
        if (jj_3R_20()) return true;
        return false;
    }

     private boolean jj_3_81() {
        if (jj_scan_token(MINUS)) return true;
        return false;
    }

     private boolean jj_3_80() {
        if (jj_scan_token(PLUS)) return true;
        return false;
    }

     private boolean jj_3_82() {
        Token xsp;
        xsp = jj_scanpos;
        if (jj_3_80()) {
            jj_scanpos = xsp;
            if (jj_3_81()) return true;
        }
        return false;
    }

     private boolean jj_3R_56() {
        Token xsp;
        xsp = jj_scanpos;
        if (jj_3_82()) jj_scanpos = xsp;
        if (jj_3R_58()) return true;
        return false;
    }

     private boolean jj_3_72() {
        if (jj_3R_55()) return true;
        if (jj_3R_56()) return true;
        return false;
    }

     private boolean jj_3_79() {
        if (jj_scan_token(IN)) return true;
        return false;
    }

     private boolean jj_3_78() {
        if (jj_scan_token(LE)) return true;
        return false;
    }

     private boolean jj_3_77() {
        if (jj_scan_token(GE)) return true;
        return false;
    }

     private boolean jj_3_76() {
        if (jj_scan_token(NE)) return true;
        return false;
    }

     private boolean jj_3_75() {
        if (jj_scan_token(GT)) return true;
        return false;
    }

     private boolean jj_3_74() {
        if (jj_scan_token(LT)) return true;
        return false;
    }

     private boolean jj_3_73() {
        if (jj_scan_token(EQ)) return true;
        return false;
    }

     private boolean jj_3R_55() {
        Token xsp;
        xsp = jj_scanpos;
        if (jj_3_73()) {
            jj_scanpos = xsp;
            if (jj_3_74()) {
                jj_scanpos = xsp;
                if (jj_3_75()) {
                    jj_scanpos = xsp;
                    if (jj_3_76()) {
                        jj_scanpos = xsp;
                        if (jj_3_77()) {
                            jj_scanpos = xsp;
                            if (jj_3_78()) {
                                jj_scanpos = xsp;
                                if (jj_3_79()) return true;
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

     private boolean jj_3_71() {
        if (jj_scan_token(COMMA)) return true;
        if (jj_3R_53()) return true;
        return false;
    }

     private boolean jj_3R_53() {
        if (jj_3R_56()) return true;
        return false;
    }

     private boolean jj_3_67() {
        if (jj_scan_token(COMMA)) return true;
        if (jj_3R_53()) return true;
        return false;
    }

     private boolean jj_3_62() {
        if (jj_scan_token(DOWNTO)) return true;
        return false;
    }

     private boolean jj_3R_50() {
        if (jj_3R_53()) return true;
        return false;
    }

     private boolean jj_3_64() {
        if (jj_scan_token(SEMICOLON)) return true;
        if (jj_3R_52()) return true;
        return false;
    }

     private boolean jj_3_70() {
        if (jj_scan_token(UPARROW)) return true;
        if (jj_3R_54()) return true;
        return false;
    }

     private boolean jj_3_69() {
        if (jj_scan_token(DOT)) return true;
        if (jj_3R_20()) return true;
        return false;
    }

     private boolean jj_3_61() {
        if (jj_scan_token(TO)) return true;
        return false;
    }

     private boolean jj_3R_64() {
        Token xsp;
        xsp = jj_scanpos;
        if (jj_3_70()) jj_scanpos = xsp;
        return false;
    }

     private boolean jj_3_68() {
        if (jj_scan_token(LBRACKET)) return true;
        if (jj_3R_53()) return true;
        return false;
    }

     private boolean jj_3R_63() {
        Token xsp;
        xsp = jj_scanpos;
        if (jj_3_69()) jj_scanpos = xsp;
        return false;
    }

     private boolean jj_3_63() {
        if (jj_scan_token(COMMA)) return true;
        if (jj_3R_20()) return true;
        return false;
    }

     private boolean jj_3R_54() {
        Token xsp;
        xsp = jj_scanpos;
        if (jj_3R_62()) {
            jj_scanpos = xsp;
            if (jj_3R_63()) {
                jj_scanpos = xsp;
                if (jj_3R_64()) return true;
            }
        }
        return false;
    }

     private boolean jj_3R_62() {
        Token xsp;
        xsp = jj_scanpos;
        if (jj_3_68()) jj_scanpos = xsp;
        return false;
    }

     private boolean jj_3_66() {
        if (jj_3R_20()) return true;
        return false;
    }

     private boolean jj_3R_48() {
        if (jj_scan_token(GOTO)) return true;
        if (jj_scan_token(NUMBER)) return true;
        return false;
    }

     private boolean jj_3_65() {
        if (jj_scan_token(NUMBER)) return true;
        return false;
    }

     private boolean jj_3R_52() {
        Token xsp;
        xsp = jj_scanpos;
        if (jj_3_65()) {
            jj_scanpos = xsp;
            if (jj_3_66()) return true;
        }
        return false;
    }

     private boolean jj_3R_43() {
        if (jj_scan_token(CASE)) return true;
        if (jj_3R_53()) return true;
        return false;
    }

     private boolean jj_3_60() {
        if (jj_scan_token(SEMICOLON)) return true;
        if (jj_3R_51()) return true;
        return false;
    }

     private boolean jj_3_59() {
        if (jj_scan_token(ELSE)) return true;
        if (jj_3R_51()) return true;
        return false;
    }

     private boolean jj_3R_47() {
        if (jj_scan_token(WITH)) return true;
        if (jj_3R_20()) return true;
        return false;
    }

     private boolean jj_3R_46() {
        if (jj_scan_token(FOR)) return true;
        if (jj_3R_20()) return true;
        return false;
    }

     private boolean jj_3R_45() {
        if (jj_scan_token(REPEAT)) return true;
        if (jj_3R_51()) return true;
        Token xsp;
        while (true) {
            xsp = jj_scanpos;
            if (jj_3_60()) {
                jj_scanpos = xsp;
                break;
            }
        }
        if (jj_scan_token(UNTIL)) return true;
        return false;
    }

     private boolean jj_3R_44() {
        if (jj_scan_token(WHILE)) return true;
        if (jj_3R_53()) return true;
        return false;
    }

     private boolean jj_3_58() {
        if (jj_scan_token(LPAREN)) return true;
        if (jj_3R_50()) return true;
        return false;
    }

     private boolean jj_3R_42() {
        if (jj_scan_token(IF)) return true;
        if (jj_3R_53()) return true;
        return false;
    }

     private boolean jj_3R_61() {
        if (jj_3R_54()) return true;
        return false;
    }

     private boolean jj_3R_41() {
        if (jj_3R_20()) return true;
        Token xsp;
        xsp = jj_scanpos;
        if (jj_3_58()) jj_scanpos = xsp;
        return false;
    }

     private boolean jj_3_39() {
        if (jj_3R_20()) return true;
        return false;
    }

     private boolean jj_3R_40() {
        if (jj_3R_20()) return true;
        Token xsp;
        xsp = jj_scanpos;
        if (jj_3R_61()) jj_scanpos = xsp;
        if (jj_scan_token(ASSIGN)) return true;
        return false;
    }

     private boolean jj_3_45() {
        if (jj_scan_token(SEMICOLON)) return true;
        if (jj_3R_39()) return true;
        return false;
    }

     private boolean jj_3_56() {
        if (jj_3R_49()) return true;
        return false;
    }

     private boolean jj_3_55() {
        if (jj_3R_48()) return true;
        return false;
    }

     private boolean jj_3_54() {
        if (jj_3R_47()) return true;
        return false;
    }

     private boolean jj_3_53() {
        if (jj_3R_46()) return true;
        return false;
    }

     private boolean jj_3_52() {
        if (jj_3R_45()) return true;
        return false;
    }

     private boolean jj_3_51() {
        if (jj_3R_44()) return true;
        return false;
    }

     private boolean jj_3_50() {
        if (jj_3R_43()) return true;
        return false;
    }

     private boolean jj_3_49() {
        if (jj_3R_42()) return true;
        return false;
    }

     private boolean jj_3_48() {
        if (jj_3R_41()) return true;
        return false;
    }

     private boolean jj_3_57() {
        Token xsp;
        xsp = jj_scanpos;
        if (jj_3_47()) {
            jj_scanpos = xsp;
            if (jj_3_48()) {
                jj_scanpos = xsp;
                if (jj_3_49()) {
                    jj_scanpos = xsp;
                    if (jj_3_50()) {
                        jj_scanpos = xsp;
                        if (jj_3_51()) {
                            jj_scanpos = xsp;
                            if (jj_3_52()) {
                                jj_scanpos = xsp;
                                if (jj_3_53()) {
                                    jj_scanpos = xsp;
                                    if (jj_3_54()) {
                                        jj_scanpos = xsp;
                                        if (jj_3_55()) {
                                            jj_scanpos = xsp;
                                            if (jj_3_56()) return true;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

     private boolean jj_3_47() {
        if (jj_3R_40()) return true;
        return false;
    }

     private boolean jj_3R_51() {
        Token xsp;
        xsp = jj_scanpos;
        if (jj_3_57()) jj_scanpos = xsp;
        return false;
    }

     private boolean jj_3_46() {
        if (jj_scan_token(NUMBER)) return true;
        if (jj_scan_token(COLON)) return true;
        return false;
    }

     private boolean jj_3R_39() {
        Token xsp;
        xsp = jj_scanpos;
        if (jj_3_46()) jj_scanpos = xsp;
        if (jj_3R_51()) return true;
        return false;
    }

     private boolean jj_3_38() {
        if (jj_3R_37()) return true;
        return false;
    }

     private boolean jj_3_40() {
        if (jj_scan_token(SEMICOLON)) return true;
        if (jj_3R_38()) return true;
        return false;
    }

     private boolean jj_3R_49() {
        if (jj_scan_token(BEGIN)) return true;
        if (jj_3R_39()) return true;
        Token xsp;
        while (true) {
            xsp = jj_scanpos;
            if (jj_3_45()) {
                jj_scanpos = xsp;
                break;
            }
        }
        if (jj_scan_token(END)) return true;
        return false;
    }

     private boolean jj_3_37() {
        if (jj_3R_37()) return true;
        return false;
    }

     private boolean jj_3_44() {
        if (jj_scan_token(PROCEDURE)) return true;
        if (jj_3R_19()) return true;
        return false;
    }

     private boolean jj_3_41() {
        if (jj_scan_token(VAR)) return true;
        return false;
    }

     private boolean jj_3_43() {
        if (jj_scan_token(FUNCTION)) return true;
        if (jj_3R_19()) return true;
        return false;
    }

     private boolean jj_3_42() {
        Token xsp;
        xsp = jj_scanpos;
        if (jj_3_41()) jj_scanpos = xsp;
        if (jj_3R_19()) return true;
        if (jj_scan_token(COLON)) return true;
        return false;
    }

     private boolean jj_3R_38() {
        Token xsp;
        xsp = jj_scanpos;
        if (jj_3_42()) {
            jj_scanpos = xsp;
            if (jj_3_43()) {
                jj_scanpos = xsp;
                if (jj_3_44()) return true;
            }
        }
        return false;
    }

     private boolean jj_3R_37() {
        if (jj_scan_token(LPAREN)) return true;
        if (jj_3R_38()) return true;
        return false;
    }

     private boolean jj_3_33() {
        if (jj_scan_token(SEMICOLON)) return true;
        return false;
    }

     private boolean jj_3_34() {
        if (jj_scan_token(SEMICOLON)) return true;
        return false;
    }

     private boolean jj_3R_36() {
        if (jj_scan_token(FUNCTION)) return true;
        if (jj_3R_20()) return true;
        return false;
    }

     private boolean jj_3R_35() {
        if (jj_scan_token(PROCEDURE)) return true;
        if (jj_3R_20()) return true;
        return false;
    }

     private boolean jj_3_32() {
        if (jj_scan_token(COMMA)) return true;
        if (jj_3R_34()) return true;
        return false;
    }

     private boolean jj_3_36() {
        if (jj_3R_36()) return true;
        return false;
    }

     private boolean jj_3_35() {
        if (jj_3R_35()) return true;
        return false;
    }

     private boolean jj_3R_26() {
        Token xsp;
        xsp = jj_scanpos;
        if (jj_3_35()) {
            jj_scanpos = xsp;
            if (jj_3_36()) return true;
        }
        return false;
    }

     private boolean jj_3R_34() {
        if (jj_3R_20()) return true;
        return false;
    }

     private boolean jj_3R_20() {
        if (jj_scan_token(IDENTIFIER)) return true;
        return false;
    }

     private boolean jj_3_31() {
        if (jj_scan_token(SEMICOLON)) return true;
        if (jj_3R_33()) return true;
        return false;
    }

     private boolean jj_3_30() {
        if (jj_scan_token(SEMICOLON)) return true;
        if (jj_3R_19()) return true;
        return false;
    }

     private boolean jj_3R_19() {
        if (jj_3R_34()) return true;
        Token xsp;
        while (true) {
            xsp = jj_scanpos;
            if (jj_3_32()) {
                jj_scanpos = xsp;
                break;
            }
        }
        return false;
    }

     private boolean jj_3R_33() {
        if (jj_3R_19()) return true;
        return false;
    }

     private boolean jj_3R_25() {
        if (jj_scan_token(VAR)) return true;
        if (jj_3R_33()) return true;
        return false;
    }

     private boolean jj_3R_30() {
        if (jj_3R_19()) return true;
        return false;
    }

     private boolean jj_3_13() {
        if (jj_scan_token(COMMA)) return true;
        if (jj_3R_29()) return true;
        return false;
    }

     private boolean jj_3_19() {
        if (jj_scan_token(COMMA)) return true;
        if (jj_3R_20()) return true;
        return false;
    }

     private boolean jj_3_29() {
        if (jj_scan_token(NUMBER)) return true;
        return false;
    }

     private boolean jj_3_24() {
        if (jj_scan_token(MINUS)) return true;
        return false;
    }

     private boolean jj_3_28() {
        if (jj_3R_20()) return true;
        return false;
    }

     private boolean jj_3R_32() {
        Token xsp;
        xsp = jj_scanpos;
        if (jj_3_28()) {
            jj_scanpos = xsp;
            if (jj_3_29()) return true;
        }
        return false;
    }

     private boolean jj_3_23() {
        if (jj_scan_token(PLUS)) return true;
        return false;
    }

     private boolean jj_3_25() {
        Token xsp;
        xsp = jj_scanpos;
        if (jj_3_23()) {
            jj_scanpos = xsp;
            if (jj_3_24()) return true;
        }
        return false;
    }

     private boolean jj_3_27() {
        Token xsp;
        xsp = jj_scanpos;
        if (jj_3_25()) jj_scanpos = xsp;
        if (jj_3R_32()) return true;
        return false;
    }

     private boolean jj_3_26() {
        if (jj_scan_token(STRING)) return true;
        return false;
    }

     private boolean jj_3R_31() {
        Token xsp;
        xsp = jj_scanpos;
        if (jj_3_26()) {
            jj_scanpos = xsp;
            if (jj_3_27()) return true;
        }
        return false;
    }

     private boolean jj_3_22() {
        if (jj_3R_31()) return true;
        if (jj_scan_token(DOTDOT)) return true;
        return false;
    }

     private boolean jj_3_21() {
        if (jj_scan_token(LPAREN)) return true;
        if (jj_3R_20()) return true;
        return false;
    }

     private boolean jj_3_20() {
        if (jj_3R_20()) return true;
        return false;
    }

     private boolean jj_3R_29() {
        Token xsp;
        xsp = jj_scanpos;
        if (jj_3_20()) {
            jj_scanpos = xsp;
            if (jj_3_21()) {
                jj_scanpos = xsp;
                if (jj_3_22()) return true;
            }
        }
        return false;
    }

     private boolean jj_3_12() {
        if (jj_scan_token(SEMICOLON)) return true;
        if (jj_3R_28()) return true;
        return false;
    }

     private boolean jj_3_18() {
        if (jj_3R_29()) return true;
        return false;
    }

     private boolean jj_3_17() {
        if (jj_scan_token(RECORD)) return true;
        if (jj_3R_30()) return true;
        return false;
    }

     private boolean jj_3_16() {
        if (jj_scan_token(SETOF)) return true;
        if (jj_3R_29()) return true;
        return false;
    }

     private boolean jj_3_15() {
        if (jj_3R_20()) return true;
        if (jj_scan_token(LBRACKET)) return true;
        return false;
    }

     private boolean jj_3_14() {
        if (jj_scan_token(UPARROW)) return true;
        if (jj_3R_20()) return true;
        return false;
    }

     private boolean jj_3_11() {
        if (jj_scan_token(SEMICOLON)) return true;
        if (jj_3R_27()) return true;
        return false;
    }

     private boolean jj_3R_28() {
        if (jj_3R_20()) return true;
        return false;
    }

     private boolean jj_3R_24() {
        if (jj_scan_token(TYPE)) return true;
        if (jj_3R_28()) return true;
        return false;
    }

     private boolean jj_3_10() {
        if (jj_scan_token(COMMA)) return true;
        if (jj_scan_token(NUMBER)) return true;
        return false;
    }

     private boolean jj_3R_27() {
        if (jj_3R_20()) return true;
        return false;
    }

     public JPascalTokenManager token_source;
     SimpleCharStream jj_input_stream;
    /**
     * Current token.
     */
     public Token token;
    /**
     * Next token.
     */
     public Token jj_nt;
     private int jj_ntk;
     private Token jj_scanpos, jj_lastpos;
     private int jj_la;
     private int jj_gen;
     private int[] jj_la1 = new int[0];
     private int[] jj_la1_0;
     private int[] jj_la1_1;
     private int[] jj_la1_2;

     {
        jj_la1_init_0();
        jj_la1_init_1();
        jj_la1_init_2();
    }

    private  void jj_la1_init_0() {
        jj_la1_0 = new int[]{};
    }

    private  void jj_la1_init_1() {
        jj_la1_1 = new int[]{};
    }

    private  void jj_la1_init_2() {
        jj_la1_2 = new int[]{};
    }

     private JJCalls[] jj_2_rtns = new JJCalls[98];
     private boolean jj_rescan = false;
     private int jj_gc = 0;

    public JPascal(InputStream stream) {
        this(stream, null);
    }

    public JPascal(InputStream stream, String encoding) {
        try {
            jj_input_stream = new SimpleCharStream(stream, encoding, 1, 1);
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
        token_source = new JPascalTokenManager(jj_input_stream);
        token = new Token();
        jj_ntk = -1;
        jj_gen = 0;
        for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
    }

    /**
     * Reinitialise.
     */
     public void ReInit(InputStream stream) {
        ReInit(stream, (String) null);
    }

    /**
     * Reinitialise.
     */
     public void ReInit(InputStream stream, String encoding) {
        try {
            jj_input_stream.ReInit(stream, encoding, 1, 1);
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
        token_source.ReInit(jj_input_stream);
        token = new Token();
        jj_ntk = -1;
        jj_gen = 0;
        for (int i = 0; i < 0; i++) jj_la1[i] = -1;
        for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
    }

    public JPascal(Reader stream) {
        jj_input_stream = new SimpleCharStream(stream, 1, 1);
        token_source = new JPascalTokenManager(jj_input_stream);
        token = new Token();
        jj_ntk = -1;
        jj_gen = 0;
        for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
    }

    /**
     * Reinitialise.
     */
     public void ReInit(Reader stream) {
        jj_input_stream.ReInit(stream, 1, 1);
        token_source.ReInit(jj_input_stream);
        token = new Token();
        jj_ntk = -1;
        jj_gen = 0;
        for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
    }

    /**
     * Constructor with generated Token Manager.
     */
    public JPascal(JPascalTokenManager tm) {
        token_source = tm;
        token = new Token();
        jj_ntk = -1;
        jj_gen = 0;
        for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
    }

    /**
     * Reinitialise.
     */
    public void ReInit(JPascalTokenManager tm) {
        token_source = tm;
        token = new Token();
        jj_ntk = -1;
        jj_gen = 0;
        for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
    }

     private Token jj_consume_token(int kind) throws ParseException {
        Token oldToken;
        if ((oldToken = token).next != null) token = token.next;
        else token = token.next = token_source.getNextToken();
        jj_ntk = -1;
        if (token.kind == kind) {
            jj_gen++;
            if (++jj_gc > 100) {
                jj_gc = 0;
                for (int i = 0; i < jj_2_rtns.length; i++) {
                    JJCalls c = jj_2_rtns[i];
                    while (c != null) {
                        if (c.gen < jj_gen) c.first = null;
                        c = c.next;
                    }
                }
            }
            return token;
        }
        token = oldToken;
        jj_kind = kind;
        throw generateParseException();
    }

    @SuppressWarnings("serial")
     private final class LookaheadSuccess extends Error {
    }

     private LookaheadSuccess jj_ls = new LookaheadSuccess();

     private boolean jj_scan_token(int kind) {
        if (jj_scanpos == jj_lastpos) {
            jj_la--;
            if (jj_scanpos.next == null) {
                jj_lastpos = jj_scanpos = jj_scanpos.next = token_source.getNextToken();
            } else {
                jj_lastpos = jj_scanpos = jj_scanpos.next;
            }
        } else {
            jj_scanpos = jj_scanpos.next;
        }
        if (jj_rescan) {
            int i = 0;
            Token tok = token;
            while (tok != null && tok != jj_scanpos) {
                i++;
                tok = tok.next;
            }
            if (tok != null) jj_add_error_token(kind, i);
        }
        if (jj_scanpos.kind != kind) return true;
        if (jj_la == 0 && jj_scanpos == jj_lastpos) throw jj_ls;
        return false;
    }


    /**
     * Get the next Token.
     */
     public Token getNextToken() {
        if (token.next != null) token = token.next;
        else token = token.next = token_source.getNextToken();
        jj_ntk = -1;
        jj_gen++;
        return token;
    }

    /**
     * Get the specific Token.
     */
     public Token getToken(int index) {
        Token t = token;
        for (int i = 0; i < index; i++) {
            if (t.next != null) t = t.next;
            else t = t.next = token_source.getNextToken();
        }
        return t;
    }

     private int jj_ntk_f() {
        if ((jj_nt = token.next) == null)
            return (jj_ntk = (token.next = token_source.getNextToken()).kind);
        else
            return (jj_ntk = jj_nt.kind);
    }

     private java.util.List<int[]> jj_expentries = new java.util.ArrayList<int[]>();
     private int[] jj_expentry;
     private int jj_kind = -1;
     private int[] jj_lasttokens = new int[100];
     private int jj_endpos;

     private void jj_add_error_token(int kind, int pos) {
        if (pos >= 100) return;
        if (pos == jj_endpos + 1) {
            jj_lasttokens[jj_endpos++] = kind;
        } else if (jj_endpos != 0) {
            jj_expentry = new int[jj_endpos];
            for (int i = 0; i < jj_endpos; i++) {
                jj_expentry[i] = jj_lasttokens[i];
            }
            jj_entries_loop:
            for (java.util.Iterator<?> it = jj_expentries.iterator(); it.hasNext(); ) {
                int[] oldentry = (int[]) (it.next());
                if (oldentry.length == jj_expentry.length) {
                    for (int i = 0; i < jj_expentry.length; i++) {
                        if (oldentry[i] != jj_expentry[i]) {
                            continue jj_entries_loop;
                        }
                    }
                    jj_expentries.add(jj_expentry);
                    break jj_entries_loop;
                }
            }
            if (pos != 0) jj_lasttokens[(jj_endpos = pos) - 1] = kind;
        }
    }

    /**
     * Generate ParseException.
     */
     public ParseException generateParseException() {
        jj_expentries.clear();
        boolean[] la1tokens = new boolean[88];
        if (jj_kind >= 0) {
            la1tokens[jj_kind] = true;
            jj_kind = -1;
        }
        for (int i = 0; i < 0; i++) {
            if (jj_la1[i] == jj_gen) {
                for (int j = 0; j < 32; j++) {
                    if ((jj_la1_0[i] & (1 << j)) != 0) {
                        la1tokens[j] = true;
                    }
                    if ((jj_la1_1[i] & (1 << j)) != 0) {
                        la1tokens[32 + j] = true;
                    }
                    if ((jj_la1_2[i] & (1 << j)) != 0) {
                        la1tokens[64 + j] = true;
                    }
                }
            }
        }
        for (int i = 0; i < 88; i++) {
            if (la1tokens[i]) {
                jj_expentry = new int[1];
                jj_expentry[0] = i;
                jj_expentries.add(jj_expentry);
            }
        }
        jj_endpos = 0;
        jj_rescan_token();
        jj_add_error_token(0, 0);
        int[][] exptokseq = new int[jj_expentries.size()][];
        for (int i = 0; i < jj_expentries.size(); i++) {
            exptokseq[i] = jj_expentries.get(i);
        }
        return new ParseException(token, exptokseq, tokenImage);
    }

    /**
     * Enable tracing.
     */
     public void enable_tracing() {
    }

    /**
     * Disable tracing.
     */
     public void disable_tracing() {
    }

     private void jj_rescan_token() {
        jj_rescan = true;
        for (int i = 0; i < 98; i++) {
            try {
                JJCalls p = jj_2_rtns[i];
                do {
                    if (p.gen > jj_gen) {
                        jj_la = p.arg;
                        jj_lastpos = jj_scanpos = p.first;
                        switch (i) {
                            case 0:
                                jj_3_1();
                                break;
                            case 1:
                                jj_3_2();
                                break;
                            case 2:
                                jj_3_3();
                                break;
                            case 3:
                                jj_3_4();
                                break;
                            case 4:
                                jj_3_5();
                                break;
                            case 5:
                                jj_3_6();
                                break;
                            case 6:
                                jj_3_7();
                                break;
                            case 7:
                                jj_3_8();
                                break;
                            case 8:
                                jj_3_9();
                                break;
                            case 9:
                                jj_3_10();
                                break;
                            case 10:
                                jj_3_11();
                                break;
                            case 11:
                                jj_3_12();
                                break;
                            case 12:
                                jj_3_13();
                                break;
                            case 13:
                                jj_3_14();
                                break;
                            case 14:
                                jj_3_15();
                                break;
                            case 15:
                                jj_3_16();
                                break;
                            case 16:
                                jj_3_17();
                                break;
                            case 17:
                                jj_3_18();
                                break;
                            case 18:
                                jj_3_19();
                                break;
                            case 19:
                                jj_3_20();
                                break;
                            case 20:
                                jj_3_21();
                                break;
                            case 21:
                                jj_3_22();
                                break;
                            case 22:
                                jj_3_23();
                                break;
                            case 23:
                                jj_3_24();
                                break;
                            case 24:
                                jj_3_25();
                                break;
                            case 25:
                                jj_3_26();
                                break;
                            case 26:
                                jj_3_27();
                                break;
                            case 27:
                                jj_3_28();
                                break;
                            case 28:
                                jj_3_29();
                                break;
                            case 29:
                                jj_3_30();
                                break;
                            case 30:
                                jj_3_31();
                                break;
                            case 31:
                                jj_3_32();
                                break;
                            case 32:
                                jj_3_33();
                                break;
                            case 33:
                                jj_3_34();
                                break;
                            case 34:
                                jj_3_35();
                                break;
                            case 35:
                                jj_3_36();
                                break;
                            case 36:
                                jj_3_37();
                                break;
                            case 37:
                                jj_3_38();
                                break;
                            case 38:
                                jj_3_39();
                                break;
                            case 39:
                                jj_3_40();
                                break;
                            case 40:
                                jj_3_41();
                                break;
                            case 41:
                                jj_3_42();
                                break;
                            case 42:
                                jj_3_43();
                                break;
                            case 43:
                                jj_3_44();
                                break;
                            case 44:
                                jj_3_45();
                                break;
                            case 45:
                                jj_3_46();
                                break;
                            case 46:
                                jj_3_47();
                                break;
                            case 47:
                                jj_3_48();
                                break;
                            case 48:
                                jj_3_49();
                                break;
                            case 49:
                                jj_3_50();
                                break;
                            case 50:
                                jj_3_51();
                                break;
                            case 51:
                                jj_3_52();
                                break;
                            case 52:
                                jj_3_53();
                                break;
                            case 53:
                                jj_3_54();
                                break;
                            case 54:
                                jj_3_55();
                                break;
                            case 55:
                                jj_3_56();
                                break;
                            case 56:
                                jj_3_57();
                                break;
                            case 57:
                                jj_3_58();
                                break;
                            case 58:
                                jj_3_59();
                                break;
                            case 59:
                                jj_3_60();
                                break;
                            case 60:
                                jj_3_61();
                                break;
                            case 61:
                                jj_3_62();
                                break;
                            case 62:
                                jj_3_63();
                                break;
                            case 63:
                                jj_3_64();
                                break;
                            case 64:
                                jj_3_65();
                                break;
                            case 65:
                                jj_3_66();
                                break;
                            case 66:
                                jj_3_67();
                                break;
                            case 67:
                                jj_3_68();
                                break;
                            case 68:
                                jj_3_69();
                                break;
                            case 69:
                                jj_3_70();
                                break;
                            case 70:
                                jj_3_71();
                                break;
                            case 71:
                                jj_3_72();
                                break;
                            case 72:
                                jj_3_73();
                                break;
                            case 73:
                                jj_3_74();
                                break;
                            case 74:
                                jj_3_75();
                                break;
                            case 75:
                                jj_3_76();
                                break;
                            case 76:
                                jj_3_77();
                                break;
                            case 77:
                                jj_3_78();
                                break;
                            case 78:
                                jj_3_79();
                                break;
                            case 79:
                                jj_3_80();
                                break;
                            case 80:
                                jj_3_81();
                                break;
                            case 81:
                                jj_3_82();
                                break;
                            case 82:
                                jj_3_83();
                                break;
                            case 83:
                                jj_3_84();
                                break;
                            case 84:
                                jj_3_85();
                                break;
                            case 85:
                                jj_3_86();
                                break;
                            case 86:
                                jj_3_87();
                                break;
                            case 87:
                                jj_3_88();
                                break;
                            case 88:
                                jj_3_89();
                                break;
                            case 89:
                                jj_3_90();
                                break;
                            case 90:
                                jj_3_91();
                                break;
                            case 91:
                                jj_3_92();
                                break;
                            case 92:
                                jj_3_93();
                                break;
                            case 93:
                                jj_3_94();
                                break;
                            case 94:
                                jj_3_95();
                                break;
                            case 95:
                                jj_3_96();
                                break;
                            case 96:
                                jj_3_97();
                                break;
                            case 97:
                                jj_3_98();
                                break;
                        }
                    }
                    p = p.next;
                } while (p != null);
            } catch (LookaheadSuccess ls) {
            }
        }
        jj_rescan = false;
    }

    private void jj_save(int index, int xla) {
        JJCalls p = jj_2_rtns[index];
        while (p.gen > jj_gen) {
            if (p.next == null) {
                p = p.next = new JJCalls();
                break;
            }
            p = p.next;
        }
        p.gen = jj_gen + xla - jj_la;
        p.first = token;
        p.arg = xla;
    }

     class JJCalls {
        int gen;
        Token first;
        int arg;
        JJCalls next;
    }
}
