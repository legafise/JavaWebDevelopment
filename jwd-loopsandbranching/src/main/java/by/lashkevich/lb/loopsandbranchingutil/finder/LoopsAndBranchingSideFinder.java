package by.lashkevich.lb.loopsandbranchingutil.finder;

import by.lashkevich.lb.entity.Triangle;

import java.util.ArrayList;
import java.util.List;

/**
 * Utilitarian class for triangle sids finding
 * @author Roman Lashkevich
 */
public final class LoopsAndBranchingSideFinder {
    private LoopsAndBranchingSideFinder() {
    }

    public static List<Double> findTriangleSide(Triangle triangle) {
        List<Double> triangleSides = new ArrayList<>();
        double firstTriangleSide = Math.sqrt(Math.pow(triangle.getSecondPoint().getX()
                - triangle.getFirstPoint().getX(), 2) + Math.pow(triangle.getSecondPoint().getY()
                - triangle.getFirstPoint().getY(), 2));
        double secondTriangleSide = Math.sqrt(Math.pow(triangle.getThirdPoint().getX()
                - triangle.getSecondPoint().getX(), 2) + Math.pow(triangle.getThirdPoint().getY()
                - triangle.getSecondPoint().getY(), 2));
        double thirdTriangleSide = Math.sqrt(Math.pow(triangle.getFirstPoint().getX()
                - triangle.getThirdPoint().getX(), 2) + Math.pow(triangle.getFirstPoint().getY()
                - triangle.getThirdPoint().getY(), 2));

        triangleSides.add(firstTriangleSide);
        triangleSides.add(secondTriangleSide);
        triangleSides.add(thirdTriangleSide);

        return triangleSides;
    }
}
