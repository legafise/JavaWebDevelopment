package by.lashkevich.bills.service;

import by.lashkevich.bills.entity.Client;

/**
 * Class that validates objects
 * @author RomalLashkevich
 */
public class ServiceValidator {
    public boolean isValidClient(Client client) {
        return client != null && isValidId(client.getId()) && isValidName(client.getName())
                && isValidSurname(client.getSurname()) && isValidAge(client.getAge());
    }

    private boolean isValidId(long id) {
        return id > 0;
    }

    private boolean isValidName(String name) {
        return name != null && name.length() > 1;
    }

    private boolean isValidSurname(String name) {
        return name != null && name.length() > 1;
    }

    private boolean isValidAge(int age) {
        return age >= 12;
    }
}
