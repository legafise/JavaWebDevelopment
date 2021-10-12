package by.lashkevich.xml.entity;

import java.util.List;
import java.util.Objects;

public class Analog extends Medicine {
    private double efficiency;
    private String titleOfOriginal;

    public Analog(String id, String group, String name, String pharmaceuticalCompanyName,
                  List<MedicineVersion> versions, double efficiency, String titleOfOriginal) {
        super(id, group, name, pharmaceuticalCompanyName, versions);
        this.efficiency = efficiency;
        this.titleOfOriginal = titleOfOriginal;
    }

    public Analog() {
    }

    public double getEfficiency() {
        return efficiency;
    }

    public void setEfficiency(double efficiency) {
        this.efficiency = efficiency;
    }

    public String getTitleOfOriginal() {
        return titleOfOriginal;
    }

    public void setTitleOfOriginal(String titleOfOriginal) {
        this.titleOfOriginal = titleOfOriginal;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Analog analog = (Analog) o;
        return Double.compare(analog.efficiency, efficiency) == 0 &&
                Objects.equals(titleOfOriginal, analog.titleOfOriginal);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), efficiency, titleOfOriginal);
    }

    @Override
    public String toString() {
        return "\nAnalog{" +
                "id='" + super.getId() + '\'' +
                ", group='" + super.getGroup() + '\'' +
                ", name='" + super.getName() + '\'' +
                ", pharmaceuticalCompanyName='" + super.getPharmaceuticalCompanyName() + '\'' +
                ", versions=" + super.getVersions() + '\'' +
                ", efficiency=" + efficiency + "%" + '\'' +
                ", titleOfOriginal='" + titleOfOriginal + "'"+
                '}';
    }
}
