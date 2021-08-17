package by.lashkevich.arrays.view.impl;

import by.lashkevich.arrays.constant.ArraysConstant;
import by.lashkevich.arrays.controller.ArraysRequest;
import by.lashkevich.arrays.arraysutill.creator.ArraysDataCreator;
import by.lashkevich.arrays.arraysutill.creator.ArraysDataCreatorFactory;
import by.lashkevich.arrays.exception.ArraysDataCreatorException;
import by.lashkevich.arrays.exception.RequestTypeException;

import java.util.Arrays;

public enum MatrixRequestType {
    MATRIX_MULTIPLICATION_REQUEST(1) {
        @Override
        ArraysRequest createRequest() throws RequestTypeException {
            try {
                ArraysRequest request = new ArraysRequest();
                ArraysDataCreator creator = ArraysDataCreatorFactory.getInstance().createDataCreator();
                int multiplicationCommandNumber = -2;
                request.putParameter(ArraysConstant.COMMAND_NUMBER, multiplicationCommandNumber);
                request.putParameter(ArraysConstant.DATA_NAME,
                        Arrays.asList(creator.createSquareMatrix(), creator.createSquareMatrix()));
                return request;
            } catch (ArraysDataCreatorException e) {
                throw new RequestTypeException(e.getMessage());
            }
        }
    },
    MATRIX_ADDITION_REQUEST(2) {
        @Override
        ArraysRequest createRequest() throws RequestTypeException {
            try {
                ArraysRequest request = new ArraysRequest();
                ArraysDataCreator creator = ArraysDataCreatorFactory.getInstance().createDataCreator();
                int additionCommandNumber = -3;
                request.putParameter(ArraysConstant.COMMAND_NUMBER, additionCommandNumber);
                request.putParameter(ArraysConstant.DATA_NAME,
                        Arrays.asList(creator.createRectangularMatrix(), creator.createRectangularMatrix()));
                return request;
            } catch (ArraysDataCreatorException e) {
                throw new RequestTypeException(e.getMessage());
            }
        }
    },
    MATRIX_SUBTRACTION_REQUEST(3) {
        @Override
        ArraysRequest createRequest() throws RequestTypeException {
            try {
                ArraysRequest request = new ArraysRequest();
                ArraysDataCreator creator = ArraysDataCreatorFactory.getInstance().createDataCreator();
                int subtractionCommandNumber = -4;
                request.putParameter(ArraysConstant.COMMAND_NUMBER, subtractionCommandNumber);
                request.putParameter(ArraysConstant.DATA_NAME,
                        Arrays.asList(creator.createRectangularMatrix(), creator.createRectangularMatrix()));
                return request;
            } catch (ArraysDataCreatorException e) {
                throw new RequestTypeException(e.getMessage());
            }
        }
    },
    MATRIX_TRANSPOSE_REQUEST(4) {
        @Override
        ArraysRequest createRequest() throws RequestTypeException {
            try {
                ArraysRequest request = new ArraysRequest();
                ArraysDataCreator creator = ArraysDataCreatorFactory.getInstance().createDataCreator();
                int transposeCommandNumber = -5;
                request.putParameter(ArraysConstant.COMMAND_NUMBER, transposeCommandNumber);
                request.putParameter(ArraysConstant.DATA_NAME, creator.createRectangularMatrix());
                return request;
            } catch (ArraysDataCreatorException e) {
                throw new RequestTypeException(e.getMessage());
            }
        }
    };

    private static final String INVALID_OPERATION_WAS_CHOSEN_ERROR_MESSAGE = "Invalid operation was chosen";
    private final int requestNumber;

    MatrixRequestType(int requestNumber) {
        this.requestNumber = requestNumber;
    }

    abstract ArraysRequest createRequest() throws RequestTypeException;

    public int getRequestNumber() {
        return requestNumber;
    }

    public static MatrixRequestType findRequestType(int number) throws RequestTypeException {
        return Arrays.stream(MatrixRequestType.values())
                .filter(requestTypeNumber -> number == requestTypeNumber.getRequestNumber())
                .findAny()
                .orElseThrow(() -> new RequestTypeException(INVALID_OPERATION_WAS_CHOSEN_ERROR_MESSAGE));
    }
}
