package by.lashkevich.lb.reporter;

public final class LargestDigitFinderReporter {
    private static final String RECEIVED_NUMBER_MESSAGE = "\nReceived number = ";
    private static final String FINDING_RESULT_MESSAGE = "Largest digit = %d\n";

    private LargestDigitFinderReporter() {
    }

    public static void reportNumberInfo(long number) {
        System.out.println(RECEIVED_NUMBER_MESSAGE + number);
    }

    public static void reportFindingResult(int digit) {
        System.out.println(String.format(FINDING_RESULT_MESSAGE, digit));
    }
}
