package by.lashkevich.lb.loopsandbranchingutil.validator;

/**
 * Utilitarian class for functions data validation
 * @author Roman Lashkevich
 */
public final class LoopsAndBranchingFunctionDataValidator {
    private LoopsAndBranchingFunctionDataValidator() {
    }

    public static boolean validateFunctionWithStepData(double a, double b, double h) {
        return a < b && h > 0;
    }
}
