package by.lashkevich.jwd.service;

import by.lashkevich.jwd.entity.Ring;
import by.lashkevich.jwd.exception.LinearProgramServiceException;

public interface RingService {
    double calculateArea(Ring ring) throws LinearProgramServiceException;
}
