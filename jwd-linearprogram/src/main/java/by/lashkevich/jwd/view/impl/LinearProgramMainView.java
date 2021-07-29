package by.lashkevich.jwd.view.impl;

import by.lashkevich.jwd.constant.LinearProgramConstant;
import by.lashkevich.jwd.controller.Request;
import by.lashkevich.jwd.reader.LinearProgramMainViewReader;
import by.lashkevich.jwd.server.LinearProgramServer;
import by.lashkevich.jwd.view.View;

public class LinearProgramMainView implements View {
    private static final String SELECT_TASK_MESSAGE = "Enter the number and select the task: ";
    private static final String SELECT_DATA_ENTRY_TYPE_MESSAGE = "Select the type of data entry: ";
    private static final String NO_SUCH_TASK_MESSAGE = "Task under this number does not exist\n";
    private static final String CONSOLE_DATA_ENTRY_MESSAGE = "1. Console data entry\n";
    private static final String FILE_DATA_ENTRY_MESSAGE = "2. File data entry";
    private static final String NO_SUCH_DATA_ENTRY_TYPE_MESSAGE = "Data entry type under this number does not exist\n";
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
    private LinearProgramServer server;
    private LinearProgramMainViewReader reader;

    public LinearProgramMainView() {
        server = new LinearProgramServer();
        reader = new LinearProgramMainViewReader();
    }

    @Override
    public void executeView() {
        Request request = new Request();

        System.out.println(ENTER_ZERO_TO_END_PROGRAM_MESSAGE + NEW_LINE_BREAK
                + SELECT_TASK_MESSAGE + NEW_LINE_BREAK
                + THE_FIRST_TASK_INFORMATION + NEW_LINE_BREAK
                + THE_SECOND_TASK_INFORMATION + NEW_LINE_BREAK
                + THE_THIRD_TASK_INFORMATION + NEW_LINE_BREAK
                + THE_FOURTH_TASK_INFORMATION + NEW_LINE_BREAK
                + THE_FIFTH_TASK_INFORMATION);
        int commandNumber = reader.readCommandNumber();

        if (commandNumber > 5 || commandNumber < 0) {
            System.out.println(NO_SUCH_TASK_MESSAGE);
            request.putParameter(LinearProgramConstant.COMMAND_NUMBER, 6);
        } else {
            request.putParameter(LinearProgramConstant.COMMAND_NUMBER, commandNumber);
        }

        server.handleRequest(request);
    }

    @Override
    public int getViewCommandNumber() {
        return 6;
    }
}


