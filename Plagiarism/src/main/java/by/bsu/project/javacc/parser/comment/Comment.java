package by.bsu.project.javacc.parser.comment;

import by.bsu.project.javacc.general.ParseException;
import by.bsu.project.javacc.general.SimpleCharStream;
import by.bsu.project.javacc.model.Token;

import java.io.*;

public class Comment implements CommentConstants {

    int lineNo = 1;

    public static void main(String args[]) throws ParseException {
        Comment parser = new Comment(new ByteArrayInputStream(("//123\n" +
                "/*qwe qwre*/" +
                "//124 bdgg bbbb\n" +
                "dfg dfgg vv").getBytes()));
        parser.Input();
        System.out.println(parser.getCommentLength());
    }

    public int getCommentLength() {
        return token_source.getCommonCommentLength();
    }
    public void anyOldLines() throws ParseException {
        switch ((jj_ntk == -1) ? jj_ntk_f() : jj_ntk) {
            case singleLineComment: {
                jj_consume_token(singleLineComment);
                break;
            }
            case formalComment: {
                jj_consume_token(formalComment);
                break;
            }
            case multiLineComment: {
                jj_consume_token(multiLineComment);
                break;
            }
            case hashLine: {
                jj_consume_token(hashLine);
                jj_consume_token(number);
                lineNo = Integer.parseInt(getToken(0).image);
                // The newLine after will incorrectly add 1 to the line count, so correct this in advance.
                // Must remember, the number refers to the original number of the *following* line.
                lineNo--;
                break;
            }
            case newLine: {
                jj_consume_token(newLine);
                lineNo++;
                break;
            }
            case number: {
                jj_consume_token(number);
                break;
            }
            case word: {
                jj_consume_token(word);
                break;
            }
            case space: {
                jj_consume_token(space);
                break;
            }
            case character_literal: {
                jj_consume_token(character_literal);
                break;
            }
            case string_literal: {
                jj_consume_token(string_literal);
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
                case singleLineComment:
                case formalComment:
                case multiLineComment:
                case newLine:
                case hashLine:
                case number:
                case word:
                case space:
                case others:
                case character_literal:
                case string_literal: {
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

    public CommentTokenManager token_source;
    SimpleCharStream jj_input_stream;

    public Token token;

    public Token jj_nt;
    private int jj_ntk;
    private int jj_gen;
    final private int[] jj_la1 = new int[2];
    private int[] jj_la1_0;

    private void jj_la1_init_0() {
        jj_la1_0 = new int[]{0xf7862, 0xf7862,};
    }


    public Comment(InputStream stream) {
        this(stream, null);
    }

    public Comment(InputStream stream, String encoding) {
        jj_la1_init_0();
        try {
            jj_input_stream = new SimpleCharStream(stream, encoding, 1, 1);
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
        token_source = new CommentTokenManager(jj_input_stream);
        token = new Token();
        jj_ntk = -1;
        jj_gen = 0;
        for (int i = 0; i < 2; i++) jj_la1[i] = -1;
    }

    public void ReInit(InputStream stream) {
        ReInit(stream, null);
    }


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
        for (int i = 0; i < 2; i++) jj_la1[i] = -1;
    }

    public Comment(Reader stream) {
        jj_input_stream = new SimpleCharStream(stream, 1, 1);
        token_source = new CommentTokenManager(jj_input_stream);
        token = new Token();
        jj_ntk = -1;
        jj_gen = 0;
        for (int i = 0; i < 2; i++) jj_la1[i] = -1;
    }

    public void ReInit(Reader stream) {
        jj_input_stream.ReInit(stream, 1, 1);
        token_source.ReInit(jj_input_stream);
        token = new Token();
        jj_ntk = -1;
        jj_gen = 0;
        for (int i = 0; i < 2; i++) jj_la1[i] = -1;
    }

    /**
     * Constructor with generated Token Manager.
     */
    public Comment(CommentTokenManager tm) {
        token_source = tm;
        token = new Token();
        jj_ntk = -1;
        jj_gen = 0;
        for (int i = 0; i < 2; i++) jj_la1[i] = -1;
    }

    public void ReInit(CommentTokenManager tm) {
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


    public Token getNextToken() {
        if (token.next != null) token = token.next;
        else token = token.next = token_source.getNextToken();
        jj_ntk = -1;
        jj_gen++;
        return token;
    }

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

    public ParseException generateParseException() {
        jj_expentries.clear();
        boolean[] la1tokens = new boolean[20];
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
        for (int i = 0; i < 20; i++) {
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
}
