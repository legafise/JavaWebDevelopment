package by.lashkevich.bills.service.impl;

import by.lashkevich.bills.dao.DaoException;
import by.lashkevich.bills.dao.DaoFactory;
import by.lashkevich.bills.entity.Bill;
import by.lashkevich.bills.service.BillService;
import by.lashkevich.bills.service.ServiceDuplicationChecker;
import by.lashkevich.bills.service.ServiceException;

import java.math.BigDecimal;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * @author Roman Lashkevich
 * @see BillService
 */
public class BillsBillService implements BillService {
    private static final String INCORRECT_RANGE_ERROR_MESSAGE = "Incorrect range vas entered";
    private final ServiceDuplicationChecker serviceDuplicationChecker;

    public BillsBillService() {
        serviceDuplicationChecker = new ServiceDuplicationChecker();
    }

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
            Comparator<Bill> billComparator = (firstBill, secondBill) -> -1 * firstBill.getBalance()
                    .compareTo(secondBill.getBalance());
            return DaoFactory.getInstance().getBillDao().findAllBills().stream()
                    .sorted(billComparator)
                    .collect(Collectors.toList());
        } catch (DaoException e) {
            throw new ServiceException(e.getMessage());
        }
    }

    @Override
    public List<Bill> balanceAscendingOrderSort() throws ServiceException {
        try {
            Comparator<Bill> billComparator = Comparator.comparing(Bill::getBalance);
            return DaoFactory.getInstance().getBillDao().findAllBills().stream()
                    .sorted(billComparator)
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

            Predicate<Bill> billPredicate = (bill -> bill.getBalance().compareTo(bigDecimalFirstRangeElement) > 0
                    && bill.getBalance().compareTo(bigDecimalSecondRangeElement) < 0);
            Comparator<Bill> billComparator = Comparator.comparing(Bill::getBalance);
            return DaoFactory.getInstance().getBillDao().findAllBills().stream()
                    .filter(billPredicate)
                    .sorted(billComparator)
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
        } catch (DaoException | NumberFormatException e) {
            throw new ServiceException(e.getMessage());
        }
    }

    @Override
    public boolean changeBalance(String id, String balance) throws ServiceException {
        try {
            Bill bill = DaoFactory.getInstance().getBillDao().findBillById(Long.parseLong(id));
            bill.setBalance(new BigDecimal(balance));
            return DaoFactory.getInstance().getBillDao().update(bill);
        } catch (DaoException | NumberFormatException e) {
            throw new ServiceException(e.getMessage());
        }
    }

    @Override
    public boolean createBill(String id) throws ServiceException {
        try {
            Bill bill = new Bill(Long.parseLong(id));
            if (serviceDuplicationChecker.isDuplicateBill(bill)) {
                return false;
            }

            if (DaoFactory.getInstance().getBillDao().addBill(bill)
                    && DaoFactory.getInstance().getBankDao().addBill(bill)) {
                return true;
            }

            removeBill(id);
            return false;
        } catch (DaoException | NumberFormatException e) {
            throw new ServiceException(e.getMessage());
        }
    }

    @Override
    public boolean removeBill(String id) throws ServiceException {
        try {
            boolean bankDaoRemovingResult = DaoFactory.getInstance().getBankDao().removeBill(Long.parseLong(id));
            boolean clientDaoRemovingResult = DaoFactory.getInstance().getClientDao().removeBill(Long.parseLong(id));
            boolean billDaoRemovingResult = DaoFactory.getInstance().getBillDao().removeBill(Long.parseLong(id));
            return bankDaoRemovingResult || clientDaoRemovingResult || billDaoRemovingResult;
        } catch (DaoException | NumberFormatException e) {
            throw new ServiceException(e.getMessage());
        }
    }
}
