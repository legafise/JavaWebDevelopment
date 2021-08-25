package by.lashkevich.bills.controller.command.reporter;

import by.lashkevich.bills.entity.Client;
import by.lashkevich.bills.view.locale.LocaleReader;

import java.math.BigDecimal;

public class ClientReporter {
    private static final String CLIENT_INFO_MESSAGE_KEY = "reporter.client.info.message";
    private static final String CLIENT_TOTAL_BILLS_AMOUNT_INFO_MESSAGE_KEY = "reporter.client.total" +
            ".bills.amount.info.message";
    private static final String CLIENT_TOTAL_POSITIVE_BILLS_AMOUNT_INFO_MESSAGE_KEY = "reporter.client.total" +
            ".positive.bills.amount.info.message";
    private static final String CLIENT_TOTAL_NEGATIVE_BILLS_AMOUNT_INFO_MESSAGE_KEY = "reporter.client.total" +
            ".negative.bills.amount.info.message";
    private static final String NEW_LINE_BREAK = "\n";
    private final LocaleReader localeReader;

    public ClientReporter() {
        localeReader = LocaleReader.getInstance();
    }

    public void reportClientInfo(Client client) {
        System.out.println(String.format(localeReader
                .readMessageFromBundle(CLIENT_INFO_MESSAGE_KEY) + client, client.getId()) + NEW_LINE_BREAK);
    }

    public void reportClientTotalBillsAmountInfo(BigDecimal totalAmount, String clientId) {
        reportClientBillsAmountInfo(totalAmount, clientId, CLIENT_TOTAL_BILLS_AMOUNT_INFO_MESSAGE_KEY);
    }

    public void reportClientTotalPositiveBillsAmountInfo(BigDecimal totalAmount, String clientId) {
        reportClientBillsAmountInfo(totalAmount, clientId, CLIENT_TOTAL_POSITIVE_BILLS_AMOUNT_INFO_MESSAGE_KEY);
    }

    public void reportClientTotalNegativeBillsAmountInfo(BigDecimal totalAmount, String clientId) {
        reportClientBillsAmountInfo(totalAmount, clientId, CLIENT_TOTAL_NEGATIVE_BILLS_AMOUNT_INFO_MESSAGE_KEY);
    }

    private void reportClientBillsAmountInfo(BigDecimal totalAmount, String clientId, String messageKey) {
        System.out.println(String.format(localeReader.readMessageFromBundle(messageKey), clientId)
                + totalAmount + NEW_LINE_BREAK);
    }
}
