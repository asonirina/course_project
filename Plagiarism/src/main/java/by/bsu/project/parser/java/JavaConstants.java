/* Generated By:JavaCC: Do not edit this line. JavaConstants.java */
package by.bsu.project.parser.java;


/**
 * Token literal values and constants.
 * Generated by org.javacc.parser.OtherFilesGen#start()
 */
public interface JavaConstants {

  /** End of File. */
  int EOF = 0;
  /** RegularExpression Id. */
  int newLine = 1;
  /** RegularExpression Id. */
  int hashLine = 2;
  /** RegularExpression Id. */
  int singleLineComment = 3;
  /** RegularExpression Id. */
  int multiLineComment = 4;
  /** RegularExpression Id. */
  int formalComment = 5;
  /** RegularExpression Id. */
  int endAnyMultiLineComment = 8;
  /** RegularExpression Id. */
  int CONST = 10;
  /** RegularExpression Id. */
  int GOTO = 11;
  /** RegularExpression Id. */
  int TYPE = 12;
  /** RegularExpression Id. */
  int BREAK = 13;
  /** RegularExpression Id. */
  int CASE = 14;
  /** RegularExpression Id. */
  int CATCH = 15;
  /** RegularExpression Id. */
  int CLASS = 16;
  /** RegularExpression Id. */
  int CONTINUE = 17;
  /** RegularExpression Id. */
  int _DEFAULT = 18;
  /** RegularExpression Id. */
  int DO = 19;
  /** RegularExpression Id. */
  int ELSE = 20;
  /** RegularExpression Id. */
  int FALSE = 21;
  /** RegularExpression Id. */
  int FINALLY = 22;
  /** RegularExpression Id. */
  int FLOAT = 23;
  /** RegularExpression Id. */
  int FOR = 24;
  /** RegularExpression Id. */
  int IF = 25;
  /** RegularExpression Id. */
  int IMPLEMENTS = 26;
  /** RegularExpression Id. */
  int IMPORT = 27;
  /** RegularExpression Id. */
  int INSTANCEOF = 28;
  /** RegularExpression Id. */
  int INT = 29;
  /** RegularExpression Id. */
  int INTERFACE = 30;
  /** RegularExpression Id. */
  int NATIVE = 31;
  /** RegularExpression Id. */
  int NEW = 32;
  /** RegularExpression Id. */
  int NULL = 33;
  /** RegularExpression Id. */
  int PACKAGE = 34;
  /** RegularExpression Id. */
  int RETURN = 35;
  /** RegularExpression Id. */
  int SHORT = 36;
  /** RegularExpression Id. */
  int SUPER = 37;
  /** RegularExpression Id. */
  int SWITCH = 38;
  /** RegularExpression Id. */
  int THIS = 39;
  /** RegularExpression Id. */
  int THROW = 40;
  /** RegularExpression Id. */
  int TRUE = 41;
  /** RegularExpression Id. */
  int TRY = 42;
  /** RegularExpression Id. */
  int WHILE = 43;
  /** RegularExpression Id. */
  int ASSERT = 44;
  /** RegularExpression Id. */
  int MODIFIERS = 45;
  /** RegularExpression Id. */
  int IDENTIFIER = 46;
  /** RegularExpression Id. */
  int LETTER = 47;
  /** RegularExpression Id. */
  int DIGIT = 48;
  /** RegularExpression Id. */
  int INTEGER_LITERAL = 49;
  /** RegularExpression Id. */
  int DECIMAL_LITERAL = 50;
  /** RegularExpression Id. */
  int HEX_LITERAL = 51;
  /** RegularExpression Id. */
  int OCTAL_LITERAL = 52;
  /** RegularExpression Id. */
  int FLOATING_POINT_LITERAL = 53;
  /** RegularExpression Id. */
  int EXPONENT = 54;
  /** RegularExpression Id. */
  int CHARACTER_LITERAL = 55;
  /** RegularExpression Id. */
  int STRING_LITERAL = 56;
  /** RegularExpression Id. */
  int LPAREN = 57;
  /** RegularExpression Id. */
  int RPAREN = 58;
  /** RegularExpression Id. */
  int LBRACE = 59;
  /** RegularExpression Id. */
  int RBRACE = 60;
  /** RegularExpression Id. */
  int LBRACKET = 61;
  /** RegularExpression Id. */
  int RBRACKET = 62;
  /** RegularExpression Id. */
  int SEMICOLON = 63;
  /** RegularExpression Id. */
  int COMMA = 64;
  /** RegularExpression Id. */
  int DOT = 65;
  /** RegularExpression Id. */
  int ASSIGN = 66;
  /** RegularExpression Id. */
  int GT = 67;
  /** RegularExpression Id. */
  int LT = 68;
  /** RegularExpression Id. */
  int BANG = 69;
  /** RegularExpression Id. */
  int TILDE = 70;
  /** RegularExpression Id. */
  int HOOK = 71;
  /** RegularExpression Id. */
  int COLON = 72;
  /** RegularExpression Id. */
  int EQ = 73;
  /** RegularExpression Id. */
  int LE = 74;
  /** RegularExpression Id. */
  int GE = 75;
  /** RegularExpression Id. */
  int NE = 76;
  /** RegularExpression Id. */
  int SC_OR = 77;
  /** RegularExpression Id. */
  int SC_AND = 78;
  /** RegularExpression Id. */
  int INCR = 79;
  /** RegularExpression Id. */
  int DECR = 80;
  /** RegularExpression Id. */
  int PLUS = 81;
  /** RegularExpression Id. */
  int MINUS = 82;
  /** RegularExpression Id. */
  int STAR = 83;
  /** RegularExpression Id. */
  int SLASH = 84;
  /** RegularExpression Id. */
  int BIT_AND = 85;
  /** RegularExpression Id. */
  int BIT_OR = 86;
  /** RegularExpression Id. */
  int XOR = 87;
  /** RegularExpression Id. */
  int REM = 88;
  /** RegularExpression Id. */
  int SHIFT = 89;
  /** RegularExpression Id. */
  int PLUSASSIGN = 90;
  /** RegularExpression Id. */
  int MINUSASSIGN = 91;
  /** RegularExpression Id. */
  int STARASSIGN = 92;
  /** RegularExpression Id. */
  int SLASHASSIGN = 93;
  /** RegularExpression Id. */
  int ANDASSIGN = 94;
  /** RegularExpression Id. */
  int REMASSIGN = 95;
  /** RegularExpression Id. */
  int SHIFTASSIGN = 96;
  /** RegularExpression Id. */
  int others = 98;

