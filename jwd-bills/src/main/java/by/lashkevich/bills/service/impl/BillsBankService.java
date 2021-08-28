package by.lashkevich.bills.service.impl;

import by.lashkevich.bills.dao.DaoException;
import by.lashkevich.bills.dao.DaoFactory;
import by.lashkevich.bills.entity.Bank;
import by.lashkevich.bills.service.BankService;
import by.lashkevich.bills.service.ServiceException;

/**
 * @author Roman Lashkevich
 * @see BankService
 */
public class BillsBankService implements BankService {
    @Override
    public Bank findBank() throws ServiceException {
        try {
            return DaoFactory.getInstance().getBankDao().findBank();
        } catch (DaoException e) {
            throw new ServiceException(e.getMessage());
        }
    }

    @Override
    public void saveBankData() throws ServiceException {
        try {
            DaoFactory.getInstance().getBankDao().writeBankData();
            DaoFactory.getInstance().getClientDao().writeClientsData();
            DaoFactory.getInstance().getBillDao().writeBillsData();
        } catch (DaoException e) {
            throw new ServiceException(e.getMessage());
        }
    }
}
