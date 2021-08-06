package by.lashkevich.lb.service;

import by.lashkevich.lb.entity.Triangle;
import by.lashkevich.lb.exception.LoopsAndBranchingServiceException;

/**
 * Service that executes the logic of the calculate triangle task
 * @author Roman Lashkevich
 */
public interface TriangleService {
    double calculateArea(Triangle triangle) throws LoopsAndBranchingServiceException;
    double calculatePerimeter(Triangle triangle) throws LoopsAndBranchingServiceException;
}
