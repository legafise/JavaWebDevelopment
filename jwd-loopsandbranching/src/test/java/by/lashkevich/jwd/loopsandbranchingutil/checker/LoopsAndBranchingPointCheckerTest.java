package by.lashkevich.jwd.loopsandbranchingutil.checker;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static by.lashkevich.lb.loopsandbranchingutil.checker.LoopsAndBranchingPointChecker.*;

public class LoopsAndBranchingPointCheckerTest {
    @DataProvider(name = "positiveDataForAreaA")
    public Object[][] createPositiveDataForAreaA() {
        return new Object[][]{
                {new double[]{1, 1}, true},
                {new double[]{1, 1}, true},
                {new double[]{1, 2}, true},
                {new double[]{1, 3}, true},
                {new double[]{2, 2}, true},
                {new double[]{2, 1}, true},
                {new double[]{3, 0.5}, true},
                {new double[]{-1, 1}, true},
                {new double[]{-1, 1}, true},
                {new double[]{-1, 2}, true},
                {new double[]{-1, 3}, true},
                {new double[]{-2, 2}, true},
                {new double[]{-2, 1}, true},
                {new double[]{-3, 0.5}, true},
        };
    }

    @DataProvider(name = "positiveDataForAreaB")
    public Object[][] createPositiveDataForAreaB() {
        return new Object[][]{
                {new double[]{1, 1}, true},
                {new double[]{1, 1}, true},
                {new double[]{1, 2}, true},
                {new double[]{1, 3}, true},
                {new double[]{1, 4}, true},
                {new double[]{-1, 1}, true},
                {new double[]{-1, 1}, true},
                {new double[]{-1, 2}, true},
                {new double[]{-1, 3}, true},
                {new double[]{-1, 4}, true},
                {new double[]{2, 2}, true},
                {new double[]{2, 1}, true},
                {new double[]{1, -1}, true},
                {new double[]{1, -1}, true},
                {new double[]{1, -2}, true},
                {new double[]{1, -3}, true},
                {new double[]{-1, -1}, true},
                {new double[]{-1, -1}, true},
                {new double[]{-1, -2}, true},
                {new double[]{-1, -3}, true},
                {new double[]{2, -2}, true},
                {new double[]{2, -1}, true}
        };
    }

    @DataProvider(name = "positiveDataForAreaC")
    public Object[][] createPositiveDataForAreaC() {
        return new Object[][]{
                {new double[]{1, 1}, true},
                {new double[]{1, 1}, true},
                {new double[]{1, 2}, true},
                {new double[]{1, 3}, true},
                {new double[]{2, 2}, true},
                {new double[]{2, 1}, true},
                {new double[]{1, -1}, true},
                {new double[]{1, -1}, true},
                {new double[]{1, -2}, true},
                {new double[]{1, -3}, true},
                {new double[]{2, -2}, true},
                {new double[]{2, -1}, true}
        };
    }


    @Test(description = "Positive scenario for checking points on A area",
            dataProvider = "positiveDataForAreaA")
    public void checkAPointTest(double[] coordinates, boolean expectedResult) {
        Assert.assertEquals(checkAPoint(coordinates[0], coordinates[1]), expectedResult);
    }

    @Test(description = "Positive scenario for checking points on B area",
            dataProvider = "positiveDataForAreaB")
    public void checkBPointTest(double[] coordinates, boolean expectedResult) {
        Assert.assertEquals(checkBPoint(coordinates[0], coordinates[1]), expectedResult);
    }

    @Test(description = "Positive scenario for checking points on C area",
            dataProvider = "positiveDataForAreaC")
    public void checkCPointTest(double[] coordinates, boolean expectedResult) {
        Assert.assertEquals(checkCPoint(coordinates[0], coordinates[1]), expectedResult);
    }
}