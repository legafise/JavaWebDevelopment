package by.lashkevich.jwd.util.calculator;

import by.lashkevich.jwd.entity.Triangle;
import by.lashkevich.jwd.exception.TriangleValidatorException;

public interface Calculator {
    double calculateArea(Triangle triangle) throws TriangleValidatorException;
    double calculatePerimeter(Triangle triangle) throws TriangleValidatorException;
}
