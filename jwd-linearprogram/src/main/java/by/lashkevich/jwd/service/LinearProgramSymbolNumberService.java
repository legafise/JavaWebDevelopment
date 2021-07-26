package by.lashkevich.jwd.service;

import by.lashkevich.jwd.linearprogramutil.finder.SymbolNumbersFinder;

import java.util.Map;

public class LinearProgramSymbolNumberService {
    public Map<Character, Integer> find(char symbol) {
        return SymbolNumbersFinder.findSymbolNumbers(symbol);
    }
}
