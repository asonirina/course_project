package by.bsu.project.antlr.model;

import by.bsu.project.general.lang.LangWrap.Lang;
import by.bsu.project.antlr.tree.TreeParser;
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
        byte bytes1[] = IOUtils.toByteArray(new FileInputStream("test-distance-trees/Test3.java"));
        byte bytes2[] = IOUtils.toByteArray(new FileInputStream("test-distance-trees/Test1.java"));
        TreeParser helper1 = new TreeParser("ghj", Lang.JAVA);
        List<TreeNode> nodes1 = helper1.getTree(bytes1);
        TreeParser helper2 = new TreeParser("ghj1", Lang.JAVA);
        List<TreeNode> nodes2 = helper2.getTree(bytes2);
        NodeDistance nd = new CustomNodeDistance();
        TreeEditDistance d = new TreeEditDistance(nd, nodes1, nodes2);
        double h = d.calculate();
        System.out.println(h);
    }
}
