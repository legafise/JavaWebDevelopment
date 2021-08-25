package by.lashkevich.bills.service;

import by.lashkevich.bills.service.impl.BillsBillService;
import by.lashkevich.bills.service.impl.BillsClientService;

public class ServiceFactory {
    private static final ServiceFactory instance = new ServiceFactory();
    private final ClientService clientService;
    private final BillService billService;

    private ServiceFactory(){
        clientService = new BillsClientService();
        billService = new BillsBillService();
    }

    public static ServiceFactory getInstance(){
        return instance;
    }
    public ClientService getClientService(){
        return clientService;
    }

    public BillService getBillService(){
        return billService;
    }
}
