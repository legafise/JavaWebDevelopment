package by.lashkevich.bills.service;

import by.lashkevich.bills.entity.Bank;

public interface BankService {
    Bank findBank() throws ServiceException;
}
