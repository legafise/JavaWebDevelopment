package by.lashkevich.jwd.service.impl;

import by.lashkevich.jwd.entity.Ring;
import by.lashkevich.jwd.exception.LinearProgramServiceException;
import by.lashkevich.jwd.linearprogramutil.calculator.RingCalculator;
import by.lashkevich.jwd.linearprogramutil.validator.RingValidator;
import by.lashkevich.jwd.service.RingService;

public class LinearProgramRingService implements RingService {
    private static final String IMPOSSIBLE_RING_ERROR_MESSAGE = "Impossible ring was introduced";

    @Override
    public double calculateArea(Ring ring) throws LinearProgramServiceException {
        if (!RingValidator.isValidRing(ring)) {
            throw new LinearProgramServiceException(IMPOSSIBLE_RING_ERROR_MESSAGE);
        }

        return RingCalculator.calculateRingArea(ring);
    }
}
