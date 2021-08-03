package by.lashkevich.lb.reporter;


import java.util.List;

public final class SquareRootFormulaReporter {
    private static final String RESULT_EQUALS  = "Square root formula result = %.1f\n";
    private static final String VARIABLES_EQUAL  = "\nVariable a = %.1f; Variable b = %.1f;" +
            " Variable c = %.1f;";

    private SquareRootFormulaReporter() {
    }

    public static void reportSquareRootFormulaResult(double result) {
        System.out.println(String.format(RESULT_EQUALS, result));
    }

    public static void reportSquareRootFormulaVariablesInfo(List<Double> variables) {
        System.out.println(String.format(VARIABLES_EQUAL, variables.get(0), variables.get(1), variables.get(2)));
    }
}
