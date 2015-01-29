package by.bsu.project.antlr.lang;

import org.antlr.runtime.CharStream;
import org.antlr.runtime.Lexer;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.RecognizerSharedState;

/**
 * User: iason
 * Date: 29.01.15
 */
public class LangLexer extends Lexer {
    public LangLexer() {
    }

    public LangLexer(CharStream input) {
        super(input);
    }

    public LangLexer(CharStream input, RecognizerSharedState state) {
        super(input, state);
    }

    @Override
    public void mTokens() throws RecognitionException {
    }
}
