package by.lashkevich.lb.loopsandbranchingutil.validator;

import by.lashkevich.lb.entity.LoopsAndBranchingDate;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static by.lashkevich.lb.loopsandbranchingutil.validator.LoopsAndBranchingDateValidator.isValidDate;
import static org.testng.Assert.*;

public class LoopsAndBranchingDateValidatorTest {
    @DataProvider(name = "positiveDataForDayValidating")
    public Object[][] createPositiveDataForValidating() {
        return new Object[][]{
                {1, 1},
                {31, 12},
        };
    }

    @DataProvider(name = "badDataForDayValidating")
    public Object[][] createBadDataForValidating(){
        return new Object[][]{
                {0, 0},
                {32, 13},
        };
    }

    @Test(description = "Positive validating scenario", dataProvider = "positiveDataForDayValidating")
    public void validateDateWithPositiveDataTest(int day, int month) {
        Assert.assertTrue(isValidDate(new LoopsAndBranchingDate(day, month)));
    }

    @Test(description = "Bad validating scenario", dataProvider = "badDataForDayValidating")
    public void validateDateWithBadDataTest(int day, int month) {
        Assert.assertFalse(isValidDate(new LoopsAndBranchingDate(day, month)));
    }
}