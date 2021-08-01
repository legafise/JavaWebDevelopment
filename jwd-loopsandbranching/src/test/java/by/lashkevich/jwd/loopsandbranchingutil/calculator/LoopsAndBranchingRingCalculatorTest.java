package by.lashkevich.jwd.loopsandbranchingutil.calculator;

import by.lashkevich.lb.entity.Ring;
import by.lashkevich.lb.loopsandbranchingutil.calculator.LoopsAndBranchingRingCalculator;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoopsAndBranchingRingCalculatorTest {
    @DataProvider(name = "positiveDataForRingCalculator")
    public Object[][] createPositiveDataForSqrt() {
        return new Object[][]{
                {new double[]{8, 10}, 113},
                {new double[]{1, 2}, 9.4},
                {new double[]{1, Double.MAX_VALUE}, Double.POSITIVE_INFINITY},
                {new double[]{Double.MAX_VALUE, 1}, Double.NEGATIVE_INFINITY},
                {new double[]{Double.MAX_VALUE, Double.MAX_VALUE}, Double.NaN}
        };
    }

    @Test(description = "Positive scenario of area calculation",
            dataProvider = "positiveDataForRingCalculator")
    public void calculateRingAreaWithNormalDataTest(double[] radii, double expectedArea) {
        Ring ring = new Ring(radii[0], radii[1]);
        Assert.assertEquals(LoopsAndBranchingRingCalculator.calculateRingArea(ring), expectedArea, 0.1);
    }
}