package by.lashkevich.jwd.controller;

import by.lashkevich.jwd.command.Command;
import by.lashkevich.jwd.command.CommandType;
import by.lashkevich.jwd.constant.LinearProgramConstant;
import by.lashkevich.jwd.exception.LinearProgramCommandException;
import by.lashkevich.jwd.exception.LinearProgramControllerException;
import by.lashkevich.jwd.view.impl.LinearProgramMainView;
import by.lashkevich.jwd.view.View;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LinearProgramController {
    private static final String NO_COMMAND_ERROR_MESSAGE = "There is't command number";
    private static final Logger LOGGER = LogManager.getRootLogger();

    public View doRequest(Request request) {
        try {
            Object commandNumber = request.getParameter(LinearProgramConstant.COMMAND_NUMBER);
            if (commandNumber == null) {
                throw new LinearProgramControllerException(NO_COMMAND_ERROR_MESSAGE);
            }

            Command command = CommandType.findCommand((int) commandNumber);
            return command.execute(request);
        } catch (LinearProgramCommandException | LinearProgramControllerException e) {
            LOGGER.log(Level.ERROR, e.getMessage());
            return new LinearProgramMainView();
        }
    }
}


