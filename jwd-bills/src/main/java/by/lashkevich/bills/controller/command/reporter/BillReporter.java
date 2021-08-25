package by.lashkevich.bills.controller.command.reporter;

import by.lashkevich.bills.entity.Bill;
import by.lashkevich.bills.view.locale.LocaleReader;

import java.util.List;

public class BillReporter {
    private static final String BILL_INFO_MESSAGE_KEY = "reporter.bill.info.message";
    private static final String BALANCE_DESCENDING_SORT_RESULT_MESSAGE_KEY = "reporter.bill.balance" +
            ".descending.sort.result.message";
    private static final String BALANCE_ASCENDING_SORT_RESULT_MESSAGE_KEY = "reporter.bill.balance" +
            ".ascending.sort.result.message";
    private static final String BALANCE_RANGE_SEARCH_RESULT_MESSAGE_KEY = "reporter.bill.balance" +
            ".range.sort.result.message";
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

    private void reportBillsSortResult(List<Bill> bills, String messageKey) {
        System.out.println(localeReader.readMessageFromBundle(messageKey)
                + NEW_LINE_BREAK + bills + NEW_LINE_BREAK);
    }

    public void reportBillsBalanceRangeSearchInfo(List<Bill> bills,
                                                  String firstRangeElement, String secondRangeElement) {
        System.out.println(String.format(localeReader.readMessageFromBundle(BALANCE_RANGE_SEARCH_RESULT_MESSAGE_KEY),
                        firstRangeElement, secondRangeElement) + bills + NEW_LINE_BREAK);
    }
}
