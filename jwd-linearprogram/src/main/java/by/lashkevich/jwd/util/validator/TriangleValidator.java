package by.lashkevich.jwd.util.validator;

import by.lashkevich.jwd.entity.Triangle;
import by.lashkevich.jwd.exception.TriangleValidatorException;
import by.lashkevich.jwd.util.finder.SideFinder;

import java.util.List;

public final class TriangleValidator {
    private static final String IMPOSSIBLE_TRIANGLE_ERROR_MESSAGE = "Impossible triangle introduced";

    private TriangleValidator() {
    }

    public static void isValidTriangle(Triangle triangle) throws TriangleValidatorException {
        List<Double> sides = SideFinder.findTriangleSide(triangle);
        boolean isValid = sides.get(0) + sides.get(1) > sides.get(2)
                && sides.get(0) + sides.get(2) > sides.get(1)
                && sides.get(1) + sides.get(2) > sides.get(0);

        if (!isValid) {
            throw new TriangleValidatorException(IMPOSSIBLE_TRIANGLE_ERROR_MESSAGE);
        }
    }
}
