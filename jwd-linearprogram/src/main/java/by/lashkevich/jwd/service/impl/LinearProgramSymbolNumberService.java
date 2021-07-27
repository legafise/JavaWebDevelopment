package by.lashkevich.jwd.service.impl;

import by.lashkevich.jwd.linearprogramutil.finder.SymbolNumbersFinder;
import by.lashkevich.jwd.service.SymbolNumberService;

import java.util.Map;

public class LinearProgramSymbolNumberService implements SymbolNumberService {
    @Override
    public Map<Character, Integer> find(char symbol) {
        return SymbolNumbersFinder.findSymbolNumbers(symbol);
    }
}
