package by.lashkevich.figures.dao;

import by.lashkevich.figures.entity.Bank;
import by.lashkevich.figures.entity.Bill;
import by.lashkevich.figures.entity.Client;

/**
 * Interface for management bank data
 * @author Roman Lashkevich
 */
public interface BankDao {
    Bank findBank() throws DaoException;

    boolean addClient(Client client) throws DaoException;

    boolean addBill(Bill bill);

    boolean removeClient(long clientId) throws DaoException;

    boolean removeBill(long billId) throws DaoException;

    void writeBankData() throws DaoException;
}
