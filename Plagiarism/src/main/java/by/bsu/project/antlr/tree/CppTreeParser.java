package by.bsu.project.antlr.tree;

import by.bsu.project.antlr.lang.OperationUtil;
import by.bsu.project.antlr.model.TreeNode;
import by.bsu.project.general.lang.LangWrap;
import org.antlr.runtime.CommonToken;
import org.antlr.runtime.tree.CommonTree;
import org.antlr.runtime.tree.Tree;
import org.apache.commons.lang.StringUtils;

import java.util.ArrayList;
import java.util.List;

import static by.bsu.project.general.lang.LangWrap.Lang;
import static by.bsu.project.general.lang.LangWrap.Operation;

/**
 * User: iason
 * Date: 02.11.15
 */
public class CppTreeParser extends BaseParser {

    public CppTreeParser(Lang lang) {
        super(lang);
    }

    public CppTreeParser(Lang lang, boolean checkIdentifiers) {
        super(lang, checkIdentifiers);
    }

    protected void doTree(CommonTree t, TreeNode node) {
        Operation op = OperationUtil.get(lang, t);
        switch (op) {
            case SIMPLE_DECL: {
                doSimpleDeclaration(t, node);
                break;
            }
            case FUNCTION_METHOD_DECL: {
                doMethod(t, node);
                break;
            }
            default: {
                break;
            }
        }
    }

    private void doClass(CommonTree t, TreeNode node) {
        String name = "";
        TreeNode classNode = createTreeNode("", node, Operation.CLASS_DECL);
        classNode.setStart(((CommonToken)t.getToken()).getStartIndex());
        for (CommonTree child : getChildren(t)) {
            Operation op = OperationUtil.get(lang, child);
            switch (op) {
                case CLASS_NAME: {
                    classNode.setStop(((CommonToken)((CommonTree)child.getChild(0)).getToken()).getStopIndex());
                    name = doIdent((CommonTree) child.getChild(0));
                    break;
                }
                case CLASS_CONTENT: {
                    doClassTopLevelScope(child, classNode);
                    break;
                }
                default: {
                    break;
                }
            }
        }
        classNode.setName(Operation.CLASS_DECL.name() + ' ' + name);
        nodes.add(classNode);
    }

    private void doSimpleDeclaration(CommonTree t, TreeNode node) {
        for (CommonTree child : getChildren(t)) {
            Operation op = OperationUtil.get(lang, child);
            switch (op) {
                case CLASS_DECL: {
                    doClass((CommonTree) child.getChild(0), node);
                    break;
                }
                case VAR_DECLARATION: {
                    doVarDeclaration(child, node);
                    break;
                }
                case VAR_DECLARATOR_LIST: {
                    doVarDeclaratorList(child, node, new ArrayList<int[]>());
                    break;
                }
                default: {
                    break;
                }
            }
        }
    }

