package by.lashkevich.lb.service;

import by.lashkevich.lb.entity.Ring;
import by.lashkevich.lb.exception.LoopsAndBranchingServiceException;

public interface RingService {
    double calculateArea(Ring ring) throws LoopsAndBranchingServiceException;
}
