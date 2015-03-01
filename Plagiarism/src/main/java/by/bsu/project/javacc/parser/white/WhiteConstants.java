package by.bsu.project.javacc.parser.white;

public interface WhiteConstants {

  /** End of File. */
  int EOF = 0;
  /** RegularExpression Id. */
  int hashLine = 1;
  /** RegularExpression Id. */
  int newLine = 2;
  /** RegularExpression Id. */
  int space = 3;
  /** RegularExpression Id. */
  int tab = 4;

  /** Lexical state. */
  int DEFAULT = 0;

  /** Literal token values. */
  String[] tokenImage = {
    "<EOF>",
    "\"#line \"",
    "<newLine>",
    "\" \"",
    "\"\\t\"",
  };

}
