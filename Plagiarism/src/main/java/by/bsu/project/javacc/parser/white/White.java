package by.bsu.project.javacc.parser.white;

import by.bsu.project.javacc.general.ParseException;
import by.bsu.project.javacc.general.SimpleCharStream;
import by.bsu.project.javacc.model.Token;

import java.io.ByteArrayInputStream;

public class White implements WhiteConstants {
    private int lineNo = 1;
    private int spaces = 0;
    private int tabs = 0;

    public static void main(String args[]) throws ParseException {
        White parser = new White(new ByteArrayInputStream("   ".getBytes()));
        parser.Input();
    }

     public void anyOldLines() throws ParseException {
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
                spaces++;
                break;
            }
            case tab: {
                jj_consume_token(tab);
                tabs++;
                break;
            }
            case newLine: {
                jj_consume_token(newLine);
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

    public void Input() throws ParseException {
        label_1:
        while (true) {
            switch ((jj_ntk == -1) ? jj_ntk_f() : jj_ntk) {
                case hashLine:
                case newLine:
                case space:
                case tab:
                case others: {
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

    public WhiteTokenManager token_source;
    SimpleCharStream jj_input_stream;
    public Token token;

    public Token jj_nt;
    private int jj_ntk;
    private int jj_gen;
    final private int[] jj_la1 = new int[2];
    private int[] jj_la1_0;

    private void jj_la1_init_0() {
        jj_la1_0 = new int[]{0x3e, 0x3e,};
    }

    public White(java.io.InputStream stream) {
        this(stream, null);
    }

    private White(java.io.InputStream stream, String encoding) {
        jj_la1_init_0();
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

    public void ReInit(java.io.InputStream stream) {
        ReInit(stream, (String) null);
    }

    public void ReInit(java.io.InputStream stream, String encoding) {
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
        jj_input_stream = new SimpleCharStream(stream, 1, 1);
        token_source = new WhiteTokenManager(jj_input_stream);
        token = new Token();
        jj_ntk = -1;
        jj_gen = 0;
        for (int i = 0; i < 2; i++) jj_la1[i] = -1;
    }

    public void ReInit(java.io.Reader stream) {
        jj_input_stream.ReInit(stream, 1, 1);
        token_source.ReInit(jj_input_stream);
        token = new Token();
        jj_ntk = -1;
        jj_gen = 0;
        for (int i = 0; i < 2; i++) jj_la1[i] = -1;
    }

//    public White(WhiteTokenManager tm) {
//        token_source = tm;
//        token = new Token();
//        jj_ntk = -1;
//        jj_gen = 0;
//        for (int i = 0; i < 2; i++) jj_la1[i] = -1;
//    }

    public void ReInit(WhiteTokenManager tm) {
        token_source = tm;
        token = new Token();
        jj_ntk = -1;
        jj_gen = 0;
        for (int i = 0; i < 2; i++) jj_la1[i] = -1;
    }

    private Token jj_consume_token(int kind) throws ParseException {
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

    final public Token getNextToken() {
        if (token.next != null) token = token.next;
        else token = token.next = token_source.getNextToken();
        jj_ntk = -1;
        jj_gen++;
        return token;
    }

    final public Token getToken(int index) {
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

    public ParseException generateParseException() {
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

    public int getSpaces() {
        return spaces;
    }

    public int getTabs() {
        return tabs;
    }

    public int getLineNo() {
        return lineNo;
    }
}