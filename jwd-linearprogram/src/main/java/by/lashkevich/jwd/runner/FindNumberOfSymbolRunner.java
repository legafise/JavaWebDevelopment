package by.lashkevich.jwd.runner;

import by.lashkevich.jwd.reporter.FindNumberOfSymbolReporter;

import java.util.Scanner;

public final class FindNumberOfSymbolRunner {
    private static final String ENTER_SYMBOL_COORDINATE_MESSAGE = "Enter any symbol";

    private FindNumberOfSymbolRunner() {
    }

    public static void runNumberOfSymbolFinder() {
        Scanner scanner = new Scanner(System.in);
        System.out.println(ENTER_SYMBOL_COORDINATE_MESSAGE);
        FindNumberOfSymbolReporter.reportSymbolsNumbers(scanner.next().charAt(0));
    }
}
