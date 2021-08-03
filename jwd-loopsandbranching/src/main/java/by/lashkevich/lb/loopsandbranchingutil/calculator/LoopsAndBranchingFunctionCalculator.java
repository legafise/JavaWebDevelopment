package by.lashkevich.lb.loopsandbranchingutil.calculator;

public final class LoopsAndBranchingFunctionCalculator {
    private LoopsAndBranchingFunctionCalculator() {
    }

    public static double calculateTwoConditionFunction(double x) {
        return x >= 0 && x <= 3 ? Math.pow(x, 2) : 4;
    }
}
