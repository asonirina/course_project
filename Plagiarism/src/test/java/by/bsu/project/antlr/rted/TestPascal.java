package by.bsu.project.antlr.rted;

import by.bsu.project.antlr.model.TreeNode;
import by.bsu.project.antlr.tree.BaseParser;
import by.bsu.project.antlr.tree.PascalTreeParser;
import by.bsu.project.general.lang.LangWrap;
import org.apache.commons.io.IOUtils;

import java.io.FileInputStream;
import java.util.List;

/**
 * User: iason
 * Date: 09.02.15
 */
public class TestPascal {
    public static void main(String[] args) throws Exception{
        byte bytes[] = IOUtils.toByteArray(new FileInputStream("test-distance-trees/123/Test.pas"));
        BaseParser helper1 = new PascalTreeParser(LangWrap.Lang.PASCAL, true);
        List<TreeNode> nodes = helper1.getTree(bytes);
    }
}
