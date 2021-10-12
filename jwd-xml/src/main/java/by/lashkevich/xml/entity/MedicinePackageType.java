package by.lashkevich.xml.entity;

import java.util.Objects;

public class MedicinePackageType {
    private String packageType;
    private String amount;
    private double price;

    public MedicinePackageType(String packageType, String amount, double price) {
        this.packageType = packageType;
        this.amount = amount;
        this.price = price;
    }

    public MedicinePackageType() {
    }

    public String getPackageType() {
        return packageType;
    }

    public void setPackageType(String packageType) {
        this.packageType = packageType;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MedicinePackageType that = (MedicinePackageType) o;
        return Double.compare(that.price, price) == 0 &&
                Objects.equals(packageType, that.packageType) &&
                Objects.equals(amount, that.amount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(packageType, amount, price);
    }

    @Override
    public String toString() {
        return "MedicinePackageType{" +
                "packageType='" + packageType + '\'' +
                ", amount='" + amount + '\'' +
                ", price=" + price +
                '}';
    }
}
