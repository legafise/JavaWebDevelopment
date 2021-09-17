package by.lashkevich.figures.service;

import by.lashkevich.figures.entity.Bank;

/**
 * Interface that performs actions on things related to bank
 * @author Roman Lashkevich
 */
public interface BankService {
    Bank findBank() throws ServiceException;

    void saveBankData() throws ServiceException;
}
