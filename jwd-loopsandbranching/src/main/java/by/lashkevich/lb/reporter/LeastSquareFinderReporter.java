package by.lashkevich.lb.reporter;

public final class LeastSquareFinderReporter {
    public static final String NUMBERS_INFO = "\nFirst number = %.1f\nSecond number = %.1f";
    public static final String RESULT_EQUALS_MESSAGE = "Smallest square of two numbers = %.1f\n";

    private LeastSquareFinderReporter() {
    }

    public static void reportNumbersInfo(double firstNumber, double secondNumber) {
        System.out.println(String.format(NUMBERS_INFO, firstNumber, secondNumber));
    }

    public static void reportLeastSquareFindingResult(double leastSquare) {
        System.out.println(String.format(RESULT_EQUALS_MESSAGE, leastSquare));
    }
}
