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
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @see BankDao
 * @author Roman Lashkevich
 */
public class BillsBankDao implements BankDao {
    private static final String BANK_INFO_FILE_NAME = "BankInfo.txt";
    private static final String BANK_SEPARATION_SIGN = "BankInfo";
    private static final String BILL_SEPARATION_SIGN = "BillsInfo";
    private static final String CLIENT_SEPARATION_SIGN = "ClientsInfo";
    private static final String SEPARATION_SIGN = "";
    private final FilePathFinder filePathFinder;
    private Bank bank;

    public BillsBankDao() throws DaoException {
        filePathFinder = new FilePathFinder();
        readBankData();
    }

    @Override
    public Bank findBank() {
        return bank;
    }

    @Override
    public boolean addClient(Client client) throws DaoException {
        return bank.getClients().add(client);
    }

    @Override
    public boolean addBill(Bill bill) {
        return bank.getBills().add(bill);
    }

    @Override
    public boolean removeClient(long clientId) throws DaoException {
        Optional<Client> removingClientOptional = bank.getClients().stream()
                .filter(client -> client.getId() == clientId)
                .findAny();
        return removingClientOptional.isPresent() && bank.getClients().remove(removingClientOptional.get());
    }

    @Override
    public boolean removeBill(long billId) throws DaoException {
        Optional<Bill> removingBillOptional = bank.getBills().stream()
                .filter(bill -> bill.getId() == billId)
                .findAny();
        return removingBillOptional.isPresent() && bank.getBills().remove(removingBillOptional.get());
    }

    private void readBankData() throws DaoException {
        try {
            long id = 1;
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
                            bills.add(DaoFactory.getInstance()
                                    .getBillDao().findBillById(Long.parseLong(currentBillElement)));
                        }
                    } while (billsMarker);
                }

                do {
                    String currentBillElement = bankIterator.next().toString();
                    clientMarker = !currentBillElement.equals(SEPARATION_SIGN);
                    if (clientMarker) {
                        clients.add(DaoFactory.getInstance()
                                .getClientDao().findClientById(Long.parseLong(currentBillElement)));
                    }
                } while (clientMarker && bankIterator.hasNext());
            }

            bank.setBills(bills);
            bank.setClients(clients);

            this.bank = bank;
        } catch (IOException e) {
            throw new DaoException(e.getMessage());
        }
    }
}
