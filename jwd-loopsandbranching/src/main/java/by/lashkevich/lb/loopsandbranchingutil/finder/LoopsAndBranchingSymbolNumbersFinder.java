package by.lashkevich.lb.loopsandbranchingutil.finder;

import java.util.HashMap;
import java.util.Map;

public final class LoopsAndBranchingSymbolNumbersFinder {
    private LoopsAndBranchingSymbolNumbersFinder() {
    }

    public static Map<Character, Integer> findSymbolNumbers(char symbol) {
        Map<Character, Integer> symbolsAndNumbers = new HashMap<>();
        symbolsAndNumbers.put((char) ((int) symbol - 1), (int) symbol - 1);
        symbolsAndNumbers.put(symbol, (int) symbol);
        symbolsAndNumbers.put((char) ((int) symbol + 1), (int) symbol + 1);

        return symbolsAndNumbers;
    }
}
