package by.bsu.project.antlr.rted;

import by.bsu.project.antlr.model.TreeNode;
import by.bsu.project.antlr.tree.TreeParser;
import by.bsu.project.antlr.util.OrderComparator;
import by.bsu.project.antlr.util.TreeEditDistance;
import by.bsu.project.general.lang.LangWrap;
import org.apache.commons.io.IOUtils;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * User: iason
 * Date: 09.02.15
 */
public class TestRTED {
    public static void main(String[] args) throws Exception{
        byte bytes1[] = IOUtils.toByteArray(new FileInputStream("test-distance-trees/Test1.pas"));
        byte bytes2[] = IOUtils.toByteArray(new FileInputStream("test-distance-trees/Test2.pas"));
        TreeParser helper1 = new TreeParser(LangWrap.Lang.PASCAL);
        List<TreeNode> nodes1 = helper1.getTree(bytes1);
        TreeParser helper2 = new TreeParser(LangWrap.Lang.PASCAL);
        List<TreeNode> nodes2 = helper2.getTree(bytes2);

        TreeEditDistance.numerateTree(nodes1.get(0));
        TreeEditDistance.numerateTree(nodes2.get(0));
        Collections.sort(nodes1, new OrderComparator());
        Collections.sort(nodes2, new OrderComparator());
        RTED c = new RTED();
//        c.init(nodes1, nodes2);
//        c.computeOptimalStrategy();
        System.out.println(c.nonNormalizedTreeDist(nodes1, nodes2));
        LinkedList list = c.computeEditMapping();

    }
}
