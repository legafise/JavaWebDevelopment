package by.lashkevich.figures.view;

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

    public String readBillId() {
        return scanner.next();
    }

    public String readRangeValue() {
        return scanner.next();
    }

    public String readClientName() {
        return scanner.next();
    }

    public String readClientSurname() {
        return scanner.next();
    }

    public String readClientAge() {
        return scanner.next();
    }

    public String readBillBalance() {
        return scanner.next();
    }
}
