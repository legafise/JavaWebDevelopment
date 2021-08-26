package by.lashkevich.bills.service;

import by.lashkevich.bills.service.impl.BillsBankService;
import by.lashkevich.bills.service.impl.BillsBillService;
import by.lashkevich.bills.service.impl.BillsClientService;

public class ServiceFactory {
    private static final ServiceFactory instance = new ServiceFactory();
    private final ClientService clientService;
    private final BillService billService;
    private final BankService bankService;

    private ServiceFactory(){
        clientService = new BillsClientService();
        billService = new BillsBillService();
        bankService = new BillsBankService();
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

    public BankService getBankService(){
        return bankService;
    }
}
