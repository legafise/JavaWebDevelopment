package by.lashkevich.lb.service.impl;

import by.lashkevich.lb.loopsandbranchingutil.calculator.LoopsAndBranchingFormulaCalculator;
import by.lashkevich.lb.service.FormulaCalculatorService;

public class LoopsAndBranchingFormulaCalculatorService implements FormulaCalculatorService {
    @Override
    public double calculateSquareRootFormula(double a, double b, double c) {
        return LoopsAndBranchingFormulaCalculator.calculateSquareRootFormula(a, b, c);
    }
}
