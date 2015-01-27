package by.bsu.project.antlr.model;

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
        byte bytes1[] = IOUtils.toByteArray(new FileInputStream("test/Test.java"));
        byte bytes2[] = IOUtils.toByteArray(new FileInputStream("test/Test1.java"));
        TreeHelper helper1 = new TreeHelper("ghj");
        List<TreeNode> nodes1 = helper1.getTree(bytes1);
        TreeHelper helper2 = new TreeHelper("ghj1");
        List<TreeNode> nodes2 = helper2.getTree(bytes2);
        NodeDistance nd = new NodeDistance() {
            public int rename(TreeNode n1, TreeNode n2) {
                if(n1.getName().equals(n2.getName())) return 0;
                else return 1;
            }
            public int insert(TreeNode n1, TreeNode n2) {
                return 1;
            }
            public int delete(TreeNode n1, TreeNode n2) {
                return 1;
            }
        };
        TreeEditDistance d = new TreeEditDistance(nd, nodes1, nodes2);
        int h = d.calculate();

    }
}
