package by.lashkevich.bills.dao.impl;

import by.lashkevich.bills.dao.BillDao;
import by.lashkevich.bills.dao.DaoException;
import by.lashkevich.bills.dao.FilePathFinder;
import by.lashkevich.bills.entity.Bill;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class BillsBillDao implements BillDao {
    private static final String BILL_INFO_FILE_NAME = "BillsInfo.txt";
    private static final String BILL_SEPARATION_SIGN = "BillInfo";
    private static final String INCORRECT_ID_MESSAGE = "Incorrect bill id(%d) was entered";
    private final FilePathFinder filePathFinder;
    private List<Bill> bills;

    public BillsBillDao() throws DaoException {
        filePathFinder = new FilePathFinder();
        readBillsData();
    }

    @Override
    public Bill findBillById(long id) throws DaoException {
        return bills.stream()
                .filter(bill -> bill.getId() == id)
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
                bills.set(i, bill);
                return true;
            }
        }

        return false;
    }

    private void readBillsData() throws DaoException {
        try {
            List<Bill> bills = new ArrayList<>();
            List<String> billData = Files.lines(Paths.get(filePathFinder.findInfoFilePath(BILL_INFO_FILE_NAME)))
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
