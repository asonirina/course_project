package by.bsu.project.parser.java;

import by.bsu.project.general.ParseException;
import by.bsu.project.model.Token;
import by.bsu.project.settings.Settings;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Java implements JavaConstants {

  /**
   * The stream used to save the output file.
   */
  static PrintStream save;

  /**
   * Stream containing the output of this tokenizer.
   */

    static ByteArrayOutputStream baos = new ByteArrayOutputStream();

  /**
   * Keep track of the line number from the file read in. Used to print #line xxx in the outputFile.
   */
  static int lineNo = 1;


  /**
   * Used to control when a new line is started in the outputted file.
   */
  static boolean seenNewLine = false;

    static List<String> nodes = new ArrayList<>();


  /**
   * Reinitialise all the variables, and get on with parsing the whatever's in the input stream.
   *
   * @param is - the input stream to parse.
   * @param isNewOutputStream - if we change out
   */
  public static void ReInit(InputStream is, boolean isNewOutputStream) {
      if (isNewOutputStream) {
          try {
              Java.baos.close();
          } catch (Exception ex) {

          }
      }
      Java.baos = new ByteArrayOutputStream();
      Java.lineNo = 1;
      Java.seenNewLine = false;
      Java.nodes = new ArrayList<>();
      Java.ReInit(is);
  }

  /**
   * Print the passed string into the new file.
   *
   * @param stringToPrint the string to print.
   */
  static void toPrint(String stringToPrint) {
   // printLineNo();
    if (seenNewLine)
      save.println();
    seenNewLine = false;
    save.print(stringToPrint);
      nodes.add(stringToPrint);
  }


    public static void main(String args[]) throws ParseException {
        Java parser = new Java(System.in);
        parser.Input();
        System.out.println(Java.baos.toString());
    }

    public static String[] tokenize(String source) throws ParseException {
        Java parser = new Java(new ByteArrayInputStream(source.getBytes()));
        parser.Input();
        //return Java.baos.toString();
        return Java.nodes.toArray(new String[0]);
    }

  static final public void anyOldLines() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
    case singleLineComment:{
      jj_consume_token(singleLineComment);
      break;
      }
    case formalComment:{
      jj_consume_token(formalComment);
      break;
      }
    case multiLineComment:{
      jj_consume_token(multiLineComment);
      break;
      }
    case hashLine:{
      jj_consume_token(hashLine);
      jj_consume_token(INTEGER_LITERAL);
      seenNewLine = false;
    lineNo = Integer.parseInt(getToken(0).image);
//    printLineNumber = true;
//    printLineNo();
    // The newLine that follows this will incorrectly add 1 to the line count, so correct this in advance.
    // Must remember, the number refers to the original number of the *following* line.
    lineNo--;
      break;
      }
    case LPAREN:{
      jj_consume_token(LPAREN);
      break;
      }
    case RPAREN:{
      jj_consume_token(RPAREN);
      break;
      }
    case LBRACE:{
      jj_consume_token(LBRACE);
      break;
      }
    case RBRACE:{
      jj_consume_token(RBRACE);
      break;
      }
    case LBRACKET:{
      jj_consume_token(LBRACKET);
      break;
      }
    case RBRACKET:{
      jj_consume_token(RBRACKET);
      break;
      }
    case SEMICOLON:{
      jj_consume_token(SEMICOLON);
      break;
      }
    case COMMA:{
      jj_consume_token(COMMA);
      break;
      }
    case DOT:{
      jj_consume_token(DOT);
      break;
      }
    case ASSIGN:{
      jj_consume_token(ASSIGN);
      break;
      }
    case GT:{
      jj_consume_token(GT);
      break;
      }
    case LT:{
      jj_consume_token(LT);
      break;
      }
    case BANG:{
      jj_consume_token(BANG);
      break;
      }
    case TILDE:{
      jj_consume_token(TILDE);
      break;
      }
    case HOOK:{
      jj_consume_token(HOOK);
      break;
      }
    case COLON:{
      jj_consume_token(COLON);
      break;
      }
    case EQ:{
      jj_consume_token(EQ);
      break;
      }
    case LE:{
      jj_consume_token(LE);
      break;
      }
    case GE:{
      jj_consume_token(GE);
      break;
      }
    case NE:{
      jj_consume_token(NE);
      break;
      }
    case SC_OR:{
      jj_consume_token(SC_OR);
      break;
      }
    case SC_AND:{
      jj_consume_token(SC_AND);
      break;
      }
    case INCR:{
      jj_consume_token(INCR);
      break;
      }
    case DECR:{
      jj_consume_token(DECR);
      break;
      }
    case PLUS:{
      jj_consume_token(PLUS);
      break;
      }
    case MINUS:{
      jj_consume_token(MINUS);
      break;
      }
    case STAR:{
      jj_consume_token(STAR);
      break;
      }
    case SLASH:{
      jj_consume_token(SLASH);
      break;
      }
    case BIT_AND:{
      jj_consume_token(BIT_AND);
      break;
      }
    case BIT_OR:{
      jj_consume_token(BIT_OR);
      break;
      }
    case XOR:{
      jj_consume_token(XOR);
      break;
      }
    case REM:{
      jj_consume_token(REM);
      break;
      }
    case SHIFT:{
      jj_consume_token(SHIFT);
      break;
      }
    case PLUSASSIGN:{
      jj_consume_token(PLUSASSIGN);
      break;
      }
    case MINUSASSIGN:{
      jj_consume_token(MINUSASSIGN);
      break;
      }
    case STARASSIGN:{
      jj_consume_token(STARASSIGN);
      break;
      }
    case SLASHASSIGN:{
      jj_consume_token(SLASHASSIGN);
      break;
      }
    case ANDASSIGN:{
      jj_consume_token(ANDASSIGN);
      break;
      }
    case REMASSIGN:{
      jj_consume_token(REMASSIGN);
      break;
      }
    case SHIFTASSIGN:{
      jj_consume_token(SHIFTASSIGN);
      break;
      }
    case BREAK:{
      jj_consume_token(BREAK);
      break;
      }
    case CASE:{
      jj_consume_token(CASE);
      break;
      }
    case CATCH:{
      jj_consume_token(CATCH);
      break;
      }
    case CLASS:{
      jj_consume_token(CLASS);
      break;
      }
    case CONST:{
      jj_consume_token(CONST);
      break;
      }
    case CONTINUE:{
      jj_consume_token(CONTINUE);
      break;
      }
    case _DEFAULT:{
      jj_consume_token(_DEFAULT);
      break;
      }
    case DO:{
      jj_consume_token(DO);
      break;
      }
    case ELSE:{
      jj_consume_token(ELSE);
      break;
      }
    case FALSE:{
      jj_consume_token(FALSE);
      break;
      }
    case FINALLY:{
      jj_consume_token(FINALLY);
      break;
      }
    case FLOAT:{
      jj_consume_token(FLOAT);
      break;
      }
    case FOR:{
      jj_consume_token(FOR);
      break;
      }
    case GOTO:{
      jj_consume_token(GOTO);
      break;
      }
    case IF:{
      jj_consume_token(IF);
      break;
      }
    case IMPLEMENTS:{
      jj_consume_token(IMPLEMENTS);
      break;
      }
    case IMPORT:{
      jj_consume_token(IMPORT);
      break;
      }
    case INSTANCEOF:{
      jj_consume_token(INSTANCEOF);
      break;
      }
    case INT:{
      jj_consume_token(INT);
      break;
      }
    case INTERFACE:{
      jj_consume_token(INTERFACE);
      break;
      }
    case NATIVE:{
      jj_consume_token(NATIVE);
      break;
      }
    case NEW:{
      jj_consume_token(NEW);
      break;
      }
    case MODIFIERS:{
      jj_consume_token(MODIFIERS);
      break;
      }
    case NULL:{
      jj_consume_token(NULL);
      break;
      }
    case PACKAGE:{
      jj_consume_token(PACKAGE);
      break;
      }
    case RETURN:{
      jj_consume_token(RETURN);
      break;
      }
    case SHORT:{
      jj_consume_token(SHORT);
      break;
      }
    case SUPER:{
      jj_consume_token(SUPER);
      break;
      }
    case SWITCH:{
      jj_consume_token(SWITCH);
      break;
      }
    case THIS:{
      jj_consume_token(THIS);
      break;
      }
    case THROW:{
      jj_consume_token(THROW);
      break;
      }
    case TRUE:{
      jj_consume_token(TRUE);
      break;
      }
    case TRY:{
      jj_consume_token(TRY);
      break;
      }
    case TYPE:{
      jj_consume_token(TYPE);
      break;
      }
    case WHILE:{
      jj_consume_token(WHILE);
      break;
      }
    case INTEGER_LITERAL:{
      jj_consume_token(INTEGER_LITERAL);
      break;
      }
    case FLOATING_POINT_LITERAL:{
      jj_consume_token(FLOATING_POINT_LITERAL);
      break;
      }
    case CHARACTER_LITERAL:{
      jj_consume_token(CHARACTER_LITERAL);
      break;
      }
    case STRING_LITERAL:{
      jj_consume_token(STRING_LITERAL);
      break;
      }
    case IDENTIFIER:{
      jj_consume_token(IDENTIFIER);
      break;
      }
    case ASSERT:{
      jj_consume_token(ASSERT);
      break;
      }
    case newLine:{
      jj_consume_token(newLine);
      break;
      }
    case others:{
      jj_consume_token(others);
if (seenNewLine)
        Java.save.println();
      seenNewLine=false;
      Java.toPrint(token.image);
      break;
      }
    default:
      jj_la1[0] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

    static final public void Input() throws ParseException {
        Java.save = new PrintStream(baos);//System.out;

    label_1:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
      case newLine:
      case hashLine:
      case singleLineComment:
      case multiLineComment:
      case formalComment:
      case CONST:
      case GOTO:
      case TYPE:
      case BREAK:
      case CASE:
      case CATCH:
      case CLASS:
      case CONTINUE:
      case _DEFAULT:
      case DO:
      case ELSE:
      case FALSE:
      case FINALLY:
      case FLOAT:
      case FOR:
      case IF:
      case IMPLEMENTS:
      case IMPORT:
      case INSTANCEOF:
      case INT:
      case INTERFACE:
      case NATIVE:
      case NEW:
      case NULL:
      case PACKAGE:
      case RETURN:
      case SHORT:
      case SUPER:
      case SWITCH:
      case THIS:
      case THROW:
      case TRUE:
      case TRY:
      case WHILE:
      case ASSERT:
      case MODIFIERS:
      case IDENTIFIER:
      case INTEGER_LITERAL:
      case FLOATING_POINT_LITERAL:
      case CHARACTER_LITERAL:
      case STRING_LITERAL:
      case LPAREN:
      case RPAREN:
      case LBRACE:
      case RBRACE:
      case LBRACKET:
      case RBRACKET:
      case SEMICOLON:
      case COMMA:
      case DOT:
      case ASSIGN:
      case GT:
      case LT:
      case BANG:
      case TILDE:
      case HOOK:
      case COLON:
      case EQ:
      case LE:
      case GE:
      case NE:
      case SC_OR:
      case SC_AND:
      case INCR:
      case DECR:
      case PLUS:
      case MINUS:
      case STAR:
      case SLASH:
      case BIT_AND:
      case BIT_OR:
      case XOR:
      case REM:
      case SHIFT:
      case PLUSASSIGN:
      case MINUSASSIGN:
      case STARASSIGN:
      case SLASHASSIGN:
      case ANDASSIGN:
      case REMASSIGN:
      case SHIFTASSIGN:
      case others:{
        ;
        break;
        }
      default:
        jj_la1[1] = jj_gen;
        break label_1;
      }
      anyOldLines();
    }
    jj_consume_token(0);
  }

  static private boolean jj_initialized_once = false;
  /** Generated Token Manager. */
  static public JavaTokenManager token_source;
  static JavaCharStream jj_input_stream;
  /** Current token. */
  static public Token token;
  /** Next token. */
  static public Token jj_nt;
  static private int jj_ntk;
  static private int jj_gen;
  static final private int[] jj_la1 = new int[2];
  static private int[] jj_la1_0;
  static private int[] jj_la1_1;
  static private int[] jj_la1_2;
  static private int[] jj_la1_3;
  static {
      jj_la1_init_0();
      jj_la1_init_1();
      jj_la1_init_2();
      jj_la1_init_3();
   }
   private static void jj_la1_init_0() {
      jj_la1_0 = new int[] {0xfffffc3e,0xfffffc3e,};
   }
   private static void jj_la1_init_1() {
      jj_la1_1 = new int[] {0xffa27fff,0xffa27fff,};
   }
   private static void jj_la1_init_2() {
      jj_la1_2 = new int[] {0xffffffff,0xffffffff,};
   }
   private static void jj_la1_init_3() {
      jj_la1_3 = new int[] {0x5,0x5,};
   }

  /** Constructor with InputStream. */
  public Java(InputStream stream) {
     this(stream, null);
  }
  /** Constructor with InputStream and supplied encoding */
  public Java(InputStream stream, String encoding) {
    if (jj_initialized_once) {
      System.out.println("ERROR: Second call to constructor of static parser.  ");
      System.out.println("       You must either use ReInit() or set the JavaCC option STATIC to false");
      System.out.println("       during parser generation.");
      throw new Error();
    }
    jj_initialized_once = true;
     jj_input_stream = new JavaCharStream(stream, 1, 1);
    token_source = new JavaTokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 2; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  static public void ReInit(InputStream stream) {
     ReInit(stream, (String) null);
  }
  /** Reinitialise. */
  static public void ReInit(InputStream stream, String encoding) {
    jj_input_stream.ReInit(stream, 1, 1);
    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 2; i++) jj_la1[i] = -1;
  }

  /** Constructor. */
  public Java(Reader stream) {
    if (jj_initialized_once) {
      System.out.println("ERROR: Second call to constructor of static parser. ");
      System.out.println("       You must either use ReInit() or set the JavaCC option STATIC to false");
      System.out.println("       during parser generation.");
      throw new Error();
    }
    jj_initialized_once = true;
    jj_input_stream = new JavaCharStream(stream, 1, 1);
    token_source = new JavaTokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 2; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  static public void ReInit(Reader stream) {
    jj_input_stream.ReInit(stream, 1, 1);
    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 2; i++) jj_la1[i] = -1;
  }

  /** Constructor with generated Token Manager. */
  public Java(JavaTokenManager tm) {
    if (jj_initialized_once) {
      System.out.println("ERROR: Second call to constructor of static parser. ");
      System.out.println("       You must either use ReInit() or set the JavaCC option STATIC to false");
      System.out.println("       during parser generation.");
      throw new Error();
    }
    jj_initialized_once = true;
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 2; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  public void ReInit(JavaTokenManager tm) {
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 2; i++) jj_la1[i] = -1;
  }

  static private Token jj_consume_token(int kind) throws ParseException {
    Token oldToken;
    if ((oldToken = token).next != null) token = token.next;
    else token = token.next = token_source.getNextToken();
    jj_ntk = -1;
    if (token.kind == kind) {
      jj_gen++;
      return token;
    }
    token = oldToken;
    jj_kind = kind;
    throw generateParseException();
  }


