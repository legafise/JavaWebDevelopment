package by.lashkevich.lb.reader;

import java.util.Scanner;

public class LoopsAndBranchingMainViewReader {
    private final Scanner SCANNER = new Scanner(System.in);

    public int readCommandNumber() {
        return SCANNER.nextInt();
    }

    public int readDataEntryNumber() {
        return SCANNER.nextInt();
    }
}
