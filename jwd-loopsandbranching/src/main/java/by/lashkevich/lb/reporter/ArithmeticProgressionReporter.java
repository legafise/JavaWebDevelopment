package by.lashkevich.lb.reporter;

import static by.lashkevich.lb.reader.LoopsAndBranchingPropertiesReader.getInstance;

public final class ArithmeticProgressionReporter {
    private static final String RECEIVED_NUMBER_MESSAGE_KEY = "reporter.received.number.message";
    private static final String CHECKING_RESULT_MESSAGE_KEY = "reporter.is.number.progression.message";

    private ArithmeticProgressionReporter() {
    }

    public static void reportNumberInfo(long number) {
        System.out.println(getInstance().readMessageFromBundle(RECEIVED_NUMBER_MESSAGE_KEY) + number);
    }

    public static void reportCheckingResult(boolean isProgression) {
        System.out.println(String.format(getInstance().readMessageFromBundle(CHECKING_RESULT_MESSAGE_KEY),
                isProgression));
    }
}
