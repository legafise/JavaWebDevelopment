package by.lashkevich.bills.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Client {
    private long id;
    private String name;
    private String surname;
    private int age;
    private List<Bill> bills;

    public Client() {
    }

    public Client(long id, String name, String surname, int age, List<Bill> bills) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.bills = bills;
    }

    public Client(long id, String name, String surname, int age) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.bills = new ArrayList<>();
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

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
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
        Client client = (Client) o;
        return id == client.id &&
                age == client.age &&
                Objects.equals(name, client.name) &&
                Objects.equals(surname, client.surname) &&
                Objects.equals(bills, client.bills);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, surname, age, bills);
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + age +
                ", bills=" + bills +
                '}';
    }
}
