package by.lashkevich.arrays.arraysutill.reader;

import java.util.Scanner;

public class ArraysViewConsoleReader {
    private final Scanner SCANNER = new Scanner(System.in);

    public int readCommandNumber() {
        return SCANNER.nextInt();
    }

    public int readDataEntryNumber() {
        return SCANNER.nextInt();
    }

    public int readLocaleNumber() {
        return SCANNER.nextInt();
    }

    public int readRequestNumber() {
        return SCANNER.nextInt();
    }
}
