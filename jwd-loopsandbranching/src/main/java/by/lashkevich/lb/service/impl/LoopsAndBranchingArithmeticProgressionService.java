package by.lashkevich.lb.service.impl;

import by.lashkevich.lb.loopsandbranchingutil.checker.LoopsAndBranchingArithmeticProgressionChecker;
import by.lashkevich.lb.service.ArithmeticProgressionService;

/**
 * @see by.lashkevich.lb.service.ArithmeticProgressionService
 * @author Roman Lashkevich
 */
public class LoopsAndBranchingArithmeticProgressionService implements ArithmeticProgressionService {
    @Override
    public boolean checkArithmeticProgression(long number) {
        return LoopsAndBranchingArithmeticProgressionChecker
                .isArithmeticProgression(number);
    }
}
