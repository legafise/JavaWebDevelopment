package by.lashkevich.bills.service;

import by.lashkevich.bills.entity.Bill;

import java.util.List;

public interface BillService {
    Bill findBillById(String id) throws ServiceException;

    List<Bill> balanceDescendingOrderSort() throws ServiceException;

    List<Bill> balanceAscendingOrderSort() throws ServiceException;

    List<Bill> billsBalanceRangeSearch(String firstRangeElement, String secondRangeElement) throws ServiceException;

    boolean blockBillById(String id) throws ServiceException;

    boolean unblockBillById(String id) throws ServiceException;
}
