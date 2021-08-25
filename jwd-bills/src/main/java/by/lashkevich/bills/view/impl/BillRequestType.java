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
    };

    private static final String INVALID_OPERATION_MESSAGE_KEY = "view.invalid.operation.message";
    private static final String INTRODUCE_BILL_ID_MESSAGE_KEY = "view.introduce.bill.id.message";
    private static final String INTRODUCE_FIRST_RANGE_VALUE_MESSAGE_KEY = "view.introduce.first.range.value.message";
    private static final String INTRODUCE_SECOND_RANGE_VALUE_MESSAGE_KEY = "view.introduce.second.range.value.message";
    private static final int BILL_VIEW_COMMAND_NUMBER = 3;
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
        return Arrays.stream(BillRequestType.values())
                .filter(requestTypeNumber -> requestNumber == requestTypeNumber.getRequestNumber())
                .findAny()
                .orElse(STANDARD_REQUEST);
    }
}
