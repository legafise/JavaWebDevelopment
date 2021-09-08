package by.lashkevich.multithreading.controller;

import by.lashkevich.multithreading.controller.command.Command;
import by.lashkevich.multithreading.controller.command.CommandException;
import by.lashkevich.multithreading.controller.command.CommandType;
import by.lashkevich.multithreading.controller.request.Request;
import by.lashkevich.multithreading.controller.request.RequestConstant;
import by.lashkevich.multithreading.view.View;
import by.lashkevich.multithreading.view.impl.ViewType;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Class that handles requests from the view layer
 * @author Roman Lashkevich
 */
public final class Controller {
    private static final String NO_COMMAND_ERROR_MESSAGE = "There is't command number";
    private static final Logger LOGGER = LogManager.getRootLogger();
    private static Controller instance;

    private Controller() {
    }

    public static Controller getInstance() {
        if (instance == null) {
            instance = new Controller();
        }

        return instance;
    }

    /**
     * Request and exception handler
     * @param request
     * @return view for any task or menu
     * @see Request
     */
    public View doRequest(Request request) {
        try {
            Object commandNumber = request.getParameter(RequestConstant.COMMAND_NUMBER);
            if (commandNumber == null) {
                throw new ControllerException(NO_COMMAND_ERROR_MESSAGE);
            }

            Command command = CommandType.findCommand((int) commandNumber);
            return command.execute(request);
        } catch (CommandException | ControllerException e) {
            LOGGER.log(Level.ERROR, e.getMessage());
            return ViewType.MAIN_VIEW.getView();
        }
    }
}


