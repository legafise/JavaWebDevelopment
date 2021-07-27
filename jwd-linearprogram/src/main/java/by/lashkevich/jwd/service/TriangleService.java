package by.lashkevich.jwd.service;

import by.lashkevich.jwd.entity.Triangle;
import by.lashkevich.jwd.exception.LinearProgramServiceException;

public interface TriangleService {
    double calculateArea(Triangle triangle) throws LinearProgramServiceException;
    double calculatePerimeter(Triangle triangle) throws LinearProgramServiceException;
}
