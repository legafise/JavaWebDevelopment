package by.lashkevich.bills.entity;

import java.util.List;
import java.util.Objects;

public class Bank {
    private long id;
    private String name;
    private List<Client> clients;
    private List<Bill> bills;

    public Bank() {
    }

    public Bank(long id, String name, List<Client> clients, List<Bill> bills) {
        this.id = id;
        this.name = name;
        this.clients = clients;
        this.bills = bills;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Client> getClients() {
        return clients;
    }

    public void setClients(List<Client> clients) {
        this.clients = clients;
    }

    public List<Bill> getBills() {
        return bills;
    }

    public void setBills(List<Bill> bills) {
        this.bills = bills;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bank bank = (Bank) o;
        return id == bank.id &&
                Objects.equals(name, bank.name) &&
                Objects.equals(clients, bank.clients) &&
                Objects.equals(bills, bank.bills);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, clients, bills);
    }

    @Override
    public String toString() {
        return "Bank{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", clients=" + clients +
                ", bills=" + bills +
                '}';
    }
}
