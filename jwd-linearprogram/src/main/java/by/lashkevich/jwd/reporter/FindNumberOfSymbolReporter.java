package by.lashkevich.jwd.reporter;

import java.util.Map;

public final class FindNumberOfSymbolReporter {
    private static final String RECEIVED_SYMBOL_MESSAGE = "Received symbol = ";
    private static final String RESULT_EQUALS_MESSAGE = "Result: ";
    private static final String NEW_LINE_BREAK = "\n";

    private FindNumberOfSymbolReporter() {
    }

    public static void reportSymbolNumbers(Map<Character, Integer> symbolsAndNumbers) {
        System.out.println(RESULT_EQUALS_MESSAGE + symbolsAndNumbers + NEW_LINE_BREAK);
    }

    public static void reportIntroducedSymbol(char symbol) {
        System.out.println(RECEIVED_SYMBOL_MESSAGE + symbol);
    }
}
