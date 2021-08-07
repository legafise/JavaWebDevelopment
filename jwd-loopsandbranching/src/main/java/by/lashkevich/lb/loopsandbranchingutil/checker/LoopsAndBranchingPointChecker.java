package by.lashkevich.lb.loopsandbranchingutil.checker;

import by.lashkevich.lb.entity.Point;
import by.lashkevich.lb.reader.LoopsAndBranchingPropertiesReader;

/**
 * Utilitarian class for checking point
 * @author Roman Lashkevich
 */
public final class LoopsAndBranchingPointChecker {
    private static final String FIRST_POINT_IS_CLOSER_MESSAGE_KEY = "util.first.point.is.closer.result.message";
    private static final String SECOND_POINT_IS_CLOSER_MESSAGE_KEY = "util.second.point.is.closer.result.message";
    private static final String POINTS_AT_THE_TAME_DISTANCE_MESSAGE_KEY = "util.points.at.the.same.distance.result.message";

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
            return LoopsAndBranchingPropertiesReader
                    .getInstance().readMessageFromBundle(FIRST_POINT_IS_CLOSER_MESSAGE_KEY);
        } else if (secondDistanceCoefficient < firstDistanceCoefficient) {
            return LoopsAndBranchingPropertiesReader
                    .getInstance().readMessageFromBundle(SECOND_POINT_IS_CLOSER_MESSAGE_KEY);
        } else {
            return LoopsAndBranchingPropertiesReader
                    .getInstance().readMessageFromBundle(POINTS_AT_THE_TAME_DISTANCE_MESSAGE_KEY);
        }
    }
}
