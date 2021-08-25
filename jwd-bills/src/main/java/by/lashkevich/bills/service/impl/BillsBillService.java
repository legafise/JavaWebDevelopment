package by.lashkevich.bills.service.impl;

import by.lashkevich.bills.dao.DaoException;
import by.lashkevich.bills.dao.DaoFactory;
import by.lashkevich.bills.entity.Bill;
import by.lashkevich.bills.service.BillService;
import by.lashkevich.bills.service.ServiceException;

import java.util.List;
import java.util.stream.Collectors;

public class BillsBillService implements BillService {
    @Override
    public Bill findBillById(String id) throws ServiceException {
        try {
            return DaoFactory.getInstance().getBillDao().findBillById(Long.parseLong(id));
        } catch (DaoException | NumberFormatException e) {
            throw new ServiceException(e.getMessage());
        }
    }

    @Override
    public List<Bill> balanceDescendingOrderSort() throws ServiceException {
        try {
            return DaoFactory.getInstance().getBillDao().findAllBills().stream()
                    .sorted((firstBill, secondBill) -> -1 * firstBill.getBalance().compareTo(secondBill.getBalance()))
                    .collect(Collectors.toList());
        } catch (DaoException e) {
            throw new ServiceException(e.getMessage());
        }
    }

    @Override
    public List<Bill> balanceAscendingOrderSort() throws ServiceException {
        try {
            return DaoFactory.getInstance().getBillDao().findAllBills().stream()
                    .sorted((firstBill, secondBill) -> firstBill.getBalance().compareTo(secondBill.getBalance()))
                    .collect(Collectors.toList());
        } catch (DaoException e) {
            throw new ServiceException(e.getMessage());
        }
    }
}
