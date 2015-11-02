package by.bsu.project.antlr.parser.java;

import by.bsu.project.antlr.lang.LangFactory;
import by.bsu.project.antlr.tree.BaseParser;
import by.bsu.project.general.lang.LangWrap.Lang;
import by.bsu.project.antlr.model.TreeNode;
import org.apache.commons.io.IOUtils;

import java.io.FileInputStream;
import java.util.List;

/**
 * User: iason
 * Date: 29.01.15
 */
public class TreeJavaTest {
    public static void main(String[] args) throws Exception{
        byte bytes1[] = IOUtils.toByteArray(new FileInputStream("test/Test.java"));
        BaseParser helper1 = LangFactory.createParser(Lang.JAVA);
        List<TreeNode> nodes1 = helper1.getTree(bytes1);
    }
}
