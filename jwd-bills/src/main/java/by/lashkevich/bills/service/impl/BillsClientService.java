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
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * @author Roman Lashkevich
 * @see ClientService
 */
public class BillsClientService implements ClientService {
    private static final String STANDARD_BALANCE_VALUE = "0.0";
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
            BigDecimal totalBalance = new BigDecimal(STANDARD_BALANCE_VALUE);
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
            BigDecimal totalPositiveBalance = new BigDecimal(STANDARD_BALANCE_VALUE);
            for (Bill bill : client.getBills()) {
                if (bill.getBalance().compareTo(new BigDecimal(STANDARD_BALANCE_VALUE)) > 0) {
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
            BigDecimal totalPositiveBalance = new BigDecimal(STANDARD_BALANCE_VALUE);
            for (Bill bill : client.getBills()) {
                if (bill.getBalance().compareTo(new BigDecimal(STANDARD_BALANCE_VALUE)) < 0) {
                    totalPositiveBalance = totalPositiveBalance.add(bill.getBalance());
                }
            }

            return totalPositiveBalance;
        } catch (DaoException | NumberFormatException e) {
            throw new ServiceException(e.getMessage());
        }
    }

    @Override
    public boolean createClient(String id, String name, String surname, String age) throws ServiceException {
        try {
            Client client = new Client(Long.parseLong(id), name, surname, Integer.parseInt(age));
            if (!serviceValidator.isValidClient(client) || serviceDuplicationChecker.isDuplicateClient(client)) {
                return false;
            }

            if (DaoFactory.getInstance().getClientDao().addClient(client)
                    && DaoFactory.getInstance().getBankDao().addClient(client)) {
                return true;
            }

            removeClient(id);
            return false;
        } catch (DaoException | NumberFormatException e) {
            throw new ServiceException(e.getMessage());
        }
    }

    @Override
    public boolean removeClient(String id) throws ServiceException {
        try {
            boolean bankDaoRemovingResult = DaoFactory.getInstance().getBankDao().removeClient(Long.parseLong(id));
            boolean clientDaoRemovingResult = DaoFactory.getInstance().getClientDao().removeClient(Long.parseLong(id));
            return bankDaoRemovingResult || clientDaoRemovingResult;
        } catch (DaoException | NumberFormatException e) {
            throw new ServiceException(e.getMessage());
        }
    }

    @Override
    public boolean assignBill(String clientId, String billId) throws ServiceException {
        try {
            Predicate<Bill> billPredicate = bill -> bill.getId() == Long.parseLong(billId);
            Optional<Bill> isExistBill = DaoFactory.getInstance().getClientDao()
                    .findClientById(Long.parseLong(clientId)).getBills().stream()
                    .filter(billPredicate).findAny();

            if (isExistBill.isPresent()) {
                return false;
            }

            return DaoFactory.getInstance().getClientDao()
                    .findClientById(Long.parseLong(clientId)).getBills().add(DaoFactory.getInstance()
                            .getBillDao().findBillById(Long.parseLong(billId)));
        } catch (DaoException | NumberFormatException e) {
            throw new ServiceException(e.getMessage());
        }
    }

    @Override
    public boolean removeClientBill(String clientId, String billId) throws ServiceException {
        try {
            return DaoFactory.getInstance().getClientDao()
                    .findClientById(Long.parseLong(clientId)).getBills().remove(DaoFactory.getInstance()
                            .getBillDao().findBillById(Long.parseLong(billId)));
        } catch (DaoException | NumberFormatException e) {
            throw new ServiceException(e.getMessage());
        }
    }
}
