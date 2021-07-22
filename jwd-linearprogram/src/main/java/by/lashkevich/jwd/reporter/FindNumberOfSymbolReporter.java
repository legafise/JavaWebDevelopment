package by.lashkevich.jwd.reporter;

import by.lashkevich.jwd.util.finder.NumberOfSymbolFinder;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public final class FindNumberOfSymbolReporter {
    private static final Logger LOGGER = LogManager.getRootLogger();
    private static final String INTRODUCED_SYMBOL_MESSAGE = "Introduced symbol = ";
    private static final String RESULT_EQUALS_MESSAGE = "Result = ";
    private static final String NEW_LINE_BREAK = "\n";

    private FindNumberOfSymbolReporter() {
    }

    public static void reportSymbolsNumbers(char symbol) {
        LOGGER.log(Level.INFO, INTRODUCED_SYMBOL_MESSAGE + symbol + NEW_LINE_BREAK
                + RESULT_EQUALS_MESSAGE + NumberOfSymbolFinder.findNumberOfSymbol(symbol)
                + NEW_LINE_BREAK);
    }
}
