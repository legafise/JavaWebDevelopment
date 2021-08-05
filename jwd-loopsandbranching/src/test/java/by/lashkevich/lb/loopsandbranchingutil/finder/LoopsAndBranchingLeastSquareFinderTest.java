package by.lashkevich.lb.loopsandbranchingutil.finder;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static by.lashkevich.lb.loopsandbranchingutil.finder.LoopsAndBranchingLeastSquareFinder.*;

public class LoopsAndBranchingLeastSquareFinderTest {
    @DataProvider(name = "nonStandardDataForFindingLeastSquare")
    public Object[][] createNonStandardDataForFindingLeastSquare() {
        return new Object[][]{
                {new double[]{5, 4}, 16.0},
                {new double[]{-4, -3}, 9.0},
                {new double[]{0, 0}, 0.0},
                {new double[]{0, 1}, 0.0},
                {new double[]{4, 0}, 0.0},
                {new double[]{Double.MAX_VALUE, Double.MIN_VALUE}, 0},
                {new double[]{Double.MAX_VALUE, 1}, 1},
                {new double[]{1, Double.MIN_VALUE}, 0},
        };
    }

    @Test(description = "Positive scenario for validating with specific data",
            dataProvider = "nonStandardDataForFindingLeastSquare")
    public void findLeastSquareWithNonStandardValuesTest(double[] dataForFinding, double expectedResult) {
        Assert.assertEquals(findLeastSquare(dataForFinding[0], dataForFinding[1]), expectedResult);
    }
}