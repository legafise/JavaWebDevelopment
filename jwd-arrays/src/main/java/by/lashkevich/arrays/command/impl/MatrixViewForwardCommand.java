package by.lashkevich.arrays.command.impl;

import by.lashkevich.arrays.command.Command;
import by.lashkevich.arrays.controller.ArraysRequest;
import by.lashkevich.arrays.view.View;
import by.lashkevich.arrays.view.impl.ViewType;

public class MatrixViewForwardCommand implements Command {
    @Override
    public View execute(ArraysRequest request) {
        return ViewType.MATRIX_VIEW.getView();
    }
}
