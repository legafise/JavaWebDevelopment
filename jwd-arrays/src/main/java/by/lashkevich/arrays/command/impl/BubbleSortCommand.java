package by.lashkevich.arrays.command.impl;

import by.lashkevich.arrays.arraysutill.reporter.ArraysArrayReporter;
import by.lashkevich.arrays.command.Command;
import by.lashkevich.arrays.constant.ArraysConstant;
import by.lashkevich.arrays.controller.ArraysRequest;
import by.lashkevich.arrays.entity.ArraysArray;
import by.lashkevich.arrays.exception.ArraysCommandException;
import by.lashkevich.arrays.exception.ArraysServiceException;
import by.lashkevich.arrays.service.ArrayService;
import by.lashkevich.arrays.service.impl.ArraysArrayService;
import by.lashkevich.arrays.view.View;
import by.lashkevich.arrays.view.impl.ViewType;

public class BubbleSortCommand implements Command {
    private ArrayService arrayService;

    public BubbleSortCommand() {
        arrayService = new ArraysArrayService();
    }

    @Override
    public View execute(ArraysRequest request) throws ArraysCommandException {
        try {
            ArraysArray array = (ArraysArray) request.getParameter(ArraysConstant.DATA_NAME);
            ArraysArrayReporter.reportReceivedArrayInfo(array);
            ArraysArray sortedArray = arrayService.bubbleSort(array);
            ArraysArrayReporter.reportBubbleSortResult(sortedArray);
            return ViewType.MAIN_VIEW.getView();
        } catch (ArraysServiceException e) {
            throw new ArraysCommandException(e.getMessage());
        }
    }
}
