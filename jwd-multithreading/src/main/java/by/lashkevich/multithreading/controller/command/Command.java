package by.lashkevich.multithreading.controller.command;

import by.lashkevich.multithreading.controller.request.Request;
import by.lashkevich.multithreading.view.View;

/**
 * Command pattern main interface
 *
 * @author Roman Lanskevich
 */
public interface Command {
    /**
     * Executing a command called by the controller
     *
     * @param request with data
     * @return view to continue the program
     * @throws CommandException
     * @see Request
     * @see View
     */
    View execute(Request request) throws CommandException;
}
