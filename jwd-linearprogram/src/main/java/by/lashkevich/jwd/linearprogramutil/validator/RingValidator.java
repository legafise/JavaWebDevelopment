package by.lashkevich.jwd.linearprogramutil.validator;

import by.lashkevich.jwd.entity.Ring;

public final class RingValidator {
    private static final String IMPOSSIBLE_RING_ERROR_MESSAGE = "Impossible ring introduced";

    private RingValidator() {
    }

    public static boolean isValidRing(Ring ring) {
        if (ring == null) {
            return false;
        }

        return ring.getInnerRadius() < ring.getOuterRadius();
    }
}
