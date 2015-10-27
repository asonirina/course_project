package by.bsu.project.antlr.lang;

import by.bsu.project.general.lang.LangWrap.Lang;
import by.bsu.project.antlr.parser.cpp.CPPGrammarLexer;
import by.bsu.project.antlr.parser.cpp.CPPGrammarParser;
import by.bsu.project.antlr.parser.java.JavaLexer;
import by.bsu.project.antlr.parser.java.JavaParser;
import by.bsu.project.antlr.parser.pascal.PascalLexer;
import by.bsu.project.antlr.parser.pascal.PascalParser;
import org.antlr.runtime.CharStream;
import org.antlr.runtime.CommonTokenStream;

/**
 * User: iason
 * Date: 29.01.15
 */
public class LangFactory {
    Lang lang;
    public LangFactory(Lang lang) {
       this.lang = lang;
    }

    public LangParser createParser(CommonTokenStream tokens) {
        switch (lang) {
            case JAVA:
                return new JavaParser(tokens);
            case CPP:
                return new CPPGrammarParser(tokens);
            case PASCAL:
                return new PascalParser(tokens);
            default:
                return null;
        }
    }

    public LangLexer createLexer(CharStream in) {
        switch (lang) {
            case JAVA:
                return new JavaLexer(in);
            case CPP:
                return new CPPGrammarLexer(in);
            case PASCAL:
                return new PascalLexer(in);
            default:
                return null;
        }
    }
}
