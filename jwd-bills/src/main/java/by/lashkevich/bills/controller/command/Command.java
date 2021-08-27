package by.lashkevich.bills.controller.command;

import by.lashkevich.bills.controller.request.Request;
import by.lashkevich.bills.service.ServiceException;
import by.lashkevich.bills.view.View;

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
     * @see by.lashkevich.bills.controller.request.Request
     * @see by.lashkevich.bills.view.View
     */
    View execute(Request request) throws CommandException;
}
