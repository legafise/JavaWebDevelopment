package by.lashkevich.jwd.linearprogramutil.calculator;

import by.lashkevich.jwd.entity.Triangle;
import by.lashkevich.jwd.linearprogramutil.finder.SideFinder;

import java.util.List;

import static by.lashkevich.jwd.linearprogramutil.finder.SideFinder.findTriangleSide;
import static java.lang.Math.sqrt;

public final class TriangleCalculator {
    private TriangleCalculator() {
    }

    public static double calculatePerimeter(Triangle triangle) {
        return findTriangleSide(triangle).stream()
                .mapToDouble(currentSide -> currentSide).sum();
    }

    public static double calculateArea(Triangle triangle) {
        List<Double> sides = SideFinder.findTriangleSide(triangle);
        double semiPerimeter = calculatePerimeter(triangle) / 2;
        return sqrt(semiPerimeter * (semiPerimeter - sides.get(0))
                * (semiPerimeter - sides.get(1)) * (semiPerimeter - sides.get(2)));
    }
}
