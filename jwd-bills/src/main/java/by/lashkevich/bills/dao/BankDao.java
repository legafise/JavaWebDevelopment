package by.lashkevich.bills.dao;

import by.lashkevich.bills.entity.Bank;
import by.lashkevich.bills.entity.Client;

public interface BankDao {
    Bank findBank() throws DaoException;

    boolean addClient(Client client) throws DaoException;

    boolean removeClient(long clientId) throws DaoException;
}
