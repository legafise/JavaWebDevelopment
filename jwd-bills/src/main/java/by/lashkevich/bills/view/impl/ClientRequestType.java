package by.lashkevich.bills.view.impl;

import by.lashkevich.bills.controller.request.Request;
import by.lashkevich.bills.controller.request.RequestConstant;
import by.lashkevich.bills.view.ViewConsoleReader;
import by.lashkevich.bills.view.locale.LocaleReader;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;

public enum ClientRequestType {
    STANDARD_REQUEST(0) {
        @Override
        Request createRequest(ViewConsoleReader consoleReader, LocaleReader localeReader) {
            String invalidOperationMessage = localeReader.readMessageFromBundle(INVALID_OPERATION_MESSAGE_KEY);
            System.out.println(invalidOperationMessage);
            LOGGER.log(Level.ERROR, invalidOperationMessage);
            Request request = new Request();
            request.putParameter(RequestConstant.COMMAND_NUMBER, CLIENT_VIEW_COMMAND_NUMBER);
            return request;
        }
    },
    FIND_CLIENT_BY_ID_REQUEST(1) {
        @Override
        Request createRequest(ViewConsoleReader consoleReader, LocaleReader localeReader) {
            Request request = new Request();
            System.out.println(localeReader.readMessageFromBundle(INTRODUCE_CLIENT_ID_MESSAGE_KEY));
            request.putParameter(RequestConstant.DATA_NAME, consoleReader.readClientId());
            request.putParameter(RequestConstant.COMMAND_NUMBER, FIND_CLIENT_BY_ID_COMMAND_NUMBER);
            return request;
        }
    },
    CALCULATE_CLIENT_TOTAL_BILLS_AMOUNT_REQUEST(2) {
        @Override
        Request createRequest(ViewConsoleReader consoleReader, LocaleReader localeReader) {
            Request request = new Request();
            System.out.println(localeReader.readMessageFromBundle(INTRODUCE_CLIENT_ID_MESSAGE_KEY));
            request.putParameter(RequestConstant.DATA_NAME, consoleReader.readClientId());
            request.putParameter(RequestConstant.COMMAND_NUMBER, CALCULATE_TOTAL_BILLS_AMOUNT_NUMBER);
            return request;
        }
    },
    CALCULATE_CLIENT_TOTAL_POSITIVE_BILLS_AMOUNT_REQUEST(3) {
        @Override
        Request createRequest(ViewConsoleReader consoleReader, LocaleReader localeReader) {
            Request request = new Request();
            System.out.println(localeReader.readMessageFromBundle(INTRODUCE_CLIENT_ID_MESSAGE_KEY));
            request.putParameter(RequestConstant.DATA_NAME, consoleReader.readClientId());
            request.putParameter(RequestConstant.COMMAND_NUMBER, CALCULATE_TOTAL_POSITIVE_BILLS_AMOUNT_NUMBER);
            return request;
        }
    },
    CALCULATE_CLIENT_TOTAL_NEGATIVE_BILLS_AMOUNT_REQUEST(4) {
        @Override
        Request createRequest(ViewConsoleReader consoleReader, LocaleReader localeReader) {
            Request request = new Request();
            System.out.println(localeReader.readMessageFromBundle(INTRODUCE_CLIENT_ID_MESSAGE_KEY));
            request.putParameter(RequestConstant.DATA_NAME, consoleReader.readClientId());
            request.putParameter(RequestConstant.COMMAND_NUMBER, CALCULATE_TOTAL_NEGATIVE_BILLS_AMOUNT_NUMBER);
            return request;
        }
    };

    private static final String INVALID_OPERATION_MESSAGE_KEY = "view.invalid.operation.message";
    private static final String INTRODUCE_CLIENT_ID_MESSAGE_KEY = "view.introduce.client.id.message";
    private static final int CLIENT_VIEW_COMMAND_NUMBER = 1;
    private static final int CALCULATE_TOTAL_BILLS_AMOUNT_NUMBER = -3;
    private static final int CALCULATE_TOTAL_POSITIVE_BILLS_AMOUNT_NUMBER = -4;
    private static final int CALCULATE_TOTAL_NEGATIVE_BILLS_AMOUNT_NUMBER = -5;
    private static final int FIND_CLIENT_BY_ID_COMMAND_NUMBER = -2;
    private static final Logger LOGGER = LogManager.getRootLogger();
    private final int requestNumber;

    ClientRequestType(int requestNumber) {
        this.requestNumber = requestNumber;
    }

    abstract Request createRequest(ViewConsoleReader consoleReader, LocaleReader localeReader);

    public int getRequestNumber() {
        return requestNumber;
    }

    public static ClientRequestType findRequestType(int requestNumber) {
        return Arrays.stream(ClientRequestType.values())
                .filter(requestTypeNumber -> requestNumber == requestTypeNumber.getRequestNumber())
                .findAny()
                .orElse(STANDARD_REQUEST);
    }
}
