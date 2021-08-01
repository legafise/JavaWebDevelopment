package by.lashkevich.lb.loopsandbranchingutil.calculator;

import by.lashkevich.lb.entity.Ring;

public final class LoopsAndBranchingRingCalculator {
    private LoopsAndBranchingRingCalculator() {
    }

    public static double calculateRingArea(Ring ring) {
        return Math.PI * (Math.pow(ring.getOuterRadius(), 2)
                - Math.pow(ring.getInnerRadius(), 2));
    }
}
