package by.lashkevich.arrays.view.impl;

import by.lashkevich.arrays.arraysutill.parser.ArraysArrayParserFactory;
import by.lashkevich.arrays.arraysutill.reader.ArraysFileDataReader;
import by.lashkevich.arrays.arraysutill.reader.ArraysPropertiesReader;
import by.lashkevich.arrays.arraysutill.reader.ArraysViewConsoleReader;
import by.lashkevich.arrays.constant.ArraysConstant;
import by.lashkevich.arrays.controller.ArraysRequest;
import by.lashkevich.arrays.exception.ArraysDataCreatorException;
import by.lashkevich.arrays.exception.RequestTypeException;

import java.util.Arrays;

public enum ArrayRequestType {
    BUBBLE_SORT_REQUEST(1) {
        @Override
        ArraysRequest createRequest(int entryNumber) throws RequestTypeException {
            return entryNumber == 1 ? ArrayRequestType
                    .createRandomArraySortRequest(RANDOM_ARRAY_BUBBLE_SORT_COMMAND_NUMBER)
                    : ArrayRequestType.createFileArraySortRequest(FILE_ARRAY_BUBBLE_SORT_COMMAND_NUMBER);
        }
    },
    COCKTAIL_SORT_REQUEST(2) {
        @Override
        ArraysRequest createRequest(int entryNumber) throws RequestTypeException {
            return entryNumber == 1 ? ArrayRequestType
                    .createRandomArraySortRequest(RANDOM_ARRAY_COCKTAIL_SORT_COMMAND_NUMBER)
                    : ArrayRequestType.createFileArraySortRequest(FILE_ARRAY_COCKTAIL_SORT_COMMAND_NUMBER);
        }
    },
    SELECTION_SORT_REQUEST(3) {
        @Override
        ArraysRequest createRequest(int entryNumber) throws RequestTypeException {
            return entryNumber == 1 ? ArrayRequestType
                    .createRandomArraySortRequest(RANDOM_ARRAY_SELECTION_SORT_COMMAND_NUMBER)
                    : ArrayRequestType.createFileArraySortRequest(FILE_ARRAY_SELECTION_SORT_COMMAND_NUMBER);
        }
    },
    INSERTION_SORT_REQUEST(4) {
        @Override
        ArraysRequest createRequest(int entryNumber) throws RequestTypeException {
            return entryNumber == 1 ? ArrayRequestType
                    .createRandomArraySortRequest(RANDOM_ARRAY_INSERTION_SORT_COMMAND_NUMBER)
                    : ArrayRequestType.createFileArraySortRequest(FILE_ARRAY_INSERTION_SORT_COMMAND_NUMBER);
        }
    },
    SHELL_SORT_REQUEST(5) {
        @Override
        ArraysRequest createRequest(int entryNumber) throws RequestTypeException {
            return entryNumber == 1 ? ArrayRequestType
                    .createRandomArraySortRequest(RANDOM_ARRAY_SHELL_SORT_COMMAND_NUMBER)
                    : ArrayRequestType.createFileArraySortRequest(FILE_ARRAY_SHELL_SORT_COMMAND_NUMBER);
        }
    };

    private static final String INVALID_OPERATION_ERROR_MESSAGE = "Invalid operation was chosen";
    private static final String INVALID_PARSER_ERROR_MESSAGE = "Invalid parser was chosen";
    private static final String CHOOSE_PARSER_MESSAGE_KEY = "view.choose.parser.message";
    private static final int RANDOM_ARRAY_BUBBLE_SORT_COMMAND_NUMBER = -6;
    private static final int RANDOM_ARRAY_COCKTAIL_SORT_COMMAND_NUMBER = -7;
    private static final int RANDOM_ARRAY_SELECTION_SORT_COMMAND_NUMBER = -8;
    private static final int FILE_ARRAY_BUBBLE_SORT_COMMAND_NUMBER = -9;
    private static final int FILE_ARRAY_COCKTAIL_SORT_COMMAND_NUMBER = -10;
    private static final int FILE_ARRAY_SELECTION_SORT_COMMAND_NUMBER = -11;
    private static final int RANDOM_ARRAY_INSERTION_SORT_COMMAND_NUMBER = -16;
    private static final int FILE_ARRAY_INSERTION_SORT_COMMAND_NUMBER = -17;
    private static final int FILE_ARRAY_SHELL_SORT_COMMAND_NUMBER = -18;
    private static final int RANDOM_ARRAY_SHELL_SORT_COMMAND_NUMBER = -19;
    private final int requestNumber;

    ArrayRequestType(int requestNumber) {
        this.requestNumber = requestNumber;
    }

    public int getRequestNumber() {
        return requestNumber;
    }

    abstract ArraysRequest createRequest(int entryNumber) throws RequestTypeException;

    public static ArrayRequestType findRequestType(int number) throws RequestTypeException {
        return Arrays.stream(ArrayRequestType.values())
                .filter(requestTypeNumber -> number == requestTypeNumber.getRequestNumber())
                .findAny()
                .orElseThrow(() -> new RequestTypeException(INVALID_OPERATION_ERROR_MESSAGE));
    }

    private static ArraysRequest createRandomArraySortRequest(int sortCommandNumber) {
        ArraysRequest request = new ArraysRequest();
        request.putParameter(ArraysConstant.COMMAND_NUMBER, sortCommandNumber);
        return request;
    }

    private static ArraysRequest createFileArraySortRequest(int sortCommandNumber) throws RequestTypeException {
        try {
            chooseParserNumber();
            ArraysRequest request = new ArraysRequest();
            ArraysFileDataReader fileDataReader = new ArraysFileDataReader();
            request.putParameter(ArraysConstant.DATA_NAME, fileDataReader.readArrayData());
            request.putParameter(ArraysConstant.COMMAND_NUMBER, sortCommandNumber);
            return request;
        } catch (ArraysDataCreatorException e) {
            throw new RequestTypeException(e.getMessage());
        }
    }

    private static void chooseParserNumber() throws RequestTypeException {
        ArraysViewConsoleReader consoleReader = new ArraysViewConsoleReader();
        System.out.println(ArraysPropertiesReader.getInstance().readMessageFromBundle(CHOOSE_PARSER_MESSAGE_KEY));
        int parserNumber = consoleReader.readParserNumber();
        if (parserNumber < 1 || parserNumber > 5) {
            throw new RequestTypeException(INVALID_PARSER_ERROR_MESSAGE);
        }

        ArraysArrayParserFactory.getInstance().setParserNumber(parserNumber);
    }
}
