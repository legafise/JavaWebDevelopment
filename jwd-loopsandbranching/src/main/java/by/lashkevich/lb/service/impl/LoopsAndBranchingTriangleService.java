package by.lashkevich.lb.service.impl;

import by.lashkevich.lb.entity.Triangle;
import by.lashkevich.lb.exception.LoopsAndBranchingServiceException;
import by.lashkevich.lb.loopsandbranchingutil.calculator.LoopsAndBranchingTriangleCalculator;
import by.lashkevich.lb.service.TriangleService;
import by.lashkevich.lb.loopsandbranchingutil.validator.LoopsAndBranchingTriangleValidator;

/**
 * @see by.lashkevich.lb.service.TriangleService
 * @author Roman Lashkevich
 */
public class LoopsAndBranchingTriangleService implements TriangleService {
    private static final String IMPOSSIBLE_TRIANGLE_ERROR_MESSAGE = "Impossible triangle introduced";

    @Override
    public double calculateArea(Triangle triangle) throws LoopsAndBranchingServiceException {
        validateTriangle(triangle);
        return LoopsAndBranchingTriangleCalculator.calculateArea(triangle);
    }

    @Override
    public double calculatePerimeter(Triangle triangle) throws LoopsAndBranchingServiceException {
        validateTriangle(triangle);
        return LoopsAndBranchingTriangleCalculator.calculatePerimeter(triangle);
    }

    private void validateTriangle(Triangle triangle) throws LoopsAndBranchingServiceException {
        if (!LoopsAndBranchingTriangleValidator.isValidTriangle(triangle)) {
            throw new LoopsAndBranchingServiceException(IMPOSSIBLE_TRIANGLE_ERROR_MESSAGE);
        }
    }
}
