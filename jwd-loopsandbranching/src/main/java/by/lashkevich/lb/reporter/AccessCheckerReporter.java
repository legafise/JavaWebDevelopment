package by.lashkevich.lb.reporter;

import java.util.List;

public final class AccessCheckerReporter {
    private static final String PASSWORD_INFO_MESSAGE = "\nPassword = %d";
    private static final String ACCESS_CHECK_RESULT_MESSAGE = "Access check result";
    private static final String NEW_LINE_BREAK = "\n";

    private AccessCheckerReporter() {
    }

    public static void reportPasswordInfo(int password) {
        System.out.println(String.format(PASSWORD_INFO_MESSAGE, password));
    }

    public static void reportAccessCheckResult(List<String> accesses) {
        System.out.println(ACCESS_CHECK_RESULT_MESSAGE
                + accesses + NEW_LINE_BREAK);
    }
}
