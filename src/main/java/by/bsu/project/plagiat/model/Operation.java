package by.bsu.project.plagiat.model;

/**
 * User: iason
 * Date: 02.04.14
 */
public enum Operation {
    PLUS(" + "),
    MINUS(" - "),
    LESS_THAN(" < "),
    ASSIGN(" = ");

    private String symbol;

    Operation(String symbol) {
        this.symbol = symbol;
    }

    public String getSymbol() {
        return symbol;
    }
}
