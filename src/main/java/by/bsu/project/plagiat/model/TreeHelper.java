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

        // int index = -1;

        TreeNode classNode = new TreeNode(h++, "", node);

        for (int i = 0; i < t.getChildCount(); i++) {
            Tree child = t.getChild(i);
            switch (child.getType()) {

                case 164: {  // [IDENT]
                    name = doIdent((CommonTree) child);
                    break;
                }
                //------------------------------------------------------------------------------
                case 123: {  //class top level
                    doClassTopLevelScope((CommonTree) child, classNode);
                    break;
                }
                //------------------------------------------------------------------------------
                default: {
                    break;
                }
            }
        }
        classNode.setName(scope + "class " + name);
        nodes.add(classNode);


    }

    private void doVarDeclaration(CommonTree t, TreeNode node) {
        String scope = "";
        String type = "";
        String name = "";

        TreeNode varDeclarationNode = new TreeNode(h++, "", node);
        for (int i = 0; i < t.getChildCount(); i++) {
            Tree child = t.getChild(i);
            switch (child.getType()) {

                case 162: {  //[VAR_DECLARATOR_LIST]
                    name = doVarDeclaratorList((CommonTree) child, varDeclarationNode);
                    break;
                }
                //-------------------------------------------------------------------------------
                case 157: {  //type
                    type = doType((CommonTree) child);
                    break;
                }
                //----------------------------------------------------------------------------------
                default: {
                }
            }
        }
        varDeclarationNode.setName(scope + type + name);
        nodes.add(varDeclarationNode);
    }

    private String doVarDeclaratorList(CommonTree t, TreeNode node) {
        String name = "";
        for (int i = 0; i < t.getChildCount(); i++) {
            Tree child = t.getChild(i);
            switch (child.getType()) {
                case 161: {  //[VAR_DECLARATOR]
                    name = doVarDeclarator((CommonTree) child, node);
                }

                default: {
                    break;
                }
            }
        }
        return name;
    }

    private String doVarDeclarator(CommonTree t, TreeNode node) {
        String name = "";
        for (int i = 0; i < t.getChildCount(); i++) {
            Tree child = t.getChild(i);
            switch (child.getType()) {
                case 164: {  // [IDENT]
                    name = doIdent((CommonTree) child);
                    break;
                }
                //-------------------------------------------------
                case 126: {
                    doExpr((CommonTree) child, node);
                    break;
                }
                //-------------------------------------------------
                default: {
                    break;
                }
            }
        }
        return name;
    }

    private void doExpr(CommonTree t, TreeNode node) {
        for (int i = 0; i < t.getChildCount(); i++) {
            Tree child = t.getChild(i);
            switch (child.getType()) {
                case 120: { // [CLASS_CONSTRUCTOR_CALL]
                    doConstructorCall((CommonTree) child, node);
                    break;
                }
                case 25: { // [LESS THAN]
                    doBinOperator((CommonTree) child, node, Operation.LESS_THAN);
                    break;
                }
                case 148: { //[POST_INC]
                    doPostInc((CommonTree) child, node);
                    break;
                }

                case 147: { //[POST_DEC]
                    doPostDec((CommonTree) child, node);
                    break;
                }

                case 167: {  // [DECIMAL_LITERAL]
                    doDecimalLiteral((CommonTree)child, node);
                   break;
                }

                case 170: {  // [STRING_LITERAL]
                    doStringLiteral((CommonTree)child, node);
                    break;
                }
                case 144: {  //[METHOD_CALL]
                    doMethodCall((CommonTree)child, node);
                   break;
                }

                case 6:{
                    doBinOperator((CommonTree)child, node, Operation.ASSIGN);
                    break;
                }

                case 38: {
                    doBinOperator((CommonTree)child, node, Operation.PLUS);
                            break;
                }

                case 30:{
                    doBinOperator((CommonTree)child, node, Operation.MINUS);
                    break;
                }
                default: {
                    break;
                }

            }
        }
    }

    private void doPostInc(CommonTree t, TreeNode node) {
        String name = "";
        for (int i = 0; i < t.getChildCount(); i++) {
            Tree child = t.getChild(i);
            switch (child.getType()) {
                case 164:{
                    name = doIdent((CommonTree)child);
                }
            }
        }

        TreeNode postInc = new TreeNode(h++, name+"++", node);
        nodes.add(postInc);
    }

    private void doPostDec(CommonTree t, TreeNode node) {
        String name = "";
        for (int i = 0; i < t.getChildCount(); i++) {
            Tree child = t.getChild(i);
            switch (child.getType()) {
                case 164:{
                    name = doIdent((CommonTree)child);
                }
            }
        }

        TreeNode postInc = new TreeNode(h++, name+"--", node);
        nodes.add(postInc);
    }

    private String doBinOperator(CommonTree t, TreeNode node, Operation operation) {
        String arr[] = new String[2];
        TreeNode bin = new TreeNode(h++, "", node);
        for (int i = 0; i < t.getChildCount(); i++) {
            Tree child = t.getChild(i);
            switch (child.getType()) {
                case 164: {
                    arr[i] = doIdent((CommonTree) child);
                    break;
                }

                case 167: {
                    arr[i] = doDecimalLiteral((CommonTree) child);
                    break;
                }

                case 170: {
                    arr[i] = doStringLiteral((CommonTree) child);
                    break;
                }

                case 38: {
                    arr[i] = doBinOperator((CommonTree) child, bin, Operation.PLUS);
                    break;
                }
                case 30: {
                    arr[i] = doBinOperator((CommonTree) child, bin, Operation.MINUS);
                    break;
                }
            }
        }
        bin.setName(arr[0] + operation.getSymbol() + arr[1]);
        nodes.add(bin);
        return bin.getName();
    }
    private String doDecimalLiteral(CommonTree t) {
        return t.getText();
    }

    private void doMethodCall(CommonTree t, TreeNode node) {
        String name = "";
        TreeNode methodCall = new TreeNode(h++, "", node);
        for (int i = 0; i < t.getChildCount(); i++) {
            Tree child = t.getChild(i);
            switch (child.getType()) {
                case 164: {
                    name = doIdent((CommonTree)child);
                    break;
                }
                case 15: {   // [DOT]
                 name = doDot((CommonTree)child);
                    break;
                }

                case 112: {
                    doArgumentList((CommonTree)child, methodCall);
                }
            }
        }
        methodCall.setName(name);
        nodes.add(methodCall);
    }

    private String doDot(CommonTree t) {
        return doIdent((CommonTree)t.getChild(0))+"."+doIdent((CommonTree)t.getChild(1)) ;
    }

    private void doDecimalLiteral(CommonTree t, TreeNode node) {
        TreeNode decimal = new TreeNode(h++, t.getText(), node);
        nodes.add(decimal);
    }

    private void doStringLiteral(CommonTree t, TreeNode node) {
        TreeNode decimal = new TreeNode(h++, t.getText(), node);
        nodes.add(decimal);
    }

    private String doStringLiteral(CommonTree t) {
        return t.getText();
    }

    private void doConstructorCall(CommonTree t, TreeNode node) {
        for (int i = 0; i < t.getChildCount(); i++) {
            Tree child = t.getChild(i);
            switch (child.getType()) {
                case 151: { // [QUALIFIED_TYPE_IDENT]
                    TreeNode constructor = new TreeNode(h++, "new " + doQualifiedTypeIdent((CommonTree) child), node);
                    nodes.add(constructor);
                    break;
                }
                //----------------------------------------------------
                case 112: {
                    doArgumentList((CommonTree) child, node);
                    break;
                }
                //----------------------------------------------------
                default: {
                    break;
                }

            }
        }
    }

    private String doQualifiedTypeIdent(CommonTree t) {
        String name = "";
        for (int i = 0; i < t.getChildCount(); i++) {
            Tree child = t.getChild(i);
            switch (child.getType()) {
                case 164: {// [IDENT]
                    name = doIdent((CommonTree) child);
                }
            }
        }
        return name;
    }

    private void doArgumentList(CommonTree t, TreeNode node) {
        for (int i = 0; i < t.getChildCount(); i++) {
            Tree child = t.getChild(i);
            switch (child.getType()) {
                case 126: {  // [EXPR]
                    doExpr((CommonTree) child, node);
                    break;
                }
                default: {
                    break;
                }

            }
        }
    }

    private void doMethod(CommonTree t, TreeNode node) {
        List<String> params = new ArrayList<>();
        String scope = "";
        String name = "";
        String type = "void ";

        TreeNode methodNode = new TreeNode(h++, "", node);

        for (int i = 0; i < t.getChildCount(); i++) {
            Tree child = t.getChild(i);
            switch (child.getType()) {

                case 157: {  //type
                    type = doType((CommonTree) child);
                    break;
                }
                //--------------------------------------------------------------------------
                case 164: {  //identifier
                    name = doIdent((CommonTree) child) + " ";
                    break;
                }
                //----------------------------------------------------------------------------
                case 117: {  //block scope
                    doBlockScope((CommonTree) child, methodNode);
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
        methodNode.setName(scope + type + name + "(" + StringUtils.join(params, ", ") + ")");
        nodes.add(methodNode);

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
                    name = doIdent((CommonTree) child);
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
                    type = doQualifiedTypeIdent((CommonTree) child);
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
                case 55: {
                    type = "boolean";
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

    private void doBlockScope(CommonTree t, TreeNode node) {
        for (int i = 0; i < t.getChildCount(); i++) {
            Tree child = t.getChild(i);
            switch (child.getType()) {
                case 160: {   // [VAR_DECLARATION]
                    doVarDeclaration((CommonTree) child, node);
                    break;
                }
                //-----------------------------------------------
                case 126: {
                    doExpr((CommonTree) child, node);
                    break;
                }

                case 74: {
                    doIf((CommonTree) child, node);
                    break;
                }
                default: {
                    break;
                }
            }
        }
    }
    private void doIf(CommonTree t, TreeNode node) {
        for (int i = 0; i < t.getChildCount(); i++) {
            Tree child = t.getChild(i);
            switch (child.getType()) {
//                case 146:{   // [PARENTESIZED_EXPR]
//                  doParentesizeExpr
//                }
            }
        }
    }
    private void doClassTopLevelScope(CommonTree t, TreeNode node) {
        for (int i = 0; i < t.getChildCount(); i++) {
            Tree child = t.getChild(i);
            switch (child.getType()) {
                case 160: { //var declaration
                    doVarDeclaration((CommonTree) child, node);
                    break;
                }
                //----------------------------------------------------------------------------------
                case 163: {  //void method
                    doMethod((CommonTree) child, node);
                    break;
                }
                //----------------------------------------------------------------------------------------
                case 136: {  // method
                    doMethod((CommonTree) child, node);
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

    private String doIdent(CommonTree t) {
        return t.getText();
    }
}

