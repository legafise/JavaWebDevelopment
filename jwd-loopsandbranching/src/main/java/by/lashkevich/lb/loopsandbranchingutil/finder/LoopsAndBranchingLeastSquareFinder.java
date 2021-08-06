package by.lashkevich.lb.loopsandbranchingutil.finder;

/**
 * Utilitarian class for finding least square
 * @author Roman Lashkevich
 */
public final class LoopsAndBranchingLeastSquareFinder {
    private LoopsAndBranchingLeastSquareFinder() {
    }

    public static double findLeastSquare(double a, double b) {
        return Math.min(Math.pow(a, 2), Math.pow(b, 2));
    }
}
