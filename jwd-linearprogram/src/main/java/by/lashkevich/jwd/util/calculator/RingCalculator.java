package by.lashkevich.jwd.util.calculator;

import by.lashkevich.jwd.entity.Ring;
import by.lashkevich.jwd.exception.LinearProgramValidatorException;
import by.lashkevich.jwd.util.validator.RingValidator;

public final class RingCalculator {
    private RingCalculator() {
    }

    public static double calculateRingArea(Ring ring) throws LinearProgramValidatorException {
        RingValidator.isValidRing(ring);
        return Math.PI * (Math.pow(ring.getOuterRadius(), 2)
                - Math.pow(ring.getInnerRadius(), 2));
    }
}
