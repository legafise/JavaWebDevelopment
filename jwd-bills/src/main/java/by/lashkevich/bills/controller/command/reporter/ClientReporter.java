package by.lashkevich.bills.controller.command.reporter;

import by.lashkevich.bills.entity.Client;
import by.lashkevich.bills.view.locale.LocaleReader;

import java.math.BigDecimal;

/**
 * Class that report information about
 * operations with clients
 * @author Roman Lashkevich
 */
public class ClientReporter {
    private static final String CLIENT_INFO_MESSAGE_KEY = "reporter.client.info.message";
    private static final String CLIENT_TOTAL_BILLS_AMOUNT_INFO_MESSAGE_KEY = "reporter.client.total" +
            ".bills.amount.info.message";
    private static final String CLIENT_TOTAL_POSITIVE_BILLS_AMOUNT_INFO_MESSAGE_KEY = "reporter.client.total" +
            ".positive.bills.amount.info.message";
    private static final String CLIENT_TOTAL_NEGATIVE_BILLS_AMOUNT_INFO_MESSAGE_KEY = "reporter.client.total" +
            ".negative.bills.amount.info.message";
    private static final String POSITIVE_RESULT_MESSAGE_KEY = "reporter.positive.result.message";
    private static final String NEGATIVE_RESULT_MESSAGE_KEY = "reporter.negative.result.message";
    private static final String CLIENT_ADDING_RESULT_MESSAGE_KEY = "reporter.client.adding.result.message";
    private static final String CLIENT_REMOVING_RESULT_MESSAGE_KEY = "reporter.client.removing.result.message";
    private static final String CLIENT_BILL_REMOVING_RESULT_MESSAGE_KEY = "reporter.client.bill" +
            ".removing.result.message";
    private static final String CLIENT_BILL_ASSIGNING_RESULT_MESSAGE_KEY = "reporter.client.bill" +
            ".assigning.result.message";
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

    public void reportClientAddingResult(boolean result) {
        reportResult(result, CLIENT_ADDING_RESULT_MESSAGE_KEY);
    }

    public void reportClientRemovingResult(boolean result) {
        reportResult(result, CLIENT_REMOVING_RESULT_MESSAGE_KEY);
    }

    public void reportClientBillRemovingResult(boolean result) {
        reportResult(result, CLIENT_BILL_REMOVING_RESULT_MESSAGE_KEY);
    }

    public void reportClientBillAssigningResult(boolean result) {
        reportResult(result, CLIENT_BILL_ASSIGNING_RESULT_MESSAGE_KEY);
    }

    private void reportResult(boolean result, String messageKey) {
        String resultMessage = result ? POSITIVE_RESULT_MESSAGE_KEY : NEGATIVE_RESULT_MESSAGE_KEY;
        System.out.println(localeReader.readMessageFromBundle(messageKey)
                + localeReader.readMessageFromBundle(resultMessage));
    }
}
