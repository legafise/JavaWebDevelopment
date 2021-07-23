package by.lashkevich.jwd.runner;

import by.lashkevich.jwd.entity.Ring;
import by.lashkevich.jwd.reporter.RingCalculatorReporter;

import java.util.Scanner;

public final class RingCalculatorRunner {
    private static final String ENTER_INNER_RADIUS_MESSAGE = "Enter the inner radius";
    private static final String ENTER_OUTER_RADIUS_MESSAGE = "Enter the outer radius";

    private RingCalculatorRunner() {
    }

    public static void runRingCalculator() {
        Scanner scanner = new Scanner(System.in);
        Ring ring = new Ring();

        System.out.println(ENTER_INNER_RADIUS_MESSAGE);
        ring.setInnerRadius(scanner.nextDouble());

        System.out.println(ENTER_OUTER_RADIUS_MESSAGE);
        ring.setOuterRadius(scanner.nextDouble());

        RingCalculatorReporter.reportRingArea(ring);
    }
}
