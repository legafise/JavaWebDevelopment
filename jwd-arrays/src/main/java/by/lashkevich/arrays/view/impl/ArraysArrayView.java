package by.lashkevich.arrays.view.impl;

import by.lashkevich.arrays.arraysutill.reader.ArraysPropertiesReader;
import by.lashkevich.arrays.arraysutill.reader.ArraysViewConsoleReader;
import by.lashkevich.arrays.constant.ArraysConstant;
import by.lashkevich.arrays.controller.ArraysController;
import by.lashkevich.arrays.controller.ArraysRequest;
import by.lashkevich.arrays.exception.RequestTypeException;
import by.lashkevich.arrays.view.View;
import by.lashkevich.arrays.view.ViewEntryTypeChooser;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ArraysArrayView implements View {
    private static final Logger LOGGER = LogManager.getRootLogger();
    private static final String ARRAY_OPERATIONS_INFO_KEY = "view.array.operation.info.message";
    private static final int ARRAY_VIEW_NUMBER = 2;
    private final ArraysViewConsoleReader consoleReader;
    private final ArraysPropertiesReader propertiesReader;

    public ArraysArrayView() {
        consoleReader = new ArraysViewConsoleReader();
        propertiesReader = ArraysPropertiesReader.getInstance();
    }

    @Override
    public void executeView() {
        ArraysRequest request = new ArraysRequest();

        try {
            System.out.println(propertiesReader.readMessageFromBundle(ARRAY_OPERATIONS_INFO_KEY));
            int requestNumber = consoleReader.readRequestNumber();
            request = ArrayRequestType
                    .findRequestType(requestNumber)
                    .createRequest(ViewEntryTypeChooser.chooseEntryType(ARRAY_VIEW_NUMBER));
            ArraysController.getInstance().doRequest(request).executeView();
        } catch (RequestTypeException e) {
            LOGGER.log(Level.ERROR, e.getMessage());
            request.putParameter(ArraysConstant.COMMAND_NUMBER, ARRAY_VIEW_NUMBER);
            ArraysController.getInstance().doRequest(request).executeView();
        }
    }
}
