package by.lashkevich.jwd.reporter;

import by.lashkevich.jwd.entity.Ring;
import by.lashkevich.jwd.exception.LinearProgramValidatorException;
import by.lashkevich.jwd.util.calculator.RingCalculator;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static java.lang.String.format;

public final class RingCalculatorReporter {
    private static final Logger LOGGER = LogManager.getRootLogger();
    private static final String RING_INFORMATION_MESSAGE = "Ring = ";
    private static final String SEMICOLON_SIGN = "; ";
    private static final String AREA_IS_EQUAL_MESSAGE = "\nArea = %.1f\n";

    private RingCalculatorReporter() {
    }

    public static void reportRingArea(Ring ring) {
        try {
            LOGGER.log(Level.INFO, RING_INFORMATION_MESSAGE
                    + ring + SEMICOLON_SIGN
                    + format(AREA_IS_EQUAL_MESSAGE,
                    RingCalculator.calculateRingArea(ring)));
        } catch (LinearProgramValidatorException e) {
            LOGGER.log(Level.ERROR, e);
        }
    }
}
