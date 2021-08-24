package by.lashkevich.bills.dao;

import by.lashkevich.bills.entity.Bill;

public interface BillDao {
    Bill findBillById(long id) throws DaoException;
}
