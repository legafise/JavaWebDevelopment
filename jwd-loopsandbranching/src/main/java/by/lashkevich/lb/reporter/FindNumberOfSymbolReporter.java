package by.lashkevich.lb.reporter;

import java.util.Map;

import static by.lashkevich.lb.reader.LoopsAndBranchingPropertiesReader.getInstance;

public final class FindNumberOfSymbolReporter {
    private static final String RECEIVED_SYMBOL_MESSAGE_KEY = "reporter.received.symbol.message";
    private static final String RESULT_EQUALS_MESSAGE_KEY = "reporter.result.message";
    private static final String NEW_LINE_BREAK = "\n";

    private FindNumberOfSymbolReporter() {
    }

    public static void reportSymbolNumbers(Map<Character, Integer> symbolsAndNumbers) {
        System.out.println(getInstance().readMessageFromBundle(RESULT_EQUALS_MESSAGE_KEY)
                + symbolsAndNumbers + NEW_LINE_BREAK);
    }

    public static void reportIntroducedSymbol(char symbol) {
        System.out.println(getInstance().readMessageFromBundle(RECEIVED_SYMBOL_MESSAGE_KEY) + symbol);
    }
}
