package by.lashkevich.jwd.command;

import by.lashkevich.jwd.exception.LinearProgramCommandTypeException;

import java.util.Arrays;

public enum CommandType {
    MENU_EXIT(new MenuExitCommand()),
    TRIANGLE_CALCULATOR(new TriangleCalculatorCommand());

    private static final String INVALID_COMMAND_WAS_CHOSEN_ERROR_MESSAGE = "Invalid command was chosen";
    private Command command;

    CommandType(Command command) {
        this.command = command;
    }

    public Command getCommand() {
        return command;
    }

    public static CommandType findCommand(int number) throws LinearProgramCommandTypeException {
        return Arrays.stream(CommandType.values())
                .filter(commandType -> number == commandType.ordinal()).findAny()
                .orElseThrow(() -> new LinearProgramCommandTypeException(INVALID_COMMAND_WAS_CHOSEN_ERROR_MESSAGE));
    }
}
