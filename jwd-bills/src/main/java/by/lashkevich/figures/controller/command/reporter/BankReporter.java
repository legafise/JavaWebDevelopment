package by.lashkevich.figures.controller.command.reporter;

import by.lashkevich.figures.entity.Bank;
import by.lashkevich.figures.view.locale.LocaleReader;

/**
 * Class that report information about
 * operations with bank
 * @author Roman Lashkevich
 */
public class BankReporter {
    private static final String BANK_INFO_MESSAGE_KEY = "reporter.bank.information.message";
    private static final String SAVE_BANK_DATA_RESULT_MESSAGE_KEY = "reporter.bank.data.save.result.message";
    private static final String NEW_LINE_BREAK = "\n";
    private final LocaleReader localeReader;

    public BankReporter() {
        this.localeReader = LocaleReader.getInstance();
    }

    public void reportBankInfo(Bank bank) {
        System.out.println(NEW_LINE_BREAK + localeReader.readMessageFromBundle(BANK_INFO_MESSAGE_KEY)
                + bank + NEW_LINE_BREAK);
    }

    public void saveDataResult() {
        System.out.println(localeReader.readMessageFromBundle(SAVE_BANK_DATA_RESULT_MESSAGE_KEY));
    }
}
