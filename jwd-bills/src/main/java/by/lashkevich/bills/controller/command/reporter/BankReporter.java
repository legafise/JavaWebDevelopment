package by.lashkevich.bills.controller.command.reporter;

import by.lashkevich.bills.entity.Bank;
import by.lashkevich.bills.view.locale.LocaleReader;

public class BankReporter {
    private static final String BANK_INFO_MESSAGE_KEY = "reporter.bank.information.message";
    private static final String NEW_LINE_BREAK = "\n";
    private final LocaleReader localeReader;

    public BankReporter() {
        this.localeReader = LocaleReader.getInstance();
    }

    public void reportBankInfo(Bank bank) {
        System.out.println(NEW_LINE_BREAK + localeReader.readMessageFromBundle(BANK_INFO_MESSAGE_KEY)
                + bank + NEW_LINE_BREAK);
    }
}
