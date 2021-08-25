package by.lashkevich.bills.dao;

import by.lashkevich.bills.entity.Bill;

import java.util.List;

public interface BillDao {
    Bill findBillById(long id) throws DaoException;

    List<Bill> findAllBills() throws DaoException;
}
