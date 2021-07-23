package by.lashkevich.jwd.reporter;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static by.lashkevich.jwd.util.calculator.FormulaCalculator.calculateSquareRootFormula;

public final class SquareRootFormulaReporter {
    private static final Logger LOGGER = LogManager.getRootLogger();
    private static final String RESULT_EQUALS  = "result = ";

    private SquareRootFormulaReporter() {
    }

    public static void reportSquareRootFormulaResult(double a, double b, double c) {
        LOGGER.info(RESULT_EQUALS + calculateSquareRootFormula(a, b, c));
    }
}
