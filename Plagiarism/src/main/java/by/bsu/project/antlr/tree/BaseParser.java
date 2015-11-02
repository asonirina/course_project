package by.bsu.project.antlr.tree;

import by.bsu.project.antlr.lang.LangFactory;
import by.bsu.project.antlr.lang.LangLexer;
import by.bsu.project.antlr.lang.LangParser;
import by.bsu.project.antlr.lang.OperationUtil;
import by.bsu.project.antlr.model.TreeNode;
import by.bsu.project.general.lang.LangWrap;
import by.bsu.project.general.model.AttributeCounting;
import org.antlr.runtime.ANTLRInputStream;
import org.antlr.runtime.CommonToken;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.Token;
import org.antlr.runtime.tree.CommonTree;
import org.antlr.runtime.tree.CommonTreeAdaptor;
import org.antlr.runtime.tree.TreeAdaptor;
import org.apache.commons.lang.StringUtils;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * User: iason
 * Date: 30.10.15
 */
public abstract class BaseParser {
    protected int h = 0;
    protected List<TreeNode> nodes = new ArrayList<>();
    protected AttributeCounting ac;
    protected LangFactory factory;
    protected final TreeAdaptor adaptor = new CommonTreeAdaptor() {
        public Object create(Token payload) {
            return new CommonTree(payload);
        }
    };
    protected LangWrap.Lang lang;
    protected boolean checkIdentifiers = false;

    public AttributeCounting getAc() {
        return ac;
    }

    protected BaseParser(LangWrap.Lang lang) {
        this.ac = new AttributeCounting();
        this.lang = lang;
        this.factory = new LangFactory(lang);
    }


    protected BaseParser(LangWrap.Lang lang, boolean checkIdentifiers) {
        this(lang);
        this.checkIdentifiers = checkIdentifiers;
    }

    protected static List<CommonTree> getChildren(CommonTree tree) {
        if(tree.getChildren() == null) {
            return new ArrayList<>();
        }
        return (List<CommonTree>) tree.getChildren();
    }

    protected abstract void doTree(CommonTree t, TreeNode node);
    protected abstract String doMethodCall(CommonTree t, TreeNode node);
    protected abstract String doFormalParam(CommonTree t);
    protected abstract List<LangWrap.Operation> doType(CommonTree t);
    protected abstract void doCommonIfWhile(CommonTree t, TreeNode node, LangWrap.Operation o);

    protected void doRoot(CommonTree t) {
        if (t == null) {
            return;
        }
        LangWrap.Operation op = OperationUtil.get(lang, t);
        if (op.equals(LangWrap.Operation.ROOT)) {
            TreeNode root = new TreeNode(h++, LangWrap.Operation.ROOT.name(), null);
            root.setOperation(LangWrap.Operation.ROOT);
            nodes.add(root);

            for (CommonTree child : getChildren(t)) {
                doTree(child, root);
            }
        }
    }

    public List<TreeNode> getTree(byte[] bytes) {
        try {
            ANTLRInputStream in = new ANTLRInputStream(new ByteArrayInputStream(bytes));
            LangLexer lexer = factory.createLexer(in);
            CommonTokenStream tokens = new CommonTokenStream(lexer);
            LangParser parser = factory.createParser(tokens);
            parser.setTreeAdaptor(adaptor);

            CommonTree tree = (CommonTree) parser.compilationUnit().getTree();
            ac.setTokens(parser.getTokenStream().size());
            doRoot(tree);
            return nodes;
        } catch (Exception ex) {
            return null;
        }
    }

    protected TreeNode createTreeNode(String name, TreeNode parent, LangWrap.Operation operation) {
        return new TreeNode(h++, name, parent, operation);
    }

    protected String doExpr(CommonTree t, TreeNode node) {
        if(t == null){
            return "";
        }
        String res = doCommonExpression(t, node);
        if (StringUtils.isNotBlank(res)) {
            return res;
        }
        for (CommonTree child : getChildren(t)) {
            res = doCommonExpression(child, node);
            if (StringUtils.isNotBlank(res)) {
                break;
            }
        }

        return res;
    }

