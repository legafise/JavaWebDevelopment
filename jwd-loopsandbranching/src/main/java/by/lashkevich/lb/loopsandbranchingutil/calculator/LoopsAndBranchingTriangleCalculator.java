package by.lashkevich.lb.loopsandbranchingutil.calculator;

import by.lashkevich.lb.entity.Triangle;
import by.lashkevich.lb.loopsandbranchingutil.finder.LoopsAndBranchingSideFinder;

import java.util.List;

import static by.lashkevich.lb.loopsandbranchingutil.finder.LoopsAndBranchingSideFinder.findTriangleSide;
import static java.lang.Math.sqrt;

/**
 * Utilitarian class for calculation triangle components
 * @author Roman Lashkevich
 */
public final class LoopsAndBranchingTriangleCalculator {
    private LoopsAndBranchingTriangleCalculator() {
    }

    public static double calculatePerimeter(Triangle triangle) {
        return findTriangleSide(triangle).stream()
                .mapToDouble(currentSide -> currentSide).sum();
    }

    public static double calculateArea(Triangle triangle) {
        List<Double> sides = LoopsAndBranchingSideFinder.findTriangleSide(triangle);
        double semiPerimeter = calculatePerimeter(triangle) / 2;
        return sqrt(semiPerimeter * (semiPerimeter - sides.get(0))
                * (semiPerimeter - sides.get(1)) * (semiPerimeter - sides.get(2)));
    }
}
