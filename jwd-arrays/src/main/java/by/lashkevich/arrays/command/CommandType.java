package by.lashkevich.arrays.command;

import by.lashkevich.arrays.command.impl.*;
import by.lashkevich.arrays.exception.ArraysCommandException;

import java.util.Arrays;

public enum CommandType {
    COCKTAIL_SORT(new BubbleSortCommand(), -7),
    BUBBLE_SORT(new BubbleSortCommand(), -6),
    MATRIX_TRANSPOSE(new MatrixTransposeCommand(), -5),
    MATRIX_SUBTRACTION(new MatrixSubtractionCommand(), -4),
    MATRIX_ADDITION(new MatrixAdditionCommand(), -3),
    MATRIX_MULTIPLICATION(new MatrixMultiplicationCommand(), -2),
    MAIN_FORWARD(new MainForwardCommand(), -1),
    MENU_EXIT(new MenuExitCommand(), 0),
    MATRIX_VIEW_FORWARD(new MatrixViewForwardCommand(), 1),
    ARRAY_VIEW_FORWARD(new ArrayViewForwardCommand(), 2);

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

    public static Command findCommand(int number) throws ArraysCommandException {
        return Arrays.stream(CommandType.values())
                .filter(commandType -> number == commandType.getCommandNumber())
                .map(CommandType::getCommand)
                .findAny()
                .orElseThrow(() -> new ArraysCommandException(INVALID_COMMAND_WAS_CHOSEN_ERROR_MESSAGE));
    }
}
