package by.lashkevich.lb.reporter;

import by.lashkevich.lb.entity.Ring;

public final class RingCalculatorReporter {
    private static final String RING_INFORMATION_MESSAGE = "\nRing: ";
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
