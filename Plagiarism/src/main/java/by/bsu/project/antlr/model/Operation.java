package by.bsu.project.antlr.model;

/**
 * User: iason
 * Date: 02.04.14
 */
public enum Operation {
    PLUS(" + "),
    MINUS(" - "),
    LESS_THAN(" < "),
    GREATER_THAN(" > "),
    ASSIGN(" = "),
    EQUAL (" == "),
    NOT_EQUAL(" != "),
    LOGICAL_AND(" && ");

    private String symbol;

    Operation(String symbol) {
        this.symbol = symbol;
    }

    public String getSymbol() {
        return symbol;
    }
}