/** Get the next Token. */
  static final public Token getNextToken() {
    if (token.next != null) token = token.next;
    else token = token.next = token_source.getNextToken();
    jj_ntk = -1;
    jj_gen++;
    return token;
  }

/** Get the specific Token. */
  static final public Token getToken(int index) {
    Token t = token;
    for (int i = 0; i < index; i++) {
      if (t.next != null) t = t.next;
      else t = t.next = token_source.getNextToken();
    }
    return t;
  }

  static private int jj_ntk_f() {
    if ((jj_nt=token.next) == null)
      return (jj_ntk = (token.next=token_source.getNextToken()).kind);
    else
      return (jj_ntk = jj_nt.kind);
  }

  static private java.util.List<int[]> jj_expentries = new java.util.ArrayList<int[]>();
  static private int[] jj_expentry;
  static private int jj_kind = -1;

  /** Generate ParseException. */
  static public ParseException generateParseException() {
    jj_expentries.clear();
    boolean[] la1tokens = new boolean[99];
    if (jj_kind >= 0) {
      la1tokens[jj_kind] = true;
      jj_kind = -1;
    }
    for (int i = 0; i < 2; i++) {
      if (jj_la1[i] == jj_gen) {
        for (int j = 0; j < 32; j++) {
          if ((jj_la1_0[i] & (1<<j)) != 0) {
            la1tokens[j] = true;
          }
          if ((jj_la1_1[i] & (1<<j)) != 0) {
            la1tokens[32+j] = true;
          }
          if ((jj_la1_2[i] & (1<<j)) != 0) {
            la1tokens[64+j] = true;
          }
          if ((jj_la1_3[i] & (1<<j)) != 0) {
            la1tokens[96+j] = true;
          }
        }
      }
    }
    for (int i = 0; i < 99; i++) {
      if (la1tokens[i]) {
        jj_expentry = new int[1];
        jj_expentry[0] = i;
        jj_expentries.add(jj_expentry);
      }
    }
    int[][] exptokseq = new int[jj_expentries.size()][];
    for (int i = 0; i < jj_expentries.size(); i++) {
      exptokseq[i] = jj_expentries.get(i);
    }
    return new ParseException(token, exptokseq, tokenImage);
  }

  /** Enable tracing. */
  static final public void enable_tracing() {
  }

  /** Disable tracing. */
  static final public void disable_tracing() {
  }

}

