package by.lashkevich.jwd.util.calculator;

import by.lashkevich.jwd.entity.Triangle;
import by.lashkevich.jwd.exception.TriangleCalculatorException;

public interface Calculator {
    double calculateArea(Triangle triangle) throws TriangleCalculatorException;
    double calculatePerimeter(Triangle triangle) throws TriangleCalculatorException;
}
