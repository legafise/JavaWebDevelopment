package by.lashkevich.jwd.util.calculator;

import by.lashkevich.jwd.entity.Ring;
import by.lashkevich.jwd.exception.LinearProgramValidatorException;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class RingCalculatorTest {
    private Ring positiveTestRing;
    private Ring negativeTestRing;
    private double testInnerRadius;
    private double positiveTestOuterRadius;
    private double negativeTestOuterRadius;
    private double expectedArea;

    @BeforeMethod
    public void setUp() {
        testInnerRadius = 8;
        positiveTestOuterRadius = 10;
        negativeTestOuterRadius = 5;
        positiveTestRing = new Ring(testInnerRadius, positiveTestOuterRadius);
        negativeTestRing = new Ring(testInnerRadius, negativeTestOuterRadius);
        expectedArea = 113;
    }

    @Test
    public void calculateRingAreaPositiveTest() throws LinearProgramValidatorException {
        Assert.assertEquals(RingCalculator.calculateRingArea(positiveTestRing), expectedArea, 0.1);
    }

    @Test
    public void calculateRingAreaNegativeTest() throws LinearProgramValidatorException {
        expectedArea = 10;
        Assert.assertNotEquals(RingCalculator.calculateRingArea(positiveTestRing), expectedArea, 0.1);
    }

    @Test (expectedExceptions = LinearProgramValidatorException.class)
    public void calculateRingAreaWithNegativeRingTest() throws LinearProgramValidatorException {
        RingCalculator.calculateRingArea(negativeTestRing);
    }
}