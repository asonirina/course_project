package by.bsu.project.antlr.rted;

import by.bsu.project.antlr.model.TreeNode;
import by.bsu.project.antlr.tree.TreeParser;
import by.bsu.project.antlr.util.OrderComparator;
import by.bsu.project.antlr.util.TreeEditDistance;
import by.bsu.project.general.lang.LangWrap;
import org.apache.commons.io.IOUtils;

import java.io.FileInputStream;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * User: iason
 * Date: 09.02.15
 */
public class TestCPP {
    public static void main(String[] args) throws Exception{
        byte bytes[] = IOUtils.toByteArray(new FileInputStream("test-distance-trees/123/Test.cpp"));
        TreeParser helper = new TreeParser(LangWrap.Lang.CPP, true);
        List<TreeNode> nodes = helper.getTree(bytes);
    }
}
