package by.lashkevich.jwd.linearprogramutil.calculator;

import by.lashkevich.jwd.entity.Ring;

public final class RingCalculator {
    private RingCalculator() {
    }

    public static double calculateRingArea(Ring ring) {
        return Math.PI * (Math.pow(ring.getOuterRadius(), 2)
                - Math.pow(ring.getInnerRadius(), 2));
    }
}
