package by.bsu.project.antlr.parser.pascal;

import org.antlr.runtime.ANTLRFileStream;
import org.antlr.runtime.CharStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.Token;
import org.antlr.runtime.tree.CommonTree;
import org.antlr.runtime.tree.CommonTreeAdaptor;
import org.antlr.runtime.tree.Tree;


public class TestPascal {

  public static void main(String[] args) throws Exception{
      CharStream input = new ANTLRFileStream("test/Test.pas");
      PascalLexer lexer =
        new PascalLexer(input);
      CommonTokenStream tokens = new CommonTokenStream(lexer); 
      PascalParser parser = new PascalParser(tokens);

      // launch the parser using the treeadaptor
      parser.setTreeAdaptor(adaptor);

      // Print the tree
//      System.out.println(
              printTree1((CommonTree) parser.compilationUnit().getTree(),0);
//      );

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
                        + " [" + PascalParser.tokenNames[t.getChild(i).getType()]
                        + "]");

                printTreeHelper1((CommonTree) t.getChild(i), indent + 1);
            }
        }
    }

  /** prints the tree t as XML, with recursive calls */
  private static String printTree(Tree t, int indent) {
    StringBuffer sb = new StringBuffer(indent);
    for (int i = 0; i < indent; i++) {
      sb = sb.append("  ");
    }
    sb.append("<"+getType(t)+" value=\""+t.toString().replaceAll("<", "&lt;").replaceAll("&", "&amp;").replaceAll("\"", "&quot;")+"\" line=\""+t.getLine()+"\">\n");
    for (int i = 0; i < t.getChildCount(); i++) {
      sb.append(printTree((CommonTree) t.getChild(i), indent + 1));
    }
    for (int i = 0; i < indent; i++) {
      sb = sb.append("  ");
    }
    sb.append("</"+getType(t)+">\n");
    return sb.toString(); 
  }

  /** returns the AST node type, e.g. "FOR" */
  public static String getType(Tree t) {
    return PascalParser.tokenNames[t.getType()];
  }


  public static final CommonTreeAdaptor adaptor = new CommonTreeAdaptor() {
    public Object create(Token payload) {
      return new CommonTree(payload);
    }
  };

}

