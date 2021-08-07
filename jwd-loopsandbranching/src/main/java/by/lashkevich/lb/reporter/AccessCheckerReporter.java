package by.lashkevich.lb.reporter;

import java.util.List;

import static by.lashkevich.lb.reader.LoopsAndBranchingPropertiesReader.getInstance;

public final class AccessCheckerReporter {
    private static final String PASSWORD_INFO_MESSAGE_KEY = "reporter.password.info.message";
    private static final String ACCESS_CHECK_RESULT_MESSAGE_KEY = "reporter.access.check.result.message";
    private static final String NEW_LINE_BREAK = "\n";

    private AccessCheckerReporter() {
    }

    public static void reportPasswordInfo(int password) {
        System.out.println(String.format(getInstance().readMessageFromBundle(PASSWORD_INFO_MESSAGE_KEY), password));
    }

    public static void reportAccessCheckResult(List<String> accesses) {
        System.out.println(getInstance().readMessageFromBundle(ACCESS_CHECK_RESULT_MESSAGE_KEY)
                + accesses + NEW_LINE_BREAK);
    }
}
