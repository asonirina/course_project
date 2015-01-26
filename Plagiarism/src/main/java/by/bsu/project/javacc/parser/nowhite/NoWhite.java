package by.bsu.project.javacc.parser.nowhite;

import by.bsu.project.javacc.general.ParseException;
import by.bsu.project.javacc.general.SimpleCharStream;
import by.bsu.project.javacc.model.Token;
import by.bsu.project.javacc.settings.Settings;

import java.io.*;
import java.util.Date;

public class NoWhite implements NoWhiteConstants {

  /**
   * The stream used to save the output file.
   */
  static PrintStream save;

  /**
   * The new file containing the output of this tokeniser.
   */
  static File outputFile = null;

  /**
   * Keep track of the line number from the file read in. Used to print #line xxx in the outputFile.
   */
  static int lineNo = 1;

  /**
   * If true, then have not encountered any non-whitespace characters (newLine, space, tab) on this line
   * so far, so don't print any whitespace characters yet.
   * If false, then have found some non-whitespace characters, so can safely print whitespace characters.
   */
  static boolean atStartOfLine = true;

  /**
   * If true then we have skipped a line because it was blank and should print #line xxx before continuing.
   */
  static boolean justSkippedALine = false;

  /**
   * Reinitialise all the variables, and get on with parsing the whatever's in the input stream.
   *
   * @param is - the input stream to parse.
   * @param f - the file to save the results of this tokeniser to.
   */
  public static void ReInit(InputStream is, File f) {
    // Don't need to reinitialise the PrintStream, it's done for us.
    NoWhite.ReInit(is);
    NoWhite.outputFile = f;
    NoWhite.lineNo=1;
    NoWhite.atStartOfLine = true;
    NoWhite.justSkippedALine = false;
  } // ReInit


  /**
   * Print the current line number into the new file - if we have just skipped a line.
   */
  static void printLineNo() {
    if (justSkippedALine) {
      save.println("#line " + lineNo);
      justSkippedALine = false;
    }
  } // printLineNo


  public static void main(String args[]) throws ParseException {
    NoWhite parser = new NoWhite(System.in);
    parser.Input();
  }

  static final public void anyOldLines() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
    case hashLine:{
      jj_consume_token(hashLine);
      jj_consume_token(number);
lineNo = Integer.parseInt(getToken(0).image);
    // The newLine after will incorrectly add 1 to the line count, so correct this in advance.
    // Must remember, the number refers to the original number of the *following* line.
    lineNo--;
      break;
      }
    case space:
    case tab:{
      switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
      case space:{
        jj_consume_token(space);
        break;
        }
      case tab:{
        jj_consume_token(tab);
        break;
        }
      default:
        jj_la1[0] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
if (!atStartOfLine)
      save.print(" ");
      break;
      }
    case newLine:{
      jj_consume_token(newLine);
if (!atStartOfLine) {
      save.println();
      atStartOfLine = true;
    }
    else {
      justSkippedALine = true;
    }
    lineNo++;
      break;
      }
    case number:
    case others:{
      switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
      case others:{
        jj_consume_token(others);
        break;
        }
      case number:{
        jj_consume_token(number);
        break;
        }
      default:
        jj_la1[1] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
//printLineNo();
    save.print(token.image);
    atStartOfLine = false;
      break;
      }
    default:
      jj_la1[2] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  static final public void Input() throws ParseException {try {
    if (outputFile!=null)
      save = new PrintStream(new FileOutputStream(outputFile));
    else
      save = System.out;
  } catch (IOException e) {
      Date day = new Date(System.currentTimeMillis());
      if (outputFile != null) {
        try {
            String file = new String
                (System.getProperty("user.home") + Settings.fileSep
                 + "sherlock.log");
            BufferedWriter bw = new BufferedWriter
                (new FileWriter(file, true));
            bw.write(day + "-" + "Cannot write to: "
                     + outputFile.getAbsolutePath());
            bw.newLine();
            bw.close();
        }
        catch (IOException e2) {
            if (outputFile != null)
                System.err.println(day + "-" + "Cannot write to: "
                                   + outputFile.getAbsolutePath());
        }
      }
      else System.err.println(day + "-" + "Cannot write to System.out");
      return;
  }
    label_1:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
      case hashLine:
      case number:
      case newLine:
      case space:
      case tab:
      case others:{
        ;
        break;
        }
      default:
        jj_la1[3] = jj_gen;
        break label_1;
      }
      anyOldLines();
    }
    jj_consume_token(0);
    save.flush();
    save.close();
  }

  static private boolean jj_initialized_once = false;
  /** Generated Token Manager. */
  static public NoWhiteTokenManager token_source;
  static SimpleCharStream jj_input_stream;
  /** Current token. */
  static public Token token;
  /** Next token. */
  static public Token jj_nt;
  static private int jj_ntk;
  static private int jj_gen;
  static final private int[] jj_la1 = new int[4];
  static private int[] jj_la1_0;
  static {
      jj_la1_init_0();
   }
   private static void jj_la1_init_0() {
      jj_la1_0 = new int[] {0x30,0x44,0x7e,0x7e,};
   }

  /** Constructor with InputStream. */
  public NoWhite(InputStream stream) {
     this(stream, null);
  }
  /** Constructor with InputStream and supplied encoding */
  public NoWhite(InputStream stream, String encoding) {
    if (jj_initialized_once) {
      System.out.println("ERROR: Second call to constructor of static parser.  ");
      System.out.println("       You must either use ReInit() or set the JavaCC option STATIC to false");
      System.out.println("       during parser generation.");
      throw new Error();
    }
    jj_initialized_once = true;
    try { jj_input_stream = new SimpleCharStream(stream, encoding, 1, 1);

    } catch(UnsupportedEncodingException e) { throw new RuntimeException(e); }
    token_source = new NoWhiteTokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 4; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  static public void ReInit(InputStream stream) {
     ReInit(stream, (String)null);
  }
  /** Reinitialise. */
  public static  void ReInit(InputStream stream, String encoding) {
    try { jj_input_stream.ReInit(stream, encoding, 1, 1); } catch(UnsupportedEncodingException e) { throw new RuntimeException(e); }
    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 4; i++) jj_la1[i] = -1;
  }

  /** Constructor. */
  public NoWhite(Reader stream) {
    if (jj_initialized_once) {
      System.out.println("ERROR: Second call to constructor of static parser. ");
      System.out.println("       You must either use ReInit() or set the JavaCC option STATIC to false");
      System.out.println("       during parser generation.");
      throw new Error();
    }
    jj_initialized_once = true;
    jj_input_stream = new SimpleCharStream(stream, 1, 1);
    token_source = new NoWhiteTokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 4; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  static public void ReInit(Reader stream) {
    jj_input_stream.ReInit(stream, 1, 1);
    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 4; i++) jj_la1[i] = -1;
  }

  /** Constructor with generated Token Manager. */
  public NoWhite(NoWhiteTokenManager tm) {
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
    for (int i = 0; i < 4; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  public void ReInit(NoWhiteTokenManager tm) {
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 4; i++) jj_la1[i] = -1;
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
    boolean[] la1tokens = new boolean[7];
    if (jj_kind >= 0) {
      la1tokens[jj_kind] = true;
      jj_kind = -1;
    }
    for (int i = 0; i < 4; i++) {
      if (jj_la1[i] == jj_gen) {
        for (int j = 0; j < 32; j++) {
          if ((jj_la1_0[i] & (1<<j)) != 0) {
            la1tokens[j] = true;
          }
        }
      }
    }
    for (int i = 0; i < 7; i++) {
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