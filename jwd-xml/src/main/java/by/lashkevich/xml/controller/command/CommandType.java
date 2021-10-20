package by.lashkevich.xml.controller.command;

import by.lashkevich.xml.controller.command.impl.BuilderCommand;
import by.lashkevich.xml.controller.command.impl.ErrorPageCommand;
import by.lashkevich.xml.controller.command.impl.MainPageCommand;
import by.lashkevich.xml.controller.command.impl.SaveFileCommand;

import java.util.Arrays;

public enum CommandType {
    MATRIX_VIEW_REDIRECT(new BuilderCommand(), "HANDLE_XML"),
    MAIN_PAGE_REDIRECT(new MainPageCommand(), "MAIN_PAGE"),
    ERROR_PAGE_REDIRECT(new ErrorPageCommand(), "ERROR"),
    SAVE_FILE(new SaveFileCommand(), "SAVE_FILE");

    private static final String UNKNOWN_COMMAND_ERROR_MESSAGE = "Unknown command: %s";
    private final Command command;
    private final String commandName;

    CommandType(Command command, String commandName) {
        this.command = command;
        this.commandName = commandName;
    }

    public String getCommandName() {
        return commandName;
    }

    public Command getCommand() {
        return command;
    }

    public static Command findCommand(String commandName) throws CommandException {
        return Arrays.stream(CommandType.values())
                .filter(commandType -> commandName.toUpperCase().equals(commandType.getCommandName()))
                .map(CommandType::getCommand)
                .findAny()
                .orElseThrow(() -> new CommandException(String.format(UNKNOWN_COMMAND_ERROR_MESSAGE, commandName)));
    }
}
