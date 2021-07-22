package by.lashkevich.jwd.util.validator;

import by.lashkevich.jwd.entity.Triangle;
import by.lashkevich.jwd.util.finder.SideFinder;

import java.util.List;

public final class TriangleValidator {
    private TriangleValidator() {
    }

    public static boolean isValidTriangle(Triangle triangle) {
        List<Double> sides = SideFinder.findTriangleSide(triangle);
        return sides.get(0) + sides.get(1) > sides.get(2)
                && sides.get(0) + sides.get(2) > sides.get(1)
                && sides.get(1) + sides.get(2) > sides.get(0);
    }
}
