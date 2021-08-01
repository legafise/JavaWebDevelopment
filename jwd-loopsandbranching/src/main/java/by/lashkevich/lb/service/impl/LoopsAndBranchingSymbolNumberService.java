package by.lashkevich.lb.service.impl;

import by.lashkevich.lb.loopsandbranchingutil.finder.LoopsAndBranchingSymbolNumbersFinder;
import by.lashkevich.lb.service.SymbolNumberService;

import java.util.Map;

public class LoopsAndBranchingSymbolNumberService implements SymbolNumberService {
    @Override
    public Map<Character, Integer> find(char symbol) {
        return LoopsAndBranchingSymbolNumbersFinder.findSymbolNumbers(symbol);
    }
}
