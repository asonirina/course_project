package by.bsu.project.antlr.tree;

import by.bsu.project.antlr.lang.LangFactory;
import by.bsu.project.antlr.lang.LangLexer;
import by.bsu.project.antlr.lang.LangParser;
import by.bsu.project.antlr.lang.OperationUtil;
import by.bsu.project.antlr.model.TreeNode;
import by.bsu.project.general.model.AttributeCounting;
import org.antlr.runtime.ANTLRInputStream;
import org.antlr.runtime.CommonToken;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.Token;
import org.antlr.runtime.tree.CommonTree;
import org.antlr.runtime.tree.CommonTreeAdaptor;
import org.antlr.runtime.tree.Tree;
import org.antlr.runtime.tree.TreeAdaptor;
import org.apache.commons.lang.StringUtils;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.List;

import static by.bsu.project.general.lang.LangWrap.Lang;
import static by.bsu.project.general.lang.LangWrap.Operation;

/**
 * User: iason
 * Date: 30.10.15
 */
public class PascalTreeParser extends BaseParser {

    public PascalTreeParser(Lang lang) {
        super(lang);
    }

    public PascalTreeParser(Lang lang, boolean checkIdentifiers) {
        super(lang, checkIdentifiers);
    }


    protected void doTree(CommonTree t, TreeNode node) {
            Operation op = OperationUtil.get(lang, t);
            switch (op) {
                case VAR: { //pascal
                    doVar(t, node);
                    break;
                }
                case PROCEDURE: { //pascal
                    doMethod(t, node);
                    break;
                }
                case FUNCTION_METHOD_DECL: { //pascal
                    doMethod(t, node);
                    break;
                }
                case BLOCK_SCOPE: { //pascal
                    doBlockScope(t, node);
                    break;
                }
                default: {
                    break;
                }
            }
    }


    private void doVar(CommonTree t, TreeNode node) {
        for (int i = 0; i < t.getChildCount(); i++) {
            CommonTree child = (CommonTree) t.getChild(i);
            Operation op = OperationUtil.get(lang, child);
            switch (op) {
                case VAR_DECLARATION: {
                    doVarDeclaration(child, node);
                    break;
                }
                default: {
                    break;
                }
            }
        }
    }

    private String doVarDeclaration(CommonTree t, TreeNode node) {
        List<Operation> types = doType(t); // try to find any children TYPE (Pascal)
        List<String> names = new ArrayList<>();
        List<int[]> indexes = new ArrayList<>();

        for (int i = 0; i < t.getChildCount(); i++) {
            CommonTree child = (CommonTree) t.getChild(i);
            Operation op = OperationUtil.get(lang, child);
            switch (op) {
                case NAME: {//cpp
                    int[] temp = new int[2];
                    temp[0] = ((CommonToken)((CommonTree)child.getChild(0)).getToken()).getStartIndex();
                    temp[1] = ((CommonToken)((CommonTree)child.getChild(0)).getToken()).getStopIndex();
                    indexes.add(temp);
                    names.add(doIdent((CommonTree) child.getChild(0)));
                    break;
                }
                case VAR_DECLARATOR_LIST: {
                    names.addAll(doVarDeclaratorList(child, node, indexes));
                    break;
                }
                case TYPE: {
                    types = doType(child);
                    break;
                }
                case INIT: {
                    doExpr(child, node);
                    break;
                }
                default: {
                    break;
                }
            }
        }
        for (int i = 0; i<names.size(); i++) {
            String name = names.get(i);
            int[] temp = indexes.get(i);
            TreeNode varDeclarationNode = new TreeNode(h++, getType(types) + ' ' + name, node);
            varDeclarationNode.setOperation(Operation.VAR_DECLARATION);
            varDeclarationNode.setStart(temp[0]);
            varDeclarationNode.setStop(temp[1]);
            nodes.add(varDeclarationNode);
        }
        return getType(types) + StringUtils.join(names.toArray());
    }

