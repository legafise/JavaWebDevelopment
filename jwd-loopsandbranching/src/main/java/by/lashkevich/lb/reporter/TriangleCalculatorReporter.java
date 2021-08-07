package by.lashkevich.lb.reporter;

import by.lashkevich.lb.entity.Triangle;
import by.lashkevich.lb.reader.LoopsAndBranchingPropertiesReader;

import static by.lashkevich.lb.reader.LoopsAndBranchingPropertiesReader.getInstance;

public final class TriangleCalculatorReporter {
    private static final String PERIMETER_AND_AREA_ARE_EQUAL_MESSAGE_KEY = "reporter.perimeter.and.area.equal.message";
    private static final String TRIANGLE_INFO_MESSAGE_KEY = "reporter.triangle.info.message";

    private TriangleCalculatorReporter() {
    }

    public static void reportTrianglePerimeterAndArea(double perimeter, double area) {
        System.out.println(String.format(getInstance()
                        .readMessageFromBundle(PERIMETER_AND_AREA_ARE_EQUAL_MESSAGE_KEY), perimeter, area));
    }

    public static void reportTriangleInfo(Triangle triangle) {
        System.out.println(getInstance().readMessageFromBundle(TRIANGLE_INFO_MESSAGE_KEY) + triangle);
    }
}
