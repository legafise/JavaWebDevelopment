package by.lashkevich.jwd.linearprogramutil.validator;

import by.lashkevich.jwd.entity.Ring;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RingValidatorTest {
    private Ring positiveTestRing;
    private Ring negativeTestRing;

    @BeforeMethod
    public void setUp() {
        double testInnerRadius = 8;
        double positiveTestOuterRadius = 9;
        double negativeTestOuterRadius = 5;
        positiveTestRing = new Ring(testInnerRadius, positiveTestOuterRadius);
        negativeTestRing = new Ring(testInnerRadius, negativeTestOuterRadius);
    }

    @Test
    public void isValidRingPositiveTest() {
        Assert.assertTrue(RingValidator.isValidRing(positiveTestRing));
    }

    @Test
    public void isValidRingNegativeTest() {
        Assert.assertFalse(RingValidator.isValidRing(negativeTestRing));
    }
}