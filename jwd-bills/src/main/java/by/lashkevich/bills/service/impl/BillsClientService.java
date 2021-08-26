package by.lashkevich.bills.service.impl;

import by.lashkevich.bills.dao.DaoException;
import by.lashkevich.bills.dao.DaoFactory;
import by.lashkevich.bills.entity.Bill;
import by.lashkevich.bills.entity.Client;
import by.lashkevich.bills.service.ClientService;
import by.lashkevich.bills.service.ServiceDuplicationChecker;
import by.lashkevich.bills.service.ServiceException;
import by.lashkevich.bills.service.ServiceValidator;

import java.math.BigDecimal;

public class BillsClientService implements ClientService {
    private final ServiceValidator serviceValidator;
    private final ServiceDuplicationChecker serviceDuplicationChecker;

    public BillsClientService() {
        serviceValidator = new ServiceValidator();
        serviceDuplicationChecker = new ServiceDuplicationChecker();
    }

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
            BigDecimal totalBalance = new BigDecimal("0");
            for (Bill bill : client.getBills()) {
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
            BigDecimal totalPositiveBalance = new BigDecimal("0");
            for (Bill bill : client.getBills()) {
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
            BigDecimal totalPositiveBalance = new BigDecimal("0");
            for (Bill bill : client.getBills()) {
                if (bill.getBalance().compareTo(new BigDecimal("0")) < 0) {
                    totalPositiveBalance = totalPositiveBalance.add(bill.getBalance());
                }
            }

            return totalPositiveBalance;
        } catch (DaoException | NumberFormatException e) {
            throw new ServiceException(e.getMessage());
        }
    }

    @Override
    public boolean createClient(long id, String name, String surname, int age) throws ServiceException {
        try {
            Client client = new Client(id, name, surname, age);
            if (!serviceValidator.isValidClient(client) || serviceDuplicationChecker.isDuplicateClient(client)) {
                return false;
            }

            if (DaoFactory.getInstance().getClientDao().addClient(client)
                    && DaoFactory.getInstance().getBankDao().addClient(client)) {
                return true;
            }

            removeClient(id);
            return false;
        } catch (DaoException e) {
            throw new ServiceException(e.getMessage());
        }
    }

    @Override
    public boolean removeClient(long id) throws ServiceException {
        try {
            boolean bankDaoRemovingResult = DaoFactory.getInstance().getBankDao().removeClient(id);
            boolean clientDaoRemovingResult = DaoFactory.getInstance().getClientDao().removeClient(id);
            return bankDaoRemovingResult || clientDaoRemovingResult;
        } catch (DaoException e) {
            throw new ServiceException(e.getMessage());
        }
    }
}
