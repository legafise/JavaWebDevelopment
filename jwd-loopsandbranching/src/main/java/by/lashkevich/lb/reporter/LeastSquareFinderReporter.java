package by.lashkevich.lb.reporter;

import static by.lashkevich.lb.reader.LoopsAndBranchingPropertiesReader.getInstance;

public final class LeastSquareFinderReporter {
    public static final String NUMBERS_INFO_KEY = "reporter.numbers.info.message";
    public static final String RESULT_EQUALS_MESSAGE_KEY = "reporter.least.square.result.message";

    private LeastSquareFinderReporter() {
    }

    public static void reportNumbersInfo(double firstNumber, double secondNumber) {
        System.out.println(String.format(getInstance()
                .readMessageFromBundle(NUMBERS_INFO_KEY), firstNumber, secondNumber));
    }

    public static void reportLeastSquareFindingResult(double leastSquare) {
        System.out.println(String.format(getInstance()
                .readMessageFromBundle(RESULT_EQUALS_MESSAGE_KEY), leastSquare));
    }
}
