package by.lashkevich.jwd.runner;

import by.lashkevich.jwd.reporter.SquareRootFormulaReporter;

import java.util.Scanner;

public final class SquareRootFormulaRunner {
    private static final String ENTER_VARIABLE_A_MESSAGE = "Enter variable a";
    private static final String ENTER_VARIABLE_B_MESSAGE = "Enter variable b";
    private static final String ENTER_VARIABLE_C_MESSAGE = "Enter variable c";

    private SquareRootFormulaRunner() {
    }

    public static void RunSquareRootFormulaCalculation() {
        Scanner scanner = new Scanner(System.in);
        double a;
        double b;
        double c;

        System.out.println(ENTER_VARIABLE_A_MESSAGE);
        a = scanner.nextDouble();

        System.out.println(ENTER_VARIABLE_B_MESSAGE);
        b = scanner.nextDouble();

        System.out.println(ENTER_VARIABLE_C_MESSAGE);
        c = scanner.nextDouble();

        SquareRootFormulaReporter.reportSquareRootFormulaResult(a, b, c);
    }
}
