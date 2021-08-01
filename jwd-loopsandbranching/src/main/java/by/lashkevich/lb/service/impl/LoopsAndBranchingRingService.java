package by.lashkevich.lb.service.impl;

import by.lashkevich.lb.entity.Ring;
import by.lashkevich.lb.exception.LoopsAndBranchingServiceException;
import by.lashkevich.lb.loopsandbranchingutil.calculator.LoopsAndBranchingRingCalculator;
import by.lashkevich.lb.loopsandbranchingutil.validator.LoopsAndBranchingRingValidator;
import by.lashkevich.lb.service.RingService;

public class LoopsAndBranchingRingService implements RingService {
    private static final String IMPOSSIBLE_RING_ERROR_MESSAGE = "Impossible ring was introduced";

    @Override
    public double calculateArea(Ring ring) throws LoopsAndBranchingServiceException {
        if (!LoopsAndBranchingRingValidator.isValidRing(ring)) {
            throw new LoopsAndBranchingServiceException(IMPOSSIBLE_RING_ERROR_MESSAGE);
        }

        return LoopsAndBranchingRingCalculator.calculateRingArea(ring);
    }
}
