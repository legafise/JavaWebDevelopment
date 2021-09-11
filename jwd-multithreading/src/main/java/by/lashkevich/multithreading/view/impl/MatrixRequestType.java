package by.lashkevich.multithreading.view.impl;

import by.lashkevich.multithreading.controller.request.Request;
import by.lashkevich.multithreading.controller.request.RequestConstant;
import by.lashkevich.multithreading.view.ViewConsoleReader;
import by.lashkevich.multithreading.view.locale.LocaleReader;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;

/**
 * Enum for fast request creating
 * @author Roman Lashkevich
 * @see by.lashkevich.multithreading.controller.request.Request
 */
public enum MatrixRequestType {
    STANDARD_REQUEST(0) {
        @Override
        Request createRequest(ViewConsoleReader consoleReader, LocaleReader localeReader) {
            String invalidOperationMessage = localeReader.readMessageFromBundle(INVALID_OPERATION_MESSAGE_KEY);
            System.out.println(invalidOperationMessage);
            LOGGER.log(Level.INFO, invalidOperationMessage);
            Request request = new Request();
            request.putParameter(RequestConstant.COMMAND_NUMBER, MATRIX_VIEW_COMMAND_NUMBER);
            return request;
        }
    };

    private static final Logger LOGGER = LogManager.getRootLogger();
    private static final String INVALID_OPERATION_MESSAGE_KEY = "view.invalid.operation.message";
    private static final int MATRIX_VIEW_COMMAND_NUMBER = 2;

    private final int requestNumber;

    MatrixRequestType(int requestNumber) {
        this.requestNumber = requestNumber;
    }

    abstract Request createRequest(ViewConsoleReader consoleReader, LocaleReader localeReader);

    public int getRequestNumber() {
        return requestNumber;
    }

    public static MatrixRequestType findRequestType(int number) {
        return Arrays.stream(MatrixRequestType.values())
                .filter(requestTypeNumber -> number == requestTypeNumber.getRequestNumber())
                .findAny()
                .orElse(STANDARD_REQUEST);
    }
}
