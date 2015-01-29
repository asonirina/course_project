package by.bsu.project.antlr.lang;

import org.antlr.runtime.*;
import org.antlr.runtime.tree.CommonTree;
import org.antlr.runtime.tree.CommonTreeAdaptor;
import org.antlr.runtime.tree.TreeAdaptor;

/**
 * User: iason
 * Date: 29.01.15
 */
public abstract class LangParser extends Parser {

    protected TreeAdaptor adaptor = new CommonTreeAdaptor();

    public void setTreeAdaptor(TreeAdaptor adaptor) {
        this.adaptor = adaptor;
    }
    public TreeAdaptor getTreeAdaptor() {
        return adaptor;
    }
    public LangParser(TokenStream input) {
        super(input);
    }

    protected LangParser(TokenStream input, RecognizerSharedState state) {
        super(input, state);
    }

    public abstract CompilationUnit compilationUnit() throws RecognitionException;

    public class CompilationUnit extends ParserRuleReturnScope {
        public CommonTree tree;
        @Override
        public Object getTree() { return tree; }
    }
}
