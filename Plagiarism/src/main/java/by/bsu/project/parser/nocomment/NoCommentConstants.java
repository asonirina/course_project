/* Generated By:JavaCC: Do not edit this line. NoCommentConstants.java */
package by.bsu.project.parser.nocomment;


/**
 * Token literal values and constants.
 * Generated by org.javacc.parser.OtherFilesGen#start()
 */
public interface NoCommentConstants {

  /** End of File. */
  int EOF = 0;
  /** RegularExpression Id. */
  int singleLineComment = 1;
  /** RegularExpression Id. */
  int anyMultiLineComment = 2;
  /** RegularExpression Id. */
  int endAnyMultiLineComment = 5;
  /** RegularExpression Id. */
  int newLine = 7;
  /** RegularExpression Id. */
  int hashLine = 8;
  /** RegularExpression Id. */
  int number = 9;
  /** RegularExpression Id. */
  int others = 10;

  /** Lexical state. */
  int DEFAULT = 0;
  /** Lexical state. */
  int inSingleLineComment = 1;
  /** Lexical state. */
  int inAnyMultiLineComment = 2;

  /** Literal token values. */
  String[] tokenImage = {
    "<EOF>",
    "\"//\"",
    "\"/*\"",
    "<token of kind 3>",
    "<token of kind 4>",
    "\"*/\"",
    "<token of kind 6>",
    "<newLine>",
    "\"#line \"",
    "<number>",
    "<others>",
  };

}
