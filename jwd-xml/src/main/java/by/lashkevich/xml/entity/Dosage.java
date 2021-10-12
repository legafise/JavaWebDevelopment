package by.lashkevich.xml.entity;

import java.util.Objects;

public class Dosage {
    private String medicationFrequency;
    private String dose;

    public Dosage(String medicationFrequency, String dose) {
        this.medicationFrequency = medicationFrequency;
        this.dose = dose;
    }

    public Dosage() {
    }

    public String getMedicationFrequency() {
        return medicationFrequency;
    }

    public void setMedicationFrequency(String medicationFrequency) {
        this.medicationFrequency = medicationFrequency;
    }

    public String getDose() {
        return dose;
    }

    public void setDose(String dose) {
        this.dose = dose;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dosage dosage1 = (Dosage) o;
        return Objects.equals(medicationFrequency, dosage1.medicationFrequency) &&
                Objects.equals(dose, dosage1.dose);
    }

    @Override
    public int hashCode() {
        return Objects.hash(medicationFrequency, dose);
    }

    @Override
    public String toString() {
        return "Dosage{" +
                "medicationFrequency='" + medicationFrequency + '\'' +
                ", dosage='" + dose + '\'' +
                '}';
    }
}
