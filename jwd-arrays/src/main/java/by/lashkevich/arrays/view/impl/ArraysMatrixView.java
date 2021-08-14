package by.lashkevich.arrays.view.impl;

import by.lashkevich.arrays.arraysutill.reader.ArraysPropertiesReader;
import by.lashkevich.arrays.arraysutill.reader.ArraysViewConsoleReader;
import by.lashkevich.arrays.constant.ArraysConstant;
import by.lashkevich.arrays.controller.ArraysController;
import by.lashkevich.arrays.controller.ArraysRequest;
import by.lashkevich.arrays.exception.RequestTypeException;
import by.lashkevich.arrays.view.View;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ArraysMatrixView implements View {
    private static final Logger LOGGER = LogManager.getRootLogger();
    private static final String MATRIX_OPERATIONS_INFO_KEY = "view.matrix.operation.info.message";
    private final ArraysViewConsoleReader consoleReader;
    private final ArraysPropertiesReader propertiesReader;

    public ArraysMatrixView() {
        consoleReader = new ArraysViewConsoleReader();
        propertiesReader = ArraysPropertiesReader.getInstance();
    }

    @Override
    public void executeView() {
        ArraysRequest request = new ArraysRequest();

        try {
            System.out.println(propertiesReader.readMessageFromBundle(MATRIX_OPERATIONS_INFO_KEY));
            request = MatrixRequestType
                    .findRequestType(consoleReader.readRequestNumber()).createRequest();
            ArraysController.getInstance().doRequest(request).executeView();
        } catch (RequestTypeException e) {
            LOGGER.log(Level.ERROR, e.getMessage());
            int matrixViewNumber = 1;
            request.putParameter(ArraysConstant.COMMAND_NUMBER, matrixViewNumber);
            ArraysController.getInstance().doRequest(request).executeView();
        }
    }
}
