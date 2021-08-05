package by.lashkevich.lb.loopsandbranchingutil.finder;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoopsAndBranchingDigitFinderTest {
    @DataProvider(name = "positiveSpecificDataForFindingTheLargestDigit")
    public Object[][] createPositiveSpecificDataForFindingTheLargestDigit() {
        return new Object[][] {
                {123456789, 9},
                {-123456789, 9},
                {0, 0},
                {10, 1},
                {-10, 1},
                {9, 9},
                {-9, 9},
                {0000000000, 0},
                {1111111111, 1},
                {Long.MAX_VALUE, 9},
                {Long.MIN_VALUE, 0},
        };
    }

    @Test(description = "Positive scenario of finding the largest digit with specific data",
            dataProvider = "positiveSpecificDataForFindingTheLargestDigit")
    public void findLargestDigitWithSpecificNumbersTest(long number, int expectedResult) {
        Assert.assertEquals(LoopsAndBranchingDigitFinder.findLargestDigit(number), expectedResult);
    }
}