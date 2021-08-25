package by.lashkevich.bills.service;

import by.lashkevich.bills.service.impl.BillsClientService;

public class ServiceFactory {
    private static final ServiceFactory instance = new ServiceFactory();
    private final ClientService clientService;

    private ServiceFactory(){
        clientService = new BillsClientService();
    }

    public static ServiceFactory getInstance(){
        return instance;
    }
    public ClientService getClientService(){
        return clientService;
    }
}
