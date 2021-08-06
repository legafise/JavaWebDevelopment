package by.lashkevich.lb.loopsandbranchingutil.validator;

import by.lashkevich.lb.entity.Ring;

/**
 * Utilitarian class for ring validation
 * @author Roman Lashkevich
 */
public final class LoopsAndBranchingRingValidator {
    private LoopsAndBranchingRingValidator() {
    }

    public static boolean isValidRing(Ring ring) {
        if (ring == null) {
            return false;
        }

        return ring.getInnerRadius() > 0 && ring.getInnerRadius() < ring.getOuterRadius();
    }
}
