package by.bsu.project.antlr.parser.pascal;// $ANTLR 3.4 pascal3g.g 2015-01-27 10:33:05

import org.antlr.runtime.*;

@SuppressWarnings({"all", "warnings", "unchecked"})
public class PascalLexer extends Lexer {
    public static final int EOF=-1;
    public static final int AND=4;
    public static final int ARGDECL=5;
    public static final int ARGDECLS=6;
    public static final int ARGLIST=7;
    public static final int ARRAY=8;
    public static final int ASSIGN=9;
    public static final int AT=10;
    public static final int BEGIN=11;
    public static final int BLOCK=12;
    public static final int BOOLEAN=13;
    public static final int CASE=14;
    public static final int CHAR=15;
    public static final int CHR=16;
    public static final int COLON=17;
    public static final int COMMA=18;
    public static final int COMMENT_1=19;
    public static final int COMMENT_2=20;
    public static final int CONST=21;
    public static final int CONSTLIST=22;
    public static final int DIV=23;
    public static final int DO=24;
    public static final int DOT=25;
    public static final int DOTDOT=26;
    public static final int DOWNTO=27;
    public static final int ELIST=28;
    public static final int ELSE=29;
    public static final int END=30;
    public static final int EQUAL=31;
    public static final int EXIT=32;
    public static final int EXPONENT=33;
    public static final int FIELD=34;
    public static final int FIELDLIST=35;
    public static final int FILE=36;
    public static final int FOR=37;
    public static final int FORWARD=38;
    public static final int FUNCTION=39;
    public static final int FUNC_CALL=40;
    public static final int GE=41;
    public static final int GOTO=42;
    public static final int GT=43;
    public static final int IDENT=44;
    public static final int IDLIST=45;
    public static final int IF=46;
    public static final int IMPLEMENTATION=47;
    public static final int IN=48;
    public static final int INTEGER=49;
    public static final int INTERFACE=50;
    public static final int LABEL=51;
    public static final int LBRACK=52;
    public static final int LBRACK2=53;
    public static final int LCURLY=54;
    public static final int LE=55;
    public static final int LPAREN=56;
    public static final int LT=57;
    public static final int MINUS=58;
    public static final int MOD=59;
    public static final int NIL=60;
    public static final int NOT=61;
    public static final int NOT_EQUAL=62;
    public static final int NUM_INT=63;
    public static final int NUM_REAL=64;
    public static final int OF=65;
    public static final int OR=66;
    public static final int PACKED=67;
    public static final int PLUS=68;
    public static final int POINTER=69;
    public static final int PROCEDURE=70;
    public static final int PROC_CALL=71;
    public static final int PROGRAM=72;
    public static final int RBRACK=73;
    public static final int RBRACK2=74;
    public static final int RCURLY=75;
    public static final int REAL=76;
    public static final int RECORD=77;
    public static final int REPEAT=78;
    public static final int RPAREN=79;
    public static final int SCALARTYPE=80;
    public static final int SEMI=81;
    public static final int SET=82;
    public static final int SLASH=83;
    public static final int STAR=84;
    public static final int STRING=85;
    public static final int STRING_LITERAL=86;
    public static final int SUBRANGE=87;
    public static final int THEN=88;
    public static final int TO=89;
    public static final int TYPE=90;
    public static final int TYPEDECL=91;
    public static final int TYPELIST=92;
    public static final int UNIT=93;
    public static final int UNTIL=94;
    public static final int USES=95;
    public static final int VAR=96;
    public static final int VARDECL=97;
    public static final int VARIANT_CASE=98;
    public static final int VARIANT_TAG=99;
    public static final int VARIANT_TAG_NO_ID=100;
    public static final int WHILE=101;
    public static final int WITH=102;
    public static final int WS=103;

    // delegates
    // delegators
    public Lexer[] getDelegates() {
        return new Lexer[] {};
    }

