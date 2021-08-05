package by.lashkevich.lb.loopsandbranchingutil.checker;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static by.lashkevich.lb.loopsandbranchingutil.checker.LoopsAndBranchingArithmeticProgressionChecker.isArithmeticProgression;

public class LoopsAndBranchingArithmeticProgressionCheckerTest {
    @DataProvider(name = "positiveDataForArithmeticProgressionChecking")
    public Object[][] createDataForArithmeticProgressionChecking() {
        return new Object[][] {
                {123456789, true},
                {-123456789, true},
                {111111111, true},
                {-111111111, true},
                {999999999, true},
                {-999999999, true},
                {000000000, true},
                {13579, true},
                {-13579, true},
                {159, true},
                {-159, true},
        };
    }

    @Test(description = "Positive scenario of arithmetic progression checker",
            dataProvider = "positiveDataForArithmeticProgressionChecking")
    public void ArithmeticProgressionCheckingPositiveTest(long number, boolean expectedResult) {
        Assert.assertEquals(isArithmeticProgression(number), expectedResult);
    }
}