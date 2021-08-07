package by.lashkevich.lb.reporter;

import by.lashkevich.lb.entity.Ring;

import static by.lashkevich.lb.reader.LoopsAndBranchingPropertiesReader.getInstance;

public final class RingCalculatorReporter {
    private static final String RING_INFORMATION_MESSAGE_KEY = "reporter.ring.info.message";
    private static final String AREA_IS_EQUAL_MESSAGE_KEY = "reporter.area.info.message";

    private RingCalculatorReporter() {
    }

    public static void reportRingArea(double area) {
        System.out.println(String.format(getInstance().readMessageFromBundle(AREA_IS_EQUAL_MESSAGE_KEY), area));
    }

    public static void reportRingInfo(Ring ring) {
        System.out.println(getInstance().readMessageFromBundle(RING_INFORMATION_MESSAGE_KEY) + ring);
    }
}
