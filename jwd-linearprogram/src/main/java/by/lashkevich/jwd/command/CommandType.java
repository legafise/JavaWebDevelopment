package by.lashkevich.jwd.command;

import by.lashkevich.jwd.command.impl.*;
import by.lashkevich.jwd.exception.LinearProgramCommandException;

import java.util.Arrays;

public enum CommandType {
    MENU_EXIT(new MenuExitCommand(), 0),
    TRIANGLE_CALCULATOR_FORWARD(new TriangleCalculatorForwardCommand(), 1),
    RING_CALCULATOR_FORWARD(new RingCalculatorForwardCommand(), 2),
    SYMBOL_NUMBERS_FORWARD(new SymbolNumbersFinderForwardCommand(), 3),
    SQUARE_ROOT_FORMULA_CALCULATOR_FORWARD(new FormulaCalculatorForwardCommand(), 4),
    POINT_CHECKER_FORWARD(new PointCheckerForwardCommand(), 5),
    MAIN_FORWARD(new MainForwardCommand(), 6),
    TRIANGLE_CALCULATOR(new TriangleCalculatorCommand(), 7),
    RING_CALCULATOR(new RingCalculatorCommand(), 8),
    SYMBOL_NUMBERS_FINDER(new SymbolNumbersFinderCommand(),9),
    SQUARE_ROOT_FORMULA_CALCULATOR(new FormulaCalculatorCommand(), 10),
    POINT_CHECKER(new PointCheckerCommand(),11);

    private static final String INVALID_COMMAND_WAS_CHOSEN_ERROR_MESSAGE = "Invalid command was chosen";
    private Command command;
    private int commandNumber;

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

    public static Command findCommand(int number) throws LinearProgramCommandException {
        return Arrays.stream(CommandType.values())
                .filter(commandType -> number == commandType.getCommandNumber())
                .map(CommandType::getCommand)
                .findAny()
                .orElseThrow(() -> new LinearProgramCommandException(INVALID_COMMAND_WAS_CHOSEN_ERROR_MESSAGE));
    }
}
