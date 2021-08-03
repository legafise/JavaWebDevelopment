package by.lashkevich.lb.service.impl;

import by.lashkevich.lb.loopsandbranchingutil.finder.LoopsAndBranchingLeastSquareFinder;
import by.lashkevich.lb.service.LeastSquareFinderService;

public class LoopsAndBranchingLeastSquareFinderService implements LeastSquareFinderService {
    @Override
    public double findLeastSquare(double firstNumber, double secondNumber) {
        return LoopsAndBranchingLeastSquareFinder
                .findLeastSquare(firstNumber, secondNumber);
    }
}
