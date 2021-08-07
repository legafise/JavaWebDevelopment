package by.lashkevich.lb.reporter;

import by.lashkevich.lb.entity.Point;

import java.util.List;

import static by.lashkevich.lb.reader.LoopsAndBranchingPropertiesReader.getInstance;

public final class PointCheckerReporter {
    private static final String POINTS_INFO_KEY = "reporter.points.message";
    private static final String POINT_DISTANCE_FROM_ORIGIN_CHECKING_RESULT_MESSAGE_KEY = "reporter.result.message";
    private static final String NEW_LINE_BREAK = "\n";
    private static final String POINTS_ON_AREA_CHECKING_RESULTS_EQUAL_KEY = "reporter.points.checking.result.message";

    private PointCheckerReporter() {
    }

    public static void reportDistanceFromOriginCheckResult(String result) {
        System.out.println(getInstance()
                .readMessageFromBundle(POINT_DISTANCE_FROM_ORIGIN_CHECKING_RESULT_MESSAGE_KEY)
                + result + NEW_LINE_BREAK);
    }

    public static void reportPointsOnAreaCheckingResult(boolean aPointCheckResult, boolean bPointCheckResult,
                                                        boolean cPointCheckResult) {
        System.out.println(String.format(getInstance()
                        .readMessageFromBundle(POINTS_ON_AREA_CHECKING_RESULTS_EQUAL_KEY), aPointCheckResult,
                bPointCheckResult, cPointCheckResult));
    }

    public static void reportPointInfo(List<Point> points) {
        System.out.println(getInstance().readMessageFromBundle(POINTS_INFO_KEY) + points);
    }
}
