package by.bsu.project.antlr.parser.java;

import by.bsu.project.antlr.model.TreeNode;
import org.antlr.runtime.*;
import org.antlr.runtime.tree.CommonTree;
import org.antlr.runtime.tree.CommonTreeAdaptor;
import org.antlr.runtime.tree.TreeAdaptor;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

public class TestJava {
    static final TreeAdaptor adaptor = new CommonTreeAdaptor() {
        public Object create(Token payload) {
            if (payload != null)
            {
//                System.out.println("Create " + JavaParser.tokenNames[payload.getType()] + ":  L" + payload.getLine() + ":C" + payload.getCharPositionInLine() + " " + payload.getText());
            }
            return new CommonTree(payload);
        }
    };

    static List<TreeNode> nodes = new ArrayList<TreeNode>();

    public void printTree(CommonTree t, int indent) {
        System.out.println(t.toString());
        printTreeHelper(t, indent);
    }

    private void printTreeHelper(CommonTree t, int indent) {
        if (t != null) {
            StringBuffer sb = new StringBuffer(indent);
            for (int i = 0; i <indent; i++)
            sb = sb.append("___");
            for (int i = 0; i < t.getChildCount(); i++) {
                System.out.println(sb.toString() + t.getChild(i).toString()
                        + " [" + JavaParser.tokenNames[t.getChild(i).getType()]
                        + "]");
               // TreeNode child = new TreeNode(t.getChild(i).getType()+" "+t.getChild(i).getText(), node);
               // nodes.add(child);
                printTreeHelper((CommonTree) t.getChild(i), indent + 1);
            }
        }
    }


    public void printTree1(CommonTree t, int indent) {
     //   System.out.println(t.toString());

        printTreeHelper1(t, indent);
    }

    private void printTreeHelper1(CommonTree t, int indent) {
        if (t != null) {
            StringBuffer sb = new StringBuffer(indent);
            for (int i = 0; i <indent; i++)
                sb = sb.append("___");
            for (int i = 0; i < t.getChildCount(); i++) {
                System.out.println(sb.toString() + t.getChild(i).getType()+" "+t.getChild(i).toString()
                        + " [" + JavaParser.tokenNames[t.getChild(i).getType()]
                        + "]");

                printTreeHelper1((CommonTree) t.getChild(i), indent + 1);
            }
        }
    }
    public static void main(String[] args) throws Exception {

        TestJava d = new TestJava();
        ANTLRInputStream in = new ANTLRInputStream(new FileInputStream("test/Test.java"));
        JavaLexer lexer = new JavaLexer(in);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        JavaParser parser = new JavaParser(tokens);

        parser.setTreeAdaptor(adaptor);


        CommonTree tree = (CommonTree)parser.compilationUnit().getTree();

        d.printTree(tree, 1);

            System.out.println("---------------------------------------------------------------------------------") ;
        d.printTree1(tree, 1);

    }
}