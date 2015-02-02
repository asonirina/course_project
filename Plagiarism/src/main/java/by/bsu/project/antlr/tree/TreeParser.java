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
public class TreeParser {
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

    public TreeParser(String id, Lang lang) {
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
    ///
    private void doTree(CommonTree t, TreeNode node) {
        if (t != null) {
        Operation1 op = OperationUtil.get(lang, t);
            switch (op) {
                case ROOT: {
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
                case BLOCK_SCOPE: { //pascal
                    doBlockScope(t, node);
                    break;
                }
                //------------------------------------------------------------------------------------------

                default: {
                    break;
                }
            }
        }
    }

    ///
    private void doClass(CommonTree t, TreeNode node) {
        String name = "";
        TreeNode classNode = new TreeNode(h++, "", node);

        for (int i = 0; i < t.getChildCount(); i++) {
            CommonTree child = (CommonTree)t.getChild(i);
            LangWrap.Operation1 op = OperationUtil.get(lang, child);
            switch (op) {

                case CLASS_NAME: {
                    name = doIdent((CommonTree)child.getChild(0));
                    break;
                }
                //------------------------------------------------------------------------------
                case IDENT: {
                    name = doIdent(child);
                    break;
                }
                //------------------------------------------------------------------------------
                case CLASS_CONTENT: {
                    doClassTopLevelScope(child, classNode);
                    break;
                }
                //------------------------------------------------------------------------------
                default: {
                    break;
                }
            }
        }
        classNode.setName("class " + name);
        nodes.add(classNode);

    }
    ///
    private void doSimpleDeclaration(CommonTree t, TreeNode node) {
        for (int i =0; i<t.getChildCount(); i++) {
            CommonTree child = (CommonTree)t.getChild(i);
            Operation1 op = OperationUtil.get(lang, child);
            switch (op) {

                case CLASS_DECL: {
                    doClass((CommonTree) child.getChild(0), node);
                    break;
                }
                //------------------------------------------------------------------------------
                case VAR_DECLARATION: {
                    doVarDeclaration(child, node);
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
            CommonTree child = (CommonTree)t.getChild(i);
            Operation1 op = OperationUtil.get(lang, child);
            switch (op) {

                case VAR_DECLARATION: {
                    doVarDeclaration( child, node);
                    break;
                }
                //----------------------------------------------------------------------------------
                default: {
                    break;
                }
            }
        }
    }

    ////
    private String doVarDeclaration(CommonTree t, TreeNode node) {
        String type = doType(t); // try to find any children TYPE (Pascal)
        List<String> names = new ArrayList<>();

        for (int i = 0; i < t.getChildCount(); i++) {
            CommonTree child = (CommonTree)t.getChild(i);
            Operation1 op = OperationUtil.get(lang, child);
            switch (op) {
                case NAME: {//cpp !!!! it's OK
                    names.add(doIdent((CommonTree) child.getChild(0)));
                    break;
                }
                //-------------------------------------------------------------------------------
                case VAR_DECLARATOR_LIST: {
                    names.addAll(doVarDeclaratorList(child, node));
                    break;
                }
                //-------------------------------------------------------------------------------
                case TYPE: {
                    type = doType(child);
                    break;
                }
                //----------------------------------------------------------------------------------
                case INIT: {
                    doExpr(child, node);
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

    /////
    private List<String> doVarDeclaratorList(CommonTree t, TreeNode node) {
        List<String> names = new ArrayList<>();
        for (int i = 0; i < t.getChildCount(); i++) {
            CommonTree child = (CommonTree)t.getChild(i);
            Operation1 op = OperationUtil.get(lang, child);
            switch (op) {
                case VAR_DECLARATOR: {
                    names.add(doVarDeclarator( child, node));
                    break;
                }
                case IDENT: {
                    names.add(doIdent(child));
                    break;
                }
                default: {
                    break;
                }
            }
        }
        return names;
    }

    ///////
    private String doVarDeclarator(CommonTree t, TreeNode node) {
        String name = "";
        for (int i = 0; i < t.getChildCount(); i++) {
            CommonTree child = (CommonTree)t.getChild(i);
            Operation1 op = OperationUtil.get(lang, child);
            switch (op) {
                case IDENT: {
                    name = doIdent(child);
                    break;
                }
                //-------------------------------------------------
                case EXPR: {
                    name += " = " + doExpr(child, node);
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

    /////////////////
    private String doExpr(CommonTree t, TreeNode node) {
        String res = doCommonExpression(t, node);
        if(StringUtils.isNotBlank(res)) {
            return res;
        }
        for (int i = 0; i < t.getChildCount(); i++) {
            Tree child = t.getChild(i);
            res = doCommonExpression((CommonTree)child, node);
            if(StringUtils.isNotBlank(res)) {
                break;
            }
        }

        return res;
    }
    ////////////////
    private String doCppLinearExpression(CommonTree t, TreeNode node) {
        if (t.getChildCount() == 1) {
            return doExpr((CommonTree) t.getChild(0), node);
        }
        Operation1 current = Operation1.NULL;
        List<String> arr = new ArrayList<>();
        for (int i = 0; i < t.getChildCount(); i++) {
            CommonTree child = (CommonTree) t.getChild(i);
            Operation1 op = OperationUtil.get(lang, child);
            switch (op) {
                case FIELD: {
                    arr.add(doExpr(child, node));
                    break;
                }
                case IDENT: {
                    arr.add(doIdent(child));
                    break;
                }
                default: {
                    if(child.getChildCount()==0){
                        current = op;
                    } else {
                        current = OperationUtil.get(lang, (CommonTree)child.getChild(0));
                    }
                    break;
                }
            }
        }
        TreeNode bin = new TreeNode(h++, StringUtils.join(arr, ' ') + current.name(), node);
        nodes.add(bin);
        return bin.getName();
    }

    ////////////////
    private String doCommonExpression(CommonTree t, TreeNode node) {
        String res = "";
        Operation1 op = OperationUtil.get(lang, t);
        switch (op) {
            case FIELD: { // cpp
                res = doCppLinearExpression(t, node);
                break;
            }
            case LVAL: { // cpp
                res = doCppLinearExpression(t, node);
                break;
            }
            case RVAL: { // cpp
                res = doCppLinearExpression(t, node);
                break;
            }
            case EXPR: { // cpp
                res = doCppLinearExpression(t, node);
                break;
            }
            case CLASS_CONSTRUCTOR_CALL: {
                res = doConstructorCall(t, node);
                break;
            }
            case POST_INC: {
                res = doPostInc(t, node);
                break;
            }
            case POST_DEC: {
                res = doPostDec(t, node);
                break;
            }
            case METHOD_CALL: {
                res = doMethodCall(t, node);
                break;
            }
            case IDENT: {
                res = doIdent(t);
                break;
            }
            case DECIMAL_LITERAL: {
                res = doLiteral(t, node, Type.DECIMAL);
                break;
            }

            case FLOATING_POINT_LITERAL: {
                res = doLiteral(t, node, Type.FLOATING_POINT);
                break;
            }

            case STRING_LITERAL: {
                res = doLiteral(t, node, Type.STRING);
                break;
            }

            case TRUE: {
                res = doLiteral(t, node, Type.BOOL);
                break;
            }

            case FALSE: {
                res = doLiteral(t, node, Type.BOOL);
                break;
            }
            case ASSIGN: {
                res = doBinOperator(t, node, Operation.ASSIGN);
                ac.incAssign();
                break;
            }
            case PLUS: {
                res = doBinOperator(t, node, Operation.PLUS);
                ac.incPlus();
                break;
            }

            case MINUS: {
                res = doBinOperator(t, node, Operation.MINUS);
                ac.incMinus();
                break;
            }
            case EQUAL: {
                res = doBinOperator(t, node, Operation.EQUAL);
                break;
            }

            case NOT_EQUAL: {
                res = doBinOperator(t, node, Operation.NOT_EQUAL);
                break;
            }
            case LOGICAL_AND: {
                res = doBinOperator(t, node, Operation.LOGICAL_AND);
                break;
            }

            case LESS_THAN: {
                res = doBinOperator(t, node, Operation.LESS_THAN);
                break;
            }

            case GREATER_THAN: {
                res = doBinOperator(t, node, Operation.GREATER_THAN);
                break;
            }

            default: {
                break;
            }
        }
        return res;
    }
    ///////
    private String doPostInc(CommonTree t, TreeNode node) {
        String name = "";
        for (int i = 0; i < t.getChildCount(); i++) {
            CommonTree child = (CommonTree)t.getChild(i);
            Operation1 op = OperationUtil.get(lang, child);
            switch (op) {
                case IDENT: {
                    name = doIdent(child);
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

    ///////////
    private String doPostDec(CommonTree t, TreeNode node) {
        String name = "";
        for (int i = 0; i < t.getChildCount(); i++) {
            CommonTree child = (CommonTree)t.getChild(i);
            Operation1 op = OperationUtil.get(lang, child);
            switch (op) {
                case IDENT: {
                    name = doIdent(child);
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

    /////////////////
    private String doBinOperator(CommonTree t, TreeNode node, Operation operation) {
        List<String> arr = new ArrayList<>();
        TreeNode bin = new TreeNode(h++, "", node);
        for (int i = 0; i < t.getChildCount(); i++) {
            Tree child = t.getChild(i);
            String temp = doExpr((CommonTree) child, bin);
            if(StringUtils.isNotBlank(temp)) {
                arr.add(temp);
            }
        }
        bin.setName(StringUtils.join(arr, operation.getSymbol()));
        bin.setOperation(operation.getSymbol());
        nodes.add(bin);
        return bin.getName();
    }

    //////////////
    private String doMethodCall(CommonTree t, TreeNode node) {
        String name = "";
        TreeNode methodCall = new TreeNode(h++, "", node);
        for (int i = 0; i < t.getChildCount(); i++) {
            CommonTree child = (CommonTree)t.getChild(i);
            Operation1 op = OperationUtil.get(lang, child);
            switch (op) {
                case IDENT: {
                    name = doIdent(child);
                    break;
                }
                case CALLEE: {
                    name = doDot(child);
                    break;
                }
                case ARGUMENT: {
                    doCppLinearExpression(child, methodCall);
                    break;
                }
                case DOT: {
                    name = doDot(child);
                    break;
                }
                case ARGUMENT_LIST: {
                    doArgumentList(child, methodCall);
                }
            }
        }
        methodCall.setName(name);
        methodCall.setOperation("method_call");
        nodes.add(methodCall);
        ac.incCall();
        return name;
    }

    //////////////
    private String doDot(CommonTree t) {
        List<String> names = new ArrayList<>();
        for (int i = 0; i<t.getChildCount(); i++) {
            CommonTree child = (CommonTree)t.getChild(i);
            Operation1 op = OperationUtil.get(lang, child);
            switch (op){
                case IDENT:{
                    names.add(doIdent(child));
                    break;
                }
                case DOT:{
                    names.add(doDot(child));
                }
                default:{
                    break;
                }
            }
        }
        return StringUtils.join(names, '.');
    }

    //////////////////
    private String doLiteral(CommonTree t, TreeNode node, Type type) {
        return t.getText()+ type.getName();
    }

    /////////
    private String doConstructorCall(CommonTree t, TreeNode node) {
        TreeNode constructor = new TreeNode(h++, "", node);
        for (int i = 0; i < t.getChildCount(); i++) {
            CommonTree child = (CommonTree)t.getChild(i);
            Operation1 op = OperationUtil.get(lang, child);
            switch (op) {
                case QUALIFIED_TYPE_IDENT: {
                    constructor.setName("new " + doQualifiedTypeIdent(child));
                    break;
                }
                //----------------------------------------------------
                case ARGUMENT_LIST: {
                    doArgumentList( child, constructor);
                    break;
                }
                //----------------------------------------------------
                default: {
                    break;
                }
            }
        }
        nodes.add(constructor);
        ac.incCall();
        return constructor.getName();
    }

    //////////////
    private String doQualifiedTypeIdent(CommonTree t) {
        String name = "";
        for (int i = 0; i < t.getChildCount(); i++) {
            CommonTree child = (CommonTree)t.getChild(i);
            Operation1 op = OperationUtil.get(lang, child);
            switch (op) {
                case IDENT: {
                    name = doIdent( child);
                }
            }
        }
        ac.incVar();
        return name;
    }

    ////////////
    private void doArgumentList(CommonTree t, TreeNode node) {
        for (int i = 0; i < t.getChildCount(); i++) {
            CommonTree child = (CommonTree)t.getChild(i);
            if (lang.equals(Lang.PASCAL)) {
                doExpr(child, node);
            }
            Operation1 op = OperationUtil.get(lang, child);
            switch (op) {
                case EXPR: {
                    doExpr(child, node);
                    break;
                }
                default: {
                    break;
                }
            }
        }
    }

    /////////////////
    private void doMethod(CommonTree t, TreeNode node) {
        List<String> params = new ArrayList<>();
        String name = "";
        String type = doType(t); //pascal
        TreeNode methodNode = new TreeNode(h++, "", node);

        for (int i = 0; i < t.getChildCount(); i++) {
            CommonTree child = (CommonTree)t.getChild(i);
            Operation1 op = OperationUtil.get(lang, child);
            switch (op) {
                case RETURN_TYPE: { //cpp
                    String temp = doType( child).trim();
                    type = temp.equalsIgnoreCase("void") ? "" : temp;
                    break;
                }

                case TYPE: { //java
                    type = doType(child);
                    break;
                }
                //--------------------------------------------------------------------------
                case IDENT: {
                    name = doIdent(child) + " ";
                    break;
                }

                //--------------------------------------------------------------------------
                case FUNCTION_NAME: {
                    name = doIdent((CommonTree) child.getChild(0)) + " ";
                    break;
                }
                //----------------------------------------------------------------------------
                case BLOCK_SCOPE: {
                    doBlockScope(child, methodNode);
                    break;
                }
                //---------------------------------------------------------------------------------
                case FORMAL_PARAM_LIST: {
                    params = doFormalParamList(child);
                    break;
                }
                //---------------------------------------------------------------------------------
                case VAR: {
                    doVar(child, methodNode);
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

    /////////////////
    private List<String> doFormalParamList(CommonTree t) {
        List<String> params = new ArrayList<>();
        for (int i = 0; i < t.getChildCount(); i++) {
            CommonTree child = (CommonTree)t.getChild(i);
            Operation1 op = OperationUtil.get(lang, child);
            switch (op) {
                case FORMAL_PARAM_STD_DECL: {  //identifier
                    params.add(doFormalParam( child));
                    break;
                }
                default: {
                    break;
                }
            }
        }
        return params;
    }

    /////////////////////
    private String doFormalParam(CommonTree t) {
        List<String> names = new ArrayList<>();
        String type = doType(t);  //pascal !!!
        for (int i = 0; i < t.getChildCount(); i++) {
            CommonTree child = (CommonTree)t.getChild(i);
            Operation1 op = OperationUtil.get(lang, child);
            switch (op) {
                case VAR_DECLARATOR_LIST: { //pascal
                   names.addAll(doVarDeclaratorList(child, null));
                    break;
                }
                //---------------------------------------------------------------
                case TYPE: {
                    type = doType(child);
                    break;
                }
                //---------------------------------------------------------------
                case IDENT: {
                    names.add(doIdent(child));
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

    /////////////////
    private String doType(CommonTree t) {
        String type = "";
        String array = "";
        for (int i = 0; i < t.getChildCount(); i++) {
            CommonTree child = (CommonTree)t.getChild(i);
            Operation1 op = OperationUtil.get(lang, child);
            switch (op) {
                case TYPE_NAME: {   //custom type
                    type = doQualifiedTypeIdent(child);
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

    //////////////////
    private void doBlockScope(CommonTree t, TreeNode node) {
        for (int i = 0; i < t.getChildCount(); i++) {
            CommonTree child = (CommonTree)t.getChild(i);
            if (lang.equals(Lang.PASCAL)) {
                doExpr(child, node);
            }
            Operation1 op = OperationUtil.get(lang, child);
            switch (op) {
                case SIMPLE_DECL: {  //cpp
                    doSimpleDeclaration(child, node);
                    break;
                }
                case BLOCK_SCOPE: {  //cpp
                    doBlockScope(child, node);
                    break;
                }

                case VAR_DECLARATION: {
                    doVarDeclaration(child, node);
                    break;
                }
                //-----------------------------------------------
                case EXPR: {
                    doExpr(child, node);
                    break;
                }
                //-----------------------------------------------
                case EXPR_STATEMENT: {  //cpp
                    doExpr((CommonTree) child.getChild(0), node);
                    break;
                }
                //---------------------------------------------------------------------------------
                case IF: {
                    doIf(child, node);
                    break;
                }
                //---------------------------------------------------------------------------------
                case ITERATION: {
                    doIteration(child, node);
                    break;
                }
                //---------------------------------------------------------------------------------
                case WHILE: {
                    doWhile(child, node);
                    break;
                }
                //---------------------------------------------------------------------------------
                case FOR: {
                    doFor(child, node);
                    break;
                }
                //---------------------------------------------------------------------------------
                case RETURN: {
                    doExpr((CommonTree)child.getChild(0), node);
                    break;
                }
                //---------------------------------------------------------------------------------
                case JUMP_STATEMENT: {
                    doExpr((CommonTree)child.getChild(1).getChild(0), node);
                    break;
                }
                //---------------------------------------------------------------------------------

                default: {
                    break;
                }
            }
        }
    }

    //////////////////
    private void doIf(CommonTree t, TreeNode node) {
        TreeNode ifNode = new TreeNode(h++, "", node);
        String c1 = "", c2="";
        for (int i = 0; i < t.getChildCount(); i++) {
            CommonTree child = (CommonTree)t.getChild(i);
            if (lang.equals(Lang.PASCAL) && StringUtils.isBlank(c1)) {
                c1 = doExpr(child, ifNode);
            }
            String temp = doIfWhileBlock(child, ifNode);
            if (StringUtils.isNotBlank(temp)) {
                c2 = temp;
            }
        }
        ifNode.setName("if (" + c1 + c2 + ")");
        ifNode.setOperation("if");
        nodes.add(ifNode);
        ac.incIfs();
    }

     ////////////////
    private String doIfWhileBlock(CommonTree t, TreeNode node) {
        String condition = "";
        Operation1 op = OperationUtil.get(lang, t);
        switch (op) {
            case PARENTESIZED_EXPR: {
                condition = doParenthesizedExpr(t, node);
                break;
            }
            case CONDITION: {
                condition = doExpr((CommonTree)t.getChild(0), node);
                break;
            }

            case BLOCK_SCOPE: {
                doBlockScope(t, node);
                break;
            }
        }
        return condition;
    }

    /////////
    private void doIteration(CommonTree t, TreeNode node){
        CommonTree type = (CommonTree)t.getChild(0).getChild(0);
        Operation1 op = OperationUtil.get(lang, type);
        switch (op){
            case WHILE:{
                doWhile(t, node);
                break;
            }
            case FOR:{
                doFor(t, node);
                break;
            }
            default:{
                break;
            }
        }
    }

    ///////////////
    private void doWhile(CommonTree t, TreeNode node) {
        TreeNode whileNode = new TreeNode(h++, "", node);
        String c1 = "", c2="";
        for (int i = 0; i < t.getChildCount(); i++) {
            CommonTree child = (CommonTree)t.getChild(i);
            //pascal
            if (lang.equals(Lang.PASCAL) && StringUtils.isBlank(c1)) {
                c1 = doExpr(child, whileNode);
            }
            String temp = doIfWhileBlock(child, whileNode);
            if (StringUtils.isNotBlank(temp)) {
                c2 = temp;
            }
        }
        whileNode.setName("while (" + c1 + c2 + ")");
        whileNode.setOperation("cycle");
        nodes.add(whileNode);
        ac.incCycle();
    }

    private void doFor(CommonTree t, TreeNode node) {
        TreeNode forNode = new TreeNode(h++, "", node);
        String name = "";
        for (int i = 0; i < t.getChildCount(); i++) {
            CommonTree child = (CommonTree)t.getChild(i);
            Operation1 op = OperationUtil.get(lang, child);
            switch (op) {
                case FOR_INIT: {
                    doForInit(child, forNode);
                    break;
                }
                case FOR_CONDITION: {
                    name += doForCondition(child, forNode) + " ; ";
                    break;
                }
                case CONDITION: {
                    name += doExpr((CommonTree)child.getChild(0), node)+ " ; ";
                    break;
                }

                case FOR_UPDATE: {
                    name += doForUpdate(child, forNode);
                    break;
                }

                case TO: {
                    name += doTo(child, forNode);
                    break;
                }

                case BLOCK_SCOPE: {
                    doBlockScope(child, forNode);
                    break;
                }
            }
        }
        forNode.setName("for (" + name + ")");
        forNode.setOperation("cycle");
        nodes.add(forNode);
        ac.incCycle();
    }

    private String doTo(CommonTree t, TreeNode node) {
        CommonTree init = (CommonTree) t.getChild(0);
        String assign = doExpr(init, node);
        TreeNode assignNode = new TreeNode(h++, "ASSIGN"+assign, node);
        nodes.add(assignNode);
        CommonTree con = (CommonTree) t.getChild(1);
        String condition = doExpr(con, node);
        TreeNode conditionNode = new TreeNode(h++, "LESS"+condition, node);
        nodes.add(conditionNode);
        return assign + condition;
    }

    //////////////////////
    private void doForInit(CommonTree t, TreeNode node) {
        for (int i = 0; i < t.getChildCount(); i++) {
            CommonTree child = (CommonTree)t.getChild(i);
            Operation1 op = OperationUtil.get(lang, child);
            switch (op) {
                case VAR_DECLARATION: {
                    doVarDeclaration(child, node);
                    break;
                }
                case SIMPLE_DECL:{
                    doSimpleDeclaration(child, node);
                    break;
                }
                default:{
                    break;
                }
            }
        }
    }

    //////////////////
    private String doForCondition(CommonTree t, TreeNode node) {
        String name = "";
        for (int i = 0; i < t.getChildCount(); i++) {
            CommonTree child = (CommonTree)t.getChild(i);
            Operation1 op = OperationUtil.get(lang, child);
            switch (op) {
                case EXPR: {
                    name = doExpr(child, node);
                    break;
                }
            }
        }
        return name;
    }

    ////////////////
    private String doForUpdate(CommonTree t, TreeNode node) {
        String name = "";
        for (int i = 0; i < t.getChildCount(); i++) {
            CommonTree child = (CommonTree)t.getChild(i);
            Operation1 op = OperationUtil.get(lang, child);
            switch (op) {
                case EXPR: {
                    name = doExpr( child, node);
                    break;
                }
            }
        }
        return name;
    }

    ////////
    private String doParenthesizedExpr(CommonTree t, TreeNode node) {
        String name = "";
        for (int i = 0; i < t.getChildCount(); i++) {
            CommonTree child = (CommonTree)t.getChild(i);
            Operation1 op = OperationUtil.get(lang, child);
            switch (op) {
                case EXPR: {
                    name = doExpr(child, node);
                    break;
                }
            }
        }
        return name;
    }

    ////////////////////////////
    private void doClassTopLevelScope(CommonTree t, TreeNode node) {
        for (int i = 0; i < t.getChildCount(); i++) {
            CommonTree child = (CommonTree)t.getChild(i);
            Operation1 op = OperationUtil.get(lang, child);
            switch (op) {
                case VAR_DECLARATION: {
                    doVarDeclaration( child, node);
                    break;
                }
               //----------------------------------------------------------------------------------
                case SIMPLE_DECL: { //used for var init in class
                    doSimpleDeclaration(child, node);
                    break;
                }
                //----------------------------------------------------------------------------------
                case VOID_METHOD_DECL: {
                    doMethod(child, node);
                    break;
                }
                //----------------------------------------------------------------------------------------
                case FUNCTION_METHOD_DECL: {
                    doMethod(child, node);
                    break;
                }
                //------------------------------------------------------------------------------------------
                default: {
                    break;
                }
            }
        }
    }

    //////////////
    private String doIdent(CommonTree t) {
        return t.getText();
    }
}