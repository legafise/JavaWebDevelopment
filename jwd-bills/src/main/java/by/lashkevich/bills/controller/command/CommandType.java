package by.lashkevich.bills.controller.command;

import by.lashkevich.bills.controller.command.impl.*;

import java.util.Arrays;

public enum CommandType {
    MAIN_FORWARD(new MainForwardCommand(), -1),
    MENU_EXIT(new MenuExitCommand(), 0),
    CHOOSE_LOCALE(new ChooseLocaleCommand(), 1);

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
