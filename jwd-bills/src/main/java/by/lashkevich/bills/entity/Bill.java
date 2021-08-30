package by.lashkevich.bills.entity;

import java.math.BigDecimal;
import java.util.Objects;

/**
 * Class created to work within a job with bills
 * @author RomalLashkevich
 */
public class Bill {
    private static final String STANDARD_BILL_BALANCE = "0.0";
    private long id;
    private BigDecimal balance;
    private boolean isBlocked;

    public Bill() {
    }

    public Bill(long id) {
        this.id = id;
        this.balance = new BigDecimal(STANDARD_BILL_BALANCE);
        this.isBlocked = false;
    }

    public Bill(long id, BigDecimal balance, boolean isBlocked) {
        this.id = id;
        this.balance = balance;
        this.isBlocked = isBlocked;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public boolean isBlocked() {
        return isBlocked;
    }

    public void setBlocked(boolean blocked) {
        isBlocked = blocked;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bill bill = (Bill) o;
        return id == bill.id &&
                isBlocked == bill.isBlocked &&
                Objects.equals(balance, bill.balance);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, balance, isBlocked);
    }

    @Override
    public String toString() {
        return "Bill{" +
                "id=" + id +
                ", balance=" + balance + "$" +
                ", isBlocked=" + isBlocked +
                '}';
    }
}
