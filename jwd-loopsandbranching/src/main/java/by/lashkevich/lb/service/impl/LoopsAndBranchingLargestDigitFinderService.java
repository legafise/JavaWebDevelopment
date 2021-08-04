package by.lashkevich.lb.service.impl;

import by.lashkevich.lb.loopsandbranchingutil.finder.LoopsAndBranchingDigitFinder;
import by.lashkevich.lb.service.LargestDigitFinderService;

public class LoopsAndBranchingLargestDigitFinderService implements LargestDigitFinderService {
    @Override
    public int findLargestDigit(long number) {
        return LoopsAndBranchingDigitFinder.findLargestDigit(number);
    }
}
