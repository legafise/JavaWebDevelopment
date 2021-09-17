package by.lashkevich.figures.dao;

import by.lashkevich.figures.entity.Client;

import java.util.List;

/**
 * Interface for management client data
 * @author Roman Lashkevich
 */
public interface ClientDao {
    Client findClientById(long id) throws DaoException;

    List<Client> findAllClients() throws DaoException;

    boolean addClient(Client client) throws DaoException;

    boolean removeClient(long id) throws DaoException;

    boolean removeBill(long id) throws DaoException;

    void writeClientsData() throws DaoException;
}
