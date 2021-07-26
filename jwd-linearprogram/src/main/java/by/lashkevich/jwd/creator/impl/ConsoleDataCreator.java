package by.lashkevich.jwd.creator.impl;

import by.lashkevich.jwd.entity.Point;
import by.lashkevich.jwd.entity.Ring;
import by.lashkevich.jwd.entity.Triangle;
import by.lashkevich.jwd.creator.DataCreator;
import by.lashkevich.jwd.linearprogramutil.finder.SymbolNumbersFinder;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class ConsoleDataCreator implements DataCreator {
    private static final String ENTER_POINT_COORDINATES_MESSAGE = "Enter the coordinates of the point №";
    private static final String ENTER_X_COORDINATE_MESSAGE = "Enter the x coordinate";
    private static final String ENTER_Y_COORDINATE_MESSAGE = "Enter the y coordinate";
    private static final String ENTER_INNER_RADIUS_MESSAGE = "Enter the inner radius";
    private static final String ENTER_OUTER_RADIUS_MESSAGE = "Enter the outer radius";
    private static final String ENTER_SYMBOL_COORDINATE_MESSAGE = "Enter any symbol";
    private final Scanner SCANNER;

    public ConsoleDataCreator() {
        this.SCANNER = new Scanner(System.in);
    }

    @Override
    public Triangle createTriangle() {
        Point firstPoint = new Point();
        Point secondPoint = new Point();
        Point thirdPoint = new Point();
        List<Point> pointList = Arrays.asList(firstPoint, secondPoint, thirdPoint);

        for (int i = 0; i < 3; i++) {
            System.out.println(ENTER_POINT_COORDINATES_MESSAGE + (i + 1));

            System.out.println(ENTER_X_COORDINATE_MESSAGE);
            pointList.get(i).setX(SCANNER.nextDouble());

            System.out.println(ENTER_Y_COORDINATE_MESSAGE);
            pointList.get(i).setY(SCANNER.nextDouble());
        }

        return new Triangle(pointList.get(0), pointList.get(1), pointList.get(2));
    }

    @Override
    public Ring createRing() {
        Ring ring = new Ring();

        System.out.println(ENTER_INNER_RADIUS_MESSAGE);
        ring.setInnerRadius(SCANNER.nextDouble());

        System.out.println(ENTER_OUTER_RADIUS_MESSAGE);
        ring.setOuterRadius(SCANNER.nextDouble());

        return ring;
    }

    @Override
    public char createSymbol() {
        System.out.println(ENTER_SYMBOL_COORDINATE_MESSAGE);
        return SCANNER.next().charAt(0);
    }
}
