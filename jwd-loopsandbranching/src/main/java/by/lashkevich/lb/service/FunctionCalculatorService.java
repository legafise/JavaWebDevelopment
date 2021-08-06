package by.lashkevich.lb.service;

import by.lashkevich.lb.exception.LoopsAndBranchingServiceException;

import java.util.List;
import java.util.Map;

/**
 * Service that executes the logic of the functions calculation tasks
 * @author Roman Lashkevich
 */
public interface FunctionCalculatorService {
    double calculateTwoConditionFunction(double x);

    List<Double> calculateFunctionWithStep(double a, double b,
                                           double h) throws LoopsAndBranchingServiceException;

    Map<Double, Double> calculateTrigonometricFunction(double a, double b,
                                                       double h) throws LoopsAndBranchingServiceException;

    Map<Double, Double> calculateFunctionWithoutDataEntry();
}
