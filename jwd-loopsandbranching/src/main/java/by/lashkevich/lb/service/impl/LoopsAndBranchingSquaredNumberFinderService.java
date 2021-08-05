package by.lashkevich.lb.service.impl;

import by.lashkevich.lb.loopsandbranchingutil.finder.LoopsAndBranchingLeastSquareFinder;
import by.lashkevich.lb.service.LeastSquareFinderService;

public class LoopsAndBranchingSquaredNumberFinderService implements LeastSquareFinderService {
    @Override
    public double findLeastSquaredNumber(double firstNumber, double secondNumber) {
        return LoopsAndBranchingLeastSquareFinder
                .findLeastSquare(firstNumber, secondNumber);
    }
}
