package by.lashkevich.lb.loopsandbranchingutil.checker;

public final class LoopsAndBranchingPointCoordinatesChecker {
    private LoopsAndBranchingPointCoordinatesChecker() {
    }

    public static boolean checkAPoint(double x, double y) {
        return y >= 0 && y <= (x + 4) && y <= (4 - x);
    }

    public static boolean checkBPoint(double x, double y) {
        return (x >= -2 && x <= 2 && y >= 0 && y <= 4)
                || (x >= -4 && x <= 4 && y >= -3 && y <= 0);
    }

    public static boolean checkCPoint(double x, double y) {
        return x > 0 && (y >= 0 && (x * x + y * y <= 16))
                || (y <= 0 && (x * x + y * y <= 25));
    }
}
