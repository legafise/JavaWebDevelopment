package by.lashkevich.xml.entity;

import java.util.List;
import java.util.Objects;

public abstract class Medicine {
    private String id;
    private String group;
    private String name;
    private String pharmaceuticalCompanyName;
    private List<MedicineVersion> versions;

    public Medicine(String id, String group, String name, String pharmaceuticalCompanyName,
                    List<MedicineVersion> versions) {
        this.id = id;
        this.group = group;
        this.name = name;
        this.pharmaceuticalCompanyName = pharmaceuticalCompanyName;
        this.versions = versions;
    }

    public Medicine() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPharmaceuticalCompanyName() {
        return pharmaceuticalCompanyName;
    }

    public void setPharmaceuticalCompanyName(String pharmaceuticalCompanyName) {
        this.pharmaceuticalCompanyName = pharmaceuticalCompanyName;
    }

    public List<MedicineVersion> getVersions() {
        return versions;
    }

    public void setVersions(List<MedicineVersion> versions) {
        this.versions = versions;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Medicine medicine = (Medicine) o;
        return Objects.equals(id, medicine.id) &&
                Objects.equals(group, medicine.group) &&
                Objects.equals(name, medicine.name) &&
                Objects.equals(pharmaceuticalCompanyName, medicine.pharmaceuticalCompanyName) &&
                Objects.equals(versions, medicine.versions);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, group, name, pharmaceuticalCompanyName, versions);
    }

    @Override
    public String toString() {
        return "Medicine{" +
                "id='" + id + '\'' +
                ", group='" + group + '\'' +
                ", name='" + name + '\'' +
                ", pharmaceuticalCompanyName='" + pharmaceuticalCompanyName + '\'' +
                ", versions=" + versions +
                '}';
    }
}
