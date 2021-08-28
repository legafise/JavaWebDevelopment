package by.lashkevich.bills.service;

import by.lashkevich.bills.entity.Bank;

/**
 * Interface that performs actions on things related to bank
 * @author Roman Lashkevich
 */
public interface BankService {
    Bank findBank() throws ServiceException;

    void saveBankData() throws ServiceException;
}
