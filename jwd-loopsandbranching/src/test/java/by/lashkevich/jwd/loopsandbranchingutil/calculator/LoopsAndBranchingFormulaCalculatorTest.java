package by.lashkevich.jwd.loopsandbranchingutil.calculator;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static by.lashkevich.lb.loopsandbranchingutil.calculator.LoopsAndBranchingFormulaCalculator.calculateSquareRootFormula;

public class LoopsAndBranchingFormulaCalculatorTest {
    @DataProvider(name = "positiveDataForSquareRootFormula")
    public Object[][] createPositiveDataForSqrt() {
        return new Object[][]{
                {new double[]{0, -2, 0}, 0.25},
                {new double[]{0, 2, 0}, 0.25},
                {new double[]{1, -1, 3}, -0.69},
                {new double[]{1, 1, -1}, Double.NaN},
                {new double[]{-1, 2, 3}, Double.NaN},
                {new double[]{1, 2, 0}, 2.25},
                {new double[]{0, 2, 3}, 0.25},
                {new double[]{1, 0, 3}, Double.POSITIVE_INFINITY},
                {new double[]{Double.MAX_VALUE, 2, 3}, Double.NaN},
                {new double[]{Double.MAX_VALUE, Double.MAX_VALUE, 3}, Double.NaN},
                {new double[]{Double.MAX_VALUE, Double.MAX_VALUE, -3}, Double.NaN},
                {new double[]{Double.MAX_VALUE, Double.MAX_VALUE, Double.MAX_VALUE}, Double.NaN},
                {new double[]{1, Double.MAX_VALUE, 2}, Double.POSITIVE_INFINITY},
                {new double[]{1, Double.MAX_VALUE, -2}, Double.POSITIVE_INFINITY},
                {new double[]{-1, Double.MAX_VALUE, Double.MAX_VALUE}, Double.NaN}
        };
    }

    @Test(description = "Positive scenario of the formula calculation with unusual variables",
            dataProvider = "positiveDataForSquareRootFormula")
    public void calculateSquareRootFormulaWithUnusualVariablesTest(double[] variables, double expectedResult) {
        Assert.assertEquals(expectedResult,
                calculateSquareRootFormula(variables[0], variables[1], variables[2]), 0.1);
    }

    @Test
    public void calculateSquareRootWithNormalWholeNumbersTest() {
        Assert.assertEquals(0.25,
                calculateSquareRootFormula(1, 2, 3), 0.1);
    }

    @Test
    public void calculateSquareRootWithNormalFractionalNumbersTest() {
        Assert.assertEquals(-6.3,
                calculateSquareRootFormula(1.5, 2.3, 3.6), 0.1);
    }
}