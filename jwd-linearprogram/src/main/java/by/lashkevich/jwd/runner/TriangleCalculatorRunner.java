package by.lashkevich.jwd.runner;

import by.lashkevich.jwd.entity.Point;
import by.lashkevich.jwd.entity.Triangle;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static by.lashkevich.jwd.reporter.TriangleCalculatorReporter.reportTrianglePerimeterAndArea;

public final class TriangleCalculatorRunner {
    private static final String ENTER_POINT_COORDINATES_MESSAGE = "Enter the coordinates of the point №";
    private static final String ENTER_X_COORDINATE_MESSAGE = "Enter the x coordinate";
    private static final String ENTER_Y_COORDINATE_MESSAGE = "Enter the y coordinate";

    private TriangleCalculatorRunner() {
    }

    public static void runTriangleCalculator() {
        Scanner scanner = new Scanner(System.in);
        Point firstPoint = new Point();
        Point secondPoint = new Point();
        Point thirdPoint = new Point();
        List<Point> pointList = Arrays.asList(firstPoint, secondPoint, thirdPoint);

        for (int i = 0; i < 3; i++) {
            System.out.println(ENTER_POINT_COORDINATES_MESSAGE + (i + 1));

            System.out.println(ENTER_X_COORDINATE_MESSAGE);
            pointList.get(i).setX(scanner.nextDouble());

            System.out.println(ENTER_Y_COORDINATE_MESSAGE);
            pointList.get(i).setY(scanner.nextDouble());
        }

        Triangle triangle = new Triangle(pointList.get(0), pointList.get(1), pointList.get(2));

        reportTrianglePerimeterAndArea(triangle);
    }
}
