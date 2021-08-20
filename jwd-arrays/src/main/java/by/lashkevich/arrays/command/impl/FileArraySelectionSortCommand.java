package by.lashkevich.arrays.command.impl;

import by.lashkevich.arrays.arraysutill.parser.ArraysArrayParserFactory;
import by.lashkevich.arrays.arraysutill.reporter.ArraysArrayReporter;
import by.lashkevich.arrays.command.Command;
import by.lashkevich.arrays.constant.ArraysConstant;
import by.lashkevich.arrays.controller.ArraysRequest;
import by.lashkevich.arrays.entity.ArraysArray;
import by.lashkevich.arrays.exception.ArraysCommandException;
import by.lashkevich.arrays.exception.ArraysParserException;
import by.lashkevich.arrays.exception.ArraysServiceException;
import by.lashkevich.arrays.service.ArrayService;
import by.lashkevich.arrays.service.ArraysServiceFactory;
import by.lashkevich.arrays.service.impl.ArraysArrayService;
import by.lashkevich.arrays.view.View;
import by.lashkevich.arrays.view.impl.ViewType;

import java.util.List;

/**
 * @author Roman Lashkevich
 * @see by.lashkevich.arrays.command.Command
 */
public class FileArraySelectionSortCommand implements Command {
    private final ArrayService arrayService;

    public FileArraySelectionSortCommand() {
        arrayService = ArraysServiceFactory.getInstance().getArrayService();
    }

    @Override
    public View execute(ArraysRequest request) throws ArraysCommandException {
        try {
            List<String> arrayData = (List<String>) request.getParameter(ArraysConstant.DATA_NAME);
            ArraysArray<Number> array = ArraysArrayParserFactory.getInstance()
                    .createArrayParser().parseArray(arrayData);
            ArraysArrayReporter.reportReceivedFileArrayInfo(array, ArraysArrayParserFactory
                    .getInstance().createArrayParser().getType());
            ArraysArray<Number> sortedArray = arrayService.selectionSort(array);
            ArraysArrayReporter.reportSelectionSortResult(sortedArray);
            return ViewType.MAIN_VIEW.getView();
        } catch (ArraysServiceException | ArraysParserException e) {
            throw new ArraysCommandException(e.getMessage());
        }
    }
}
