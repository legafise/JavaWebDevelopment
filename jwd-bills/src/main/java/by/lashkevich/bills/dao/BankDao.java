package by.lashkevich.bills.dao;

import by.lashkevich.bills.entity.Bank;

public interface BankDao {
    Bank findBank() throws DaoException;
}
