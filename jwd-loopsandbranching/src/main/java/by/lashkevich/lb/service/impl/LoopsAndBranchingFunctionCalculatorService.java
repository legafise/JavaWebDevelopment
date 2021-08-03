package by.lashkevich.lb.service.impl;

import by.lashkevich.lb.loopsandbranchingutil.calculator.LoopsAndBranchingFunctionCalculator;
import by.lashkevich.lb.service.FunctionCalculatorService;

public class LoopsAndBranchingFunctionCalculatorService implements FunctionCalculatorService {
    @Override
    public double calculateTwoConditionFunction(double x) {
        return LoopsAndBranchingFunctionCalculator
                .calculateTwoConditionFunction(x);
    }
}
