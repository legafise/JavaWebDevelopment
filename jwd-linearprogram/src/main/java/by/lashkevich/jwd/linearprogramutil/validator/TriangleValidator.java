package by.lashkevich.jwd.linearprogramutil.validator;

import by.lashkevich.jwd.entity.Triangle;
import by.lashkevich.jwd.linearprogramutil.finder.SideFinder;

import java.util.List;

public final class TriangleValidator {
    private TriangleValidator() {
    }

    public static boolean isValidTriangle(Triangle triangle) {
        if (triangle == null) {
            return false;
        }

        List<Double> sides = SideFinder.findTriangleSide(triangle);
        return sides.get(0) + sides.get(1) > sides.get(2)
                && sides.get(0) + sides.get(2) > sides.get(1)
                && sides.get(1) + sides.get(2) > sides.get(0);
    }
}
