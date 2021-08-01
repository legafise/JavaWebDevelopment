package by.lashkevich.lb.service;

import by.lashkevich.lb.entity.Triangle;
import by.lashkevich.lb.exception.LoopsAndBranchingServiceException;

public interface TriangleService {
    double calculateArea(Triangle triangle) throws LoopsAndBranchingServiceException;
    double calculatePerimeter(Triangle triangle) throws LoopsAndBranchingServiceException;
}
