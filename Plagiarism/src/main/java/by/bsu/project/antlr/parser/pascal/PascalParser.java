package by.bsu.project.antlr.parser.pascal;// $ANTLR 3.4 pascal3g.g 2015-01-27 10:33:01

import org.antlr.runtime.*;

import org.antlr.runtime.tree.*;


@SuppressWarnings({"all", "warnings", "unchecked"})
public class PascalParser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "AND", "ARGDECL", "ARGDECLS", "ARGLIST", "ARRAY", "ASSIGN", "AT", "BEGIN", "BLOCK", "BOOLEAN", "CASE", "CHAR", "CHR", "COLON", "COMMA", "COMMENT_1", "COMMENT_2", "CONST", "CONSTLIST", "DIV", "DO", "DOT", "DOTDOT", "DOWNTO", "ELIST", "ELSE", "END", "EQUAL", "EXIT", "EXPONENT", "FIELD", "FIELDLIST", "FILE", "FOR", "FORWARD", "FUNCTION", "FUNC_CALL", "GE", "GOTO", "GT", "IDENT", "IDLIST", "IF", "IMPLEMENTATION", "IN", "INTEGER", "INTERFACE", "LABEL", "LBRACK", "LBRACK2", "LCURLY", "LE", "LPAREN", "LT", "MINUS", "MOD", "NIL", "NOT", "NOT_EQUAL", "NUM_INT", "NUM_REAL", "OF", "OR", "PACKED", "PLUS", "POINTER", "PROCEDURE", "PROC_CALL", "PROGRAM", "RBRACK", "RBRACK2", "RCURLY", "REAL", "RECORD", "REPEAT", "RPAREN", "SCALARTYPE", "SEMI", "SET", "SLASH", "STAR", "STRING", "STRING_LITERAL", "SUBRANGE", "THEN", "TO", "TYPE", "TYPEDECL", "TYPELIST", "UNIT", "UNTIL", "USES", "VAR", "VARDECL", "VARIANT_CASE", "VARIANT_TAG", "VARIANT_TAG_NO_ID", "WHILE", "WITH", "WS"
    };

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
    public Parser[] getDelegates() {
        return new Parser[] {};
    }

    // delegators


    public PascalParser(TokenStream input) {
        this(input, new RecognizerSharedState());
    }
    public PascalParser(TokenStream input, RecognizerSharedState state) {
        super(input, state);
    }

protected TreeAdaptor adaptor = new CommonTreeAdaptor();

