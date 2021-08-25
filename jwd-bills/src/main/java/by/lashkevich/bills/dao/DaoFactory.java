package by.lashkevich.bills.dao;

import by.lashkevich.bills.dao.impl.BillsBankDao;
import by.lashkevich.bills.dao.impl.BillsBillDao;
import by.lashkevich.bills.dao.impl.BillsClientDao;

public class DaoFactory {
    private static final DaoFactory instance = new DaoFactory();
    private final ClientDao clientDao;
    private final BillDao billDao;
    private BankDao bankDao;
    private boolean isBankDaraRead = false;

    private DaoFactory() {
        clientDao = new BillsClientDao();
        billDao = new BillsBillDao();
    }

    public static DaoFactory getInstance() {
        return instance;
    }

    public ClientDao getClientDao() {
        return clientDao;
    }

    public BillDao getBillDao() {
        return billDao;
    }

    public BankDao getBankDao() {
        if (!isBankDaraRead) {
            bankDao = new BillsBankDao();
            isBankDaraRead = true;
        }

        return bankDao;
    }
}
