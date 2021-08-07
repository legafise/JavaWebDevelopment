package by.lashkevich.lb.reporter;

import java.util.List;
import java.util.Map;

import static by.lashkevich.lb.reader.LoopsAndBranchingPropertiesReader.getInstance;

public final class FunctionReporter {
    private static final String TWO_CONDITION_FUNCTION_RESULT_EQUALS_MESSAGE_KEY =
            "reporter.format.function.result.message";
    private static final String FUNCTION_WITH_STEP_RESULT_EQUALS_MESSAGE_KEY = "reporter.function.result.message";
    private static final String FUNCTION_WITH_STEP_INFO_MESSAGE_KEY = "reporter.function.with.step.message";
    private static final String FUNCTION_WITHOUT_DATA_ENTRY_INFO_MESSAGE_KEY =
            "reporter.without.data.entry.function.with.step.message";
    private static final String TWO_CONDITION_FUNCTION_INFO_MESSAGE_KEY = "reporter.two.condition.function.message";
    private static final String NEW_LINE_BREAK = "\n";

    private FunctionReporter() {
    }

    public static void reportTwoConditionFunctionResult(double result) {
        System.out.println(String.format(getInstance()
                .readMessageFromBundle(TWO_CONDITION_FUNCTION_RESULT_EQUALS_MESSAGE_KEY),result));
    }

    public static void reportTwoConditionFunctionInfo(double xVariable) {
        System.out.println(String.format(getInstance().readMessageFromBundle(TWO_CONDITION_FUNCTION_INFO_MESSAGE_KEY),
                xVariable));
    }

    public static void reportFunctionWithoutDataEntryInfo() {
        System.out.println(String.format(getInstance()
                .readMessageFromBundle(FUNCTION_WITHOUT_DATA_ENTRY_INFO_MESSAGE_KEY)));
    }

    public static void reportFunctionWithStepInfo(List<Double> variables) {
        System.out.println(String.format(getInstance().readMessageFromBundle(FUNCTION_WITH_STEP_INFO_MESSAGE_KEY),
                variables.get(0), variables.get(1), variables.get(2)));
    }

    public static void reportTableFunctionResult(Map<Double, Double> result) {
        System.out.println(getInstance()
                .readMessageFromBundle(FUNCTION_WITH_STEP_RESULT_EQUALS_MESSAGE_KEY) + result + NEW_LINE_BREAK);
    }

    public static void reportFunctionWithStepResult(List<Double> result) {
        System.out.println(getInstance()
                .readMessageFromBundle(FUNCTION_WITH_STEP_RESULT_EQUALS_MESSAGE_KEY) + result + NEW_LINE_BREAK);
    }
}
