package by.lashkevich.jwd.reporter;

import by.lashkevich.jwd.entity.Point;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public final class PointCheckerReporter {
    private static final Logger LOGGER = LogManager.getRootLogger();
    private static final String VARIABLES_EQUAL = "x = %.1f; y = %.1f;";
    private static final String CHECKING_RESULTS_EQUAL = "Checking result for area a = %b;"
            + "\nChecking result for area b = %b;\n"
            + "Checking result for area c = %b;\n";

    private PointCheckerReporter() {
    }

    public static void reportCheckResult(boolean aPointCheckResult, boolean bPointCheckResult,
                                         boolean cPointCheckResult) {
        System.out.println(String.format(CHECKING_RESULTS_EQUAL,
                aPointCheckResult, bPointCheckResult, cPointCheckResult));
    }

    public static void reportPointInfo(Point point) {
        System.out.println(String.format(VARIABLES_EQUAL, point.getX(), point.getY()));
    }
}
