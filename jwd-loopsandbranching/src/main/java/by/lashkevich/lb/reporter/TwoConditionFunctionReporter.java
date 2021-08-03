package by.lashkevich.lb.reporter;

public final class TwoConditionFunctionReporter {
    private static final String FUNCTION_RESULT_EQUALS_MESSAGE = "Function result = %.1f\n";
    private static final String FUNCTION_INFO_MESSAGE = "\nx = %.1f";

    private TwoConditionFunctionReporter() {
    }

    public static void reportTwoConditionFunctionResult(double result) {
        System.out.println(String.format(FUNCTION_RESULT_EQUALS_MESSAGE, result));
    }

    public static void reportTwoConditionFunctionInfo(double xVariable) {
        System.out.println(String.format(FUNCTION_INFO_MESSAGE, xVariable));
    }
}
