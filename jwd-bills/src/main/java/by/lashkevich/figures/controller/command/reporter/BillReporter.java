package by.lashkevich.figures.controller.command.reporter;

import by.lashkevich.figures.entity.Bill;
import by.lashkevich.figures.view.locale.LocaleReader;

import java.util.List;

/**
 * Class that report information about
 * operations with bills
 * @author Roman Lashkevich
 */
public class BillReporter {
    private static final String BILL_INFO_MESSAGE_KEY = "reporter.bill.info.message";
    private static final String BALANCE_DESCENDING_SORT_RESULT_MESSAGE_KEY = "reporter.bill.balance" +
            ".descending.sort.result.message";
    private static final String BALANCE_ASCENDING_SORT_RESULT_MESSAGE_KEY = "reporter.bill.balance" +
            ".ascending.sort.result.message";
    private static final String BALANCE_RANGE_SEARCH_RESULT_MESSAGE_KEY = "reporter.bill.balance" +
            ".range.sort.result.message";
    private static final String BLOCKING_RESULT_MESSAGE_KEY = "reporter.bill.blocking.result.info.message";
    private static final String BALANCE_CHANGING_RESULT_MESSAGE_KEY = "reporter.bill.balance.changing" +
            ".result.info.message";
    private static final String UNBLOCKING_RESULT_MESSAGE_KEY = "reporter.bill.unblocking.result.info.message";
    private static final String POSITIVE_RESULT_MESSAGE_KEY = "reporter.positive.result.message";
    private static final String NEGATIVE_RESULT_MESSAGE_KEY = "reporter.negative.result.message";
    private static final String BILL_CREATING_RESULT_MESSAGE_KEY = "reporter.bill.creating.result.message";
    private static final String BILL_REMOOVING_RESULT_MESSAGE_KEY = "reporter.bill.removing.result.message";
    private static final String NEW_LINE_BREAK = "\n";
    private final LocaleReader localeReader;

    public BillReporter() {
        localeReader = LocaleReader.getInstance();
    }

    public void reportBillInfo(Bill bill) {
        System.out.println(String.format(localeReader
                .readMessageFromBundle(BILL_INFO_MESSAGE_KEY) + bill, bill.getId()) + NEW_LINE_BREAK);
    }

    public void reportBalanceDescendingSortResult(List<Bill> bills) {
        reportBillsSortResult(bills, BALANCE_DESCENDING_SORT_RESULT_MESSAGE_KEY);
    }

    public void reportBalanceAscendingSortResult(List<Bill> bills) {
        reportBillsSortResult(bills, BALANCE_ASCENDING_SORT_RESULT_MESSAGE_KEY);
    }

    public void reportBillsBalanceRangeSearchInfo(List<Bill> bills,
                                                  String firstRangeElement, String secondRangeElement) {
        System.out.println(String.format(localeReader.readMessageFromBundle(BALANCE_RANGE_SEARCH_RESULT_MESSAGE_KEY),
                        firstRangeElement, secondRangeElement) + bills + NEW_LINE_BREAK);
    }

    public void reportBillBlockingResult(boolean result) {
        reportBillChangingResult(result, BLOCKING_RESULT_MESSAGE_KEY);
    }

    public void reportBillUnblockingResult(boolean result) {
        reportBillChangingResult(result, UNBLOCKING_RESULT_MESSAGE_KEY);
    }

    public void reportBillBalanceChangingResult(boolean result) {
        reportBillChangingResult(result, BALANCE_CHANGING_RESULT_MESSAGE_KEY);
    }

    public void reportBillCreatingResult(boolean result) {
        reportBillChangingResult(result, BILL_CREATING_RESULT_MESSAGE_KEY);
    }

    public void reportBillRemovingResult(boolean result) {
        reportBillChangingResult(result, BILL_REMOOVING_RESULT_MESSAGE_KEY);
    }

    private void reportBillsSortResult(List<Bill> bills, String messageKey) {
        System.out.println(localeReader.readMessageFromBundle(messageKey)
                + NEW_LINE_BREAK + bills + NEW_LINE_BREAK);
    }

    private void reportBillChangingResult(boolean result, String messageKey) {
        String resultMessage = result ? localeReader.readMessageFromBundle(POSITIVE_RESULT_MESSAGE_KEY)
                : localeReader.readMessageFromBundle(NEGATIVE_RESULT_MESSAGE_KEY);
        System.out.println(localeReader.readMessageFromBundle(messageKey) + resultMessage);
    }
}
