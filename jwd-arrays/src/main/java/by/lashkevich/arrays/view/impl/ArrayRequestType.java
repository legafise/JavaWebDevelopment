package by.lashkevich.arrays.view.impl;

import by.lashkevich.arrays.constant.ArraysConstant;
import by.lashkevich.arrays.controller.ArraysRequest;
import by.lashkevich.arrays.arraysutill.creator.ArraysDataCreator;
import by.lashkevich.arrays.arraysutill.creator.ArraysDataCreatorFactory;
import by.lashkevich.arrays.exception.ArraysDataCreatorException;
import by.lashkevich.arrays.exception.RequestTypeException;

import java.util.Arrays;

public enum ArrayRequestType {
    BUBBLE_SORT_REQUEST(1) {
        @Override
        ArraysRequest createRequest() throws RequestTypeException {
            return ArrayRequestType.createArraySortRequest(BUBBLE_SORT_COMMAND_NUMBER);
        }
    },
    COCKTAIL_SORT_REQUEST(2) {
        @Override
        ArraysRequest createRequest() throws RequestTypeException {
            return ArrayRequestType.createArraySortRequest(COCKTAIL_SORT_COMMAND_NUMBER);
        }
    };


    private static final String INVALID_OPERATION_WAS_CHOSEN_ERROR_MESSAGE = "Invalid operation was chosen";
    private static final int BUBBLE_SORT_COMMAND_NUMBER = -6;
    private static final int COCKTAIL_SORT_COMMAND_NUMBER = -7;
    private final int requestNumber;

    ArrayRequestType(int requestNumber) {
        this.requestNumber = requestNumber;
    }

    public int getRequestNumber() {
        return requestNumber;
    }

    abstract ArraysRequest createRequest() throws RequestTypeException;

    public static ArrayRequestType findRequestType(int number) throws RequestTypeException {
        return Arrays.stream(ArrayRequestType.values())
                .filter(requestTypeNumber -> number == requestTypeNumber.getRequestNumber())
                .findAny()
                .orElseThrow(() -> new RequestTypeException(INVALID_OPERATION_WAS_CHOSEN_ERROR_MESSAGE));
    }

    private static ArraysRequest createArraySortRequest(int sortCommandNumber) throws RequestTypeException {
        try {
            ArraysRequest request = new ArraysRequest();
            ArraysDataCreator dataCreator = ArraysDataCreatorFactory.getInstance().createDataCreator();
            request.putParameter(ArraysConstant.DATA_NAME, dataCreator.createArray());
            request.putParameter(ArraysConstant.COMMAND_NUMBER, sortCommandNumber);
            return request;
        } catch (ArraysDataCreatorException e) {
            throw new RequestTypeException(e.getMessage());
        }
    }
}
