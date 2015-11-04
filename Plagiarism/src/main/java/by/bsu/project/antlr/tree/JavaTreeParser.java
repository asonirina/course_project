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
 * Date: 30.10.05
 */
public class JavaTreeParser extends BaseParser {

    public JavaTreeParser(Lang lang) {
        super(lang);
    }

    public JavaTreeParser(Lang lang, boolean checkIdentifiers) {
        super(lang, checkIdentifiers);
    }

    protected void doTree(CommonTree t, TreeNode node) {
        Operation op = OperationUtil.get(lang, t);
        if (op.equals(Operation.CLASS_DECL)) {
            doClass(t, node);
        }
    }

    private void doClass(CommonTree t, TreeNode node){
        String name = "";
        TreeNode classNode = createTreeNode("", node, Operation.CLASS_DECL);
        classNode.setTokenIndex(getIndex(t));
        for (CommonTree child : getChildren(t)) {

            Operation op = OperationUtil.get(lang, child);
            switch (op) {
                case IDENT: {
                    name = doIdent(child);
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

    private String doVarDeclaration(CommonTree t, TreeNode node) {
        List<Operation> types = new ArrayList<>();
        List<String> names = new ArrayList<>();
        List<Integer> indexes = new ArrayList<>();

        for (CommonTree child : getChildren(t)) {
            Operation op = OperationUtil.get(lang, child);
            switch (op) {
                case VAR_DECLARATOR_LIST: {
                    names.addAll(doVarDeclaratorList(child, node, indexes));
                    break;
                }
                case TYPE: {
                    types = doType(child);
                    break;
                }
                default: {
                    break;
                }
            }
        }
        for (int i = 0; i < names.size(); i++) {
            String name = names.get(i);
            int index = indexes.get(i);
            TreeNode varDeclarationNode = createTreeNode(getType(types) + ' ' + name, node, Operation.VAR_DECLARATION);
            varDeclarationNode.setTokenIndex(index);
            nodes.add(varDeclarationNode);
        }
        return getType(types) + StringUtils.join(names.toArray());
    }

    private List<String> doVarDeclaratorList(CommonTree t, TreeNode node, List<Integer> indexes) {
        List<String> names = new ArrayList<>();
        for (CommonTree child : getChildren(t)) {
            Operation op = OperationUtil.get(lang, child);
            switch (op) {
                case VAR_DECLARATOR: {
                    indexes.add(getIndex(child.getChild(0)));
                    names.add(doVarDeclarator(child, node));
                    break;
                }
                case IDENT: {
                    indexes.add(getIndex(child.getChild(0)));
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
        int index = -10;
        for (CommonTree child : getChildren(t)) {
            Operation op = OperationUtil.get(lang, child);
            switch (op) {
                case IDENT: {
                    name = doIdent(child);
                    index = getIndex(child) + 2;
                    break;
                }
                case EXPR: {
                    String exprName = name + ' ' + Operation.ASSIGN.name() + ' ' + doExpr(child, node);
                    TreeNode assignNode = createTreeNode(exprName, node, Operation.ASSIGN);
                    assignNode.setTokenIndex(index);
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
                case DOT: {
                    name = doDot(child);
                    methodCall.setTokenIndex(getIndex(child.getChild(1)));
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

    private String doConstructorCall(CommonTree t, TreeNode node) {
        TreeNode constructor = createTreeNode("", node, Operation.CLASS_CONSTRUCTOR_CALL);
        for (CommonTree child : getChildren(t)) {
            Operation op = OperationUtil.get(lang, child);
            switch (op) {
                case QUALIFIED_TYPE_IDENT: {
                    constructor.setName(Operation.NEW.name() + ' ' + doQualifiedTypeIdent(child));
                    constructor.setTokenIndex(getIndex(child.getChild(0)));
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
        nodes.add(constructor);
        return constructor.getName();
    }

    protected String doCommonExpression(CommonTree t, TreeNode node) {
        String res = super.doCommonExpression(t, node);
        if(StringUtils.isNotBlank(res)) {
            return res;
        }
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
            case CLASS_CONSTRUCTOR_CALL: {
                res = doConstructorCall(t, node);
                break;
            }
            default: {
                break;
            }
        }
        return res;
    }

    private String doQualifiedTypeIdent(CommonTree t) {
        String name = "";
        for (CommonTree child : getChildren(t)) {
            Operation op = OperationUtil.get(lang, child);
            switch (op) {
                case IDENT: {
                    name = Operation.QUALIFIED_TYPE_IDENT.name() + ' ' + doIdent(child);
                }
            }
        }
        return name;
    }

    private void doArgumentList(CommonTree t, TreeNode node) {
        for (CommonTree child : getChildren(t)) {
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
                case TYPE: { //java
                    types = doType(child);
                    break;
                }
                case IDENT: {
                    methodNode.setTokenIndex(getIndex(child));
                    name = doIdent(child) + " ";
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
                case TRY: {
                    doBlockScope((CommonTree)child.getChild(0), node);
                }
                default: {
                    break;
                }
            }
        }
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

    protected void doCommonIfWhile(CommonTree t, TreeNode node, Operation o) {
        TreeNode commonNode = createTreeNode("", node, o);
        commonNode.setTokenIndex(getIndex(t));
        String name = "";
        for (CommonTree child : getChildren(t)) {
            String temp = doIfWhileBlock(child, commonNode);
            if (StringUtils.isNotBlank(temp)) {
                name = temp;
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
                case FOR_INIT: {
                    doForInit(child, forNode);
                    break;
                }
                case FOR_CONDITION: {
                    name += doForCondition(child, forNode) + ' ';
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
                case VAR_DECLARATION: {
                    doVarDeclaration(child, node);
                    break;
                }
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

    private String doForCondition(CommonTree t, TreeNode node) {
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

    private String doParenthesizedExpr(CommonTree t, TreeNode node) {
        String name = "";
        for (CommonTree child : getChildren(t)) {
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
                case VOID_METHOD_DECL: {
                    doMethod(child, node);
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