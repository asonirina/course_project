package by.bsu.project.antlr.tree;

import by.bsu.project.antlr.lang.OperationUtil;
import by.bsu.project.antlr.model.TreeNode;
import org.antlr.runtime.tree.CommonTree;
import org.apache.commons.lang.StringUtils;

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
                case VAR: {
                    doVar(t, node);
                    break;
                }
                case PROCEDURE: {
                    doMethod(t, node);
                    break;
                }
                case FUNCTION_METHOD_DECL: {
                    doMethod(t, node);
                    break;
                }
                case BLOCK_SCOPE: {
                    doBlockScope(t, node);
                    break;
                }
                default: {
                    break;
                }
            }
    }

    private void doVar(CommonTree t, TreeNode node) {
        for (CommonTree child : getChildren(t)) {
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
        Operation type = Operation.NULL;
        List<String> names = new ArrayList<>();
        List<Integer> indexes = new ArrayList<>();

        for (CommonTree child : getChildren(t)) {
            Operation op = OperationUtil.get(lang, child);
            switch (op) {
                case VAR_DECLARATOR_LIST: {
                    names.addAll(doVarDeclaratorList(child, indexes));
                    break;
                }
                default: {
                    type = doSingleType(child);
                    break;
                }
            }
        }
        for (int i = 0; i<names.size(); i++) {
            String name = names.get(i);
            int index = indexes.get(i);
            TreeNode varDeclarationNode = createTreeNode(type.name() + ' ' + name, node, Operation.VAR_DECLARATION);
            varDeclarationNode.setTokenIndex(index);
            nodes.add(varDeclarationNode);
        }
        return type.name() + StringUtils.join(names.toArray());
    }

    private List<String> doVarDeclaratorList(CommonTree t,  List<Integer> indexes) {
        List<String> names = new ArrayList<>();
        for (CommonTree child : getChildren(t)) {
            Operation op = OperationUtil.get(lang, child);
            switch (op) {
                case IDENT: {
                    indexes.add(getIndex(child));
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

    protected String doMethodCall(CommonTree t, TreeNode node) {
        String name = "";
        TreeNode methodCall = createTreeNode("", node, Operation.METHOD_CALL);
        for (CommonTree child : getChildren(t)) {
            Operation op = OperationUtil.get(lang, child);
            switch (op) {
                case IDENT: {
                    methodCall.setTokenIndex(getIndex(child));
                    name = doIdent(child);
                    break;
                }
                case ARGUMENT_LIST: {
                    doArgumentList(child, methodCall);
                }
            }
        }
        methodCall.setName(name);
        nodes.add(methodCall);
        return name;
    }

    private void doArgumentList(CommonTree t, TreeNode node) {
        for (CommonTree child : getChildren(t)) {
            doExpr(child, node);
        }
    }

    private void doMethod(CommonTree t, TreeNode node) {
        List<String> params = new ArrayList<>();
        String name = "";
        Operation type = Operation.NULL;
        TreeNode methodNode = createTreeNode("", node, Operation.FUNCTION_METHOD_DECL);

        for (CommonTree child : getChildren(t)) {
            Operation op = OperationUtil.get(lang, child);
            switch (op) {
                case IDENT: {
                    methodNode.setTokenIndex(getIndex(child));
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
                    type = doSingleType(child);
                    break;
                }
            }
        }
        methodNode.setName(type.name() + ' ' + name + ' ' + StringUtils.join(params, ' '));
        nodes.add(methodNode);
        ac.incMethod();
    }

    protected String doFormalParam(CommonTree t) {
        List<String> names = new ArrayList<>();
        Operation type = Operation.NULL;
        for (CommonTree child : getChildren(t)) {
            Operation op = OperationUtil.get(lang, child);
            switch (op) {
                case VAR_DECLARATOR_LIST: {
                    names.addAll(doVarDeclaratorList(child, new ArrayList<Integer>()));
                    break;
                }
                default: {
                    type = doSingleType(child);
                    break;
                }
            }
        }
        String res = "";
        for (String s : names) {
            res += type.name() + " " + s + ", ";
        }
        return res.substring(0, res.length() - 2);
    }

    protected List<Operation> doType(CommonTree t) {
        Operation type = Operation.NULL;
        boolean array = false;
        for (CommonTree child : getChildren(t)) {
            Operation op = doSingleType(child);
            if(op.equals(Operation.ARRAY)) {
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
                case BLOCK_SCOPE: {
                    doBlockScope(child, node);
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
                    doExpr(child, node);
                    break;
                }
            }
        }
    }

    private String doIfWhileBlock(CommonTree t, TreeNode node) {
        Operation op = OperationUtil.get(lang, t);
        switch (op) {
            case BLOCK_SCOPE: {
                doBlockScope(t, node);
                break;
            }
            default: {
                break;
            }
        }
        return null;
    }

    protected void doCommonIfWhile(CommonTree t, TreeNode node, Operation o) {
        TreeNode commonNode = createTreeNode("", node, o);
        commonNode.setTokenIndex(getIndex(t));
        String name = "";
        for (CommonTree child : getChildren(t)) {
            Operation op = OperationUtil.get(lang, child);
            switch (op) {
                case BLOCK_SCOPE: {
                    doIfWhileBlock(child, commonNode);
                    break;
                }
                default: {
                    name = doExpr(child, commonNode);
                    break;
                }
            }
        }
        commonNode.setName(o.name() + ' ' + name);
        nodes.add(commonNode);
    }

    private void doFor(CommonTree t, TreeNode node) {
        TreeNode forNode = createTreeNode("", node, Operation.FOR);
        forNode.setTokenIndex(getIndex(t));
        String name = "";
        for (CommonTree child : getChildren(t)) {
            Operation op = OperationUtil.get(lang, child);
            switch (op) {
                case TO: {
                    name += doTo(child, forNode);
                    break;
                }
                case BLOCK_SCOPE: {
                    doBlockScope(child, forNode);
                    break;
                }
                default: {
                    name +=doIdent(child) + ' ';
                    break;
                }
            }
        }
        forNode.setName(Operation.FOR.name() + ' ' + name);
        nodes.add(forNode);
    }

    private String doTo(CommonTree t, TreeNode node) {
        List<CommonTree> children = getChildren(t);
        CommonTree init = children.get(0);
        String assign = doExpr(init, node);
        TreeNode assignNode = createTreeNode(Operation.ASSIGN.name() + ' ' + assign, node, Operation.ASSIGN);
        nodes.add(assignNode);
        CommonTree con = children.get(1);
        String condition = doExpr(con, node);
        TreeNode conditionNode = createTreeNode(Operation.LESS_THAN.name() + ' ' + condition, node, Operation.LESS_THAN);
        nodes.add(conditionNode);
        return assign + ' ' + condition;
    }
}