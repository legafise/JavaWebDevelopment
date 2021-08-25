package by.lashkevich.bills.controller.command.reporter;

import by.lashkevich.bills.entity.Bill;
import by.lashkevich.bills.view.locale.LocaleReader;

import java.util.List;

public class BillReporter {
    private static final String BILL_INFO_MESSAGE_KEY = "reporter.bill.info.message";
    private static final String BALANCE_DESCENDING_SORT_RESULT_MESSAGE_KEY = "reporter.bill.balance" +
            ".descending.sort.result.message";
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

    private void reportBillsSortResult(List<Bill> bills, String messageKey) {
        System.out.println(localeReader.readMessageFromBundle(messageKey) + NEW_LINE_BREAK + bills);
    }
}
