package by.lashkevich.bills.dao.impl;

import by.lashkevich.bills.dao.ClientDao;
import by.lashkevich.bills.dao.DaoException;
import by.lashkevich.bills.dao.FilePathFinder;
import by.lashkevich.bills.entity.Client;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class BillsClientDao implements ClientDao {
    private static final String CLIENT_INFO_FILE_NAME = "ClientsInfo.txt";
    private static final String CLIENT_SEPARATION_SIGN = "ClientInfo";
    private static final String BILL_SEPARATION_SIGN = "BillsInfo";
    private static final String INCORRECT_ID_MESSAGE = "Incorrect client id(%d) was entered";
    private final FilePathFinder filePathFinder;
    private List<Client> clients;

    public BillsClientDao() throws DaoException {
        filePathFinder = new FilePathFinder();
        readClientsData();
    }

    @Override
    public Client findClientById(long id) throws DaoException {
        return clients.stream()
                .filter(client -> client.getId() == id)
                .findFirst()
                .orElseThrow(() -> new DaoException(String.format(INCORRECT_ID_MESSAGE, id)));
    }

    public void readClientsData() throws DaoException {
        try {
            List<Client> clients = new ArrayList<>();
            List<String> clientData = Files.lines(Paths.get(filePathFinder.findInfoFilePath(CLIENT_INFO_FILE_NAME)))
                    .collect(Collectors.toList());
            Iterator clientIterator = clientData.iterator();
            String currentElement = clientIterator.next().toString();

            while (clientIterator.hasNext()) {
                boolean billMarker;
                if (currentElement.equals(CLIENT_SEPARATION_SIGN)) {
                    List<Long> billsIds = new ArrayList<>();
                    Client client = new Client();
                    client.setId(Long.parseLong(clientIterator.next().toString()));
                    client.setName(clientIterator.next().toString());
                    client.setSurname(clientIterator.next().toString());
                    client.setAge(Integer.parseInt(clientIterator.next().toString()));

                    if (clientIterator.hasNext() && clientIterator.next().toString().equals(BILL_SEPARATION_SIGN)) {
                        do {
                            if (!clientIterator.hasNext()) {
                                break;
                            }

                            currentElement = clientIterator.next().toString();
                            billMarker = !currentElement.equals(CLIENT_SEPARATION_SIGN);
                            if (billMarker) {
                                billsIds.add(Long.parseLong(currentElement));
                            }
                        } while (billMarker);

                        client.setBillIds(billsIds);
                        clients.add(client);
                    }
                }
            }

            this.clients = clients;
        } catch (IOException e) {
            throw new DaoException(e.getMessage());
        }
    }
}
