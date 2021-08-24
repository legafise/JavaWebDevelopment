package by.lashkevich.bills.dao.impl;

import by.lashkevich.bills.dao.*;
import by.lashkevich.bills.entity.Bank;
import by.lashkevich.bills.entity.Bill;
import by.lashkevich.bills.entity.Client;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class BillsBankDao implements BankDao {
    private static final String BANK_INFO_FILE_NAME = "BankInfo.txt";
    private static final String INCORRECT_ID_MESSAGE = "Incorrect bank id(%d) was entered";
    private static final String BANK_SEPARATION_SIGN = "BankInfo";
    private static final String BILL_SEPARATION_SIGN = "BillsInfo";
    private static final String CLIENT_SEPARATION_SIGN = "ClientsInfo";
    private static final String SEPARATION_SIGN = "";
    private final FilePathFinder filePathFinder;
    private ClientDao clientDao;
    private BillDao billDao;

    public BillsBankDao() {
        filePathFinder = new FilePathFinder();
        clientDao = new BillsClientDao();
        billDao = new BillsBillDao();
    }

    @Override
    public Bank findBankById(long id) throws DaoException {
        try {
            Bank bank = new Bank();
            List<Bill> bills = new ArrayList<>();
            List<Client> clients = new ArrayList<>();
            List<String> banksData = Files.lines(Paths.get(filePathFinder.findInfoFilePath(BANK_INFO_FILE_NAME)))
                    .collect(Collectors.toList());
            Iterator bankIterator = banksData.iterator();
            boolean billsMarker;
            boolean clientMarker;
            while (bankIterator.hasNext()) {
                if (bankIterator.next().toString().equals(BANK_SEPARATION_SIGN)
                        && bankIterator.next().toString().equals(String.valueOf(id))) {
                    bank.setId(id);
                    bank.setName(bankIterator.next().toString());
                }

                if (bankIterator.hasNext() && bankIterator.next().toString().equals(BILL_SEPARATION_SIGN)) {
                    do {
                        String currentBillElement = bankIterator.next().toString();
                        billsMarker = !currentBillElement.equals(CLIENT_SEPARATION_SIGN);
                        if (billsMarker) {
                            bills.add(billDao.findBillById(Long.parseLong(currentBillElement)));
                        }
                    } while (billsMarker);
                }

                do {
                    String currentBillElement = bankIterator.next().toString();
                    clientMarker = !currentBillElement.equals(SEPARATION_SIGN);
                    if (clientMarker) {
                        clients.add(clientDao.findClientById(Long.parseLong(currentBillElement)));
                    }
                } while (clientMarker && bankIterator.hasNext());
            }

            if (bank.getId() == 0) {
                throw new DaoException(String.format(INCORRECT_ID_MESSAGE, id));
            }

            bank.setBills(bills);
            bank.setClients(clients);

            return bank;
        } catch (IOException e) {
            throw new DaoException(e.getMessage());
        }
    }
}
