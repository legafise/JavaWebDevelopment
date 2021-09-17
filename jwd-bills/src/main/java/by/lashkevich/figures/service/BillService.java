package by.lashkevich.figures.service;

import by.lashkevich.figures.entity.Bill;

import java.util.List;

/**
 * Interface that performs actions on things related to bills
 * @author Roman Lashkevich
 */
public interface BillService {
    Bill findBillById(String id) throws ServiceException;

    List<Bill> balanceDescendingOrderSort() throws ServiceException;

    List<Bill> balanceAscendingOrderSort() throws ServiceException;

    List<Bill> billsBalanceRangeSearch(String firstRangeElement, String secondRangeElement) throws ServiceException;

    boolean blockBillById(String id) throws ServiceException;

    boolean unblockBillById(String id) throws ServiceException;

    boolean changeBalance(String id, String balance) throws ServiceException;

    boolean createBill(String id) throws ServiceException;

    boolean removeBill(String id) throws ServiceException;
}
