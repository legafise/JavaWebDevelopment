package by.lashkevich.lb.reporter;

import java.util.List;
import java.util.Map;

public final class FunctionReporter {
    private static final String TWO_CONDITION_FUNCTION_RESULT_EQUALS_MESSAGE = "Function result = %.1f\n";
    private static final String FUNCTION_WITH_STEP_RESULT_EQUALS_MESSAGE = "Function result = ";
    private static final String FUNCTION_WITH_STEP_INFO_MESSAGE = "\nLine segment [%.1f, %.1f]; Step = %.1f";
    private static final String FUNCTION_WITHOUT_DATA_ENTRY_INFO_MESSAGE = "\nLine segment [-5, 5]; Step = 0.5";
    private static final String TWO_CONDITION_FUNCTION_INFO_MESSAGE = "\nx = %.1f";
    private static final String NEW_LINE_BREAK = "\n";

    private FunctionReporter() {
    }

    public static void reportTwoConditionFunctionResult(double result) {
        System.out.println(String.format(TWO_CONDITION_FUNCTION_RESULT_EQUALS_MESSAGE, result));
    }

    public static void reportTwoConditionFunctionInfo(double xVariable) {
        System.out.println(String.format(TWO_CONDITION_FUNCTION_INFO_MESSAGE, xVariable));
    }

    public static void reportFunctionWithoutDataEntryInfo() {
        System.out.println(String.format(FUNCTION_WITHOUT_DATA_ENTRY_INFO_MESSAGE));
    }

    public static void reportFunctionWithStepInfo(List<Double> variables) {
        System.out.println(String.format(FUNCTION_WITH_STEP_INFO_MESSAGE,
                variables.get(0), variables.get(1), variables.get(2)));
    }

    public static void reportTableFunctionResult(Map<Double, Double> result) {
        System.out.println(FUNCTION_WITH_STEP_RESULT_EQUALS_MESSAGE + result
                + NEW_LINE_BREAK);
    }

    public static void reportFunctionWithStepResult(List<Double> result) {
        System.out.println(FUNCTION_WITH_STEP_RESULT_EQUALS_MESSAGE + result
                + NEW_LINE_BREAK);
    }
}
