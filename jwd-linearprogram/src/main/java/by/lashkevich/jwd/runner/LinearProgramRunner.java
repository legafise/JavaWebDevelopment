package by.lashkevich.jwd.runner;

import by.lashkevich.jwd.entity.MenuItem;

import java.util.Scanner;

public class LinearProgramRunner {
    private static final String SELECT_TASK_MESSAGE = "Enter the number and select the task: ";
    private static final String ENTER_ZERO_TO_END_PROGRAM_MESSAGE = "Enter 0 to end the program";
    private static final String THE_FIRST_TASK_INFORMATION = "1. Find the area and perimeter of a" +
            " triangle knowing the coordinates of its vertices";
    private static final String THE_SECOND_TASK_INFORMATION = "2. Determine if a " +
            "point belongs to a shaded area";
    private static final String THE_THIRD_TASK_INFORMATION = "3. Enter any symbol and determine" +
            "its ordinal number, as well as indicate the previous and subsequent symbol";
    private static final String THE_FOURTH_TASK_INFORMATION = "4. Calculate the value of an " +
            "expression using a square root formula";
    private static final String THE_FIFTH_TASK_INFORMATION = "5. Find the area of a ring";

    public static void main(String[] args) {
        boolean isInfinityCycle = true;
        Scanner scanner = new Scanner(System.in);

        while (isInfinityCycle) {
            System.out.println(ENTER_ZERO_TO_END_PROGRAM_MESSAGE + "\n"
                    + SELECT_TASK_MESSAGE + "\n"
                    + THE_FIRST_TASK_INFORMATION + "\n"
                    + THE_SECOND_TASK_INFORMATION + "\n"
                    + THE_THIRD_TASK_INFORMATION + "\n"
                    + THE_FOURTH_TASK_INFORMATION + "\n"
                    + THE_FIFTH_TASK_INFORMATION);

            isInfinityCycle = MenuItem.findMenuItem(scanner.nextInt()).execute();
        }
    }
}


