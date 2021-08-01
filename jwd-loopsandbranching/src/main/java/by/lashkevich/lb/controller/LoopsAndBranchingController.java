package by.lashkevich.lb.controller;

import by.lashkevich.lb.command.Command;
import by.lashkevich.lb.command.CommandType;
import by.lashkevich.lb.constant.LoopsAndBranchingConstant;
import by.lashkevich.lb.exception.LoopsAndBranchingCommandException;
import by.lashkevich.lb.exception.LoopsAndBranchingControllerException;
import by.lashkevich.lb.view.impl.LoopsAndBranchingMainView;
import by.lashkevich.lb.view.View;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LoopsAndBranchingController {
    private static final String NO_COMMAND_ERROR_MESSAGE = "There is't command number";
    private static final Logger LOGGER = LogManager.getRootLogger();

    public View doRequest(Request request) {
        try {
            Object commandNumber = request.getParameter(LoopsAndBranchingConstant.COMMAND_NUMBER);
            if (commandNumber == null) {
                throw new LoopsAndBranchingControllerException(NO_COMMAND_ERROR_MESSAGE);
            }

            Command command = CommandType.findCommand((int) commandNumber);
            return command.execute(request);
        } catch (LoopsAndBranchingCommandException | LoopsAndBranchingControllerException e) {
            LOGGER.log(Level.ERROR, e.getMessage());
            return new LoopsAndBranchingMainView();
        }
    }
}


