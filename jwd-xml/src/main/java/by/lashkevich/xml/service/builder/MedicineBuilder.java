package by.lashkevich.xml.service.builder;

import by.lashkevich.xml.entity.Medicine;

import java.util.List;

public abstract class MedicineBuilder {
    private List<Medicine> medicineList;

    public MedicineBuilder() {
    }

    public List<Medicine> getMedicineList() {
        return medicineList;
    }

    public void setMedicineList(List<Medicine> medicineList) {
        this.medicineList = medicineList;
    }

    public abstract void buildMedicineList(String filename);
}
