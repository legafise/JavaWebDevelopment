package by.lashkevich.bills.service;

import by.lashkevich.bills.entity.Client;

import java.math.BigDecimal;

public interface ClientService {
    Client findClientById(String id) throws ServiceException;

    BigDecimal calculateTotalClientBillsAmount(String id) throws ServiceException;

    BigDecimal calculateTotalClientPositiveBillsAmount(String id) throws ServiceException;

    BigDecimal calculateTotalClientNegativeBillsAmount(String id) throws ServiceException;

    boolean createClient(String id, String name, String surname, String age) throws ServiceException;

    boolean removeClient(String id) throws ServiceException;

    boolean assignBill(String userId, String billId) throws ServiceException;

    boolean removeClientBill(String clientId, String billId) throws ServiceException;
}
