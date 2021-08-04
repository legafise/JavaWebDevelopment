package by.lashkevich.lb.service.impl;

import by.lashkevich.lb.exception.LoopsAndBranchingServiceException;
import by.lashkevich.lb.loopsandbranchingutil.calculator.LoopsAndBranchingFunctionCalculator;
import by.lashkevich.lb.loopsandbranchingutil.validator.LoopsAndBranchingFunctionDataValidator;
import by.lashkevich.lb.service.FunctionCalculatorService;

import java.util.List;
import java.util.Map;

public class LoopsAndBranchingFunctionCalculatorService implements FunctionCalculatorService {
    @Override
    public double calculateTwoConditionFunction(double x) {
        return LoopsAndBranchingFunctionCalculator
                .calculateTwoConditionFunction(x);
    }

    @Override
    public List<Double> calculateFunctionWithStep(double a,
                                                  double b, double h) throws LoopsAndBranchingServiceException {
        validateFunctionData(a, b, h);
        return LoopsAndBranchingFunctionCalculator.calculateFunctionWithStep(a, b, h);
    }

    @Override
    public Map<Double, Double> calculateTrigonometricFunction(double a,
                                                              double b,
                                                              double h) throws LoopsAndBranchingServiceException {
        validateFunctionData(a, b, h);
        return LoopsAndBranchingFunctionCalculator.calculateTrigonometricFunctionWithStep(a, b, h);
    }

    private void validateFunctionData(double a, double b, double h) throws LoopsAndBranchingServiceException {
        if (!LoopsAndBranchingFunctionDataValidator.validateFunctionWithStepData(a, b, h)) {
            throw new LoopsAndBranchingServiceException();
        }
    }
}
