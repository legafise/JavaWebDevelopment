package by.lashkevich.lb.reporter;


import java.util.List;

import static by.lashkevich.lb.reader.LoopsAndBranchingPropertiesReader.getInstance;

public final class SquareRootFormulaReporter {
    private static final String RESULT_EQUALS_KEY = "reporter.square.root.formula.result.message";
    private static final String VARIABLES_EQUAL_KEY = "reporter.variables.equal.message";

    private SquareRootFormulaReporter() {
    }

    public static void reportSquareRootFormulaResult(double result) {
        System.out.println(String.format(getInstance().readMessageFromBundle(RESULT_EQUALS_KEY), result));
    }

    public static void reportSquareRootFormulaVariablesInfo(List<Double> variables) {
        System.out.println(String.format(getInstance().readMessageFromBundle(VARIABLES_EQUAL_KEY),
                variables.get(0), variables.get(1), variables.get(2)));
    }
}
