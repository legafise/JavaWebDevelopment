package by.lashkevich.lb.loopsandbranchingutil.validator;

import by.lashkevich.lb.entity.Triangle;
import by.lashkevich.lb.loopsandbranchingutil.finder.LoopsAndBranchingSideFinder;

import java.util.List;

/**
 * Utilitarian class for triangle validation
 * @author Roman Lashkevich
 */
public final class LoopsAndBranchingTriangleValidator {
    private LoopsAndBranchingTriangleValidator() {
    }

    public static boolean isValidTriangle(Triangle triangle) {
        if (triangle == null) {
            return false;
        }

        List<Double> sides = LoopsAndBranchingSideFinder.findTriangleSide(triangle);
        return sides.get(0) + sides.get(1) > sides.get(2)
                && sides.get(0) + sides.get(2) > sides.get(1)
                && sides.get(1) + sides.get(2) > sides.get(0);
    }
}
