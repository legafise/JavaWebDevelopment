package by.lashkevich.jwd.reader;

import java.util.Scanner;

public class LinearProgramMainViewReader {
    private final Scanner SCANNER = new Scanner(System.in);

    public int readCommandNumber() {
        return SCANNER.nextInt();
    }

    public int readDataEntry() {
        return SCANNER.nextInt();
    }
}
