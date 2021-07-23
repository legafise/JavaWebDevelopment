package by.lashkevich.jwd.util.validator;

import by.lashkevich.jwd.entity.Ring;
import by.lashkevich.jwd.exception.LinearProgramValidatorException;

public class RingValidator {
    private static final String IMPOSSIBLE_RING_ERROR_MESSAGE = "Impossible ring introduced";

    private RingValidator() {
    }

    public static void isValidRing(Ring ring) throws LinearProgramValidatorException {
        boolean isValid = !(ring.getInnerRadius() > ring.getOuterRadius());

        if (!isValid) {
            throw new LinearProgramValidatorException(IMPOSSIBLE_RING_ERROR_MESSAGE);
        }
    }
}
