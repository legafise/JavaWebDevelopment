package by.lashkevich.lb.loopsandbranchingutil.calculator;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static java.util.Map.entry;

public class LoopsAndBranchingFunctionCalculatorTest {
    @DataProvider(name = "positiveDataForTwoConditionFunction")
    public Object[][] createPositiveDataForTwoConditionFunction() {
        return new Object[][]{
                {0.0, 0.0},
                {1.0, 1.0},
                {2.0, 4.0},
                {3.0, 9.0},
                {-1.0, 4.0},
                {4.0, 4.0},
                {Double.MAX_VALUE, 4.0},
                {Double.MIN_VALUE, 0.0},
        };
    }

    @DataProvider(name = "positiveDataForFunctionWithStep")
    public Object[][] createPositiveDataForFunctionWithStep() {
        return new Object[][]{
                {new double[]{-3.0, 3, 1.0}, Arrays.asList(3.0, 2.0, 1.0, 0.0, -1.0, -2.0, 3.0)},
                {new double[]{-0.5, 1.5, 0.5}, Arrays.asList(0.5, 0.0, -0.5, -1.0, -1.5)},
                {new double[]{10, 15, 1}, Arrays.asList(10.0, 11.0, 12.0, 13.0, 14.0, 15.0)},
        };
    }

    @DataProvider(name = "positiveDataForTrigonometricFunctionWithStep")
    public Object[][] createPositiveDataForTrigonometricFunctionWithStep() {
        return new Object[][]{
                {new double[]{1.0, 2.0, 1.0}, Map.ofEntries(entry(1.0, 3.3087925286812254))},
                {new double[]{1.5, 2.5, 1.5}, Map.ofEntries(entry(1.5, 2.3292352150144793))},
                {new double[]{-1.0, 0.0, 1.0}, Map.ofEntries(entry(-1.0, -3.3087925286812254))},
                {new double[]{0.0, 1.0, 1.0}, Map.ofEntries(entry(0.0, Double.POSITIVE_INFINITY))},
                {new double[]{Double.MIN_VALUE, Double.MAX_VALUE, Double.MAX_VALUE},
                        Map.ofEntries(entry(4.9E-324, Double.POSITIVE_INFINITY))},
        };
    }


    @Test(description = "Positive scenario for two condition function",
            dataProvider = "positiveDataForTwoConditionFunction")
    public void calculateTwoConditionFunctionTest(double x, double expectedResult) {
        Assert.assertEquals(LoopsAndBranchingFunctionCalculator
                .calculateTwoConditionFunction(x), expectedResult);
    }

    @Test(description = "Positive scenario for function with step",
            dataProvider = "positiveDataForFunctionWithStep")
    public void calculateFunctionWithStepTest(double[] functionComponents,
                                              List<Double> expectedResult) {
        Assert.assertEquals(LoopsAndBranchingFunctionCalculator
                .calculateFunctionWithStep(functionComponents[0],
                        functionComponents[1], functionComponents[2]), expectedResult);
    }

    @Test(description = "Positive scenario for trigonometric function with step",
            dataProvider = "positiveDataForTrigonometricFunctionWithStep")
    public void testCalculateTrigonometricFunctionWithStepTest(double[] functionComponents,
                                                               Map<Double, Double> expectedResult) {
        Assert.assertEquals(LoopsAndBranchingFunctionCalculator
                .calculateTrigonometricFunctionWithStep(functionComponents[0],
                        functionComponents[1], functionComponents[2]), expectedResult);
    }

    @Test
    public void calculateFunctionWithoutDataEntryTest() {
        Map<Double,Double> expectedResult = Map.ofEntries(entry(-5.0, -7.5), entry(-4.5,-5.125),
                entry(-4.0,-3.0), entry(-3.5,-1.125), entry(-3.0,0.5), entry(-2.5,1.875),
                entry(-2.0,3.0), entry(-1.5,3.875), entry(-1.0,4.5), entry(-0.5,4.875),
                entry(0.0,5.0), entry(0.5,4.875), entry(1.0,4.5), entry(1.5,3.875),
                entry(2.0,3.0), entry(2.5,1.875), entry(3.0,0.5), entry(3.5,-1.125),
                entry(4.0,-3.0), entry(4.5,-5.125), entry(5.0,-7.5));

        Assert.assertEquals(LoopsAndBranchingFunctionCalculator.calculateFunctionWithoutDataEntry(), expectedResult);
    }
}