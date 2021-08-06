package by.lashkevich.lb.service.impl;

import by.lashkevich.lb.loopsandbranchingutil.finder.LoopsAndBranchingDigitFinder;
import by.lashkevich.lb.service.LargestDigitFinderService;

/**
 * @see by.lashkevich.lb.service.LargestDigitFinderService
 * @author Roman Lashkevich
 */
public class LoopsAndBranchingDigitService implements LargestDigitFinderService {
    @Override
    public int findLargestDigit(long number) {
        return LoopsAndBranchingDigitFinder.findLargestDigit(number);
    }
}
