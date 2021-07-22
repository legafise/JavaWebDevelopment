package by.lashkevich.jwd.runner;

import java.util.Scanner;

import static by.lashkevich.jwd.reporter.PointCheckerReporter.reportCheckResult;

public final class PointCheckRunner {
    private static final String ENTER_X_COORDINATE_MESSAGE = "Enter the x coordinate";
    private static final String ENTER_Y_COORDINATE_MESSAGE = "Enter the y coordinate";

    private PointCheckRunner() {
    }

    public static void runPointChecker() {
        Scanner scanner = new Scanner(System.in);

        System.out.println(ENTER_X_COORDINATE_MESSAGE);
        int xCoordinate = scanner.nextInt();

        System.out.println(ENTER_Y_COORDINATE_MESSAGE);
        int yCoordinate = scanner.nextInt();

        reportCheckResult(xCoordinate, yCoordinate);
    }
}