    private String doVarDeclaration(CommonTree t, TreeNode node) {
        String type = "";
        String name = "";
        TreeNode varDeclarationNode = createTreeNode("", node, Operation.VAR_DECLARATION);
        for (CommonTree child : getChildren(t)) {
            Operation op = OperationUtil.get(lang, child);
            switch (op) {
                case NAME: {
                    varDeclarationNode.setStart(((CommonToken) ((CommonTree) child.getChild(0)).getToken()).getStartIndex());
                    varDeclarationNode.setStop(((CommonToken) ((CommonTree) child.getChild(0)).getToken()).getStopIndex());
                    name = doIdent((CommonTree) child.getChild(0));
                    break;
                }
                case TYPE: {
                    type = getType(doType(child));
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
        varDeclarationNode.setName(type + ' ' + name);
        nodes.add(varDeclarationNode);

        return varDeclarationNode.getName();
    }

    private List<String> doVarDeclaratorList(CommonTree t, TreeNode node, List<int[]> indexes) {
        List<String> names = new ArrayList<>();
        for (CommonTree child : getChildren(t)) {
            Operation op = OperationUtil.get(lang, child);
            switch (op) {
                case VAR_DECLARATION: {
                    doVarDeclaration(child, node);
                    break;
                }
                case IDENT: {
                    int temp[] = new int[2];
                    temp[0] = ((CommonToken) ((CommonTree) child.getChild(0)).getToken()).getStartIndex();
                    temp[1] = ((CommonToken) ((CommonTree) child.getChild(0)).getToken()).getStopIndex();
                    indexes.add(temp);
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

    private String doCppLinearExpression(CommonTree t, TreeNode node) {
        if (t.getChildCount() == 1) {
            return doExpr((CommonTree) t.getChild(0), node);
        }
        List<String> arr = new ArrayList<>();
        for (CommonTree child : getChildren(t)) {
            Operation op = OperationUtil.get(lang, child);
            switch (op) {
                case FIELD: {
                    arr.add(doExpr(child, node));
                    break;
                }
                case IDENT: {
                    arr.add(doIdent(child));
                    break;
                }
                case OUT:   {
                    doBinOperator(t, node, LangWrap.Operation.OUT);
                    break;
                }
                default: {
                    break;
                }
            }
        }
        return StringUtils.join(arr, ' ');
    }

    protected String doCommonExpression(CommonTree t, TreeNode node) {
        String res = "";
        Operation op = OperationUtil.get(lang, t);
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

    protected String doBinOperator(CommonTree t, TreeNode node, Operation operation) {
        List<String> arr = new ArrayList<>();
        TreeNode bin = createTreeNode("", node, operation);
        for (CommonTree child : getChildren(t)) {
            String temp = doExpr(child, bin);
            if (StringUtils.isNotBlank(temp)) {
                arr.add(temp);
            }
        }
        bin.setName(operation.name() + ' ' + StringUtils.join(arr, ' '));
        bin.setStart(((CommonToken)t.getToken()).getStartIndex());
        bin.setStop(((CommonToken)t.getToken()).getStopIndex());
        nodes.add(bin);
        return bin.getName();
    }

    protected String doMethodCall(CommonTree t, TreeNode node) {
        String name = "";
        TreeNode methodCall = createTreeNode("", node, Operation.METHOD_CALL);
        for (CommonTree child : getChildren(t)) {
            Operation op = OperationUtil.get(lang, child);
            switch (op) {
                case CALLEE: {
                    List<CommonTree> list = getChildren(child);
                    methodCall.setStart(((CommonToken)list.get(0).getToken()).getStartIndex());
                    methodCall.setStop(((CommonToken)list.get(list.size() - 1).getToken()).getStopIndex());
                    name = doDot(child);
                    break;
                }
                case ARGUMENT: {
                    doCppLinearExpression(child, methodCall);
                    break;
                }
            }
        }
        methodCall.setName(name);
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

    private String doConstructorCall(CommonTree t, TreeNode node) {
        TreeNode constructor = new TreeNode(h++, "", node);
        for (int i = 0; i < t.getChildCount(); i++) {
            CommonTree child = (CommonTree) t.getChild(i);
            Operation op = OperationUtil.get(lang, child);
            switch (op) {
                case QUALIFIED_TYPE_IDENT: {
                    constructor.setName(Operation.NEW.name() + ' ' + doQualifiedTypeIdent(child));
                    break;
                }
                case ARGUMENT_LIST: {
                    doArgumentList(child, constructor);
                    break;
                }
                default: {
                    break;
                }
            }
        }
        constructor.setOperation(Operation.CLASS_CONSTRUCTOR_CALL);
        nodes.add(constructor);

        return constructor.getName();
    }

    private String doQualifiedTypeIdent(CommonTree t) {
        String name = "";
        for (int i = 0; i < t.getChildCount(); i++) {
            CommonTree child = (CommonTree) t.getChild(i);
            Operation op = OperationUtil.get(lang, child);
            switch (op) {
                case IDENT: {
                    name = Operation.QUALIFIED_TYPE_IDENT.name() + ' ' + (checkIdentifiers ? child.getText() : "");
                }
            }
        }
        return name;
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
        List<Operation> types = new ArrayList<>();
        TreeNode methodNode = createTreeNode("", node, Operation.FUNCTION_METHOD_DECL);

        for (CommonTree child : getChildren(t)) {
            Operation op = OperationUtil.get(lang, child);
            switch (op) {
                case RETURN_TYPE: { //cpp
                    types = doType(child);
                    break;
                }
                case FUNCTION_NAME: {
                    methodNode.setStart(((CommonToken) ((CommonTree) child.getChild(0)).getToken()).getStartIndex());
                    methodNode.setStop(((CommonToken) ((CommonTree) child.getChild(0)).getToken()).getStopIndex());
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
                default: {
                    break;
                }
            }
        }
        methodNode.setName(getType(types) + name + ' ' + StringUtils.join(params, ' '));
        nodes.add(methodNode);
        ac.incMethod();
    }

    protected String doFormalParam(CommonTree t) {
        List<String> names = new ArrayList<>();
        List<Operation> types = new ArrayList<>();
        for (CommonTree child : getChildren(t)) {
            Operation op = OperationUtil.get(lang, child);
            switch (op) {
                case TYPE: {
                    types = doType(child);
                    break;
                }
                case NAME: {
                    names.add(doIdent((CommonTree)child.getChild(0)));
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
        for (CommonTree child :getChildren(t)) {
            Operation op = OperationUtil.get(lang, child);
            switch (op) {
                case TYPE_NAME: {
                    type = Operation.QUALIFIED_TYPE_IDENT;
                    break;
                }
                case ARRAY: {
                    array = Operation.ARRAY;
                    break;
                }
                case POINTER: {
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
            Operation op = OperationUtil.get(lang, child);
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
                case EXPR: {
                    doExpr(child, node);
                    break;
                }
                case EXPR_STATEMENT: {  //cpp
                    doExpr((CommonTree) child.getChild(0), node);
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
                case SIMPLE_DECL: {
                    doSimpleDeclaration(child, node);
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

    private void doClassTopLevelScope(CommonTree t, TreeNode node) {
        for (CommonTree child : getChildren(t)) {
            Operation op = OperationUtil.get(lang, child);
            switch (op) {
                case VAR_DECLARATION: {
                    doVarDeclaration(child, node);
                    break;
                }
                case SIMPLE_DECL: { //used for var init in class
                    doSimpleDeclaration(child, node);
                    break;
                }
                case FUNCTION_METHOD_DECL: {
                    doMethod(child, node);
                    break;
                }
                default: {
                    break;
                }
            }
        }
    }
}