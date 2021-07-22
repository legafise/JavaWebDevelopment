package by.lashkevich.jwd.reporter;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static by.lashkevich.jwd.util.checker.PointChecker.*;
import static java.lang.String.format;

public final class PointCheckerReporter {
    private static final Logger LOGGER = LogManager.getRootLogger();
    private static final String X_EQUALS = "x = ";
    private static final String Y_EQUALS = "y = ";
    private static final String SEMICOLON_SIGN = "; ";
    private static final String CHECKING_RESULTS_EQUAL = "\nChecking result for area a = %b;"
            + "\nChecking result for area b = %b;\n"
            + "Checking result for area c = %b;\n";

    private PointCheckerReporter() {
    }

    public static void reportCheckResult(int x, int y) {
        LOGGER.info(X_EQUALS + x + SEMICOLON_SIGN + Y_EQUALS + y +
                SEMICOLON_SIGN + format(CHECKING_RESULTS_EQUAL, checkAPoint(x, y),
                checkBPoint(x, y), checkCPoint(x, y)));
    }
}
