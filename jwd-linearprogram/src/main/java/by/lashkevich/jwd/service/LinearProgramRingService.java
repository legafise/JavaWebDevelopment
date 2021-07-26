package by.lashkevich.jwd.service;

import by.lashkevich.jwd.entity.Ring;
import by.lashkevich.jwd.exception.LinearProgramServiceException;
import by.lashkevich.jwd.linearprogramutil.calculator.RingCalculator;
import by.lashkevich.jwd.linearprogramutil.validator.RingValidator;

public class LinearProgramRingService {
    private static final String IMPOSSIBLE_RING_ERROR_MESSAGE = "Impossible ring was introduced";

    public double calculateArea(Ring ring) throws LinearProgramServiceException {
        if (!RingValidator.isValidRing(ring)) {
            throw new LinearProgramServiceException(IMPOSSIBLE_RING_ERROR_MESSAGE);
        }

        return RingCalculator.calculateRingArea(ring);
    }
}
