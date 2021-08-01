package by.lashkevich.jwd.loopsandbranchingutil.finder;

import by.lashkevich.lb.loopsandbranchingutil.finder.LoopsAndBranchingSymbolNumbersFinder;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class LoopsAndBranchingSymbolNumbersFinderTest {
    @DataProvider(name = "positiveDataSymbolNumbersFinder")
    public Object[][] createPositiveDataForAreaC() {
        return new Object[][]{
                {new char[]{'x', 'y', 'z'}, new int[]{120, 121, 122}},
                {new char[]{'X', 'Y', 'Z'}, new int[]{88, 89, 90}},
                {new char[]{'1', '2', '3'}, new int[]{49, 50, 51}},
                {new char[]{';', '<', '='}, new int[]{59, 60, 61}},
        };
    }

    @Test(description = "Positive scenario for checking symbols",
            dataProvider = "positiveDataSymbolNumbersFinder")
    public void findNumberOfSymbolTest(char[] symbols, int[] symbolNumbers) {
        Map<Character, Integer> expectedSymbolsAndNumbers = new HashMap<>();
        expectedSymbolsAndNumbers.put(symbols[0], symbolNumbers[0]);
        expectedSymbolsAndNumbers.put(symbols[1], symbolNumbers[1]);
        expectedSymbolsAndNumbers.put(symbols[2], symbolNumbers[2]);
        Assert.assertEquals(LoopsAndBranchingSymbolNumbersFinder.findSymbolNumbers(symbols[1]),
                expectedSymbolsAndNumbers);
    }
}