package by.lashkevich.jwd.service;

import java.util.Map;

public interface SymbolNumberService {
    Map<Character, Integer> find(char symbol);
}
