package by.lashkevich.arrays.command;

import by.lashkevich.arrays.controller.ArraysRequest;
import by.lashkevich.arrays.exception.ArraysCommandException;
import by.lashkevich.arrays.view.View;

public interface Command {
    View execute(ArraysRequest request) throws ArraysCommandException;
}
