package by.lashkevich.arrays.command.impl;

import by.lashkevich.arrays.command.Command;
import by.lashkevich.arrays.controller.ArraysRequest;
import by.lashkevich.arrays.view.View;
import by.lashkevich.arrays.view.impl.ViewType;

/**
 * @author Roman Lashkevich
 * @see by.lashkevich.arrays.command.Command
 */
public class MainForwardCommand implements Command {
    @Override
    public View execute(ArraysRequest request) {
        return ViewType.MAIN_VIEW.getView();
    }
}
