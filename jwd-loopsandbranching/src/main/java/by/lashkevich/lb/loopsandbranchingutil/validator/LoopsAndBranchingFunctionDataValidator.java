package by.lashkevich.lb.loopsandbranchingutil.validator;

public final class LoopsAndBranchingFunctionDataValidator {
    private LoopsAndBranchingFunctionDataValidator() {
    }

    public static boolean validateFunctionWithStepData(double a, double b, double h) {
        return a < b && h > 0;
    }
}
