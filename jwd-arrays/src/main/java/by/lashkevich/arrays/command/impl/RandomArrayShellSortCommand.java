package by.lashkevich.arrays.command.impl;

import by.lashkevich.arrays.arraysutill.creator.ArraysRandomDataCreator;
import by.lashkevich.arrays.arraysutill.reporter.ArraysArrayReporter;
import by.lashkevich.arrays.command.Command;
import by.lashkevich.arrays.controller.ArraysRequest;
import by.lashkevich.arrays.entity.ArraysArray;
import by.lashkevich.arrays.exception.ArraysCommandException;
import by.lashkevich.arrays.exception.ArraysServiceException;
import by.lashkevich.arrays.service.ArrayService;
import by.lashkevich.arrays.service.impl.ArraysArrayService;
import by.lashkevich.arrays.view.View;
import by.lashkevich.arrays.view.impl.ViewType;

public class RandomArrayShellSortCommand implements Command {
    private final ArrayService arrayService;
    private final ArraysRandomDataCreator arraysCreator;

    public RandomArrayShellSortCommand() {
        arrayService = new ArraysArrayService();
        arraysCreator = new ArraysRandomDataCreator();
    }

    @Override
    public View execute(ArraysRequest request) throws ArraysCommandException {
        try {
            ArraysArray<Number> array = arraysCreator.createArray();
            ArraysArrayReporter.reportReceivedRandomArrayInfo(array);
            ArraysArray<Number> sortedArray = arrayService.shellSort(array);
            ArraysArrayReporter.reportShellSortResult(sortedArray);
            return ViewType.MAIN_VIEW.getView();
        } catch (ArraysServiceException e) {
            throw new ArraysCommandException(e.getMessage());
        }
    }
}
