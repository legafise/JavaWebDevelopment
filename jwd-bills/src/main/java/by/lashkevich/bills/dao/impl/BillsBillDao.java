package by.lashkevich.bills.dao.impl;

import by.lashkevich.bills.dao.BillDao;
import by.lashkevich.bills.dao.DaoException;
import by.lashkevich.bills.dao.FileFinder;
import by.lashkevich.bills.entity.Bill;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * @author Roman Lashkevich
 * @see BillDao
 */
public class BillsBillDao implements BillDao {
    private static final String BILL_INFO_FILE_NAME = "BillsInfo.txt";
    private static final String BILL_SEPARATION_SIGN = "BillInfo";
    private static final String INCORRECT_ID_MESSAGE = "Incorrect bill id(%d) was entered";
    private static final String SAVING_BILL_INFO_FILE_PATH = "jwd-bills/src/main/resources/info/BillsInfo.txt";
    private static final String NEW_LINE_BREAK = "\n";
    private final FileFinder fileFinder;
    private List<Bill> bills;

    public BillsBillDao() throws DaoException {
        fileFinder = new FileFinder();
        readBillsData();
    }

    @Override
    public Bill findBillById(long id) throws DaoException {
        Predicate<Bill> billPredicate = bill -> bill.getId() == id;
        return bills.stream()
                .filter(billPredicate)
                .findFirst()
                .orElseThrow(() -> new DaoException(String.format(INCORRECT_ID_MESSAGE, id)));
    }

    @Override
    public List<Bill> findAllBills() throws DaoException {
        return bills;
    }

    @Override
    public boolean update(Bill bill) {
        for (int i = 0; i < bills.size(); i++) {
            if (bills.get(i).getId() == bill.getId()) {
                bills.get(i).setBalance(bill.getBalance());
                bills.get(i).setBlocked(bill.isBlocked());
                return true;
            }
        }

        return false;
    }

    @Override
    public boolean addBill(Bill bill) {
        return bills.add(bill);
    }

    @Override
    public boolean removeBill(long id) {
        Predicate<Bill> billPredicate = bill -> bill.getId() == id;
        Optional<Bill> removingBillOptional = bills.stream()
                .filter(billPredicate)
                .findAny();
        return removingBillOptional.isPresent() && bills.remove(removingBillOptional.get());
    }

    @Override
    public void writeBillsData() throws DaoException {
        File billsInfoFile = new File(SAVING_BILL_INFO_FILE_PATH);

        try (PrintWriter printWriter = new PrintWriter(billsInfoFile)) {
            for (Bill bill : bills) {
                printWriter.write("BillInfo" + NEW_LINE_BREAK);
                printWriter.write(bill.getId() + NEW_LINE_BREAK);
                printWriter.write(bill.getBalance() + NEW_LINE_BREAK);
                printWriter.write(bill.isBlocked() + NEW_LINE_BREAK);
            }
        } catch (FileNotFoundException e) {
            throw new DaoException(e);
        }
    }

    private void readBillsData() throws DaoException {
        try {
            List<Bill> bills = new ArrayList<>();
            List<String> billData = Files.lines(Paths.get(fileFinder.findInfoFilePath(BILL_INFO_FILE_NAME)))
                    .collect(Collectors.toList());
            Iterator billIterator = billData.iterator();
            while (billIterator.hasNext()) {
                if (billIterator.next().toString().equals(BILL_SEPARATION_SIGN)) {
                    Bill bill = new Bill();
                    bill.setId(Long.parseLong(billIterator.next().toString()));
                    bill.setBalance(new BigDecimal(billIterator.next().toString()));
                    bill.setBlocked(Boolean.parseBoolean(billIterator.next().toString()));
                    bills.add(bill);
                }
            }

            this.bills = bills;
        } catch (IOException e) {
            throw new DaoException(e.getMessage());
        }
    }
}
