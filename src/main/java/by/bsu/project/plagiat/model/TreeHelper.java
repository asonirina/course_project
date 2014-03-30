package by.bsu.project.plagiat.model;

import org.antlr.runtime.ANTLRInputStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.Token;
import org.antlr.runtime.tree.*;
import org.apache.commons.lang.StringUtils;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * User: iason
 * Date: 26.03.14
 */
public class TreeHelper {
    private long h = 0;
    private final TreeAdaptor adaptor = new CommonTreeAdaptor() {
        public Object create(Token payload) {
            return new CommonTree(payload);
        }
    };

    private List<TreeNode> nodes = new ArrayList<>();

    public List<TreeNode> getTree(byte[] bytes) {
        try {
            //ANTLRInputStream in = new ANTLRInputStream(new FileInputStream("D://Test.java"));
            ANTLRInputStream in = new ANTLRInputStream(new ByteArrayInputStream(bytes));
            JavaLexer lexer = new JavaLexer(in);
            CommonTokenStream tokens = new CommonTokenStream(lexer);
            JavaParser parser = new JavaParser(tokens);
            parser.setTreeAdaptor(adaptor);

            CommonTree tree = (CommonTree) parser.compilationUnit().getTree();

            doTree(tree, null);
            return nodes;
        } catch (Exception ex) {
            return null;
        }
    }


    private void doTree(CommonTree t, TreeNode node) {
        if (t != null) {

            switch (t.getType()) {

                case 0: { //root
                    TreeNode root = new TreeNode(h++, "root", null);
                    nodes.add(root);

                    for (int i = 0; i < t.getChildCount(); i++) {
                        doTree((CommonTree) t.getChild(i), root);
                    }
                    break;
                }

                //-----------------------------------------------------------------------
                case 61: { //class node
                    doClass(t, node);
                    break;
                }
                //------------------------------------------------------------------------------
                case 160: { //var declaration
                    doVarDeclaration(t, node);
                    break;
                }

                //----------------------------------------------------------------------------------
                case 163: {  //void method
                    doMethod(t, node);
                    break;
                }
                //----------------------------------------------------------------------------------------
                case 136: {  // method
                    doMethod(t, node);
                    break;
                }
                //------------------------------------------------------------------------------------------
                default: {
                    //skip  it
                    break;
                }
            }

        }
    }

    private void doClass(CommonTree t, TreeNode node) {
        String scope = "";
        String name = "";

        int index = -1;
        for (int i = 0; i < t.getChildCount(); i++) {
            Tree child = t.getChild(i);
            switch (child.getType()) {

                case 145: {  //modifier list
                    if (child.getChildCount() > 0) {
                        scope = child.getChild(0).getText() + " ";
                    }
                    break;
                }
                //------------------------------------------------------------------------
                case 164: {  //identifier
                    name = child.getText();
                    break;
                }
                //------------------------------------------------------------------------------
                case 123: {  //class top level
                    index = i;
                    break;
                }
                //------------------------------------------------------------------------------
                default: {
                    break;
                }
            }
        }
        TreeNode classNode = new TreeNode(h++, scope + "class " + name, node);
        nodes.add(classNode);

        for (int i = 0; i < t.getChild(index).getChildCount(); i++) {
            doTree((CommonTree) t.getChild(index).getChild(i), classNode);
        }

    }

    private void doVarDeclaration(CommonTree t, TreeNode node) {
        String scope = "";
        String type = "";
        String name = "";

        int index = -1;
        for (int i = 0; i < t.getChildCount(); i++) {
            Tree child = t.getChild(i);
            switch (child.getType()) {

                case 145: {  //modifier list
                    if (child.getChildCount() > 0) {
                        scope = child.getChild(0).getText() + " ";
                    }
                    break;
                }
                //--------------------------------------------------------------------
                case 162: {  //var declaration list
                    name = child.getChild(0).getChild(0).getText();
                    break;
                }
                //-------------------------------------------------------------------------------
                case 157: {  //type
                    type = doType((CommonTree) child);
                    break;
                }
                //----------------------------------------------------------------------------------
                default: {
                    break;
                }
            }
        }
        TreeNode classNode = new TreeNode(h++, scope + type + name, node);
        nodes.add(classNode);
    }

    private void doMethod(CommonTree t, TreeNode node) {
        List<String> params = new ArrayList<>();
        String scope = "";
        String name = "";
        String type = "void ";
        int index = -1;

        for (int i = 0; i < t.getChildCount(); i++) {
            Tree child = t.getChild(i);
            switch (child.getType()) {

                case 145: {  //modifier list
                    if (child.getChildCount() > 0) {
                        scope = child.getChild(0).getText() + " ";
                    }
                    break;
                }
                //--------------------------------------------------------------------
                case 157: {  //type
                    type = doType((CommonTree) child);
                    break;
                }
                //--------------------------------------------------------------------------
                case 164: {  //identifier
                    name = child.getText() + " ";
                    break;
                }
                //----------------------------------------------------------------------------
                case 117: {  //block scope
                    index = i;
                    break;
                }
                //---------------------------------------------------------------------------------
                case 133: {   //formal param
                    formalParamList((CommonTree) child, params);
                    break;
                }
                default: {
                    break;
                }
            }
        }
        TreeNode methodNode = new TreeNode(h++, scope + type + name + "(" + StringUtils.join(params, ", ") + ")", node);
        nodes.add(methodNode);

        for (int i = 0; i < t.getChild(index).getChildCount(); i++) {
            doTree((CommonTree) t.getChild(index).getChild(i), methodNode);
        }

    }

    private void formalParamList(CommonTree t, List<String> params) {
        for (int i = 0; i < t.getChildCount(); i++) {
            params.add(formalParam((CommonTree) t.getChild(i)));
        }
    }

    private String formalParam(CommonTree t) {
        String name = "";
        String type = "";
        for (int i = 0; i < t.getChildCount(); i++) {
            Tree child = t.getChild(i);
            switch (child.getType()) {
                case 157: {  //type
                    type = doType((CommonTree) child);
                    break;
                }
                //---------------------------------------------------------------
                case 164: {  //identifier
                    name = child.getText();
                    break;
                }
                //-----------------------------------------------------------------------
                default: {
                    break;
                }

            }
        }
        return type + name;
    }

    private String doType(CommonTree t) {
        String type = "";
        int arr = 0;
        for (int i = 0; i < t.getChildCount(); i++) {
            Tree child = t.getChild(i);
            switch (child.getType()) {

                case 151: {   //custom type
                    type = child.getChild(0).getText();
                    break;
                }
                //----------------------------------------------------------------------
                case 114: {   //array declaration
                    arr = child.getChildCount();
                    break;
                }
                //-------------------------------------------------------------
                case 79: {
                    type = "int";
                    break;
                }
                //---------------------------------------------------------------------------------
                case 65: {
                    type = "double";
                    break;
                }
                default: {
                    break;
                }
            }
        }
        for (int i = 0; i < arr; i++) {
            type += "[]";
        }
        return type + " ";
    }
}
