package by.lashkevich.jwd.loopsandbranchingutil.validator;

import by.lashkevich.lb.entity.Ring;
import by.lashkevich.lb.loopsandbranchingutil.validator.LoopsAndBranchingRingValidator;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoopsAndBranchingRingValidatorTest {
    @DataProvider(name = "positiveRingValidateData")
    public Object[][] createPositiveRingData() {
        return new Object[][]{
                {new double[]{1, 2}, true},
                {new double[]{10, 20}, true},
                {new double[]{23.23, 30.21}, true},
                {new double[]{1, Double.MAX_VALUE}, true},
        };
    }

    @Test(description = "Positive scenario for validate ring",
            dataProvider = "positiveRingValidateData")
    public void isValidRingTest(double[] radii, boolean expectedResult) {
        double testInnerRadius = radii[0];
        double positiveTestOuterRadius = radii[1];
        Ring testRing = new Ring(testInnerRadius, positiveTestOuterRadius);
        Assert.assertEquals(LoopsAndBranchingRingValidator.isValidRing(testRing), expectedResult);
    }
}