package by.lashkevich.figures.controller.command;

import by.lashkevich.figures.controller.request.Request;
import by.lashkevich.figures.view.View;

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
     * @see by.lashkevich.figures.controller.request.Request
     * @see by.lashkevich.figures.view.View
     */
    View execute(Request request) throws CommandException;
}
