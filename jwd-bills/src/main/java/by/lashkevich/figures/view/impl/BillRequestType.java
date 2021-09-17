package by.lashkevich.figures.view.impl;

import by.lashkevich.figures.controller.request.Request;
import by.lashkevich.figures.controller.request.RequestConstant;
import by.lashkevich.figures.view.ViewConsoleReader;
import by.lashkevich.figures.view.locale.LocaleReader;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public enum BillRequestType {
    STANDARD_REQUEST(0) {
        @Override
        Request createRequest(ViewConsoleReader consoleReader, LocaleReader localeReader) {
            String invalidOperationMessage = localeReader.readMessageFromBundle(INVALID_OPERATION_MESSAGE_KEY);
            System.out.println(invalidOperationMessage);
            LOGGER.log(Level.ERROR, invalidOperationMessage);
            Request request = new Request();
            request.putParameter(RequestConstant.COMMAND_NUMBER, BILL_VIEW_COMMAND_NUMBER);
            return request;
        }
    },
    FIND_BILL_BY_ID_REQUEST(1) {
        @Override
        Request createRequest(ViewConsoleReader consoleReader, LocaleReader localeReader) {
            Request request = new Request();
            System.out.println(localeReader.readMessageFromBundle(INTRODUCE_BILL_ID_MESSAGE_KEY));
            request.putParameter(RequestConstant.DATA_NAME, consoleReader.readBillId());
            request.putParameter(RequestConstant.COMMAND_NUMBER, FIND_BILL_BY_ID_COMMAND_NUMBER);
            return request;
        }
    },
    BALANCE_DESCENDING_SORT_REQUEST(2) {
        @Override
        Request createRequest(ViewConsoleReader consoleReader, LocaleReader localeReader) {
            Request request = new Request();
            request.putParameter(RequestConstant.COMMAND_NUMBER, BALANCE_DESCENDING_SORT_COMMAND_NUMBER);
            return request;
        }
    },
    BALANCE_ASCENDING_SORT_REQUEST(3) {
        @Override
        Request createRequest(ViewConsoleReader consoleReader, LocaleReader localeReader) {
            Request request = new Request();
            request.putParameter(RequestConstant.COMMAND_NUMBER, BALANCE_ASCENDING_SORT_COMMAND_NUMBER);
            return request;
        }
    },
    FIND_BILLS_BY_BALANCE_IN_RANGE(4) {
        @Override
        Request createRequest(ViewConsoleReader consoleReader, LocaleReader localeReader) {
            Request request = new Request();
            List<String> rangeValues = new ArrayList<>();
            System.out.println(localeReader.readMessageFromBundle(INTRODUCE_FIRST_RANGE_VALUE_MESSAGE_KEY));
            rangeValues.add(consoleReader.readRangeValue());
            System.out.println(localeReader.readMessageFromBundle(INTRODUCE_SECOND_RANGE_VALUE_MESSAGE_KEY));
            rangeValues.add(consoleReader.readRangeValue());
            request.putParameter(RequestConstant.COMMAND_NUMBER, FIND_BILLS_BY_BALANCE_IN_RANGE_COMMAND_NUMBER);
            request.putParameter(RequestConstant.DATA_NAME, rangeValues);
            return request;
        }
    },
    BLOCK_BILL_BY_ID_REQUEST(5) {
        @Override
        Request createRequest(ViewConsoleReader consoleReader, LocaleReader localeReader) {
            Request request = new Request();
            System.out.println(localeReader.readMessageFromBundle(INTRODUCE_BILL_ID_MESSAGE_KEY));
            request.putParameter(RequestConstant.DATA_NAME, consoleReader.readBillId());
            request.putParameter(RequestConstant.COMMAND_NUMBER, BLOCK_BILL_BY_ID_REQUEST_COMMAND_NUMBER);
            return request;
        }
    },
    UNBLOCK_BILL_BY_ID_REQUEST(6) {
        @Override
        Request createRequest(ViewConsoleReader consoleReader, LocaleReader localeReader) {
            Request request = new Request();
            System.out.println(localeReader.readMessageFromBundle(INTRODUCE_BILL_ID_MESSAGE_KEY));
            request.putParameter(RequestConstant.DATA_NAME, consoleReader.readBillId());
            request.putParameter(RequestConstant.COMMAND_NUMBER, UNBLOCK_BILL_BY_ID_REQUEST_COMMAND_NUMBER);
            return request;
        }
    },
    CHANGE_BALANCE_REQUEST(7) {
        @Override
        Request createRequest(ViewConsoleReader consoleReader, LocaleReader localeReader) {
            Request request = new Request();
            List<String> billBalanceData = new ArrayList<>();
            System.out.println(localeReader.readMessageFromBundle(INTRODUCE_BILL_ID_MESSAGE_KEY));
            billBalanceData.add(consoleReader.readBillId());
            System.out.println(localeReader.readMessageFromBundle(INTRODUCE_BILL_BALANCE_MESSAGE_KEY));
            billBalanceData.add(consoleReader.readBillBalance());
            request.putParameter(RequestConstant.DATA_NAME, billBalanceData);
            request.putParameter(RequestConstant.COMMAND_NUMBER, CHANGE_BILL_BALANCE_COMMAND_NUMBER);
            return request;
        }
    },
    CREATE_NEW_BILL(8) {
        @Override
        Request createRequest(ViewConsoleReader consoleReader, LocaleReader localeReader) {
            Request request = new Request();
            System.out.println(localeReader.readMessageFromBundle(INTRODUCE_BILL_DATA_MESSAGE_KEY));
            System.out.println(localeReader.readMessageFromBundle(INTRODUCE_BILL_ID_MESSAGE_KEY));
            request.putParameter(RequestConstant.DATA_NAME, consoleReader.readBillId());
            request.putParameter(RequestConstant.COMMAND_NUMBER, CREATE_NEW_BILL_COMMAND_NUMBER);
            return request;
        }
    },
    REMOVE_BILL_BY_ID_REQUEST(9) {
        @Override
        Request createRequest(ViewConsoleReader consoleReader, LocaleReader localeReader) {
            Request request = new Request();
            System.out.println(localeReader.readMessageFromBundle(INTRODUCE_BILL_ID_MESSAGE_KEY));
            request.putParameter(RequestConstant.DATA_NAME, consoleReader.readBillId());
            request.putParameter(RequestConstant.COMMAND_NUMBER, REMOVE_BILL_BY_ID_COMMAND_NUMBER);
            return request;
        }
    };

    private static final String INVALID_OPERATION_MESSAGE_KEY = "view.invalid.operation.message";
    private static final String INTRODUCE_BILL_ID_MESSAGE_KEY = "view.introduce.bill.id.message";
    private static final String INTRODUCE_FIRST_RANGE_VALUE_MESSAGE_KEY = "view.introduce.first.range.value.message";
    private static final String INTRODUCE_SECOND_RANGE_VALUE_MESSAGE_KEY = "view.introduce.second.range.value.message";
    private static final String INTRODUCE_BILL_BALANCE_MESSAGE_KEY = "view.introduce.bill.balance.message";
    private static final String INTRODUCE_BILL_DATA_MESSAGE_KEY = "view.introduce.bill.data.message";
    private static final int BILL_VIEW_COMMAND_NUMBER = 3;
    private static final int REMOVE_BILL_BY_ID_COMMAND_NUMBER = -16;
    private static final int CREATE_NEW_BILL_COMMAND_NUMBER = -15;
    private static final int CHANGE_BILL_BALANCE_COMMAND_NUMBER = -14;
    private static final int UNBLOCK_BILL_BY_ID_REQUEST_COMMAND_NUMBER = -11;
    private static final int BLOCK_BILL_BY_ID_REQUEST_COMMAND_NUMBER = -10;
    private static final int FIND_BILLS_BY_BALANCE_IN_RANGE_COMMAND_NUMBER = -9;
    private static final int BALANCE_ASCENDING_SORT_COMMAND_NUMBER = -8;
    private static final int BALANCE_DESCENDING_SORT_COMMAND_NUMBER = -7;
    private static final int FIND_BILL_BY_ID_COMMAND_NUMBER = -6;
    private static final Logger LOGGER = LogManager.getRootLogger();
    private final int requestNumber;

    BillRequestType(int requestNumber) {
        this.requestNumber = requestNumber;
    }

    abstract Request createRequest(ViewConsoleReader consoleReader, LocaleReader localeReader);

    public int getRequestNumber() {
        return requestNumber;
    }

    public static BillRequestType findRequestType(int requestNumber) {
        Predicate<BillRequestType> billRequestTypePredicate = requestType -> requestNumber == requestType
                .getRequestNumber();
        return Arrays.stream(BillRequestType.values())
                .filter(billRequestTypePredicate)
                .findAny()
                .orElse(STANDARD_REQUEST);
    }
}
