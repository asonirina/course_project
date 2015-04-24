package by.bsu.project.javacc.util;

import by.bsu.project.general.lang.LangWrap;
import by.bsu.project.javacc.JavaCCParser;
import by.bsu.project.javacc.parser.cpp.CPP;
import by.bsu.project.javacc.parser.java.Java;
import by.bsu.project.javacc.parser.pascal.JPascal;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;

/**
 * User: iason
 * Date: 24.04.15
 */
public class JavaCCNodesExtractor {
    public static List<String> getNodes(byte[] source, LangWrap.Lang lang) throws Exception{
        JavaCCParser parser = createParser(new ByteArrayInputStream(source), lang);
        parser.Input();
        return parser.getNodes();
    }

    private static JavaCCParser createParser(InputStream in, LangWrap.Lang lang) throws Exception{
        if (lang.equals(LangWrap.Lang.JAVA)) {
                return new Java(in);
        } else   if (lang.equals(LangWrap.Lang.CPP)) {
            return new CPP(in);
        }  else         if (lang.equals(LangWrap.Lang.PASCAL)) {
            return new JPascal(in);
        }
        throw new Exception("Use C++, Java, Pascal");
    }
}
