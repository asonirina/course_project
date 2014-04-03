package by.bsu.project.plagiat.model;

/**
 * User: iason
 * Date: 03.04.14
 */
public enum Type {
    DECIMAL("decimal"),
    STRING("string"),
    FLOATING_POINT("floating point"),
    BOOL("boolean");

    String name;

    private Type(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
