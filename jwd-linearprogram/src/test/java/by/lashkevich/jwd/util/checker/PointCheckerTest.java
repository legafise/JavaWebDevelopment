package by.lashkevich.jwd.util.checker;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static by.lashkevich.jwd.util.checker.PointChecker.*;

public class PointCheckerTest {
    private int validXValue;
    private int validYValue;
    private int notValidAYValue;
    private int notValidAXValue;
    private int notValidBYValue;
    private int notValidBXValue;
    private int notValidCYValue;
    private int notValidCXValue;

    @BeforeMethod
    public void setUp() {
        validXValue = 1;
        validYValue = 1;
        notValidAXValue = 0;
        notValidAYValue = -1;
        notValidBXValue = 3;
        notValidBYValue = 2;
        notValidCXValue = 4;
        notValidCYValue = -4;
    }

    @Test
    public void checkAPointPositiveTest() {
        Assert.assertTrue(checkAPoint(validXValue, validYValue));
    }

    @Test
    public void checkAPointNegativeTest() {
        Assert.assertFalse(checkAPoint(notValidAXValue, notValidAYValue));
    }

    @Test
    public void checkBPointPositiveTest() {
        Assert.assertTrue(checkBPoint(validXValue, validYValue));
    }

    @Test
    public void checkBPointNegativeTest() {
        Assert.assertFalse(checkBPoint(notValidBXValue, notValidBYValue));
    }

    @Test
    public void checkCPointPositiveTest() {
        Assert.assertTrue(checkCPoint(validXValue, validYValue));
    }

    @Test
    public void checkCPointNegativeTest() {
        Assert.assertFalse(checkCPoint(notValidCXValue, notValidCYValue));
    }
}