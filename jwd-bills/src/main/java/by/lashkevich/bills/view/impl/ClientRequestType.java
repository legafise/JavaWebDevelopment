package by.lashkevich.bills.view.impl;

import by.lashkevich.bills.controller.request.Request;
import by.lashkevich.bills.controller.request.RequestConstant;
import by.lashkevich.bills.view.ViewConsoleReader;
import by.lashkevich.bills.view.locale.LocaleReader;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

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
    },
    CREATE_NEW_CLIENT_REQUEST(5) {
        @Override
        Request createRequest(ViewConsoleReader consoleReader, LocaleReader localeReader) {
            Request request = new Request();
            List<String> clientData = new ArrayList<>();

            System.out.println(localeReader.readMessageFromBundle(INTRODUCE_CLIENT_DATA_MESSAGE_KEY));
            System.out.println(localeReader.readMessageFromBundle(INTRODUCE_CLIENT_ID_MESSAGE_KEY));
            clientData.add(consoleReader.readClientId());
            System.out.println(localeReader.readMessageFromBundle(INTRODUCE_CLIENT_NAME_MESSAGE_KEY));
            clientData.add(consoleReader.readClientName());
            System.out.println(localeReader.readMessageFromBundle(INTRODUCE_CLIENT_SURNAME_MESSAGE_KEY));
            clientData.add(consoleReader.readClientSurname());
            System.out.println(localeReader.readMessageFromBundle(INTRODUCE_CLIENT_AGE_MESSAGE_KEY));
            clientData.add(consoleReader.readClientAge());

            request.putParameter(RequestConstant.DATA_NAME, clientData);
            request.putParameter(RequestConstant.COMMAND_NUMBER, CREATE_NEW_CLIENT_COMMAND_NUMBER);
            return request;
        }
    },
    REMOVE_CLIENT_BY_ID_REQUEST(6) {
        @Override
        Request createRequest(ViewConsoleReader consoleReader, LocaleReader localeReader) {
            Request request = new Request();
            System.out.println(localeReader.readMessageFromBundle(INTRODUCE_CLIENT_ID_MESSAGE_KEY));
            request.putParameter(RequestConstant.DATA_NAME, consoleReader.readClientId());
            request.putParameter(RequestConstant.COMMAND_NUMBER, REMOVE_CLIENT_BY_ID_COMMAND_NUMBER);
            return request;
        }
    },
    ASSIGN_BILL_TO_CLIENT(7) {
        @Override
        Request createRequest(ViewConsoleReader consoleReader, LocaleReader localeReader) {
            return ClientRequestType.assignOrRemoveBill(consoleReader, localeReader,
                    ASSIGN_BILL_TO_CLIENT_COMMAND_NUMBER);
        }
    },
    REMOVE_CLIENT_BILL(8) {
        @Override
        Request createRequest(ViewConsoleReader consoleReader, LocaleReader localeReader) {
            return ClientRequestType.assignOrRemoveBill(consoleReader, localeReader,
                    REMOVE_CLIENT_BILL_COMMAND_NUMBER);
        }
    };

    private static final String INVALID_OPERATION_MESSAGE_KEY = "view.invalid.operation.message";
    private static final String INTRODUCE_CLIENT_ID_MESSAGE_KEY = "view.introduce.client.id.message";
    private static final String INTRODUCE_CLIENT_DATA_MESSAGE_KEY = "view.introduce.client.data.message";
    private static final String INTRODUCE_CLIENT_NAME_MESSAGE_KEY = "view.introduce.client.name.message";
    private static final String INTRODUCE_CLIENT_SURNAME_MESSAGE_KEY = "view.introduce.client.surname.message";
    private static final String INTRODUCE_CLIENT_AGE_MESSAGE_KEY = "view.introduce.client.age.message";
    private static final String INTRODUCE_BILL_ID_MESSAGE_KEY = "view.introduce.bill.id.message";
    private static final int CLIENT_VIEW_COMMAND_NUMBER = 2;
    private static final int CALCULATE_TOTAL_BILLS_AMOUNT_NUMBER = -3;
    private static final int CALCULATE_TOTAL_POSITIVE_BILLS_AMOUNT_NUMBER = -4;
    private static final int CALCULATE_TOTAL_NEGATIVE_BILLS_AMOUNT_NUMBER = -5;
    private static final int FIND_CLIENT_BY_ID_COMMAND_NUMBER = -2;
    private static final int CREATE_NEW_CLIENT_COMMAND_NUMBER = -12;
    private static final int REMOVE_CLIENT_BY_ID_COMMAND_NUMBER = -13;
    private static final int ASSIGN_BILL_TO_CLIENT_COMMAND_NUMBER = -17;
    private static final int REMOVE_CLIENT_BILL_COMMAND_NUMBER = -18;
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
        Predicate<ClientRequestType> clientRequestTypePredicate = requestType -> requestNumber == requestType
                .getRequestNumber();
        return Arrays.stream(ClientRequestType.values())
                .filter(clientRequestTypePredicate)
                .findAny()
                .orElse(STANDARD_REQUEST);
    }

    private static Request assignOrRemoveBill(ViewConsoleReader consoleReader, LocaleReader localeReader,
                                              int commandNumber) {
        Request request = new Request();
        List<String> assigningOrRemovingBillData = new ArrayList<>();
        System.out.println(localeReader.readMessageFromBundle(INTRODUCE_CLIENT_ID_MESSAGE_KEY));
        assigningOrRemovingBillData.add(consoleReader.readClientId());
        System.out.println(localeReader.readMessageFromBundle(INTRODUCE_BILL_ID_MESSAGE_KEY));
        assigningOrRemovingBillData.add(consoleReader.readBillId());
        request.putParameter(RequestConstant.DATA_NAME, assigningOrRemovingBillData);
        request.putParameter(RequestConstant.COMMAND_NUMBER, commandNumber);
        return request;
    }
}
