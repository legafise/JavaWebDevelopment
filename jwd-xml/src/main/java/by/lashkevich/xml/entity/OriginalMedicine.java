package by.lashkevich.xml.entity;

import java.util.List;
import java.util.Objects;

public class OriginalMedicine extends Medicine {
    private List<String> analogs;

    public OriginalMedicine(String id, String group, String name, String pharmaceuticalCompanyName,
                            List<MedicineVersion> versions, List<String> analogs) {
        super(id, group, name, pharmaceuticalCompanyName, versions);
        this.analogs = analogs;
    }

    public OriginalMedicine() {
    }

    public List<String> getAnalogs() {
        return analogs;
    }

    public void setAnalogs(List<String> analogs) {
        this.analogs = analogs;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        OriginalMedicine that = (OriginalMedicine) o;
        return Objects.equals(analogs, that.analogs);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), analogs);
    }

    @Override
    public String toString() {
        return "\nOriginalMedicine{" +
                "id='" + super.getId() + '\'' +
                ", group='" + super.getGroup() + '\'' +
                ", name='" + super.getName() + '\'' +
                ", pharmaceuticalCompanyName='" + super.getPharmaceuticalCompanyName() + '\'' +
                ", versions=" + super.getVersions() + '\'' +
                ", analogs=" + analogs +
                '}';
    }
}
