package by.lashkevich.lb.command;

import by.lashkevich.lb.exception.LoopsAndBranchingCommandException;
import by.lashkevich.lb.command.impl.*;

import java.util.Arrays;

public enum CommandType {
    POINT_DISTANCE_FROM_ORIGIN_CHECKER(new PointDistanceFromOriginCheckerCommand(), -10),
    LEAST_SQUARE_FINDER(new LeastSquareFinderCommand(),-9),
    DATE_VALIDATOR(new DateValidatorCommand(),-8),
    TWO_CONDITION_FUNCTION_CALCULATOR(new TwoConditionFunctionCalculatorCommand(),-7),
    POINT_CHECKER(new PointOnAreaCommand(),-6),
    SQUARE_ROOT_FORMULA_CALCULATOR(new SquareRootFormulaCalculatorCommand(), -5),
    SYMBOL_NUMBERS_FINDER(new SymbolNumbersFinderCommand(),-4),
    RING_CALCULATOR(new RingCalculatorCommand(), -3),
    TRIANGLE_CALCULATOR(new TriangleCalculatorCommand(), -2),
    MAIN_FORWARD(new MainForwardCommand(), -1),
    MENU_EXIT(new MenuExitCommand(), 0),
    TRIANGLE_CALCULATOR_FORWARD(new TriangleCalculatorForwardCommand(), 1),
    RING_CALCULATOR_FORWARD(new RingCalculatorForwardCommand(), 2),
    SYMBOL_NUMBERS_FORWARD(new SymbolNumbersFinderForwardCommand(), 3),
    SQUARE_ROOT_FORMULA_CALCULATOR_FORWARD(new SquareRootFormulaCalculatorForwardCommand(), 4),
    POINT_CHECKER_FORWARD(new PointOnAreaForwardCommand(), 5),
    TWO_CONDITION_FUNCTION_FORWARD(new TwoConditionFunctionForwardCommand(), 6),
    DATE_VALIDATOR_FORWARD(new DateValidatorForwardCommand(), 7),
    LEAST_SQUARE_FINDER_FORWARD(new LeastSquareFinderForwardCommand(), 8),
    POINT_DISTANCE_FROM_ORIGIN_FORWARD(new PointDistanceFromOriginForwardCommand(), 9);

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

    public static Command findCommand(int number) throws LoopsAndBranchingCommandException {
        return Arrays.stream(CommandType.values())
                .filter(commandType -> number == commandType.getCommandNumber())
                .map(CommandType::getCommand)
                .findAny()
                .orElseThrow(() -> new LoopsAndBranchingCommandException(INVALID_COMMAND_WAS_CHOSEN_ERROR_MESSAGE));
    }
}
