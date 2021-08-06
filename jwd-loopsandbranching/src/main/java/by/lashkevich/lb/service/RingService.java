package by.lashkevich.lb.service;

import by.lashkevich.lb.entity.Ring;
import by.lashkevich.lb.exception.LoopsAndBranchingServiceException;

/**
 * Service that executes the logic of the calculate ring task
 * @author Roman Lashkevich
 */
public interface RingService {
    double calculateArea(Ring ring) throws LoopsAndBranchingServiceException;
}
