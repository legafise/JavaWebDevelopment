package by.lashkevich.jwd.reporter;

import by.lashkevich.jwd.entity.Ring;

public final class RingCalculatorReporter {
    private static final String RING_INFORMATION_MESSAGE = "Ring: ";
    private static final String AREA_IS_EQUAL_MESSAGE = "Area = %.1f\n";

    private RingCalculatorReporter() {
    }

    public static void reportRingArea(double area) {
        System.out.println(String.format(AREA_IS_EQUAL_MESSAGE, area));
    }

    public static void reportRingInfo(Ring ring) {
        System.out.println(RING_INFORMATION_MESSAGE + ring);
    }
}
