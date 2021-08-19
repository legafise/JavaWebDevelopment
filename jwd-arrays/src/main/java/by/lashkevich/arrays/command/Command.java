package by.lashkevich.arrays.command;

import by.lashkevich.arrays.controller.ArraysRequest;
import by.lashkevich.arrays.exception.ArraysCommandException;
import by.lashkevich.arrays.view.View;
/**
 * Command pattern main interface
 * @author Roman Lanskevich
 */
public interface Command {
    /**
     * Executing a command called by the controller
     * @param request with data
     * @return view to continue the program
     * @throws ArraysCommandException
     * @see by.lashkevich.arrays.controller.ArraysRequest
     */
    View execute(ArraysRequest request) throws ArraysCommandException;
}
