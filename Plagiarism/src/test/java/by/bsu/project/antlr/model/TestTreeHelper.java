package by.bsu.project.antlr.model;

import by.bsu.project.antlr.lang.LangFactory;
import by.bsu.project.antlr.tree.BaseParser;
import by.bsu.project.general.lang.LangWrap.Lang;
import by.bsu.project.antlr.util.*;
import org.apache.commons.io.IOUtils;

import java.io.FileInputStream;
import java.util.List;

/**
 * User: iason
 * Date: 27.01.15
 */
public class TestTreeHelper {
    public static void main(String[] args) throws Exception{
        byte bytes1[] = IOUtils.toByteArray(new FileInputStream("test-distance-trees/Test1.pas"));
        byte bytes2[] = IOUtils.toByteArray(new FileInputStream("test-distance-trees/Test2.pas"));
        BaseParser helper1 = LangFactory.createParser(Lang.PASCAL);
        List<TreeNode> nodes1 = helper1.getTree(bytes1);
        BaseParser helper2 = LangFactory.createParser(Lang.PASCAL);
        List<TreeNode> nodes2 = helper2.getTree(bytes2);
        NodeDistance nd = new TreeNodeDistance();
        TreeEditDistance d = new TreeEditDistance(nd, nodes1, nodes2);
        double h = d.calculate();
        System.out.println(h);
    }
}
