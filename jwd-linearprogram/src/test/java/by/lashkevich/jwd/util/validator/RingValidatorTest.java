package by.lashkevich.jwd.util.validator;

import by.lashkevich.jwd.entity.Ring;
import by.lashkevich.jwd.exception.LinearProgramValidatorException;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RingValidatorTest {
    private Ring positiveTestRing;
    private Ring negativeTestRing;
    private double testInnerRadius;
    private double positiveTestOuterRadius;
    private double negativeTestOuterRadius;

    @BeforeMethod
    public void setUp() {
        testInnerRadius = 8;
        positiveTestOuterRadius = 9;
        negativeTestOuterRadius = 5;
        positiveTestRing = new Ring(testInnerRadius, positiveTestOuterRadius);
        negativeTestRing = new Ring(testInnerRadius, negativeTestOuterRadius);
    }

    @Test
    public void isValidRingPositiveTest() throws LinearProgramValidatorException {
        RingValidator.isValidRing(positiveTestRing);
    }

    @Test (expectedExceptions = LinearProgramValidatorException.class)
    public void isValidRingNegativeTest() throws LinearProgramValidatorException {
        RingValidator.isValidRing(negativeTestRing);
    }
}