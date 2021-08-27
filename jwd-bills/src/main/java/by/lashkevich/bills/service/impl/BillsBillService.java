package by.lashkevich.bills.service.impl;

import by.lashkevich.bills.dao.DaoException;
import by.lashkevich.bills.dao.DaoFactory;
import by.lashkevich.bills.entity.Bill;
import by.lashkevich.bills.service.BillService;
import by.lashkevich.bills.service.ServiceException;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

public class BillsBillService implements BillService {
    private static final String INCORRECT_RANGE_ERROR_MESSAGE = "Incorrect range vas entered";

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

    @Override
    public List<Bill> billsBalanceRangeSearch(String firstRangeElement,
                                              String secondRangeElement) throws ServiceException {
        try {
            BigDecimal bigDecimalFirstRangeElement = new BigDecimal(firstRangeElement);
            BigDecimal bigDecimalSecondRangeElement = new BigDecimal(secondRangeElement);
            if (bigDecimalFirstRangeElement.compareTo(bigDecimalSecondRangeElement) > 0) {
                throw new ServiceException(INCORRECT_RANGE_ERROR_MESSAGE);
            }

            return DaoFactory.getInstance().getBillDao().findAllBills().stream()
                    .filter(bill -> bill.getBalance().compareTo(bigDecimalFirstRangeElement) > 0
                            && bill.getBalance().compareTo(bigDecimalSecondRangeElement) < 0)
                    .sorted((firstBill, secondBill) -> firstBill.getBalance().compareTo(secondBill.getBalance()))
                    .collect(Collectors.toList());
        } catch (DaoException e) {
            throw new ServiceException(e.getMessage());
        }
    }

    @Override
    public boolean blockBillById(String id) throws ServiceException {
        try {
            Bill bill = DaoFactory.getInstance().getBillDao().findBillById(Long.parseLong(id));
            bill.setBlocked(true);
            return DaoFactory.getInstance().getBillDao().update(bill);
        } catch (DaoException | NumberFormatException e) {
            throw new ServiceException(e.getMessage());
        }
    }

    @Override
    public boolean unblockBillById(String id) throws ServiceException {
        try {
            Bill bill = DaoFactory.getInstance().getBillDao().findBillById(Long.parseLong(id));
            bill.setBlocked(false);
            return DaoFactory.getInstance().getBillDao().update(bill);
        } catch (NumberFormatException e) {
            throw new ServiceException(e.getMessage());
        } catch (DaoException e) {
            return false;
        }
    }

    @Override
    public boolean changeBalance(String id, String balance) throws ServiceException {
        try {
            Bill bill = DaoFactory.getInstance().getBillDao().findBillById(Long.parseLong(id));
            bill.setBalance(new BigDecimal(balance));
            return DaoFactory.getInstance().getBillDao().update(bill);
        } catch (NumberFormatException e) {
            throw new ServiceException(e.getMessage());
        } catch (DaoException e) {
            return false;
        }
    }
}
