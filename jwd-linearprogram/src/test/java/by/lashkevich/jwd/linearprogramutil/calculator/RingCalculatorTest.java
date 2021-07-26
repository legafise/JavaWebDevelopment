package by.lashkevich.jwd.linearprogramutil.calculator;

import by.lashkevich.jwd.entity.Ring;
import by.lashkevich.jwd.exception.LinearProgramServiceException;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RingCalculatorTest {
    private Ring positiveTestRing;
    private double expectedArea;

    @BeforeMethod
    public void setUp() {
        double testInnerRadius = 8;
        double positiveTestOuterRadius = 10;
        positiveTestRing = new Ring(testInnerRadius, positiveTestOuterRadius);
        expectedArea = 113;
    }

    @Test
    public void calculateRingAreaPositiveTest() {
        Assert.assertEquals(RingCalculator.calculateRingArea(positiveTestRing), expectedArea, 0.1);
    }

    @Test
    public void calculateRingAreaNegativeTest() {
        expectedArea = 10;
        Assert.assertNotEquals(RingCalculator.calculateRingArea(positiveTestRing), expectedArea, 0.1);
    }
}