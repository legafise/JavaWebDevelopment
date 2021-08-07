package by.lashkevich.lb.reporter;

import by.lashkevich.lb.entity.LoopsAndBranchingDate;

import static by.lashkevich.lb.reader.LoopsAndBranchingPropertiesReader.getInstance;

public final class DateValidatorReporter {
    private static final String DATE_INFO_MESSAGE_KEY = "reporter.date.info.message";
    private static final String DATE_VALIDATING_RESULT_MESSAGE_KEY = "reporter.result.message";
    private static final String NEW_LINE_BREAK = "\n";

    private DateValidatorReporter() {
    }

    public static void reportDateInfo(LoopsAndBranchingDate date) {
        System.out.println(String.format(getInstance().readMessageFromBundle(DATE_INFO_MESSAGE_KEY) + date));
    }

    public static void reportDateValidatingResult(boolean isValidDate) {
        String validatingResult = isValidDate ? "date is valid" : "date is not valid";
        System.out.println(String.format(getInstance().readMessageFromBundle(DATE_VALIDATING_RESULT_MESSAGE_KEY)
                + validatingResult) + NEW_LINE_BREAK);
    }
}
