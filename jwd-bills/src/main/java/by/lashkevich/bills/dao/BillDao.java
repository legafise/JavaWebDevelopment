package by.lashkevich.bills.dao;

import by.lashkevich.bills.entity.Bill;

import java.util.List;

/**
 * Interface for management bills data
 * @author Roman Lashkevich
 */
public interface BillDao {
    Bill findBillById(long id) throws DaoException;

    List<Bill> findAllBills() throws DaoException;

    boolean update(Bill bill);

    boolean addBill(Bill bill);

    boolean removeBill(long id);

    void writeBillsData() throws DaoException;
}
