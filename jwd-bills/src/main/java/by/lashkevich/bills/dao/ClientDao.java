package by.lashkevich.bills.dao;

import by.lashkevich.bills.entity.Client;

import java.util.List;

public interface ClientDao {
    Client findClientById(long id) throws DaoException;

    List<Client> findAllClients() throws DaoException;

    boolean addClient(Client client) throws DaoException;

    boolean removeClient(long id) throws DaoException;
}
