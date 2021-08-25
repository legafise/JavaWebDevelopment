package by.lashkevich.bills.view;

import java.util.Scanner;

/**
 * Class for reading data for views from console
 * @author Roman Lashkevich
 */
public class ViewConsoleReader {
    private final Scanner scanner = new Scanner(System.in);

    public int readCommandNumber() {
        return scanner.nextInt();
    }

    public int readLocaleNumber() {
        return scanner.nextInt();
    }

    public int readRequestNumber() {
        return scanner.nextInt();
    }

    public String readClientId() {
        return scanner.next();
    }
}
