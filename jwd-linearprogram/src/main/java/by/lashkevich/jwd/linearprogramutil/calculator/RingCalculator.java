package by.lashkevich.jwd.linearprogramutil.calculator;

import by.lashkevich.jwd.entity.Ring;
import by.lashkevich.jwd.linearprogramutil.validator.RingValidator;

public final class RingCalculator {
    private RingCalculator() {
    }

    public static double calculateRingArea(Ring ring) {
        RingValidator.isValidRing(ring);
        return Math.PI * (Math.pow(ring.getOuterRadius(), 2)
                - Math.pow(ring.getInnerRadius(), 2));
    }
}
