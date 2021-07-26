package by.lashkevich.jwd.service;

import by.lashkevich.jwd.entity.Triangle;
import by.lashkevich.jwd.exception.LinearProgramServiceException;
import by.lashkevich.jwd.linearprogramutil.calculator.TriangleCalculator;

import static by.lashkevich.jwd.linearprogramutil.validator.TriangleValidator.isValidTriangle;

public class LinearProgramTriangleService {
    private static final String IMPOSSIBLE_TRIANGLE_ERROR_MESSAGE = "Impossible triangle introduced";

    public double calculateArea(Triangle triangle) throws LinearProgramServiceException {
        validateTriangle(triangle);
        return TriangleCalculator.calculateArea(triangle);
    }

    public double calculatePerimeter(Triangle triangle) throws LinearProgramServiceException {
        validateTriangle(triangle);
        return TriangleCalculator.calculatePerimeter(triangle);
    }

    private void validateTriangle(Triangle triangle) throws LinearProgramServiceException {
        if (!isValidTriangle(triangle)) {
            throw new LinearProgramServiceException(IMPOSSIBLE_TRIANGLE_ERROR_MESSAGE);
        }
    }
}
