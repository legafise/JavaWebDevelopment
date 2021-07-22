package by.lashkevich.jwd.reporter;

import by.lashkevich.jwd.entity.Triangle;
import by.lashkevich.jwd.exception.TriangleCalculatorException;
import by.lashkevich.jwd.util.calculator.Calculator;
import by.lashkevich.jwd.util.calculator.impl.TriangleCalculator;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static java.lang.String.format;

public final class TriangleCalculatorReporter {
    private static final Logger LOGGER = LogManager.getRootLogger();
    private static final String TRIANGLE_INFORMATION_MESSAGE = "Triangle = ";
    private static final String SEMICOLON_SIGN = "; ";
    private static final String PERIMETER_AND_AREA_ARE_EQUAL_MESSAGE = "Perimeter = %.1f; Area = %.1f" + "\n";
    private static Calculator calculator = new TriangleCalculator();

    private TriangleCalculatorReporter() {
    }

    public static void reportTrianglePerimeterAndArea(Triangle triangle) {
        try {
            LOGGER.log(Level.INFO, TRIANGLE_INFORMATION_MESSAGE
                            + triangle + SEMICOLON_SIGN
                            + format(PERIMETER_AND_AREA_ARE_EQUAL_MESSAGE,
                    calculator.calculatePerimeter(triangle),
                    calculator.calculateArea(triangle)));
        } catch (TriangleCalculatorException e) {
            LOGGER.log(Level.ERROR, e);
        }
    }
}
