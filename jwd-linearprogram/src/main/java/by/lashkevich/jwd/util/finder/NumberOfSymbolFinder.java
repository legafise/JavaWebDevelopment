package by.lashkevich.jwd.util.finder;

import java.util.HashMap;
import java.util.Map;

public final class NumberOfSymbolFinder {
    private NumberOfSymbolFinder() {
    }

    public static Map<Character, Integer> findNumberOfSymbol(char symbol) {
        Map<Character, Integer> symbolsAndNumbers = new HashMap<>();
        symbolsAndNumbers.put((char) ((int) symbol - 1), (int) symbol - 1);
        symbolsAndNumbers.put(symbol, (int) symbol);
        symbolsAndNumbers.put((char) ((int) symbol + 1), (int) symbol + 1);

        return symbolsAndNumbers;
    }
}
