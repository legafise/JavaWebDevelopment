package by.lashkevich.bills.dao;

import by.lashkevich.bills.entity.Bank;

public interface BankDao {
    Bank findBankById(long id) throws DaoException;
}
