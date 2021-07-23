package by.lashkevich.jwd.util.calculator;

import by.lashkevich.jwd.entity.Triangle;
import by.lashkevich.jwd.exception.LinearProgramValidatorException;
import by.lashkevich.jwd.util.finder.SideFinder;

import java.util.List;

import static by.lashkevich.jwd.util.finder.SideFinder.findTriangleSide;
import static by.lashkevich.jwd.util.validator.TriangleValidator.isValidTriangle;
import static java.lang.Math.sqrt;

public final class TriangleCalculator {
    private TriangleCalculator() {
    }

    public static double calculatePerimeter(Triangle triangle) throws LinearProgramValidatorException {
        isValidTriangle(triangle);
        return findTriangleSide(triangle).stream()
                .mapToDouble(currentSide -> currentSide).sum();
    }

    public static double calculateArea(Triangle triangle) throws LinearProgramValidatorException {
        isValidTriangle(triangle);
        List<Double> sides = SideFinder.findTriangleSide(triangle);
        double semiPerimeter = calculatePerimeter(triangle) / 2;
        return sqrt(semiPerimeter * (semiPerimeter - sides.get(0))
                * (semiPerimeter - sides.get(1)) * (semiPerimeter - sides.get(2)));
    }
}
