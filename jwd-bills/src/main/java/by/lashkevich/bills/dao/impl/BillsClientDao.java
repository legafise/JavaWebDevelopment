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

    public BillsClientDao() {
        filePathFinder = new FilePathFinder();
    }

    @Override
    public Client findClientById(long id) throws DaoException {
        try {
            Client client = new Client();
            List<Long> billsIds = new ArrayList<>();
            List<String> clientData = Files.lines(Paths.get(filePathFinder.findInfoFilePath(CLIENT_INFO_FILE_NAME)))
                    .collect(Collectors.toList());
            Iterator clientIterator = clientData.iterator();
            boolean billMarker;
            while (clientIterator.hasNext()) {
                if (clientIterator.next().toString().equals(CLIENT_SEPARATION_SIGN)
                        && clientIterator.next().toString().equals(String.valueOf(id))) {
                    client.setId(id);
                    client.setName(clientIterator.next().toString());
                    client.setSurname(clientIterator.next().toString());
                    client.setAge(Integer.parseInt(clientIterator.next().toString()));

                    if (clientIterator.hasNext() && clientIterator.next().toString().equals(BILL_SEPARATION_SIGN)) {
                        do {
                            String currentBillElement = clientIterator.next().toString();
                            billMarker = !currentBillElement.equals(CLIENT_SEPARATION_SIGN);
                            if (billMarker) {
                                billsIds.add(Long.parseLong(currentBillElement));
                            }
                        } while (billMarker && clientIterator.hasNext());

                        break;
                    }
                }
            }

            if (client.getId() == 0) {
                throw new DaoException(String.format(INCORRECT_ID_MESSAGE, id));
            }

            client.setBillIds(billsIds);

            return client;
        } catch (IOException e) {
            throw new DaoException(e.getMessage());
        }
    }
}
