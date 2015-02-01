package by.bsu.project.antlr.tree;

import by.bsu.project.antlr.lang.*;
import by.bsu.project.antlr.model.Operation;
import by.bsu.project.antlr.model.TreeNode;
import by.bsu.project.antlr.model.Type;
import by.bsu.project.general.model.AttributeCounting;
import org.antlr.runtime.ANTLRInputStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.Token;
import org.antlr.runtime.tree.*;
import org.apache.commons.lang.StringUtils;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.List;

import static by.bsu.project.antlr.lang.LangWrap.Operation1;
import static by.bsu.project.antlr.lang.LangWrap.Lang;

/**
 * User: iason
 * Date: 26.03.14
 */
public class TreeHelper {
    private int h = 0;
    private List<TreeNode> nodes = new ArrayList<>();
    private AttributeCounting ac;
    private LangFactory factory;
    private final TreeAdaptor adaptor = new CommonTreeAdaptor() {
        public Object create(Token payload) {
            return new CommonTree(payload);
        }
    };
    private Lang lang;

    public AttributeCounting getAc() {
        return ac;
    }

    public TreeHelper(String id, Lang lang) {
        this.ac = new AttributeCounting(id);
        this.lang = lang;
        this.factory = new LangFactory(lang);
    }

    public List<TreeNode> getTree(byte[] bytes) {
        try {
            ANTLRInputStream in = new ANTLRInputStream(new ByteArrayInputStream(bytes));
            LangLexer lexer = factory.createLexer(in);
            CommonTokenStream tokens = new CommonTokenStream(lexer);
            LangParser parser = factory.createParser(tokens);
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
        Operation1 op = OperationUtil.get(lang, t.getType());
            switch (op) {
                case ROOT: { //root
                    TreeNode root = new TreeNode(h++, "root", null);
                    nodes.add(root);

                    for (int i = 0; i < t.getChildCount(); i++) {
                        doTree((CommonTree) t.getChild(i), root);
                    }
                    break;
                }
                //-----------------------------------------------------------------------
                case CLASS_DECL: { //class node
                    doClass(t, node);
                    break;
                }
                //------------------------------------------------------------------------------------------
                case SIMPLE_DECL: { //cpp
                    doSimpleDeclaration(t, node);
                    break;
                }
                //------------------------------------------------------------------------------------------
                case VAR: { //pascal
                    doVar(t, node);
                    break;
                }
                //------------------------------------------------------------------------------------------
                case PROCEDURE: { //pascal
                    doMethod(t, node);
                    break;
                }
                //------------------------------------------------------------------------------------------
                case FUNCTION_METHOD_DECL: { //pascal
                    doMethod(t, node);
                    break;
                }
                //------------------------------------------------------------------------------------------

                default: {
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
                LangWrap.Operation1 op = OperationUtil.get(lang, child.getType());
                switch (op) {

                    case CLASS_NAME: {  // [IDENT]
                        name = doIdent((CommonTree) child.getChild(0));
                        break;
                    }
                    //------------------------------------------------------------------------------
                    case IDENT: {  // [IDENT]
                        name = doIdent((CommonTree) child);
                        break;
                    }
                    //------------------------------------------------------------------------------
                    case CLASS_CONTENT: {  //class top level
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

    private void doSimpleDeclaration(CommonTree t, TreeNode node) {
        for (int i =0; i<t.getChildCount(); i++) {
            Tree child = t.getChild(i);
            Operation1 op = OperationUtil.get(lang, child.getType());
            switch (op) {

                case CLASS_DECL: {
                    doClass((CommonTree) child.getChild(0), node);
                    break;
                }
                //------------------------------------------------------------------------------
                case VAR_DECLARATION: {
                    doVarDeclaration((CommonTree) child, node);
                    break;
                }
                //------------------------------------------------------------------------------

                default: {
                    break;
                }
            }
        }

    }

    //pascal
    private void doVar(CommonTree t, TreeNode node) {
        for (int i = 0; i < t.getChildCount(); i++) {
            Tree child = t.getChild(i);
            Operation1 op = OperationUtil.get(lang, child.getType());
            switch (op) {

                case VAR_DECLARATION: {
                    doVarDeclaration((CommonTree) child, node);
                    break;
                }
                //----------------------------------------------------------------------------------
                default: {
                    break;
                }
            }
        }
    }

    private String doVarDeclaration(CommonTree t, TreeNode node) {
        String type = doType(t); // try to find any children TYPE (Pascal)
        List<String> names = new ArrayList<>();

        for (int i = 0; i < t.getChildCount(); i++) {
            Tree child = t.getChild(i);
            Operation1 op = OperationUtil.get(lang, child.getType());
            switch (op) {
                case NAME: {//cpp !!!! it's OK
                    names.add(doIdent((CommonTree) child.getChild(0)));
                    break;
                }
                //-------------------------------------------------------------------------------
                case VAR_DECLARATOR_LIST: {
                    names.addAll(doVarDeclaratorList((CommonTree) child, node));
                    break;
                }
                //-------------------------------------------------------------------------------
                case TYPE: {
                    type = doType((CommonTree) child);
                    break;
                }
                //----------------------------------------------------------------------------------
                case INIT: {
                    doExpr((CommonTree) child, node);
                    break;
                }
                //----------------------------------------------------------------------------------
                default: {
                }
            }
        }
        for (String name : names) {
            TreeNode varDeclarationNode = new TreeNode(h++, "", node);
            varDeclarationNode.setName(type +" "+ name);
            varDeclarationNode.setOperation("var_" + type);
            nodes.add(varDeclarationNode);
        }
        return type + StringUtils.join(names.toArray());
    }

    private List<String> doVarDeclaratorList(CommonTree t, TreeNode node) {
        List<String> names = new ArrayList<>();
        for (int i = 0; i < t.getChildCount(); i++) {
            Tree child = t.getChild(i);
            Operation1 op = OperationUtil.get(lang, child.getType());
            switch (op) {
                case VAR_DECLARATOR: {
                    names.add(doVarDeclarator((CommonTree) child, node));
                    break;
                }
                case IDENT: {
                    names.add(doIdent((CommonTree) child));
                    break;
                }
                default: {
                    break;
                }
            }
        }
        return names;
    }

    private String doVarDeclarator(CommonTree t, TreeNode node) {
        String name = "";
        for (int i = 0; i < t.getChildCount(); i++) {
            Tree child = t.getChild(i);
            Operation1 op = OperationUtil.get(lang, child.getType());
            switch (op) {
                case IDENT: {
                    name = doIdent((CommonTree) child);
                    break;
                }
                //-------------------------------------------------
                case EXPR: {
                    name += " = " + doExpr((CommonTree) child, node);
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

    private String doExpr(CommonTree t, TreeNode node) {
        String res = "";
        for (int i = 0; i < t.getChildCount(); i++) {
            Tree child = t.getChild(i);
            switch (child.getType()) {
                case 120: { // [CLASS_CONSTRUCTOR_CALL]
                    doConstructorCall((CommonTree) child, node);
                    break;
                }
                case 148: { //[POST_INC]
                    res = doPostInc((CommonTree) child, node);
                    break;
                }

                case 147: { //[POST_DEC]
                    res = doPostDec((CommonTree) child, node);
                    break;
                }

                case 167: {  // [DECIMAL_LITERAL]
                    res = doLiteral((CommonTree) child, node, Type.DECIMAL);
                    break;
                }
                case 168: {  // [STRING_LITERAL]
                    res = doLiteral((CommonTree) child, node, Type.FLOATING_POINT);
                    break;
                }
                case 170: {  // [STRING_LITERAL]
                    res = doLiteral((CommonTree) child, node, Type.STRING);
                    break;
                }

                case 99: {   // TRUE
                    res = doLiteral((CommonTree) child, node, Type.BOOL);
                    break;
                }

                case 69: { // FALSE
                    res = doLiteral((CommonTree) child, node, Type.BOOL);
                    break;
                }
                case 144: {  //[METHOD_CALL]
                    res = doMethodCall((CommonTree) child, node);
                    break;
                }
                case 6: {
                    res = doBinOperator((CommonTree) child, node, Operation.ASSIGN);
                    break;
                }

                case 38: {
                    res = doBinOperator((CommonTree) child, node, Operation.PLUS);
                    break;
                }

                case 30: {
                    res = doBinOperator((CommonTree) child, node, Operation.MINUS);
                    break;
                }

                case 18: {
                    res = doBinOperator((CommonTree) child, node, Operation.EQUAL);
                    break;
                }

                case 35: {
                    res = doBinOperator((CommonTree) child, node, Operation.NOT_EQUAL);
                    break;
                }

                case 26: {
                    res = doBinOperator((CommonTree) child, node, Operation.LOGICAL_AND);
                    break;
                }

                case 25: { // [LESS THAN]
                    res = doBinOperator((CommonTree) child, node, Operation.LESS_THAN);
                    break;
                }

                case 20: { // [GREATER THAN]
                    res = doBinOperator((CommonTree) child, node, Operation.GREATER_THAN);
                    break;
                }
                default: {
                    break;
                }

            }
        }

        return res;
    }

    private String doPostInc(CommonTree t, TreeNode node) {
        String name = "";
        for (int i = 0; i < t.getChildCount(); i++) {
            Tree child = t.getChild(i);
            Operation1 op = OperationUtil.get(lang, child.getType());
            switch (op) {
                case IDENT: {
                    name = doIdent((CommonTree) child);
                }
            }
        }

        TreeNode postInc = new TreeNode(h++, name + "++", node);
        nodes.add(postInc);
        postInc.setOperation("post_inc");
        ac.incPlus();
        ac.incAssign();
        return postInc.getName();
    }

    private String doPostDec(CommonTree t, TreeNode node) {
        String name = "";
        for (int i = 0; i < t.getChildCount(); i++) {
            Tree child = t.getChild(i);
            Operation1 op = OperationUtil.get(lang, child.getType());
            switch (op) {
                case IDENT: {
                    name = doIdent((CommonTree) child);
                }
            }
        }

        TreeNode postDec = new TreeNode(h++, name + "--", node);
        nodes.add(postDec);
        postDec.setOperation("post_dec");
        ac.incMinus();
        ac.incAssign();
        return postDec.getName();
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
                    arr[i] = doLiteral((CommonTree) child);
                    break;
                }

                case 170: {
                    arr[i] = doLiteral((CommonTree) child);
                    break;
                }

                case 168: {
                    arr[i] = doLiteral((CommonTree) child);
                    break;
                }

                case 99: {
                    arr[i] = doLiteral((CommonTree) child);
                    break;
                }

                case 69: {
                    arr[i] = doLiteral((CommonTree) child);
                    break;
                }

                case 38: {
                    arr[i] = doBinOperator((CommonTree) child, bin, Operation.PLUS);
                    ac.incPlus();
                    break;
                }
                case 30: {
                    arr[i] = doBinOperator((CommonTree) child, bin, Operation.MINUS);
                    ac.incMinus();
                    break;
                }

                case 6: {
                    arr[i] = doBinOperator((CommonTree) child, bin, Operation.ASSIGN);
                    ac.incAssign();
                    break;
                }

                case 18: {
                    arr[i] = doBinOperator((CommonTree) child, bin, Operation.EQUAL);
                    break;
                }

                case 35: {
                    arr[i] = doBinOperator((CommonTree) child, bin, Operation.NOT_EQUAL);
                    break;
                }

                case 26: {
                    arr[i] = doBinOperator((CommonTree) child, bin, Operation.LOGICAL_AND);
                    break;
                }

                case 25: { // [LESS THAN]
                    arr[i] = doBinOperator((CommonTree) child, bin, Operation.LESS_THAN);
                    break;
                }

                case 20: { // [GREATER THAN]
                    arr[i] = doBinOperator((CommonTree) child, bin, Operation.GREATER_THAN);
                    break;
                }
            }
        }
        bin.setName(arr[0] + operation.getSymbol() + arr[1]);
        bin.setOperation(operation.getSymbol());
        nodes.add(bin);
        return bin.getName();
    }

    private String doMethodCall(CommonTree t, TreeNode node) {
        String name = "";
        TreeNode methodCall = new TreeNode(h++, "", node);
        for (int i = 0; i < t.getChildCount(); i++) {
            Tree child = t.getChild(i);
            switch (child.getType()) {
                case 164: {
                    name = doIdent((CommonTree) child);
                    break;
                }
                case 15: {   // [DOT]
                    name = doDot((CommonTree) child);
                    break;
                }

                case 112: {
                    doArgumentList((CommonTree) child, methodCall);
                }
            }
        }
        methodCall.setName(name);
        methodCall.setOperation("method_call");
        nodes.add(methodCall);
        ac.incCall();
        return name;
    }

    private String doDot(CommonTree t) {
        return doIdent((CommonTree) t.getChild(0)) + "." + doIdent((CommonTree) t.getChild(1));
    }

    private String doLiteral(CommonTree t, TreeNode node, Type type) {
        TreeNode literal = new TreeNode(h++, t.getText(), node);
        nodes.add(literal);
        return literal.getName();
    }

    private String doLiteral(CommonTree t) {
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

        ac.incCall();
    }

    private String doQualifiedTypeIdent(CommonTree t) {
        String name = "";
        for (int i = 0; i < t.getChildCount(); i++) {
            Tree child = t.getChild(i);
            Operation1 op = OperationUtil.get(lang, child.getType());
            switch (op) {
                case IDENT: {
                    name = doIdent((CommonTree) child);
                }
            }
        }
        ac.incVar();
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
        String name = "";
        String type = doType(t); //pascal
        TreeNode methodNode = new TreeNode(h++, "", node);

        for (int i = 0; i < t.getChildCount(); i++) {
            Tree child = t.getChild(i);
            Operation1 op = OperationUtil.get(lang, child.getType());
            switch (op) {
                case RETURN_TYPE: { //cpp
                    String temp = doType((CommonTree) child);
                    type = temp.equalsIgnoreCase("void") ? "" : temp;
                    break;
                }

                case TYPE: { //java
                    type = doType((CommonTree) child);
                    break;
                }
                //--------------------------------------------------------------------------
                case IDENT: {
                    name = doIdent((CommonTree) child) + " ";
                    break;
                }
                //----------------------------------------------------------------------------
                case BLOCK_SCOPE: {
                    doBlockScope((CommonTree) child, methodNode);
                    break;
                }
                //---------------------------------------------------------------------------------
                case FORMAL_PARAM_LIST: {
                    params = doFormalParamList((CommonTree) child);
                    break;
                }
                //---------------------------------------------------------------------------------
                case VAR: {
                    doVar((CommonTree) child, methodNode);
                    break;
                }
                default: {
                    break;
                }
            }
        }
        methodNode.setName(type + name + "(" + StringUtils.join(params, ',') + ")");
        methodNode.setOperation("method");
        nodes.add(methodNode);
        ac.incMethod();
    }

    private List<String> doFormalParamList(CommonTree t) {
        List<String> params = new ArrayList<>();
        for (int i = 0; i < t.getChildCount(); i++) {
            Tree child = t.getChild(i);
            Operation1 op = OperationUtil.get(lang, child.getType());
            switch (op) {
                case FORMAL_PARAM_STD_DECL: {  //identifier
                    params.add(doFormalParam((CommonTree) child));
                    break;
                }
                //-----------------------------------------------------------------------
                default: {
                    break;
                }
            }
        }
        return params;
    }

    private String doFormalParam(CommonTree t) {
        List<String> names = new ArrayList<>();
        String type = doType(t);  //pascal !!!
        for (int i = 0; i < t.getChildCount(); i++) {
            Tree child = t.getChild(i);
            Operation1 op = OperationUtil.get(lang, child.getType());
            switch (op) {
                case VAR_DECLARATOR_LIST: { //pascal
                   names.addAll(doVarDeclaratorList((CommonTree) child, null));
                    break;
                }
                //---------------------------------------------------------------
                case TYPE: {
                    type = doType((CommonTree) child);
                    break;
                }
                //---------------------------------------------------------------
                case IDENT: {
                    names.add(doIdent((CommonTree) child));
                    break;
                }
                //-----------------------------------------------------------------------
                default: {
                    break;
                }
            }
        }
        String res = "";
        for(String s: names) {
           res +=type+" "+s+", ";
        }
        return res.substring(0, res.length() - 2);
    }

    private String doType(CommonTree t) {
        String type = "";
        String array = "";
        for (int i = 0; i < t.getChildCount(); i++) {
            Tree child = t.getChild(i);
            Operation1 op = OperationUtil.get(lang, child.getType());
            switch (op) {
                case TYPE_NAME: {   //custom type
                    type = doQualifiedTypeIdent((CommonTree) child);
                    break;
                }
                //-------------------------------------------------------------
                case ARRAY: {   //custom type
                    array = "ARRAY";
                    break;
                }
                case INT: {
                    type = "INT";
                    break;
                }
                //---------------------------------------------------------------------------------
                case FLOAT: {
                    type = "FLOAT";
                    break;
                }
                //---------------------------------------------------------------------------------
                case CHAR: {
                    type = "CHAR";
                    break;
                }
                //---------------------------------------------------------------------------------
                case DOUBLE: {
                    type = "DOUBLE";
                    break;
                }
                //---------------------------------------------------------------------------------
                case BOOLEAN: {
                    type = "BOOLEAN";
                    break;
                }
                //---------------------------------------------------------------------------------
                case STRING: {
                    type = "STRING";
                    break;
                }
                //---------------------------------------------------------------------------------
                default: {
                    break;
                }
            }
        }
        return type + " "+array;
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
                //---------------------------------------------------------------------------------
                case 74: {
                    doIf((CommonTree) child, node);
                    break;
                }
                //---------------------------------------------------------------------------------
                case 103: {
                    doWhile((CommonTree) child, node);
                    break;
                }
                //---------------------------------------------------------------------------------
                case 73: {
                    doFor((CommonTree) child, node);
                    break;
                }
                //---------------------------------------------------------------------------------
                default: {
                    break;
                }
            }
        }
    }

    private void doIf(CommonTree t, TreeNode node) {
        TreeNode ifNode = new TreeNode(h++, "", node);
        String condition = "";
        for (int i = 0; i < t.getChildCount(); i++) {
            Tree child = t.getChild(i);
            switch (child.getType()) {
                case 146: {   // [PARENTESIZED_EXPR]
                    condition = doParenthesizedExpr((CommonTree) child, ifNode);
                    break;
                }

                case 117: {
                    doBlockScope((CommonTree) child, ifNode);
                    break;
                }
            }
        }
        ifNode.setName("if (" + condition + ")");
        ifNode.setOperation("if");
        nodes.add(ifNode);
        ac.incIfs();
    }

    private void doWhile(CommonTree t, TreeNode node) {
        TreeNode whileNode = new TreeNode(h++, "", node);
        String name = "";
        for (int i = 0; i < t.getChildCount(); i++) {
            Tree child = t.getChild(i);
            switch (child.getType()) {
                case 146: {   // [PARENTESIZED_EXPR]
                    name = doParenthesizedExpr((CommonTree) child, whileNode);
                    break;
                }

                case 117: {
                    doBlockScope((CommonTree) child, whileNode);
                    break;
                }
            }
        }
        whileNode.setName("while (" + name + ")");
        whileNode.setOperation("cycle");
        nodes.add(whileNode);
        ac.incCycle();
    }

    private void doFor(CommonTree t, TreeNode node) {
        TreeNode forNode = new TreeNode(h++, "", node);
        String name = "";
        for (int i = 0; i < t.getChildCount(); i++) {
            Tree child = t.getChild(i);
            switch (child.getType()) {
                case 131: {   // [FOR_INIT]
                    name += doForInit((CommonTree) child, forNode) + " ; ";
                    break;
                }
                case 129: {   // [FOR_CONDITION]
                    name += doForCondition((CommonTree) child, forNode) + " ; ";
                    break;
                }

                case 132: {   // [FOR_CONDITION]
                    name += doForUpdate((CommonTree) child, forNode);
                    break;
                }

                case 117: {   // [FOR_CONDITION]
                    doBlockScope((CommonTree) child, forNode);
                    break;
                }

            }
        }
        forNode.setName("for (" + name + ")");
        forNode.setOperation("cycle");
        nodes.add(forNode);
        ac.incCycle();
    }

    private String doForInit(CommonTree t, TreeNode node) {
//        TreeNode forInit = new TreeNode(h++, "", node);
        String name = "";
        for (int i = 0; i < t.getChildCount(); i++) {
            Tree child = t.getChild(i);
            switch (child.getType()) {
                case 160: {   // [VAR_DECLARATION]
                    name = doVarDeclaration((CommonTree) child, node);
                    break;
                }
            }
        }
//        forInit.setName(name);
//        nodes.add(forInit);
        return name;
    }

    private String doForCondition(CommonTree t, TreeNode node) {
//        TreeNode forCond = new TreeNode(h++, "", node);
        String name = "";
        for (int i = 0; i < t.getChildCount(); i++) {
            Tree child = t.getChild(i);
            switch (child.getType()) {
                case 126: {   // [VAR_DECLARATION]
                    name = doExpr((CommonTree) child, node);
                    break;
                }
            }
        }
//        forCond.setName(name);
//        nodes.add(forCond);
        return name;
    }

    private String doForUpdate(CommonTree t, TreeNode node) {
//        TreeNode forUpdate = new TreeNode(h++, "", node);
        String name = "";
        for (int i = 0; i < t.getChildCount(); i++) {
            Tree child = t.getChild(i);
            switch (child.getType()) {
                case 126: {   // [VAR_DECLARATION]
                    name = doExpr((CommonTree) child, node);
                    break;
                }
            }
        }
//        forUpdate.setName(name);
//        nodes.add(forUpdate);
        return name;
    }

    private String doParenthesizedExpr(CommonTree t, TreeNode node) {
        String name = "";
        for (int i = 0; i < t.getChildCount(); i++) {
            Tree child = t.getChild(i);
            switch (child.getType()) {
                case 126: {
                    name = doExpr((CommonTree) child, node);
                    break;
                }
            }
        }

        return name;
    }

    private void doClassTopLevelScope(CommonTree t, TreeNode node) {
        for (int i = 0; i < t.getChildCount(); i++) {
            Tree child = t.getChild(i);
            Operation1 op = OperationUtil.get(lang, child.getType());
            switch (op) {
                case VAR_DECLARATION: {
                    doVarDeclaration((CommonTree) child, node);
                    break;
                }
               //----------------------------------------------------------------------------------
                case SIMPLE_DECL: { //used for var init in class
                    doSimpleDeclaration((CommonTree) child, node);
                    break;
                }
                //----------------------------------------------------------------------------------
                case VOID_METHOD_DECL: {
                    doMethod((CommonTree) child, node);
                    break;
                }
                //----------------------------------------------------------------------------------------
                case FUNCTION_METHOD_DECL: {
                    doMethod((CommonTree) child, node);
                    break;
                }
                //------------------------------------------------------------------------------------------
                default: {
                    break;
                }
            }
        }
    }

    private String doIdent(CommonTree t) {
        return t.getText();
    }
}