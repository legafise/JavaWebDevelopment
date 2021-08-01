package by.lashkevich.lb.view.impl;

import by.lashkevich.lb.constant.LoopsAndBranchingConstant;
import by.lashkevich.lb.controller.Request;
import by.lashkevich.lb.reader.LoopsAndBranchingMainViewReader;
import by.lashkevich.lb.reader.LoopsAndBranchingReaderFactory;
import by.lashkevich.lb.server.LoopsAndBranchingServer;
import by.lashkevich.lb.view.View;

public class LoopsAndBranchingMainView implements View {
    private static final String SELECT_TASK_MESSAGE = "Enter the number and select the task: ";
    private static final String SELECT_DATA_ENTRY_TYPE_MESSAGE = "Select the type of data entry: ";
    private static final String NO_SUCH_TASK_MESSAGE = "Task under this number does not exist\n";
    private static final String CONSOLE_DATA_ENTRY_MESSAGE = "\n1. Console data entry\n";
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
    private LoopsAndBranchingServer server;
    private LoopsAndBranchingMainViewReader reader;

    public LoopsAndBranchingMainView() {
        server = new LoopsAndBranchingServer();
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
                    + THE_FIFTH_TASK_INFORMATION);
            int commandNumber = reader.readCommandNumber();

            if (commandNumber > 5 || commandNumber < 0) {
                System.out.println(NO_SUCH_TASK_MESSAGE);
                request.putParameter(LoopsAndBranchingConstant.COMMAND_NUMBER, getViewCommandNumber());
            } else {
                request.putParameter(LoopsAndBranchingConstant.COMMAND_NUMBER, commandNumber);
            }

        }
        server.handleRequest(request);
    }

    @Override
    public int getViewCommandNumber() {
        return 6;
    }
}


