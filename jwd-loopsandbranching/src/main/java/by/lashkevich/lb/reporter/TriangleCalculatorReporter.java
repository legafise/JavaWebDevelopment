package by.lashkevich.lb.reporter;

import by.lashkevich.lb.entity.Triangle;

public final class TriangleCalculatorReporter {
    private static final String PERIMETER_AND_AREA_ARE_EQUAL_MESSAGE = "Perimeter = %.1f; Area = %.1f\n";
    private static final String TRIANGLE_INFO_MESSAGE = "\nTriangle info: ";

    private TriangleCalculatorReporter() {
    }

    public static void reportTrianglePerimeterAndArea(double perimeter, double area) {
        System.out.println(String.format(PERIMETER_AND_AREA_ARE_EQUAL_MESSAGE, perimeter, area));
    }

    public static void reportTriangleInfo(Triangle triangle) {
        System.out.println(TRIANGLE_INFO_MESSAGE + triangle);
    }
}
