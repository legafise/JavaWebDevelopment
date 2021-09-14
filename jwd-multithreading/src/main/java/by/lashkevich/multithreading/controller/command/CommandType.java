package by.lashkevich.multithreading.controller.command;

import by.lashkevich.multithreading.controller.command.impl.*;

import java.util.Arrays;

public enum CommandType {
    FILL_MATRIX_DIAGONAL_WITH_SET_COMMAND_NUMBER(new FillMatrixDiagonalWithSetCommand(), -6),
    FILL_MATRIX_DIAGONAL_WITH_BOOLEAN_VARIABLE_COMMAND_NUMBER(new FillMatrixDiagonalWithBooleanVariableCommand(),
            -5),
    FILL_MATRIX_DIAGONAL_WITH_SEMAPHORE_COMMAND_NUMBER(new FillMatrixDiagonalWithSemaphoreCommand(), -4),
    FILL_MATRIX_DIAGONAL_WITH_QUEUE_COMMAND_NUMBER(new FillMatrixDiagonalWithQueueCommand(), -3),
    FILL_MATRIX_DIAGONAL_WITH_LOCKER_COMMAND_NUMBER(new FillMatrixDiagonalWithLockerCommand(), -2),
    MAIN_FORWARD(new MainForwardCommand(), -1),
    MENU_EXIT(new MenuExitCommand(), 0),
    CHOOSE_LOCALE(new ChooseLocaleCommand(), 1),
    MATRIX_VIEW_FORWARD(new MatrixViewForwardCommand(), 2);

    private static final String INVALID_COMMAND_WAS_CHOSEN_ERROR_MESSAGE = "Invalid command was chosen";
    private final Command command;
    private final int commandNumber;

    CommandType(Command command, int commandNumber) {
        this.command = command;
        this.commandNumber = commandNumber;
    }

    public int getCommandNumber() {
        return commandNumber;
    }

    public Command getCommand() {
        return command;
    }

    public static Command findCommand(int number) throws CommandException {
        return Arrays.stream(CommandType.values())
                .filter(commandType -> number == commandType.getCommandNumber())
                .map(CommandType::getCommand)
                .findAny()
                .orElseThrow(() -> new CommandException(INVALID_COMMAND_WAS_CHOSEN_ERROR_MESSAGE));
    }
}
