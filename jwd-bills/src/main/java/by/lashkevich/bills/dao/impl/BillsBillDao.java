package by.lashkevich.bills.dao.impl;

import by.lashkevich.bills.dao.BillDao;
import by.lashkevich.bills.dao.DaoException;
import by.lashkevich.bills.dao.FilePathFinder;
import by.lashkevich.bills.entity.Bill;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class BillsBillDao implements BillDao {
    private static final String BILL_INFO_FILE_NAME = "BillsInfo.txt";
    private static final String BILL_SEPARATION_SIGN = "BillInfo";
    private static final String INCORRECT_ID_MESSAGE = "Incorrect bill id(%d) was entered";
    private final FilePathFinder filePathFinder;

    public BillsBillDao() {
        filePathFinder = new FilePathFinder();
    }

    @Override
    public Bill findBillById(long id) throws DaoException {
        try {
            Bill bill = new Bill();
            List<String> billData = Files.lines(Paths.get(filePathFinder.findInfoFilePath(BILL_INFO_FILE_NAME)))
                    .collect(Collectors.toList());
            Iterator billIterator = billData.iterator();
            while (billIterator.hasNext()) {
                if (billIterator.next().toString().equals(BILL_SEPARATION_SIGN)
                        && billIterator.next().toString().equals(String.valueOf(id))) {
                    bill.setId(id);
                    bill.setBalance(new BigDecimal(billIterator.next().toString()));
                    bill.setBlocked(Boolean.parseBoolean(billIterator.next().toString()));
                }
            }

            if (bill.getId() == 0) {
                throw new DaoException(String.format(INCORRECT_ID_MESSAGE, id));
            }

            return bill;
        } catch (IOException e) {
            throw new DaoException(e.getMessage());
        }
    }
}
