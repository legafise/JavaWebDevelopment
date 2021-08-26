package by.lashkevich.bills.dao;

import by.lashkevich.bills.dao.impl.BillsBankDao;
import by.lashkevich.bills.dao.impl.BillsBillDao;
import by.lashkevich.bills.dao.impl.BillsClientDao;

public class DaoFactory {
    private static final DaoFactory instance = new DaoFactory();
    private final BillDao billDao;
    private ClientDao clientDao;
    private BankDao bankDao;
    private boolean isBankDataRead = false;
    private boolean isUserDataRead = false;

    private DaoFactory() {
        billDao = new BillsBillDao();
    }

    public static DaoFactory getInstance() {
        return instance;
    }

    public BillDao getBillDao() {
        return billDao;
    }

    public ClientDao getClientDao() {
        if (!isUserDataRead) {
            clientDao = new BillsClientDao();
            isUserDataRead = true;
        }

        return clientDao;
    }

    public BankDao getBankDao() {
        if (!isBankDataRead) {
            bankDao = new BillsBankDao();
            isBankDataRead = true;
        }

        return bankDao;
    }
}
