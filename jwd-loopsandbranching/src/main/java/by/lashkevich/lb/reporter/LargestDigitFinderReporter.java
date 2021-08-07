package by.lashkevich.lb.reporter;

import static by.lashkevich.lb.reader.LoopsAndBranchingPropertiesReader.getInstance;

public final class LargestDigitFinderReporter {
    private static final String RECEIVED_NUMBER_MESSAGE_KEY = "reporter.received.number.message";
    private static final String FINDING_RESULT_MESSAGE_KEY = "reporter.largest.digit.message";

    private LargestDigitFinderReporter() {
    }

    public static void reportNumberInfo(long number) {
        System.out.println(getInstance().readMessageFromBundle(RECEIVED_NUMBER_MESSAGE_KEY) + number);
    }

    public static void reportFindingResult(int digit) {
        System.out.println(String.format(getInstance().readMessageFromBundle(FINDING_RESULT_MESSAGE_KEY), digit));
    }
}
