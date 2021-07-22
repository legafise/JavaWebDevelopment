package by.lashkevich.jwd.util.checker;

public final class PointChecker {
    private PointChecker() {
    }

    public static boolean checkAPoint(int x, int y) {
        return y >= 0 && y <= (x + 4) && y <= (4 - x);
    }

    public static boolean checkBPoint(int x, int y) {
        return (x >= -2 && x <= 2 && y >= 0 && y <= 4)
                || (x >= -4 && x <= 4 && y >= -3 && y <= 0);
    }

    public static boolean checkCPoint(int x, int y) {
        return x > 0 && (y >= 0 && (x * x + y * y <= 16))
                || (y <= 0 && (x * x + y * y <= 25));
    }
}
