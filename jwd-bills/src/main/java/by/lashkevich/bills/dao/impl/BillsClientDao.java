package by.lashkevich.bills.dao.impl;

import by.lashkevich.bills.dao.*;
import by.lashkevich.bills.entity.Bill;
import by.lashkevich.bills.entity.Client;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * @author Roman Lashkevich
 * @see ClientDao
 */
public class BillsClientDao implements ClientDao {
    private static final String CLIENT_INFO_FILE_NAME = "ClientsInfo.txt";
    private static final String CLIENT_SEPARATION_SIGN = "ClientInfo";
    private static final String BILL_SEPARATION_SIGN = "BillsInfo";
    private static final String INCORRECT_ID_MESSAGE = "Incorrect client id(%d) was entered";
    private static final String SAVING_CLIENT_INFO_FILE_PATH = "jwd-bills/src/main/resources/info/ClientsInfo.txt";
    private static final String NEW_LINE_BREAK = "\n";
    private final FileFinder fileFinder;
    private List<Client> clients;
    private String currentElement;

    public BillsClientDao() throws DaoException {
        fileFinder = new FileFinder();
        readClientsData();
    }

    @Override
    public Client findClientById(long id) throws DaoException {
        Predicate<Client> clientPredicate = client -> client.getId() == id;
        return clients.stream()
                .filter(clientPredicate)
                .findFirst()
                .orElseThrow(() -> new DaoException(String.format(INCORRECT_ID_MESSAGE, id)));
    }

    @Override
    public List<Client> findAllClients() throws DaoException {
        return clients;
    }

    @Override
    public boolean addClient(Client client) throws DaoException {
        return clients.add(client);
    }

    @Override
    public boolean removeClient(long id) throws DaoException {
        Predicate<Client> clientPredicate = client -> client.getId() == id;
        Optional<Client> removingClientOptional = clients.stream()
                .filter(clientPredicate)
                .findAny();
        return removingClientOptional.isPresent() && clients.remove(removingClientOptional.get());
    }

    @Override
    public boolean removeBill(long id) throws DaoException {
        boolean removingResult = false;
        Predicate<Bill> billPredicate = bill -> bill.getId() == id;
        for (Client client : clients) {
            Optional<Bill> removingBillOptional = client.getBills().stream()
                    .filter(billPredicate)
                    .findAny();
            if (removingBillOptional.isPresent()) {
                client.getBills().remove(removingBillOptional.get());
                removingResult = true;
            }
        }

        return removingResult;
    }

    @Override
    public void writeClientsData() throws DaoException {
        File clientsInfoFile = new File(SAVING_CLIENT_INFO_FILE_PATH);

        try (PrintWriter printWriter = new PrintWriter(clientsInfoFile)) {
            for (Client client : clients) {
                printWriter.write(CLIENT_SEPARATION_SIGN + NEW_LINE_BREAK);
                printWriter.write(client.getId() + NEW_LINE_BREAK);
                printWriter.write(client.getName() + NEW_LINE_BREAK);
                printWriter.write(client.getSurname() + NEW_LINE_BREAK);
                printWriter.write(client.getAge() + NEW_LINE_BREAK);
                printWriter.write(BILL_SEPARATION_SIGN + NEW_LINE_BREAK);

                for (Bill bill : client.getBills()) {
                    printWriter.write(bill.getId() + NEW_LINE_BREAK);
                }
            }
        } catch (FileNotFoundException e) {
            throw new DaoException(e);
        }
    }

    public void readClientsData() throws DaoException {
        try {
            List<Client> clients = new ArrayList<>();
            List<String> clientData = Files.lines(Paths.get(fileFinder.findInfoFilePath(CLIENT_INFO_FILE_NAME)))
                    .collect(Collectors.toList());
            Iterator<String> clientIterator = clientData.iterator();
            currentElement = clientIterator.next();

            while (clientIterator.hasNext()) {
                if (currentElement.equals(CLIENT_SEPARATION_SIGN)) {
                    Client client = mapClient(clientIterator);
                    client.setBills(mapBills(clientIterator));
                    clients.add(client);
                }
            }

            this.clients = clients;
        } catch (IOException e) {
            throw new DaoException(e.getMessage());
        }
    }

    private List<Bill> mapBills(Iterator<String> clientIterator) {
        List<Bill> bills = new ArrayList<>();
        boolean billMarker = false;
        if (clientIterator.hasNext() && clientIterator.next().equals(BILL_SEPARATION_SIGN)) {
            do {
                if (clientIterator.hasNext()) {
                    currentElement = clientIterator.next();
                    billMarker = !currentElement.equals(CLIENT_SEPARATION_SIGN);
                    if (billMarker) {
                        bills.add(DaoFactory.getInstance().getBillDao()
                                .findBillById(Long.parseLong(currentElement)));
                    }
                }
            } while (billMarker);
        }

        return bills;
    }

    private Client mapClient(Iterator<String> clientIterator) {
        Client client = new Client();
        client.setId(Long.parseLong(clientIterator.next()));
        client.setName(clientIterator.next());
        client.setSurname(clientIterator.next());
        client.setAge(Integer.parseInt(clientIterator.next()));

        return client;
    }
}
