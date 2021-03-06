package by.lashkevich.lb.service.impl;

import by.lashkevich.lb.loopsandbranchingutil.calculator.LoopsAndBranchingFormulaCalculator;
import by.lashkevich.lb.service.FormulaCalculatorService;

/**
 * @see by.lashkevich.lb.service.FormulaCalculatorService
 * @author Roman Lashkevich
 */
public class LoopsAndBranchingFormulaService implements FormulaCalculatorService {
    @Override
    public double calculateSquareRootFormula(double a, double b, double c) {
        return LoopsAndBranchingFormulaCalculator.calculateSquareRootFormula(a, b, c);
    }
}
