package by.lashkevich.arrays.command;

import by.lashkevich.arrays.command.impl.*;
import by.lashkevich.arrays.exception.ArraysCommandException;

import java.util.Arrays;

public enum CommandType {
    FILE_MATRIX_TRANSPOSE(new FileMatrixTransposeCommand(), -15),
    FILE_MATRIX_SUBTRACTION(new FileMatrixSubtractionCommand(), -14),
    FILE_MATRIX_ADDITION(new FileMatrixAdditionCommand(), -13),
    FILE_MATRIX_MULTIPLICATION(new FileMatrixMultiplicationCommand(), -12),
    FILE_ARRAY_SELECTION_SORT(new FileArraySelectionSortCommand(), -11),
    FILE_ARRAY_COCKTAIL_SORT(new FileArrayCocktailSortCommand(), -10),
    FILE_ARRAY_BUBBLE_SORT(new FileArrayBubbleSortCommand(), -9),
    RANDOM_ARRAY_SELECTION_SORT(new RandomArraySelectionSortCommand(), -8),
    RANDOM_ARRAY_COCKTAIL_SORT(new RandomArrayCocktailSortCommand(), -7),
    RANDOM_ARRAY_BUBBLE_SORT(new RandomArrayBubbleSortCommand(), -6),
    RANDOM_MATRIX_TRANSPOSE(new RandomMatrixTransposeCommand(), -5),
    RANDOM_MATRIX_SUBTRACTION(new RandomMatrixSubtractionCommand(), -4),
    RANDOM_MATRIX_ADDITION(new RandomMatrixAdditionCommand(), -3),
    RANDOM_MATRIX_MULTIPLICATION(new RandomMatrixMultiplicationCommand(), -2),
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
