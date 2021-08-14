package by.lashkevich.arrays.controller;

import by.lashkevich.arrays.command.Command;
import by.lashkevich.arrays.command.CommandType;
import by.lashkevich.arrays.constant.ArraysConstant;
import by.lashkevich.arrays.exception.ArraysCommandException;
import by.lashkevich.arrays.exception.ArraysControllerException;
import by.lashkevich.arrays.view.View;
import by.lashkevich.arrays.view.impl.ViewType;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Class that handles requests from the view layer
 * @author Roman Lashkevich
 */
public final class ArraysController {
    private static final String NO_COMMAND_ERROR_MESSAGE = "There is't command number";
    private static final Logger LOGGER = LogManager.getRootLogger();
    private static ArraysController instance;

    private ArraysController() {
    }

    public static ArraysController getInstance() {
        if (instance == null) {
            instance = new ArraysController();
        }

        return instance;
    }

    /**
     * Request and exception handler
     * @param request
     * @return view for any task or menu
     * @see by.lashkevich.arrays.controller.ArraysRequest
     */
    public View doRequest(ArraysRequest request) {
        try {
            Object commandNumber = request.getParameter(ArraysConstant.COMMAND_NUMBER);
            if (commandNumber == null) {
                throw new ArraysControllerException(NO_COMMAND_ERROR_MESSAGE);
            }

            Command command = CommandType.findCommand((int) commandNumber);
            return command.execute(request);
        } catch (ArraysControllerException | ArraysCommandException e) {
            LOGGER.log(Level.ERROR, e.getMessage());
            return ViewType.MAIN_VIEW.getView();
        }
    }
}


