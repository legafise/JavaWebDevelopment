package by.lashkevich.arrays.view.impl;

import by.lashkevich.arrays.arraysutill.reader.ArraysFileDataReader;
import by.lashkevich.arrays.constant.ArraysConstant;
import by.lashkevich.arrays.controller.ArraysRequest;
import by.lashkevich.arrays.exception.ArraysDataCreatorException;
import by.lashkevich.arrays.exception.RequestTypeException;

import java.util.Arrays;
import java.util.List;

/**
 * Enum for fast request creating
 * @author Roman Lashkevich
 * @see by.lashkevich.arrays.controller.ArraysRequest
 */
public enum MatrixRequestType {
    MATRIX_MULTIPLICATION_REQUEST(1) {
        @Override
        ArraysRequest createRequest(int entryNumber) throws RequestTypeException {
            try {
                ArraysFileDataReader dataReader = new ArraysFileDataReader();
                List<String> matrixData = dataReader.readSquareMatrixData();
                return MatrixRequestType.collectRequest(entryNumber, RANDOM_MATRIX_MULTIPLICATION_COMMAND_NUMBER,
                        FILE_MATRIX_MULTIPLICATION_COMMAND_NUMBER, matrixData);
            } catch (ArraysDataCreatorException e) {
                throw new RequestTypeException(e.getMessage());
            }
        }
    },
    MATRIX_ADDITION_REQUEST(2) {
        @Override
        ArraysRequest createRequest(int entryNumber) throws RequestTypeException {
            try {
                ArraysFileDataReader dataReader = new ArraysFileDataReader();
                List<String> matrixData = dataReader.readRectangularMatrixData();
                return MatrixRequestType.collectRequest(entryNumber, RANDOM_MATRIX_ADDITION_COMMAND_NUMBER,
                        FILE_MATRIX_ADDITION_COMMAND_NUMBER, matrixData);
            } catch (ArraysDataCreatorException e) {
                throw new RequestTypeException(e.getMessage());
            }
        }
    },
    MATRIX_SUBTRACTION_REQUEST(3) {
        @Override
        ArraysRequest createRequest(int entryNumber) throws RequestTypeException {
            try {
                ArraysFileDataReader dataReader = new ArraysFileDataReader();
                List<String> matrixData = dataReader.readRectangularMatrixData();
                return MatrixRequestType.collectRequest(entryNumber, RANDOM_MATRIX_SUBTRACTION_COMMAND_NUMBER,
                        FILE_MATRIX_SUBTRACTION_COMMAND_NUMBER, matrixData);
            } catch (ArraysDataCreatorException e) {
                throw new RequestTypeException(e.getMessage());
            }
        }
    },
    MATRIX_TRANSPOSE_REQUEST(4) {
        @Override
        ArraysRequest createRequest(int entryNumber) throws RequestTypeException {
            try {
                ArraysFileDataReader dataReader = new ArraysFileDataReader();
                List<String> matrixData = dataReader.readSquareMatrixData();
                return MatrixRequestType.collectRequest(entryNumber, RANDOM_MATRIX_TRANSPOSE_COMMAND_NUMBER,
                        FILE_MATRIX_TRANSPOSE_COMMAND_NUMBER, matrixData);
            } catch (ArraysDataCreatorException e) {
                throw new RequestTypeException(e.getMessage());
            }
        }
    };

    private static final String INVALID_OPERATION_WAS_CHOSEN_ERROR_MESSAGE = "Invalid operation was chosen";
    private static final int RANDOM_MATRIX_TRANSPOSE_COMMAND_NUMBER = -5;
    private static final int FILE_MATRIX_TRANSPOSE_COMMAND_NUMBER = -15;
    private static final int RANDOM_MATRIX_MULTIPLICATION_COMMAND_NUMBER = -2;
    private static final int FILE_MATRIX_MULTIPLICATION_COMMAND_NUMBER = -12;
    private static final int RANDOM_MATRIX_ADDITION_COMMAND_NUMBER = -3;
    private static final int FILE_MATRIX_ADDITION_COMMAND_NUMBER = -13;
    private static final int RANDOM_MATRIX_SUBTRACTION_COMMAND_NUMBER = -4;
    private static final int FILE_MATRIX_SUBTRACTION_COMMAND_NUMBER = -14;
    private final int requestNumber;

    MatrixRequestType(int requestNumber) {
        this.requestNumber = requestNumber;
    }

    abstract ArraysRequest createRequest(int entryNumber) throws RequestTypeException;

    public int getRequestNumber() {
        return requestNumber;
    }

    public static MatrixRequestType findRequestType(int number) throws RequestTypeException {
        return Arrays.stream(MatrixRequestType.values())
                .filter(requestTypeNumber -> number == requestTypeNumber.getRequestNumber())
                .findAny()
                .orElseThrow(() -> new RequestTypeException(INVALID_OPERATION_WAS_CHOSEN_ERROR_MESSAGE));
    }

    private static ArraysRequest collectRequest(int entryNumber, int randomMatrixCommandNumber,
                                                int fileMatrixCommandNumber, List<String> matrixData) {
        return entryNumber == 1 ? MatrixRequestType
                .createRandomMatrixSortRequest(randomMatrixCommandNumber)
                : MatrixRequestType
                .createFileMatrixSortRequest(fileMatrixCommandNumber, matrixData);
    }

    private static ArraysRequest createRandomMatrixSortRequest(int matrixCommandNumber) {
        ArraysRequest request = new ArraysRequest();
        request.putParameter(ArraysConstant.COMMAND_NUMBER, matrixCommandNumber);
        return request;
    }

    private static ArraysRequest createFileMatrixSortRequest(int matrixCommandNumber, List<String> matrixData) {
        ArraysRequest request = new ArraysRequest();
        request.putParameter(ArraysConstant.DATA_NAME, matrixData);
        request.putParameter(ArraysConstant.COMMAND_NUMBER, matrixCommandNumber);
        return request;
    }
}
