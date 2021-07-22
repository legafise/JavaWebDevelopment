package by.lashkevich.jwd.util.finder;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static org.testng.Assert.*;

public class NumberOfSymbolFinderTest {
    private char introducedSymbol;
    private char previousSymbol;
    private char nextSymbol;
    private int introducedSymbolNumber;
    private int previousSymbolNumber;
    private int nextSymbolNumber;
    private Map<Character, Integer> expectedSymbolsAndNumbers;

    @BeforeMethod
    public void setUp() {
        introducedSymbol = 'y';
        previousSymbol = 'x';
        nextSymbol = 'z';
        introducedSymbolNumber = 121;
        previousSymbolNumber = 120;
        nextSymbolNumber = 122;

        expectedSymbolsAndNumbers = new HashMap<>();
        expectedSymbolsAndNumbers.put(previousSymbol, previousSymbolNumber);
        expectedSymbolsAndNumbers.put(introducedSymbol, introducedSymbolNumber);
        expectedSymbolsAndNumbers.put(nextSymbol, nextSymbolNumber);
    }

    @Test
    public void findNumberOfSymbolPositiveTest() {
        Assert.assertEquals(NumberOfSymbolFinder.findNumberOfSymbol(introducedSymbol),
                expectedSymbolsAndNumbers);
    }

    @Test
    public void findNumberOfSymbolNegativeTest() {
        Assert.assertNotEquals(NumberOfSymbolFinder.findNumberOfSymbol(previousSymbol),
                expectedSymbolsAndNumbers);
    }
}