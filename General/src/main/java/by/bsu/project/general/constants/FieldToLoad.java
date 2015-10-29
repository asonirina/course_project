package by.bsu.project.general.constants;

/**
 * User: iason
 * Date: 27.10.15
 */
public enum FieldToLoad {
    ATTRIBUTE_COUNTING("ac"),
    PROGRAM_FILES("programFiles"),
    USER_TASKS("userTasks"),
    SINGLE_TESTS("tests"),
    NEURAL_NODE("neuralNode");

    private String name;

    private FieldToLoad(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
