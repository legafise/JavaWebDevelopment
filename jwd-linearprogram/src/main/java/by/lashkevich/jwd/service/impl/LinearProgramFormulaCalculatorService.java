package by.lashkevich.jwd.service.impl;

import by.lashkevich.jwd.linearprogramutil.calculator.FormulaCalculator;
import by.lashkevich.jwd.service.FormulaCalculatorService;

public class LinearProgramFormulaCalculatorService implements FormulaCalculatorService {
    @Override
    public double calculateSquareRootFormula(double a, double b, double c) {
        return FormulaCalculator.calculateSquareRootFormula(a, b, c);
    }
}
