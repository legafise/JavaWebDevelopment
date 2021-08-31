package by.lashkevich.bills.service;

import by.lashkevich.bills.dao.DaoFactory;
import by.lashkevich.bills.entity.Bill;
import by.lashkevich.bills.entity.Client;

import java.util.Optional;
import java.util.function.Predicate;

/**
 * Class that checks processing objects for
 * duplicates in data store
 * @author RomalLashkevich
 */
public class ServiceDuplicationChecker {
    public boolean isDuplicateClient(Client client) {
        Predicate<Client> clientPredicate = currentClient -> currentClient.getId() == client.getId();
        Optional<Client> duplicateClient = DaoFactory.getInstance()
                .getClientDao().findAllClients().stream()
                .filter(clientPredicate)
                .findAny();

        return duplicateClient.isPresent();
    }

    public boolean isDuplicateBill(Bill bill) {
        Predicate<Bill> billPredicate = currentBill -> currentBill.getId() == bill.getId();
        Optional<Bill> duplicateBill = DaoFactory.getInstance()
                .getBillDao().findAllBills().stream()
                .filter(billPredicate)
                .findAny();

        return duplicateBill.isPresent();
    }
}
