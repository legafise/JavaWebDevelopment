package by.lashkevich.bills.dao;

import by.lashkevich.bills.entity.Client;

public interface ClientDao {
    Client findClientById(long id) throws DaoException;
}
