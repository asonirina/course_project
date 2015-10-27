package by.bsu.project.general.constants;

public class ETestingConstants {
    public enum UserTaskStatus {
        IN_PROGRESS(0, "in progress"),
        FAILED(1, "failed"),
        PASSED(2, "passed"),
        APPROVED(3, "approved"),
        REJECTED(4, "rejected");

        private Integer id;
        private String name;

        private UserTaskStatus(Integer id, String name) {
            this.id = id;
            this.name = name;
        }

        public Integer getId() {
            return id;
        }

        public String getName() {
            return name;
        }
    }

    public static int UPLOADED_FILE = 0;
    public static int TESTED_FILE = 1;
    public static int READY_FILE = 2;
    public static int COMPLETE_FILE = 3;
    public static int FAILED_FILE = 5;

    public final static String POSTFIX_C = ".c";
    public final static String POSTFIX_CPP = ".cpp";
    public final static String POSTFIX_PASCAL_P = ".p";
    public final static String POSTFIX_PASCAL_PAS = ".pas";
    public final static String POSTFIX_JAVA = ".java";

    public final static String ADMIN_ROLE = "admin";
    public final static String USER_ROLE = "student";

    public final static String MODEL_ERRORS = "errors";
    public final static String MODEL_STUDENT = "student";
    public final static String MODEL_TASK = "task";
    public final static String MODEL_STUDENT_LIST = "studentList";
    public final static String MODEL_TASK_LIST = "taskList";
    public final static String MODEL_MESSAGE = "message";
    public final static String MODEL_ALERT = "alert";
    public final static String MODEL_PROGRAM_LIST = "programList";
    public final static String MODEL_PROGRAM = "program";
    public final static String MODEL_MESSAGES = "messages";
    public final static String MODEL_TEST_RESULTS = "testResults";
    public final static String MODEL_TASKS = "tasks";
    public final static String MODEL_TITLE = "title";
    public final static String MODEL_NEWS = "news";
    public final static String MODEL_FILE = "file";
    public final static String MODEL_LANG = "lang";

    public final static String TABLE_FIELD_LOGIN = "login";
    public final static String TABLE_FIELD_ID = "id";
    public final static String TABLE_FIELD_FORM = "form";
    public final static String TABLE_FIELD_PROGRAM_NAME = "program_name";
    public final static String TABLE_FIELD_RUN_STATUS = "run_status";

    public final static String TREE_NODES = "treeNodes";
    public final static String PROGRAM_NAME = "progrName";
    public final static String USER_ID = "user_id";
    public final static String TASK_ID = "task_id";

    public final static String CURRENT_FORM = "currentForm";

}
