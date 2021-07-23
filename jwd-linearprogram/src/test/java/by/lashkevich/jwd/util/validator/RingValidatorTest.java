package by.lashkevich.jwd.util.validator;

import by.lashkevich.jwd.entity.Ring;
import by.lashkevich.jwd.exception.LinearProgramValidatorException;
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
        try {
            RingValidator.isValidRing(positiveTestRing);
        } catch (LinearProgramValidatorException e) {
            Assert.fail(e.getMessage());
        }
    }

    @Test (expectedExceptions = LinearProgramValidatorException.class)
    public void isValidRingNegativeTest() throws LinearProgramValidatorException {
        RingValidator.isValidRing(negativeTestRing);
    }
}