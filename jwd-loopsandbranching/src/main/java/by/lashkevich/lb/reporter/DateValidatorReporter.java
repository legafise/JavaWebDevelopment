package by.lashkevich.lb.reporter;

import by.lashkevich.lb.entity.LoopsAndBranchingDate;

public final class DateValidatorReporter {
    private static final String DATE_INFO_MESSAGE = "Date info: ";
    private static final String DATE_VALIDATING_RESULT_MESSAGE = "Result: ";
    private static final String NEW_LINE_BREAK = "\n";

    private DateValidatorReporter() {
    }

    public static void reportDateInfo(LoopsAndBranchingDate date) {
        System.out.println(String.format(DATE_INFO_MESSAGE + date));
    }

    public static void reportDateValidatingResult(boolean isValidDate) {
        String validatingResult = isValidDate ? "date is valid" : "date is not valid";
        System.out.println(String.format(DATE_VALIDATING_RESULT_MESSAGE
                + validatingResult) + NEW_LINE_BREAK);
    }
}
