package by.lashkevich.lb.loopsandbranchingutil.checker;

import by.lashkevich.lb.entity.Point;

public final class LoopsAndBranchingPointChecker {
    private static final String FIRST_POINT_IS_CLOSER_MESSAGE = "The first point is closer";
    private static final String SECOND_POINT_IS_CLOSER_MESSAGE = "The second point is closer";
    private static final String POINTS_AT_THE_TAME_DISTANCE_MESSAGE = "Points at the same distance";

    private LoopsAndBranchingPointChecker() {
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

    public static String checkDistanceFromOrigin(Point firstPoint, Point secondPoint) {
        double firstDistanceCoefficient = Math.pow(firstPoint.getX(), 2)
                + Math.pow(firstPoint.getY(), 2);
        double secondDistanceCoefficient = Math.pow(secondPoint.getX(), 2)
                + Math.pow(secondPoint.getY(), 2);
        if (firstDistanceCoefficient < secondDistanceCoefficient) {
            return FIRST_POINT_IS_CLOSER_MESSAGE;
        } else if (secondDistanceCoefficient < firstDistanceCoefficient) {
            return SECOND_POINT_IS_CLOSER_MESSAGE;
        } else {
            return POINTS_AT_THE_TAME_DISTANCE_MESSAGE;
        }
    }
}
