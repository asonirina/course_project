package by.bsu.project.antlr.cpp;

import org.antlr.runtime.*;
import org.antlr.runtime.tree.CommonTree;
import org.antlr.runtime.tree.CommonTreeAdaptor;
import org.antlr.runtime.tree.TreeAdaptor;

public class TestCPP {
    static final TreeAdaptor adaptor = new CommonTreeAdaptor() {
        public Object create(Token payload) {
            if (payload != null)
            {
                System.out.println("Create " + CPPGrammarParser.tokenNames[payload.getType()] + ":  L" + payload.getLine() + ":C" + payload.getCharPositionInLine() + " " + payload.getText());
            }
            return new CommonTree(payload);
        }
    };

	public static void main(String[] args) throws Exception {

			Lexer lexer = new CPPGrammarLexer(new ANTLRFileStream("test/Test.cpp"));

			CommonTokenStream tokens = new CommonTokenStream(lexer);

			CPPGrammarParser parser = new CPPGrammarParser(tokens);

//            parser.setTreeAdaptor(adaptor);
			CommonTree tree = parser.code().getTree();
        printTree1(tree, 1);

//			t.inspect(parser);
//			System.out.println(t.toStringTree(parser));

		}

    public static void printTree1(CommonTree t, int indent) {
        //   System.out.println(t.toString());

        printTreeHelper1(t, indent);
    }

    private static void printTreeHelper1(CommonTree t, int indent) {
        if (t != null) {
            StringBuffer sb = new StringBuffer(indent);
            for (int i = 0; i <indent; i++)
                sb = sb.append("___");
            for (int i = 0; i < t.getChildCount(); i++) {
                System.out.println(sb.toString() + t.getChild(i).getType()+" "+t.getChild(i).toString()
                        + " [" + CPPGrammarParser.tokenNames[t.getChild(i).getType()]
                        + "]");

                printTreeHelper1((CommonTree) t.getChild(i), indent + 1);
            }
        }
    }
	}

