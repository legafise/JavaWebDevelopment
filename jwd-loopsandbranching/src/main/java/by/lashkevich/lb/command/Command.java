package by.lashkevich.lb.command;

import by.lashkevich.lb.controller.Request;
import by.lashkevich.lb.exception.LoopsAndBranchingCommandException;
import by.lashkevich.lb.view.View;

/**
 * Command pattern main interface
 * @author Roman Lanskevich
 */
public interface Command {
    /**
     * Executing a command called by the controller
     * @param request with data about task
     * @return view to continue the program
     * @throws LoopsAndBranchingCommandException
     * @see by.lashkevich.lb.controller.Request
     */
    View execute(Request request) throws LoopsAndBranchingCommandException;
}