    private List<String> doVarDeclaratorList(CommonTree t, TreeNode node, List<int[]> indexes) {
        List<String> names = new ArrayList<>();
        for (int i = 0; i < t.getChildCount(); i++) {
            CommonTree child = (CommonTree) t.getChild(i);
            Operation op = OperationUtil.get(lang, child);
            switch (op) {
                case VAR_DECLARATOR: {
                    if(indexes != null ){
                        int temp[] = new int[2];
                        temp[0] = ((CommonToken)((CommonTree)child.getChild(0)).getToken()).getStartIndex();
                        temp[1] = ((CommonToken)((CommonTree)child.getChild(0)).getToken()).getStopIndex();
                        indexes.add(temp);
                    }
                    names.add(doVarDeclarator(child, node));
                    break;
                }
                case IDENT: {
                    if(indexes != null ){
                        int temp[] = new int[2];
                        temp[0] = ((CommonToken)((CommonTree)child.getChild(0)).getToken()).getStartIndex();
                        temp[1] = ((CommonToken)((CommonTree)child.getChild(0)).getToken()).getStopIndex();
                        indexes.add(temp);
                    }
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

    private String doVarDeclarator(CommonTree t, TreeNode node) {
        String name = "";
        for (int i = 0; i < t.getChildCount(); i++) {
            CommonTree child = (CommonTree) t.getChild(i);
            Operation op = OperationUtil.get(lang, child);
            switch (op) {
                case IDENT: {
                    name = doIdent(child);
                    break;
                }
                case EXPR: {
                    String exprName = name + ' ' + Operation.ASSIGN.name() + ' ' + doExpr(child, node);
                    TreeNode assignNode = new TreeNode(h++, exprName, node);
                    assignNode.setOperation(Operation.ASSIGN);
                    nodes.add(assignNode);
                    break;
                }
                default: {
                    break;
                }
            }
        }
        return name;
    }

    protected String doExpr(CommonTree t, TreeNode node) {
        String res = doCommonExpression(t, node);
        if (StringUtils.isNotBlank(res)) {
            return res;
        }
        for (int i = 0; i < t.getChildCount(); i++) {
            Tree child = t.getChild(i);
            res = doCommonExpression((CommonTree) child, node);
            if (StringUtils.isNotBlank(res)) {
                break;
            }
        }

        return res;
    }

    private String doCommonExpression(CommonTree t, TreeNode node) {
        String res = "";
        Operation op = OperationUtil.get(lang, t);
        switch (op) {
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
                res = doLiteral(t, Operation.INT);
                break;
            }

            case FLOATING_POINT_LITERAL: {
                res = doLiteral(t, Operation.DOUBLE);
                break;
            }

            case STRING_LITERAL: {
                res = doLiteral(t, Operation.STRING);
                break;
            }

            case TRUE: {
                res = doLiteral(t, Operation.BOOLEAN);
                break;
            }

            case FALSE: {
                res = doLiteral(t, Operation.BOOLEAN);
                break;
            }
            case ASSIGN: {
                res = doBinOperator(t, node, Operation.ASSIGN);
                break;
            }
            case PLUS: {
                res = doBinOperator(t, node, Operation.PLUS);
                break;
            }

            case MINUS: {
                res = doBinOperator(t, node, Operation.MINUS);
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

    private String doPostInc(CommonTree t, TreeNode node) {
        String name = "";
        for (int i = 0; i < t.getChildCount(); i++) {
            CommonTree child = (CommonTree) t.getChild(i);
            Operation op = OperationUtil.get(lang, child);
            switch (op) {
                case IDENT: {
                    name = doIdent(child);
                }
            }
        }

        TreeNode postInc = new TreeNode(h++, name + ' ' + Operation.POST_INC.name(), node);
        nodes.add(postInc);
        postInc.setOperation(Operation.POST_INC);
        return postInc.getName();
    }

    private String doPostDec(CommonTree t, TreeNode node) {
        String name = "";
        for (int i = 0; i < t.getChildCount(); i++) {
            CommonTree child = (CommonTree) t.getChild(i);
            Operation op = OperationUtil.get(lang, child);
            switch (op) {
                case IDENT: {
                    name = doIdent(child);
                }
            }
        }

        TreeNode postDec = new TreeNode(h++, name + ' ' + Operation.POST_DEC.name(), node);
        nodes.add(postDec);
        postDec.setOperation(Operation.POST_DEC);
        return postDec.getName();
    }

    private String doMethodCall(CommonTree t, TreeNode node) {
        String name = "";
        TreeNode methodCall = new TreeNode(h++, "", node);
        for (int i = 0; i < t.getChildCount(); i++) {
            CommonTree child = (CommonTree) t.getChild(i);
            Operation op = OperationUtil.get(lang, child);
            switch (op) {
                case IDENT: {
                    methodCall.setStart(((CommonToken)child.getToken()).getStartIndex());
                    methodCall.setStop(((CommonToken)child.getToken()).getStopIndex());
                    name = doIdent(child);
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
        methodCall.setOperation(Operation.METHOD_CALL);
        nodes.add(methodCall);
        return name;
    }

    private String doDot(CommonTree t) {
        List<String> names = new ArrayList<>();
        for (int i = 0; i < t.getChildCount(); i++) {
            CommonTree child = (CommonTree) t.getChild(i);
            Operation op = OperationUtil.get(lang, child);
            switch (op) {
                case IDENT: {
                    names.add(doIdent(child));
                    break;
                }
                case DOT: {
                    names.add(doDot(child));
                }
                default: {
                    break;
                }
            }
        }
        return StringUtils.join(names, '.');
    }

    private void doArgumentList(CommonTree t, TreeNode node) {
        for (int i = 0; i < t.getChildCount(); i++) {
            CommonTree child = (CommonTree) t.getChild(i);
            if (lang.equals(Lang.PASCAL)) {
                doExpr(child, node);
            }
            Operation op = OperationUtil.get(lang, child);
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

    private void doMethod(CommonTree t, TreeNode node) {
        List<String> params = new ArrayList<>();
        String name = "";
        List<Operation> types = doType(t); //pascal
        TreeNode methodNode = new TreeNode(h++, "", node);

        for (int i = 0; i < t.getChildCount(); i++) {
            CommonTree child = (CommonTree) t.getChild(i);
            Operation op = OperationUtil.get(lang, child);
            switch (op) {
                case RETURN_TYPE: { //cpp
                    types = doType(child);
                    break;
                }
                case TYPE: { //java
                    types = doType(child);
                    break;
                }
                case IDENT: {
                    methodNode.setStart(((CommonToken) child.getToken()).getStartIndex());
                    methodNode.setStop(((CommonToken)child.getToken()).getStopIndex());
                    name = doIdent(child) + " ";
                    break;
                }
                case FUNCTION_NAME: {
                    name = doIdent((CommonTree) child.getChild(0)) + " ";
                    break;
                }
                case BLOCK_SCOPE: {
                    doBlockScope(child, methodNode);
                    break;
                }
                case FORMAL_PARAM_LIST: {
                    params = doFormalParamList(child);
                    break;
                }
                case VAR: {
                    doVar(child, methodNode);
                    break;
                }
                default: {
                    break;
                }
            }
        }
        methodNode.setName(getType(types) + name + ' ' + StringUtils.join(params, ' '));
        methodNode.setOperation(Operation.FUNCTION_METHOD_DECL);
        nodes.add(methodNode);
        ac.incMethod();
    }

    private static String getType(List<Operation> types) {
        String res = "";
        for (Operation op : types) {
            res += op.name() + ' ';
        }
        return res;
    }

    private List<String> doFormalParamList(CommonTree t) {
        List<String> params = new ArrayList<>();
        for (int i = 0; i < t.getChildCount(); i++) {
            CommonTree child = (CommonTree) t.getChild(i);
            Operation op = OperationUtil.get(lang, child);
            switch (op) {
                case FORMAL_PARAM_STD_DECL: {  //identifier
                    params.add(doFormalParam(child));
                    break;
                }
                default: {
                    break;
                }
            }
        }
        return params;
    }

    private String doFormalParam(CommonTree t) {
        List<String> names = new ArrayList<>();
        List<Operation> types = doType(t);  //pascal !!!
        for (int i = 0; i < t.getChildCount(); i++) {
            CommonTree child = (CommonTree) t.getChild(i);
            Operation op = OperationUtil.get(lang, child);
            switch (op) {
                case VAR_DECLARATOR_LIST: { //pascal
                    names.addAll(doVarDeclaratorList(child, null, null));
                    break;
                }
                case TYPE: {
                    types = doType(child);
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
        String res = "";
        for (String s : names) {
            res += getType(types) + " " + s + ", ";
        }
        return res.substring(0, res.length() - 2);
    }

    private List<Operation> doType(CommonTree t) {
        Operation type = Operation.NULL;
        Operation array = Operation.NULL;
        for (int i = 0; i < t.getChildCount(); i++) {
            CommonTree child = (CommonTree) t.getChild(i);
            Operation op = OperationUtil.get(lang, child);
            switch (op) {
                case QUALIFIED_TYPE_IDENT: {   //custom type
                    type = Operation.QUALIFIED_TYPE_IDENT;
                    break;
                }
                case TYPE_NAME: {
                    type = Operation.QUALIFIED_TYPE_IDENT;
                    break;
                }
                case ARRAY: {
                    array = Operation.ARRAY;
                    break;
                }
                case INT: {
                    type = Operation.INT;
                    break;
                }
                case FLOAT: {
                    type = Operation.FLOAT;
                    break;
                }
                case CHAR: {
                    type = Operation.CHAR;
                    break;
                }
                case DOUBLE: {
                    type = Operation.DOUBLE;
                    break;
                }
                case BOOLEAN: {
                    type = Operation.BOOLEAN;
                    break;
                }
                case STRING: {
                    type = Operation.STRING;
                    break;
                }
                default: {
                    break;
                }
            }
        }
        List<Operation> types = new ArrayList<>();
        if (!type.equals(Operation.NULL)) {
            types.add(type);
        }
        if (!array.equals(Operation.NULL)) {
            types.add(array);
        }
        return types;
    }

    private void doBlockScope(CommonTree t, TreeNode node) {
        for (CommonTree child : getChildren(t)) {
            doExpr(child, node);
            Operation op = OperationUtil.get(lang, child);
            switch (op) {
                case BLOCK_SCOPE: {
                    doBlockScope(child, node);
                    break;
                }
                case VAR_DECLARATION: {
                    doVarDeclaration(child, node);
                    break;
                }
                case EXPR: {
                    doExpr(child, node);
                    break;
                }
                case IF: {
                    doIf(child, node);
                    break;
                }
                case ITERATION: {
                    doIteration(child, node);
                    break;
                }
                case WHILE: {
                    doWhile(child, node);
                    break;
                }
                case FOR: {
                    doFor(child, node);
                    break;
                }
                case RETURN: {
                    doExpr((CommonTree) child.getChild(0), node);
                    break;
                }
                case JUMP_STATEMENT: {
                    doExpr((CommonTree) child.getChild(1).getChild(0), node);
                    break;
                }
                default: {
                    break;
                }
            }
        }
    }

    private void doIf(CommonTree t, TreeNode node) {
        TreeNode ifNode = new TreeNode(h++, "", node);
        ifNode.setStart(((CommonToken) t.getToken()).getStartIndex());
        ifNode.setStop(((CommonToken) t.getToken()).getStopIndex());
        String c1 = "", c2 = "";
        for (int i = 0; i < t.getChildCount(); i++) {
            CommonTree child = (CommonTree) t.getChild(i);
            if (lang.equals(Lang.PASCAL) && StringUtils.isBlank(c1)) {
                c1 = doExpr(child, ifNode);
            }
            String temp = doIfWhileBlock(child, ifNode);
            if (StringUtils.isNotBlank(temp)) {
                c2 = temp;
            }
        }
        ifNode.setName(Operation.IF.name() + ' ' + c1 + ' ' + c2);
        ifNode.setOperation(Operation.IF);
        nodes.add(ifNode);
    }

    private String doIfWhileBlock(CommonTree t, TreeNode node) {
        String condition = "";
        Operation op = OperationUtil.get(lang, t);
        switch (op) {
            case PARENTESIZED_EXPR: {
                condition = doParenthesizedExpr(t, node);
                break;
            }
            case CONDITION: {
                condition = doExpr((CommonTree) t.getChild(0), node);
                break;
            }
            case BLOCK_SCOPE: {
                doBlockScope(t, node);
                break;
            }
        }
        return condition;
    }

    private void doIteration(CommonTree t, TreeNode node) {
        CommonTree type = (CommonTree) t.getChild(0).getChild(0);
        Operation op = OperationUtil.get(lang, type);
        switch (op) {
            case WHILE: {
                doWhile(t, node);
                break;
            }
            case FOR: {
                doFor(t, node);
                break;
            }
            default: {
                break;
            }
        }
    }

    private void doWhile(CommonTree t, TreeNode node) {
        TreeNode whileNode = new TreeNode(h++, "", node);
        whileNode.setStart(((CommonToken)t.getToken()).getStartIndex());
        whileNode.setStop(((CommonToken)t.getToken()).getStopIndex());
        String c1 = "", c2 = "";
        for (int i = 0; i < t.getChildCount(); i++) {
            CommonTree child = (CommonTree) t.getChild(i);
            //pascal
            if (lang.equals(Lang.PASCAL) && StringUtils.isBlank(c1)) {
                c1 = doExpr(child, whileNode);
            }
            String temp = doIfWhileBlock(child, whileNode);
            if (StringUtils.isNotBlank(temp)) {
                c2 = temp;
            }
        }
        whileNode.setName(Operation.WHILE.name() + ' ' + c1 + ' ' + c2);
        whileNode.setOperation(Operation.WHILE);
        nodes.add(whileNode);
    }

    private void doFor(CommonTree t, TreeNode node) {
        TreeNode forNode = new TreeNode(h++, "", node);
        forNode.setStart(((CommonToken) t.getToken()).getStartIndex());
        String name = "";
        for (int i = 0; i < t.getChildCount(); i++) {
            CommonTree child = (CommonTree) t.getChild(i);
            Operation op = OperationUtil.get(lang, child);
            switch (op) {
                case FOR_INIT: {
                    doForInit(child, forNode);
                    break;
                }
                case FOR_CONDITION: {
                    name += doForCondition(child, forNode) + ' ';
                    break;
                }
                case CONDITION: {
                    name += doExpr((CommonTree) child.getChild(0), node) + ' ';
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
                    forNode.setStop(((CommonToken) child.getToken()).getStartIndex());
                    doBlockScope(child, forNode);
                    break;
                }
                default: {
                    break;
                }
            }
        }
        forNode.setName(Operation.FOR.name() + ' ' + name);
        forNode.setOperation(Operation.FOR);
        nodes.add(forNode);
    }

    private String doTo(CommonTree t, TreeNode node) {
        CommonTree init = (CommonTree) t.getChild(0);
        String assign = doExpr(init, node);
        TreeNode assignNode = new TreeNode(h++, Operation.ASSIGN.name() + ' ' + assign, node);
        assignNode.setOperation(Operation.ASSIGN);
        nodes.add(assignNode);
        CommonTree con = (CommonTree) t.getChild(1);
        String condition = doExpr(con, node);
        TreeNode conditionNode = new TreeNode(h++, Operation.LESS_THAN.name() + ' ' + condition, node);
        conditionNode.setOperation(Operation.LESS_THAN);
        nodes.add(conditionNode);
        return assign + condition;
    }

    private void doForInit(CommonTree t, TreeNode node) {
        for (int i = 0; i < t.getChildCount(); i++) {
            CommonTree child = (CommonTree) t.getChild(i);
            Operation op = OperationUtil.get(lang, child);
            switch (op) {
                case VAR_DECLARATION: {
                    doVarDeclaration(child, node);
                    break;
                }

                default: {
                    break;
                }
            }
        }
    }

    private String doForCondition(CommonTree t, TreeNode node) {
        String name = "";
        for (int i = 0; i < t.getChildCount(); i++) {
            CommonTree child = (CommonTree) t.getChild(i);
            Operation op = OperationUtil.get(lang, child);
            switch (op) {
                case EXPR: {
                    name = doExpr(child, node);
                    break;
                }
            }
        }
        return name;
    }

    private String doForUpdate(CommonTree t, TreeNode node) {
        String name = "";
        for (int i = 0; i < t.getChildCount(); i++) {
            CommonTree child = (CommonTree) t.getChild(i);
            Operation op = OperationUtil.get(lang, child);
            switch (op) {
                case EXPR: {
                    name = doExpr(child, node);
                    break;
                }
            }
        }
        return name;
    }

    private String doParenthesizedExpr(CommonTree t, TreeNode node) {
        String name = "";
        for (int i = 0; i < t.getChildCount(); i++) {
            CommonTree child = (CommonTree) t.getChild(i);
            Operation op = OperationUtil.get(lang, child);
            switch (op) {
                case EXPR: {
                    name = doExpr(child, node);
                    break;
                }
            }
        }
        return name;
    }
}