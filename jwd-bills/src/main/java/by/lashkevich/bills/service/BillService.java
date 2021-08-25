package by.lashkevich.bills.service;

import by.lashkevich.bills.entity.Bill;

import java.util.List;

public interface BillService {
    Bill findBillById(String id) throws ServiceException;

    List<Bill> balanceDescendingOrderSort() throws ServiceException;
}
