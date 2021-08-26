package by.lashkevich.bills.service;

import by.lashkevich.bills.dao.DaoFactory;
import by.lashkevich.bills.entity.Client;

import java.util.Optional;

public class ServiceDuplicationChecker {
    public boolean isDuplicateClient(Client client) {
        Optional<Client> duplicateClient = DaoFactory.getInstance()
                .getClientDao().findAllClients().stream()
                .filter(currentClient -> currentClient.getId() == client.getId())
                .findAny();

        return duplicateClient.isPresent();
    }
}