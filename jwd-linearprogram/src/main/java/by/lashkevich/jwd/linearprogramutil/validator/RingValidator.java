package by.lashkevich.jwd.linearprogramutil.validator;

import by.lashkevich.jwd.entity.Ring;

public final class RingValidator {
    private RingValidator() {
    }

    public static boolean isValidRing(Ring ring) {
        if (ring == null) {
            return false;
        }

        return ring.getInnerRadius() > 0 && ring.getInnerRadius() < ring.getOuterRadius();
    }
}
