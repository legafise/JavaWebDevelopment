package by.lashkevich.lb.reporter;

import by.lashkevich.lb.entity.Point;

import java.util.List;

public final class PointCheckerReporter {
    private static final String POINTS_INFO = "\nPoints: ";
    private static final String POINT_DISTANCE_FROM_ORIGIN_CHECKING_RESULT_MESSAGE = "Result = ";
    private static final String NEW_LINE_BREAK = "\n";
    private static final String POINTS_ON_AREA_CHECKING_RESULTS_EQUAL = "Checking result for area a = %b;"
            + "\nChecking result for area b = %b;\n"
            + "Checking result for area c = %b;\n";

    private PointCheckerReporter() {
    }

    public static void reportDistanceFromOriginCheckResult(String result) {
        System.out.println(POINT_DISTANCE_FROM_ORIGIN_CHECKING_RESULT_MESSAGE
                + result + NEW_LINE_BREAK);
    }

    public static void reportPointsOnAreaCheckingResult(boolean aPointCheckResult, boolean bPointCheckResult,
                                                        boolean cPointCheckResult) {
        System.out.println(String.format(POINTS_ON_AREA_CHECKING_RESULTS_EQUAL,
                aPointCheckResult, bPointCheckResult, cPointCheckResult));
    }

    public static void reportPointInfo(List<Point> points) {
        System.out.println(POINTS_INFO + points);
    }
}
