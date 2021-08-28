package by.lashkevich.bills.service;

import by.lashkevich.bills.dao.DaoFactory;
import by.lashkevich.bills.entity.Bill;
import by.lashkevich.bills.entity.Client;

import java.util.Optional;

/**
 * Class that checks processing objects for
 * duplicates in data store
 * @author RomalLashkevich
 */
public class ServiceDuplicationChecker {
    public boolean isDuplicateClient(Client client) {
        Optional<Client> duplicateClient = DaoFactory.getInstance()
                .getClientDao().findAllClients().stream()
                .filter(currentClient -> currentClient.getId() == client.getId())
                .findAny();

        return duplicateClient.isPresent();
    }

    public boolean isDuplicateBill(Bill bill) {
        Optional<Bill> duplicateBill = DaoFactory.getInstance()
                .getBillDao().findAllBills().stream()
                .filter(currentBill -> currentBill.getId() == bill.getId())
                .findAny();

        return duplicateBill.isPresent();
    }
}
