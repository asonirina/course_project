package by.bsu.project.javacc.parser.white;

import by.bsu.project.javacc.general.ParseException;
import by.bsu.project.javacc.general.SimpleCharStream;
import by.bsu.project.javacc.model.Token;

import java.io.*;

public class White implements WhiteConstants {
    static PrintStream save;
    static File outputFile = null;
    static int lineNo = 1;

    static void ReInit(InputStream is, File f) {
        White.ReInit(is);
        White.outputFile = f;
        White.lineNo = 1;
    }

    public static void main(String args[]) throws ParseException {
        White parser = new White(System.in);
        parser.Input();
    }

    static final public void anyOldLines() throws ParseException {
        switch ((jj_ntk == -1) ? jj_ntk_f() : jj_ntk) {
            case hashLine: {
                jj_consume_token(hashLine);
                lineNo = Integer.parseInt(getToken(0).image);
                // The newLine after will incorrectly add 1 to the line count, so correct this in advance.
                // Must remember, the number refers to the original number of the *following* line.
                lineNo--;
                break;
            }
            case space: {
                jj_consume_token(space);
                save.print("<space>");
                break;
            }
            case tab: {
                jj_consume_token(tab);
                save.print("<tab>");
                break;
            }
            case newLine: {
                jj_consume_token(newLine);
                save.print("<new_line>");

                lineNo++;
                break;
            }
            case others: {
                jj_consume_token(others);

                break;
            }
            default:
                jj_la1[0] = jj_gen;
                jj_consume_token(-1);
                throw new ParseException();
        }
    }

    static final public void Input() throws ParseException {
        try {
            if (outputFile != null)
                save = new PrintStream(new FileOutputStream(outputFile));
            else
                save = System.out;
        } catch (IOException e) {
            return;
        }
        label_1:
        while (true) {
            switch ((jj_ntk == -1) ? jj_ntk_f() : jj_ntk) {
                case hashLine:
                case newLine:
                case space:
                case tab:
                case others: {
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
        save.flush();
        save.close();
    }

    static private boolean jj_initialized_once = false;

    static public WhiteTokenManager token_source;
    static SimpleCharStream jj_input_stream;
    static public Token token;

    static public Token jj_nt;
    static private int jj_ntk;
    static private int jj_gen;
    static final private int[] jj_la1 = new int[2];
    static private int[] jj_la1_0;

    static {
        jj_la1_init_0();
    }

    private static void jj_la1_init_0() {
        jj_la1_0 = new int[]{0x3e, 0x3e,};
    }

    /**
     * Constructor with InputStream.
     */
    public White(java.io.InputStream stream) {
        this(stream, null);
    }

    public White(java.io.InputStream stream, String encoding) {
        if (jj_initialized_once) {
            throw new Error("Second call to constructor of static parser");
        }
        jj_initialized_once = true;
        try {
            jj_input_stream = new SimpleCharStream(stream, encoding, 1, 1);
        } catch (java.io.UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
        token_source = new WhiteTokenManager(jj_input_stream);
        token = new Token();
        jj_ntk = -1;
        jj_gen = 0;
        for (int i = 0; i < 2; i++) jj_la1[i] = -1;
    }

    static public void ReInit(java.io.InputStream stream) {
        ReInit(stream, (String) null);
    }

    static public void ReInit(java.io.InputStream stream, String encoding) {
        try {
            jj_input_stream.ReInit(stream, encoding, 1, 1);
        } catch (java.io.UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
        token_source.ReInit(jj_input_stream);
        token = new Token();
        jj_ntk = -1;
        jj_gen = 0;
        for (int i = 0; i < 2; i++) jj_la1[i] = -1;
    }

    public White(java.io.Reader stream) {
        if (jj_initialized_once) {
            throw new Error("Second call to constructor of static parser");
        }
        jj_initialized_once = true;
        jj_input_stream = new SimpleCharStream(stream, 1, 1);
        token_source = new WhiteTokenManager(jj_input_stream);
        token = new Token();
        jj_ntk = -1;
        jj_gen = 0;
        for (int i = 0; i < 2; i++) jj_la1[i] = -1;
    }

    static public void ReInit(java.io.Reader stream) {
        jj_input_stream.ReInit(stream, 1, 1);
        token_source.ReInit(jj_input_stream);
        token = new Token();
        jj_ntk = -1;
        jj_gen = 0;
        for (int i = 0; i < 2; i++) jj_la1[i] = -1;
    }

    public White(WhiteTokenManager tm) {
        if (jj_initialized_once) {
            throw new Error("Second call to constructor of static parser");
        }
        jj_initialized_once = true;
        token_source = tm;
        token = new Token();
        jj_ntk = -1;
        jj_gen = 0;
        for (int i = 0; i < 2; i++) jj_la1[i] = -1;
    }

    public void ReInit(WhiteTokenManager tm) {
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

    static final public Token getNextToken() {
        if (token.next != null) token = token.next;
        else token = token.next = token_source.getNextToken();
        jj_ntk = -1;
        jj_gen++;
        return token;
    }

    static final public Token getToken(int index) {
        Token t = token;
        for (int i = 0; i < index; i++) {
            if (t.next != null) t = t.next;
            else t = t.next = token_source.getNextToken();
        }
        return t;
    }

    static private int jj_ntk_f() {
        if ((jj_nt = token.next) == null)
            return (jj_ntk = (token.next = token_source.getNextToken()).kind);
        else
            return (jj_ntk = jj_nt.kind);
    }

    static private java.util.List<int[]> jj_expentries = new java.util.ArrayList<int[]>();
    static private int[] jj_expentry;
    static private int jj_kind = -1;

    static public ParseException generateParseException() {
        jj_expentries.clear();
        boolean[] la1tokens = new boolean[6];
        if (jj_kind >= 0) {
            la1tokens[jj_kind] = true;
            jj_kind = -1;
        }
        for (int i = 0; i < 2; i++) {
            if (jj_la1[i] == jj_gen) {
                for (int j = 0; j < 32; j++) {
                    if ((jj_la1_0[i] & (1 << j)) != 0) {
                        la1tokens[j] = true;
                    }
                }
            }
        }
        for (int i = 0; i < 6; i++) {
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

    static final public void enable_tracing() {
    }

    static final public void disable_tracing() {
    }
}
