package by.lashkevich.lb.service;

import java.util.Map;

/**
 * Service that executes the logic of the find symbol numbers task
 * @author Roman Lashkevich
 */
public interface SymbolNumberService {
    Map<Character, Integer> find(char symbol);
}
