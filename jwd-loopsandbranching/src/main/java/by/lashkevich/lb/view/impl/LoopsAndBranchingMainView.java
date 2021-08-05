package by.lashkevich.lb.view.impl;

import by.lashkevich.lb.constant.LoopsAndBranchingConstant;
import by.lashkevich.lb.controller.LoopsAndBranchingController;
import by.lashkevich.lb.controller.Request;
import by.lashkevich.lb.reader.LoopsAndBranchingMainViewReader;
import by.lashkevich.lb.reader.LoopsAndBranchingReaderFactory;
import by.lashkevich.lb.view.View;

public class LoopsAndBranchingMainView implements View {
    private static final String SELECT_TASK_MESSAGE = "Enter the number and select the task: ";
    private static final String SELECT_DATA_ENTRY_TYPE_MESSAGE = "Select the type of data entry: ";
    private static final String NO_SUCH_TASK_MESSAGE = "Task under this number does not exist\n";
    private static final String CONSOLE_DATA_ENTRY_MESSAGE = "\n1. Console data entry\n";
    private static final String FILE_DATA_ENTRY_MESSAGE = "2. File data entry";
    private static final String NO_SUCH_DATA_ENTRY_TYPE_MESSAGE = "Data entry type under this" +
            "number does not exist\n";
    private static final String NEW_LINE_BREAK = "\n";
    private static final String ENTER_ZERO_TO_END_PROGRAM_MESSAGE = "Enter 0 to end the program";
    private static final String THE_FIRST_TASK_INFORMATION = "1. Find the area and perimeter of a" +
            " triangle knowing the coordinates of its vertices";
    private static final String THE_FIFTH_TASK_INFORMATION = "5. Determine if a " +
            "point belongs to a shaded area";
    private static final String THE_THIRD_TASK_INFORMATION = "3. Enter any symbol and determine" +
            "its ordinal number, as well as indicate the previous and subsequent symbol";
    private static final String THE_FOURTH_TASK_INFORMATION = "4. Calculate the value of an " +
            "expression using a square root formula";
    private static final String THE_SECOND_TASK_INFORMATION = "2. Find the area of a ring";
    private static final String THE_SIXTH_TASK_INFORMATION = "6. Calculate function with " +
            "two conditions";
    private static final String THE_SEVENTH_TASK_INFORMATION = "7. Validate date";
    private static final String THE_EIGHTH_TASK_INFORMATION = "8. Find the least" +
            "square of two numbers";
    private static final String THE_NINTH_TASK_INFORMATION = "9. Determine which point" +
            "is closer to origin of coordinates.";
    private static final String THE_TENTH_TASK_INFORMATION = "10. Define available modules by password";
    private static final String THE_ELEVENTH_TASK_INFORMATION = "11. Calculate the values of the" +
            "trigonometric function F (x) on the segment [a, b] with step h";
    private static final String THE_TWELFTH_TASK_INFORMATION = "12. Calculate the values of the" +
            "function F (x) on the segment [a, b] with step h";
    private static final String THE_THIRTEENTH_TASK_INFORMATION = "13. Find the largest digit of" +
            "a given natural number";
    private static final String THE_FOURTEENTH_TASK_INFORMATION = "14. Make a table of the values" +
            "of the function y = 5 - x^2 / 2 on the segment [-5; 5] with a step of 0.5";
    private static final String THE_FIFTEENTH_TASK_INFORMATION = "15. For a given natural number, " +
            "determine whether its digits form an arithmetic progression";
    private LoopsAndBranchingController controller;
    private LoopsAndBranchingMainViewReader reader;

    public LoopsAndBranchingMainView() {
        controller = new LoopsAndBranchingController();
        reader = new LoopsAndBranchingMainViewReader();
    }

    @Override
    public void executeView() {
        Request request = new Request();
        System.out.println(SELECT_DATA_ENTRY_TYPE_MESSAGE
                + CONSOLE_DATA_ENTRY_MESSAGE
                + FILE_DATA_ENTRY_MESSAGE);
        int dataEntryTypeNumber = reader.readDataEntryNumber();
        if (dataEntryTypeNumber < 1 || dataEntryTypeNumber > 2) {
            System.out.println(NO_SUCH_DATA_ENTRY_TYPE_MESSAGE);
            request.putParameter(LoopsAndBranchingConstant.COMMAND_NUMBER, getViewCommandNumber());
        } else {
            LoopsAndBranchingReaderFactory.getInstance().setDataReaderNumber(dataEntryTypeNumber);

            System.out.println(ENTER_ZERO_TO_END_PROGRAM_MESSAGE + NEW_LINE_BREAK
                    + SELECT_TASK_MESSAGE + NEW_LINE_BREAK
                    + THE_FIRST_TASK_INFORMATION + NEW_LINE_BREAK
                    + THE_SECOND_TASK_INFORMATION + NEW_LINE_BREAK
                    + THE_THIRD_TASK_INFORMATION + NEW_LINE_BREAK
                    + THE_FOURTH_TASK_INFORMATION + NEW_LINE_BREAK
                    + THE_FIFTH_TASK_INFORMATION + NEW_LINE_BREAK
                    + THE_SIXTH_TASK_INFORMATION + NEW_LINE_BREAK
                    + THE_SEVENTH_TASK_INFORMATION + NEW_LINE_BREAK
                    + THE_EIGHTH_TASK_INFORMATION + NEW_LINE_BREAK
                    + THE_NINTH_TASK_INFORMATION + NEW_LINE_BREAK
                    + THE_TENTH_TASK_INFORMATION + NEW_LINE_BREAK
                    + THE_ELEVENTH_TASK_INFORMATION + NEW_LINE_BREAK
                    + THE_TWELFTH_TASK_INFORMATION + NEW_LINE_BREAK
                    + THE_THIRTEENTH_TASK_INFORMATION + NEW_LINE_BREAK
                    + THE_FOURTEENTH_TASK_INFORMATION + NEW_LINE_BREAK
                    + THE_FIFTEENTH_TASK_INFORMATION);
            int commandNumber = reader.readCommandNumber();

            if (commandNumber > 15 || commandNumber < 0) {
                System.out.println(NO_SUCH_TASK_MESSAGE);
                request.putParameter(LoopsAndBranchingConstant.COMMAND_NUMBER, getViewCommandNumber());
            } else {
                request.putParameter(LoopsAndBranchingConstant.COMMAND_NUMBER, commandNumber);
            }

        }
        controller.doRequest(request).executeView();
    }

    @Override
    public int getViewCommandNumber() {
        return -1;
    }
}