    public PascalLexer() {}
    public PascalLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public PascalLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);
    }
    public String getGrammarFileName() { return "pascal3g.g"; }

    // $ANTLR start "AND"
    public final void mAND() throws RecognitionException {
        try {
            int _type = AND;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // pascal3g.g:2:5: ( 'and' )
            // pascal3g.g:2:7: 'and'
            {
            match("and"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "AND"

    // $ANTLR start "ARRAY"
    public final void mARRAY() throws RecognitionException {
        try {
            int _type = ARRAY;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // pascal3g.g:3:7: ( 'array' )
            // pascal3g.g:3:9: 'array'
            {
            match("array"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "ARRAY"

    // $ANTLR start "ASSIGN"
    public final void mASSIGN() throws RecognitionException {
        try {
            int _type = ASSIGN;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // pascal3g.g:4:8: ( ':=' )
            // pascal3g.g:4:10: ':='
            {
            match(":="); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "ASSIGN"

    // $ANTLR start "AT"
    public final void mAT() throws RecognitionException {
        try {
            int _type = AT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // pascal3g.g:5:4: ( '@' )
            // pascal3g.g:5:6: '@'
            {
            match('@'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "AT"

    // $ANTLR start "BEGIN"
    public final void mBEGIN() throws RecognitionException {
        try {
            int _type = BEGIN;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // pascal3g.g:6:7: ( 'begin' )
            // pascal3g.g:6:9: 'begin'
            {
            match("begin"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "BEGIN"

    // $ANTLR start "BOOLEAN"
    public final void mBOOLEAN() throws RecognitionException {
        try {
            int _type = BOOLEAN;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // pascal3g.g:7:9: ( 'boolean' )
            // pascal3g.g:7:11: 'boolean'
            {
            match("boolean"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "BOOLEAN"

    // $ANTLR start "CASE"
    public final void mCASE() throws RecognitionException {
        try {
            int _type = CASE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // pascal3g.g:8:6: ( 'case' )
            // pascal3g.g:8:8: 'case'
            {
            match("case"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "CASE"

    // $ANTLR start "CHAR"
    public final void mCHAR() throws RecognitionException {
        try {
            int _type = CHAR;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // pascal3g.g:9:6: ( 'char' )
            // pascal3g.g:9:8: 'char'
            {
            match("char"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "CHAR"

    // $ANTLR start "CHR"
    public final void mCHR() throws RecognitionException {
        try {
            int _type = CHR;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // pascal3g.g:10:5: ( 'chr' )
            // pascal3g.g:10:7: 'chr'
            {
            match("chr"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "CHR"

    // $ANTLR start "COLON"
    public final void mCOLON() throws RecognitionException {
        try {
            int _type = COLON;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // pascal3g.g:11:7: ( ':' )
            // pascal3g.g:11:9: ':'
            {
            match(':'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "COLON"

    // $ANTLR start "COMMA"
    public final void mCOMMA() throws RecognitionException {
        try {
            int _type = COMMA;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // pascal3g.g:12:7: ( ',' )
            // pascal3g.g:12:9: ','
            {
            match(','); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "COMMA"

    // $ANTLR start "CONST"
    public final void mCONST() throws RecognitionException {
        try {
            int _type = CONST;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // pascal3g.g:13:7: ( 'const' )
            // pascal3g.g:13:9: 'const'
            {
            match("const"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "CONST"

    // $ANTLR start "DIV"
    public final void mDIV() throws RecognitionException {
        try {
            int _type = DIV;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // pascal3g.g:14:5: ( 'div' )
            // pascal3g.g:14:7: 'div'
            {
            match("div"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "DIV"

    // $ANTLR start "DO"
    public final void mDO() throws RecognitionException {
        try {
            int _type = DO;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // pascal3g.g:15:4: ( 'do' )
            // pascal3g.g:15:6: 'do'
            {
            match("do"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "DO"

    // $ANTLR start "DOT"
    public final void mDOT() throws RecognitionException {
        try {
            int _type = DOT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // pascal3g.g:16:5: ( '.' )
            // pascal3g.g:16:7: '.'
            {
            match('.'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "DOT"

    // $ANTLR start "DOTDOT"
    public final void mDOTDOT() throws RecognitionException {
        try {
            int _type = DOTDOT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // pascal3g.g:17:8: ( '..' )
            // pascal3g.g:17:10: '..'
            {
            match(".."); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "DOTDOT"

    // $ANTLR start "DOWNTO"
    public final void mDOWNTO() throws RecognitionException {
        try {
            int _type = DOWNTO;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // pascal3g.g:18:8: ( 'downto' )
            // pascal3g.g:18:10: 'downto'
            {
            match("downto"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "DOWNTO"

    // $ANTLR start "ELSE"
    public final void mELSE() throws RecognitionException {
        try {
            int _type = ELSE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // pascal3g.g:19:6: ( 'else' )
            // pascal3g.g:19:8: 'else'
            {
            match("else"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "ELSE"

    // $ANTLR start "END"
    public final void mEND() throws RecognitionException {
        try {
            int _type = END;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // pascal3g.g:20:5: ( 'end' )
            // pascal3g.g:20:7: 'end'
            {
            match("end"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "END"

    // $ANTLR start "EQUAL"
    public final void mEQUAL() throws RecognitionException {
        try {
            int _type = EQUAL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // pascal3g.g:21:7: ( '=' )
            // pascal3g.g:21:9: '='
            {
            match('='); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "EQUAL"

    // $ANTLR start "EXIT"
    public final void mEXIT() throws RecognitionException {
        try {
            int _type = EXIT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // pascal3g.g:22:6: ( 'exit' )
            // pascal3g.g:22:8: 'exit'
            {
            match("exit"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "EXIT"

    // $ANTLR start "FILE"
    public final void mFILE() throws RecognitionException {
        try {
            int _type = FILE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // pascal3g.g:23:6: ( 'file' )
            // pascal3g.g:23:8: 'file'
            {
            match("file"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "FILE"

    // $ANTLR start "FOR"
    public final void mFOR() throws RecognitionException {
        try {
            int _type = FOR;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // pascal3g.g:24:5: ( 'for' )
            // pascal3g.g:24:7: 'for'
            {
            match("for"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "FOR"

    // $ANTLR start "FORWARD"
    public final void mFORWARD() throws RecognitionException {
        try {
            int _type = FORWARD;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // pascal3g.g:25:9: ( 'forward' )
            // pascal3g.g:25:11: 'forward'
            {
            match("forward"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "FORWARD"

    // $ANTLR start "FUNCTION"
    public final void mFUNCTION() throws RecognitionException {
        try {
            int _type = FUNCTION;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // pascal3g.g:26:10: ( 'function' )
            // pascal3g.g:26:12: 'function'
            {
            match("function"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "FUNCTION"

    // $ANTLR start "GE"
    public final void mGE() throws RecognitionException {
        try {
            int _type = GE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // pascal3g.g:27:4: ( '>=' )
            // pascal3g.g:27:6: '>='
            {
            match(">="); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "GE"

    // $ANTLR start "GOTO"
    public final void mGOTO() throws RecognitionException {
        try {
            int _type = GOTO;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // pascal3g.g:28:6: ( 'goto' )
            // pascal3g.g:28:8: 'goto'
            {
            match("goto"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "GOTO"

    // $ANTLR start "GT"
    public final void mGT() throws RecognitionException {
        try {
            int _type = GT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // pascal3g.g:29:4: ( '>' )
            // pascal3g.g:29:6: '>'
            {
            match('>'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "GT"

    // $ANTLR start "IF"
    public final void mIF() throws RecognitionException {
        try {
            int _type = IF;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // pascal3g.g:30:4: ( 'if' )
            // pascal3g.g:30:6: 'if'
            {
            match("if"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "IF"

    // $ANTLR start "IMPLEMENTATION"
    public final void mIMPLEMENTATION() throws RecognitionException {
        try {
            int _type = IMPLEMENTATION;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // pascal3g.g:31:16: ( 'implementation' )
            // pascal3g.g:31:18: 'implementation'
            {
            match("implementation"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "IMPLEMENTATION"

    // $ANTLR start "IN"
    public final void mIN() throws RecognitionException {
        try {
            int _type = IN;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // pascal3g.g:32:4: ( 'in' )
            // pascal3g.g:32:6: 'in'
            {
            match("in"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "IN"

    // $ANTLR start "INTEGER"
    public final void mINTEGER() throws RecognitionException {
        try {
            int _type = INTEGER;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // pascal3g.g:33:9: ( 'integer' )
            // pascal3g.g:33:11: 'integer'
            {
            match("integer"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "INTEGER"

    // $ANTLR start "INTERFACE"
    public final void mINTERFACE() throws RecognitionException {
        try {
            int _type = INTERFACE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // pascal3g.g:34:11: ( 'interface' )
            // pascal3g.g:34:13: 'interface'
            {
            match("interface"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "INTERFACE"

    // $ANTLR start "LABEL"
    public final void mLABEL() throws RecognitionException {
        try {
            int _type = LABEL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // pascal3g.g:35:7: ( 'label' )
            // pascal3g.g:35:9: 'label'
            {
            match("label"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "LABEL"

    // $ANTLR start "LBRACK"
    public final void mLBRACK() throws RecognitionException {
        try {
            int _type = LBRACK;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // pascal3g.g:36:8: ( '[' )
            // pascal3g.g:36:10: '['
            {
            match('['); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "LBRACK"

    // $ANTLR start "LBRACK2"
    public final void mLBRACK2() throws RecognitionException {
        try {
            int _type = LBRACK2;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // pascal3g.g:37:9: ( '(.' )
            // pascal3g.g:37:11: '(.'
            {
            match("(."); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "LBRACK2"

    // $ANTLR start "LCURLY"
    public final void mLCURLY() throws RecognitionException {
        try {
            int _type = LCURLY;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // pascal3g.g:38:8: ( '{' )
            // pascal3g.g:38:10: '{'
            {
            match('{'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "LCURLY"

    // $ANTLR start "LE"
    public final void mLE() throws RecognitionException {
        try {
            int _type = LE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // pascal3g.g:39:4: ( '<=' )
            // pascal3g.g:39:6: '<='
            {
            match("<="); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "LE"

    // $ANTLR start "LPAREN"
    public final void mLPAREN() throws RecognitionException {
        try {
            int _type = LPAREN;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // pascal3g.g:40:8: ( '(' )
            // pascal3g.g:40:10: '('
            {
            match('('); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "LPAREN"

    // $ANTLR start "LT"
    public final void mLT() throws RecognitionException {
        try {
            int _type = LT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // pascal3g.g:41:4: ( '<' )
            // pascal3g.g:41:6: '<'
            {
            match('<'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "LT"

    // $ANTLR start "MINUS"
    public final void mMINUS() throws RecognitionException {
        try {
            int _type = MINUS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // pascal3g.g:42:7: ( '-' )
            // pascal3g.g:42:9: '-'
            {
            match('-'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "MINUS"

    // $ANTLR start "MOD"
    public final void mMOD() throws RecognitionException {
        try {
            int _type = MOD;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // pascal3g.g:43:5: ( 'mod' )
            // pascal3g.g:43:7: 'mod'
            {
            match("mod"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "MOD"

    // $ANTLR start "NIL"
    public final void mNIL() throws RecognitionException {
        try {
            int _type = NIL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // pascal3g.g:44:5: ( 'nil' )
            // pascal3g.g:44:7: 'nil'
            {
            match("nil"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "NIL"

    // $ANTLR start "NOT"
    public final void mNOT() throws RecognitionException {
        try {
            int _type = NOT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // pascal3g.g:45:5: ( 'not' )
            // pascal3g.g:45:7: 'not'
            {
            match("not"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "NOT"

    // $ANTLR start "NOT_EQUAL"
    public final void mNOT_EQUAL() throws RecognitionException {
        try {
            int _type = NOT_EQUAL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // pascal3g.g:46:11: ( '<>' )
            // pascal3g.g:46:13: '<>'
            {
            match("<>"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "NOT_EQUAL"

    // $ANTLR start "OF"
    public final void mOF() throws RecognitionException {
        try {
            int _type = OF;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // pascal3g.g:47:4: ( 'of' )
            // pascal3g.g:47:6: 'of'
            {
            match("of"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "OF"

    // $ANTLR start "OR"
    public final void mOR() throws RecognitionException {
        try {
            int _type = OR;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // pascal3g.g:48:4: ( 'or' )
            // pascal3g.g:48:6: 'or'
            {
            match("or"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "OR"

    // $ANTLR start "PACKED"
    public final void mPACKED() throws RecognitionException {
        try {
            int _type = PACKED;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // pascal3g.g:49:8: ( 'packed' )
            // pascal3g.g:49:10: 'packed'
            {
            match("packed"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "PACKED"

    // $ANTLR start "PLUS"
    public final void mPLUS() throws RecognitionException {
        try {
            int _type = PLUS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // pascal3g.g:50:6: ( '+' )
            // pascal3g.g:50:8: '+'
            {
            match('+'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "PLUS"

    // $ANTLR start "POINTER"
    public final void mPOINTER() throws RecognitionException {
        try {
            int _type = POINTER;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // pascal3g.g:51:9: ( '^' )
            // pascal3g.g:51:11: '^'
            {
            match('^'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "POINTER"

    // $ANTLR start "PROCEDURE"
    public final void mPROCEDURE() throws RecognitionException {
        try {
            int _type = PROCEDURE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // pascal3g.g:52:11: ( 'procedure' )
            // pascal3g.g:52:13: 'procedure'
            {
            match("procedure"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "PROCEDURE"

    // $ANTLR start "PROGRAM"
    public final void mPROGRAM() throws RecognitionException {
        try {
            int _type = PROGRAM;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // pascal3g.g:53:9: ( 'program' )
            // pascal3g.g:53:11: 'program'
            {
            match("program");



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "PROGRAM"

    // $ANTLR start "RBRACK"
    public final void mRBRACK() throws RecognitionException {
        try {
            int _type = RBRACK;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // pascal3g.g:54:8: ( ']' )
            // pascal3g.g:54:10: ']'
            {
            match(']'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "RBRACK"

    // $ANTLR start "RBRACK2"
    public final void mRBRACK2() throws RecognitionException {
        try {
            int _type = RBRACK2;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // pascal3g.g:55:9: ( '.)' )
            // pascal3g.g:55:11: '.)'
            {
            match(".)"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "RBRACK2"

    // $ANTLR start "RCURLY"
    public final void mRCURLY() throws RecognitionException {
        try {
            int _type = RCURLY;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // pascal3g.g:56:8: ( '}' )
            // pascal3g.g:56:10: '}'
            {
            match('}'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "RCURLY"

    // $ANTLR start "REAL"
    public final void mREAL() throws RecognitionException {
        try {
            int _type = REAL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // pascal3g.g:57:6: ( 'real' )
            // pascal3g.g:57:8: 'real'
            {
            match("real"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "REAL"

    // $ANTLR start "RECORD"
    public final void mRECORD() throws RecognitionException {
        try {
            int _type = RECORD;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // pascal3g.g:58:8: ( 'record' )
            // pascal3g.g:58:10: 'record'
            {
            match("record"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "RECORD"

    // $ANTLR start "REPEAT"
    public final void mREPEAT() throws RecognitionException {
        try {
            int _type = REPEAT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // pascal3g.g:59:8: ( 'repeat' )
            // pascal3g.g:59:10: 'repeat'
            {
            match("repeat"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "REPEAT"

    // $ANTLR start "RPAREN"
    public final void mRPAREN() throws RecognitionException {
        try {
            int _type = RPAREN;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // pascal3g.g:60:8: ( ')' )
            // pascal3g.g:60:10: ')'
            {
            match(')'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "RPAREN"

    // $ANTLR start "SEMI"
    public final void mSEMI() throws RecognitionException {
        try {
            int _type = SEMI;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // pascal3g.g:61:6: ( ';' )
            // pascal3g.g:61:8: ';'
            {
            match(';'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "SEMI"

    // $ANTLR start "SET"
    public final void mSET() throws RecognitionException {
        try {
            int _type = SET;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // pascal3g.g:62:5: ( 'set' )
            // pascal3g.g:62:7: 'set'
            {
            match("set"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "SET"

    // $ANTLR start "SLASH"
    public final void mSLASH() throws RecognitionException {
        try {
            int _type = SLASH;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // pascal3g.g:63:7: ( '/' )
            // pascal3g.g:63:9: '/'
            {
            match('/'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "SLASH"

    // $ANTLR start "STAR"
    public final void mSTAR() throws RecognitionException {
        try {
            int _type = STAR;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // pascal3g.g:64:6: ( '*' )
            // pascal3g.g:64:8: '*'
            {
            match('*'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "STAR"

    // $ANTLR start "STRING"
    public final void mSTRING() throws RecognitionException {
        try {
            int _type = STRING;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // pascal3g.g:65:8: ( 'string' )
            // pascal3g.g:65:10: 'string'
            {
            match("string"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "STRING"

    // $ANTLR start "THEN"
    public final void mTHEN() throws RecognitionException {
        try {
            int _type = THEN;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // pascal3g.g:66:6: ( 'then' )
            // pascal3g.g:66:8: 'then'
            {
            match("then"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "THEN"

    // $ANTLR start "TO"
    public final void mTO() throws RecognitionException {
        try {
            int _type = TO;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // pascal3g.g:67:4: ( 'to' )
            // pascal3g.g:67:6: 'to'
            {
            match("to"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "TO"

    // $ANTLR start "TYPE"
    public final void mTYPE() throws RecognitionException {
        try {
            int _type = TYPE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // pascal3g.g:68:6: ( 'type' )
            // pascal3g.g:68:8: 'type'
            {
            match("type"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "TYPE"

    // $ANTLR start "UNIT"
    public final void mUNIT() throws RecognitionException {
        try {
            int _type = UNIT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // pascal3g.g:69:6: ( 'unit' )
            // pascal3g.g:69:8: 'unit'
            {
            match("unit"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "UNIT"

    // $ANTLR start "UNTIL"
    public final void mUNTIL() throws RecognitionException {
        try {
            int _type = UNTIL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // pascal3g.g:70:7: ( 'until' )
            // pascal3g.g:70:9: 'until'
            {
            match("until"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "UNTIL"

    // $ANTLR start "USES"
    public final void mUSES() throws RecognitionException {
        try {
            int _type = USES;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // pascal3g.g:71:6: ( 'uses' )
            // pascal3g.g:71:8: 'uses'
            {
            match("uses"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "USES"

    // $ANTLR start "VAR"
    public final void mVAR() throws RecognitionException {
        try {
            int _type = VAR;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // pascal3g.g:72:5: ( 'var' )
            // pascal3g.g:72:7: 'var'
            {
            match("var"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "VAR"

    // $ANTLR start "WHILE"
    public final void mWHILE() throws RecognitionException {
        try {
            int _type = WHILE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // pascal3g.g:73:7: ( 'while' )
            // pascal3g.g:73:9: 'while'
            {
            match("while"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "WHILE"

    // $ANTLR start "WITH"
    public final void mWITH() throws RecognitionException {
        try {
            int _type = WITH;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // pascal3g.g:74:6: ( 'with' )
            // pascal3g.g:74:8: 'with'
            {
            match("with"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "WITH"

    // $ANTLR start "WS"
    public final void mWS() throws RecognitionException {
        try {
            int _type = WS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // pascal3g.g:702:9: ( ( ' ' | '\\t' | '\\f' | ( '\\r\\n' | '\\r' | '\\n' ) ) )
            // pascal3g.g:702:11: ( ' ' | '\\t' | '\\f' | ( '\\r\\n' | '\\r' | '\\n' ) )
            {
            // pascal3g.g:702:11: ( ' ' | '\\t' | '\\f' | ( '\\r\\n' | '\\r' | '\\n' ) )
            int alt2=4;
            switch ( input.LA(1) ) {
            case ' ':
                {
                alt2=1;
                }
                break;
            case '\t':
                {
                alt2=2;
                }
                break;
            case '\f':
                {
                alt2=3;
                }
                break;
            case '\n':
            case '\r':
                {
                alt2=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;

            }

            switch (alt2) {
                case 1 :
                    // pascal3g.g:702:13: ' '
                    {
                    match(' '); 

                    }
                    break;
                case 2 :
                    // pascal3g.g:703:8: '\\t'
                    {
                    match('\t'); 

                    }
                    break;
                case 3 :
                    // pascal3g.g:704:8: '\\f'
                    {
                    match('\f'); 

                    }
                    break;
                case 4 :
                    // pascal3g.g:706:8: ( '\\r\\n' | '\\r' | '\\n' )
                    {
                    // pascal3g.g:706:8: ( '\\r\\n' | '\\r' | '\\n' )
                    int alt1=3;
                    int LA1_0 = input.LA(1);

                    if ( (LA1_0=='\r') ) {
                        int LA1_1 = input.LA(2);

                        if ( (LA1_1=='\n') ) {
                            alt1=1;
                        }
                        else {
                            alt1=2;
                        }
                    }
                    else if ( (LA1_0=='\n') ) {
                        alt1=3;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 1, 0, input);

                        throw nvae;

                    }
                    switch (alt1) {
                        case 1 :
                            // pascal3g.g:706:11: '\\r\\n'
                            {
                            match("\r\n"); 



                            }
                            break;
                        case 2 :
                            // pascal3g.g:707:10: '\\r'
                            {
                            match('\r'); 

                            }
                            break;
                        case 3 :
                            // pascal3g.g:708:10: '\\n'
                            {
                            match('\n'); 

                            }
                            break;

                    }


                      

                    }
                    break;

            }


             _channel=HIDDEN; 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "WS"

    // $ANTLR start "COMMENT_1"
    public final void mCOMMENT_1() throws RecognitionException {
        try {
            int _type = COMMENT_1;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // pascal3g.g:716:9: ( '(*' ({...}? => '*' |~ ( '*' ) )* '*)' )
            // pascal3g.g:716:13: '(*' ({...}? => '*' |~ ( '*' ) )* '*)'
            {
            match("(*"); 



            // pascal3g.g:717:8: ({...}? => '*' |~ ( '*' ) )*
            loop3:
            do {
                int alt3=3;
                int LA3_0 = input.LA(1);

                if ( (LA3_0=='*') ) {
                    int LA3_1 = input.LA(2);

                    if ( (LA3_1==')') ) {
                        int LA3_3 = input.LA(3);

                        if ( ((LA3_3 >= '\u0000' && LA3_3 <= '\uFFFF')) && (( input.LA(2) != ')' ))) {
                            alt3=1;
                        }


                    }
                    else if ( ((LA3_1 >= '\u0000' && LA3_1 <= '(')||(LA3_1 >= '*' && LA3_1 <= '\uFFFF')) && (( input.LA(2) != ')' ))) {
                        alt3=1;
                    }


                }
                else if ( ((LA3_0 >= '\u0000' && LA3_0 <= ')')||(LA3_0 >= '+' && LA3_0 <= '\uFFFF')) ) {
                    alt3=2;
                }


                switch (alt3) {
            	case 1 :
            	    // pascal3g.g:720:10: {...}? => '*'
            	    {
            	    if ( !(( input.LA(2) != ')' )) ) {
            	        throw new FailedPredicateException(input, "COMMENT_1", " input.LA(2) != ')' ");
            	    }

            	    match('*'); 

            	    }
            	    break;
            	case 2 :
            	    // pascal3g.g:721:16: ~ ( '*' )
            	    {
            	    if ( (input.LA(1) >= '\u0000' && input.LA(1) <= ')')||(input.LA(1) >= '+' && input.LA(1) <= '\uFFFF') ) {
            	        input.consume();
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);


            match("*)"); 



            _channel=HIDDEN; 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "COMMENT_1"

    // $ANTLR start "COMMENT_2"
    public final void mCOMMENT_2() throws RecognitionException {
        try {
            int _type = COMMENT_2;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // pascal3g.g:728:9: ( '{' (~ ( '}' ) )* '}' )
            // pascal3g.g:728:12: '{' (~ ( '}' ) )* '}'
            {
            match('{'); 

            // pascal3g.g:729:9: (~ ( '}' ) )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( ((LA4_0 >= '\u0000' && LA4_0 <= '|')||(LA4_0 >= '~' && LA4_0 <= '\uFFFF')) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // pascal3g.g:
            	    {
            	    if ( (input.LA(1) >= '\u0000' && input.LA(1) <= '|')||(input.LA(1) >= '~' && input.LA(1) <= '\uFFFF') ) {
            	        input.consume();
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    break loop4;
                }
            } while (true);


            match('}'); 

            _channel=HIDDEN; 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "COMMENT_2"

    // $ANTLR start "IDENT"
    public final void mIDENT() throws RecognitionException {
        try {
            int _type = IDENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // pascal3g.g:737:8: ( ( 'a' .. 'z' | 'A' .. 'Z' ) ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )* )
            // pascal3g.g:737:11: ( 'a' .. 'z' | 'A' .. 'Z' ) ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )*
            {
            if ( (input.LA(1) >= 'A' && input.LA(1) <= 'Z')||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            // pascal3g.g:737:31: ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( ((LA5_0 >= '0' && LA5_0 <= '9')||(LA5_0 >= 'A' && LA5_0 <= 'Z')||LA5_0=='_'||(LA5_0 >= 'a' && LA5_0 <= 'z')) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // pascal3g.g:
            	    {
            	    if ( (input.LA(1) >= '0' && input.LA(1) <= '9')||(input.LA(1) >= 'A' && input.LA(1) <= 'Z')||input.LA(1)=='_'||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
            	        input.consume();
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    break loop5;
                }
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "IDENT"

    // $ANTLR start "STRING_LITERAL"
    public final void mSTRING_LITERAL() throws RecognitionException {
        try {
            int _type = STRING_LITERAL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // pascal3g.g:742:3: ( '\\'' ( '\\'\\'' |~ ( '\\'' ) )* '\\'' )
            // pascal3g.g:742:5: '\\'' ( '\\'\\'' |~ ( '\\'' ) )* '\\''
            {
            match('\''); 

            // pascal3g.g:742:10: ( '\\'\\'' |~ ( '\\'' ) )*
            loop6:
            do {
                int alt6=3;
                int LA6_0 = input.LA(1);

                if ( (LA6_0=='\'') ) {
                    int LA6_1 = input.LA(2);

                    if ( (LA6_1=='\'') ) {
                        alt6=1;
                    }


                }
                else if ( ((LA6_0 >= '\u0000' && LA6_0 <= '&')||(LA6_0 >= '(' && LA6_0 <= '\uFFFF')) ) {
                    alt6=2;
                }


                switch (alt6) {
            	case 1 :
            	    // pascal3g.g:742:11: '\\'\\''
            	    {
            	    match("''"); 



            	    }
            	    break;
            	case 2 :
            	    // pascal3g.g:742:20: ~ ( '\\'' )
            	    {
            	    if ( (input.LA(1) >= '\u0000' && input.LA(1) <= '&')||(input.LA(1) >= '(' && input.LA(1) <= '\uFFFF') ) {
            	        input.consume();
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    break loop6;
                }
            } while (true);


            match('\''); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "STRING_LITERAL"

    // $ANTLR start "NUM_INT"
    public final void mNUM_INT() throws RecognitionException {
        try {
            int _type = NUM_INT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // pascal3g.g:752:3: ( ( '0' .. '9' )+ ( ({...}? => '.' ( '0' .. '9' )+ ( EXPONENT )? )? | EXPONENT ) )
            // pascal3g.g:752:5: ( '0' .. '9' )+ ( ({...}? => '.' ( '0' .. '9' )+ ( EXPONENT )? )? | EXPONENT )
            {
            // pascal3g.g:752:5: ( '0' .. '9' )+
            int cnt7=0;
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( ((LA7_0 >= '0' && LA7_0 <= '9')) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // pascal3g.g:
            	    {
            	    if ( (input.LA(1) >= '0' && input.LA(1) <= '9') ) {
            	        input.consume();
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt7 >= 1 ) break loop7;
                        EarlyExitException eee =
                            new EarlyExitException(7, input);
                        throw eee;
                }
                cnt7++;
            } while (true);


            // pascal3g.g:753:5: ( ({...}? => '.' ( '0' .. '9' )+ ( EXPONENT )? )? | EXPONENT )
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0=='.') && (((input.LA(2)!='.')&&(input.LA(2)!=')')))) {
                alt11=1;
            }
            else if ( (LA11_0=='e') ) {
                alt11=2;
            }
            else {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // pascal3g.g:753:7: ({...}? => '.' ( '0' .. '9' )+ ( EXPONENT )? )?
                    {
                    // pascal3g.g:753:7: ({...}? => '.' ( '0' .. '9' )+ ( EXPONENT )? )?
                    int alt10=2;
                    int LA10_0 = input.LA(1);

                    if ( (LA10_0=='.') && (((input.LA(2)!='.')&&(input.LA(2)!=')')))) {
                        alt10=1;
                    }
                    switch (alt10) {
                        case 1 :
                            // pascal3g.g:753:9: {...}? => '.' ( '0' .. '9' )+ ( EXPONENT )?
                            {
                            if ( !(((input.LA(2)!='.')&&(input.LA(2)!=')'))) ) {
                                throw new FailedPredicateException(input, "NUM_INT", "(input.LA(2)!='.')&&(input.LA(2)!=')')");
                            }

                            match('.'); 

                            _type = NUM_REAL;

                            // pascal3g.g:756:9: ( '0' .. '9' )+
                            int cnt8=0;
                            loop8:
                            do {
                                int alt8=2;
                                int LA8_0 = input.LA(1);

                                if ( ((LA8_0 >= '0' && LA8_0 <= '9')) ) {
                                    alt8=1;
                                }


                                switch (alt8) {
                            	case 1 :
                            	    // pascal3g.g:
                            	    {
                            	    if ( (input.LA(1) >= '0' && input.LA(1) <= '9') ) {
                            	        input.consume();
                            	    }
                            	    else {
                            	        MismatchedSetException mse = new MismatchedSetException(null,input);
                            	        recover(mse);
                            	        throw mse;
                            	    }


                            	    }
                            	    break;

                            	default :
                            	    if ( cnt8 >= 1 ) break loop8;
                                        EarlyExitException eee =
                                            new EarlyExitException(8, input);
                                        throw eee;
                                }
                                cnt8++;
                            } while (true);


                            // pascal3g.g:756:21: ( EXPONENT )?
                            int alt9=2;
                            int LA9_0 = input.LA(1);

                            if ( (LA9_0=='e') ) {
                                alt9=1;
                            }
                            switch (alt9) {
                                case 1 :
                                    // pascal3g.g:756:22: EXPONENT
                                    {
                                    mEXPONENT(); 


                                    }
                                    break;

                            }


                            }
                            break;

                    }


                    }
                    break;
                case 2 :
                    // pascal3g.g:758:7: EXPONENT
                    {
                    mEXPONENT(); 


                    _type = NUM_REAL;

                    }
                    break;

            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "NUM_INT"

    // $ANTLR start "EXPONENT"
    public final void mEXPONENT() throws RecognitionException {
        try {
            // pascal3g.g:767:3: ( ( 'e' ) ( '+' | '-' )? ( '0' .. '9' )+ )
            // pascal3g.g:767:6: ( 'e' ) ( '+' | '-' )? ( '0' .. '9' )+
            {
            // pascal3g.g:767:6: ( 'e' )
            // pascal3g.g:767:7: 'e'
            {
            match('e'); 

            }


            // pascal3g.g:767:12: ( '+' | '-' )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0=='+'||LA12_0=='-') ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // pascal3g.g:
                    {
                    if ( input.LA(1)=='+'||input.LA(1)=='-' ) {
                        input.consume();
                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        recover(mse);
                        throw mse;
                    }


                    }
                    break;

            }


            // pascal3g.g:767:23: ( '0' .. '9' )+
            int cnt13=0;
            loop13:
            do {
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( ((LA13_0 >= '0' && LA13_0 <= '9')) ) {
                    alt13=1;
                }


                switch (alt13) {
            	case 1 :
            	    // pascal3g.g:
            	    {
            	    if ( (input.LA(1) >= '0' && input.LA(1) <= '9') ) {
            	        input.consume();
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt13 >= 1 ) break loop13;
                        EarlyExitException eee =
                            new EarlyExitException(13, input);
                        throw eee;
                }
                cnt13++;
            } while (true);


            }


        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "EXPONENT"

    public void mTokens() throws RecognitionException {
        // pascal3g.g:1:8: ( AND | ARRAY | ASSIGN | AT | BEGIN | BOOLEAN | CASE | CHAR | CHR | COLON | COMMA | CONST | DIV | DO | DOT | DOTDOT | DOWNTO | ELSE | END | EQUAL | EXIT | FILE | FOR | FORWARD | FUNCTION | GE | GOTO | GT | IF | IMPLEMENTATION | IN | INTEGER | INTERFACE | LABEL | LBRACK | LBRACK2 | LCURLY | LE | LPAREN | LT | MINUS | MOD | NIL | NOT | NOT_EQUAL | OF | OR | PACKED | PLUS | POINTER | PROCEDURE | PROGRAM | RBRACK | RBRACK2 | RCURLY | REAL | RECORD | REPEAT | RPAREN | SEMI | SET | SLASH | STAR | STRING | THEN | TO | TYPE | UNIT | UNTIL | USES | VAR | WHILE | WITH | WS | COMMENT_1 | COMMENT_2 | IDENT | STRING_LITERAL | NUM_INT )
        int alt14=79;
        alt14 = dfa14.predict(input);
        switch (alt14) {
            case 1 :
                // pascal3g.g:1:10: AND
                {
                mAND(); 


                }
                break;
            case 2 :
                // pascal3g.g:1:14: ARRAY
                {
                mARRAY(); 


                }
                break;
            case 3 :
                // pascal3g.g:1:20: ASSIGN
                {
                mASSIGN(); 


                }
                break;
            case 4 :
                // pascal3g.g:1:27: AT
                {
                mAT(); 


                }
                break;
            case 5 :
                // pascal3g.g:1:30: BEGIN
                {
                mBEGIN(); 


                }
                break;
            case 6 :
                // pascal3g.g:1:36: BOOLEAN
                {
                mBOOLEAN(); 


                }
                break;
            case 7 :
                // pascal3g.g:1:44: CASE
                {
                mCASE(); 


                }
                break;
            case 8 :
                // pascal3g.g:1:49: CHAR
                {
                mCHAR(); 


                }
                break;
            case 9 :
                // pascal3g.g:1:54: CHR
                {
                mCHR(); 


                }
                break;
            case 10 :
                // pascal3g.g:1:58: COLON
                {
                mCOLON(); 


                }
                break;
            case 11 :
                // pascal3g.g:1:64: COMMA
                {
                mCOMMA(); 


                }
                break;
            case 12 :
                // pascal3g.g:1:70: CONST
                {
                mCONST(); 


                }
                break;
            case 13 :
                // pascal3g.g:1:76: DIV
                {
                mDIV(); 


                }
                break;
            case 14 :
                // pascal3g.g:1:80: DO
                {
                mDO(); 


                }
                break;
            case 15 :
                // pascal3g.g:1:83: DOT
                {
                mDOT(); 


                }
                break;
            case 16 :
                // pascal3g.g:1:87: DOTDOT
                {
                mDOTDOT(); 


                }
                break;
            case 17 :
                // pascal3g.g:1:94: DOWNTO
                {
                mDOWNTO(); 


                }
                break;
            case 18 :
                // pascal3g.g:1:101: ELSE
                {
                mELSE(); 


                }
                break;
            case 19 :
                // pascal3g.g:1:106: END
                {
                mEND(); 


                }
                break;
            case 20 :
                // pascal3g.g:1:110: EQUAL
                {
                mEQUAL(); 


                }
                break;
            case 21 :
                // pascal3g.g:1:116: EXIT
                {
                mEXIT(); 


                }
                break;
            case 22 :
                // pascal3g.g:1:121: FILE
                {
                mFILE(); 


                }
                break;
            case 23 :
                // pascal3g.g:1:126: FOR
                {
                mFOR(); 


                }
                break;
            case 24 :
                // pascal3g.g:1:130: FORWARD
                {
                mFORWARD(); 


                }
                break;
            case 25 :
                // pascal3g.g:1:138: FUNCTION
                {
                mFUNCTION(); 


                }
                break;
            case 26 :
                // pascal3g.g:1:147: GE
                {
                mGE(); 


                }
                break;
            case 27 :
                // pascal3g.g:1:150: GOTO
                {
                mGOTO(); 


                }
                break;
            case 28 :
                // pascal3g.g:1:155: GT
                {
                mGT(); 


                }
                break;
            case 29 :
                // pascal3g.g:1:158: IF
                {
                mIF(); 


                }
                break;
            case 30 :
                // pascal3g.g:1:161: IMPLEMENTATION
                {
                mIMPLEMENTATION(); 


                }
                break;
            case 31 :
                // pascal3g.g:1:176: IN
                {
                mIN(); 


                }
                break;
            case 32 :
                // pascal3g.g:1:179: INTEGER
                {
                mINTEGER(); 


                }
                break;
            case 33 :
                // pascal3g.g:1:187: INTERFACE
                {
                mINTERFACE(); 


                }
                break;
            case 34 :
                // pascal3g.g:1:197: LABEL
                {
                mLABEL(); 


                }
                break;
            case 35 :
                // pascal3g.g:1:203: LBRACK
                {
                mLBRACK(); 


                }
                break;
            case 36 :
                // pascal3g.g:1:210: LBRACK2
                {
                mLBRACK2(); 


                }
                break;
            case 37 :
                // pascal3g.g:1:218: LCURLY
                {
                mLCURLY(); 


                }
                break;
            case 38 :
                // pascal3g.g:1:225: LE
                {
                mLE(); 


                }
                break;
            case 39 :
                // pascal3g.g:1:228: LPAREN
                {
                mLPAREN(); 


                }
                break;
            case 40 :
                // pascal3g.g:1:235: LT
                {
                mLT(); 


                }
                break;
            case 41 :
                // pascal3g.g:1:238: MINUS
                {
                mMINUS(); 


                }
                break;
            case 42 :
                // pascal3g.g:1:244: MOD
                {
                mMOD(); 


                }
                break;
            case 43 :
                // pascal3g.g:1:248: NIL
                {
                mNIL(); 


                }
                break;
            case 44 :
                // pascal3g.g:1:252: NOT
                {
                mNOT(); 


                }
                break;
            case 45 :
                // pascal3g.g:1:256: NOT_EQUAL
                {
                mNOT_EQUAL(); 


                }
                break;
            case 46 :
                // pascal3g.g:1:266: OF
                {
                mOF(); 


                }
                break;
            case 47 :
                // pascal3g.g:1:269: OR
                {
                mOR(); 


                }
                break;
            case 48 :
                // pascal3g.g:1:272: PACKED
                {
                mPACKED(); 


                }
                break;
            case 49 :
                // pascal3g.g:1:279: PLUS
                {
                mPLUS(); 


                }
                break;
            case 50 :
                // pascal3g.g:1:284: POINTER
                {
                mPOINTER(); 


                }
                break;
            case 51 :
                // pascal3g.g:1:292: PROCEDURE
                {
                mPROCEDURE(); 


                }
                break;
            case 52 :
                // pascal3g.g:1:302: PROGRAM
                {
                mPROGRAM(); 


                }
                break;
            case 53 :
                // pascal3g.g:1:310: RBRACK
                {
                mRBRACK(); 


                }
                break;
            case 54 :
                // pascal3g.g:1:317: RBRACK2
                {
                mRBRACK2(); 


                }
                break;
            case 55 :
                // pascal3g.g:1:325: RCURLY
                {
                mRCURLY(); 


                }
                break;
            case 56 :
                // pascal3g.g:1:332: REAL
                {
                mREAL(); 


                }
                break;
            case 57 :
                // pascal3g.g:1:337: RECORD
                {
                mRECORD(); 


                }
                break;
            case 58 :
                // pascal3g.g:1:344: REPEAT
                {
                mREPEAT(); 


                }
                break;
            case 59 :
                // pascal3g.g:1:351: RPAREN
                {
                mRPAREN(); 


                }
                break;
            case 60 :
                // pascal3g.g:1:358: SEMI
                {
                mSEMI(); 


                }
                break;
            case 61 :
                // pascal3g.g:1:363: SET
                {
                mSET(); 


                }
                break;
            case 62 :
                // pascal3g.g:1:367: SLASH
                {
                mSLASH(); 


                }
                break;
            case 63 :
                // pascal3g.g:1:373: STAR
                {
                mSTAR(); 


                }
                break;
            case 64 :
                // pascal3g.g:1:378: STRING
                {
                mSTRING(); 


                }
                break;
            case 65 :
                // pascal3g.g:1:385: THEN
                {
                mTHEN(); 


                }
                break;
            case 66 :
                // pascal3g.g:1:390: TO
                {
                mTO(); 


                }
                break;
            case 67 :
                // pascal3g.g:1:393: TYPE
                {
                mTYPE(); 


                }
                break;
            case 68 :
                // pascal3g.g:1:398: UNIT
                {
                mUNIT(); 


                }
                break;
            case 69 :
                // pascal3g.g:1:403: UNTIL
                {
                mUNTIL(); 


                }
                break;
            case 70 :
                // pascal3g.g:1:409: USES
                {
                mUSES(); 


                }
                break;
            case 71 :
                // pascal3g.g:1:414: VAR
                {
                mVAR(); 


                }
                break;
            case 72 :
                // pascal3g.g:1:418: WHILE
                {
                mWHILE(); 


                }
                break;
            case 73 :
                // pascal3g.g:1:424: WITH
                {
                mWITH(); 


                }
                break;
            case 74 :
                // pascal3g.g:1:429: WS
                {
                mWS(); 


                }
                break;
            case 75 :
                // pascal3g.g:1:432: COMMENT_1
                {
                mCOMMENT_1(); 


                }
                break;
            case 76 :
                // pascal3g.g:1:442: COMMENT_2
                {
                mCOMMENT_2(); 


                }
                break;
            case 77 :
                // pascal3g.g:1:452: IDENT
                {
                mIDENT(); 


                }
                break;
            case 78 :
                // pascal3g.g:1:458: STRING_LITERAL
                {
                mSTRING_LITERAL(); 


                }
                break;
            case 79 :
                // pascal3g.g:1:473: NUM_INT
                {
                mNUM_INT(); 


                }
                break;

        }

    }


    protected DFA14 dfa14 = new DFA14(this);
    static final String DFA14_eotS =
        "\1\uffff\1\50\1\56\1\uffff\2\50\1\uffff\1\50\1\70\1\50\1\uffff\1"+
        "\50\1\100\3\50\1\uffff\1\110\1\111\1\115\1\uffff\4\50\4\uffff\1"+
        "\50\2\uffff\1\50\2\uffff\4\50\4\uffff\2\50\2\uffff\6\50\1\152\3"+
        "\uffff\6\50\2\uffff\1\50\1\162\1\50\1\165\1\50\10\uffff\3\50\1\172"+
        "\1\173\6\50\1\u0084\6\50\1\u008c\5\50\1\u0092\1\50\1\u0094\1\50"+
        "\1\uffff\1\50\1\u0097\2\50\1\u009b\2\50\1\uffff\2\50\1\uffff\1\50"+
        "\1\u00a1\1\u00a2\1\u00a3\2\uffff\5\50\1\u00aa\2\50\1\uffff\4\50"+
        "\1\u00b1\2\50\1\uffff\3\50\1\u00b7\1\u00b8\1\uffff\1\50\1\uffff"+
        "\1\50\1\u00bb\1\uffff\1\u00bc\1\u00bd\1\50\1\uffff\1\50\1\u00c0"+
        "\3\50\3\uffff\3\50\1\u00c8\2\50\1\uffff\1\50\1\u00cc\1\u00cd\1\u00ce"+
        "\1\50\1\u00d0\1\uffff\1\50\1\u00d2\1\u00d3\1\u00d4\1\50\2\uffff"+
        "\1\u00d6\1\50\3\uffff\2\50\1\uffff\3\50\1\u00dd\3\50\1\uffff\3\50"+
        "\3\uffff\1\u00e4\1\uffff\1\u00e5\3\uffff\1\50\1\uffff\1\u00e7\5"+
        "\50\1\uffff\1\u00ed\2\50\1\u00f0\1\u00f1\1\u00f2\2\uffff\1\u00f3"+
        "\1\uffff\1\u00f4\2\50\1\u00f7\1\50\1\uffff\1\50\1\u00fa\5\uffff"+
        "\1\u00fb\1\50\1\uffff\2\50\2\uffff\1\50\1\u0100\1\u0101\1\50\2\uffff"+
        "\3\50\1\u0106\1\uffff";
    static final String DFA14_eofS =
        "\u0107\uffff";
    static final String DFA14_minS =
        "\1\11\1\156\1\75\1\uffff\1\145\1\141\1\uffff\1\151\1\51\1\154\1"+
        "\uffff\1\151\1\75\1\157\1\146\1\141\1\uffff\1\52\1\0\1\75\1\uffff"+
        "\1\157\1\151\1\146\1\141\4\uffff\1\145\2\uffff\1\145\2\uffff\1\150"+
        "\1\156\1\141\1\150\4\uffff\1\144\1\162\2\uffff\1\147\1\157\1\163"+
        "\1\141\1\156\1\166\1\60\3\uffff\1\163\1\144\1\151\1\154\1\162\1"+
        "\156\2\uffff\1\164\1\60\1\160\1\60\1\142\10\uffff\1\144\1\154\1"+
        "\164\2\60\1\143\1\157\1\141\1\164\1\162\1\145\1\60\1\160\1\151\1"+
        "\145\1\162\1\151\1\164\1\60\1\141\1\151\1\154\1\145\1\162\1\60\1"+
        "\163\1\60\1\156\1\uffff\1\145\1\60\1\164\1\145\1\60\1\143\1\157"+
        "\1\uffff\1\154\1\145\1\uffff\1\145\3\60\2\uffff\1\153\1\143\1\154"+
        "\1\157\1\145\1\60\1\151\1\156\1\uffff\1\145\1\164\1\151\1\163\1"+
        "\60\1\154\1\150\1\uffff\1\171\1\156\1\145\2\60\1\uffff\1\164\1\uffff"+
        "\1\164\1\60\1\uffff\2\60\1\141\1\uffff\1\164\1\60\1\145\1\147\1"+
        "\154\3\uffff\2\145\1\162\1\60\1\162\1\141\1\uffff\1\156\3\60\1\154"+
        "\1\60\1\uffff\1\145\3\60\1\141\2\uffff\1\60\1\157\3\uffff\1\162"+
        "\1\151\1\uffff\1\155\1\145\1\146\1\60\2\144\1\141\1\uffff\1\144"+
        "\1\164\1\147\3\uffff\1\60\1\uffff\1\60\3\uffff\1\156\1\uffff\1\60"+
        "\1\144\1\157\1\145\1\162\1\141\1\uffff\1\60\1\165\1\155\3\60\2\uffff"+
        "\1\60\1\uffff\1\60\2\156\1\60\1\143\1\uffff\1\162\1\60\5\uffff\1"+
        "\60\1\164\1\uffff\2\145\2\uffff\1\141\2\60\1\164\2\uffff\1\151\1"+
        "\157\1\156\1\60\1\uffff";
    static final String DFA14_maxS =
        "\1\175\1\162\1\75\1\uffff\2\157\1\uffff\1\157\1\56\1\170\1\uffff"+
        "\1\165\1\75\1\157\1\156\1\141\1\uffff\1\56\1\uffff\1\76\1\uffff"+
        "\2\157\2\162\4\uffff\1\145\2\uffff\1\164\2\uffff\1\171\1\163\1\141"+
        "\1\151\4\uffff\1\144\1\162\2\uffff\1\147\1\157\1\163\1\162\1\156"+
        "\1\166\1\172\3\uffff\1\163\1\144\1\151\1\154\1\162\1\156\2\uffff"+
        "\1\164\1\172\1\160\1\172\1\142\10\uffff\1\144\1\154\1\164\2\172"+
        "\1\143\1\157\1\160\1\164\1\162\1\145\1\172\1\160\1\164\1\145\1\162"+
        "\1\151\1\164\1\172\1\141\1\151\1\154\1\145\1\162\1\172\1\163\1\172"+
        "\1\156\1\uffff\1\145\1\172\1\164\1\145\1\172\1\143\1\157\1\uffff"+
        "\1\154\1\145\1\uffff\1\145\3\172\2\uffff\1\153\1\147\1\154\1\157"+
        "\1\145\1\172\1\151\1\156\1\uffff\1\145\1\164\1\151\1\163\1\172\1"+
        "\154\1\150\1\uffff\1\171\1\156\1\145\2\172\1\uffff\1\164\1\uffff"+
        "\1\164\1\172\1\uffff\2\172\1\141\1\uffff\1\164\1\172\1\145\1\162"+
        "\1\154\3\uffff\2\145\1\162\1\172\1\162\1\141\1\uffff\1\156\3\172"+
        "\1\154\1\172\1\uffff\1\145\3\172\1\141\2\uffff\1\172\1\157\3\uffff"+
        "\1\162\1\151\1\uffff\1\155\1\145\1\146\1\172\2\144\1\141\1\uffff"+
        "\1\144\1\164\1\147\3\uffff\1\172\1\uffff\1\172\3\uffff\1\156\1\uffff"+
        "\1\172\1\144\1\157\1\145\1\162\1\141\1\uffff\1\172\1\165\1\155\3"+
        "\172\2\uffff\1\172\1\uffff\1\172\2\156\1\172\1\143\1\uffff\1\162"+
        "\1\172\5\uffff\1\172\1\164\1\uffff\2\145\2\uffff\1\141\2\172\1\164"+
        "\2\uffff\1\151\1\157\1\156\1\172\1\uffff";
    static final String DFA14_acceptS =
        "\3\uffff\1\4\2\uffff\1\13\3\uffff\1\24\5\uffff\1\43\3\uffff\1\51"+
        "\4\uffff\1\61\1\62\1\65\1\67\1\uffff\1\73\1\74\1\uffff\1\76\1\77"+
        "\4\uffff\1\112\1\115\1\116\1\117\2\uffff\1\3\1\12\7\uffff\1\20\1"+
        "\66\1\17\6\uffff\1\32\1\34\5\uffff\1\44\1\113\1\47\1\45\1\114\1"+
        "\46\1\55\1\50\34\uffff\1\16\7\uffff\1\35\2\uffff\1\37\4\uffff\1"+
        "\56\1\57\10\uffff\1\102\7\uffff\1\1\5\uffff\1\11\1\uffff\1\15\2"+
        "\uffff\1\23\3\uffff\1\27\5\uffff\1\52\1\53\1\54\6\uffff\1\75\6\uffff"+
        "\1\107\5\uffff\1\7\1\10\2\uffff\1\22\1\25\1\26\2\uffff\1\33\7\uffff"+
        "\1\70\3\uffff\1\101\1\103\1\104\1\uffff\1\106\1\uffff\1\111\1\2"+
        "\1\5\1\uffff\1\14\6\uffff\1\42\6\uffff\1\105\1\110\1\uffff\1\21"+
        "\5\uffff\1\60\2\uffff\1\71\1\72\1\100\1\6\1\30\2\uffff\1\40\2\uffff"+
        "\1\64\1\31\4\uffff\1\41\1\63\4\uffff\1\36";
    static final String DFA14_specialS =
        "\22\uffff\1\0\u00f4\uffff}>";
    static final String[] DFA14_transitionS = {
            "\2\47\1\uffff\2\47\22\uffff\1\47\6\uffff\1\51\1\21\1\36\1\42"+
            "\1\31\1\6\1\24\1\10\1\41\12\52\1\2\1\37\1\23\1\12\1\14\1\uffff"+
            "\1\3\32\50\1\20\1\uffff\1\33\1\32\2\uffff\1\1\1\4\1\5\1\7\1"+
            "\11\1\13\1\15\1\50\1\16\2\50\1\17\1\25\1\26\1\27\1\30\1\50\1"+
            "\35\1\40\1\43\1\44\1\45\1\46\3\50\1\22\1\uffff\1\34",
            "\1\53\3\uffff\1\54",
            "\1\55",
            "",
            "\1\57\11\uffff\1\60",
            "\1\61\6\uffff\1\62\6\uffff\1\63",
            "",
            "\1\64\5\uffff\1\65",
            "\1\67\4\uffff\1\66",
            "\1\71\1\uffff\1\72\11\uffff\1\73",
            "",
            "\1\74\5\uffff\1\75\5\uffff\1\76",
            "\1\77",
            "\1\101",
            "\1\102\6\uffff\1\103\1\104",
            "\1\105",
            "",
            "\1\107\3\uffff\1\106",
            "\0\112",
            "\1\113\1\114",
            "",
            "\1\116",
            "\1\117\5\uffff\1\120",
            "\1\121\13\uffff\1\122",
            "\1\123\20\uffff\1\124",
            "",
            "",
            "",
            "",
            "\1\125",
            "",
            "",
            "\1\126\16\uffff\1\127",
            "",
            "",
            "\1\130\6\uffff\1\131\11\uffff\1\132",
            "\1\133\4\uffff\1\134",
            "\1\135",
            "\1\136\1\137",
            "",
            "",
            "",
            "",
            "\1\140",
            "\1\141",
            "",
            "",
            "\1\142",
            "\1\143",
            "\1\144",
            "\1\145\20\uffff\1\146",
            "\1\147",
            "\1\150",
            "\12\50\7\uffff\32\50\4\uffff\1\50\1\uffff\26\50\1\151\3\50",
            "",
            "",
            "",
            "\1\153",
            "\1\154",
            "\1\155",
            "\1\156",
            "\1\157",
            "\1\160",
            "",
            "",
            "\1\161",
            "\12\50\7\uffff\32\50\4\uffff\1\50\1\uffff\32\50",
            "\1\163",
            "\12\50\7\uffff\32\50\4\uffff\1\50\1\uffff\23\50\1\164\6\50",
            "\1\166",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\167",
            "\1\170",
            "\1\171",
            "\12\50\7\uffff\32\50\4\uffff\1\50\1\uffff\32\50",
            "\12\50\7\uffff\32\50\4\uffff\1\50\1\uffff\32\50",
            "\1\174",
            "\1\175",
            "\1\176\1\uffff\1\177\14\uffff\1\u0080",
            "\1\u0081",
            "\1\u0082",
            "\1\u0083",
            "\12\50\7\uffff\32\50\4\uffff\1\50\1\uffff\32\50",
            "\1\u0085",
            "\1\u0086\12\uffff\1\u0087",
            "\1\u0088",
            "\1\u0089",
            "\1\u008a",
            "\1\u008b",
            "\12\50\7\uffff\32\50\4\uffff\1\50\1\uffff\32\50",
            "\1\u008d",
            "\1\u008e",
            "\1\u008f",
            "\1\u0090",
            "\1\u0091",
            "\12\50\7\uffff\32\50\4\uffff\1\50\1\uffff\32\50",
            "\1\u0093",
            "\12\50\7\uffff\32\50\4\uffff\1\50\1\uffff\32\50",
            "\1\u0095",
            "",
            "\1\u0096",
            "\12\50\7\uffff\32\50\4\uffff\1\50\1\uffff\32\50",
            "\1\u0098",
            "\1\u0099",
            "\12\50\7\uffff\32\50\4\uffff\1\50\1\uffff\26\50\1\u009a\3\50",
            "\1\u009c",
            "\1\u009d",
            "",
            "\1\u009e",
            "\1\u009f",
            "",
            "\1\u00a0",
            "\12\50\7\uffff\32\50\4\uffff\1\50\1\uffff\32\50",
            "\12\50\7\uffff\32\50\4\uffff\1\50\1\uffff\32\50",
            "\12\50\7\uffff\32\50\4\uffff\1\50\1\uffff\32\50",
            "",
            "",
            "\1\u00a4",
            "\1\u00a5\3\uffff\1\u00a6",
            "\1\u00a7",
            "\1\u00a8",
            "\1\u00a9",
            "\12\50\7\uffff\32\50\4\uffff\1\50\1\uffff\32\50",
            "\1\u00ab",
            "\1\u00ac",
            "",
            "\1\u00ad",
            "\1\u00ae",
            "\1\u00af",
            "\1\u00b0",
            "\12\50\7\uffff\32\50\4\uffff\1\50\1\uffff\32\50",
            "\1\u00b2",
            "\1\u00b3",
            "",
            "\1\u00b4",
            "\1\u00b5",
            "\1\u00b6",
            "\12\50\7\uffff\32\50\4\uffff\1\50\1\uffff\32\50",
            "\12\50\7\uffff\32\50\4\uffff\1\50\1\uffff\32\50",
            "",
            "\1\u00b9",
            "",
            "\1\u00ba",
            "\12\50\7\uffff\32\50\4\uffff\1\50\1\uffff\32\50",
            "",
            "\12\50\7\uffff\32\50\4\uffff\1\50\1\uffff\32\50",
            "\12\50\7\uffff\32\50\4\uffff\1\50\1\uffff\32\50",
            "\1\u00be",
            "",
            "\1\u00bf",
            "\12\50\7\uffff\32\50\4\uffff\1\50\1\uffff\32\50",
            "\1\u00c1",
            "\1\u00c2\12\uffff\1\u00c3",
            "\1\u00c4",
            "",
            "",
            "",
            "\1\u00c5",
            "\1\u00c6",
            "\1\u00c7",
            "\12\50\7\uffff\32\50\4\uffff\1\50\1\uffff\32\50",
            "\1\u00c9",
            "\1\u00ca",
            "",
            "\1\u00cb",
            "\12\50\7\uffff\32\50\4\uffff\1\50\1\uffff\32\50",
            "\12\50\7\uffff\32\50\4\uffff\1\50\1\uffff\32\50",
            "\12\50\7\uffff\32\50\4\uffff\1\50\1\uffff\32\50",
            "\1\u00cf",
            "\12\50\7\uffff\32\50\4\uffff\1\50\1\uffff\32\50",
            "",
            "\1\u00d1",
            "\12\50\7\uffff\32\50\4\uffff\1\50\1\uffff\32\50",
            "\12\50\7\uffff\32\50\4\uffff\1\50\1\uffff\32\50",
            "\12\50\7\uffff\32\50\4\uffff\1\50\1\uffff\32\50",
            "\1\u00d5",
            "",
            "",
            "\12\50\7\uffff\32\50\4\uffff\1\50\1\uffff\32\50",
            "\1\u00d7",
            "",
            "",
            "",
            "\1\u00d8",
            "\1\u00d9",
            "",
            "\1\u00da",
            "\1\u00db",
            "\1\u00dc",
            "\12\50\7\uffff\32\50\4\uffff\1\50\1\uffff\32\50",
            "\1\u00de",
            "\1\u00df",
            "\1\u00e0",
            "",
            "\1\u00e1",
            "\1\u00e2",
            "\1\u00e3",
            "",
            "",
            "",
            "\12\50\7\uffff\32\50\4\uffff\1\50\1\uffff\32\50",
            "",
            "\12\50\7\uffff\32\50\4\uffff\1\50\1\uffff\32\50",
            "",
            "",
            "",
            "\1\u00e6",
            "",
            "\12\50\7\uffff\32\50\4\uffff\1\50\1\uffff\32\50",
            "\1\u00e8",
            "\1\u00e9",
            "\1\u00ea",
            "\1\u00eb",
            "\1\u00ec",
            "",
            "\12\50\7\uffff\32\50\4\uffff\1\50\1\uffff\32\50",
            "\1\u00ee",
            "\1\u00ef",
            "\12\50\7\uffff\32\50\4\uffff\1\50\1\uffff\32\50",
            "\12\50\7\uffff\32\50\4\uffff\1\50\1\uffff\32\50",
            "\12\50\7\uffff\32\50\4\uffff\1\50\1\uffff\32\50",
            "",
            "",
            "\12\50\7\uffff\32\50\4\uffff\1\50\1\uffff\32\50",
            "",
            "\12\50\7\uffff\32\50\4\uffff\1\50\1\uffff\32\50",
            "\1\u00f5",
            "\1\u00f6",
            "\12\50\7\uffff\32\50\4\uffff\1\50\1\uffff\32\50",
            "\1\u00f8",
            "",
            "\1\u00f9",
            "\12\50\7\uffff\32\50\4\uffff\1\50\1\uffff\32\50",
            "",
            "",
            "",
            "",
            "",
            "\12\50\7\uffff\32\50\4\uffff\1\50\1\uffff\32\50",
            "\1\u00fc",
            "",
            "\1\u00fd",
            "\1\u00fe",
            "",
            "",
            "\1\u00ff",
            "\12\50\7\uffff\32\50\4\uffff\1\50\1\uffff\32\50",
            "\12\50\7\uffff\32\50\4\uffff\1\50\1\uffff\32\50",
            "\1\u0102",
            "",
            "",
            "\1\u0103",
            "\1\u0104",
            "\1\u0105",
            "\12\50\7\uffff\32\50\4\uffff\1\50\1\uffff\32\50",
            ""
    };

    static final short[] DFA14_eot = DFA.unpackEncodedString(DFA14_eotS);
    static final short[] DFA14_eof = DFA.unpackEncodedString(DFA14_eofS);
    static final char[] DFA14_min = DFA.unpackEncodedStringToUnsignedChars(DFA14_minS);
    static final char[] DFA14_max = DFA.unpackEncodedStringToUnsignedChars(DFA14_maxS);
    static final short[] DFA14_accept = DFA.unpackEncodedString(DFA14_acceptS);
    static final short[] DFA14_special = DFA.unpackEncodedString(DFA14_specialS);
    static final short[][] DFA14_transition;

    static {
        int numStates = DFA14_transitionS.length;
        DFA14_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA14_transition[i] = DFA.unpackEncodedString(DFA14_transitionS[i]);
        }
    }

    class DFA14 extends DFA {

        public DFA14(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 14;
            this.eot = DFA14_eot;
            this.eof = DFA14_eof;
            this.min = DFA14_min;
            this.max = DFA14_max;
            this.accept = DFA14_accept;
            this.special = DFA14_special;
            this.transition = DFA14_transition;
        }
        public String getDescription() {
            return "1:1: Tokens : ( AND | ARRAY | ASSIGN | AT | BEGIN | BOOLEAN | CASE | CHAR | CHR | COLON | COMMA | CONST | DIV | DO | DOT | DOTDOT | DOWNTO | ELSE | END | EQUAL | EXIT | FILE | FOR | FORWARD | FUNCTION | GE | GOTO | GT | IF | IMPLEMENTATION | IN | INTEGER | INTERFACE | LABEL | LBRACK | LBRACK2 | LCURLY | LE | LPAREN | LT | MINUS | MOD | NIL | NOT | NOT_EQUAL | OF | OR | PACKED | PLUS | POINTER | PROCEDURE | PROGRAM | RBRACK | RBRACK2 | RCURLY | REAL | RECORD | REPEAT | RPAREN | SEMI | SET | SLASH | STAR | STRING | THEN | TO | TYPE | UNIT | UNTIL | USES | VAR | WHILE | WITH | WS | COMMENT_1 | COMMENT_2 | IDENT | STRING_LITERAL | NUM_INT );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            IntStream input = _input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA14_18 = input.LA(1);

                        s = -1;
                        if ( ((LA14_18 >= '\u0000' && LA14_18 <= '\uFFFF')) ) {s = 74;}

                        else s = 73;

                        if ( s>=0 ) return s;
                        break;
            }
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 14, _s, input);
            error(nvae);
            throw nvae;
        }

    }
 

}