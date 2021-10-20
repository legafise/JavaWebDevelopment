package by.lashkevich.xml.controller.command;

import javax.servlet.http.HttpServletRequest;

public class CommandFactory {
    private static final String COMMAND_PARAMETER_NAME = "command";
    private static final CommandFactory INSTANCE = new CommandFactory();

    private CommandFactory() {
    }

    public static CommandFactory getInstance() {
        return INSTANCE;
    }

    public Command initCommand(HttpServletRequest request) throws CommandException {
        String command = request.getParameter(COMMAND_PARAMETER_NAME);
        return CommandType.findCommand(command);
    }
}
