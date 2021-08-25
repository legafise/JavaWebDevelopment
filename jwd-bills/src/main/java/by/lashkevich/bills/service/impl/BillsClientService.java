package by.lashkevich.bills.service.impl;

import by.lashkevich.bills.dao.DaoException;
import by.lashkevich.bills.dao.DaoFactory;
import by.lashkevich.bills.entity.Bill;
import by.lashkevich.bills.entity.Client;
import by.lashkevich.bills.service.ClientService;
import by.lashkevich.bills.service.ServiceException;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class BillsClientService implements ClientService {
    @Override
    public Client findClientById(String id) throws ServiceException {
        try {
            return DaoFactory.getInstance().getClientDao().findClientById(Long.parseLong(id));
        } catch (DaoException | NumberFormatException e) {
            throw new ServiceException(e.getMessage());
        }
    }

    @Override
    public BigDecimal calculateTotalClientBillsAmount(String id) throws ServiceException {
        try {
            Client client = DaoFactory.getInstance().getClientDao().findClientById(Long.parseLong(id));
            List<Bill> bills = client.getBillIds().stream()
                    .map(billId -> DaoFactory.getInstance().getBillDao().findBillById(billId))
                    .collect(Collectors.toList());

            BigDecimal totalBalance = new BigDecimal("0");
            for (Bill bill : bills) {
                totalBalance = totalBalance.add(bill.getBalance());
            }

            return totalBalance;
        } catch (DaoException | NumberFormatException e) {
            throw new ServiceException(e.getMessage());
        }
    }

    @Override
    public BigDecimal calculateTotalClientPositiveBillsAmount(String id) throws ServiceException {
        try {
            Client client = DaoFactory.getInstance().getClientDao().findClientById(Long.parseLong(id));
            List<Bill> bills = client.getBillIds().stream()
                    .map(billId -> DaoFactory.getInstance().getBillDao().findBillById(billId))
                    .collect(Collectors.toList());

            BigDecimal totalPositiveBalance = new BigDecimal("0");
            for (Bill bill : bills) {
                if (bill.getBalance().compareTo(new BigDecimal("0")) > 0) {
                    totalPositiveBalance = totalPositiveBalance.add(bill.getBalance());
                }
            }

            return totalPositiveBalance;
        } catch (DaoException | NumberFormatException e) {
            throw new ServiceException(e.getMessage());
        }
    }

    @Override
    public BigDecimal calculateTotalClientNegativeBillsAmount(String id) throws ServiceException {
        try {
            Client client = DaoFactory.getInstance().getClientDao().findClientById(Long.parseLong(id));
            List<Bill> bills = client.getBillIds().stream()
                    .map(billId -> DaoFactory.getInstance().getBillDao().findBillById(billId))
                    .collect(Collectors.toList());

            BigDecimal totalPositiveBalance = new BigDecimal("0");
            for (Bill bill : bills) {
                if (bill.getBalance().compareTo(new BigDecimal("0")) < 0) {
                    totalPositiveBalance = totalPositiveBalance.add(bill.getBalance());
                }
            }

            return totalPositiveBalance;
        } catch (DaoException | NumberFormatException e) {
            throw new ServiceException(e.getMessage());
        }
    }
}