public void setTreeAdaptor(TreeAdaptor adaptor) {
    this.adaptor = adaptor;
}
public TreeAdaptor getTreeAdaptor() {
    return adaptor;
}
    public String[] getTokenNames() { return PascalParser.tokenNames; }
    public String getGrammarFileName() { return "pascal3g.g"; }


    public static class program_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "program"
    // pascal3g.g:216:1: program : programHeading ( INTERFACE )? block DOT -> ^( PROGRAM programHeading block ) ;
    public final program_return program() throws RecognitionException {
        program_return retval = new program_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token INTERFACE2=null;
        Token DOT4=null;
        programHeading_return programHeading1 =null;

        block_return block3 =null;


        Object INTERFACE2_tree=null;
        Object DOT4_tree=null;
        RewriteRuleTokenStream stream_INTERFACE=new RewriteRuleTokenStream(adaptor,"token INTERFACE");
        RewriteRuleTokenStream stream_DOT=new RewriteRuleTokenStream(adaptor,"token DOT");
        RewriteRuleSubtreeStream stream_block=new RewriteRuleSubtreeStream(adaptor,"rule block");
        RewriteRuleSubtreeStream stream_programHeading=new RewriteRuleSubtreeStream(adaptor,"rule programHeading");
        try {
            // pascal3g.g:217:5: ( programHeading ( INTERFACE )? block DOT -> ^( PROGRAM programHeading block ) )
            // pascal3g.g:217:7: programHeading ( INTERFACE )? block DOT
            {
            pushFollow(FOLLOW_programHeading_in_program2231);
            programHeading1=programHeading();

            state._fsp--;

            stream_programHeading.add(programHeading1.getTree());

            // pascal3g.g:217:22: ( INTERFACE )?
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==INTERFACE) ) {
                alt1=1;
            }
            switch (alt1) {
                case 1 :
                    // pascal3g.g:217:23: INTERFACE
                    {
                    INTERFACE2=(Token)match(input,INTERFACE,FOLLOW_INTERFACE_in_program2234);  
                    stream_INTERFACE.add(INTERFACE2);


                    }
                    break;

            }


            pushFollow(FOLLOW_block_in_program2244);
            block3=block();

            state._fsp--;

            stream_block.add(block3.getTree());

            DOT4=(Token)match(input,DOT,FOLLOW_DOT_in_program2252);  
            stream_DOT.add(DOT4);


            // AST REWRITE
            // elements: block, programHeading
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",
                    retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 220:7: -> ^( PROGRAM programHeading block )
            {
                // pascal3g.g:220:10: ^( PROGRAM programHeading block )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot(
                (Object)adaptor.create(PROGRAM, "PROGRAM")
                , root_1);

                adaptor.addChild(root_1, stream_programHeading.nextTree());

                adaptor.addChild(root_1, stream_block.nextTree());

                adaptor.addChild(root_0, root_1);
                }

            }


            retval.tree = root_0;

            }

            retval.stop = input.LT(-1);


            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "program"


    public static class programHeading_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "programHeading"
    // pascal3g.g:223:1: programHeading : ( PROGRAM ! identifier ( LPAREN ! identifierList RPAREN !)? SEMI !| UNIT identifier SEMI !);
    public final programHeading_return programHeading() throws RecognitionException {
        programHeading_return retval = new programHeading_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token PROGRAM5=null;
        Token LPAREN7=null;
        Token RPAREN9=null;
        Token SEMI10=null;
        Token UNIT11=null;
        Token SEMI13=null;
        identifier_return identifier6 =null;

        identifierList_return identifierList8 =null;

        identifier_return identifier12 =null;


        Object PROGRAM5_tree=null;
        Object LPAREN7_tree=null;
        Object RPAREN9_tree=null;
        Object SEMI10_tree=null;
        Object UNIT11_tree=null;
        Object SEMI13_tree=null;

        try {
            // pascal3g.g:224:5: ( PROGRAM ! identifier ( LPAREN ! identifierList RPAREN !)? SEMI !| UNIT identifier SEMI !)
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==PROGRAM) ) {
                alt3=1;
            }
            else if ( (LA3_0==UNIT) ) {
                alt3=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;

            }
            switch (alt3) {
                case 1 :
                    // pascal3g.g:224:7: PROGRAM ! identifier ( LPAREN ! identifierList RPAREN !)? SEMI !
                    {
                    root_0 = (Object)adaptor.nil();


                    PROGRAM5=(Token)match(input,PROGRAM,FOLLOW_PROGRAM_in_programHeading2285); 

                    pushFollow(FOLLOW_identifier_in_programHeading2288);
                    identifier6=identifier();

                    state._fsp--;

                    adaptor.addChild(root_0, identifier6.getTree());

                    // pascal3g.g:224:27: ( LPAREN ! identifierList RPAREN !)?
                    int alt2=2;
                    int LA2_0 = input.LA(1);

                    if ( (LA2_0==LPAREN) ) {
                        alt2=1;
                    }
                    switch (alt2) {
                        case 1 :
                            // pascal3g.g:224:28: LPAREN ! identifierList RPAREN !
                            {
                            LPAREN7=(Token)match(input,LPAREN,FOLLOW_LPAREN_in_programHeading2291); 

                            pushFollow(FOLLOW_identifierList_in_programHeading2294);
                            identifierList8=identifierList();

                            state._fsp--;

                            adaptor.addChild(root_0, identifierList8.getTree());

                            RPAREN9=(Token)match(input,RPAREN,FOLLOW_RPAREN_in_programHeading2296); 

                            }
                            break;

                    }


                    SEMI10=(Token)match(input,SEMI,FOLLOW_SEMI_in_programHeading2301); 

                    }
                    break;
                case 2 :
                    // pascal3g.g:225:7: UNIT identifier SEMI !
                    {
                    root_0 = (Object)adaptor.nil();


                    UNIT11=(Token)match(input,UNIT,FOLLOW_UNIT_in_programHeading2310); 
                    UNIT11_tree = 
                    (Object)adaptor.create(UNIT11)
                    ;
                    adaptor.addChild(root_0, UNIT11_tree);


                    pushFollow(FOLLOW_identifier_in_programHeading2312);
                    identifier12=identifier();

                    state._fsp--;

                    adaptor.addChild(root_0, identifier12.getTree());

                    SEMI13=(Token)match(input,SEMI,FOLLOW_SEMI_in_programHeading2314); 

                    }
                    break;

            }
            retval.stop = input.LT(-1);


            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "programHeading"


    public static class identifier_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "identifier"
    // pascal3g.g:228:1: identifier : IDENT ;
    public final identifier_return identifier() throws RecognitionException {
        identifier_return retval = new identifier_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token IDENT14=null;

        Object IDENT14_tree=null;

        try {
            // pascal3g.g:229:5: ( IDENT )
            // pascal3g.g:229:7: IDENT
            {
            root_0 = (Object)adaptor.nil();


            IDENT14=(Token)match(input,IDENT,FOLLOW_IDENT_in_identifier2330); 
            IDENT14_tree = 
            (Object)adaptor.create(IDENT14)
            ;
            adaptor.addChild(root_0, IDENT14_tree);


            }

            retval.stop = input.LT(-1);


            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "identifier"


    public static class block_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "block"
    // pascal3g.g:232:1: block : ( labelDeclarationPart | constantDefinitionPart | typeDefinitionPart | variableDeclarationPart | procedureAndFunctionDeclarationPart | usesUnitsPart | IMPLEMENTATION )* compoundStatement ;
    public final block_return block() throws RecognitionException {
        block_return retval = new block_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token IMPLEMENTATION21=null;
        labelDeclarationPart_return labelDeclarationPart15 =null;

        constantDefinitionPart_return constantDefinitionPart16 =null;

        typeDefinitionPart_return typeDefinitionPart17 =null;

        variableDeclarationPart_return variableDeclarationPart18 =null;

        procedureAndFunctionDeclarationPart_return procedureAndFunctionDeclarationPart19 =null;

        usesUnitsPart_return usesUnitsPart20 =null;

        compoundStatement_return compoundStatement22 =null;


        Object IMPLEMENTATION21_tree=null;

        try {
            // pascal3g.g:233:5: ( ( labelDeclarationPart | constantDefinitionPart | typeDefinitionPart | variableDeclarationPart | procedureAndFunctionDeclarationPart | usesUnitsPart | IMPLEMENTATION )* compoundStatement )
            // pascal3g.g:233:7: ( labelDeclarationPart | constantDefinitionPart | typeDefinitionPart | variableDeclarationPart | procedureAndFunctionDeclarationPart | usesUnitsPart | IMPLEMENTATION )* compoundStatement
            {
            root_0 = (Object)adaptor.nil();


            // pascal3g.g:233:7: ( labelDeclarationPart | constantDefinitionPart | typeDefinitionPart | variableDeclarationPart | procedureAndFunctionDeclarationPart | usesUnitsPart | IMPLEMENTATION )*
            loop4:
            do {
                int alt4=8;
                switch ( input.LA(1) ) {
                case LABEL:
                    {
                    alt4=1;
                    }
                    break;
                case CONST:
                    {
                    alt4=2;
                    }
                    break;
                case TYPE:
                    {
                    alt4=3;
                    }
                    break;
                case VAR:
                    {
                    alt4=4;
                    }
                    break;
                case FUNCTION:
                case PROCEDURE:
                    {
                    alt4=5;
                    }
                    break;
                case USES:
                    {
                    alt4=6;
                    }
                    break;
                case IMPLEMENTATION:
                    {
                    alt4=7;
                    }
                    break;

                }

                switch (alt4) {
            	case 1 :
            	    // pascal3g.g:233:9: labelDeclarationPart
            	    {
            	    pushFollow(FOLLOW_labelDeclarationPart_in_block2349);
            	    labelDeclarationPart15=labelDeclarationPart();

            	    state._fsp--;

            	    adaptor.addChild(root_0, labelDeclarationPart15.getTree());

            	    }
            	    break;
            	case 2 :
            	    // pascal3g.g:234:9: constantDefinitionPart
            	    {
            	    pushFollow(FOLLOW_constantDefinitionPart_in_block2359);
            	    constantDefinitionPart16=constantDefinitionPart();

            	    state._fsp--;

            	    adaptor.addChild(root_0, constantDefinitionPart16.getTree());

            	    }
            	    break;
            	case 3 :
            	    // pascal3g.g:235:9: typeDefinitionPart
            	    {
            	    pushFollow(FOLLOW_typeDefinitionPart_in_block2369);
            	    typeDefinitionPart17=typeDefinitionPart();

            	    state._fsp--;

            	    adaptor.addChild(root_0, typeDefinitionPart17.getTree());

            	    }
            	    break;
            	case 4 :
            	    // pascal3g.g:236:9: variableDeclarationPart
            	    {
            	    pushFollow(FOLLOW_variableDeclarationPart_in_block2379);
            	    variableDeclarationPart18=variableDeclarationPart();

            	    state._fsp--;

            	    adaptor.addChild(root_0, variableDeclarationPart18.getTree());

            	    }
            	    break;
            	case 5 :
            	    // pascal3g.g:237:9: procedureAndFunctionDeclarationPart
            	    {
            	    pushFollow(FOLLOW_procedureAndFunctionDeclarationPart_in_block2389);
            	    procedureAndFunctionDeclarationPart19=procedureAndFunctionDeclarationPart();

            	    state._fsp--;

            	    adaptor.addChild(root_0, procedureAndFunctionDeclarationPart19.getTree());

            	    }
            	    break;
            	case 6 :
            	    // pascal3g.g:238:9: usesUnitsPart
            	    {
            	    pushFollow(FOLLOW_usesUnitsPart_in_block2399);
            	    usesUnitsPart20=usesUnitsPart();

            	    state._fsp--;

            	    adaptor.addChild(root_0, usesUnitsPart20.getTree());

            	    }
            	    break;
            	case 7 :
            	    // pascal3g.g:239:9: IMPLEMENTATION
            	    {
            	    IMPLEMENTATION21=(Token)match(input,IMPLEMENTATION,FOLLOW_IMPLEMENTATION_in_block2409); 
            	    IMPLEMENTATION21_tree = 
            	    (Object)adaptor.create(IMPLEMENTATION21)
            	    ;
            	    adaptor.addChild(root_0, IMPLEMENTATION21_tree);


            	    }
            	    break;

            	default :
            	    break loop4;
                }
            } while (true);


            pushFollow(FOLLOW_compoundStatement_in_block2426);
            compoundStatement22=compoundStatement();

            state._fsp--;

            adaptor.addChild(root_0, compoundStatement22.getTree());

            }

            retval.stop = input.LT(-1);


            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "block"


    public static class usesUnitsPart_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "usesUnitsPart"
    // pascal3g.g:244:1: usesUnitsPart : USES ^ identifierList SEMI !;
    public final usesUnitsPart_return usesUnitsPart() throws RecognitionException {
        usesUnitsPart_return retval = new usesUnitsPart_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token USES23=null;
        Token SEMI25=null;
        identifierList_return identifierList24 =null;


        Object USES23_tree=null;
        Object SEMI25_tree=null;

        try {
            // pascal3g.g:245:5: ( USES ^ identifierList SEMI !)
            // pascal3g.g:245:7: USES ^ identifierList SEMI !
            {
            root_0 = (Object)adaptor.nil();


            USES23=(Token)match(input,USES,FOLLOW_USES_in_usesUnitsPart2443); 
            USES23_tree = 
            (Object)adaptor.create(USES23)
            ;
            root_0 = (Object)adaptor.becomeRoot(USES23_tree, root_0);


            pushFollow(FOLLOW_identifierList_in_usesUnitsPart2446);
            identifierList24=identifierList();

            state._fsp--;

            adaptor.addChild(root_0, identifierList24.getTree());

            SEMI25=(Token)match(input,SEMI,FOLLOW_SEMI_in_usesUnitsPart2448); 

            }

            retval.stop = input.LT(-1);


            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "usesUnitsPart"


    public static class labelDeclarationPart_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "labelDeclarationPart"
    // pascal3g.g:248:1: labelDeclarationPart : LABEL ^ label ( COMMA ! label )* SEMI !;
    public final labelDeclarationPart_return labelDeclarationPart() throws RecognitionException {
        labelDeclarationPart_return retval = new labelDeclarationPart_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token LABEL26=null;
        Token COMMA28=null;
        Token SEMI30=null;
        label_return label27 =null;

        label_return label29 =null;


        Object LABEL26_tree=null;
        Object COMMA28_tree=null;
        Object SEMI30_tree=null;

        try {
            // pascal3g.g:249:5: ( LABEL ^ label ( COMMA ! label )* SEMI !)
            // pascal3g.g:249:7: LABEL ^ label ( COMMA ! label )* SEMI !
            {
            root_0 = (Object)adaptor.nil();


            LABEL26=(Token)match(input,LABEL,FOLLOW_LABEL_in_labelDeclarationPart2466); 
            LABEL26_tree = 
            (Object)adaptor.create(LABEL26)
            ;
            root_0 = (Object)adaptor.becomeRoot(LABEL26_tree, root_0);


            pushFollow(FOLLOW_label_in_labelDeclarationPart2469);
            label27=label();

            state._fsp--;

            adaptor.addChild(root_0, label27.getTree());

            // pascal3g.g:249:20: ( COMMA ! label )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==COMMA) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // pascal3g.g:249:22: COMMA ! label
            	    {
            	    COMMA28=(Token)match(input,COMMA,FOLLOW_COMMA_in_labelDeclarationPart2473); 

            	    pushFollow(FOLLOW_label_in_labelDeclarationPart2476);
            	    label29=label();

            	    state._fsp--;

            	    adaptor.addChild(root_0, label29.getTree());

            	    }
            	    break;

            	default :
            	    break loop5;
                }
            } while (true);


            SEMI30=(Token)match(input,SEMI,FOLLOW_SEMI_in_labelDeclarationPart2481); 

            }

            retval.stop = input.LT(-1);


            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "labelDeclarationPart"


    public static class label_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "label"
    // pascal3g.g:252:1: label : unsignedInteger ;
    public final label_return label() throws RecognitionException {
        label_return retval = new label_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        unsignedInteger_return unsignedInteger31 =null;



        try {
            // pascal3g.g:253:5: ( unsignedInteger )
            // pascal3g.g:253:7: unsignedInteger
            {
            root_0 = (Object)adaptor.nil();


            pushFollow(FOLLOW_unsignedInteger_in_label2499);
            unsignedInteger31=unsignedInteger();

            state._fsp--;

            adaptor.addChild(root_0, unsignedInteger31.getTree());

            }

            retval.stop = input.LT(-1);


            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "label"


    public static class constantDefinitionPart_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "constantDefinitionPart"
    // pascal3g.g:256:1: constantDefinitionPart : CONST ^ constantDefinition ( SEMI ! constantDefinition )* SEMI !;
    public final constantDefinitionPart_return constantDefinitionPart() throws RecognitionException {
        constantDefinitionPart_return retval = new constantDefinitionPart_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token CONST32=null;
        Token SEMI34=null;
        Token SEMI36=null;
        constantDefinition_return constantDefinition33 =null;

        constantDefinition_return constantDefinition35 =null;


        Object CONST32_tree=null;
        Object SEMI34_tree=null;
        Object SEMI36_tree=null;

        try {
            // pascal3g.g:257:5: ( CONST ^ constantDefinition ( SEMI ! constantDefinition )* SEMI !)
            // pascal3g.g:257:7: CONST ^ constantDefinition ( SEMI ! constantDefinition )* SEMI !
            {
            root_0 = (Object)adaptor.nil();


            CONST32=(Token)match(input,CONST,FOLLOW_CONST_in_constantDefinitionPart2516); 
            CONST32_tree = 
            (Object)adaptor.create(CONST32)
            ;
            root_0 = (Object)adaptor.becomeRoot(CONST32_tree, root_0);


            pushFollow(FOLLOW_constantDefinition_in_constantDefinitionPart2519);
            constantDefinition33=constantDefinition();

            state._fsp--;

            adaptor.addChild(root_0, constantDefinition33.getTree());

            // pascal3g.g:257:33: ( SEMI ! constantDefinition )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==SEMI) ) {
                    int LA6_1 = input.LA(2);

                    if ( (LA6_1==IDENT) ) {
                        alt6=1;
                    }


                }


                switch (alt6) {
            	case 1 :
            	    // pascal3g.g:257:35: SEMI ! constantDefinition
            	    {
            	    SEMI34=(Token)match(input,SEMI,FOLLOW_SEMI_in_constantDefinitionPart2523); 

            	    pushFollow(FOLLOW_constantDefinition_in_constantDefinitionPart2526);
            	    constantDefinition35=constantDefinition();

            	    state._fsp--;

            	    adaptor.addChild(root_0, constantDefinition35.getTree());

            	    }
            	    break;

            	default :
            	    break loop6;
                }
            } while (true);


            SEMI36=(Token)match(input,SEMI,FOLLOW_SEMI_in_constantDefinitionPart2531); 

            }

            retval.stop = input.LT(-1);


            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "constantDefinitionPart"


    public static class constantDefinition_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "constantDefinition"
    // pascal3g.g:260:1: constantDefinition : identifier EQUAL ^ constant ;
    public final constantDefinition_return constantDefinition() throws RecognitionException {
        constantDefinition_return retval = new constantDefinition_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token EQUAL38=null;
        identifier_return identifier37 =null;

        constant_return constant39 =null;


        Object EQUAL38_tree=null;

        try {
            // pascal3g.g:261:5: ( identifier EQUAL ^ constant )
            // pascal3g.g:261:7: identifier EQUAL ^ constant
            {
            root_0 = (Object)adaptor.nil();


            pushFollow(FOLLOW_identifier_in_constantDefinition2549);
            identifier37=identifier();

            state._fsp--;

            adaptor.addChild(root_0, identifier37.getTree());

            EQUAL38=(Token)match(input,EQUAL,FOLLOW_EQUAL_in_constantDefinition2551); 
            EQUAL38_tree = 
            (Object)adaptor.create(EQUAL38)
            ;
            root_0 = (Object)adaptor.becomeRoot(EQUAL38_tree, root_0);


            pushFollow(FOLLOW_constant_in_constantDefinition2554);
            constant39=constant();

            state._fsp--;

            adaptor.addChild(root_0, constant39.getTree());

            }

            retval.stop = input.LT(-1);


            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "constantDefinition"


    public static class constantChr_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "constantChr"
    // pascal3g.g:264:1: constantChr : CHR ^ LPAREN ! ( unsignedInteger | identifier ) RPAREN !;
    public final constantChr_return constantChr() throws RecognitionException {
        constantChr_return retval = new constantChr_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token CHR40=null;
        Token LPAREN41=null;
        Token RPAREN44=null;
        unsignedInteger_return unsignedInteger42 =null;

        identifier_return identifier43 =null;


        Object CHR40_tree=null;
        Object LPAREN41_tree=null;
        Object RPAREN44_tree=null;

        try {
            // pascal3g.g:265:5: ( CHR ^ LPAREN ! ( unsignedInteger | identifier ) RPAREN !)
            // pascal3g.g:265:7: CHR ^ LPAREN ! ( unsignedInteger | identifier ) RPAREN !
            {
            root_0 = (Object)adaptor.nil();


            CHR40=(Token)match(input,CHR,FOLLOW_CHR_in_constantChr2571); 
            CHR40_tree = 
            (Object)adaptor.create(CHR40)
            ;
            root_0 = (Object)adaptor.becomeRoot(CHR40_tree, root_0);


            LPAREN41=(Token)match(input,LPAREN,FOLLOW_LPAREN_in_constantChr2574); 

            // pascal3g.g:265:20: ( unsignedInteger | identifier )
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==NUM_INT) ) {
                alt7=1;
            }
            else if ( (LA7_0==IDENT) ) {
                alt7=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 7, 0, input);

                throw nvae;

            }
            switch (alt7) {
                case 1 :
                    // pascal3g.g:265:21: unsignedInteger
                    {
                    pushFollow(FOLLOW_unsignedInteger_in_constantChr2578);
                    unsignedInteger42=unsignedInteger();

                    state._fsp--;

                    adaptor.addChild(root_0, unsignedInteger42.getTree());

                    }
                    break;
                case 2 :
                    // pascal3g.g:265:37: identifier
                    {
                    pushFollow(FOLLOW_identifier_in_constantChr2580);
                    identifier43=identifier();

                    state._fsp--;

                    adaptor.addChild(root_0, identifier43.getTree());

                    }
                    break;

            }


            RPAREN44=(Token)match(input,RPAREN,FOLLOW_RPAREN_in_constantChr2583); 

            }

            retval.stop = input.LT(-1);


            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "constantChr"


    public static class constant_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "constant"
    // pascal3g.g:268:1: constant : ( unsignedNumber |s= sign n= unsignedNumber -> ^( $s $n) | identifier |s2= sign id= identifier -> ^( $s2 $id) | string | constantChr );
    public final constant_return constant() throws RecognitionException {
        constant_return retval = new constant_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        sign_return s =null;

        unsignedNumber_return n =null;

        sign_return s2 =null;

        identifier_return id =null;

        unsignedNumber_return unsignedNumber45 =null;

        identifier_return identifier46 =null;

        string_return string47 =null;

        constantChr_return constantChr48 =null;


        RewriteRuleSubtreeStream stream_sign=new RewriteRuleSubtreeStream(adaptor,"rule sign");
        RewriteRuleSubtreeStream stream_unsignedNumber=new RewriteRuleSubtreeStream(adaptor,"rule unsignedNumber");
        RewriteRuleSubtreeStream stream_identifier=new RewriteRuleSubtreeStream(adaptor,"rule identifier");
        try {
            // pascal3g.g:269:5: ( unsignedNumber |s= sign n= unsignedNumber -> ^( $s $n) | identifier |s2= sign id= identifier -> ^( $s2 $id) | string | constantChr )
            int alt8=6;
            switch ( input.LA(1) ) {
            case NUM_INT:
            case NUM_REAL:
                {
                alt8=1;
                }
                break;
            case MINUS:
            case PLUS:
                {
                int LA8_2 = input.LA(2);

                if ( ((LA8_2 >= NUM_INT && LA8_2 <= NUM_REAL)) ) {
                    alt8=2;
                }
                else if ( (LA8_2==IDENT) ) {
                    alt8=4;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 8, 2, input);

                    throw nvae;

                }
                }
                break;
            case IDENT:
                {
                alt8=3;
                }
                break;
            case STRING_LITERAL:
                {
                alt8=5;
                }
                break;
            case CHR:
                {
                alt8=6;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 8, 0, input);

                throw nvae;

            }

            switch (alt8) {
                case 1 :
                    // pascal3g.g:269:7: unsignedNumber
                    {
                    root_0 = (Object)adaptor.nil();


                    pushFollow(FOLLOW_unsignedNumber_in_constant2601);
                    unsignedNumber45=unsignedNumber();

                    state._fsp--;

                    adaptor.addChild(root_0, unsignedNumber45.getTree());

                    }
                    break;
                case 2 :
                    // pascal3g.g:270:7: s= sign n= unsignedNumber
                    {
                    pushFollow(FOLLOW_sign_in_constant2611);
                    s=sign();

                    state._fsp--;

                    stream_sign.add(s.getTree());

                    pushFollow(FOLLOW_unsignedNumber_in_constant2615);
                    n=unsignedNumber();

                    state._fsp--;

                    stream_unsignedNumber.add(n.getTree());

                    // AST REWRITE
                    // elements: n, s
                    // token labels: 
                    // rule labels: retval, s, n
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);
                    RewriteRuleSubtreeStream stream_s=new RewriteRuleSubtreeStream(adaptor,"rule s",s!=null?s.tree:null);
                    RewriteRuleSubtreeStream stream_n=new RewriteRuleSubtreeStream(adaptor,"rule n",n!=null?n.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 270:31: -> ^( $s $n)
                    {
                        // pascal3g.g:270:34: ^( $s $n)
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot(stream_s.nextNode(), root_1);

                        adaptor.addChild(root_1, stream_n.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }


                    retval.tree = root_0;

                    }
                    break;
                case 3 :
                    // pascal3g.g:271:7: identifier
                    {
                    root_0 = (Object)adaptor.nil();


                    pushFollow(FOLLOW_identifier_in_constant2634);
                    identifier46=identifier();

                    state._fsp--;

                    adaptor.addChild(root_0, identifier46.getTree());

                    }
                    break;
                case 4 :
                    // pascal3g.g:272:7: s2= sign id= identifier
                    {
                    pushFollow(FOLLOW_sign_in_constant2644);
                    s2=sign();

                    state._fsp--;

                    stream_sign.add(s2.getTree());

                    pushFollow(FOLLOW_identifier_in_constant2648);
                    id=identifier();

                    state._fsp--;

                    stream_identifier.add(id.getTree());

                    // AST REWRITE
                    // elements: id, s2
                    // token labels: 
                    // rule labels: id, retval, s2
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_id=new RewriteRuleSubtreeStream(adaptor,"rule id",id!=null?id.tree:null);
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);
                    RewriteRuleSubtreeStream stream_s2=new RewriteRuleSubtreeStream(adaptor,"rule s2",s2!=null?s2.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 272:29: -> ^( $s2 $id)
                    {
                        // pascal3g.g:272:32: ^( $s2 $id)
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot(stream_s2.nextNode(), root_1);

                        adaptor.addChild(root_1, stream_id.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }


                    retval.tree = root_0;

                    }
                    break;
                case 5 :
                    // pascal3g.g:273:7: string
                    {
                    root_0 = (Object)adaptor.nil();


                    pushFollow(FOLLOW_string_in_constant2667);
                    string47=string();

                    state._fsp--;

                    adaptor.addChild(root_0, string47.getTree());

                    }
                    break;
                case 6 :
                    // pascal3g.g:274:7: constantChr
                    {
                    root_0 = (Object)adaptor.nil();


                    pushFollow(FOLLOW_constantChr_in_constant2675);
                    constantChr48=constantChr();

                    state._fsp--;

                    adaptor.addChild(root_0, constantChr48.getTree());

                    }
                    break;

            }
            retval.stop = input.LT(-1);


            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "constant"


    public static class unsignedNumber_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "unsignedNumber"
    // pascal3g.g:277:1: unsignedNumber : ( unsignedInteger | unsignedReal );
    public final unsignedNumber_return unsignedNumber() throws RecognitionException {
        unsignedNumber_return retval = new unsignedNumber_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        unsignedInteger_return unsignedInteger49 =null;

        unsignedReal_return unsignedReal50 =null;



        try {
            // pascal3g.g:278:5: ( unsignedInteger | unsignedReal )
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==NUM_INT) ) {
                alt9=1;
            }
            else if ( (LA9_0==NUM_REAL) ) {
                alt9=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 9, 0, input);

                throw nvae;

            }
            switch (alt9) {
                case 1 :
                    // pascal3g.g:278:7: unsignedInteger
                    {
                    root_0 = (Object)adaptor.nil();


                    pushFollow(FOLLOW_unsignedInteger_in_unsignedNumber2692);
                    unsignedInteger49=unsignedInteger();

                    state._fsp--;

                    adaptor.addChild(root_0, unsignedInteger49.getTree());

                    }
                    break;
                case 2 :
                    // pascal3g.g:279:7: unsignedReal
                    {
                    root_0 = (Object)adaptor.nil();


                    pushFollow(FOLLOW_unsignedReal_in_unsignedNumber2700);
                    unsignedReal50=unsignedReal();

                    state._fsp--;

                    adaptor.addChild(root_0, unsignedReal50.getTree());

                    }
                    break;

            }
            retval.stop = input.LT(-1);


            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "unsignedNumber"


    public static class unsignedInteger_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "unsignedInteger"
    // pascal3g.g:282:1: unsignedInteger : NUM_INT ;
    public final unsignedInteger_return unsignedInteger() throws RecognitionException {
        unsignedInteger_return retval = new unsignedInteger_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token NUM_INT51=null;

        Object NUM_INT51_tree=null;

        try {
            // pascal3g.g:283:5: ( NUM_INT )
            // pascal3g.g:283:7: NUM_INT
            {
            root_0 = (Object)adaptor.nil();


            NUM_INT51=(Token)match(input,NUM_INT,FOLLOW_NUM_INT_in_unsignedInteger2717); 
            NUM_INT51_tree = 
            (Object)adaptor.create(NUM_INT51)
            ;
            adaptor.addChild(root_0, NUM_INT51_tree);


            }

            retval.stop = input.LT(-1);


            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "unsignedInteger"


    public static class unsignedReal_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "unsignedReal"
    // pascal3g.g:286:1: unsignedReal : NUM_REAL ;
    public final unsignedReal_return unsignedReal() throws RecognitionException {
        unsignedReal_return retval = new unsignedReal_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token NUM_REAL52=null;

        Object NUM_REAL52_tree=null;

        try {
            // pascal3g.g:287:5: ( NUM_REAL )
            // pascal3g.g:287:7: NUM_REAL
            {
            root_0 = (Object)adaptor.nil();


            NUM_REAL52=(Token)match(input,NUM_REAL,FOLLOW_NUM_REAL_in_unsignedReal2734); 
            NUM_REAL52_tree = 
            (Object)adaptor.create(NUM_REAL52)
            ;
            adaptor.addChild(root_0, NUM_REAL52_tree);


            }

            retval.stop = input.LT(-1);


            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "unsignedReal"


    public static class sign_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "sign"
    // pascal3g.g:290:1: sign : ( PLUS | MINUS );
    public final sign_return sign() throws RecognitionException {
        sign_return retval = new sign_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token set53=null;

        Object set53_tree=null;

        try {
            // pascal3g.g:291:5: ( PLUS | MINUS )
            // pascal3g.g:
            {
            root_0 = (Object)adaptor.nil();


            set53=(Token)input.LT(1);

            if ( input.LA(1)==MINUS||input.LA(1)==PLUS ) {
                input.consume();
                adaptor.addChild(root_0, 
                (Object)adaptor.create(set53)
                );
                state.errorRecovery=false;
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }


            }

            retval.stop = input.LT(-1);


            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "sign"


    public static class string_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "string"
    // pascal3g.g:294:1: string : STRING_LITERAL ;
    public final string_return string() throws RecognitionException {
        string_return retval = new string_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token STRING_LITERAL54=null;

        Object STRING_LITERAL54_tree=null;

        try {
            // pascal3g.g:295:5: ( STRING_LITERAL )
            // pascal3g.g:295:7: STRING_LITERAL
            {
            root_0 = (Object)adaptor.nil();


            STRING_LITERAL54=(Token)match(input,STRING_LITERAL,FOLLOW_STRING_LITERAL_in_string2772); 
            STRING_LITERAL54_tree = 
            (Object)adaptor.create(STRING_LITERAL54)
            ;
            adaptor.addChild(root_0, STRING_LITERAL54_tree);


            }

            retval.stop = input.LT(-1);


            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "string"


    public static class typeDefinitionPart_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "typeDefinitionPart"
    // pascal3g.g:298:1: typeDefinitionPart : TYPE ^ typeDefinition ( SEMI ! typeDefinition )* SEMI !;
    public final typeDefinitionPart_return typeDefinitionPart() throws RecognitionException {
        typeDefinitionPart_return retval = new typeDefinitionPart_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token TYPE55=null;
        Token SEMI57=null;
        Token SEMI59=null;
        typeDefinition_return typeDefinition56 =null;

        typeDefinition_return typeDefinition58 =null;


        Object TYPE55_tree=null;
        Object SEMI57_tree=null;
        Object SEMI59_tree=null;

        try {
            // pascal3g.g:299:5: ( TYPE ^ typeDefinition ( SEMI ! typeDefinition )* SEMI !)
            // pascal3g.g:299:7: TYPE ^ typeDefinition ( SEMI ! typeDefinition )* SEMI !
            {
            root_0 = (Object)adaptor.nil();


            TYPE55=(Token)match(input,TYPE,FOLLOW_TYPE_in_typeDefinitionPart2789); 
            TYPE55_tree = 
            (Object)adaptor.create(TYPE55)
            ;
            root_0 = (Object)adaptor.becomeRoot(TYPE55_tree, root_0);


            pushFollow(FOLLOW_typeDefinition_in_typeDefinitionPart2792);
            typeDefinition56=typeDefinition();

            state._fsp--;

            adaptor.addChild(root_0, typeDefinition56.getTree());

            // pascal3g.g:299:28: ( SEMI ! typeDefinition )*
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( (LA10_0==SEMI) ) {
                    int LA10_1 = input.LA(2);

                    if ( (LA10_1==IDENT) ) {
                        alt10=1;
                    }


                }


                switch (alt10) {
            	case 1 :
            	    // pascal3g.g:299:30: SEMI ! typeDefinition
            	    {
            	    SEMI57=(Token)match(input,SEMI,FOLLOW_SEMI_in_typeDefinitionPart2796); 

            	    pushFollow(FOLLOW_typeDefinition_in_typeDefinitionPart2799);
            	    typeDefinition58=typeDefinition();

            	    state._fsp--;

            	    adaptor.addChild(root_0, typeDefinition58.getTree());

            	    }
            	    break;

            	default :
            	    break loop10;
                }
            } while (true);


            SEMI59=(Token)match(input,SEMI,FOLLOW_SEMI_in_typeDefinitionPart2804); 

            }

            retval.stop = input.LT(-1);


            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "typeDefinitionPart"


    public static class typeDefinition_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "typeDefinition"
    // pascal3g.g:303:1: typeDefinition : identifier e= EQUAL ^ ( type | functionType | procedureType ) ;
    public final typeDefinition_return typeDefinition() throws RecognitionException {
        typeDefinition_return retval = new typeDefinition_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token e=null;
        identifier_return identifier60 =null;

        type_return type61 =null;

        functionType_return functionType62 =null;

        procedureType_return procedureType63 =null;


        Object e_tree=null;

        try {
            // pascal3g.g:304:5: ( identifier e= EQUAL ^ ( type | functionType | procedureType ) )
            // pascal3g.g:304:7: identifier e= EQUAL ^ ( type | functionType | procedureType )
            {
            root_0 = (Object)adaptor.nil();


            pushFollow(FOLLOW_identifier_in_typeDefinition2823);
            identifier60=identifier();

            state._fsp--;

            adaptor.addChild(root_0, identifier60.getTree());

            e=(Token)match(input,EQUAL,FOLLOW_EQUAL_in_typeDefinition2827); 
            e_tree = 
            (Object)adaptor.create(e)
            ;
            root_0 = (Object)adaptor.becomeRoot(e_tree, root_0);


            e.setType(TYPEDECL);

            // pascal3g.g:305:7: ( type | functionType | procedureType )
            int alt11=3;
            switch ( input.LA(1) ) {
            case ARRAY:
            case BOOLEAN:
            case CHAR:
            case CHR:
            case FILE:
            case IDENT:
            case INTEGER:
            case LPAREN:
            case MINUS:
            case NUM_INT:
            case NUM_REAL:
            case PACKED:
            case PLUS:
            case POINTER:
            case REAL:
            case RECORD:
            case SET:
            case STRING:
            case STRING_LITERAL:
                {
                alt11=1;
                }
                break;
            case FUNCTION:
                {
                alt11=2;
                }
                break;
            case PROCEDURE:
                {
                alt11=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 11, 0, input);

                throw nvae;

            }

            switch (alt11) {
                case 1 :
                    // pascal3g.g:305:9: type
                    {
                    pushFollow(FOLLOW_type_in_typeDefinition2840);
                    type61=type();

                    state._fsp--;

                    adaptor.addChild(root_0, type61.getTree());

                    }
                    break;
                case 2 :
                    // pascal3g.g:306:9: functionType
                    {
                    pushFollow(FOLLOW_functionType_in_typeDefinition2850);
                    functionType62=functionType();

                    state._fsp--;

                    adaptor.addChild(root_0, functionType62.getTree());

                    }
                    break;
                case 3 :
                    // pascal3g.g:307:9: procedureType
                    {
                    pushFollow(FOLLOW_procedureType_in_typeDefinition2861);
                    procedureType63=procedureType();

                    state._fsp--;

                    adaptor.addChild(root_0, procedureType63.getTree());

                    }
                    break;

            }


            }

            retval.stop = input.LT(-1);


            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "typeDefinition"


    public static class functionType_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "functionType"
    // pascal3g.g:311:1: functionType : FUNCTION ^ ( formalParameterList )? COLON ! resultType ;
    public final functionType_return functionType() throws RecognitionException {
        functionType_return retval = new functionType_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token FUNCTION64=null;
        Token COLON66=null;
        formalParameterList_return formalParameterList65 =null;

        resultType_return resultType67 =null;


        Object FUNCTION64_tree=null;
        Object COLON66_tree=null;

        try {
            // pascal3g.g:312:5: ( FUNCTION ^ ( formalParameterList )? COLON ! resultType )
            // pascal3g.g:312:7: FUNCTION ^ ( formalParameterList )? COLON ! resultType
            {
            root_0 = (Object)adaptor.nil();


            FUNCTION64=(Token)match(input,FUNCTION,FOLLOW_FUNCTION_in_functionType2886); 
            FUNCTION64_tree = 
            (Object)adaptor.create(FUNCTION64)
            ;
            root_0 = (Object)adaptor.becomeRoot(FUNCTION64_tree, root_0);


            // pascal3g.g:312:17: ( formalParameterList )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==LPAREN) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // pascal3g.g:312:18: formalParameterList
                    {
                    pushFollow(FOLLOW_formalParameterList_in_functionType2890);
                    formalParameterList65=formalParameterList();

                    state._fsp--;

                    adaptor.addChild(root_0, formalParameterList65.getTree());

                    }
                    break;

            }


            COLON66=(Token)match(input,COLON,FOLLOW_COLON_in_functionType2894); 

            pushFollow(FOLLOW_resultType_in_functionType2897);
            resultType67=resultType();

            state._fsp--;

            adaptor.addChild(root_0, resultType67.getTree());

            }

            retval.stop = input.LT(-1);


            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "functionType"


    public static class procedureType_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "procedureType"
    // pascal3g.g:315:1: procedureType : PROCEDURE ^ ( formalParameterList )? ;
    public final procedureType_return procedureType() throws RecognitionException {
        procedureType_return retval = new procedureType_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token PROCEDURE68=null;
        formalParameterList_return formalParameterList69 =null;


        Object PROCEDURE68_tree=null;

        try {
            // pascal3g.g:316:5: ( PROCEDURE ^ ( formalParameterList )? )
            // pascal3g.g:316:7: PROCEDURE ^ ( formalParameterList )?
            {
            root_0 = (Object)adaptor.nil();


            PROCEDURE68=(Token)match(input,PROCEDURE,FOLLOW_PROCEDURE_in_procedureType2914); 
            PROCEDURE68_tree = 
            (Object)adaptor.create(PROCEDURE68)
            ;
            root_0 = (Object)adaptor.becomeRoot(PROCEDURE68_tree, root_0);


            // pascal3g.g:316:18: ( formalParameterList )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==LPAREN) ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // pascal3g.g:316:19: formalParameterList
                    {
                    pushFollow(FOLLOW_formalParameterList_in_procedureType2918);
                    formalParameterList69=formalParameterList();

                    state._fsp--;

                    adaptor.addChild(root_0, formalParameterList69.getTree());

                    }
                    break;

            }


            }

            retval.stop = input.LT(-1);


            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "procedureType"


    public static class type_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "type"
    // pascal3g.g:319:1: type : ( simpleType | structuredType | pointerType );
    public final type_return type() throws RecognitionException {
        type_return retval = new type_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        simpleType_return simpleType70 =null;

        structuredType_return structuredType71 =null;

        pointerType_return pointerType72 =null;



        try {
            // pascal3g.g:320:5: ( simpleType | structuredType | pointerType )
            int alt14=3;
            switch ( input.LA(1) ) {
            case BOOLEAN:
            case CHAR:
            case INTEGER:
            case LPAREN:
            case REAL:
            case STRING:
                {
                alt14=1;
                }
                break;
            case NUM_INT:
                {
                int LA14_2 = input.LA(2);

                if ( (LA14_2==DOTDOT) ) {
                    switch ( input.LA(3) ) {
                    case NUM_INT:
                        {
                        alt14=1;
                        }
                        break;
                    case NUM_REAL:
                        {
                        alt14=1;
                        }
                        break;
                    case MINUS:
                    case PLUS:
                        {
                        switch ( input.LA(4) ) {
                        case NUM_INT:
                            {
                            alt14=1;
                            }
                            break;
                        case NUM_REAL:
                            {
                            alt14=1;
                            }
                            break;
                        case IDENT:
                            {
                            alt14=1;
                            }
                            break;
                        default:
                            NoViableAltException nvae =
                                new NoViableAltException("", 14, 17, input);

                            throw nvae;

                        }

                        }
                        break;
                    case IDENT:
                        {
                        alt14=1;
                        }
                        break;
                    case STRING_LITERAL:
                        {
                        alt14=1;
                        }
                        break;
                    case CHR:
                        {
                        int LA14_20 = input.LA(4);

                        if ( (LA14_20==LPAREN) ) {
                            int LA14_26 = input.LA(5);

                            if ( (LA14_26==NUM_INT) ) {
                                int LA14_28 = input.LA(6);

                                if ( (LA14_28==RPAREN) ) {
                                    alt14=1;
                                }
                                else {
                                    NoViableAltException nvae =
                                        new NoViableAltException("", 14, 28, input);

                                    throw nvae;

                                }
                            }
                            else if ( (LA14_26==IDENT) ) {
                                int LA14_29 = input.LA(6);

                                if ( (LA14_29==RPAREN) ) {
                                    alt14=1;
                                }
                                else {
                                    NoViableAltException nvae =
                                        new NoViableAltException("", 14, 29, input);

                                    throw nvae;

                                }
                            }
                            else {
                                NoViableAltException nvae =
                                    new NoViableAltException("", 14, 26, input);

                                throw nvae;

                            }
                        }
                        else {
                            NoViableAltException nvae =
                                new NoViableAltException("", 14, 20, input);

                            throw nvae;

                        }
                        }
                        break;
                    default:
                        NoViableAltException nvae =
                            new NoViableAltException("", 14, 10, input);

                        throw nvae;

                    }

                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 14, 2, input);

                    throw nvae;

                }
                }
                break;
            case NUM_REAL:
                {
                int LA14_3 = input.LA(2);

                if ( (LA14_3==DOTDOT) ) {
                    switch ( input.LA(3) ) {
                    case NUM_INT:
                        {
                        alt14=1;
                        }
                        break;
                    case NUM_REAL:
                        {
                        alt14=1;
                        }
                        break;
                    case MINUS:
                    case PLUS:
                        {
                        switch ( input.LA(4) ) {
                        case NUM_INT:
                            {
                            alt14=1;
                            }
                            break;
                        case NUM_REAL:
                            {
                            alt14=1;
                            }
                            break;
                        case IDENT:
                            {
                            alt14=1;
                            }
                            break;
                        default:
                            NoViableAltException nvae =
                                new NoViableAltException("", 14, 17, input);

                            throw nvae;

                        }

                        }
                        break;
                    case IDENT:
                        {
                        alt14=1;
                        }
                        break;
                    case STRING_LITERAL:
                        {
                        alt14=1;
                        }
                        break;
                    case CHR:
                        {
                        int LA14_20 = input.LA(4);

                        if ( (LA14_20==LPAREN) ) {
                            int LA14_26 = input.LA(5);

                            if ( (LA14_26==NUM_INT) ) {
                                int LA14_28 = input.LA(6);

                                if ( (LA14_28==RPAREN) ) {
                                    alt14=1;
                                }
                                else {
                                    NoViableAltException nvae =
                                        new NoViableAltException("", 14, 28, input);

                                    throw nvae;

                                }
                            }
                            else if ( (LA14_26==IDENT) ) {
                                int LA14_29 = input.LA(6);

                                if ( (LA14_29==RPAREN) ) {
                                    alt14=1;
                                }
                                else {
                                    NoViableAltException nvae =
                                        new NoViableAltException("", 14, 29, input);

                                    throw nvae;

                                }
                            }
                            else {
                                NoViableAltException nvae =
                                    new NoViableAltException("", 14, 26, input);

                                throw nvae;

                            }
                        }
                        else {
                            NoViableAltException nvae =
                                new NoViableAltException("", 14, 20, input);

                            throw nvae;

                        }
                        }
                        break;
                    default:
                        NoViableAltException nvae =
                            new NoViableAltException("", 14, 10, input);

                        throw nvae;

                    }

                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 14, 3, input);

                    throw nvae;

                }
                }
                break;
            case MINUS:
            case PLUS:
                {
                switch ( input.LA(2) ) {
                case NUM_INT:
                    {
                    int LA14_11 = input.LA(3);

                    if ( (LA14_11==DOTDOT) ) {
                        switch ( input.LA(4) ) {
                        case NUM_INT:
                            {
                            alt14=1;
                            }
                            break;
                        case NUM_REAL:
                            {
                            alt14=1;
                            }
                            break;
                        case MINUS:
                        case PLUS:
                            {
                            switch ( input.LA(5) ) {
                            case NUM_INT:
                                {
                                alt14=1;
                                }
                                break;
                            case NUM_REAL:
                                {
                                alt14=1;
                                }
                                break;
                            case IDENT:
                                {
                                alt14=1;
                                }
                                break;
                            default:
                                NoViableAltException nvae =
                                    new NoViableAltException("", 14, 17, input);

                                throw nvae;

                            }

                            }
                            break;
                        case IDENT:
                            {
                            alt14=1;
                            }
                            break;
                        case STRING_LITERAL:
                            {
                            alt14=1;
                            }
                            break;
                        case CHR:
                            {
                            int LA14_20 = input.LA(5);

                            if ( (LA14_20==LPAREN) ) {
                                int LA14_26 = input.LA(6);

                                if ( (LA14_26==NUM_INT) ) {
                                    int LA14_28 = input.LA(7);

                                    if ( (LA14_28==RPAREN) ) {
                                        alt14=1;
                                    }
                                    else {
                                        NoViableAltException nvae =
                                            new NoViableAltException("", 14, 28, input);

                                        throw nvae;

                                    }
                                }
                                else if ( (LA14_26==IDENT) ) {
                                    int LA14_29 = input.LA(7);

                                    if ( (LA14_29==RPAREN) ) {
                                        alt14=1;
                                    }
                                    else {
                                        NoViableAltException nvae =
                                            new NoViableAltException("", 14, 29, input);

                                        throw nvae;

                                    }
                                }
                                else {
                                    NoViableAltException nvae =
                                        new NoViableAltException("", 14, 26, input);

                                    throw nvae;

                                }
                            }
                            else {
                                NoViableAltException nvae =
                                    new NoViableAltException("", 14, 20, input);

                                throw nvae;

                            }
                            }
                            break;
                        default:
                            NoViableAltException nvae =
                                new NoViableAltException("", 14, 10, input);

                            throw nvae;

                        }

                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 14, 11, input);

                        throw nvae;

                    }
                    }
                    break;
                case NUM_REAL:
                    {
                    int LA14_12 = input.LA(3);

                    if ( (LA14_12==DOTDOT) ) {
                        switch ( input.LA(4) ) {
                        case NUM_INT:
                            {
                            alt14=1;
                            }
                            break;
                        case NUM_REAL:
                            {
                            alt14=1;
                            }
                            break;
                        case MINUS:
                        case PLUS:
                            {
                            switch ( input.LA(5) ) {
                            case NUM_INT:
                                {
                                alt14=1;
                                }
                                break;
                            case NUM_REAL:
                                {
                                alt14=1;
                                }
                                break;
                            case IDENT:
                                {
                                alt14=1;
                                }
                                break;
                            default:
                                NoViableAltException nvae =
                                    new NoViableAltException("", 14, 17, input);

                                throw nvae;

                            }

                            }
                            break;
                        case IDENT:
                            {
                            alt14=1;
                            }
                            break;
                        case STRING_LITERAL:
                            {
                            alt14=1;
                            }
                            break;
                        case CHR:
                            {
                            int LA14_20 = input.LA(5);

                            if ( (LA14_20==LPAREN) ) {
                                int LA14_26 = input.LA(6);

                                if ( (LA14_26==NUM_INT) ) {
                                    int LA14_28 = input.LA(7);

                                    if ( (LA14_28==RPAREN) ) {
                                        alt14=1;
                                    }
                                    else {
                                        NoViableAltException nvae =
                                            new NoViableAltException("", 14, 28, input);

                                        throw nvae;

                                    }
                                }
                                else if ( (LA14_26==IDENT) ) {
                                    int LA14_29 = input.LA(7);

                                    if ( (LA14_29==RPAREN) ) {
                                        alt14=1;
                                    }
                                    else {
                                        NoViableAltException nvae =
                                            new NoViableAltException("", 14, 29, input);

                                        throw nvae;

                                    }
                                }
                                else {
                                    NoViableAltException nvae =
                                        new NoViableAltException("", 14, 26, input);

                                    throw nvae;

                                }
                            }
                            else {
                                NoViableAltException nvae =
                                    new NoViableAltException("", 14, 20, input);

                                throw nvae;

                            }
                            }
                            break;
                        default:
                            NoViableAltException nvae =
                                new NoViableAltException("", 14, 10, input);

                            throw nvae;

                        }

                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 14, 12, input);

                        throw nvae;

                    }
                    }
                    break;
                case IDENT:
                    {
                    int LA14_13 = input.LA(3);

                    if ( (LA14_13==DOTDOT) ) {
                        switch ( input.LA(4) ) {
                        case NUM_INT:
                            {
                            alt14=1;
                            }
                            break;
                        case NUM_REAL:
                            {
                            alt14=1;
                            }
                            break;
                        case MINUS:
                        case PLUS:
                            {
                            switch ( input.LA(5) ) {
                            case NUM_INT:
                                {
                                alt14=1;
                                }
                                break;
                            case NUM_REAL:
                                {
                                alt14=1;
                                }
                                break;
                            case IDENT:
                                {
                                alt14=1;
                                }
                                break;
                            default:
                                NoViableAltException nvae =
                                    new NoViableAltException("", 14, 17, input);

                                throw nvae;

                            }

                            }
                            break;
                        case IDENT:
                            {
                            alt14=1;
                            }
                            break;
                        case STRING_LITERAL:
                            {
                            alt14=1;
                            }
                            break;
                        case CHR:
                            {
                            int LA14_20 = input.LA(5);

                            if ( (LA14_20==LPAREN) ) {
                                int LA14_26 = input.LA(6);

                                if ( (LA14_26==NUM_INT) ) {
                                    int LA14_28 = input.LA(7);

                                    if ( (LA14_28==RPAREN) ) {
                                        alt14=1;
                                    }
                                    else {
                                        NoViableAltException nvae =
                                            new NoViableAltException("", 14, 28, input);

                                        throw nvae;

                                    }
                                }
                                else if ( (LA14_26==IDENT) ) {
                                    int LA14_29 = input.LA(7);

                                    if ( (LA14_29==RPAREN) ) {
                                        alt14=1;
                                    }
                                    else {
                                        NoViableAltException nvae =
                                            new NoViableAltException("", 14, 29, input);

                                        throw nvae;

                                    }
                                }
                                else {
                                    NoViableAltException nvae =
                                        new NoViableAltException("", 14, 26, input);

                                    throw nvae;

                                }
                            }
                            else {
                                NoViableAltException nvae =
                                    new NoViableAltException("", 14, 20, input);

                                throw nvae;

                            }
                            }
                            break;
                        default:
                            NoViableAltException nvae =
                                new NoViableAltException("", 14, 10, input);

                            throw nvae;

                        }

                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 14, 13, input);

                        throw nvae;

                    }
                    }
                    break;
                default:
                    NoViableAltException nvae =
                        new NoViableAltException("", 14, 4, input);

                    throw nvae;

                }

                }
                break;
            case IDENT:
                {
                int LA14_5 = input.LA(2);

                if ( (LA14_5==DOTDOT) ) {
                    switch ( input.LA(3) ) {
                    case NUM_INT:
                        {
                        alt14=1;
                        }
                        break;
                    case NUM_REAL:
                        {
                        alt14=1;
                        }
                        break;
                    case MINUS:
                    case PLUS:
                        {
                        switch ( input.LA(4) ) {
                        case NUM_INT:
                            {
                            alt14=1;
                            }
                            break;
                        case NUM_REAL:
                            {
                            alt14=1;
                            }
                            break;
                        case IDENT:
                            {
                            alt14=1;
                            }
                            break;
                        default:
                            NoViableAltException nvae =
                                new NoViableAltException("", 14, 17, input);

                            throw nvae;

                        }

                        }
                        break;
                    case IDENT:
                        {
                        alt14=1;
                        }
                        break;
                    case STRING_LITERAL:
                        {
                        alt14=1;
                        }
                        break;
                    case CHR:
                        {
                        int LA14_20 = input.LA(4);

                        if ( (LA14_20==LPAREN) ) {
                            int LA14_26 = input.LA(5);

                            if ( (LA14_26==NUM_INT) ) {
                                int LA14_28 = input.LA(6);

                                if ( (LA14_28==RPAREN) ) {
                                    alt14=1;
                                }
                                else {
                                    NoViableAltException nvae =
                                        new NoViableAltException("", 14, 28, input);

                                    throw nvae;

                                }
                            }
                            else if ( (LA14_26==IDENT) ) {
                                int LA14_29 = input.LA(6);

                                if ( (LA14_29==RPAREN) ) {
                                    alt14=1;
                                }
                                else {
                                    NoViableAltException nvae =
                                        new NoViableAltException("", 14, 29, input);

                                    throw nvae;

                                }
                            }
                            else {
                                NoViableAltException nvae =
                                    new NoViableAltException("", 14, 26, input);

                                throw nvae;

                            }
                        }
                        else {
                            NoViableAltException nvae =
                                new NoViableAltException("", 14, 20, input);

                            throw nvae;

                        }
                        }
                        break;
                    default:
                        NoViableAltException nvae =
                            new NoViableAltException("", 14, 10, input);

                        throw nvae;

                    }

                }
                else if ( (LA14_5==END||LA14_5==RPAREN||LA14_5==SEMI) ) {
                    alt14=1;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 14, 5, input);

                    throw nvae;

                }
                }
                break;
            case STRING_LITERAL:
                {
                int LA14_6 = input.LA(2);

                if ( (LA14_6==DOTDOT) ) {
                    switch ( input.LA(3) ) {
                    case NUM_INT:
                        {
                        alt14=1;
                        }
                        break;
                    case NUM_REAL:
                        {
                        alt14=1;
                        }
                        break;
                    case MINUS:
                    case PLUS:
                        {
                        switch ( input.LA(4) ) {
                        case NUM_INT:
                            {
                            alt14=1;
                            }
                            break;
                        case NUM_REAL:
                            {
                            alt14=1;
                            }
                            break;
                        case IDENT:
                            {
                            alt14=1;
                            }
                            break;
                        default:
                            NoViableAltException nvae =
                                new NoViableAltException("", 14, 17, input);

                            throw nvae;

                        }

                        }
                        break;
                    case IDENT:
                        {
                        alt14=1;
                        }
                        break;
                    case STRING_LITERAL:
                        {
                        alt14=1;
                        }
                        break;
                    case CHR:
                        {
                        int LA14_20 = input.LA(4);

                        if ( (LA14_20==LPAREN) ) {
                            int LA14_26 = input.LA(5);

                            if ( (LA14_26==NUM_INT) ) {
                                int LA14_28 = input.LA(6);

                                if ( (LA14_28==RPAREN) ) {
                                    alt14=1;
                                }
                                else {
                                    NoViableAltException nvae =
                                        new NoViableAltException("", 14, 28, input);

                                    throw nvae;

                                }
                            }
                            else if ( (LA14_26==IDENT) ) {
                                int LA14_29 = input.LA(6);

                                if ( (LA14_29==RPAREN) ) {
                                    alt14=1;
                                }
                                else {
                                    NoViableAltException nvae =
                                        new NoViableAltException("", 14, 29, input);

                                    throw nvae;

                                }
                            }
                            else {
                                NoViableAltException nvae =
                                    new NoViableAltException("", 14, 26, input);

                                throw nvae;

                            }
                        }
                        else {
                            NoViableAltException nvae =
                                new NoViableAltException("", 14, 20, input);

                            throw nvae;

                        }
                        }
                        break;
                    default:
                        NoViableAltException nvae =
                            new NoViableAltException("", 14, 10, input);

                        throw nvae;

                    }

                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 14, 6, input);

                    throw nvae;

                }
                }
                break;
            case CHR:
                {
                int LA14_7 = input.LA(2);

                if ( (LA14_7==LPAREN) ) {
                    int LA14_14 = input.LA(3);

                    if ( (LA14_14==NUM_INT) ) {
                        int LA14_21 = input.LA(4);

                        if ( (LA14_21==RPAREN) ) {
                            int LA14_27 = input.LA(5);

                            if ( (LA14_27==DOTDOT) ) {
                                switch ( input.LA(6) ) {
                                case NUM_INT:
                                    {
                                    alt14=1;
                                    }
                                    break;
                                case NUM_REAL:
                                    {
                                    alt14=1;
                                    }
                                    break;
                                case MINUS:
                                case PLUS:
                                    {
                                    switch ( input.LA(7) ) {
                                    case NUM_INT:
                                        {
                                        alt14=1;
                                        }
                                        break;
                                    case NUM_REAL:
                                        {
                                        alt14=1;
                                        }
                                        break;
                                    case IDENT:
                                        {
                                        alt14=1;
                                        }
                                        break;
                                    default:
                                        NoViableAltException nvae =
                                            new NoViableAltException("", 14, 17, input);

                                        throw nvae;

                                    }

                                    }
                                    break;
                                case IDENT:
                                    {
                                    alt14=1;
                                    }
                                    break;
                                case STRING_LITERAL:
                                    {
                                    alt14=1;
                                    }
                                    break;
                                case CHR:
                                    {
                                    int LA14_20 = input.LA(7);

                                    if ( (LA14_20==LPAREN) ) {
                                        int LA14_26 = input.LA(8);

                                        if ( (LA14_26==NUM_INT) ) {
                                            int LA14_28 = input.LA(9);

                                            if ( (LA14_28==RPAREN) ) {
                                                alt14=1;
                                            }
                                            else {
                                                NoViableAltException nvae =
                                                    new NoViableAltException("", 14, 28, input);

                                                throw nvae;

                                            }
                                        }
                                        else if ( (LA14_26==IDENT) ) {
                                            int LA14_29 = input.LA(9);

                                            if ( (LA14_29==RPAREN) ) {
                                                alt14=1;
                                            }
                                            else {
                                                NoViableAltException nvae =
                                                    new NoViableAltException("", 14, 29, input);

                                                throw nvae;

                                            }
                                        }
                                        else {
                                            NoViableAltException nvae =
                                                new NoViableAltException("", 14, 26, input);

                                            throw nvae;

                                        }
                                    }
                                    else {
                                        NoViableAltException nvae =
                                            new NoViableAltException("", 14, 20, input);

                                        throw nvae;

                                    }
                                    }
                                    break;
                                default:
                                    NoViableAltException nvae =
                                        new NoViableAltException("", 14, 10, input);

                                    throw nvae;

                                }

                            }
                            else {
                                NoViableAltException nvae =
                                    new NoViableAltException("", 14, 27, input);

                                throw nvae;

                            }
                        }
                        else {
                            NoViableAltException nvae =
                                new NoViableAltException("", 14, 21, input);

                            throw nvae;

                        }
                    }
                    else if ( (LA14_14==IDENT) ) {
                        int LA14_22 = input.LA(4);

                        if ( (LA14_22==RPAREN) ) {
                            int LA14_27 = input.LA(5);

                            if ( (LA14_27==DOTDOT) ) {
                                switch ( input.LA(6) ) {
                                case NUM_INT:
                                    {
                                    alt14=1;
                                    }
                                    break;
                                case NUM_REAL:
                                    {
                                    alt14=1;
                                    }
                                    break;
                                case MINUS:
                                case PLUS:
                                    {
                                    switch ( input.LA(7) ) {
                                    case NUM_INT:
                                        {
                                        alt14=1;
                                        }
                                        break;
                                    case NUM_REAL:
                                        {
                                        alt14=1;
                                        }
                                        break;
                                    case IDENT:
                                        {
                                        alt14=1;
                                        }
                                        break;
                                    default:
                                        NoViableAltException nvae =
                                            new NoViableAltException("", 14, 17, input);

                                        throw nvae;

                                    }

                                    }
                                    break;
                                case IDENT:
                                    {
                                    alt14=1;
                                    }
                                    break;
                                case STRING_LITERAL:
                                    {
                                    alt14=1;
                                    }
                                    break;
                                case CHR:
                                    {
                                    int LA14_20 = input.LA(7);

                                    if ( (LA14_20==LPAREN) ) {
                                        int LA14_26 = input.LA(8);

                                        if ( (LA14_26==NUM_INT) ) {
                                            int LA14_28 = input.LA(9);

                                            if ( (LA14_28==RPAREN) ) {
                                                alt14=1;
                                            }
                                            else {
                                                NoViableAltException nvae =
                                                    new NoViableAltException("", 14, 28, input);

                                                throw nvae;

                                            }
                                        }
                                        else if ( (LA14_26==IDENT) ) {
                                            int LA14_29 = input.LA(9);

                                            if ( (LA14_29==RPAREN) ) {
                                                alt14=1;
                                            }
                                            else {
                                                NoViableAltException nvae =
                                                    new NoViableAltException("", 14, 29, input);

                                                throw nvae;

                                            }
                                        }
                                        else {
                                            NoViableAltException nvae =
                                                new NoViableAltException("", 14, 26, input);

                                            throw nvae;

                                        }
                                    }
                                    else {
                                        NoViableAltException nvae =
                                            new NoViableAltException("", 14, 20, input);

                                        throw nvae;

                                    }
                                    }
                                    break;
                                default:
                                    NoViableAltException nvae =
                                        new NoViableAltException("", 14, 10, input);

                                    throw nvae;

                                }

                            }
                            else {
                                NoViableAltException nvae =
                                    new NoViableAltException("", 14, 27, input);

                                throw nvae;

                            }
                        }
                        else {
                            NoViableAltException nvae =
                                new NoViableAltException("", 14, 22, input);

                            throw nvae;

                        }
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 14, 14, input);

                        throw nvae;

                    }
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 14, 7, input);

                    throw nvae;

                }
                }
                break;
            case ARRAY:
            case FILE:
            case PACKED:
            case RECORD:
            case SET:
                {
                alt14=2;
                }
                break;
            case POINTER:
                {
                alt14=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 14, 0, input);

                throw nvae;

            }

            switch (alt14) {
                case 1 :
                    // pascal3g.g:320:7: simpleType
                    {
                    root_0 = (Object)adaptor.nil();


                    pushFollow(FOLLOW_simpleType_in_type2937);
                    simpleType70=simpleType();

                    state._fsp--;

                    adaptor.addChild(root_0, simpleType70.getTree());

                    }
                    break;
                case 2 :
                    // pascal3g.g:321:7: structuredType
                    {
                    root_0 = (Object)adaptor.nil();


                    pushFollow(FOLLOW_structuredType_in_type2945);
                    structuredType71=structuredType();

                    state._fsp--;

                    adaptor.addChild(root_0, structuredType71.getTree());

                    }
                    break;
                case 3 :
                    // pascal3g.g:322:7: pointerType
                    {
                    root_0 = (Object)adaptor.nil();


                    pushFollow(FOLLOW_pointerType_in_type2953);
                    pointerType72=pointerType();

                    state._fsp--;

                    adaptor.addChild(root_0, pointerType72.getTree());

                    }
                    break;

            }
            retval.stop = input.LT(-1);


            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "type"


    public static class simpleType_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "simpleType"
    // pascal3g.g:325:1: simpleType : ( scalarType | subrangeType | typeIdentifier | stringtype );
    public final simpleType_return simpleType() throws RecognitionException {
        simpleType_return retval = new simpleType_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        scalarType_return scalarType73 =null;

        subrangeType_return subrangeType74 =null;

        typeIdentifier_return typeIdentifier75 =null;

        stringtype_return stringtype76 =null;



        try {
            // pascal3g.g:326:5: ( scalarType | subrangeType | typeIdentifier | stringtype )
            int alt15=4;
            switch ( input.LA(1) ) {
            case LPAREN:
                {
                alt15=1;
                }
                break;
            case CHR:
            case MINUS:
            case NUM_INT:
            case NUM_REAL:
            case PLUS:
            case STRING_LITERAL:
                {
                alt15=2;
                }
                break;
            case IDENT:
                {
                int LA15_3 = input.LA(2);

                if ( (LA15_3==DOTDOT) ) {
                    alt15=2;
                }
                else if ( (LA15_3==COMMA||LA15_3==END||(LA15_3 >= RBRACK && LA15_3 <= RBRACK2)||LA15_3==RPAREN||LA15_3==SEMI) ) {
                    alt15=3;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 15, 3, input);

                    throw nvae;

                }
                }
                break;
            case BOOLEAN:
            case CHAR:
            case INTEGER:
            case REAL:
                {
                alt15=3;
                }
                break;
            case STRING:
                {
                int LA15_5 = input.LA(2);

                if ( (LA15_5==LBRACK2||LA15_5==LPAREN) ) {
                    alt15=4;
                }
                else if ( (LA15_5==COMMA||LA15_5==END||(LA15_5 >= RBRACK && LA15_5 <= RBRACK2)||LA15_5==RPAREN||LA15_5==SEMI) ) {
                    alt15=3;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 15, 5, input);

                    throw nvae;

                }
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 15, 0, input);

                throw nvae;

            }

            switch (alt15) {
                case 1 :
                    // pascal3g.g:326:7: scalarType
                    {
                    root_0 = (Object)adaptor.nil();


                    pushFollow(FOLLOW_scalarType_in_simpleType2970);
                    scalarType73=scalarType();

                    state._fsp--;

                    adaptor.addChild(root_0, scalarType73.getTree());

                    }
                    break;
                case 2 :
                    // pascal3g.g:327:7: subrangeType
                    {
                    root_0 = (Object)adaptor.nil();


                    pushFollow(FOLLOW_subrangeType_in_simpleType2978);
                    subrangeType74=subrangeType();

                    state._fsp--;

                    adaptor.addChild(root_0, subrangeType74.getTree());

                    }
                    break;
                case 3 :
                    // pascal3g.g:328:7: typeIdentifier
                    {
                    root_0 = (Object)adaptor.nil();


                    pushFollow(FOLLOW_typeIdentifier_in_simpleType2987);
                    typeIdentifier75=typeIdentifier();

                    state._fsp--;

                    adaptor.addChild(root_0, typeIdentifier75.getTree());

                    }
                    break;
                case 4 :
                    // pascal3g.g:329:7: stringtype
                    {
                    root_0 = (Object)adaptor.nil();


                    pushFollow(FOLLOW_stringtype_in_simpleType2995);
                    stringtype76=stringtype();

                    state._fsp--;

                    adaptor.addChild(root_0, stringtype76.getTree());

                    }
                    break;

            }
            retval.stop = input.LT(-1);


            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "simpleType"


    public static class scalarType_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "scalarType"
    // pascal3g.g:332:1: scalarType : LPAREN identifierList RPAREN -> ^( SCALARTYPE identifierList ) ;
    public final scalarType_return scalarType() throws RecognitionException {
        scalarType_return retval = new scalarType_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token LPAREN77=null;
        Token RPAREN79=null;
        identifierList_return identifierList78 =null;


        Object LPAREN77_tree=null;
        Object RPAREN79_tree=null;
        RewriteRuleTokenStream stream_RPAREN=new RewriteRuleTokenStream(adaptor,"token RPAREN");
        RewriteRuleTokenStream stream_LPAREN=new RewriteRuleTokenStream(adaptor,"token LPAREN");
        RewriteRuleSubtreeStream stream_identifierList=new RewriteRuleSubtreeStream(adaptor,"rule identifierList");
        try {
            // pascal3g.g:333:5: ( LPAREN identifierList RPAREN -> ^( SCALARTYPE identifierList ) )
            // pascal3g.g:333:7: LPAREN identifierList RPAREN
            {
            LPAREN77=(Token)match(input,LPAREN,FOLLOW_LPAREN_in_scalarType3012);  
            stream_LPAREN.add(LPAREN77);


            pushFollow(FOLLOW_identifierList_in_scalarType3014);
            identifierList78=identifierList();

            state._fsp--;

            stream_identifierList.add(identifierList78.getTree());

            RPAREN79=(Token)match(input,RPAREN,FOLLOW_RPAREN_in_scalarType3016);  
            stream_RPAREN.add(RPAREN79);


            // AST REWRITE
            // elements: identifierList
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 334:5: -> ^( SCALARTYPE identifierList )
            {
                // pascal3g.g:334:8: ^( SCALARTYPE identifierList )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot(
                (Object)adaptor.create(SCALARTYPE, "SCALARTYPE")
                , root_1);

                adaptor.addChild(root_1, stream_identifierList.nextTree());

                adaptor.addChild(root_0, root_1);
                }

            }


            retval.tree = root_0;

            }

            retval.stop = input.LT(-1);


            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "scalarType"


    public static class subrangeType_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "subrangeType"
    // pascal3g.g:337:1: subrangeType : c1= constant DOTDOT c2= constant -> ^( SUBRANGE $c1 $c2) ;
    public final subrangeType_return subrangeType() throws RecognitionException {
        subrangeType_return retval = new subrangeType_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token DOTDOT80=null;
        constant_return c1 =null;

        constant_return c2 =null;


        Object DOTDOT80_tree=null;
        RewriteRuleTokenStream stream_DOTDOT=new RewriteRuleTokenStream(adaptor,"token DOTDOT");
        RewriteRuleSubtreeStream stream_constant=new RewriteRuleSubtreeStream(adaptor,"rule constant");
        try {
            // pascal3g.g:338:5: (c1= constant DOTDOT c2= constant -> ^( SUBRANGE $c1 $c2) )
            // pascal3g.g:338:7: c1= constant DOTDOT c2= constant
            {
            pushFollow(FOLLOW_constant_in_subrangeType3048);
            c1=constant();

            state._fsp--;

            stream_constant.add(c1.getTree());

            DOTDOT80=(Token)match(input,DOTDOT,FOLLOW_DOTDOT_in_subrangeType3050);  
            stream_DOTDOT.add(DOTDOT80);


            pushFollow(FOLLOW_constant_in_subrangeType3054);
            c2=constant();

            state._fsp--;

            stream_constant.add(c2.getTree());

            // AST REWRITE
            // elements: c1, c2
            // token labels: 
            // rule labels: retval, c1, c2
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);
            RewriteRuleSubtreeStream stream_c1=new RewriteRuleSubtreeStream(adaptor,"rule c1",c1!=null?c1.tree:null);
            RewriteRuleSubtreeStream stream_c2=new RewriteRuleSubtreeStream(adaptor,"rule c2",c2!=null?c2.tree:null);

            root_0 = (Object)adaptor.nil();
            // 339:5: -> ^( SUBRANGE $c1 $c2)
            {
                // pascal3g.g:339:8: ^( SUBRANGE $c1 $c2)
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot(
                (Object)adaptor.create(SUBRANGE, "SUBRANGE")
                , root_1);

                adaptor.addChild(root_1, stream_c1.nextTree());

                adaptor.addChild(root_1, stream_c2.nextTree());

                adaptor.addChild(root_0, root_1);
                }

            }


            retval.tree = root_0;

            }

            retval.stop = input.LT(-1);


            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "subrangeType"


    public static class typeIdentifier_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "typeIdentifier"
    // pascal3g.g:342:1: typeIdentifier : ( identifier | CHAR | BOOLEAN | INTEGER | REAL | STRING );
    public final typeIdentifier_return typeIdentifier() throws RecognitionException {
        typeIdentifier_return retval = new typeIdentifier_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token CHAR82=null;
        Token BOOLEAN83=null;
        Token INTEGER84=null;
        Token REAL85=null;
        Token STRING86=null;
        identifier_return identifier81 =null;


        Object CHAR82_tree=null;
        Object BOOLEAN83_tree=null;
        Object INTEGER84_tree=null;
        Object REAL85_tree=null;
        Object STRING86_tree=null;

        try {
            // pascal3g.g:343:5: ( identifier | CHAR | BOOLEAN | INTEGER | REAL | STRING )
            int alt16=6;
            switch ( input.LA(1) ) {
            case IDENT:
                {
                alt16=1;
                }
                break;
            case CHAR:
                {
                alt16=2;
                }
                break;
            case BOOLEAN:
                {
                alt16=3;
                }
                break;
            case INTEGER:
                {
                alt16=4;
                }
                break;
            case REAL:
                {
                alt16=5;
                }
                break;
            case STRING:
                {
                alt16=6;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 16, 0, input);

                throw nvae;

            }

            switch (alt16) {
                case 1 :
                    // pascal3g.g:343:7: identifier
                    {
                    root_0 = (Object)adaptor.nil();


                    pushFollow(FOLLOW_identifier_in_typeIdentifier3087);
                    identifier81=identifier();

                    state._fsp--;

                    adaptor.addChild(root_0, identifier81.getTree());

                    }
                    break;
                case 2 :
                    // pascal3g.g:344:7: CHAR
                    {
                    root_0 = (Object)adaptor.nil();


                    CHAR82=(Token)match(input,CHAR,FOLLOW_CHAR_in_typeIdentifier3095); 
                    CHAR82_tree = 
                    (Object)adaptor.create(CHAR82)
                    ;
                    adaptor.addChild(root_0, CHAR82_tree);


                    }
                    break;
                case 3 :
                    // pascal3g.g:345:7: BOOLEAN
                    {
                    root_0 = (Object)adaptor.nil();


                    BOOLEAN83=(Token)match(input,BOOLEAN,FOLLOW_BOOLEAN_in_typeIdentifier3103); 
                    BOOLEAN83_tree = 
                    (Object)adaptor.create(BOOLEAN83)
                    ;
                    adaptor.addChild(root_0, BOOLEAN83_tree);


                    }
                    break;
                case 4 :
                    // pascal3g.g:346:7: INTEGER
                    {
                    root_0 = (Object)adaptor.nil();


                    INTEGER84=(Token)match(input,INTEGER,FOLLOW_INTEGER_in_typeIdentifier3111); 
                    INTEGER84_tree = 
                    (Object)adaptor.create(INTEGER84)
                    ;
                    adaptor.addChild(root_0, INTEGER84_tree);


                    }
                    break;
                case 5 :
                    // pascal3g.g:347:7: REAL
                    {
                    root_0 = (Object)adaptor.nil();


                    REAL85=(Token)match(input,REAL,FOLLOW_REAL_in_typeIdentifier3119); 
                    REAL85_tree = 
                    (Object)adaptor.create(REAL85)
                    ;
                    adaptor.addChild(root_0, REAL85_tree);


                    }
                    break;
                case 6 :
                    // pascal3g.g:348:7: STRING
                    {
                    root_0 = (Object)adaptor.nil();


                    STRING86=(Token)match(input,STRING,FOLLOW_STRING_in_typeIdentifier3127); 
                    STRING86_tree = 
                    (Object)adaptor.create(STRING86)
                    ;
                    adaptor.addChild(root_0, STRING86_tree);


                    }
                    break;

            }
            retval.stop = input.LT(-1);


            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "typeIdentifier"


    public static class structuredType_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "structuredType"
    // pascal3g.g:351:1: structuredType : ( PACKED ^ unpackedStructuredType | unpackedStructuredType );
    public final structuredType_return structuredType() throws RecognitionException {
        structuredType_return retval = new structuredType_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token PACKED87=null;
        unpackedStructuredType_return unpackedStructuredType88 =null;

        unpackedStructuredType_return unpackedStructuredType89 =null;


        Object PACKED87_tree=null;

        try {
            // pascal3g.g:352:5: ( PACKED ^ unpackedStructuredType | unpackedStructuredType )
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==PACKED) ) {
                alt17=1;
            }
            else if ( (LA17_0==ARRAY||LA17_0==CHR||LA17_0==FILE||LA17_0==IDENT||LA17_0==MINUS||(LA17_0 >= NUM_INT && LA17_0 <= NUM_REAL)||LA17_0==PLUS||LA17_0==RECORD||LA17_0==SET||LA17_0==STRING_LITERAL) ) {
                alt17=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 17, 0, input);

                throw nvae;

            }
            switch (alt17) {
                case 1 :
                    // pascal3g.g:352:7: PACKED ^ unpackedStructuredType
                    {
                    root_0 = (Object)adaptor.nil();


                    PACKED87=(Token)match(input,PACKED,FOLLOW_PACKED_in_structuredType3145); 
                    PACKED87_tree = 
                    (Object)adaptor.create(PACKED87)
                    ;
                    root_0 = (Object)adaptor.becomeRoot(PACKED87_tree, root_0);


                    pushFollow(FOLLOW_unpackedStructuredType_in_structuredType3148);
                    unpackedStructuredType88=unpackedStructuredType();

                    state._fsp--;

                    adaptor.addChild(root_0, unpackedStructuredType88.getTree());

                    }
                    break;
                case 2 :
                    // pascal3g.g:353:6: unpackedStructuredType
                    {
                    root_0 = (Object)adaptor.nil();


                    pushFollow(FOLLOW_unpackedStructuredType_in_structuredType3155);
                    unpackedStructuredType89=unpackedStructuredType();

                    state._fsp--;

                    adaptor.addChild(root_0, unpackedStructuredType89.getTree());

                    }
                    break;

            }
            retval.stop = input.LT(-1);


            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "structuredType"


    public static class unpackedStructuredType_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "unpackedStructuredType"
    // pascal3g.g:356:1: unpackedStructuredType : ( arrayType | recordType | setType | fileType | subrangeType );
    public final unpackedStructuredType_return unpackedStructuredType() throws RecognitionException {
        unpackedStructuredType_return retval = new unpackedStructuredType_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        arrayType_return arrayType90 =null;

        recordType_return recordType91 =null;

        setType_return setType92 =null;

        fileType_return fileType93 =null;

        subrangeType_return subrangeType94 =null;



        try {
            // pascal3g.g:357:5: ( arrayType | recordType | setType | fileType | subrangeType )
            int alt18=5;
            switch ( input.LA(1) ) {
            case ARRAY:
                {
                alt18=1;
                }
                break;
            case RECORD:
                {
                alt18=2;
                }
                break;
            case SET:
                {
                alt18=3;
                }
                break;
            case FILE:
                {
                alt18=4;
                }
                break;
            case CHR:
            case IDENT:
            case MINUS:
            case NUM_INT:
            case NUM_REAL:
            case PLUS:
            case STRING_LITERAL:
                {
                alt18=5;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 18, 0, input);

                throw nvae;

            }

            switch (alt18) {
                case 1 :
                    // pascal3g.g:357:7: arrayType
                    {
                    root_0 = (Object)adaptor.nil();


                    pushFollow(FOLLOW_arrayType_in_unpackedStructuredType3172);
                    arrayType90=arrayType();

                    state._fsp--;

                    adaptor.addChild(root_0, arrayType90.getTree());

                    }
                    break;
                case 2 :
                    // pascal3g.g:358:7: recordType
                    {
                    root_0 = (Object)adaptor.nil();


                    pushFollow(FOLLOW_recordType_in_unpackedStructuredType3180);
                    recordType91=recordType();

                    state._fsp--;

                    adaptor.addChild(root_0, recordType91.getTree());

                    }
                    break;
                case 3 :
                    // pascal3g.g:359:7: setType
                    {
                    root_0 = (Object)adaptor.nil();


                    pushFollow(FOLLOW_setType_in_unpackedStructuredType3188);
                    setType92=setType();

                    state._fsp--;

                    adaptor.addChild(root_0, setType92.getTree());

                    }
                    break;
                case 4 :
                    // pascal3g.g:360:7: fileType
                    {
                    root_0 = (Object)adaptor.nil();


                    pushFollow(FOLLOW_fileType_in_unpackedStructuredType3196);
                    fileType93=fileType();

                    state._fsp--;

                    adaptor.addChild(root_0, fileType93.getTree());

                    }
                    break;
                case 5 :
                    // pascal3g.g:361:7: subrangeType
                    {
                    root_0 = (Object)adaptor.nil();


                    pushFollow(FOLLOW_subrangeType_in_unpackedStructuredType3204);
                    subrangeType94=subrangeType();

                    state._fsp--;

                    adaptor.addChild(root_0, subrangeType94.getTree());

                    }
                    break;

            }
            retval.stop = input.LT(-1);


            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "unpackedStructuredType"


    public static class stringtype_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "stringtype"
    // pascal3g.g:364:1: stringtype : ( STRING ^ LPAREN ! ( identifier | unsignedNumber ) RPAREN !| STRING ^ LBRACK2 ! ( identifier | unsignedNumber ) RBRACK2 !);
    public final stringtype_return stringtype() throws RecognitionException {
        stringtype_return retval = new stringtype_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token STRING95=null;
        Token LPAREN96=null;
        Token RPAREN99=null;
        Token STRING100=null;
        Token LBRACK2101=null;
        Token RBRACK2104=null;
        identifier_return identifier97 =null;

        unsignedNumber_return unsignedNumber98 =null;

        identifier_return identifier102 =null;

        unsignedNumber_return unsignedNumber103 =null;


        Object STRING95_tree=null;
        Object LPAREN96_tree=null;
        Object RPAREN99_tree=null;
        Object STRING100_tree=null;
        Object LBRACK2101_tree=null;
        Object RBRACK2104_tree=null;

        try {
            // pascal3g.g:365:5: ( STRING ^ LPAREN ! ( identifier | unsignedNumber ) RPAREN !| STRING ^ LBRACK2 ! ( identifier | unsignedNumber ) RBRACK2 !)
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==STRING) ) {
                int LA21_1 = input.LA(2);

                if ( (LA21_1==LPAREN) ) {
                    alt21=1;
                }
                else if ( (LA21_1==LBRACK2) ) {
                    alt21=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 21, 1, input);

                    throw nvae;

                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 21, 0, input);

                throw nvae;

            }
            switch (alt21) {
                case 1 :
                    // pascal3g.g:365:7: STRING ^ LPAREN ! ( identifier | unsignedNumber ) RPAREN !
                    {
                    root_0 = (Object)adaptor.nil();


                    STRING95=(Token)match(input,STRING,FOLLOW_STRING_in_stringtype3222); 
                    STRING95_tree = 
                    (Object)adaptor.create(STRING95)
                    ;
                    root_0 = (Object)adaptor.becomeRoot(STRING95_tree, root_0);


                    LPAREN96=(Token)match(input,LPAREN,FOLLOW_LPAREN_in_stringtype3225); 

                    // pascal3g.g:365:23: ( identifier | unsignedNumber )
                    int alt19=2;
                    int LA19_0 = input.LA(1);

                    if ( (LA19_0==IDENT) ) {
                        alt19=1;
                    }
                    else if ( ((LA19_0 >= NUM_INT && LA19_0 <= NUM_REAL)) ) {
                        alt19=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 19, 0, input);

                        throw nvae;

                    }
                    switch (alt19) {
                        case 1 :
                            // pascal3g.g:365:24: identifier
                            {
                            pushFollow(FOLLOW_identifier_in_stringtype3229);
                            identifier97=identifier();

                            state._fsp--;

                            adaptor.addChild(root_0, identifier97.getTree());

                            }
                            break;
                        case 2 :
                            // pascal3g.g:365:35: unsignedNumber
                            {
                            pushFollow(FOLLOW_unsignedNumber_in_stringtype3231);
                            unsignedNumber98=unsignedNumber();

                            state._fsp--;

                            adaptor.addChild(root_0, unsignedNumber98.getTree());

                            }
                            break;

                    }


                    RPAREN99=(Token)match(input,RPAREN,FOLLOW_RPAREN_in_stringtype3234); 

                    }
                    break;
                case 2 :
                    // pascal3g.g:366:7: STRING ^ LBRACK2 ! ( identifier | unsignedNumber ) RBRACK2 !
                    {
                    root_0 = (Object)adaptor.nil();


                    STRING100=(Token)match(input,STRING,FOLLOW_STRING_in_stringtype3244); 
                    STRING100_tree = 
                    (Object)adaptor.create(STRING100)
                    ;
                    root_0 = (Object)adaptor.becomeRoot(STRING100_tree, root_0);


                    LBRACK2101=(Token)match(input,LBRACK2,FOLLOW_LBRACK2_in_stringtype3247); 

                    // pascal3g.g:366:24: ( identifier | unsignedNumber )
                    int alt20=2;
                    int LA20_0 = input.LA(1);

                    if ( (LA20_0==IDENT) ) {
                        alt20=1;
                    }
                    else if ( ((LA20_0 >= NUM_INT && LA20_0 <= NUM_REAL)) ) {
                        alt20=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 20, 0, input);

                        throw nvae;

                    }
                    switch (alt20) {
                        case 1 :
                            // pascal3g.g:366:25: identifier
                            {
                            pushFollow(FOLLOW_identifier_in_stringtype3251);
                            identifier102=identifier();

                            state._fsp--;

                            adaptor.addChild(root_0, identifier102.getTree());

                            }
                            break;
                        case 2 :
                            // pascal3g.g:366:36: unsignedNumber
                            {
                            pushFollow(FOLLOW_unsignedNumber_in_stringtype3253);
                            unsignedNumber103=unsignedNumber();

                            state._fsp--;

                            adaptor.addChild(root_0, unsignedNumber103.getTree());

                            }
                            break;

                    }


                    RBRACK2104=(Token)match(input,RBRACK2,FOLLOW_RBRACK2_in_stringtype3256); 

                    }
                    break;

            }
            retval.stop = input.LT(-1);


            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "stringtype"


    public static class arrayType_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "arrayType"
    // pascal3g.g:369:1: arrayType : ( ARRAY ^ LBRACK ! typeList RBRACK ! OF ! componentType | ARRAY ^ LBRACK2 ! typeList RBRACK2 ! OF ! componentType );
    public final arrayType_return arrayType() throws RecognitionException {
        arrayType_return retval = new arrayType_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token ARRAY105=null;
        Token LBRACK106=null;
        Token RBRACK108=null;
        Token OF109=null;
        Token ARRAY111=null;
        Token LBRACK2112=null;
        Token RBRACK2114=null;
        Token OF115=null;
        typeList_return typeList107 =null;

        componentType_return componentType110 =null;

        typeList_return typeList113 =null;

        componentType_return componentType116 =null;


        Object ARRAY105_tree=null;
        Object LBRACK106_tree=null;
        Object RBRACK108_tree=null;
        Object OF109_tree=null;
        Object ARRAY111_tree=null;
        Object LBRACK2112_tree=null;
        Object RBRACK2114_tree=null;
        Object OF115_tree=null;

        try {
            // pascal3g.g:370:5: ( ARRAY ^ LBRACK ! typeList RBRACK ! OF ! componentType | ARRAY ^ LBRACK2 ! typeList RBRACK2 ! OF ! componentType )
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==ARRAY) ) {
                int LA22_1 = input.LA(2);

                if ( (LA22_1==LBRACK) ) {
                    alt22=1;
                }
                else if ( (LA22_1==LBRACK2) ) {
                    alt22=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 22, 1, input);

                    throw nvae;

                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 22, 0, input);

                throw nvae;

            }
            switch (alt22) {
                case 1 :
                    // pascal3g.g:370:7: ARRAY ^ LBRACK ! typeList RBRACK ! OF ! componentType
                    {
                    root_0 = (Object)adaptor.nil();


                    ARRAY105=(Token)match(input,ARRAY,FOLLOW_ARRAY_in_arrayType3275); 
                    ARRAY105_tree = 
                    (Object)adaptor.create(ARRAY105)
                    ;
                    root_0 = (Object)adaptor.becomeRoot(ARRAY105_tree, root_0);


                    LBRACK106=(Token)match(input,LBRACK,FOLLOW_LBRACK_in_arrayType3278); 

                    pushFollow(FOLLOW_typeList_in_arrayType3281);
                    typeList107=typeList();

                    state._fsp--;

                    adaptor.addChild(root_0, typeList107.getTree());

                    RBRACK108=(Token)match(input,RBRACK,FOLLOW_RBRACK_in_arrayType3283); 

                    OF109=(Token)match(input,OF,FOLLOW_OF_in_arrayType3286); 

                    pushFollow(FOLLOW_componentType_in_arrayType3289);
                    componentType110=componentType();

                    state._fsp--;

                    adaptor.addChild(root_0, componentType110.getTree());

                    }
                    break;
                case 2 :
                    // pascal3g.g:371:7: ARRAY ^ LBRACK2 ! typeList RBRACK2 ! OF ! componentType
                    {
                    root_0 = (Object)adaptor.nil();


                    ARRAY111=(Token)match(input,ARRAY,FOLLOW_ARRAY_in_arrayType3297); 
                    ARRAY111_tree = 
                    (Object)adaptor.create(ARRAY111)
                    ;
                    root_0 = (Object)adaptor.becomeRoot(ARRAY111_tree, root_0);


                    LBRACK2112=(Token)match(input,LBRACK2,FOLLOW_LBRACK2_in_arrayType3300); 

                    pushFollow(FOLLOW_typeList_in_arrayType3303);
                    typeList113=typeList();

                    state._fsp--;

                    adaptor.addChild(root_0, typeList113.getTree());

                    RBRACK2114=(Token)match(input,RBRACK2,FOLLOW_RBRACK2_in_arrayType3305); 

                    OF115=(Token)match(input,OF,FOLLOW_OF_in_arrayType3308); 

                    pushFollow(FOLLOW_componentType_in_arrayType3311);
                    componentType116=componentType();

                    state._fsp--;

                    adaptor.addChild(root_0, componentType116.getTree());

                    }
                    break;

            }
            retval.stop = input.LT(-1);


            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "arrayType"


    public static class typeList_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "typeList"
    // pascal3g.g:374:1: typeList : indexType ( COMMA indexType )* -> ^( TYPELIST ( indexType )+ ) ;
    public final typeList_return typeList() throws RecognitionException {
        typeList_return retval = new typeList_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token COMMA118=null;
        indexType_return indexType117 =null;

        indexType_return indexType119 =null;


        Object COMMA118_tree=null;
        RewriteRuleTokenStream stream_COMMA=new RewriteRuleTokenStream(adaptor,"token COMMA");
        RewriteRuleSubtreeStream stream_indexType=new RewriteRuleSubtreeStream(adaptor,"rule indexType");
        try {
            // pascal3g.g:375:3: ( indexType ( COMMA indexType )* -> ^( TYPELIST ( indexType )+ ) )
            // pascal3g.g:375:5: indexType ( COMMA indexType )*
            {
            pushFollow(FOLLOW_indexType_in_typeList3324);
            indexType117=indexType();

            state._fsp--;

            stream_indexType.add(indexType117.getTree());

            // pascal3g.g:375:15: ( COMMA indexType )*
            loop23:
            do {
                int alt23=2;
                int LA23_0 = input.LA(1);

                if ( (LA23_0==COMMA) ) {
                    alt23=1;
                }


                switch (alt23) {
            	case 1 :
            	    // pascal3g.g:375:17: COMMA indexType
            	    {
            	    COMMA118=(Token)match(input,COMMA,FOLLOW_COMMA_in_typeList3328);  
            	    stream_COMMA.add(COMMA118);


            	    pushFollow(FOLLOW_indexType_in_typeList3330);
            	    indexType119=indexType();

            	    state._fsp--;

            	    stream_indexType.add(indexType119.getTree());

            	    }
            	    break;

            	default :
            	    break loop23;
                }
            } while (true);


            // AST REWRITE
            // elements: indexType
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 376:3: -> ^( TYPELIST ( indexType )+ )
            {
                // pascal3g.g:376:6: ^( TYPELIST ( indexType )+ )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot(
                (Object)adaptor.create(TYPELIST, "TYPELIST")
                , root_1);

                if ( !(stream_indexType.hasNext()) ) {
                    throw new RewriteEarlyExitException();
                }
                while ( stream_indexType.hasNext() ) {
                    adaptor.addChild(root_1, stream_indexType.nextTree());

                }
                stream_indexType.reset();

                adaptor.addChild(root_0, root_1);
                }

            }


            retval.tree = root_0;

            }

            retval.stop = input.LT(-1);


            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "typeList"


    public static class indexType_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "indexType"
    // pascal3g.g:379:1: indexType : simpleType ;
    public final indexType_return indexType() throws RecognitionException {
        indexType_return retval = new indexType_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        simpleType_return simpleType120 =null;



        try {
            // pascal3g.g:380:5: ( simpleType )
            // pascal3g.g:380:7: simpleType
            {
            root_0 = (Object)adaptor.nil();


            pushFollow(FOLLOW_simpleType_in_indexType3359);
            simpleType120=simpleType();

            state._fsp--;

            adaptor.addChild(root_0, simpleType120.getTree());

            }

            retval.stop = input.LT(-1);


            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "indexType"


    public static class componentType_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "componentType"
    // pascal3g.g:383:1: componentType : type ;
    public final componentType_return componentType() throws RecognitionException {
        componentType_return retval = new componentType_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        type_return type121 =null;



        try {
            // pascal3g.g:384:5: ( type )
            // pascal3g.g:384:7: type
            {
            root_0 = (Object)adaptor.nil();


            pushFollow(FOLLOW_type_in_componentType3376);
            type121=type();

            state._fsp--;

            adaptor.addChild(root_0, type121.getTree());

            }

            retval.stop = input.LT(-1);


            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "componentType"


    public static class recordType_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "recordType"
    // pascal3g.g:387:1: recordType : RECORD ^ fieldList END !;
    public final recordType_return recordType() throws RecognitionException {
        recordType_return retval = new recordType_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token RECORD122=null;
        Token END124=null;
        fieldList_return fieldList123 =null;


        Object RECORD122_tree=null;
        Object END124_tree=null;

        try {
            // pascal3g.g:388:5: ( RECORD ^ fieldList END !)
            // pascal3g.g:388:7: RECORD ^ fieldList END !
            {
            root_0 = (Object)adaptor.nil();


            RECORD122=(Token)match(input,RECORD,FOLLOW_RECORD_in_recordType3393); 
            RECORD122_tree = 
            (Object)adaptor.create(RECORD122)
            ;
            root_0 = (Object)adaptor.becomeRoot(RECORD122_tree, root_0);


            pushFollow(FOLLOW_fieldList_in_recordType3396);
            fieldList123=fieldList();

            state._fsp--;

            adaptor.addChild(root_0, fieldList123.getTree());

            END124=(Token)match(input,END,FOLLOW_END_in_recordType3398); 

            }

            retval.stop = input.LT(-1);


            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "recordType"


    public static class fieldList_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "fieldList"
    // pascal3g.g:391:1: fieldList : (f1= fixedPart ( SEMI f2= variantPart | SEMI )? |f3= variantPart ) -> ^( FIELDLIST ( $f1)? ( $f2)? ( $f3)? ) ;
    public final fieldList_return fieldList() throws RecognitionException {
        fieldList_return retval = new fieldList_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token SEMI125=null;
        Token SEMI126=null;
        fixedPart_return f1 =null;

        variantPart_return f2 =null;

        variantPart_return f3 =null;


        Object SEMI125_tree=null;
        Object SEMI126_tree=null;
        RewriteRuleTokenStream stream_SEMI=new RewriteRuleTokenStream(adaptor,"token SEMI");
        RewriteRuleSubtreeStream stream_fixedPart=new RewriteRuleSubtreeStream(adaptor,"rule fixedPart");
        RewriteRuleSubtreeStream stream_variantPart=new RewriteRuleSubtreeStream(adaptor,"rule variantPart");
        try {
            // pascal3g.g:392:5: ( (f1= fixedPart ( SEMI f2= variantPart | SEMI )? |f3= variantPart ) -> ^( FIELDLIST ( $f1)? ( $f2)? ( $f3)? ) )
            // pascal3g.g:392:7: (f1= fixedPart ( SEMI f2= variantPart | SEMI )? |f3= variantPart )
            {
            // pascal3g.g:392:7: (f1= fixedPart ( SEMI f2= variantPart | SEMI )? |f3= variantPart )
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( (LA25_0==IDENT) ) {
                alt25=1;
            }
            else if ( (LA25_0==CASE) ) {
                alt25=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 25, 0, input);

                throw nvae;

            }
            switch (alt25) {
                case 1 :
                    // pascal3g.g:392:9: f1= fixedPart ( SEMI f2= variantPart | SEMI )?
                    {
                    pushFollow(FOLLOW_fixedPart_in_fieldList3420);
                    f1=fixedPart();

                    state._fsp--;

                    stream_fixedPart.add(f1.getTree());

                    // pascal3g.g:392:22: ( SEMI f2= variantPart | SEMI )?
                    int alt24=3;
                    int LA24_0 = input.LA(1);

                    if ( (LA24_0==SEMI) ) {
                        int LA24_1 = input.LA(2);

                        if ( (LA24_1==CASE) ) {
                            alt24=1;
                        }
                        else if ( (LA24_1==END||LA24_1==RPAREN) ) {
                            alt24=2;
                        }
                    }
                    switch (alt24) {
                        case 1 :
                            // pascal3g.g:392:24: SEMI f2= variantPart
                            {
                            SEMI125=(Token)match(input,SEMI,FOLLOW_SEMI_in_fieldList3424);  
                            stream_SEMI.add(SEMI125);


                            pushFollow(FOLLOW_variantPart_in_fieldList3428);
                            f2=variantPart();

                            state._fsp--;

                            stream_variantPart.add(f2.getTree());

                            }
                            break;
                        case 2 :
                            // pascal3g.g:392:46: SEMI
                            {
                            SEMI126=(Token)match(input,SEMI,FOLLOW_SEMI_in_fieldList3432);  
                            stream_SEMI.add(SEMI126);


                            }
                            break;

                    }


                    }
                    break;
                case 2 :
                    // pascal3g.g:393:9: f3= variantPart
                    {
                    pushFollow(FOLLOW_variantPart_in_fieldList3447);
                    f3=variantPart();

                    state._fsp--;

                    stream_variantPart.add(f3.getTree());

                    }
                    break;

            }


            // AST REWRITE
            // elements: f1, f3, f2
            // token labels: 
            // rule labels: retval, f1, f3, f2
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);
            RewriteRuleSubtreeStream stream_f1=new RewriteRuleSubtreeStream(adaptor,"rule f1",f1!=null?f1.tree:null);
            RewriteRuleSubtreeStream stream_f3=new RewriteRuleSubtreeStream(adaptor,"rule f3",f3!=null?f3.tree:null);
            RewriteRuleSubtreeStream stream_f2=new RewriteRuleSubtreeStream(adaptor,"rule f2",f2!=null?f2.tree:null);

            root_0 = (Object)adaptor.nil();
            // 395:7: -> ^( FIELDLIST ( $f1)? ( $f2)? ( $f3)? )
            {
                // pascal3g.g:395:10: ^( FIELDLIST ( $f1)? ( $f2)? ( $f3)? )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot(
                (Object)adaptor.create(FIELDLIST, "FIELDLIST")
                , root_1);

                // pascal3g.g:395:23: ( $f1)?
                if ( stream_f1.hasNext() ) {
                    adaptor.addChild(root_1, stream_f1.nextTree());

                }
                stream_f1.reset();

                // pascal3g.g:395:28: ( $f2)?
                if ( stream_f2.hasNext() ) {
                    adaptor.addChild(root_1, stream_f2.nextTree());

                }
                stream_f2.reset();

                // pascal3g.g:395:33: ( $f3)?
                if ( stream_f3.hasNext() ) {
                    adaptor.addChild(root_1, stream_f3.nextTree());

                }
                stream_f3.reset();

                adaptor.addChild(root_0, root_1);
                }

            }


            retval.tree = root_0;

            }

            retval.stop = input.LT(-1);


            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "fieldList"


    public static class fixedPart_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "fixedPart"
    // pascal3g.g:398:1: fixedPart : recordSection ( SEMI ! recordSection )* ;
    public final fixedPart_return fixedPart() throws RecognitionException {
        fixedPart_return retval = new fixedPart_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token SEMI128=null;
        recordSection_return recordSection127 =null;

        recordSection_return recordSection129 =null;


        Object SEMI128_tree=null;

        try {
            // pascal3g.g:399:5: ( recordSection ( SEMI ! recordSection )* )
            // pascal3g.g:399:7: recordSection ( SEMI ! recordSection )*
            {
            root_0 = (Object)adaptor.nil();


            pushFollow(FOLLOW_recordSection_in_fixedPart3496);
            recordSection127=recordSection();

            state._fsp--;

            adaptor.addChild(root_0, recordSection127.getTree());

            // pascal3g.g:399:21: ( SEMI ! recordSection )*
            loop26:
            do {
                int alt26=2;
                int LA26_0 = input.LA(1);

                if ( (LA26_0==SEMI) ) {
                    int LA26_1 = input.LA(2);

                    if ( (LA26_1==IDENT) ) {
                        alt26=1;
                    }


                }


                switch (alt26) {
            	case 1 :
            	    // pascal3g.g:399:23: SEMI ! recordSection
            	    {
            	    SEMI128=(Token)match(input,SEMI,FOLLOW_SEMI_in_fixedPart3500); 

            	    pushFollow(FOLLOW_recordSection_in_fixedPart3503);
            	    recordSection129=recordSection();

            	    state._fsp--;

            	    adaptor.addChild(root_0, recordSection129.getTree());

            	    }
            	    break;

            	default :
            	    break loop26;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);


            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "fixedPart"


    public static class recordSection_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "recordSection"
    // pascal3g.g:402:1: recordSection : identifierList COLON type -> ^( FIELD identifierList type ) ;
    public final recordSection_return recordSection() throws RecognitionException {
        recordSection_return retval = new recordSection_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token COLON131=null;
        identifierList_return identifierList130 =null;

        type_return type132 =null;


        Object COLON131_tree=null;
        RewriteRuleTokenStream stream_COLON=new RewriteRuleTokenStream(adaptor,"token COLON");
        RewriteRuleSubtreeStream stream_identifierList=new RewriteRuleSubtreeStream(adaptor,"rule identifierList");
        RewriteRuleSubtreeStream stream_type=new RewriteRuleSubtreeStream(adaptor,"rule type");
        try {
            // pascal3g.g:403:5: ( identifierList COLON type -> ^( FIELD identifierList type ) )
            // pascal3g.g:403:7: identifierList COLON type
            {
            pushFollow(FOLLOW_identifierList_in_recordSection3523);
            identifierList130=identifierList();

            state._fsp--;

            stream_identifierList.add(identifierList130.getTree());

            COLON131=(Token)match(input,COLON,FOLLOW_COLON_in_recordSection3525);  
            stream_COLON.add(COLON131);


            pushFollow(FOLLOW_type_in_recordSection3527);
            type132=type();

            state._fsp--;

            stream_type.add(type132.getTree());

            // AST REWRITE
            // elements: type, identifierList
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 404:5: -> ^( FIELD identifierList type )
            {
                // pascal3g.g:404:8: ^( FIELD identifierList type )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot(
                (Object)adaptor.create(FIELD, "FIELD")
                , root_1);

                adaptor.addChild(root_1, stream_identifierList.nextTree());

                adaptor.addChild(root_1, stream_type.nextTree());

                adaptor.addChild(root_0, root_1);
                }

            }


            retval.tree = root_0;

            }

            retval.stop = input.LT(-1);


            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "recordSection"


    public static class variantPart_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "variantPart"
    // pascal3g.g:407:1: variantPart : CASE ^ tag OF ! variant ( SEMI ! variant | SEMI !)* ;
    public final variantPart_return variantPart() throws RecognitionException {
        variantPart_return retval = new variantPart_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token CASE133=null;
        Token OF135=null;
        Token SEMI137=null;
        Token SEMI139=null;
        tag_return tag134 =null;

        variant_return variant136 =null;

        variant_return variant138 =null;


        Object CASE133_tree=null;
        Object OF135_tree=null;
        Object SEMI137_tree=null;
        Object SEMI139_tree=null;

        try {
            // pascal3g.g:408:5: ( CASE ^ tag OF ! variant ( SEMI ! variant | SEMI !)* )
            // pascal3g.g:408:7: CASE ^ tag OF ! variant ( SEMI ! variant | SEMI !)*
            {
            root_0 = (Object)adaptor.nil();


            CASE133=(Token)match(input,CASE,FOLLOW_CASE_in_variantPart3558); 
            CASE133_tree = 
            (Object)adaptor.create(CASE133)
            ;
            root_0 = (Object)adaptor.becomeRoot(CASE133_tree, root_0);


            pushFollow(FOLLOW_tag_in_variantPart3561);
            tag134=tag();

            state._fsp--;

            adaptor.addChild(root_0, tag134.getTree());

            OF135=(Token)match(input,OF,FOLLOW_OF_in_variantPart3563); 

            pushFollow(FOLLOW_variant_in_variantPart3566);
            variant136=variant();

            state._fsp--;

            adaptor.addChild(root_0, variant136.getTree());

            // pascal3g.g:408:29: ( SEMI ! variant | SEMI !)*
            loop27:
            do {
                int alt27=3;
                int LA27_0 = input.LA(1);

                if ( (LA27_0==SEMI) ) {
                    int LA27_2 = input.LA(2);

                    if ( (LA27_2==CHR||LA27_2==IDENT||LA27_2==MINUS||(LA27_2 >= NUM_INT && LA27_2 <= NUM_REAL)||LA27_2==PLUS||LA27_2==STRING_LITERAL) ) {
                        alt27=1;
                    }
                    else if ( (LA27_2==END||LA27_2==RPAREN||LA27_2==SEMI) ) {
                        alt27=2;
                    }


                }


                switch (alt27) {
            	case 1 :
            	    // pascal3g.g:408:31: SEMI ! variant
            	    {
            	    SEMI137=(Token)match(input,SEMI,FOLLOW_SEMI_in_variantPart3570); 

            	    pushFollow(FOLLOW_variant_in_variantPart3573);
            	    variant138=variant();

            	    state._fsp--;

            	    adaptor.addChild(root_0, variant138.getTree());

            	    }
            	    break;
            	case 2 :
            	    // pascal3g.g:408:47: SEMI !
            	    {
            	    SEMI139=(Token)match(input,SEMI,FOLLOW_SEMI_in_variantPart3577); 

            	    }
            	    break;

            	default :
            	    break loop27;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);


            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "variantPart"


    public static class tag_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "tag"
    // pascal3g.g:411:1: tag : (id= identifier COLON t= typeIdentifier -> ^( VARIANT_TAG $id $t) |t2= typeIdentifier -> ^( VARIANT_TAG_NO_ID $t2) );
    public final tag_return tag() throws RecognitionException {
        tag_return retval = new tag_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token COLON140=null;
        identifier_return id =null;

        typeIdentifier_return t =null;

        typeIdentifier_return t2 =null;


        Object COLON140_tree=null;
        RewriteRuleTokenStream stream_COLON=new RewriteRuleTokenStream(adaptor,"token COLON");
        RewriteRuleSubtreeStream stream_typeIdentifier=new RewriteRuleSubtreeStream(adaptor,"rule typeIdentifier");
        RewriteRuleSubtreeStream stream_identifier=new RewriteRuleSubtreeStream(adaptor,"rule identifier");
        try {
            // pascal3g.g:412:5: (id= identifier COLON t= typeIdentifier -> ^( VARIANT_TAG $id $t) |t2= typeIdentifier -> ^( VARIANT_TAG_NO_ID $t2) )
            int alt28=2;
            int LA28_0 = input.LA(1);

            if ( (LA28_0==IDENT) ) {
                int LA28_1 = input.LA(2);

                if ( (LA28_1==COLON) ) {
                    alt28=1;
                }
                else if ( (LA28_1==OF) ) {
                    alt28=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 28, 1, input);

                    throw nvae;

                }
            }
            else if ( (LA28_0==BOOLEAN||LA28_0==CHAR||LA28_0==INTEGER||LA28_0==REAL||LA28_0==STRING) ) {
                alt28=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 28, 0, input);

                throw nvae;

            }
            switch (alt28) {
                case 1 :
                    // pascal3g.g:412:7: id= identifier COLON t= typeIdentifier
                    {
                    pushFollow(FOLLOW_identifier_in_tag3600);
                    id=identifier();

                    state._fsp--;

                    stream_identifier.add(id.getTree());

                    COLON140=(Token)match(input,COLON,FOLLOW_COLON_in_tag3602);  
                    stream_COLON.add(COLON140);


                    pushFollow(FOLLOW_typeIdentifier_in_tag3606);
                    t=typeIdentifier();

                    state._fsp--;

                    stream_typeIdentifier.add(t.getTree());

                    // AST REWRITE
                    // elements: id, t
                    // token labels: 
                    // rule labels: id, retval, t
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_id=new RewriteRuleSubtreeStream(adaptor,"rule id",id!=null?id.tree:null);
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);
                    RewriteRuleSubtreeStream stream_t=new RewriteRuleSubtreeStream(adaptor,"rule t",t!=null?t.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 412:44: -> ^( VARIANT_TAG $id $t)
                    {
                        // pascal3g.g:412:47: ^( VARIANT_TAG $id $t)
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot(
                        (Object)adaptor.create(VARIANT_TAG, "VARIANT_TAG")
                        , root_1);

                        adaptor.addChild(root_1, stream_id.nextTree());

                        adaptor.addChild(root_1, stream_t.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }


                    retval.tree = root_0;

                    }
                    break;
                case 2 :
                    // pascal3g.g:413:7: t2= typeIdentifier
                    {
                    pushFollow(FOLLOW_typeIdentifier_in_tag3629);
                    t2=typeIdentifier();

                    state._fsp--;

                    stream_typeIdentifier.add(t2.getTree());

                    // AST REWRITE
                    // elements: t2
                    // token labels: 
                    // rule labels: t2, retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_t2=new RewriteRuleSubtreeStream(adaptor,"rule t2",t2!=null?t2.tree:null);
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 413:26: -> ^( VARIANT_TAG_NO_ID $t2)
                    {
                        // pascal3g.g:413:29: ^( VARIANT_TAG_NO_ID $t2)
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot(
                        (Object)adaptor.create(VARIANT_TAG_NO_ID, "VARIANT_TAG_NO_ID")
                        , root_1);

                        adaptor.addChild(root_1, stream_t2.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }


                    retval.tree = root_0;

                    }
                    break;

            }
            retval.stop = input.LT(-1);


            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "tag"


    public static class variant_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "variant"
    // pascal3g.g:416:1: variant : constList c= COLON ^ LPAREN ! fieldList RPAREN !;
    public final variant_return variant() throws RecognitionException {
        variant_return retval = new variant_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token c=null;
        Token LPAREN142=null;
        Token RPAREN144=null;
        constList_return constList141 =null;

        fieldList_return fieldList143 =null;


        Object c_tree=null;
        Object LPAREN142_tree=null;
        Object RPAREN144_tree=null;

        try {
            // pascal3g.g:417:5: ( constList c= COLON ^ LPAREN ! fieldList RPAREN !)
            // pascal3g.g:417:7: constList c= COLON ^ LPAREN ! fieldList RPAREN !
            {
            root_0 = (Object)adaptor.nil();


            pushFollow(FOLLOW_constList_in_variant3656);
            constList141=constList();

            state._fsp--;

            adaptor.addChild(root_0, constList141.getTree());

            c=(Token)match(input,COLON,FOLLOW_COLON_in_variant3660); 
            c_tree = 
            (Object)adaptor.create(c)
            ;
            root_0 = (Object)adaptor.becomeRoot(c_tree, root_0);


            c.setType(VARIANT_CASE);

            LPAREN142=(Token)match(input,LPAREN,FOLLOW_LPAREN_in_variant3669); 

            pushFollow(FOLLOW_fieldList_in_variant3672);
            fieldList143=fieldList();

            state._fsp--;

            adaptor.addChild(root_0, fieldList143.getTree());

            RPAREN144=(Token)match(input,RPAREN,FOLLOW_RPAREN_in_variant3674); 

            }

            retval.stop = input.LT(-1);


            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "variant"


    public static class setType_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "setType"
    // pascal3g.g:421:1: setType : SET ^ OF ! simpleType ;
    public final setType_return setType() throws RecognitionException {
        setType_return retval = new setType_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token SET145=null;
        Token OF146=null;
        simpleType_return simpleType147 =null;


        Object SET145_tree=null;
        Object OF146_tree=null;

        try {
            // pascal3g.g:422:5: ( SET ^ OF ! simpleType )
            // pascal3g.g:422:7: SET ^ OF ! simpleType
            {
            root_0 = (Object)adaptor.nil();


            SET145=(Token)match(input,SET,FOLLOW_SET_in_setType3692); 
            SET145_tree = 
            (Object)adaptor.create(SET145)
            ;
            root_0 = (Object)adaptor.becomeRoot(SET145_tree, root_0);


            OF146=(Token)match(input,OF,FOLLOW_OF_in_setType3695); 

            pushFollow(FOLLOW_simpleType_in_setType3698);
            simpleType147=simpleType();

            state._fsp--;

            adaptor.addChild(root_0, simpleType147.getTree());

            }

            retval.stop = input.LT(-1);


            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "setType"


    public static class fileType_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "fileType"
    // pascal3g.g:425:1: fileType : ( FILE ^ OF ! type | FILE );
    public final fileType_return fileType() throws RecognitionException {
        fileType_return retval = new fileType_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token FILE148=null;
        Token OF149=null;
        Token FILE151=null;
        type_return type150 =null;


        Object FILE148_tree=null;
        Object OF149_tree=null;
        Object FILE151_tree=null;

        try {
            // pascal3g.g:426:5: ( FILE ^ OF ! type | FILE )
            int alt29=2;
            int LA29_0 = input.LA(1);

            if ( (LA29_0==FILE) ) {
                int LA29_1 = input.LA(2);

                if ( (LA29_1==OF) ) {
                    alt29=1;
                }
                else if ( (LA29_1==END||LA29_1==RPAREN||LA29_1==SEMI) ) {
                    alt29=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 29, 1, input);

                    throw nvae;

                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 29, 0, input);

                throw nvae;

            }
            switch (alt29) {
                case 1 :
                    // pascal3g.g:426:7: FILE ^ OF ! type
                    {
                    root_0 = (Object)adaptor.nil();


                    FILE148=(Token)match(input,FILE,FOLLOW_FILE_in_fileType3715); 
                    FILE148_tree = 
                    (Object)adaptor.create(FILE148)
                    ;
                    root_0 = (Object)adaptor.becomeRoot(FILE148_tree, root_0);


                    OF149=(Token)match(input,OF,FOLLOW_OF_in_fileType3718); 

                    pushFollow(FOLLOW_type_in_fileType3721);
                    type150=type();

                    state._fsp--;

                    adaptor.addChild(root_0, type150.getTree());

                    }
                    break;
                case 2 :
                    // pascal3g.g:427:7: FILE
                    {
                    root_0 = (Object)adaptor.nil();


                    FILE151=(Token)match(input,FILE,FOLLOW_FILE_in_fileType3729); 
                    FILE151_tree = 
                    (Object)adaptor.create(FILE151)
                    ;
                    adaptor.addChild(root_0, FILE151_tree);


                    }
                    break;

            }
            retval.stop = input.LT(-1);


            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "fileType"


    public static class pointerType_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "pointerType"
    // pascal3g.g:430:1: pointerType : POINTER ^ typeIdentifier ;
    public final pointerType_return pointerType() throws RecognitionException {
        pointerType_return retval = new pointerType_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token POINTER152=null;
        typeIdentifier_return typeIdentifier153 =null;


        Object POINTER152_tree=null;

        try {
            // pascal3g.g:431:5: ( POINTER ^ typeIdentifier )
            // pascal3g.g:431:7: POINTER ^ typeIdentifier
            {
            root_0 = (Object)adaptor.nil();


            POINTER152=(Token)match(input,POINTER,FOLLOW_POINTER_in_pointerType3746); 
            POINTER152_tree = 
            (Object)adaptor.create(POINTER152)
            ;
            root_0 = (Object)adaptor.becomeRoot(POINTER152_tree, root_0);


            pushFollow(FOLLOW_typeIdentifier_in_pointerType3749);
            typeIdentifier153=typeIdentifier();

            state._fsp--;

            adaptor.addChild(root_0, typeIdentifier153.getTree());

            }

            retval.stop = input.LT(-1);


            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "pointerType"


    public static class variableDeclarationPart_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "variableDeclarationPart"
    // pascal3g.g:435:1: variableDeclarationPart : VAR ^ variableDeclaration ( SEMI ! variableDeclaration )* SEMI !;
    public final variableDeclarationPart_return variableDeclarationPart() throws RecognitionException {
        variableDeclarationPart_return retval = new variableDeclarationPart_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token VAR154=null;
        Token SEMI156=null;
        Token SEMI158=null;
        variableDeclaration_return variableDeclaration155 =null;

        variableDeclaration_return variableDeclaration157 =null;


        Object VAR154_tree=null;
        Object SEMI156_tree=null;
        Object SEMI158_tree=null;

        try {
            // pascal3g.g:436:5: ( VAR ^ variableDeclaration ( SEMI ! variableDeclaration )* SEMI !)
            // pascal3g.g:436:7: VAR ^ variableDeclaration ( SEMI ! variableDeclaration )* SEMI !
            {
            root_0 = (Object)adaptor.nil();


            VAR154=(Token)match(input,VAR,FOLLOW_VAR_in_variableDeclarationPart3767); 
            VAR154_tree = 
            (Object)adaptor.create(VAR154)
            ;
            root_0 = (Object)adaptor.becomeRoot(VAR154_tree, root_0);


            pushFollow(FOLLOW_variableDeclaration_in_variableDeclarationPart3770);
            variableDeclaration155=variableDeclaration();

            state._fsp--;

            adaptor.addChild(root_0, variableDeclaration155.getTree());

            // pascal3g.g:436:32: ( SEMI ! variableDeclaration )*
            loop30:
            do {
                int alt30=2;
                int LA30_0 = input.LA(1);

                if ( (LA30_0==SEMI) ) {
                    int LA30_1 = input.LA(2);

                    if ( (LA30_1==IDENT) ) {
                        alt30=1;
                    }


                }


                switch (alt30) {
            	case 1 :
            	    // pascal3g.g:436:34: SEMI ! variableDeclaration
            	    {
            	    SEMI156=(Token)match(input,SEMI,FOLLOW_SEMI_in_variableDeclarationPart3774); 

            	    pushFollow(FOLLOW_variableDeclaration_in_variableDeclarationPart3777);
            	    variableDeclaration157=variableDeclaration();

            	    state._fsp--;

            	    adaptor.addChild(root_0, variableDeclaration157.getTree());

            	    }
            	    break;

            	default :
            	    break loop30;
                }
            } while (true);


            SEMI158=(Token)match(input,SEMI,FOLLOW_SEMI_in_variableDeclarationPart3782); 

            }

            retval.stop = input.LT(-1);


            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "variableDeclarationPart"


    public static class variableDeclaration_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "variableDeclaration"
    // pascal3g.g:439:1: variableDeclaration : identifierList c= COLON ^ type ;
    public final variableDeclaration_return variableDeclaration() throws RecognitionException {
        variableDeclaration_return retval = new variableDeclaration_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token c=null;
        identifierList_return identifierList159 =null;

        type_return type160 =null;


        Object c_tree=null;

        try {
            // pascal3g.g:440:5: ( identifierList c= COLON ^ type )
            // pascal3g.g:440:7: identifierList c= COLON ^ type
            {
            root_0 = (Object)adaptor.nil();


            pushFollow(FOLLOW_identifierList_in_variableDeclaration3800);
            identifierList159=identifierList();

            state._fsp--;

            adaptor.addChild(root_0, identifierList159.getTree());

            c=(Token)match(input,COLON,FOLLOW_COLON_in_variableDeclaration3804); 
            c_tree = 
            (Object)adaptor.create(c)
            ;
            root_0 = (Object)adaptor.becomeRoot(c_tree, root_0);


            c.setType(VARDECL);

            pushFollow(FOLLOW_type_in_variableDeclaration3809);
            type160=type();

            state._fsp--;

            adaptor.addChild(root_0, type160.getTree());

            }

            retval.stop = input.LT(-1);


            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "variableDeclaration"


    public static class procedureAndFunctionDeclarationPart_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "procedureAndFunctionDeclarationPart"
    // pascal3g.g:443:1: procedureAndFunctionDeclarationPart : procedureOrFunctionDeclaration SEMI !;
    public final procedureAndFunctionDeclarationPart_return procedureAndFunctionDeclarationPart() throws RecognitionException {
        procedureAndFunctionDeclarationPart_return retval = new procedureAndFunctionDeclarationPart_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token SEMI162=null;
        procedureOrFunctionDeclaration_return procedureOrFunctionDeclaration161 =null;


        Object SEMI162_tree=null;

        try {
            // pascal3g.g:444:5: ( procedureOrFunctionDeclaration SEMI !)
            // pascal3g.g:444:7: procedureOrFunctionDeclaration SEMI !
            {
            root_0 = (Object)adaptor.nil();


            pushFollow(FOLLOW_procedureOrFunctionDeclaration_in_procedureAndFunctionDeclarationPart3826);
            procedureOrFunctionDeclaration161=procedureOrFunctionDeclaration();

            state._fsp--;

            adaptor.addChild(root_0, procedureOrFunctionDeclaration161.getTree());

            SEMI162=(Token)match(input,SEMI,FOLLOW_SEMI_in_procedureAndFunctionDeclarationPart3828); 

            }

            retval.stop = input.LT(-1);


            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "procedureAndFunctionDeclarationPart"


    public static class procedureOrFunctionDeclaration_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "procedureOrFunctionDeclaration"
    // pascal3g.g:447:1: procedureOrFunctionDeclaration : ( procedureDeclaration | functionDeclaration );
    public final procedureOrFunctionDeclaration_return procedureOrFunctionDeclaration() throws RecognitionException {
        procedureOrFunctionDeclaration_return retval = new procedureOrFunctionDeclaration_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        procedureDeclaration_return procedureDeclaration163 =null;

        functionDeclaration_return functionDeclaration164 =null;



        try {
            // pascal3g.g:448:5: ( procedureDeclaration | functionDeclaration )
            int alt31=2;
            int LA31_0 = input.LA(1);

            if ( (LA31_0==PROCEDURE) ) {
                alt31=1;
            }
            else if ( (LA31_0==FUNCTION) ) {
                alt31=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 31, 0, input);

                throw nvae;

            }
            switch (alt31) {
                case 1 :
                    // pascal3g.g:448:7: procedureDeclaration
                    {
                    root_0 = (Object)adaptor.nil();


                    pushFollow(FOLLOW_procedureDeclaration_in_procedureOrFunctionDeclaration3846);
                    procedureDeclaration163=procedureDeclaration();

                    state._fsp--;

                    adaptor.addChild(root_0, procedureDeclaration163.getTree());

                    }
                    break;
                case 2 :
                    // pascal3g.g:449:7: functionDeclaration
                    {
                    root_0 = (Object)adaptor.nil();


                    pushFollow(FOLLOW_functionDeclaration_in_procedureOrFunctionDeclaration3854);
                    functionDeclaration164=functionDeclaration();

                    state._fsp--;

                    adaptor.addChild(root_0, functionDeclaration164.getTree());

                    }
                    break;

            }
            retval.stop = input.LT(-1);


            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "procedureOrFunctionDeclaration"


    public static class procedureDeclaration_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "procedureDeclaration"
    // pascal3g.g:452:1: procedureDeclaration : PROCEDURE ^ identifier ( formalParameterList )? SEMI ! ( block | directive ) ;
    public final procedureDeclaration_return procedureDeclaration() throws RecognitionException {
        procedureDeclaration_return retval = new procedureDeclaration_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token PROCEDURE165=null;
        Token SEMI168=null;
        identifier_return identifier166 =null;

        formalParameterList_return formalParameterList167 =null;

        block_return block169 =null;

        directive_return directive170 =null;


        Object PROCEDURE165_tree=null;
        Object SEMI168_tree=null;

        try {
            // pascal3g.g:453:5: ( PROCEDURE ^ identifier ( formalParameterList )? SEMI ! ( block | directive ) )
            // pascal3g.g:453:7: PROCEDURE ^ identifier ( formalParameterList )? SEMI ! ( block | directive )
            {
            root_0 = (Object)adaptor.nil();


            PROCEDURE165=(Token)match(input,PROCEDURE,FOLLOW_PROCEDURE_in_procedureDeclaration3871); 
            PROCEDURE165_tree = 
            (Object)adaptor.create(PROCEDURE165)
            ;
            root_0 = (Object)adaptor.becomeRoot(PROCEDURE165_tree, root_0);


            pushFollow(FOLLOW_identifier_in_procedureDeclaration3874);
            identifier166=identifier();

            state._fsp--;

            adaptor.addChild(root_0, identifier166.getTree());

            // pascal3g.g:453:29: ( formalParameterList )?
            int alt32=2;
            int LA32_0 = input.LA(1);

            if ( (LA32_0==LPAREN) ) {
                alt32=1;
            }
            switch (alt32) {
                case 1 :
                    // pascal3g.g:453:30: formalParameterList
                    {
                    pushFollow(FOLLOW_formalParameterList_in_procedureDeclaration3877);
                    formalParameterList167=formalParameterList();

                    state._fsp--;

                    adaptor.addChild(root_0, formalParameterList167.getTree());

                    }
                    break;

            }


            SEMI168=(Token)match(input,SEMI,FOLLOW_SEMI_in_procedureDeclaration3881); 

            // pascal3g.g:454:7: ( block | directive )
            int alt33=2;
            int LA33_0 = input.LA(1);

            if ( (LA33_0==BEGIN||LA33_0==CONST||LA33_0==FUNCTION||LA33_0==IMPLEMENTATION||LA33_0==LABEL||LA33_0==PROCEDURE||LA33_0==TYPE||(LA33_0 >= USES && LA33_0 <= VAR)) ) {
                alt33=1;
            }
            else if ( (LA33_0==FORWARD) ) {
                alt33=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 33, 0, input);

                throw nvae;

            }
            switch (alt33) {
                case 1 :
                    // pascal3g.g:454:9: block
                    {
                    pushFollow(FOLLOW_block_in_procedureDeclaration3892);
                    block169=block();

                    state._fsp--;

                    adaptor.addChild(root_0, block169.getTree());

                    }
                    break;
                case 2 :
                    // pascal3g.g:454:17: directive
                    {
                    pushFollow(FOLLOW_directive_in_procedureDeclaration3896);
                    directive170=directive();

                    state._fsp--;

                    adaptor.addChild(root_0, directive170.getTree());

                    }
                    break;

            }


            }

            retval.stop = input.LT(-1);


            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "procedureDeclaration"


    public static class functionDeclaration_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "functionDeclaration"
    // pascal3g.g:461:1: functionDeclaration : FUNCTION ^ identifier ( formalParameterList )? COLON ! resultType SEMI ! ( block | directive ) ;
    public final functionDeclaration_return functionDeclaration() throws RecognitionException {
        functionDeclaration_return retval = new functionDeclaration_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token FUNCTION171=null;
        Token COLON174=null;
        Token SEMI176=null;
        identifier_return identifier172 =null;

        formalParameterList_return formalParameterList173 =null;

        resultType_return resultType175 =null;

        block_return block177 =null;

        directive_return directive178 =null;


        Object FUNCTION171_tree=null;
        Object COLON174_tree=null;
        Object SEMI176_tree=null;

        try {
            // pascal3g.g:462:5: ( FUNCTION ^ identifier ( formalParameterList )? COLON ! resultType SEMI ! ( block | directive ) )
            // pascal3g.g:462:7: FUNCTION ^ identifier ( formalParameterList )? COLON ! resultType SEMI ! ( block | directive )
            {
            root_0 = (Object)adaptor.nil();


            FUNCTION171=(Token)match(input,FUNCTION,FOLLOW_FUNCTION_in_functionDeclaration3919); 
            FUNCTION171_tree = 
            (Object)adaptor.create(FUNCTION171)
            ;
            root_0 = (Object)adaptor.becomeRoot(FUNCTION171_tree, root_0);


            pushFollow(FOLLOW_identifier_in_functionDeclaration3922);
            identifier172=identifier();

            state._fsp--;

            adaptor.addChild(root_0, identifier172.getTree());

            // pascal3g.g:462:28: ( formalParameterList )?
            int alt34=2;
            int LA34_0 = input.LA(1);

            if ( (LA34_0==LPAREN) ) {
                alt34=1;
            }
            switch (alt34) {
                case 1 :
                    // pascal3g.g:462:29: formalParameterList
                    {
                    pushFollow(FOLLOW_formalParameterList_in_functionDeclaration3925);
                    formalParameterList173=formalParameterList();

                    state._fsp--;

                    adaptor.addChild(root_0, formalParameterList173.getTree());

                    }
                    break;

            }


            COLON174=(Token)match(input,COLON,FOLLOW_COLON_in_functionDeclaration3929); 

            pushFollow(FOLLOW_resultType_in_functionDeclaration3932);
            resultType175=resultType();

            state._fsp--;

            adaptor.addChild(root_0, resultType175.getTree());

            SEMI176=(Token)match(input,SEMI,FOLLOW_SEMI_in_functionDeclaration3934); 

            // pascal3g.g:463:7: ( block | directive )
            int alt35=2;
            int LA35_0 = input.LA(1);

            if ( (LA35_0==BEGIN||LA35_0==CONST||LA35_0==FUNCTION||LA35_0==IMPLEMENTATION||LA35_0==LABEL||LA35_0==PROCEDURE||LA35_0==TYPE||(LA35_0 >= USES && LA35_0 <= VAR)) ) {
                alt35=1;
            }
            else if ( (LA35_0==FORWARD) ) {
                alt35=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 35, 0, input);

                throw nvae;

            }
            switch (alt35) {
                case 1 :
                    // pascal3g.g:463:9: block
                    {
                    pushFollow(FOLLOW_block_in_functionDeclaration3945);
                    block177=block();

                    state._fsp--;

                    adaptor.addChild(root_0, block177.getTree());

                    }
                    break;
                case 2 :
                    // pascal3g.g:463:17: directive
                    {
                    pushFollow(FOLLOW_directive_in_functionDeclaration3949);
                    directive178=directive();

                    state._fsp--;

                    adaptor.addChild(root_0, directive178.getTree());

                    }
                    break;

            }


            }

            retval.stop = input.LT(-1);


            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "functionDeclaration"


    public static class directive_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "directive"
    // pascal3g.g:466:1: directive : FORWARD ;
    public final directive_return directive() throws RecognitionException {
        directive_return retval = new directive_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token FORWARD179=null;

        Object FORWARD179_tree=null;

        try {
            // pascal3g.g:467:5: ( FORWARD )
            // pascal3g.g:467:7: FORWARD
            {
            root_0 = (Object)adaptor.nil();


            FORWARD179=(Token)match(input,FORWARD,FOLLOW_FORWARD_in_directive3968); 
            FORWARD179_tree = 
            (Object)adaptor.create(FORWARD179)
            ;
            adaptor.addChild(root_0, FORWARD179_tree);


            }

            retval.stop = input.LT(-1);


            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "directive"


    public static class formalParameterList_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "formalParameterList"
    // pascal3g.g:471:1: formalParameterList : LPAREN formalParameterSection ( SEMI formalParameterSection )* RPAREN -> ^( ARGDECLS ( formalParameterSection )+ ) ;
    public final formalParameterList_return formalParameterList() throws RecognitionException {
        formalParameterList_return retval = new formalParameterList_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token LPAREN180=null;
        Token SEMI182=null;
        Token RPAREN184=null;
        formalParameterSection_return formalParameterSection181 =null;

        formalParameterSection_return formalParameterSection183 =null;


        Object LPAREN180_tree=null;
        Object SEMI182_tree=null;
        Object RPAREN184_tree=null;
        RewriteRuleTokenStream stream_RPAREN=new RewriteRuleTokenStream(adaptor,"token RPAREN");
        RewriteRuleTokenStream stream_SEMI=new RewriteRuleTokenStream(adaptor,"token SEMI");
        RewriteRuleTokenStream stream_LPAREN=new RewriteRuleTokenStream(adaptor,"token LPAREN");
        RewriteRuleSubtreeStream stream_formalParameterSection=new RewriteRuleSubtreeStream(adaptor,"rule formalParameterSection");
        try {
            // pascal3g.g:472:5: ( LPAREN formalParameterSection ( SEMI formalParameterSection )* RPAREN -> ^( ARGDECLS ( formalParameterSection )+ ) )
            // pascal3g.g:472:7: LPAREN formalParameterSection ( SEMI formalParameterSection )* RPAREN
            {
            LPAREN180=(Token)match(input,LPAREN,FOLLOW_LPAREN_in_formalParameterList3986);  
            stream_LPAREN.add(LPAREN180);


            pushFollow(FOLLOW_formalParameterSection_in_formalParameterList3988);
            formalParameterSection181=formalParameterSection();

            state._fsp--;

            stream_formalParameterSection.add(formalParameterSection181.getTree());

            // pascal3g.g:472:37: ( SEMI formalParameterSection )*
            loop36:
            do {
                int alt36=2;
                int LA36_0 = input.LA(1);

                if ( (LA36_0==SEMI) ) {
                    alt36=1;
                }


                switch (alt36) {
            	case 1 :
            	    // pascal3g.g:472:39: SEMI formalParameterSection
            	    {
            	    SEMI182=(Token)match(input,SEMI,FOLLOW_SEMI_in_formalParameterList3992);  
            	    stream_SEMI.add(SEMI182);


            	    pushFollow(FOLLOW_formalParameterSection_in_formalParameterList3994);
            	    formalParameterSection183=formalParameterSection();

            	    state._fsp--;

            	    stream_formalParameterSection.add(formalParameterSection183.getTree());

            	    }
            	    break;

            	default :
            	    break loop36;
                }
            } while (true);


            RPAREN184=(Token)match(input,RPAREN,FOLLOW_RPAREN_in_formalParameterList3999);  
            stream_RPAREN.add(RPAREN184);


            // AST REWRITE
            // elements: formalParameterSection
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 473:5: -> ^( ARGDECLS ( formalParameterSection )+ )
            {
                // pascal3g.g:473:8: ^( ARGDECLS ( formalParameterSection )+ )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot(
                (Object)adaptor.create(ARGDECLS, "ARGDECLS")
                , root_1);

                if ( !(stream_formalParameterSection.hasNext()) ) {
                    throw new RewriteEarlyExitException();
                }
                while ( stream_formalParameterSection.hasNext() ) {
                    adaptor.addChild(root_1, stream_formalParameterSection.nextTree());

                }
                stream_formalParameterSection.reset();

                adaptor.addChild(root_0, root_1);
                }

            }


            retval.tree = root_0;

            }

            retval.stop = input.LT(-1);


            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "formalParameterList"


    public static class formalParameterSection_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "formalParameterSection"
    // pascal3g.g:476:1: formalParameterSection : ( parameterGroup | VAR ^ parameterGroup | FUNCTION ^ parameterGroup | PROCEDURE ^ parameterGroup );
    public final formalParameterSection_return formalParameterSection() throws RecognitionException {
        formalParameterSection_return retval = new formalParameterSection_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token VAR186=null;
        Token FUNCTION188=null;
        Token PROCEDURE190=null;
        parameterGroup_return parameterGroup185 =null;

        parameterGroup_return parameterGroup187 =null;

        parameterGroup_return parameterGroup189 =null;

        parameterGroup_return parameterGroup191 =null;


        Object VAR186_tree=null;
        Object FUNCTION188_tree=null;
        Object PROCEDURE190_tree=null;

        try {
            // pascal3g.g:477:5: ( parameterGroup | VAR ^ parameterGroup | FUNCTION ^ parameterGroup | PROCEDURE ^ parameterGroup )
            int alt37=4;
            switch ( input.LA(1) ) {
            case IDENT:
                {
                alt37=1;
                }
                break;
            case VAR:
                {
                alt37=2;
                }
                break;
            case FUNCTION:
                {
                alt37=3;
                }
                break;
            case PROCEDURE:
                {
                alt37=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 37, 0, input);

                throw nvae;

            }

            switch (alt37) {
                case 1 :
                    // pascal3g.g:477:7: parameterGroup
                    {
                    root_0 = (Object)adaptor.nil();


                    pushFollow(FOLLOW_parameterGroup_in_formalParameterSection4029);
                    parameterGroup185=parameterGroup();

                    state._fsp--;

                    adaptor.addChild(root_0, parameterGroup185.getTree());

                    }
                    break;
                case 2 :
                    // pascal3g.g:478:7: VAR ^ parameterGroup
                    {
                    root_0 = (Object)adaptor.nil();


                    VAR186=(Token)match(input,VAR,FOLLOW_VAR_in_formalParameterSection4037); 
                    VAR186_tree = 
                    (Object)adaptor.create(VAR186)
                    ;
                    root_0 = (Object)adaptor.becomeRoot(VAR186_tree, root_0);


                    pushFollow(FOLLOW_parameterGroup_in_formalParameterSection4040);
                    parameterGroup187=parameterGroup();

                    state._fsp--;

                    adaptor.addChild(root_0, parameterGroup187.getTree());

                    }
                    break;
                case 3 :
                    // pascal3g.g:479:7: FUNCTION ^ parameterGroup
                    {
                    root_0 = (Object)adaptor.nil();


                    FUNCTION188=(Token)match(input,FUNCTION,FOLLOW_FUNCTION_in_formalParameterSection4048); 
                    FUNCTION188_tree = 
                    (Object)adaptor.create(FUNCTION188)
                    ;
                    root_0 = (Object)adaptor.becomeRoot(FUNCTION188_tree, root_0);


                    pushFollow(FOLLOW_parameterGroup_in_formalParameterSection4051);
                    parameterGroup189=parameterGroup();

                    state._fsp--;

                    adaptor.addChild(root_0, parameterGroup189.getTree());

                    }
                    break;
                case 4 :
                    // pascal3g.g:480:7: PROCEDURE ^ parameterGroup
                    {
                    root_0 = (Object)adaptor.nil();


                    PROCEDURE190=(Token)match(input,PROCEDURE,FOLLOW_PROCEDURE_in_formalParameterSection4059); 
                    PROCEDURE190_tree = 
                    (Object)adaptor.create(PROCEDURE190)
                    ;
                    root_0 = (Object)adaptor.becomeRoot(PROCEDURE190_tree, root_0);


                    pushFollow(FOLLOW_parameterGroup_in_formalParameterSection4062);
                    parameterGroup191=parameterGroup();

                    state._fsp--;

                    adaptor.addChild(root_0, parameterGroup191.getTree());

                    }
                    break;

            }
            retval.stop = input.LT(-1);


            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "formalParameterSection"


    public static class parameterGroup_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "parameterGroup"
    // pascal3g.g:483:1: parameterGroup : ids= identifierList COLON t= typeIdentifier -> ^( ARGDECL identifierList typeIdentifier ) ;
    public final parameterGroup_return parameterGroup() throws RecognitionException {
        parameterGroup_return retval = new parameterGroup_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token COLON192=null;
        identifierList_return ids =null;

        typeIdentifier_return t =null;


        Object COLON192_tree=null;
        RewriteRuleTokenStream stream_COLON=new RewriteRuleTokenStream(adaptor,"token COLON");
        RewriteRuleSubtreeStream stream_typeIdentifier=new RewriteRuleSubtreeStream(adaptor,"rule typeIdentifier");
        RewriteRuleSubtreeStream stream_identifierList=new RewriteRuleSubtreeStream(adaptor,"rule identifierList");
        try {
            // pascal3g.g:484:5: (ids= identifierList COLON t= typeIdentifier -> ^( ARGDECL identifierList typeIdentifier ) )
            // pascal3g.g:484:7: ids= identifierList COLON t= typeIdentifier
            {
            pushFollow(FOLLOW_identifierList_in_parameterGroup4081);
            ids=identifierList();

            state._fsp--;

            stream_identifierList.add(ids.getTree());

            COLON192=(Token)match(input,COLON,FOLLOW_COLON_in_parameterGroup4083);  
            stream_COLON.add(COLON192);


            pushFollow(FOLLOW_typeIdentifier_in_parameterGroup4087);
            t=typeIdentifier();

            state._fsp--;

            stream_typeIdentifier.add(t.getTree());

            // AST REWRITE
            // elements: identifierList, typeIdentifier
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 485:5: -> ^( ARGDECL identifierList typeIdentifier )
            {
                // pascal3g.g:485:8: ^( ARGDECL identifierList typeIdentifier )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot(
                (Object)adaptor.create(ARGDECL, "ARGDECL")
                , root_1);

                adaptor.addChild(root_1, stream_identifierList.nextTree());

                adaptor.addChild(root_1, stream_typeIdentifier.nextTree());

                adaptor.addChild(root_0, root_1);
                }

            }


            retval.tree = root_0;

            }

            retval.stop = input.LT(-1);


            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "parameterGroup"


    public static class identifierList_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "identifierList"
    // pascal3g.g:488:1: identifierList : identifier ( COMMA identifier )* -> ^( IDLIST ( identifier )+ ) ;
    public final identifierList_return identifierList() throws RecognitionException {
        identifierList_return retval = new identifierList_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token COMMA194=null;
        identifier_return identifier193 =null;

        identifier_return identifier195 =null;


        Object COMMA194_tree=null;
        RewriteRuleTokenStream stream_COMMA=new RewriteRuleTokenStream(adaptor,"token COMMA");
        RewriteRuleSubtreeStream stream_identifier=new RewriteRuleSubtreeStream(adaptor,"rule identifier");
        try {
            // pascal3g.g:489:5: ( identifier ( COMMA identifier )* -> ^( IDLIST ( identifier )+ ) )
            // pascal3g.g:489:7: identifier ( COMMA identifier )*
            {
            pushFollow(FOLLOW_identifier_in_identifierList4118);
            identifier193=identifier();

            state._fsp--;

            stream_identifier.add(identifier193.getTree());

            // pascal3g.g:489:18: ( COMMA identifier )*
            loop38:
            do {
                int alt38=2;
                int LA38_0 = input.LA(1);

                if ( (LA38_0==COMMA) ) {
                    alt38=1;
                }


                switch (alt38) {
            	case 1 :
            	    // pascal3g.g:489:20: COMMA identifier
            	    {
            	    COMMA194=(Token)match(input,COMMA,FOLLOW_COMMA_in_identifierList4122);  
            	    stream_COMMA.add(COMMA194);


            	    pushFollow(FOLLOW_identifier_in_identifierList4124);
            	    identifier195=identifier();

            	    state._fsp--;

            	    stream_identifier.add(identifier195.getTree());

            	    }
            	    break;

            	default :
            	    break loop38;
                }
            } while (true);


            // AST REWRITE
            // elements: identifier
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 490:5: -> ^( IDLIST ( identifier )+ )
            {
                // pascal3g.g:490:7: ^( IDLIST ( identifier )+ )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot(
                (Object)adaptor.create(IDLIST, "IDLIST")
                , root_1);

                if ( !(stream_identifier.hasNext()) ) {
                    throw new RewriteEarlyExitException();
                }
                while ( stream_identifier.hasNext() ) {
                    adaptor.addChild(root_1, stream_identifier.nextTree());

                }
                stream_identifier.reset();

                adaptor.addChild(root_0, root_1);
                }

            }


            retval.tree = root_0;

            }

            retval.stop = input.LT(-1);


            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "identifierList"


    public static class constList_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "constList"
    // pascal3g.g:493:1: constList : constant ( COMMA constant )* -> ^( CONSTLIST ( constant )+ ) ;
    public final constList_return constList() throws RecognitionException {
        constList_return retval = new constList_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token COMMA197=null;
        constant_return constant196 =null;

        constant_return constant198 =null;


        Object COMMA197_tree=null;
        RewriteRuleTokenStream stream_COMMA=new RewriteRuleTokenStream(adaptor,"token COMMA");
        RewriteRuleSubtreeStream stream_constant=new RewriteRuleSubtreeStream(adaptor,"rule constant");
        try {
            // pascal3g.g:494:5: ( constant ( COMMA constant )* -> ^( CONSTLIST ( constant )+ ) )
            // pascal3g.g:494:7: constant ( COMMA constant )*
            {
            pushFollow(FOLLOW_constant_in_constList4156);
            constant196=constant();

            state._fsp--;

            stream_constant.add(constant196.getTree());

            // pascal3g.g:494:16: ( COMMA constant )*
            loop39:
            do {
                int alt39=2;
                int LA39_0 = input.LA(1);

                if ( (LA39_0==COMMA) ) {
                    alt39=1;
                }


                switch (alt39) {
            	case 1 :
            	    // pascal3g.g:494:18: COMMA constant
            	    {
            	    COMMA197=(Token)match(input,COMMA,FOLLOW_COMMA_in_constList4160);  
            	    stream_COMMA.add(COMMA197);


            	    pushFollow(FOLLOW_constant_in_constList4162);
            	    constant198=constant();

            	    state._fsp--;

            	    stream_constant.add(constant198.getTree());

            	    }
            	    break;

            	default :
            	    break loop39;
                }
            } while (true);


            // AST REWRITE
            // elements: constant
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 495:5: -> ^( CONSTLIST ( constant )+ )
            {
                // pascal3g.g:495:7: ^( CONSTLIST ( constant )+ )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot(
                (Object)adaptor.create(CONSTLIST, "CONSTLIST")
                , root_1);

                if ( !(stream_constant.hasNext()) ) {
                    throw new RewriteEarlyExitException();
                }
                while ( stream_constant.hasNext() ) {
                    adaptor.addChild(root_1, stream_constant.nextTree());

                }
                stream_constant.reset();

                adaptor.addChild(root_0, root_1);
                }

            }


            retval.tree = root_0;

            }

            retval.stop = input.LT(-1);


            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "constList"


    public static class resultType_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "resultType"
    // pascal3g.g:498:1: resultType : typeIdentifier ;
    public final resultType_return resultType() throws RecognitionException {
        resultType_return retval = new resultType_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        typeIdentifier_return typeIdentifier199 =null;



        try {
            // pascal3g.g:499:5: ( typeIdentifier )
            // pascal3g.g:499:7: typeIdentifier
            {
            root_0 = (Object)adaptor.nil();


            pushFollow(FOLLOW_typeIdentifier_in_resultType4194);
            typeIdentifier199=typeIdentifier();

            state._fsp--;

            adaptor.addChild(root_0, typeIdentifier199.getTree());

            }

            retval.stop = input.LT(-1);


            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "resultType"


    public static class statement_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "statement"
    // pascal3g.g:502:1: statement : ( label COLON ^ unlabelledStatement | unlabelledStatement );
    public final statement_return statement() throws RecognitionException {
        statement_return retval = new statement_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token COLON201=null;
        label_return label200 =null;

        unlabelledStatement_return unlabelledStatement202 =null;

        unlabelledStatement_return unlabelledStatement203 =null;


        Object COLON201_tree=null;

        try {
            // pascal3g.g:503:5: ( label COLON ^ unlabelledStatement | unlabelledStatement )
            int alt40=2;
            int LA40_0 = input.LA(1);

            if ( (LA40_0==NUM_INT) ) {
                alt40=1;
            }
            else if ( ((LA40_0 >= AT && LA40_0 <= BEGIN)||LA40_0==CASE||(LA40_0 >= ELSE && LA40_0 <= END)||LA40_0==EXIT||LA40_0==FOR||LA40_0==GOTO||LA40_0==IDENT||LA40_0==IF||LA40_0==REPEAT||LA40_0==SEMI||LA40_0==UNTIL||(LA40_0 >= WHILE && LA40_0 <= WITH)) ) {
                alt40=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 40, 0, input);

                throw nvae;

            }
            switch (alt40) {
                case 1 :
                    // pascal3g.g:503:7: label COLON ^ unlabelledStatement
                    {
                    root_0 = (Object)adaptor.nil();


                    pushFollow(FOLLOW_label_in_statement4211);
                    label200=label();

                    state._fsp--;

                    adaptor.addChild(root_0, label200.getTree());

                    COLON201=(Token)match(input,COLON,FOLLOW_COLON_in_statement4213); 
                    COLON201_tree = 
                    (Object)adaptor.create(COLON201)
                    ;
                    root_0 = (Object)adaptor.becomeRoot(COLON201_tree, root_0);


                    pushFollow(FOLLOW_unlabelledStatement_in_statement4216);
                    unlabelledStatement202=unlabelledStatement();

                    state._fsp--;

                    adaptor.addChild(root_0, unlabelledStatement202.getTree());

                    }
                    break;
                case 2 :
                    // pascal3g.g:504:7: unlabelledStatement
                    {
                    root_0 = (Object)adaptor.nil();


                    pushFollow(FOLLOW_unlabelledStatement_in_statement4224);
                    unlabelledStatement203=unlabelledStatement();

                    state._fsp--;

                    adaptor.addChild(root_0, unlabelledStatement203.getTree());

                    }
                    break;

            }
            retval.stop = input.LT(-1);


            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "statement"


    public static class unlabelledStatement_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "unlabelledStatement"
    // pascal3g.g:507:1: unlabelledStatement : ( simpleStatement | structuredStatement );
    public final unlabelledStatement_return unlabelledStatement() throws RecognitionException {
        unlabelledStatement_return retval = new unlabelledStatement_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        simpleStatement_return simpleStatement204 =null;

        structuredStatement_return structuredStatement205 =null;



        try {
            // pascal3g.g:508:5: ( simpleStatement | structuredStatement )
            int alt41=2;
            int LA41_0 = input.LA(1);

            if ( (LA41_0==AT||(LA41_0 >= ELSE && LA41_0 <= END)||LA41_0==EXIT||LA41_0==GOTO||LA41_0==IDENT||LA41_0==SEMI||LA41_0==UNTIL) ) {
                alt41=1;
            }
            else if ( (LA41_0==BEGIN||LA41_0==CASE||LA41_0==FOR||LA41_0==IF||LA41_0==REPEAT||(LA41_0 >= WHILE && LA41_0 <= WITH)) ) {
                alt41=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 41, 0, input);

                throw nvae;

            }
            switch (alt41) {
                case 1 :
                    // pascal3g.g:508:7: simpleStatement
                    {
                    root_0 = (Object)adaptor.nil();


                    pushFollow(FOLLOW_simpleStatement_in_unlabelledStatement4241);
                    simpleStatement204=simpleStatement();

                    state._fsp--;

                    adaptor.addChild(root_0, simpleStatement204.getTree());

                    }
                    break;
                case 2 :
                    // pascal3g.g:509:7: structuredStatement
                    {
                    root_0 = (Object)adaptor.nil();


                    pushFollow(FOLLOW_structuredStatement_in_unlabelledStatement4249);
                    structuredStatement205=structuredStatement();

                    state._fsp--;

                    adaptor.addChild(root_0, structuredStatement205.getTree());

                    }
                    break;

            }
            retval.stop = input.LT(-1);


            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "unlabelledStatement"


    public static class exitStatement_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "exitStatement"
    // pascal3g.g:512:1: exitStatement : EXIT ^;
    public final exitStatement_return exitStatement() throws RecognitionException {
        exitStatement_return retval = new exitStatement_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token EXIT206=null;

        Object EXIT206_tree=null;

        try {
            // pascal3g.g:513:5: ( EXIT ^)
            // pascal3g.g:513:7: EXIT ^
            {
            root_0 = (Object)adaptor.nil();


            EXIT206=(Token)match(input,EXIT,FOLLOW_EXIT_in_exitStatement4266); 
            EXIT206_tree = 
            (Object)adaptor.create(EXIT206)
            ;
            root_0 = (Object)adaptor.becomeRoot(EXIT206_tree, root_0);


            }

            retval.stop = input.LT(-1);


            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "exitStatement"


    public static class simpleStatement_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "simpleStatement"
    // pascal3g.g:517:1: simpleStatement : ( assignmentStatement | procedureStatement | exitStatement | gotoStatement | emptyStatement );
    public final simpleStatement_return simpleStatement() throws RecognitionException {
        simpleStatement_return retval = new simpleStatement_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        assignmentStatement_return assignmentStatement207 =null;

        procedureStatement_return procedureStatement208 =null;

        exitStatement_return exitStatement209 =null;

        gotoStatement_return gotoStatement210 =null;

        emptyStatement_return emptyStatement211 =null;



        try {
            // pascal3g.g:518:5: ( assignmentStatement | procedureStatement | exitStatement | gotoStatement | emptyStatement )
            int alt42=5;
            switch ( input.LA(1) ) {
            case AT:
                {
                alt42=1;
                }
                break;
            case IDENT:
                {
                int LA42_2 = input.LA(2);

                if ( (LA42_2==ASSIGN||LA42_2==DOT||(LA42_2 >= LBRACK && LA42_2 <= LBRACK2)||LA42_2==POINTER) ) {
                    alt42=1;
                }
                else if ( ((LA42_2 >= ELSE && LA42_2 <= END)||LA42_2==LPAREN||LA42_2==SEMI||LA42_2==UNTIL) ) {
                    alt42=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 42, 2, input);

                    throw nvae;

                }
                }
                break;
            case EXIT:
                {
                alt42=3;
                }
                break;
            case GOTO:
                {
                alt42=4;
                }
                break;
            case ELSE:
            case END:
            case SEMI:
            case UNTIL:
                {
                alt42=5;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 42, 0, input);

                throw nvae;

            }

            switch (alt42) {
                case 1 :
                    // pascal3g.g:518:7: assignmentStatement
                    {
                    root_0 = (Object)adaptor.nil();


                    pushFollow(FOLLOW_assignmentStatement_in_simpleStatement4286);
                    assignmentStatement207=assignmentStatement();

                    state._fsp--;

                    adaptor.addChild(root_0, assignmentStatement207.getTree());

                    }
                    break;
                case 2 :
                    // pascal3g.g:519:7: procedureStatement
                    {
                    root_0 = (Object)adaptor.nil();


                    pushFollow(FOLLOW_procedureStatement_in_simpleStatement4294);
                    procedureStatement208=procedureStatement();

                    state._fsp--;

                    adaptor.addChild(root_0, procedureStatement208.getTree());

                    }
                    break;
                case 3 :
                    // pascal3g.g:520:7: exitStatement
                    {
                    root_0 = (Object)adaptor.nil();


                    pushFollow(FOLLOW_exitStatement_in_simpleStatement4302);
                    exitStatement209=exitStatement();

                    state._fsp--;

                    adaptor.addChild(root_0, exitStatement209.getTree());

                    }
                    break;
                case 4 :
                    // pascal3g.g:521:7: gotoStatement
                    {
                    root_0 = (Object)adaptor.nil();


                    pushFollow(FOLLOW_gotoStatement_in_simpleStatement4310);
                    gotoStatement210=gotoStatement();

                    state._fsp--;

                    adaptor.addChild(root_0, gotoStatement210.getTree());

                    }
                    break;
                case 5 :
                    // pascal3g.g:522:7: emptyStatement
                    {
                    root_0 = (Object)adaptor.nil();


                    pushFollow(FOLLOW_emptyStatement_in_simpleStatement4318);
                    emptyStatement211=emptyStatement();

                    state._fsp--;

                    adaptor.addChild(root_0, emptyStatement211.getTree());

                    }
                    break;

            }
            retval.stop = input.LT(-1);


            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "simpleStatement"


    public static class assignmentStatement_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "assignmentStatement"
    // pascal3g.g:525:1: assignmentStatement : variable ASSIGN ^ expression ;
    public final assignmentStatement_return assignmentStatement() throws RecognitionException {
        assignmentStatement_return retval = new assignmentStatement_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token ASSIGN213=null;
        variable_return variable212 =null;

        expression_return expression214 =null;


        Object ASSIGN213_tree=null;

        try {
            // pascal3g.g:526:5: ( variable ASSIGN ^ expression )
            // pascal3g.g:526:7: variable ASSIGN ^ expression
            {
            root_0 = (Object)adaptor.nil();


            pushFollow(FOLLOW_variable_in_assignmentStatement4335);
            variable212=variable();

            state._fsp--;

            adaptor.addChild(root_0, variable212.getTree());

            ASSIGN213=(Token)match(input,ASSIGN,FOLLOW_ASSIGN_in_assignmentStatement4337); 
            ASSIGN213_tree = 
            (Object)adaptor.create(ASSIGN213)
            ;
            root_0 = (Object)adaptor.becomeRoot(ASSIGN213_tree, root_0);


            pushFollow(FOLLOW_expression_in_assignmentStatement4340);
            expression214=expression();

            state._fsp--;

            adaptor.addChild(root_0, expression214.getTree());

            }

            retval.stop = input.LT(-1);


            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "assignmentStatement"


    public static class variable_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "variable"
    // pascal3g.g:529:1: variable : ( AT ^ identifier | identifier ) ( LBRACK ^ expression ( COMMA ! expression )* RBRACK !| LBRACK2 ^ expression ( COMMA ! expression )* RBRACK2 !| DOT ^ identifier | POINTER ^)* ;
    public final variable_return variable() throws RecognitionException {
        variable_return retval = new variable_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token AT215=null;
        Token LBRACK218=null;
        Token COMMA220=null;
        Token RBRACK222=null;
        Token LBRACK2223=null;
        Token COMMA225=null;
        Token RBRACK2227=null;
        Token DOT228=null;
        Token POINTER230=null;
        identifier_return identifier216 =null;

        identifier_return identifier217 =null;

        expression_return expression219 =null;

        expression_return expression221 =null;

        expression_return expression224 =null;

        expression_return expression226 =null;

        identifier_return identifier229 =null;


        Object AT215_tree=null;
        Object LBRACK218_tree=null;
        Object COMMA220_tree=null;
        Object RBRACK222_tree=null;
        Object LBRACK2223_tree=null;
        Object COMMA225_tree=null;
        Object RBRACK2227_tree=null;
        Object DOT228_tree=null;
        Object POINTER230_tree=null;

        try {
            // pascal3g.g:530:5: ( ( AT ^ identifier | identifier ) ( LBRACK ^ expression ( COMMA ! expression )* RBRACK !| LBRACK2 ^ expression ( COMMA ! expression )* RBRACK2 !| DOT ^ identifier | POINTER ^)* )
            // pascal3g.g:530:7: ( AT ^ identifier | identifier ) ( LBRACK ^ expression ( COMMA ! expression )* RBRACK !| LBRACK2 ^ expression ( COMMA ! expression )* RBRACK2 !| DOT ^ identifier | POINTER ^)*
            {
            root_0 = (Object)adaptor.nil();


            // pascal3g.g:530:7: ( AT ^ identifier | identifier )
            int alt43=2;
            int LA43_0 = input.LA(1);

            if ( (LA43_0==AT) ) {
                alt43=1;
            }
            else if ( (LA43_0==IDENT) ) {
                alt43=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 43, 0, input);

                throw nvae;

            }
            switch (alt43) {
                case 1 :
                    // pascal3g.g:530:9: AT ^ identifier
                    {
                    AT215=(Token)match(input,AT,FOLLOW_AT_in_variable4359); 
                    AT215_tree = 
                    (Object)adaptor.create(AT215)
                    ;
                    root_0 = (Object)adaptor.becomeRoot(AT215_tree, root_0);


                    pushFollow(FOLLOW_identifier_in_variable4362);
                    identifier216=identifier();

                    state._fsp--;

                    adaptor.addChild(root_0, identifier216.getTree());

                    }
                    break;
                case 2 :
                    // pascal3g.g:531:9: identifier
                    {
                    pushFollow(FOLLOW_identifier_in_variable4373);
                    identifier217=identifier();

                    state._fsp--;

                    adaptor.addChild(root_0, identifier217.getTree());

                    }
                    break;

            }


            // pascal3g.g:533:7: ( LBRACK ^ expression ( COMMA ! expression )* RBRACK !| LBRACK2 ^ expression ( COMMA ! expression )* RBRACK2 !| DOT ^ identifier | POINTER ^)*
            loop46:
            do {
                int alt46=5;
                switch ( input.LA(1) ) {
                case LBRACK:
                    {
                    alt46=1;
                    }
                    break;
                case LBRACK2:
                    {
                    alt46=2;
                    }
                    break;
                case DOT:
                    {
                    alt46=3;
                    }
                    break;
                case POINTER:
                    {
                    alt46=4;
                    }
                    break;

                }

                switch (alt46) {
            	case 1 :
            	    // pascal3g.g:533:10: LBRACK ^ expression ( COMMA ! expression )* RBRACK !
            	    {
            	    LBRACK218=(Token)match(input,LBRACK,FOLLOW_LBRACK_in_variable4392); 
            	    LBRACK218_tree = 
            	    (Object)adaptor.create(LBRACK218)
            	    ;
            	    root_0 = (Object)adaptor.becomeRoot(LBRACK218_tree, root_0);


            	    pushFollow(FOLLOW_expression_in_variable4395);
            	    expression219=expression();

            	    state._fsp--;

            	    adaptor.addChild(root_0, expression219.getTree());

            	    // pascal3g.g:533:29: ( COMMA ! expression )*
            	    loop44:
            	    do {
            	        int alt44=2;
            	        int LA44_0 = input.LA(1);

            	        if ( (LA44_0==COMMA) ) {
            	            alt44=1;
            	        }


            	        switch (alt44) {
            	    	case 1 :
            	    	    // pascal3g.g:533:31: COMMA ! expression
            	    	    {
            	    	    COMMA220=(Token)match(input,COMMA,FOLLOW_COMMA_in_variable4399); 

            	    	    pushFollow(FOLLOW_expression_in_variable4402);
            	    	    expression221=expression();

            	    	    state._fsp--;

            	    	    adaptor.addChild(root_0, expression221.getTree());

            	    	    }
            	    	    break;

            	    	default :
            	    	    break loop44;
            	        }
            	    } while (true);


            	    RBRACK222=(Token)match(input,RBRACK,FOLLOW_RBRACK_in_variable4406); 

            	    }
            	    break;
            	case 2 :
            	    // pascal3g.g:534:9: LBRACK2 ^ expression ( COMMA ! expression )* RBRACK2 !
            	    {
            	    LBRACK2223=(Token)match(input,LBRACK2,FOLLOW_LBRACK2_in_variable4417); 
            	    LBRACK2223_tree = 
            	    (Object)adaptor.create(LBRACK2223)
            	    ;
            	    root_0 = (Object)adaptor.becomeRoot(LBRACK2223_tree, root_0);


            	    pushFollow(FOLLOW_expression_in_variable4420);
            	    expression224=expression();

            	    state._fsp--;

            	    adaptor.addChild(root_0, expression224.getTree());

            	    // pascal3g.g:534:29: ( COMMA ! expression )*
            	    loop45:
            	    do {
            	        int alt45=2;
            	        int LA45_0 = input.LA(1);

            	        if ( (LA45_0==COMMA) ) {
            	            alt45=1;
            	        }


            	        switch (alt45) {
            	    	case 1 :
            	    	    // pascal3g.g:534:31: COMMA ! expression
            	    	    {
            	    	    COMMA225=(Token)match(input,COMMA,FOLLOW_COMMA_in_variable4424); 

            	    	    pushFollow(FOLLOW_expression_in_variable4427);
            	    	    expression226=expression();

            	    	    state._fsp--;

            	    	    adaptor.addChild(root_0, expression226.getTree());

            	    	    }
            	    	    break;

            	    	default :
            	    	    break loop45;
            	        }
            	    } while (true);


            	    RBRACK2227=(Token)match(input,RBRACK2,FOLLOW_RBRACK2_in_variable4431); 

            	    }
            	    break;
            	case 3 :
            	    // pascal3g.g:535:9: DOT ^ identifier
            	    {
            	    DOT228=(Token)match(input,DOT,FOLLOW_DOT_in_variable4442); 
            	    DOT228_tree = 
            	    (Object)adaptor.create(DOT228)
            	    ;
            	    root_0 = (Object)adaptor.becomeRoot(DOT228_tree, root_0);


            	    pushFollow(FOLLOW_identifier_in_variable4445);
            	    identifier229=identifier();

            	    state._fsp--;

            	    adaptor.addChild(root_0, identifier229.getTree());

            	    }
            	    break;
            	case 4 :
            	    // pascal3g.g:536:9: POINTER ^
            	    {
            	    POINTER230=(Token)match(input,POINTER,FOLLOW_POINTER_in_variable4455); 
            	    POINTER230_tree = 
            	    (Object)adaptor.create(POINTER230)
            	    ;
            	    root_0 = (Object)adaptor.becomeRoot(POINTER230_tree, root_0);


            	    }
            	    break;

            	default :
            	    break loop46;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);


            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "variable"


    public static class expression_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "expression"
    // pascal3g.g:540:1: expression : simpleExpression ( ( EQUAL ^| NOT_EQUAL ^| LT ^| LE ^| GE ^| GT ^| IN ^) simpleExpression )* ;
    public final expression_return expression() throws RecognitionException {
        expression_return retval = new expression_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token EQUAL232=null;
        Token NOT_EQUAL233=null;
        Token LT234=null;
        Token LE235=null;
        Token GE236=null;
        Token GT237=null;
        Token IN238=null;
        simpleExpression_return simpleExpression231 =null;

        simpleExpression_return simpleExpression239 =null;


        Object EQUAL232_tree=null;
        Object NOT_EQUAL233_tree=null;
        Object LT234_tree=null;
        Object LE235_tree=null;
        Object GE236_tree=null;
        Object GT237_tree=null;
        Object IN238_tree=null;

        try {
            // pascal3g.g:541:5: ( simpleExpression ( ( EQUAL ^| NOT_EQUAL ^| LT ^| LE ^| GE ^| GT ^| IN ^) simpleExpression )* )
            // pascal3g.g:541:7: simpleExpression ( ( EQUAL ^| NOT_EQUAL ^| LT ^| LE ^| GE ^| GT ^| IN ^) simpleExpression )*
            {
            root_0 = (Object)adaptor.nil();


            pushFollow(FOLLOW_simpleExpression_in_expression4482);
            simpleExpression231=simpleExpression();

            state._fsp--;

            adaptor.addChild(root_0, simpleExpression231.getTree());

            // pascal3g.g:542:5: ( ( EQUAL ^| NOT_EQUAL ^| LT ^| LE ^| GE ^| GT ^| IN ^) simpleExpression )*
            loop48:
            do {
                int alt48=2;
                int LA48_0 = input.LA(1);

                if ( (LA48_0==EQUAL||LA48_0==GE||LA48_0==GT||LA48_0==IN||LA48_0==LE||LA48_0==LT||LA48_0==NOT_EQUAL) ) {
                    alt48=1;
                }


                switch (alt48) {
            	case 1 :
            	    // pascal3g.g:542:7: ( EQUAL ^| NOT_EQUAL ^| LT ^| LE ^| GE ^| GT ^| IN ^) simpleExpression
            	    {
            	    // pascal3g.g:542:7: ( EQUAL ^| NOT_EQUAL ^| LT ^| LE ^| GE ^| GT ^| IN ^)
            	    int alt47=7;
            	    switch ( input.LA(1) ) {
            	    case EQUAL:
            	        {
            	        alt47=1;
            	        }
            	        break;
            	    case NOT_EQUAL:
            	        {
            	        alt47=2;
            	        }
            	        break;
            	    case LT:
            	        {
            	        alt47=3;
            	        }
            	        break;
            	    case LE:
            	        {
            	        alt47=4;
            	        }
            	        break;
            	    case GE:
            	        {
            	        alt47=5;
            	        }
            	        break;
            	    case GT:
            	        {
            	        alt47=6;
            	        }
            	        break;
            	    case IN:
            	        {
            	        alt47=7;
            	        }
            	        break;
            	    default:
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 47, 0, input);

            	        throw nvae;

            	    }

            	    switch (alt47) {
            	        case 1 :
            	            // pascal3g.g:542:8: EQUAL ^
            	            {
            	            EQUAL232=(Token)match(input,EQUAL,FOLLOW_EQUAL_in_expression4491); 
            	            EQUAL232_tree = 
            	            (Object)adaptor.create(EQUAL232)
            	            ;
            	            root_0 = (Object)adaptor.becomeRoot(EQUAL232_tree, root_0);


            	            }
            	            break;
            	        case 2 :
            	            // pascal3g.g:542:17: NOT_EQUAL ^
            	            {
            	            NOT_EQUAL233=(Token)match(input,NOT_EQUAL,FOLLOW_NOT_EQUAL_in_expression4496); 
            	            NOT_EQUAL233_tree = 
            	            (Object)adaptor.create(NOT_EQUAL233)
            	            ;
            	            root_0 = (Object)adaptor.becomeRoot(NOT_EQUAL233_tree, root_0);


            	            }
            	            break;
            	        case 3 :
            	            // pascal3g.g:542:30: LT ^
            	            {
            	            LT234=(Token)match(input,LT,FOLLOW_LT_in_expression4501); 
            	            LT234_tree = 
            	            (Object)adaptor.create(LT234)
            	            ;
            	            root_0 = (Object)adaptor.becomeRoot(LT234_tree, root_0);


            	            }
            	            break;
            	        case 4 :
            	            // pascal3g.g:542:36: LE ^
            	            {
            	            LE235=(Token)match(input,LE,FOLLOW_LE_in_expression4506); 
            	            LE235_tree = 
            	            (Object)adaptor.create(LE235)
            	            ;
            	            root_0 = (Object)adaptor.becomeRoot(LE235_tree, root_0);


            	            }
            	            break;
            	        case 5 :
            	            // pascal3g.g:542:42: GE ^
            	            {
            	            GE236=(Token)match(input,GE,FOLLOW_GE_in_expression4511); 
            	            GE236_tree = 
            	            (Object)adaptor.create(GE236)
            	            ;
            	            root_0 = (Object)adaptor.becomeRoot(GE236_tree, root_0);


            	            }
            	            break;
            	        case 6 :
            	            // pascal3g.g:542:48: GT ^
            	            {
            	            GT237=(Token)match(input,GT,FOLLOW_GT_in_expression4516); 
            	            GT237_tree = 
            	            (Object)adaptor.create(GT237)
            	            ;
            	            root_0 = (Object)adaptor.becomeRoot(GT237_tree, root_0);


            	            }
            	            break;
            	        case 7 :
            	            // pascal3g.g:542:54: IN ^
            	            {
            	            IN238=(Token)match(input,IN,FOLLOW_IN_in_expression4521); 
            	            IN238_tree = 
            	            (Object)adaptor.create(IN238)
            	            ;
            	            root_0 = (Object)adaptor.becomeRoot(IN238_tree, root_0);


            	            }
            	            break;

            	    }


            	    pushFollow(FOLLOW_simpleExpression_in_expression4525);
            	    simpleExpression239=simpleExpression();

            	    state._fsp--;

            	    adaptor.addChild(root_0, simpleExpression239.getTree());

            	    }
            	    break;

            	default :
            	    break loop48;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);


            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "expression"


    public static class simpleExpression_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "simpleExpression"
    // pascal3g.g:545:1: simpleExpression : term ( ( PLUS ^| MINUS ^| OR ^) term )* ;
    public final simpleExpression_return simpleExpression() throws RecognitionException {
        simpleExpression_return retval = new simpleExpression_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token PLUS241=null;
        Token MINUS242=null;
        Token OR243=null;
        term_return term240 =null;

        term_return term244 =null;


        Object PLUS241_tree=null;
        Object MINUS242_tree=null;
        Object OR243_tree=null;

        try {
            // pascal3g.g:546:5: ( term ( ( PLUS ^| MINUS ^| OR ^) term )* )
            // pascal3g.g:546:7: term ( ( PLUS ^| MINUS ^| OR ^) term )*
            {
            root_0 = (Object)adaptor.nil();


            pushFollow(FOLLOW_term_in_simpleExpression4545);
            term240=term();

            state._fsp--;

            adaptor.addChild(root_0, term240.getTree());

            // pascal3g.g:546:12: ( ( PLUS ^| MINUS ^| OR ^) term )*
            loop50:
            do {
                int alt50=2;
                int LA50_0 = input.LA(1);

                if ( (LA50_0==MINUS||LA50_0==OR||LA50_0==PLUS) ) {
                    alt50=1;
                }


                switch (alt50) {
            	case 1 :
            	    // pascal3g.g:546:14: ( PLUS ^| MINUS ^| OR ^) term
            	    {
            	    // pascal3g.g:546:14: ( PLUS ^| MINUS ^| OR ^)
            	    int alt49=3;
            	    switch ( input.LA(1) ) {
            	    case PLUS:
            	        {
            	        alt49=1;
            	        }
            	        break;
            	    case MINUS:
            	        {
            	        alt49=2;
            	        }
            	        break;
            	    case OR:
            	        {
            	        alt49=3;
            	        }
            	        break;
            	    default:
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 49, 0, input);

            	        throw nvae;

            	    }

            	    switch (alt49) {
            	        case 1 :
            	            // pascal3g.g:546:15: PLUS ^
            	            {
            	            PLUS241=(Token)match(input,PLUS,FOLLOW_PLUS_in_simpleExpression4550); 
            	            PLUS241_tree = 
            	            (Object)adaptor.create(PLUS241)
            	            ;
            	            root_0 = (Object)adaptor.becomeRoot(PLUS241_tree, root_0);


            	            }
            	            break;
            	        case 2 :
            	            // pascal3g.g:546:23: MINUS ^
            	            {
            	            MINUS242=(Token)match(input,MINUS,FOLLOW_MINUS_in_simpleExpression4555); 
            	            MINUS242_tree = 
            	            (Object)adaptor.create(MINUS242)
            	            ;
            	            root_0 = (Object)adaptor.becomeRoot(MINUS242_tree, root_0);


            	            }
            	            break;
            	        case 3 :
            	            // pascal3g.g:546:32: OR ^
            	            {
            	            OR243=(Token)match(input,OR,FOLLOW_OR_in_simpleExpression4560); 
            	            OR243_tree = 
            	            (Object)adaptor.create(OR243)
            	            ;
            	            root_0 = (Object)adaptor.becomeRoot(OR243_tree, root_0);


            	            }
            	            break;

            	    }


            	    pushFollow(FOLLOW_term_in_simpleExpression4564);
            	    term244=term();

            	    state._fsp--;

            	    adaptor.addChild(root_0, term244.getTree());

            	    }
            	    break;

            	default :
            	    break loop50;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);


            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "simpleExpression"


    public static class term_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "term"
    // pascal3g.g:549:1: term : signedFactor ( ( STAR ^| SLASH ^| DIV ^| MOD ^| AND ^) signedFactor )* ;
    public final term_return term() throws RecognitionException {
        term_return retval = new term_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token STAR246=null;
        Token SLASH247=null;
        Token DIV248=null;
        Token MOD249=null;
        Token AND250=null;
        signedFactor_return signedFactor245 =null;

        signedFactor_return signedFactor251 =null;


        Object STAR246_tree=null;
        Object SLASH247_tree=null;
        Object DIV248_tree=null;
        Object MOD249_tree=null;
        Object AND250_tree=null;

        try {
            // pascal3g.g:550:3: ( signedFactor ( ( STAR ^| SLASH ^| DIV ^| MOD ^| AND ^) signedFactor )* )
            // pascal3g.g:550:5: signedFactor ( ( STAR ^| SLASH ^| DIV ^| MOD ^| AND ^) signedFactor )*
            {
            root_0 = (Object)adaptor.nil();


            pushFollow(FOLLOW_signedFactor_in_term4582);
            signedFactor245=signedFactor();

            state._fsp--;

            adaptor.addChild(root_0, signedFactor245.getTree());

            // pascal3g.g:550:18: ( ( STAR ^| SLASH ^| DIV ^| MOD ^| AND ^) signedFactor )*
            loop52:
            do {
                int alt52=2;
                int LA52_0 = input.LA(1);

                if ( (LA52_0==AND||LA52_0==DIV||LA52_0==MOD||(LA52_0 >= SLASH && LA52_0 <= STAR)) ) {
                    alt52=1;
                }


                switch (alt52) {
            	case 1 :
            	    // pascal3g.g:550:20: ( STAR ^| SLASH ^| DIV ^| MOD ^| AND ^) signedFactor
            	    {
            	    // pascal3g.g:550:20: ( STAR ^| SLASH ^| DIV ^| MOD ^| AND ^)
            	    int alt51=5;
            	    switch ( input.LA(1) ) {
            	    case STAR:
            	        {
            	        alt51=1;
            	        }
            	        break;
            	    case SLASH:
            	        {
            	        alt51=2;
            	        }
            	        break;
            	    case DIV:
            	        {
            	        alt51=3;
            	        }
            	        break;
            	    case MOD:
            	        {
            	        alt51=4;
            	        }
            	        break;
            	    case AND:
            	        {
            	        alt51=5;
            	        }
            	        break;
            	    default:
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 51, 0, input);

            	        throw nvae;

            	    }

            	    switch (alt51) {
            	        case 1 :
            	            // pascal3g.g:550:21: STAR ^
            	            {
            	            STAR246=(Token)match(input,STAR,FOLLOW_STAR_in_term4587); 
            	            STAR246_tree = 
            	            (Object)adaptor.create(STAR246)
            	            ;
            	            root_0 = (Object)adaptor.becomeRoot(STAR246_tree, root_0);


            	            }
            	            break;
            	        case 2 :
            	            // pascal3g.g:550:29: SLASH ^
            	            {
            	            SLASH247=(Token)match(input,SLASH,FOLLOW_SLASH_in_term4592); 
            	            SLASH247_tree = 
            	            (Object)adaptor.create(SLASH247)
            	            ;
            	            root_0 = (Object)adaptor.becomeRoot(SLASH247_tree, root_0);


            	            }
            	            break;
            	        case 3 :
            	            // pascal3g.g:550:38: DIV ^
            	            {
            	            DIV248=(Token)match(input,DIV,FOLLOW_DIV_in_term4597); 
            	            DIV248_tree = 
            	            (Object)adaptor.create(DIV248)
            	            ;
            	            root_0 = (Object)adaptor.becomeRoot(DIV248_tree, root_0);


            	            }
            	            break;
            	        case 4 :
            	            // pascal3g.g:550:45: MOD ^
            	            {
            	            MOD249=(Token)match(input,MOD,FOLLOW_MOD_in_term4602); 
            	            MOD249_tree = 
            	            (Object)adaptor.create(MOD249)
            	            ;
            	            root_0 = (Object)adaptor.becomeRoot(MOD249_tree, root_0);


            	            }
            	            break;
            	        case 5 :
            	            // pascal3g.g:550:52: AND ^
            	            {
            	            AND250=(Token)match(input,AND,FOLLOW_AND_in_term4607); 
            	            AND250_tree = 
            	            (Object)adaptor.create(AND250)
            	            ;
            	            root_0 = (Object)adaptor.becomeRoot(AND250_tree, root_0);


            	            }
            	            break;

            	    }


            	    pushFollow(FOLLOW_signedFactor_in_term4611);
            	    signedFactor251=signedFactor();

            	    state._fsp--;

            	    adaptor.addChild(root_0, signedFactor251.getTree());

            	    }
            	    break;

            	default :
            	    break loop52;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);


            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "term"


    public static class signedFactor_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "signedFactor"
    // pascal3g.g:553:1: signedFactor : ( PLUS ^| MINUS ^)? factor ;
    public final signedFactor_return signedFactor() throws RecognitionException {
        signedFactor_return retval = new signedFactor_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token PLUS252=null;
        Token MINUS253=null;
        factor_return factor254 =null;


        Object PLUS252_tree=null;
        Object MINUS253_tree=null;

        try {
            // pascal3g.g:554:5: ( ( PLUS ^| MINUS ^)? factor )
            // pascal3g.g:554:7: ( PLUS ^| MINUS ^)? factor
            {
            root_0 = (Object)adaptor.nil();


            // pascal3g.g:554:7: ( PLUS ^| MINUS ^)?
            int alt53=3;
            int LA53_0 = input.LA(1);

            if ( (LA53_0==PLUS) ) {
                alt53=1;
            }
            else if ( (LA53_0==MINUS) ) {
                alt53=2;
            }
            switch (alt53) {
                case 1 :
                    // pascal3g.g:554:8: PLUS ^
                    {
                    PLUS252=(Token)match(input,PLUS,FOLLOW_PLUS_in_signedFactor4632); 
                    PLUS252_tree = 
                    (Object)adaptor.create(PLUS252)
                    ;
                    root_0 = (Object)adaptor.becomeRoot(PLUS252_tree, root_0);


                    }
                    break;
                case 2 :
                    // pascal3g.g:554:14: MINUS ^
                    {
                    MINUS253=(Token)match(input,MINUS,FOLLOW_MINUS_in_signedFactor4635); 
                    MINUS253_tree = 
                    (Object)adaptor.create(MINUS253)
                    ;
                    root_0 = (Object)adaptor.becomeRoot(MINUS253_tree, root_0);


                    }
                    break;

            }


            pushFollow(FOLLOW_factor_in_signedFactor4640);
            factor254=factor();

            state._fsp--;

            adaptor.addChild(root_0, factor254.getTree());

            }

            retval.stop = input.LT(-1);


            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "signedFactor"


    public static class factor_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "factor"
    // pascal3g.g:557:1: factor : ( variable | LPAREN ! expression RPAREN !| functionDesignator | unsignedConstant | set | NOT ^ factor );
    public final factor_return factor() throws RecognitionException {
        factor_return retval = new factor_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token LPAREN256=null;
        Token RPAREN258=null;
        Token NOT262=null;
        variable_return variable255 =null;

        expression_return expression257 =null;

        functionDesignator_return functionDesignator259 =null;

        unsignedConstant_return unsignedConstant260 =null;

        set_return set261 =null;

        factor_return factor263 =null;


        Object LPAREN256_tree=null;
        Object RPAREN258_tree=null;
        Object NOT262_tree=null;

        try {
            // pascal3g.g:558:5: ( variable | LPAREN ! expression RPAREN !| functionDesignator | unsignedConstant | set | NOT ^ factor )
            int alt54=6;
            switch ( input.LA(1) ) {
            case AT:
                {
                alt54=1;
                }
                break;
            case IDENT:
                {
                int LA54_2 = input.LA(2);

                if ( (LA54_2==AND||(LA54_2 >= COLON && LA54_2 <= COMMA)||(LA54_2 >= DIV && LA54_2 <= DOWNTO)||(LA54_2 >= ELSE && LA54_2 <= EQUAL)||LA54_2==GE||LA54_2==GT||LA54_2==IN||(LA54_2 >= LBRACK && LA54_2 <= LBRACK2)||LA54_2==LE||(LA54_2 >= LT && LA54_2 <= MOD)||LA54_2==NOT_EQUAL||(LA54_2 >= OF && LA54_2 <= OR)||(LA54_2 >= PLUS && LA54_2 <= POINTER)||(LA54_2 >= RBRACK && LA54_2 <= RBRACK2)||LA54_2==RPAREN||LA54_2==SEMI||(LA54_2 >= SLASH && LA54_2 <= STAR)||(LA54_2 >= THEN && LA54_2 <= TO)||LA54_2==UNTIL) ) {
                    alt54=1;
                }
                else if ( (LA54_2==LPAREN) ) {
                    alt54=3;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 54, 2, input);

                    throw nvae;

                }
                }
                break;
            case LPAREN:
                {
                alt54=2;
                }
                break;
            case CHR:
            case NIL:
            case NUM_INT:
            case NUM_REAL:
            case STRING_LITERAL:
                {
                alt54=4;
                }
                break;
            case LBRACK:
            case LBRACK2:
                {
                alt54=5;
                }
                break;
            case NOT:
                {
                alt54=6;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 54, 0, input);

                throw nvae;

            }

            switch (alt54) {
                case 1 :
                    // pascal3g.g:558:7: variable
                    {
                    root_0 = (Object)adaptor.nil();


                    pushFollow(FOLLOW_variable_in_factor4657);
                    variable255=variable();

                    state._fsp--;

                    adaptor.addChild(root_0, variable255.getTree());

                    }
                    break;
                case 2 :
                    // pascal3g.g:559:7: LPAREN ! expression RPAREN !
                    {
                    root_0 = (Object)adaptor.nil();


                    LPAREN256=(Token)match(input,LPAREN,FOLLOW_LPAREN_in_factor4665); 

                    pushFollow(FOLLOW_expression_in_factor4668);
                    expression257=expression();

                    state._fsp--;

                    adaptor.addChild(root_0, expression257.getTree());

                    RPAREN258=(Token)match(input,RPAREN,FOLLOW_RPAREN_in_factor4670); 

                    }
                    break;
                case 3 :
                    // pascal3g.g:560:7: functionDesignator
                    {
                    root_0 = (Object)adaptor.nil();


                    pushFollow(FOLLOW_functionDesignator_in_factor4679);
                    functionDesignator259=functionDesignator();

                    state._fsp--;

                    adaptor.addChild(root_0, functionDesignator259.getTree());

                    }
                    break;
                case 4 :
                    // pascal3g.g:561:7: unsignedConstant
                    {
                    root_0 = (Object)adaptor.nil();


                    pushFollow(FOLLOW_unsignedConstant_in_factor4687);
                    unsignedConstant260=unsignedConstant();

                    state._fsp--;

                    adaptor.addChild(root_0, unsignedConstant260.getTree());

                    }
                    break;
                case 5 :
                    // pascal3g.g:562:7: set
                    {
                    root_0 = (Object)adaptor.nil();


                    pushFollow(FOLLOW_set_in_factor4695);
                    set261=set();

                    state._fsp--;

                    adaptor.addChild(root_0, set261.getTree());

                    }
                    break;
                case 6 :
                    // pascal3g.g:563:7: NOT ^ factor
                    {
                    root_0 = (Object)adaptor.nil();


                    NOT262=(Token)match(input,NOT,FOLLOW_NOT_in_factor4703); 
                    NOT262_tree = 
                    (Object)adaptor.create(NOT262)
                    ;
                    root_0 = (Object)adaptor.becomeRoot(NOT262_tree, root_0);


                    pushFollow(FOLLOW_factor_in_factor4706);
                    factor263=factor();

                    state._fsp--;

                    adaptor.addChild(root_0, factor263.getTree());

                    }
                    break;

            }
            retval.stop = input.LT(-1);


            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "factor"


    public static class unsignedConstant_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "unsignedConstant"
    // pascal3g.g:566:1: unsignedConstant : ( unsignedNumber | constantChr | string | NIL );
    public final unsignedConstant_return unsignedConstant() throws RecognitionException {
        unsignedConstant_return retval = new unsignedConstant_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token NIL267=null;
        unsignedNumber_return unsignedNumber264 =null;

        constantChr_return constantChr265 =null;

        string_return string266 =null;


        Object NIL267_tree=null;

        try {
            // pascal3g.g:567:5: ( unsignedNumber | constantChr | string | NIL )
            int alt55=4;
            switch ( input.LA(1) ) {
            case NUM_INT:
            case NUM_REAL:
                {
                alt55=1;
                }
                break;
            case CHR:
                {
                alt55=2;
                }
                break;
            case STRING_LITERAL:
                {
                alt55=3;
                }
                break;
            case NIL:
                {
                alt55=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 55, 0, input);

                throw nvae;

            }

            switch (alt55) {
                case 1 :
                    // pascal3g.g:567:7: unsignedNumber
                    {
                    root_0 = (Object)adaptor.nil();


                    pushFollow(FOLLOW_unsignedNumber_in_unsignedConstant4723);
                    unsignedNumber264=unsignedNumber();

                    state._fsp--;

                    adaptor.addChild(root_0, unsignedNumber264.getTree());

                    }
                    break;
                case 2 :
                    // pascal3g.g:568:7: constantChr
                    {
                    root_0 = (Object)adaptor.nil();


                    pushFollow(FOLLOW_constantChr_in_unsignedConstant4731);
                    constantChr265=constantChr();

                    state._fsp--;

                    adaptor.addChild(root_0, constantChr265.getTree());

                    }
                    break;
                case 3 :
                    // pascal3g.g:569:7: string
                    {
                    root_0 = (Object)adaptor.nil();


                    pushFollow(FOLLOW_string_in_unsignedConstant4748);
                    string266=string();

                    state._fsp--;

                    adaptor.addChild(root_0, string266.getTree());

                    }
                    break;
                case 4 :
                    // pascal3g.g:570:7: NIL
                    {
                    root_0 = (Object)adaptor.nil();


                    NIL267=(Token)match(input,NIL,FOLLOW_NIL_in_unsignedConstant4756); 
                    NIL267_tree = 
                    (Object)adaptor.create(NIL267)
                    ;
                    adaptor.addChild(root_0, NIL267_tree);


                    }
                    break;

            }
            retval.stop = input.LT(-1);


            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "unsignedConstant"


    public static class functionDesignator_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "functionDesignator"
    // pascal3g.g:573:1: functionDesignator : id= identifier LPAREN args= parameterList RPAREN -> ^( FUNC_CALL $id $args) ;
    public final functionDesignator_return functionDesignator() throws RecognitionException {
        functionDesignator_return retval = new functionDesignator_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token LPAREN268=null;
        Token RPAREN269=null;
        identifier_return id =null;

        parameterList_return args =null;


        Object LPAREN268_tree=null;
        Object RPAREN269_tree=null;
        RewriteRuleTokenStream stream_RPAREN=new RewriteRuleTokenStream(adaptor,"token RPAREN");
        RewriteRuleTokenStream stream_LPAREN=new RewriteRuleTokenStream(adaptor,"token LPAREN");
        RewriteRuleSubtreeStream stream_parameterList=new RewriteRuleSubtreeStream(adaptor,"rule parameterList");
        RewriteRuleSubtreeStream stream_identifier=new RewriteRuleSubtreeStream(adaptor,"rule identifier");
        try {
            // pascal3g.g:574:5: (id= identifier LPAREN args= parameterList RPAREN -> ^( FUNC_CALL $id $args) )
            // pascal3g.g:574:7: id= identifier LPAREN args= parameterList RPAREN
            {
            pushFollow(FOLLOW_identifier_in_functionDesignator4775);
            id=identifier();

            state._fsp--;

            stream_identifier.add(id.getTree());

            LPAREN268=(Token)match(input,LPAREN,FOLLOW_LPAREN_in_functionDesignator4777);  
            stream_LPAREN.add(LPAREN268);


            pushFollow(FOLLOW_parameterList_in_functionDesignator4781);
            args=parameterList();

            state._fsp--;

            stream_parameterList.add(args.getTree());

            RPAREN269=(Token)match(input,RPAREN,FOLLOW_RPAREN_in_functionDesignator4783);  
            stream_RPAREN.add(RPAREN269);


            // AST REWRITE
            // elements: id, args
            // token labels: 
            // rule labels: id, retval, args
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_id=new RewriteRuleSubtreeStream(adaptor,"rule id",id!=null?id.tree:null);
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);
            RewriteRuleSubtreeStream stream_args=new RewriteRuleSubtreeStream(adaptor,"rule args",args!=null?args.tree:null);

            root_0 = (Object)adaptor.nil();
            // 575:5: -> ^( FUNC_CALL $id $args)
            {
                // pascal3g.g:575:8: ^( FUNC_CALL $id $args)
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot(
                (Object)adaptor.create(FUNC_CALL, "FUNC_CALL")
                , root_1);

                adaptor.addChild(root_1, stream_id.nextTree());

                adaptor.addChild(root_1, stream_args.nextTree());

                adaptor.addChild(root_0, root_1);
                }

            }


            retval.tree = root_0;

            }

            retval.stop = input.LT(-1);


            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "functionDesignator"


    public static class parameterList_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "parameterList"
    // pascal3g.g:578:1: parameterList : actualParameter ( COMMA actualParameter )* -> ^( ARGLIST ( actualParameter )+ ) ;
    public final parameterList_return parameterList() throws RecognitionException {
        parameterList_return retval = new parameterList_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token COMMA271=null;
        actualParameter_return actualParameter270 =null;

        actualParameter_return actualParameter272 =null;


        Object COMMA271_tree=null;
        RewriteRuleTokenStream stream_COMMA=new RewriteRuleTokenStream(adaptor,"token COMMA");
        RewriteRuleSubtreeStream stream_actualParameter=new RewriteRuleSubtreeStream(adaptor,"rule actualParameter");
        try {
            // pascal3g.g:579:5: ( actualParameter ( COMMA actualParameter )* -> ^( ARGLIST ( actualParameter )+ ) )
            // pascal3g.g:579:7: actualParameter ( COMMA actualParameter )*
            {
            pushFollow(FOLLOW_actualParameter_in_parameterList4817);
            actualParameter270=actualParameter();

            state._fsp--;

            stream_actualParameter.add(actualParameter270.getTree());

            // pascal3g.g:579:23: ( COMMA actualParameter )*
            loop56:
            do {
                int alt56=2;
                int LA56_0 = input.LA(1);

                if ( (LA56_0==COMMA) ) {
                    alt56=1;
                }


                switch (alt56) {
            	case 1 :
            	    // pascal3g.g:579:25: COMMA actualParameter
            	    {
            	    COMMA271=(Token)match(input,COMMA,FOLLOW_COMMA_in_parameterList4821);  
            	    stream_COMMA.add(COMMA271);


            	    pushFollow(FOLLOW_actualParameter_in_parameterList4823);
            	    actualParameter272=actualParameter();

            	    state._fsp--;

            	    stream_actualParameter.add(actualParameter272.getTree());

            	    }
            	    break;

            	default :
            	    break loop56;
                }
            } while (true);


            // AST REWRITE
            // elements: actualParameter
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 580:5: -> ^( ARGLIST ( actualParameter )+ )
            {
                // pascal3g.g:580:8: ^( ARGLIST ( actualParameter )+ )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot(
                (Object)adaptor.create(ARGLIST, "ARGLIST")
                , root_1);

                if ( !(stream_actualParameter.hasNext()) ) {
                    throw new RewriteEarlyExitException();
                }
                while ( stream_actualParameter.hasNext() ) {
                    adaptor.addChild(root_1, stream_actualParameter.nextTree());

                }
                stream_actualParameter.reset();

                adaptor.addChild(root_0, root_1);
                }

            }


            retval.tree = root_0;

            }

            retval.stop = input.LT(-1);


            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "parameterList"


    public static class set_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "set"
    // pascal3g.g:583:1: set : ( LBRACK elementList RBRACK -> ^( SET ( elementList )? ) | LBRACK2 elementList RBRACK2 -> ^( SET ( elementList )? ) );
    public final set_return set() throws RecognitionException {
        set_return retval = new set_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token LBRACK273=null;
        Token RBRACK275=null;
        Token LBRACK2276=null;
        Token RBRACK2278=null;
        elementList_return elementList274 =null;

        elementList_return elementList277 =null;


        Object LBRACK273_tree=null;
        Object RBRACK275_tree=null;
        Object LBRACK2276_tree=null;
        Object RBRACK2278_tree=null;
        RewriteRuleTokenStream stream_RBRACK=new RewriteRuleTokenStream(adaptor,"token RBRACK");
        RewriteRuleTokenStream stream_LBRACK=new RewriteRuleTokenStream(adaptor,"token LBRACK");
        RewriteRuleTokenStream stream_RBRACK2=new RewriteRuleTokenStream(adaptor,"token RBRACK2");
        RewriteRuleTokenStream stream_LBRACK2=new RewriteRuleTokenStream(adaptor,"token LBRACK2");
        RewriteRuleSubtreeStream stream_elementList=new RewriteRuleSubtreeStream(adaptor,"rule elementList");
        try {
            // pascal3g.g:584:5: ( LBRACK elementList RBRACK -> ^( SET ( elementList )? ) | LBRACK2 elementList RBRACK2 -> ^( SET ( elementList )? ) )
            int alt57=2;
            int LA57_0 = input.LA(1);

            if ( (LA57_0==LBRACK) ) {
                alt57=1;
            }
            else if ( (LA57_0==LBRACK2) ) {
                alt57=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 57, 0, input);

                throw nvae;

            }
            switch (alt57) {
                case 1 :
                    // pascal3g.g:584:7: LBRACK elementList RBRACK
                    {
                    LBRACK273=(Token)match(input,LBRACK,FOLLOW_LBRACK_in_set4856);  
                    stream_LBRACK.add(LBRACK273);


                    pushFollow(FOLLOW_elementList_in_set4858);
                    elementList274=elementList();

                    state._fsp--;

                    stream_elementList.add(elementList274.getTree());

                    RBRACK275=(Token)match(input,RBRACK,FOLLOW_RBRACK_in_set4860);  
                    stream_RBRACK.add(RBRACK275);


                    // AST REWRITE
                    // elements: elementList
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 584:34: -> ^( SET ( elementList )? )
                    {
                        // pascal3g.g:584:37: ^( SET ( elementList )? )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot(
                        (Object)adaptor.create(SET, "SET")
                        , root_1);

                        // pascal3g.g:584:43: ( elementList )?
                        if ( stream_elementList.hasNext() ) {
                            adaptor.addChild(root_1, stream_elementList.nextTree());

                        }
                        stream_elementList.reset();

                        adaptor.addChild(root_0, root_1);
                        }

                    }


                    retval.tree = root_0;

                    }
                    break;
                case 2 :
                    // pascal3g.g:585:7: LBRACK2 elementList RBRACK2
                    {
                    LBRACK2276=(Token)match(input,LBRACK2,FOLLOW_LBRACK2_in_set4879);  
                    stream_LBRACK2.add(LBRACK2276);


                    pushFollow(FOLLOW_elementList_in_set4881);
                    elementList277=elementList();

                    state._fsp--;

                    stream_elementList.add(elementList277.getTree());

                    RBRACK2278=(Token)match(input,RBRACK2,FOLLOW_RBRACK2_in_set4883);  
                    stream_RBRACK2.add(RBRACK2278);


                    // AST REWRITE
                    // elements: elementList
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 585:35: -> ^( SET ( elementList )? )
                    {
                        // pascal3g.g:585:38: ^( SET ( elementList )? )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot(
                        (Object)adaptor.create(SET, "SET")
                        , root_1);

                        // pascal3g.g:585:44: ( elementList )?
                        if ( stream_elementList.hasNext() ) {
                            adaptor.addChild(root_1, stream_elementList.nextTree());

                        }
                        stream_elementList.reset();

                        adaptor.addChild(root_0, root_1);
                        }

                    }


                    retval.tree = root_0;

                    }
                    break;

            }
            retval.stop = input.LT(-1);


            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "set"


    public static class elementList_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "elementList"
    // pascal3g.g:588:1: elementList : ( element ( COMMA ! element )* |);
    public final elementList_return elementList() throws RecognitionException {
        elementList_return retval = new elementList_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token COMMA280=null;
        element_return element279 =null;

        element_return element281 =null;


        Object COMMA280_tree=null;

        try {
            // pascal3g.g:589:5: ( element ( COMMA ! element )* |)
            int alt59=2;
            int LA59_0 = input.LA(1);

            if ( (LA59_0==AT||LA59_0==CHR||LA59_0==IDENT||(LA59_0 >= LBRACK && LA59_0 <= LBRACK2)||LA59_0==LPAREN||LA59_0==MINUS||(LA59_0 >= NIL && LA59_0 <= NOT)||(LA59_0 >= NUM_INT && LA59_0 <= NUM_REAL)||LA59_0==PLUS||LA59_0==STRING_LITERAL) ) {
                alt59=1;
            }
            else if ( ((LA59_0 >= RBRACK && LA59_0 <= RBRACK2)) ) {
                alt59=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 59, 0, input);

                throw nvae;

            }
            switch (alt59) {
                case 1 :
                    // pascal3g.g:589:7: element ( COMMA ! element )*
                    {
                    root_0 = (Object)adaptor.nil();


                    pushFollow(FOLLOW_element_in_elementList4909);
                    element279=element();

                    state._fsp--;

                    adaptor.addChild(root_0, element279.getTree());

                    // pascal3g.g:589:15: ( COMMA ! element )*
                    loop58:
                    do {
                        int alt58=2;
                        int LA58_0 = input.LA(1);

                        if ( (LA58_0==COMMA) ) {
                            alt58=1;
                        }


                        switch (alt58) {
                    	case 1 :
                    	    // pascal3g.g:589:17: COMMA ! element
                    	    {
                    	    COMMA280=(Token)match(input,COMMA,FOLLOW_COMMA_in_elementList4913); 

                    	    pushFollow(FOLLOW_element_in_elementList4916);
                    	    element281=element();

                    	    state._fsp--;

                    	    adaptor.addChild(root_0, element281.getTree());

                    	    }
                    	    break;

                    	default :
                    	    break loop58;
                        }
                    } while (true);


                    }
                    break;
                case 2 :
                    // pascal3g.g:591:5: 
                    {
                    root_0 = (Object)adaptor.nil();


                    }
                    break;

            }
            retval.stop = input.LT(-1);


            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "elementList"


    public static class element_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "element"
    // pascal3g.g:593:1: element : expression ( DOTDOT ^ expression )? ;
    public final element_return element() throws RecognitionException {
        element_return retval = new element_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token DOTDOT283=null;
        expression_return expression282 =null;

        expression_return expression284 =null;


        Object DOTDOT283_tree=null;

        try {
            // pascal3g.g:594:5: ( expression ( DOTDOT ^ expression )? )
            // pascal3g.g:594:7: expression ( DOTDOT ^ expression )?
            {
            root_0 = (Object)adaptor.nil();


            pushFollow(FOLLOW_expression_in_element4942);
            expression282=expression();

            state._fsp--;

            adaptor.addChild(root_0, expression282.getTree());

            // pascal3g.g:594:18: ( DOTDOT ^ expression )?
            int alt60=2;
            int LA60_0 = input.LA(1);

            if ( (LA60_0==DOTDOT) ) {
                alt60=1;
            }
            switch (alt60) {
                case 1 :
                    // pascal3g.g:594:20: DOTDOT ^ expression
                    {
                    DOTDOT283=(Token)match(input,DOTDOT,FOLLOW_DOTDOT_in_element4946); 
                    DOTDOT283_tree = 
                    (Object)adaptor.create(DOTDOT283)
                    ;
                    root_0 = (Object)adaptor.becomeRoot(DOTDOT283_tree, root_0);


                    pushFollow(FOLLOW_expression_in_element4949);
                    expression284=expression();

                    state._fsp--;

                    adaptor.addChild(root_0, expression284.getTree());

                    }
                    break;

            }


            }

            retval.stop = input.LT(-1);


            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "element"


    public static class procedureStatement_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "procedureStatement"
    // pascal3g.g:597:1: procedureStatement : id= identifier ( LPAREN args= parameterList RPAREN )? -> ^( PROC_CALL identifier ( parameterList )? ) ;
    public final procedureStatement_return procedureStatement() throws RecognitionException {
        procedureStatement_return retval = new procedureStatement_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token LPAREN285=null;
        Token RPAREN286=null;
        identifier_return id =null;

        parameterList_return args =null;


        Object LPAREN285_tree=null;
        Object RPAREN286_tree=null;
        RewriteRuleTokenStream stream_RPAREN=new RewriteRuleTokenStream(adaptor,"token RPAREN");
        RewriteRuleTokenStream stream_LPAREN=new RewriteRuleTokenStream(adaptor,"token LPAREN");
        RewriteRuleSubtreeStream stream_parameterList=new RewriteRuleSubtreeStream(adaptor,"rule parameterList");
        RewriteRuleSubtreeStream stream_identifier=new RewriteRuleSubtreeStream(adaptor,"rule identifier");
        try {
            // pascal3g.g:598:5: (id= identifier ( LPAREN args= parameterList RPAREN )? -> ^( PROC_CALL identifier ( parameterList )? ) )
            // pascal3g.g:598:7: id= identifier ( LPAREN args= parameterList RPAREN )?
            {
            pushFollow(FOLLOW_identifier_in_procedureStatement4971);
            id=identifier();

            state._fsp--;

            stream_identifier.add(id.getTree());

            // pascal3g.g:598:21: ( LPAREN args= parameterList RPAREN )?
            int alt61=2;
            int LA61_0 = input.LA(1);

            if ( (LA61_0==LPAREN) ) {
                alt61=1;
            }
            switch (alt61) {
                case 1 :
                    // pascal3g.g:598:23: LPAREN args= parameterList RPAREN
                    {
                    LPAREN285=(Token)match(input,LPAREN,FOLLOW_LPAREN_in_procedureStatement4975);  
                    stream_LPAREN.add(LPAREN285);


                    pushFollow(FOLLOW_parameterList_in_procedureStatement4979);
                    args=parameterList();

                    state._fsp--;

                    stream_parameterList.add(args.getTree());

                    RPAREN286=(Token)match(input,RPAREN,FOLLOW_RPAREN_in_procedureStatement4981);  
                    stream_RPAREN.add(RPAREN286);


                    }
                    break;

            }


            // AST REWRITE
            // elements: identifier, parameterList
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 599:5: -> ^( PROC_CALL identifier ( parameterList )? )
            {
                // pascal3g.g:599:8: ^( PROC_CALL identifier ( parameterList )? )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot(
                (Object)adaptor.create(PROC_CALL, "PROC_CALL")
                , root_1);

                adaptor.addChild(root_1, stream_identifier.nextTree());

                // pascal3g.g:599:31: ( parameterList )?
                if ( stream_parameterList.hasNext() ) {
                    adaptor.addChild(root_1, stream_parameterList.nextTree());

                }
                stream_parameterList.reset();

                adaptor.addChild(root_0, root_1);
                }

            }


            retval.tree = root_0;

            }

            retval.stop = input.LT(-1);


            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "procedureStatement"


    public static class actualParameter_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "actualParameter"
    // pascal3g.g:602:1: actualParameter : expression ( COLON unsignedInteger )? ;
    public final actualParameter_return actualParameter() throws RecognitionException {
        actualParameter_return retval = new actualParameter_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token COLON288=null;
        expression_return expression287 =null;

        unsignedInteger_return unsignedInteger289 =null;


        Object COLON288_tree=null;

        try {
            // pascal3g.g:604:5: ( expression ( COLON unsignedInteger )? )
            // pascal3g.g:604:7: expression ( COLON unsignedInteger )?
            {
            root_0 = (Object)adaptor.nil();


            pushFollow(FOLLOW_expression_in_actualParameter5021);
            expression287=expression();

            state._fsp--;

            adaptor.addChild(root_0, expression287.getTree());

            // pascal3g.g:604:18: ( COLON unsignedInteger )?
            int alt62=2;
            int LA62_0 = input.LA(1);

            if ( (LA62_0==COLON) ) {
                alt62=1;
            }
            switch (alt62) {
                case 1 :
                    // pascal3g.g:604:19: COLON unsignedInteger
                    {
                    COLON288=(Token)match(input,COLON,FOLLOW_COLON_in_actualParameter5024); 
                    COLON288_tree = 
                    (Object)adaptor.create(COLON288)
                    ;
                    adaptor.addChild(root_0, COLON288_tree);


                    pushFollow(FOLLOW_unsignedInteger_in_actualParameter5026);
                    unsignedInteger289=unsignedInteger();

                    state._fsp--;

                    adaptor.addChild(root_0, unsignedInteger289.getTree());

                    }
                    break;

            }


            }

            retval.stop = input.LT(-1);


            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "actualParameter"


    public static class gotoStatement_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "gotoStatement"
    // pascal3g.g:607:1: gotoStatement : GOTO ^ label ;
    public final gotoStatement_return gotoStatement() throws RecognitionException {
        gotoStatement_return retval = new gotoStatement_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token GOTO290=null;
        label_return label291 =null;


        Object GOTO290_tree=null;

        try {
            // pascal3g.g:608:5: ( GOTO ^ label )
            // pascal3g.g:608:7: GOTO ^ label
            {
            root_0 = (Object)adaptor.nil();


            GOTO290=(Token)match(input,GOTO,FOLLOW_GOTO_in_gotoStatement5045); 
            GOTO290_tree = 
            (Object)adaptor.create(GOTO290)
            ;
            root_0 = (Object)adaptor.becomeRoot(GOTO290_tree, root_0);


            pushFollow(FOLLOW_label_in_gotoStatement5048);
            label291=label();

            state._fsp--;

            adaptor.addChild(root_0, label291.getTree());

            }

            retval.stop = input.LT(-1);


            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "gotoStatement"


    public static class emptyStatement_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "emptyStatement"
    // pascal3g.g:611:1: emptyStatement :;
    public final emptyStatement_return emptyStatement() throws RecognitionException {
        emptyStatement_return retval = new emptyStatement_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        try {
            // pascal3g.g:612:5: ()
            // pascal3g.g:613:5: 
            {
            root_0 = (Object)adaptor.nil();


            }

            retval.stop = input.LT(-1);


            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "emptyStatement"


    public static class empty_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "empty"
    // pascal3g.g:615:1: empty :;
    public final empty_return empty() throws RecognitionException {
        empty_return retval = new empty_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        try {
            // pascal3g.g:616:5: ()
            // pascal3g.g:617:5: 
            {
            root_0 = (Object)adaptor.nil();


            }

            retval.stop = input.LT(-1);


            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "empty"


    public static class structuredStatement_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "structuredStatement"
    // pascal3g.g:619:1: structuredStatement : ( compoundStatement | conditionalStatement | repetetiveStatement | withStatement );
    public final structuredStatement_return structuredStatement() throws RecognitionException {
        structuredStatement_return retval = new structuredStatement_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        compoundStatement_return compoundStatement292 =null;

        conditionalStatement_return conditionalStatement293 =null;

        repetetiveStatement_return repetetiveStatement294 =null;

        withStatement_return withStatement295 =null;



        try {
            // pascal3g.g:620:5: ( compoundStatement | conditionalStatement | repetetiveStatement | withStatement )
            int alt63=4;
            switch ( input.LA(1) ) {
            case BEGIN:
                {
                alt63=1;
                }
                break;
            case CASE:
            case IF:
                {
                alt63=2;
                }
                break;
            case FOR:
            case REPEAT:
            case WHILE:
                {
                alt63=3;
                }
                break;
            case WITH:
                {
                alt63=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 63, 0, input);

                throw nvae;

            }

            switch (alt63) {
                case 1 :
                    // pascal3g.g:620:7: compoundStatement
                    {
                    root_0 = (Object)adaptor.nil();


                    pushFollow(FOLLOW_compoundStatement_in_structuredStatement5096);
                    compoundStatement292=compoundStatement();

                    state._fsp--;

                    adaptor.addChild(root_0, compoundStatement292.getTree());

                    }
                    break;
                case 2 :
                    // pascal3g.g:621:7: conditionalStatement
                    {
                    root_0 = (Object)adaptor.nil();


                    pushFollow(FOLLOW_conditionalStatement_in_structuredStatement5104);
                    conditionalStatement293=conditionalStatement();

                    state._fsp--;

                    adaptor.addChild(root_0, conditionalStatement293.getTree());

                    }
                    break;
                case 3 :
                    // pascal3g.g:622:7: repetetiveStatement
                    {
                    root_0 = (Object)adaptor.nil();


                    pushFollow(FOLLOW_repetetiveStatement_in_structuredStatement5112);
                    repetetiveStatement294=repetetiveStatement();

                    state._fsp--;

                    adaptor.addChild(root_0, repetetiveStatement294.getTree());

                    }
                    break;
                case 4 :
                    // pascal3g.g:623:7: withStatement
                    {
                    root_0 = (Object)adaptor.nil();


                    pushFollow(FOLLOW_withStatement_in_structuredStatement5120);
                    withStatement295=withStatement();

                    state._fsp--;

                    adaptor.addChild(root_0, withStatement295.getTree());

                    }
                    break;

            }
            retval.stop = input.LT(-1);


            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "structuredStatement"


    public static class compoundStatement_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "compoundStatement"
    // pascal3g.g:626:1: compoundStatement : BEGIN statements END -> ^( BLOCK ( statements )* ) ;
    public final compoundStatement_return compoundStatement() throws RecognitionException {
        compoundStatement_return retval = new compoundStatement_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token BEGIN296=null;
        Token END298=null;
        statements_return statements297 =null;


        Object BEGIN296_tree=null;
        Object END298_tree=null;
        RewriteRuleTokenStream stream_END=new RewriteRuleTokenStream(adaptor,"token END");
        RewriteRuleTokenStream stream_BEGIN=new RewriteRuleTokenStream(adaptor,"token BEGIN");
        RewriteRuleSubtreeStream stream_statements=new RewriteRuleSubtreeStream(adaptor,"rule statements");
        try {
            // pascal3g.g:627:5: ( BEGIN statements END -> ^( BLOCK ( statements )* ) )
            // pascal3g.g:627:7: BEGIN statements END
            {
            BEGIN296=(Token)match(input,BEGIN,FOLLOW_BEGIN_in_compoundStatement5137);  
            stream_BEGIN.add(BEGIN296);


            pushFollow(FOLLOW_statements_in_compoundStatement5143);
            statements297=statements();

            state._fsp--;

            stream_statements.add(statements297.getTree());

            END298=(Token)match(input,END,FOLLOW_END_in_compoundStatement5151);  
            stream_END.add(END298);


            // AST REWRITE
            // elements: statements
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 630:9: -> ^( BLOCK ( statements )* )
            {
                // pascal3g.g:630:12: ^( BLOCK ( statements )* )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot(
                (Object)adaptor.create(BLOCK, "BLOCK")
                , root_1);

                // pascal3g.g:630:20: ( statements )*
                while ( stream_statements.hasNext() ) {
                    adaptor.addChild(root_1, stream_statements.nextTree());

                }
                stream_statements.reset();

                adaptor.addChild(root_0, root_1);
                }

            }


            retval.tree = root_0;

            }

            retval.stop = input.LT(-1);


            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "compoundStatement"


    public static class statements_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "statements"
    // pascal3g.g:633:1: statements : statement ( SEMI ! statement )* ;
    public final statements_return statements() throws RecognitionException {
        statements_return retval = new statements_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token SEMI300=null;
        statement_return statement299 =null;

        statement_return statement301 =null;


        Object SEMI300_tree=null;

        try {
            // pascal3g.g:634:5: ( statement ( SEMI ! statement )* )
            // pascal3g.g:634:7: statement ( SEMI ! statement )*
            {
            root_0 = (Object)adaptor.nil();


            pushFollow(FOLLOW_statement_in_statements5186);
            statement299=statement();

            state._fsp--;

            adaptor.addChild(root_0, statement299.getTree());

            // pascal3g.g:634:17: ( SEMI ! statement )*
            loop64:
            do {
                int alt64=2;
                int LA64_0 = input.LA(1);

                if ( (LA64_0==SEMI) ) {
                    alt64=1;
                }


                switch (alt64) {
            	case 1 :
            	    // pascal3g.g:634:19: SEMI ! statement
            	    {
            	    SEMI300=(Token)match(input,SEMI,FOLLOW_SEMI_in_statements5190); 

            	    pushFollow(FOLLOW_statement_in_statements5193);
            	    statement301=statement();

            	    state._fsp--;

            	    adaptor.addChild(root_0, statement301.getTree());

            	    }
            	    break;

            	default :
            	    break loop64;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);


            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "statements"


    public static class conditionalStatement_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "conditionalStatement"
    // pascal3g.g:637:1: conditionalStatement : ( ifStatement | caseStatement );
    public final conditionalStatement_return conditionalStatement() throws RecognitionException {
        conditionalStatement_return retval = new conditionalStatement_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        ifStatement_return ifStatement302 =null;

        caseStatement_return caseStatement303 =null;



        try {
            // pascal3g.g:638:5: ( ifStatement | caseStatement )
            int alt65=2;
            int LA65_0 = input.LA(1);

            if ( (LA65_0==IF) ) {
                alt65=1;
            }
            else if ( (LA65_0==CASE) ) {
                alt65=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 65, 0, input);

                throw nvae;

            }
            switch (alt65) {
                case 1 :
                    // pascal3g.g:638:7: ifStatement
                    {
                    root_0 = (Object)adaptor.nil();


                    pushFollow(FOLLOW_ifStatement_in_conditionalStatement5214);
                    ifStatement302=ifStatement();

                    state._fsp--;

                    adaptor.addChild(root_0, ifStatement302.getTree());

                    }
                    break;
                case 2 :
                    // pascal3g.g:639:7: caseStatement
                    {
                    root_0 = (Object)adaptor.nil();


                    pushFollow(FOLLOW_caseStatement_in_conditionalStatement5222);
                    caseStatement303=caseStatement();

                    state._fsp--;

                    adaptor.addChild(root_0, caseStatement303.getTree());

                    }
                    break;

            }
            retval.stop = input.LT(-1);


            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "conditionalStatement"


    public static class ifStatement_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "ifStatement"
    // pascal3g.g:642:1: ifStatement : IF ^ expression THEN ! statement ( ELSE ! statement )? ;
    public final ifStatement_return ifStatement() throws RecognitionException {
        ifStatement_return retval = new ifStatement_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token IF304=null;
        Token THEN306=null;
        Token ELSE308=null;
        expression_return expression305 =null;

        statement_return statement307 =null;

        statement_return statement309 =null;


        Object IF304_tree=null;
        Object THEN306_tree=null;
        Object ELSE308_tree=null;

        try {
            // pascal3g.g:643:5: ( IF ^ expression THEN ! statement ( ELSE ! statement )? )
            // pascal3g.g:643:7: IF ^ expression THEN ! statement ( ELSE ! statement )?
            {
            root_0 = (Object)adaptor.nil();


            IF304=(Token)match(input,IF,FOLLOW_IF_in_ifStatement5239); 
            IF304_tree = 
            (Object)adaptor.create(IF304)
            ;
            root_0 = (Object)adaptor.becomeRoot(IF304_tree, root_0);


            pushFollow(FOLLOW_expression_in_ifStatement5242);
            expression305=expression();

            state._fsp--;

            adaptor.addChild(root_0, expression305.getTree());

            THEN306=(Token)match(input,THEN,FOLLOW_THEN_in_ifStatement5244); 

            pushFollow(FOLLOW_statement_in_ifStatement5247);
            statement307=statement();

            state._fsp--;

            adaptor.addChild(root_0, statement307.getTree());

            // pascal3g.g:644:7: ( ELSE ! statement )?
            int alt66=2;
            int LA66_0 = input.LA(1);

            if ( (LA66_0==ELSE) ) {
                alt66=1;
            }
            switch (alt66) {
                case 1 :
                    // pascal3g.g:648:6: ELSE ! statement
                    {
                    ELSE308=(Token)match(input,ELSE,FOLLOW_ELSE_in_ifStatement5277); 

                    pushFollow(FOLLOW_statement_in_ifStatement5280);
                    statement309=statement();

                    state._fsp--;

                    adaptor.addChild(root_0, statement309.getTree());

                    }
                    break;

            }


            }

            retval.stop = input.LT(-1);


            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "ifStatement"


    public static class caseStatement_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "caseStatement"
    // pascal3g.g:652:1: caseStatement : CASE ^ expression OF ! caseListElement ( SEMI ! caseListElement )* ( SEMI !)? ( ELSE ! statements )? END !;
    public final caseStatement_return caseStatement() throws RecognitionException {
        caseStatement_return retval = new caseStatement_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token CASE310=null;
        Token OF312=null;
        Token SEMI314=null;
        Token SEMI316=null;
        Token ELSE317=null;
        Token END319=null;
        expression_return expression311 =null;

        caseListElement_return caseListElement313 =null;

        caseListElement_return caseListElement315 =null;

        statements_return statements318 =null;


        Object CASE310_tree=null;
        Object OF312_tree=null;
        Object SEMI314_tree=null;
        Object SEMI316_tree=null;
        Object ELSE317_tree=null;
        Object END319_tree=null;

        try {
            // pascal3g.g:653:5: ( CASE ^ expression OF ! caseListElement ( SEMI ! caseListElement )* ( SEMI !)? ( ELSE ! statements )? END !)
            // pascal3g.g:653:7: CASE ^ expression OF ! caseListElement ( SEMI ! caseListElement )* ( SEMI !)? ( ELSE ! statements )? END !
            {
            root_0 = (Object)adaptor.nil();


            CASE310=(Token)match(input,CASE,FOLLOW_CASE_in_caseStatement5305); 
            CASE310_tree = 
            (Object)adaptor.create(CASE310)
            ;
            root_0 = (Object)adaptor.becomeRoot(CASE310_tree, root_0);


            pushFollow(FOLLOW_expression_in_caseStatement5308);
            expression311=expression();

            state._fsp--;

            adaptor.addChild(root_0, expression311.getTree());

            OF312=(Token)match(input,OF,FOLLOW_OF_in_caseStatement5310); 

            pushFollow(FOLLOW_caseListElement_in_caseStatement5321);
            caseListElement313=caseListElement();

            state._fsp--;

            adaptor.addChild(root_0, caseListElement313.getTree());

            // pascal3g.g:654:25: ( SEMI ! caseListElement )*
            loop67:
            do {
                int alt67=2;
                int LA67_0 = input.LA(1);

                if ( (LA67_0==SEMI) ) {
                    int LA67_1 = input.LA(2);

                    if ( (LA67_1==CHR||LA67_1==IDENT||LA67_1==MINUS||(LA67_1 >= NUM_INT && LA67_1 <= NUM_REAL)||LA67_1==PLUS||LA67_1==STRING_LITERAL) ) {
                        alt67=1;
                    }


                }


                switch (alt67) {
            	case 1 :
            	    // pascal3g.g:654:27: SEMI ! caseListElement
            	    {
            	    SEMI314=(Token)match(input,SEMI,FOLLOW_SEMI_in_caseStatement5325); 

            	    pushFollow(FOLLOW_caseListElement_in_caseStatement5328);
            	    caseListElement315=caseListElement();

            	    state._fsp--;

            	    adaptor.addChild(root_0, caseListElement315.getTree());

            	    }
            	    break;

            	default :
            	    break loop67;
                }
            } while (true);


            // pascal3g.g:654:56: ( SEMI !)?
            int alt68=2;
            int LA68_0 = input.LA(1);

            if ( (LA68_0==SEMI) ) {
                alt68=1;
            }
            switch (alt68) {
                case 1 :
                    // pascal3g.g:654:56: SEMI !
                    {
                    SEMI316=(Token)match(input,SEMI,FOLLOW_SEMI_in_caseStatement5333); 

                    }
                    break;

            }


            // pascal3g.g:655:7: ( ELSE ! statements )?
            int alt69=2;
            int LA69_0 = input.LA(1);

            if ( (LA69_0==ELSE) ) {
                alt69=1;
            }
            switch (alt69) {
                case 1 :
                    // pascal3g.g:655:9: ELSE ! statements
                    {
                    ELSE317=(Token)match(input,ELSE,FOLLOW_ELSE_in_caseStatement5345); 

                    pushFollow(FOLLOW_statements_in_caseStatement5348);
                    statements318=statements();

                    state._fsp--;

                    adaptor.addChild(root_0, statements318.getTree());

                    }
                    break;

            }


            END319=(Token)match(input,END,FOLLOW_END_in_caseStatement5359); 

            }

            retval.stop = input.LT(-1);


            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "caseStatement"


    public static class caseListElement_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "caseListElement"
    // pascal3g.g:659:1: caseListElement : constList COLON ^ statement ;
    public final caseListElement_return caseListElement() throws RecognitionException {
        caseListElement_return retval = new caseListElement_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token COLON321=null;
        constList_return constList320 =null;

        statement_return statement322 =null;


        Object COLON321_tree=null;

        try {
            // pascal3g.g:660:5: ( constList COLON ^ statement )
            // pascal3g.g:660:7: constList COLON ^ statement
            {
            root_0 = (Object)adaptor.nil();


            pushFollow(FOLLOW_constList_in_caseListElement5377);
            constList320=constList();

            state._fsp--;

            adaptor.addChild(root_0, constList320.getTree());

            COLON321=(Token)match(input,COLON,FOLLOW_COLON_in_caseListElement5379); 
            COLON321_tree = 
            (Object)adaptor.create(COLON321)
            ;
            root_0 = (Object)adaptor.becomeRoot(COLON321_tree, root_0);


            pushFollow(FOLLOW_statement_in_caseListElement5382);
            statement322=statement();

            state._fsp--;

            adaptor.addChild(root_0, statement322.getTree());

            }

            retval.stop = input.LT(-1);


            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "caseListElement"


    public static class repetetiveStatement_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "repetetiveStatement"
    // pascal3g.g:663:1: repetetiveStatement : ( whileStatement | repeatStatement | forStatement );
    public final repetetiveStatement_return repetetiveStatement() throws RecognitionException {
        repetetiveStatement_return retval = new repetetiveStatement_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        whileStatement_return whileStatement323 =null;

        repeatStatement_return repeatStatement324 =null;

        forStatement_return forStatement325 =null;



        try {
            // pascal3g.g:664:5: ( whileStatement | repeatStatement | forStatement )
            int alt70=3;
            switch ( input.LA(1) ) {
            case WHILE:
                {
                alt70=1;
                }
                break;
            case REPEAT:
                {
                alt70=2;
                }
                break;
            case FOR:
                {
                alt70=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 70, 0, input);

                throw nvae;

            }

            switch (alt70) {
                case 1 :
                    // pascal3g.g:664:7: whileStatement
                    {
                    root_0 = (Object)adaptor.nil();


                    pushFollow(FOLLOW_whileStatement_in_repetetiveStatement5399);
                    whileStatement323=whileStatement();

                    state._fsp--;

                    adaptor.addChild(root_0, whileStatement323.getTree());

                    }
                    break;
                case 2 :
                    // pascal3g.g:665:7: repeatStatement
                    {
                    root_0 = (Object)adaptor.nil();


                    pushFollow(FOLLOW_repeatStatement_in_repetetiveStatement5407);
                    repeatStatement324=repeatStatement();

                    state._fsp--;

                    adaptor.addChild(root_0, repeatStatement324.getTree());

                    }
                    break;
                case 3 :
                    // pascal3g.g:666:7: forStatement
                    {
                    root_0 = (Object)adaptor.nil();


                    pushFollow(FOLLOW_forStatement_in_repetetiveStatement5415);
                    forStatement325=forStatement();

                    state._fsp--;

                    adaptor.addChild(root_0, forStatement325.getTree());

                    }
                    break;

            }
            retval.stop = input.LT(-1);


            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "repetetiveStatement"


    public static class whileStatement_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "whileStatement"
    // pascal3g.g:669:1: whileStatement : WHILE ^ expression DO ! statement ;
    public final whileStatement_return whileStatement() throws RecognitionException {
        whileStatement_return retval = new whileStatement_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token WHILE326=null;
        Token DO328=null;
        expression_return expression327 =null;

        statement_return statement329 =null;


        Object WHILE326_tree=null;
        Object DO328_tree=null;

        try {
            // pascal3g.g:670:5: ( WHILE ^ expression DO ! statement )
            // pascal3g.g:670:7: WHILE ^ expression DO ! statement
            {
            root_0 = (Object)adaptor.nil();


            WHILE326=(Token)match(input,WHILE,FOLLOW_WHILE_in_whileStatement5432); 
            WHILE326_tree = 
            (Object)adaptor.create(WHILE326)
            ;
            root_0 = (Object)adaptor.becomeRoot(WHILE326_tree, root_0);


            pushFollow(FOLLOW_expression_in_whileStatement5435);
            expression327=expression();

            state._fsp--;

            adaptor.addChild(root_0, expression327.getTree());

            DO328=(Token)match(input,DO,FOLLOW_DO_in_whileStatement5437); 

            pushFollow(FOLLOW_statement_in_whileStatement5440);
            statement329=statement();

            state._fsp--;

            adaptor.addChild(root_0, statement329.getTree());

            }

            retval.stop = input.LT(-1);


            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "whileStatement"


    public static class repeatStatement_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "repeatStatement"
    // pascal3g.g:673:1: repeatStatement : REPEAT ^ statements UNTIL ! expression ;
    public final repeatStatement_return repeatStatement() throws RecognitionException {
        repeatStatement_return retval = new repeatStatement_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token REPEAT330=null;
        Token UNTIL332=null;
        statements_return statements331 =null;

        expression_return expression333 =null;


        Object REPEAT330_tree=null;
        Object UNTIL332_tree=null;

        try {
            // pascal3g.g:674:5: ( REPEAT ^ statements UNTIL ! expression )
            // pascal3g.g:674:7: REPEAT ^ statements UNTIL ! expression
            {
            root_0 = (Object)adaptor.nil();


            REPEAT330=(Token)match(input,REPEAT,FOLLOW_REPEAT_in_repeatStatement5457); 
            REPEAT330_tree = 
            (Object)adaptor.create(REPEAT330)
            ;
            root_0 = (Object)adaptor.becomeRoot(REPEAT330_tree, root_0);


            pushFollow(FOLLOW_statements_in_repeatStatement5460);
            statements331=statements();

            state._fsp--;

            adaptor.addChild(root_0, statements331.getTree());

            UNTIL332=(Token)match(input,UNTIL,FOLLOW_UNTIL_in_repeatStatement5462); 

            pushFollow(FOLLOW_expression_in_repeatStatement5465);
            expression333=expression();

            state._fsp--;

            adaptor.addChild(root_0, expression333.getTree());

            }

            retval.stop = input.LT(-1);


            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "repeatStatement"


    public static class forStatement_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "forStatement"
    // pascal3g.g:677:1: forStatement : FOR ^ identifier ASSIGN ! forList DO ! statement ;
    public final forStatement_return forStatement() throws RecognitionException {
        forStatement_return retval = new forStatement_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token FOR334=null;
        Token ASSIGN336=null;
        Token DO338=null;
        identifier_return identifier335 =null;

        forList_return forList337 =null;

        statement_return statement339 =null;


        Object FOR334_tree=null;
        Object ASSIGN336_tree=null;
        Object DO338_tree=null;

        try {
            // pascal3g.g:678:5: ( FOR ^ identifier ASSIGN ! forList DO ! statement )
            // pascal3g.g:678:7: FOR ^ identifier ASSIGN ! forList DO ! statement
            {
            root_0 = (Object)adaptor.nil();


            FOR334=(Token)match(input,FOR,FOLLOW_FOR_in_forStatement5482); 
            FOR334_tree = 
            (Object)adaptor.create(FOR334)
            ;
            root_0 = (Object)adaptor.becomeRoot(FOR334_tree, root_0);


            pushFollow(FOLLOW_identifier_in_forStatement5485);
            identifier335=identifier();

            state._fsp--;

            adaptor.addChild(root_0, identifier335.getTree());

            ASSIGN336=(Token)match(input,ASSIGN,FOLLOW_ASSIGN_in_forStatement5487); 

            pushFollow(FOLLOW_forList_in_forStatement5490);
            forList337=forList();

            state._fsp--;

            adaptor.addChild(root_0, forList337.getTree());

            DO338=(Token)match(input,DO,FOLLOW_DO_in_forStatement5492); 

            pushFollow(FOLLOW_statement_in_forStatement5495);
            statement339=statement();

            state._fsp--;

            adaptor.addChild(root_0, statement339.getTree());

            }

            retval.stop = input.LT(-1);


            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "forStatement"


    public static class forList_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "forList"
    // pascal3g.g:681:1: forList : initialValue ( TO ^| DOWNTO ^) finalValue ;
    public final forList_return forList() throws RecognitionException {
        forList_return retval = new forList_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token TO341=null;
        Token DOWNTO342=null;
        initialValue_return initialValue340 =null;

        finalValue_return finalValue343 =null;


        Object TO341_tree=null;
        Object DOWNTO342_tree=null;

        try {
            // pascal3g.g:682:5: ( initialValue ( TO ^| DOWNTO ^) finalValue )
            // pascal3g.g:682:7: initialValue ( TO ^| DOWNTO ^) finalValue
            {
            root_0 = (Object)adaptor.nil();


            pushFollow(FOLLOW_initialValue_in_forList5512);
            initialValue340=initialValue();

            state._fsp--;

            adaptor.addChild(root_0, initialValue340.getTree());

            // pascal3g.g:682:20: ( TO ^| DOWNTO ^)
            int alt71=2;
            int LA71_0 = input.LA(1);

            if ( (LA71_0==TO) ) {
                alt71=1;
            }
            else if ( (LA71_0==DOWNTO) ) {
                alt71=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 71, 0, input);

                throw nvae;

            }
            switch (alt71) {
                case 1 :
                    // pascal3g.g:682:21: TO ^
                    {
                    TO341=(Token)match(input,TO,FOLLOW_TO_in_forList5515); 
                    TO341_tree = 
                    (Object)adaptor.create(TO341)
                    ;
                    root_0 = (Object)adaptor.becomeRoot(TO341_tree, root_0);


                    }
                    break;
                case 2 :
                    // pascal3g.g:682:27: DOWNTO ^
                    {
                    DOWNTO342=(Token)match(input,DOWNTO,FOLLOW_DOWNTO_in_forList5520); 
                    DOWNTO342_tree = 
                    (Object)adaptor.create(DOWNTO342)
                    ;
                    root_0 = (Object)adaptor.becomeRoot(DOWNTO342_tree, root_0);


                    }
                    break;

            }


            pushFollow(FOLLOW_finalValue_in_forList5524);
            finalValue343=finalValue();

            state._fsp--;

            adaptor.addChild(root_0, finalValue343.getTree());

            }

            retval.stop = input.LT(-1);


            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "forList"


    public static class initialValue_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "initialValue"
    // pascal3g.g:685:1: initialValue : expression ;
    public final initialValue_return initialValue() throws RecognitionException {
        initialValue_return retval = new initialValue_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        expression_return expression344 =null;



        try {
            // pascal3g.g:686:5: ( expression )
            // pascal3g.g:686:7: expression
            {
            root_0 = (Object)adaptor.nil();


            pushFollow(FOLLOW_expression_in_initialValue5541);
            expression344=expression();

            state._fsp--;

            adaptor.addChild(root_0, expression344.getTree());

            }

            retval.stop = input.LT(-1);


            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "initialValue"


    public static class finalValue_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "finalValue"
    // pascal3g.g:689:1: finalValue : expression ;
    public final finalValue_return finalValue() throws RecognitionException {
        finalValue_return retval = new finalValue_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        expression_return expression345 =null;



        try {
            // pascal3g.g:690:5: ( expression )
            // pascal3g.g:690:7: expression
            {
            root_0 = (Object)adaptor.nil();


            pushFollow(FOLLOW_expression_in_finalValue5558);
            expression345=expression();

            state._fsp--;

            adaptor.addChild(root_0, expression345.getTree());

            }

            retval.stop = input.LT(-1);


            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "finalValue"


    public static class withStatement_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "withStatement"
    // pascal3g.g:693:1: withStatement : WITH ^ recordVariableList DO ! statement ;
    public final withStatement_return withStatement() throws RecognitionException {
        withStatement_return retval = new withStatement_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token WITH346=null;
        Token DO348=null;
        recordVariableList_return recordVariableList347 =null;

        statement_return statement349 =null;


        Object WITH346_tree=null;
        Object DO348_tree=null;

        try {
            // pascal3g.g:694:5: ( WITH ^ recordVariableList DO ! statement )
            // pascal3g.g:694:7: WITH ^ recordVariableList DO ! statement
            {
            root_0 = (Object)adaptor.nil();


            WITH346=(Token)match(input,WITH,FOLLOW_WITH_in_withStatement5575); 
            WITH346_tree = 
            (Object)adaptor.create(WITH346)
            ;
            root_0 = (Object)adaptor.becomeRoot(WITH346_tree, root_0);


            pushFollow(FOLLOW_recordVariableList_in_withStatement5578);
            recordVariableList347=recordVariableList();

            state._fsp--;

            adaptor.addChild(root_0, recordVariableList347.getTree());

            DO348=(Token)match(input,DO,FOLLOW_DO_in_withStatement5580); 

            pushFollow(FOLLOW_statement_in_withStatement5583);
            statement349=statement();

            state._fsp--;

            adaptor.addChild(root_0, statement349.getTree());

            }

            retval.stop = input.LT(-1);


            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "withStatement"


    public static class recordVariableList_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "recordVariableList"
    // pascal3g.g:697:1: recordVariableList : variable ( COMMA ! variable )* ;
    public final recordVariableList_return recordVariableList() throws RecognitionException {
        recordVariableList_return retval = new recordVariableList_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token COMMA351=null;
        variable_return variable350 =null;

        variable_return variable352 =null;


        Object COMMA351_tree=null;

        try {
            // pascal3g.g:698:5: ( variable ( COMMA ! variable )* )
            // pascal3g.g:698:7: variable ( COMMA ! variable )*
            {
            root_0 = (Object)adaptor.nil();


            pushFollow(FOLLOW_variable_in_recordVariableList5600);
            variable350=variable();

            state._fsp--;

            adaptor.addChild(root_0, variable350.getTree());

            // pascal3g.g:698:16: ( COMMA ! variable )*
            loop72:
            do {
                int alt72=2;
                int LA72_0 = input.LA(1);

                if ( (LA72_0==COMMA) ) {
                    alt72=1;
                }


                switch (alt72) {
            	case 1 :
            	    // pascal3g.g:698:18: COMMA ! variable
            	    {
            	    COMMA351=(Token)match(input,COMMA,FOLLOW_COMMA_in_recordVariableList5604); 

            	    pushFollow(FOLLOW_variable_in_recordVariableList5607);
            	    variable352=variable();

            	    state._fsp--;

            	    adaptor.addChild(root_0, variable352.getTree());

            	    }
            	    break;

            	default :
            	    break loop72;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);


            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "recordVariableList"

    // Delegated rules


 

    public static final BitSet FOLLOW_programHeading_in_program2231 = new BitSet(new long[]{0x000C808000200800L,0x0000000184000040L});
    public static final BitSet FOLLOW_INTERFACE_in_program2234 = new BitSet(new long[]{0x0008808000200800L,0x0000000184000040L});
    public static final BitSet FOLLOW_block_in_program2244 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_DOT_in_program2252 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PROGRAM_in_programHeading2285 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_identifier_in_programHeading2288 = new BitSet(new long[]{0x0100000000000000L,0x0000000000020000L});
    public static final BitSet FOLLOW_LPAREN_in_programHeading2291 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_identifierList_in_programHeading2294 = new BitSet(new long[]{0x0000000000000000L,0x0000000000008000L});
    public static final BitSet FOLLOW_RPAREN_in_programHeading2296 = new BitSet(new long[]{0x0000000000000000L,0x0000000000020000L});
    public static final BitSet FOLLOW_SEMI_in_programHeading2301 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_UNIT_in_programHeading2310 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_identifier_in_programHeading2312 = new BitSet(new long[]{0x0000000000000000L,0x0000000000020000L});
    public static final BitSet FOLLOW_SEMI_in_programHeading2314 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENT_in_identifier2330 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_labelDeclarationPart_in_block2349 = new BitSet(new long[]{0x0008808000200800L,0x0000000184000040L});
    public static final BitSet FOLLOW_constantDefinitionPart_in_block2359 = new BitSet(new long[]{0x0008808000200800L,0x0000000184000040L});
    public static final BitSet FOLLOW_typeDefinitionPart_in_block2369 = new BitSet(new long[]{0x0008808000200800L,0x0000000184000040L});
    public static final BitSet FOLLOW_variableDeclarationPart_in_block2379 = new BitSet(new long[]{0x0008808000200800L,0x0000000184000040L});
    public static final BitSet FOLLOW_procedureAndFunctionDeclarationPart_in_block2389 = new BitSet(new long[]{0x0008808000200800L,0x0000000184000040L});
    public static final BitSet FOLLOW_usesUnitsPart_in_block2399 = new BitSet(new long[]{0x0008808000200800L,0x0000000184000040L});
    public static final BitSet FOLLOW_IMPLEMENTATION_in_block2409 = new BitSet(new long[]{0x0008808000200800L,0x0000000184000040L});
    public static final BitSet FOLLOW_compoundStatement_in_block2426 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_USES_in_usesUnitsPart2443 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_identifierList_in_usesUnitsPart2446 = new BitSet(new long[]{0x0000000000000000L,0x0000000000020000L});
    public static final BitSet FOLLOW_SEMI_in_usesUnitsPart2448 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LABEL_in_labelDeclarationPart2466 = new BitSet(new long[]{0x8000000000000000L});
    public static final BitSet FOLLOW_label_in_labelDeclarationPart2469 = new BitSet(new long[]{0x0000000000040000L,0x0000000000020000L});
    public static final BitSet FOLLOW_COMMA_in_labelDeclarationPart2473 = new BitSet(new long[]{0x8000000000000000L});
    public static final BitSet FOLLOW_label_in_labelDeclarationPart2476 = new BitSet(new long[]{0x0000000000040000L,0x0000000000020000L});
    public static final BitSet FOLLOW_SEMI_in_labelDeclarationPart2481 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_unsignedInteger_in_label2499 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CONST_in_constantDefinitionPart2516 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_constantDefinition_in_constantDefinitionPart2519 = new BitSet(new long[]{0x0000000000000000L,0x0000000000020000L});
    public static final BitSet FOLLOW_SEMI_in_constantDefinitionPart2523 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_constantDefinition_in_constantDefinitionPart2526 = new BitSet(new long[]{0x0000000000000000L,0x0000000000020000L});
    public static final BitSet FOLLOW_SEMI_in_constantDefinitionPart2531 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_identifier_in_constantDefinition2549 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_EQUAL_in_constantDefinition2551 = new BitSet(new long[]{0x8400100000010000L,0x0000000000400011L});
    public static final BitSet FOLLOW_constant_in_constantDefinition2554 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CHR_in_constantChr2571 = new BitSet(new long[]{0x0100000000000000L});
    public static final BitSet FOLLOW_LPAREN_in_constantChr2574 = new BitSet(new long[]{0x8000100000000000L});
    public static final BitSet FOLLOW_unsignedInteger_in_constantChr2578 = new BitSet(new long[]{0x0000000000000000L,0x0000000000008000L});
    public static final BitSet FOLLOW_identifier_in_constantChr2580 = new BitSet(new long[]{0x0000000000000000L,0x0000000000008000L});
    public static final BitSet FOLLOW_RPAREN_in_constantChr2583 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_unsignedNumber_in_constant2601 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_sign_in_constant2611 = new BitSet(new long[]{0x8000000000000000L,0x0000000000000001L});
    public static final BitSet FOLLOW_unsignedNumber_in_constant2615 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_identifier_in_constant2634 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_sign_in_constant2644 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_identifier_in_constant2648 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_string_in_constant2667 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_constantChr_in_constant2675 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_unsignedInteger_in_unsignedNumber2692 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_unsignedReal_in_unsignedNumber2700 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NUM_INT_in_unsignedInteger2717 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NUM_REAL_in_unsignedReal2734 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STRING_LITERAL_in_string2772 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TYPE_in_typeDefinitionPart2789 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_typeDefinition_in_typeDefinitionPart2792 = new BitSet(new long[]{0x0000000000000000L,0x0000000000020000L});
    public static final BitSet FOLLOW_SEMI_in_typeDefinitionPart2796 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_typeDefinition_in_typeDefinitionPart2799 = new BitSet(new long[]{0x0000000000000000L,0x0000000000020000L});
    public static final BitSet FOLLOW_SEMI_in_typeDefinitionPart2804 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_identifier_in_typeDefinition2823 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_EQUAL_in_typeDefinition2827 = new BitSet(new long[]{0x850210900001A100L,0x0000000000643079L});
    public static final BitSet FOLLOW_type_in_typeDefinition2840 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_functionType_in_typeDefinition2850 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_procedureType_in_typeDefinition2861 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FUNCTION_in_functionType2886 = new BitSet(new long[]{0x0100000000020000L});
    public static final BitSet FOLLOW_formalParameterList_in_functionType2890 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_COLON_in_functionType2894 = new BitSet(new long[]{0x000210000000A000L,0x0000000000201000L});
    public static final BitSet FOLLOW_resultType_in_functionType2897 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PROCEDURE_in_procedureType2914 = new BitSet(new long[]{0x0100000000000002L});
    public static final BitSet FOLLOW_formalParameterList_in_procedureType2918 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_simpleType_in_type2937 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_structuredType_in_type2945 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_pointerType_in_type2953 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_scalarType_in_simpleType2970 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_subrangeType_in_simpleType2978 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_typeIdentifier_in_simpleType2987 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_stringtype_in_simpleType2995 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LPAREN_in_scalarType3012 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_identifierList_in_scalarType3014 = new BitSet(new long[]{0x0000000000000000L,0x0000000000008000L});
    public static final BitSet FOLLOW_RPAREN_in_scalarType3016 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_constant_in_subrangeType3048 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_DOTDOT_in_subrangeType3050 = new BitSet(new long[]{0x8400100000010000L,0x0000000000400011L});
    public static final BitSet FOLLOW_constant_in_subrangeType3054 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_identifier_in_typeIdentifier3087 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CHAR_in_typeIdentifier3095 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BOOLEAN_in_typeIdentifier3103 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INTEGER_in_typeIdentifier3111 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_REAL_in_typeIdentifier3119 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STRING_in_typeIdentifier3127 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PACKED_in_structuredType3145 = new BitSet(new long[]{0x8400101000010100L,0x0000000000442011L});
    public static final BitSet FOLLOW_unpackedStructuredType_in_structuredType3148 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_unpackedStructuredType_in_structuredType3155 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_arrayType_in_unpackedStructuredType3172 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_recordType_in_unpackedStructuredType3180 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_setType_in_unpackedStructuredType3188 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_fileType_in_unpackedStructuredType3196 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_subrangeType_in_unpackedStructuredType3204 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STRING_in_stringtype3222 = new BitSet(new long[]{0x0100000000000000L});
    public static final BitSet FOLLOW_LPAREN_in_stringtype3225 = new BitSet(new long[]{0x8000100000000000L,0x0000000000000001L});
    public static final BitSet FOLLOW_identifier_in_stringtype3229 = new BitSet(new long[]{0x0000000000000000L,0x0000000000008000L});
    public static final BitSet FOLLOW_unsignedNumber_in_stringtype3231 = new BitSet(new long[]{0x0000000000000000L,0x0000000000008000L});
    public static final BitSet FOLLOW_RPAREN_in_stringtype3234 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STRING_in_stringtype3244 = new BitSet(new long[]{0x0020000000000000L});
    public static final BitSet FOLLOW_LBRACK2_in_stringtype3247 = new BitSet(new long[]{0x8000100000000000L,0x0000000000000001L});
    public static final BitSet FOLLOW_identifier_in_stringtype3251 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000400L});
    public static final BitSet FOLLOW_unsignedNumber_in_stringtype3253 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000400L});
    public static final BitSet FOLLOW_RBRACK2_in_stringtype3256 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ARRAY_in_arrayType3275 = new BitSet(new long[]{0x0010000000000000L});
    public static final BitSet FOLLOW_LBRACK_in_arrayType3278 = new BitSet(new long[]{0x850210000001A000L,0x0000000000601011L});
    public static final BitSet FOLLOW_typeList_in_arrayType3281 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000200L});
    public static final BitSet FOLLOW_RBRACK_in_arrayType3283 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000002L});
    public static final BitSet FOLLOW_OF_in_arrayType3286 = new BitSet(new long[]{0x850210100001A100L,0x0000000000643039L});
    public static final BitSet FOLLOW_componentType_in_arrayType3289 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ARRAY_in_arrayType3297 = new BitSet(new long[]{0x0020000000000000L});
    public static final BitSet FOLLOW_LBRACK2_in_arrayType3300 = new BitSet(new long[]{0x850210000001A000L,0x0000000000601011L});
    public static final BitSet FOLLOW_typeList_in_arrayType3303 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000400L});
    public static final BitSet FOLLOW_RBRACK2_in_arrayType3305 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000002L});
    public static final BitSet FOLLOW_OF_in_arrayType3308 = new BitSet(new long[]{0x850210100001A100L,0x0000000000643039L});
    public static final BitSet FOLLOW_componentType_in_arrayType3311 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_indexType_in_typeList3324 = new BitSet(new long[]{0x0000000000040002L});
    public static final BitSet FOLLOW_COMMA_in_typeList3328 = new BitSet(new long[]{0x850210000001A000L,0x0000000000601011L});
    public static final BitSet FOLLOW_indexType_in_typeList3330 = new BitSet(new long[]{0x0000000000040002L});
    public static final BitSet FOLLOW_simpleType_in_indexType3359 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_type_in_componentType3376 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RECORD_in_recordType3393 = new BitSet(new long[]{0x0000100000004000L});
    public static final BitSet FOLLOW_fieldList_in_recordType3396 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_END_in_recordType3398 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_fixedPart_in_fieldList3420 = new BitSet(new long[]{0x0000000000000002L,0x0000000000020000L});
    public static final BitSet FOLLOW_SEMI_in_fieldList3424 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_variantPart_in_fieldList3428 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SEMI_in_fieldList3432 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_variantPart_in_fieldList3447 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_recordSection_in_fixedPart3496 = new BitSet(new long[]{0x0000000000000002L,0x0000000000020000L});
    public static final BitSet FOLLOW_SEMI_in_fixedPart3500 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_recordSection_in_fixedPart3503 = new BitSet(new long[]{0x0000000000000002L,0x0000000000020000L});
    public static final BitSet FOLLOW_identifierList_in_recordSection3523 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_COLON_in_recordSection3525 = new BitSet(new long[]{0x850210100001A100L,0x0000000000643039L});
    public static final BitSet FOLLOW_type_in_recordSection3527 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CASE_in_variantPart3558 = new BitSet(new long[]{0x000210000000A000L,0x0000000000201000L});
    public static final BitSet FOLLOW_tag_in_variantPart3561 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000002L});
    public static final BitSet FOLLOW_OF_in_variantPart3563 = new BitSet(new long[]{0x8400100000010000L,0x0000000000400011L});
    public static final BitSet FOLLOW_variant_in_variantPart3566 = new BitSet(new long[]{0x0000000000000002L,0x0000000000020000L});
    public static final BitSet FOLLOW_SEMI_in_variantPart3570 = new BitSet(new long[]{0x8400100000010000L,0x0000000000400011L});
    public static final BitSet FOLLOW_variant_in_variantPart3573 = new BitSet(new long[]{0x0000000000000002L,0x0000000000020000L});
    public static final BitSet FOLLOW_SEMI_in_variantPart3577 = new BitSet(new long[]{0x0000000000000002L,0x0000000000020000L});
    public static final BitSet FOLLOW_identifier_in_tag3600 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_COLON_in_tag3602 = new BitSet(new long[]{0x000210000000A000L,0x0000000000201000L});
    public static final BitSet FOLLOW_typeIdentifier_in_tag3606 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_typeIdentifier_in_tag3629 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_constList_in_variant3656 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_COLON_in_variant3660 = new BitSet(new long[]{0x0100000000000000L});
    public static final BitSet FOLLOW_LPAREN_in_variant3669 = new BitSet(new long[]{0x0000100000004000L});
    public static final BitSet FOLLOW_fieldList_in_variant3672 = new BitSet(new long[]{0x0000000000000000L,0x0000000000008000L});
    public static final BitSet FOLLOW_RPAREN_in_variant3674 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SET_in_setType3692 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000002L});
    public static final BitSet FOLLOW_OF_in_setType3695 = new BitSet(new long[]{0x850210000001A000L,0x0000000000601011L});
    public static final BitSet FOLLOW_simpleType_in_setType3698 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FILE_in_fileType3715 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000002L});
    public static final BitSet FOLLOW_OF_in_fileType3718 = new BitSet(new long[]{0x850210100001A100L,0x0000000000643039L});
    public static final BitSet FOLLOW_type_in_fileType3721 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FILE_in_fileType3729 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_POINTER_in_pointerType3746 = new BitSet(new long[]{0x000210000000A000L,0x0000000000201000L});
    public static final BitSet FOLLOW_typeIdentifier_in_pointerType3749 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_VAR_in_variableDeclarationPart3767 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_variableDeclaration_in_variableDeclarationPart3770 = new BitSet(new long[]{0x0000000000000000L,0x0000000000020000L});
    public static final BitSet FOLLOW_SEMI_in_variableDeclarationPart3774 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_variableDeclaration_in_variableDeclarationPart3777 = new BitSet(new long[]{0x0000000000000000L,0x0000000000020000L});
    public static final BitSet FOLLOW_SEMI_in_variableDeclarationPart3782 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_identifierList_in_variableDeclaration3800 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_COLON_in_variableDeclaration3804 = new BitSet(new long[]{0x850210100001A100L,0x0000000000643039L});
    public static final BitSet FOLLOW_type_in_variableDeclaration3809 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_procedureOrFunctionDeclaration_in_procedureAndFunctionDeclarationPart3826 = new BitSet(new long[]{0x0000000000000000L,0x0000000000020000L});
    public static final BitSet FOLLOW_SEMI_in_procedureAndFunctionDeclarationPart3828 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_procedureDeclaration_in_procedureOrFunctionDeclaration3846 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_functionDeclaration_in_procedureOrFunctionDeclaration3854 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PROCEDURE_in_procedureDeclaration3871 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_identifier_in_procedureDeclaration3874 = new BitSet(new long[]{0x0100000000000000L,0x0000000000020000L});
    public static final BitSet FOLLOW_formalParameterList_in_procedureDeclaration3877 = new BitSet(new long[]{0x0000000000000000L,0x0000000000020000L});
    public static final BitSet FOLLOW_SEMI_in_procedureDeclaration3881 = new BitSet(new long[]{0x000880C000200800L,0x0000000184000040L});
    public static final BitSet FOLLOW_block_in_procedureDeclaration3892 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_directive_in_procedureDeclaration3896 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FUNCTION_in_functionDeclaration3919 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_identifier_in_functionDeclaration3922 = new BitSet(new long[]{0x0100000000020000L});
    public static final BitSet FOLLOW_formalParameterList_in_functionDeclaration3925 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_COLON_in_functionDeclaration3929 = new BitSet(new long[]{0x000210000000A000L,0x0000000000201000L});
    public static final BitSet FOLLOW_resultType_in_functionDeclaration3932 = new BitSet(new long[]{0x0000000000000000L,0x0000000000020000L});
    public static final BitSet FOLLOW_SEMI_in_functionDeclaration3934 = new BitSet(new long[]{0x000880C000200800L,0x0000000184000040L});
    public static final BitSet FOLLOW_block_in_functionDeclaration3945 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_directive_in_functionDeclaration3949 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FORWARD_in_directive3968 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LPAREN_in_formalParameterList3986 = new BitSet(new long[]{0x0000108000000000L,0x0000000100000040L});
    public static final BitSet FOLLOW_formalParameterSection_in_formalParameterList3988 = new BitSet(new long[]{0x0000000000000000L,0x0000000000028000L});
    public static final BitSet FOLLOW_SEMI_in_formalParameterList3992 = new BitSet(new long[]{0x0000108000000000L,0x0000000100000040L});
    public static final BitSet FOLLOW_formalParameterSection_in_formalParameterList3994 = new BitSet(new long[]{0x0000000000000000L,0x0000000000028000L});
    public static final BitSet FOLLOW_RPAREN_in_formalParameterList3999 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parameterGroup_in_formalParameterSection4029 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_VAR_in_formalParameterSection4037 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_parameterGroup_in_formalParameterSection4040 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FUNCTION_in_formalParameterSection4048 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_parameterGroup_in_formalParameterSection4051 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PROCEDURE_in_formalParameterSection4059 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_parameterGroup_in_formalParameterSection4062 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_identifierList_in_parameterGroup4081 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_COLON_in_parameterGroup4083 = new BitSet(new long[]{0x000210000000A000L,0x0000000000201000L});
    public static final BitSet FOLLOW_typeIdentifier_in_parameterGroup4087 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_identifier_in_identifierList4118 = new BitSet(new long[]{0x0000000000040002L});
    public static final BitSet FOLLOW_COMMA_in_identifierList4122 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_identifier_in_identifierList4124 = new BitSet(new long[]{0x0000000000040002L});
    public static final BitSet FOLLOW_constant_in_constList4156 = new BitSet(new long[]{0x0000000000040002L});
    public static final BitSet FOLLOW_COMMA_in_constList4160 = new BitSet(new long[]{0x8400100000010000L,0x0000000000400011L});
    public static final BitSet FOLLOW_constant_in_constList4162 = new BitSet(new long[]{0x0000000000040002L});
    public static final BitSet FOLLOW_typeIdentifier_in_resultType4194 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_label_in_statement4211 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_COLON_in_statement4213 = new BitSet(new long[]{0x0000542100004C00L,0x0000006000004000L});
    public static final BitSet FOLLOW_unlabelledStatement_in_statement4216 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_unlabelledStatement_in_statement4224 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_simpleStatement_in_unlabelledStatement4241 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_structuredStatement_in_unlabelledStatement4249 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_EXIT_in_exitStatement4266 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_assignmentStatement_in_simpleStatement4286 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_procedureStatement_in_simpleStatement4294 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_exitStatement_in_simpleStatement4302 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_gotoStatement_in_simpleStatement4310 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_emptyStatement_in_simpleStatement4318 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_variable_in_assignmentStatement4335 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_ASSIGN_in_assignmentStatement4337 = new BitSet(new long[]{0xB530100000010400L,0x0000000000400011L});
    public static final BitSet FOLLOW_expression_in_assignmentStatement4340 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_AT_in_variable4359 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_identifier_in_variable4362 = new BitSet(new long[]{0x0030000002000002L,0x0000000000000020L});
    public static final BitSet FOLLOW_identifier_in_variable4373 = new BitSet(new long[]{0x0030000002000002L,0x0000000000000020L});
    public static final BitSet FOLLOW_LBRACK_in_variable4392 = new BitSet(new long[]{0xB530100000010400L,0x0000000000400011L});
    public static final BitSet FOLLOW_expression_in_variable4395 = new BitSet(new long[]{0x0000000000040000L,0x0000000000000200L});
    public static final BitSet FOLLOW_COMMA_in_variable4399 = new BitSet(new long[]{0xB530100000010400L,0x0000000000400011L});
    public static final BitSet FOLLOW_expression_in_variable4402 = new BitSet(new long[]{0x0000000000040000L,0x0000000000000200L});
    public static final BitSet FOLLOW_RBRACK_in_variable4406 = new BitSet(new long[]{0x0030000002000002L,0x0000000000000020L});
    public static final BitSet FOLLOW_LBRACK2_in_variable4417 = new BitSet(new long[]{0xB530100000010400L,0x0000000000400011L});
    public static final BitSet FOLLOW_expression_in_variable4420 = new BitSet(new long[]{0x0000000000040000L,0x0000000000000400L});
    public static final BitSet FOLLOW_COMMA_in_variable4424 = new BitSet(new long[]{0xB530100000010400L,0x0000000000400011L});
    public static final BitSet FOLLOW_expression_in_variable4427 = new BitSet(new long[]{0x0000000000040000L,0x0000000000000400L});
    public static final BitSet FOLLOW_RBRACK2_in_variable4431 = new BitSet(new long[]{0x0030000002000002L,0x0000000000000020L});
    public static final BitSet FOLLOW_DOT_in_variable4442 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_identifier_in_variable4445 = new BitSet(new long[]{0x0030000002000002L,0x0000000000000020L});
    public static final BitSet FOLLOW_POINTER_in_variable4455 = new BitSet(new long[]{0x0030000002000002L,0x0000000000000020L});
    public static final BitSet FOLLOW_simpleExpression_in_expression4482 = new BitSet(new long[]{0x42810A0080000002L});
    public static final BitSet FOLLOW_EQUAL_in_expression4491 = new BitSet(new long[]{0xB530100000010400L,0x0000000000400011L});
    public static final BitSet FOLLOW_NOT_EQUAL_in_expression4496 = new BitSet(new long[]{0xB530100000010400L,0x0000000000400011L});
    public static final BitSet FOLLOW_LT_in_expression4501 = new BitSet(new long[]{0xB530100000010400L,0x0000000000400011L});
    public static final BitSet FOLLOW_LE_in_expression4506 = new BitSet(new long[]{0xB530100000010400L,0x0000000000400011L});
    public static final BitSet FOLLOW_GE_in_expression4511 = new BitSet(new long[]{0xB530100000010400L,0x0000000000400011L});
    public static final BitSet FOLLOW_GT_in_expression4516 = new BitSet(new long[]{0xB530100000010400L,0x0000000000400011L});
    public static final BitSet FOLLOW_IN_in_expression4521 = new BitSet(new long[]{0xB530100000010400L,0x0000000000400011L});
    public static final BitSet FOLLOW_simpleExpression_in_expression4525 = new BitSet(new long[]{0x42810A0080000002L});
    public static final BitSet FOLLOW_term_in_simpleExpression4545 = new BitSet(new long[]{0x0400000000000002L,0x0000000000000014L});
    public static final BitSet FOLLOW_PLUS_in_simpleExpression4550 = new BitSet(new long[]{0xB530100000010400L,0x0000000000400011L});
    public static final BitSet FOLLOW_MINUS_in_simpleExpression4555 = new BitSet(new long[]{0xB530100000010400L,0x0000000000400011L});
    public static final BitSet FOLLOW_OR_in_simpleExpression4560 = new BitSet(new long[]{0xB530100000010400L,0x0000000000400011L});
    public static final BitSet FOLLOW_term_in_simpleExpression4564 = new BitSet(new long[]{0x0400000000000002L,0x0000000000000014L});
    public static final BitSet FOLLOW_signedFactor_in_term4582 = new BitSet(new long[]{0x0800000000800012L,0x0000000000180000L});
    public static final BitSet FOLLOW_STAR_in_term4587 = new BitSet(new long[]{0xB530100000010400L,0x0000000000400011L});
    public static final BitSet FOLLOW_SLASH_in_term4592 = new BitSet(new long[]{0xB530100000010400L,0x0000000000400011L});
    public static final BitSet FOLLOW_DIV_in_term4597 = new BitSet(new long[]{0xB530100000010400L,0x0000000000400011L});
    public static final BitSet FOLLOW_MOD_in_term4602 = new BitSet(new long[]{0xB530100000010400L,0x0000000000400011L});
    public static final BitSet FOLLOW_AND_in_term4607 = new BitSet(new long[]{0xB530100000010400L,0x0000000000400011L});
    public static final BitSet FOLLOW_signedFactor_in_term4611 = new BitSet(new long[]{0x0800000000800012L,0x0000000000180000L});
    public static final BitSet FOLLOW_PLUS_in_signedFactor4632 = new BitSet(new long[]{0xB130100000010400L,0x0000000000400001L});
    public static final BitSet FOLLOW_MINUS_in_signedFactor4635 = new BitSet(new long[]{0xB130100000010400L,0x0000000000400001L});
    public static final BitSet FOLLOW_factor_in_signedFactor4640 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_variable_in_factor4657 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LPAREN_in_factor4665 = new BitSet(new long[]{0xB530100000010400L,0x0000000000400011L});
    public static final BitSet FOLLOW_expression_in_factor4668 = new BitSet(new long[]{0x0000000000000000L,0x0000000000008000L});
    public static final BitSet FOLLOW_RPAREN_in_factor4670 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_functionDesignator_in_factor4679 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_unsignedConstant_in_factor4687 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_factor4695 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NOT_in_factor4703 = new BitSet(new long[]{0xB130100000010400L,0x0000000000400001L});
    public static final BitSet FOLLOW_factor_in_factor4706 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_unsignedNumber_in_unsignedConstant4723 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_constantChr_in_unsignedConstant4731 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_string_in_unsignedConstant4748 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NIL_in_unsignedConstant4756 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_identifier_in_functionDesignator4775 = new BitSet(new long[]{0x0100000000000000L});
    public static final BitSet FOLLOW_LPAREN_in_functionDesignator4777 = new BitSet(new long[]{0xB530100000010400L,0x0000000000400011L});
    public static final BitSet FOLLOW_parameterList_in_functionDesignator4781 = new BitSet(new long[]{0x0000000000000000L,0x0000000000008000L});
    public static final BitSet FOLLOW_RPAREN_in_functionDesignator4783 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_actualParameter_in_parameterList4817 = new BitSet(new long[]{0x0000000000040002L});
    public static final BitSet FOLLOW_COMMA_in_parameterList4821 = new BitSet(new long[]{0xB530100000010400L,0x0000000000400011L});
    public static final BitSet FOLLOW_actualParameter_in_parameterList4823 = new BitSet(new long[]{0x0000000000040002L});
    public static final BitSet FOLLOW_LBRACK_in_set4856 = new BitSet(new long[]{0xB530100000010400L,0x0000000000400211L});
    public static final BitSet FOLLOW_elementList_in_set4858 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000200L});
    public static final BitSet FOLLOW_RBRACK_in_set4860 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LBRACK2_in_set4879 = new BitSet(new long[]{0xB530100000010400L,0x0000000000400411L});
    public static final BitSet FOLLOW_elementList_in_set4881 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000400L});
    public static final BitSet FOLLOW_RBRACK2_in_set4883 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_element_in_elementList4909 = new BitSet(new long[]{0x0000000000040002L});
    public static final BitSet FOLLOW_COMMA_in_elementList4913 = new BitSet(new long[]{0xB530100000010400L,0x0000000000400011L});
    public static final BitSet FOLLOW_element_in_elementList4916 = new BitSet(new long[]{0x0000000000040002L});
    public static final BitSet FOLLOW_expression_in_element4942 = new BitSet(new long[]{0x0000000004000002L});
    public static final BitSet FOLLOW_DOTDOT_in_element4946 = new BitSet(new long[]{0xB530100000010400L,0x0000000000400011L});
    public static final BitSet FOLLOW_expression_in_element4949 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_identifier_in_procedureStatement4971 = new BitSet(new long[]{0x0100000000000002L});
    public static final BitSet FOLLOW_LPAREN_in_procedureStatement4975 = new BitSet(new long[]{0xB530100000010400L,0x0000000000400011L});
    public static final BitSet FOLLOW_parameterList_in_procedureStatement4979 = new BitSet(new long[]{0x0000000000000000L,0x0000000000008000L});
    public static final BitSet FOLLOW_RPAREN_in_procedureStatement4981 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expression_in_actualParameter5021 = new BitSet(new long[]{0x0000000000020002L});
    public static final BitSet FOLLOW_COLON_in_actualParameter5024 = new BitSet(new long[]{0x8000000000000000L});
    public static final BitSet FOLLOW_unsignedInteger_in_actualParameter5026 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_GOTO_in_gotoStatement5045 = new BitSet(new long[]{0x8000000000000000L});
    public static final BitSet FOLLOW_label_in_gotoStatement5048 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_compoundStatement_in_structuredStatement5096 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_conditionalStatement_in_structuredStatement5104 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_repetetiveStatement_in_structuredStatement5112 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_withStatement_in_structuredStatement5120 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BEGIN_in_compoundStatement5137 = new BitSet(new long[]{0x8000542100004C00L,0x0000006000004000L});
    public static final BitSet FOLLOW_statements_in_compoundStatement5143 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_END_in_compoundStatement5151 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_statement_in_statements5186 = new BitSet(new long[]{0x0000000000000002L,0x0000000000020000L});
    public static final BitSet FOLLOW_SEMI_in_statements5190 = new BitSet(new long[]{0x8000542100004C00L,0x0000006000004000L});
    public static final BitSet FOLLOW_statement_in_statements5193 = new BitSet(new long[]{0x0000000000000002L,0x0000000000020000L});
    public static final BitSet FOLLOW_ifStatement_in_conditionalStatement5214 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_caseStatement_in_conditionalStatement5222 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IF_in_ifStatement5239 = new BitSet(new long[]{0xB530100000010400L,0x0000000000400011L});
    public static final BitSet FOLLOW_expression_in_ifStatement5242 = new BitSet(new long[]{0x0000000000000000L,0x0000000001000000L});
    public static final BitSet FOLLOW_THEN_in_ifStatement5244 = new BitSet(new long[]{0x8000542100004C00L,0x0000006000004000L});
    public static final BitSet FOLLOW_statement_in_ifStatement5247 = new BitSet(new long[]{0x0000000020000002L});
    public static final BitSet FOLLOW_ELSE_in_ifStatement5277 = new BitSet(new long[]{0x8000542100004C00L,0x0000006000004000L});
    public static final BitSet FOLLOW_statement_in_ifStatement5280 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CASE_in_caseStatement5305 = new BitSet(new long[]{0xB530100000010400L,0x0000000000400011L});
    public static final BitSet FOLLOW_expression_in_caseStatement5308 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000002L});
    public static final BitSet FOLLOW_OF_in_caseStatement5310 = new BitSet(new long[]{0x8400100000010000L,0x0000000000400011L});
    public static final BitSet FOLLOW_caseListElement_in_caseStatement5321 = new BitSet(new long[]{0x0000000060000000L,0x0000000000020000L});
    public static final BitSet FOLLOW_SEMI_in_caseStatement5325 = new BitSet(new long[]{0x8400100000010000L,0x0000000000400011L});
    public static final BitSet FOLLOW_caseListElement_in_caseStatement5328 = new BitSet(new long[]{0x0000000060000000L,0x0000000000020000L});
    public static final BitSet FOLLOW_SEMI_in_caseStatement5333 = new BitSet(new long[]{0x0000000060000000L});
    public static final BitSet FOLLOW_ELSE_in_caseStatement5345 = new BitSet(new long[]{0x8000542100004C00L,0x0000006000004000L});
    public static final BitSet FOLLOW_statements_in_caseStatement5348 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_END_in_caseStatement5359 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_constList_in_caseListElement5377 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_COLON_in_caseListElement5379 = new BitSet(new long[]{0x8000542100004C00L,0x0000006000004000L});
    public static final BitSet FOLLOW_statement_in_caseListElement5382 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_whileStatement_in_repetetiveStatement5399 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_repeatStatement_in_repetetiveStatement5407 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_forStatement_in_repetetiveStatement5415 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_WHILE_in_whileStatement5432 = new BitSet(new long[]{0xB530100000010400L,0x0000000000400011L});
    public static final BitSet FOLLOW_expression_in_whileStatement5435 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_DO_in_whileStatement5437 = new BitSet(new long[]{0x8000542100004C00L,0x0000006000004000L});
    public static final BitSet FOLLOW_statement_in_whileStatement5440 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_REPEAT_in_repeatStatement5457 = new BitSet(new long[]{0x8000542100004C00L,0x0000006000004000L});
    public static final BitSet FOLLOW_statements_in_repeatStatement5460 = new BitSet(new long[]{0x0000000000000000L,0x0000000040000000L});
    public static final BitSet FOLLOW_UNTIL_in_repeatStatement5462 = new BitSet(new long[]{0xB530100000010400L,0x0000000000400011L});
    public static final BitSet FOLLOW_expression_in_repeatStatement5465 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FOR_in_forStatement5482 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_identifier_in_forStatement5485 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_ASSIGN_in_forStatement5487 = new BitSet(new long[]{0xB530100000010400L,0x0000000000400011L});
    public static final BitSet FOLLOW_forList_in_forStatement5490 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_DO_in_forStatement5492 = new BitSet(new long[]{0x8000542100004C00L,0x0000006000004000L});
    public static final BitSet FOLLOW_statement_in_forStatement5495 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_initialValue_in_forList5512 = new BitSet(new long[]{0x0000000008000000L,0x0000000002000000L});
    public static final BitSet FOLLOW_TO_in_forList5515 = new BitSet(new long[]{0xB530100000010400L,0x0000000000400011L});
    public static final BitSet FOLLOW_DOWNTO_in_forList5520 = new BitSet(new long[]{0xB530100000010400L,0x0000000000400011L});
    public static final BitSet FOLLOW_finalValue_in_forList5524 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expression_in_initialValue5541 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expression_in_finalValue5558 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_WITH_in_withStatement5575 = new BitSet(new long[]{0x0000100000000400L});
    public static final BitSet FOLLOW_recordVariableList_in_withStatement5578 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_DO_in_withStatement5580 = new BitSet(new long[]{0x8000542100004C00L,0x0000006000004000L});
    public static final BitSet FOLLOW_statement_in_withStatement5583 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_variable_in_recordVariableList5600 = new BitSet(new long[]{0x0000000000040002L});
    public static final BitSet FOLLOW_COMMA_in_recordVariableList5604 = new BitSet(new long[]{0x0000100000000400L});
    public static final BitSet FOLLOW_variable_in_recordVariableList5607 = new BitSet(new long[]{0x0000000000040002L});

}