package by.lashkevich.lb.loopsandbranchingutil.validator;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static by.lashkevich.lb.loopsandbranchingutil.validator.LoopsAndBranchingFunctionDataValidator.validateFunctionWithStepData;

public class LoopsAndBranchingFunctionDataValidatorTest {
    @DataProvider(name = "unexpectedValuesForValidation")
    public Object[][] createUnexpectedDataForFunctionValidation() {
        return new Object[][]{
                {new double[]{1, 2, 1}, true},
                {new double[]{2, 1, 1}, false},
                {new double[]{Double.MIN_VALUE, Double.MAX_VALUE, 1}, true},
                {new double[]{0, 0, 0}, false},
                {new double[]{0, 0, 1}, false},
                {new double[]{0, 3, 1}, true},
        };
    }

    @Test(description = "Different unexpected scenario for validations",
            dataProvider = "unexpectedValuesForValidation")
    public void validateFunctionWithStepDataWithUnexpectedValuesTest(double[] validatingValues, boolean expectedResult) {
        Assert.assertEquals(validateFunctionWithStepData(validatingValues[0],
                validatingValues[1], validatingValues[2]), expectedResult);
    }
}