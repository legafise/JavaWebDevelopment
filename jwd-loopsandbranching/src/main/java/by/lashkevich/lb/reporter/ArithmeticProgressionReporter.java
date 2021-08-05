package by.lashkevich.lb.reporter;

public final class ArithmeticProgressionReporter {
    private static final String RECEIVED_NUMBER_MESSAGE = "\nReceived number = ";
    private static final String CHECKING_RESULT_MESSAGE = "Is number progression: %b\n";

    private ArithmeticProgressionReporter() {
    }

    public static void reportNumberInfo(long number) {
        System.out.println(RECEIVED_NUMBER_MESSAGE + number);
    }

    public static void reportCheckingResult(boolean isProgression) {
        System.out.println(String.format(CHECKING_RESULT_MESSAGE, isProgression));
    }
}