    protected List<String> doFormalParamList(CommonTree t) {
        List<String> params = new ArrayList<>();
        for (CommonTree child : getChildren(t)) {
            LangWrap.Operation op = OperationUtil.get(lang, child);
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

    protected String doBinOperator(CommonTree t, TreeNode node, LangWrap.Operation operation) {
        List<String> arr = new ArrayList<>();
        TreeNode bin = createTreeNode("", node, operation);
        for (CommonTree child : getChildren(t)) {
            String temp = doExpr(child, bin);
            if (StringUtils.isNotBlank(temp)) {
                arr.add(temp);
            }
        }
        bin.setName(operation.name() + ' ' + StringUtils.join(arr, ' '));
        bin.setStart(((CommonToken) t.getToken()).getStartIndex());
        bin.setStop(((CommonToken) t.getToken()).getStopIndex());
        nodes.add(bin);
        return bin.getName();
    }

    protected String doCommonExpression(CommonTree t, TreeNode node) {
        String res = "";
        LangWrap.Operation op = OperationUtil.get(lang, t);
        switch (op) {
            case METHOD_CALL: {
                res = doMethodCall(t, node);
                break;
            }
            case IDENT: {
                res = doIdent(t);
                break;
            }
            case DECIMAL_LITERAL: {
                res = doLiteral(t, LangWrap.Operation.INT);
                break;
            }

            case FLOATING_POINT_LITERAL: {
                res = doLiteral(t, LangWrap.Operation.DOUBLE);
                break;
            }

            case STRING_LITERAL: {
                res = doLiteral(t, LangWrap.Operation.STRING);
                break;
            }

            case TRUE: {
                res = doLiteral(t, LangWrap.Operation.BOOLEAN);
                break;
            }

            case FALSE: {
                res = doLiteral(t, LangWrap.Operation.BOOLEAN);
                break;
            }
            case ASSIGN: {
                res = doBinOperator(t, node, LangWrap.Operation.ASSIGN);
                break;
            }
            case PLUS: {
                res = doBinOperator(t, node, LangWrap.Operation.PLUS);
                break;
            }

            case MINUS: {
                res = doBinOperator(t, node, LangWrap.Operation.MINUS);
                break;
            }
            case EQUAL: {
                res = doBinOperator(t, node, LangWrap.Operation.EQUAL);
                break;
            }

            case NOT_EQUAL: {
                res = doBinOperator(t, node, LangWrap.Operation.NOT_EQUAL);
                break;
            }
            case LOGICAL_AND: {
                res = doBinOperator(t, node, LangWrap.Operation.LOGICAL_AND);
                break;
            }

            case LESS_THAN: {
                res = doBinOperator(t, node, LangWrap.Operation.LESS_THAN);
                break;
            }

            case GREATER_THAN: {
                res = doBinOperator(t, node, LangWrap.Operation.GREATER_THAN);
                break;
            }

            default: {
                break;
            }
        }
        return res;
    }

    protected String doLiteral(CommonTree t, LangWrap.Operation operation) {
        return operation.name() + ' ' + doIdent(t);
    }

    protected String doPostInc(CommonTree t, TreeNode node) {
        return doCommonPost(t, node, LangWrap.Operation.POST_INC);
    }

    protected String doPostDec(CommonTree t, TreeNode node) {
        return doCommonPost(t, node, LangWrap.Operation.POST_DEC);
    }

    private String doCommonPost(CommonTree t, TreeNode node, LangWrap.Operation o) {
        String name = "";
        for (CommonTree child : getChildren(t)) {
            LangWrap.Operation op = OperationUtil.get(lang, child);
            switch (op) {
                case IDENT: {
                    name = doIdent(child);
                }
            }
        }

        TreeNode post = createTreeNode(name + ' ' + LangWrap.Operation.POST_DEC.name(), node, o);
        nodes.add(post);
        return post.getName();
    }

    protected String doIdent(CommonTree t) {
        ac.incIdent(t.getText().length());
        return checkIdentifiers ? t.getText() : LangWrap.Operation.IDENT.name();
    }

    protected static String getType(List<LangWrap.Operation> types) {
        String res = "";
        for (LangWrap.Operation op : types) {
            res += op.name() + ' ';
        }
        return res;
    }

    protected LangWrap.Operation doSingleType(CommonTree t) {
        LangWrap.Operation op = OperationUtil.get(lang, t);
        switch (op) {
            case QUALIFIED_TYPE_IDENT: {
                return LangWrap.Operation.QUALIFIED_TYPE_IDENT;
            }
            case TYPE_NAME: {
                return LangWrap.Operation.QUALIFIED_TYPE_IDENT;
            }
            case ARRAY: {
                return LangWrap.Operation.ARRAY;
            }
            case INT: {
                return LangWrap.Operation.INT;
            }
            case FLOAT: {
                return LangWrap.Operation.FLOAT;
            }
            case CHAR: {
                return LangWrap.Operation.CHAR;
            }
            case DOUBLE: {
                return LangWrap.Operation.DOUBLE;
            }
            case BOOLEAN: {
                return  LangWrap.Operation.BOOLEAN;
            }
            case STRING: {
                return LangWrap.Operation.STRING;
            }
            case POINTER: {
                return LangWrap.Operation.POINTER;
            }
            default: {
                break;
            }
        }
        return LangWrap.Operation.NULL;
    }

    protected void doWhile(CommonTree t, TreeNode node) {
        doCommonIfWhile(t, node, LangWrap.Operation.WHILE);
    }

    protected void doIf(CommonTree t, TreeNode node) {
        doCommonIfWhile(t, node, LangWrap.Operation.IF);
    }
}
