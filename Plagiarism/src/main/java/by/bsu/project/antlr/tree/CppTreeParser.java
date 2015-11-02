package by.bsu.project.antlr.tree;

import by.bsu.project.antlr.lang.OperationUtil;
import by.bsu.project.antlr.model.TreeNode;
import by.bsu.project.general.lang.LangWrap;
import org.antlr.runtime.CommonToken;
import org.antlr.runtime.tree.CommonTree;
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
        String res = super.doCommonExpression(t, node);
        if(StringUtils.isNotBlank(res)) {
            return res;
        }
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
            default: {
                break;
            }
        }
        return res;
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
        for (CommonTree child : getChildren(t)) {
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

    protected List<Operation> doType(CommonTree t) {
        Operation type = Operation.NULL;
        boolean array = false;
        for (CommonTree child : getChildren(t)) {
            Operation op = doSingleType(child);
            if (op.equals(Operation.ARRAY) || op.equals(Operation.POINTER)) {
                array = true;
            } else {
                type = op;
            }
        }
        List<Operation> types = new ArrayList<>();
        if (!type.equals(Operation.NULL)) {
            types.add(type);
        }
        if (array) {
            types.add(Operation.ARRAY);
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


    protected void doCommonIfWhile(CommonTree t, TreeNode node, Operation o) {
        TreeNode commonNode = createTreeNode("", node, o);
        String name = "";
        for (CommonTree child : getChildren(t)) {
            Operation op = OperationUtil.get(lang, child);
            switch (op) {
                case KEYWORD:{
                    commonNode.setStart(((CommonToken)((CommonTree)child.getChild(0)).getToken()).getStartIndex());
                    commonNode.setStop(((CommonToken)((CommonTree)child.getChild(0)).getToken()).getStopIndex());
                    break;
                }
                default:  {
                    String temp = doIfWhileBlock(child, commonNode);
                    if(StringUtils.isNotBlank(temp)) {
                        name = temp;
                    }
                    break;
                }
            }
        }
        commonNode.setName(o.name() + ' ' + name);
        nodes.add(commonNode);
    }

    private String doIfWhileBlock(CommonTree t, TreeNode node) {
        String condition = "";
        Operation op = OperationUtil.get(lang, t);
        switch (op) {
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

    private void doFor(CommonTree t, TreeNode node) {
        TreeNode forNode = createTreeNode("", node, Operation.FOR);

        String name = "";
        for (CommonTree child : getChildren(t)) {
            Operation op = OperationUtil.get(lang, child);
            switch (op) {
                case KEYWORD:{
                    forNode.setStart(((CommonToken)((CommonTree)child.getChild(0)).getToken()).getStartIndex());
                    forNode.setStop(((CommonToken)((CommonTree)child.getChild(0)).getToken()).getStopIndex());
                    break;
                }
                case FOR_INIT: {
                    doForInit(child, forNode);
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
                case BLOCK_SCOPE: {
                    doBlockScope(child, forNode);
                    break;
                }
                default: {
                    break;
                }
            }
        }
        forNode.setName(Operation.FOR.name() + ' ' + name);
        nodes.add(forNode);
    }

    private void doForInit(CommonTree t, TreeNode node) {
        for (CommonTree child : getChildren(t)) {
            Operation op = OperationUtil.get(lang, child);
            switch (op) {
                case EXPR: {
                    doExpr(child, node);
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

    private String doForUpdate(CommonTree t, TreeNode node) {
        String name = "";
        for (CommonTree child : getChildren(t)) {
            Operation op = OperationUtil.get(lang, child);
            switch (op) {
                case EXPR: {
                    name = doExpr(child, node);
                    break;
                }
                default:{
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