  /** Lexical state. */
  int DEFAULT = 0;
  /** Lexical state. */
  int inSingleLineComment = 1;
  /** Lexical state. */
  int inAnyMultiLineComment = 2;

  /** Literal token values. */
  String[] tokenImage = {
    "<EOF>",
    "<newLine>",
    "\"#line \"",
    "\"//\"",
    "\"/*\"",
    "<formalComment>",
    "<token of kind 6>",
    "<token of kind 7>",
    "\"*/\"",
    "<token of kind 9>",
    "\"const\"",
    "\"goto\"",
    "<TYPE>",
    "\"break\"",
    "\"case\"",
    "\"catch\"",
    "\"class\"",
    "\"continue\"",
    "\"default\"",
    "\"do\"",
    "\"else\"",
    "\"false\"",
    "\"finally\"",
    "\"float\"",
    "\"for\"",
    "\"if\"",
    "\"implements\"",
    "\"import\"",
    "\"instanceof\"",
    "\"int\"",
    "\"interface\"",
    "\"native\"",
    "\"new\"",
    "\"null\"",
    "\"package\"",
    "\"return\"",
    "\"short\"",
    "\"super\"",
    "\"switch\"",
    "\"this.\"",
    "\"throw\"",
    "\"true\"",
    "\"try\"",
    "\"while\"",
    "\"assert\"",
    "<MODIFIERS>",
    "<IDENTIFIER>",
    "<LETTER>",
    "<DIGIT>",
    "<INTEGER_LITERAL>",
    "<DECIMAL_LITERAL>",
    "<HEX_LITERAL>",
    "<OCTAL_LITERAL>",
    "<FLOATING_POINT_LITERAL>",
    "<EXPONENT>",
    "<CHARACTER_LITERAL>",
    "<STRING_LITERAL>",
    "\"(\"",
    "\")\"",
    "\"{\"",
    "\"}\"",
    "\"[\"",
    "\"]\"",
    "\";\"",
    "\",\"",
    "\".\"",
    "\"=\"",
    "\">\"",
    "\"<\"",
    "\"!\"",
    "\"~\"",
    "\"?\"",
    "\":\"",
    "\"==\"",
    "\"<=\"",
    "\">=\"",
    "\"!=\"",
    "\"||\"",
    "\"&&\"",
    "\"++\"",
    "\"--\"",
    "\"+\"",
    "\"-\"",
    "\"*\"",
    "\"/\"",
    "\"&\"",
    "\"|\"",
    "\"^\"",
    "\"%\"",
    "<SHIFT>",
    "\"+=\"",
    "\"-=\"",
    "\"*=\"",
    "\"/=\"",
    "<ANDASSIGN>",
    "\"%=\"",
    "<SHIFTASSIGN>",
    "<token of kind 97>",
    "<others>",
  };

}
