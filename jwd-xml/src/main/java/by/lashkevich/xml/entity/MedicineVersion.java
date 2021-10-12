package by.lashkevich.xml.entity;

import java.util.Objects;

public class MedicineVersion {
    private MedicineCertificate certificate;
    private MedicinePackageType packageType;
    private Dosage dosage;

    public MedicineVersion(MedicineCertificate certificate, MedicinePackageType packageType, Dosage dosage) {
        this.certificate = certificate;
        this.packageType = packageType;
        this.dosage = dosage;
    }

    public MedicineVersion() {
    }

    public MedicineCertificate getCertificate() {
        return certificate;
    }

    public void setCertificate(MedicineCertificate certificate) {
        this.certificate = certificate;
    }

    public MedicinePackageType getPackageType() {
        return packageType;
    }

    public void setPackageType(MedicinePackageType packageType) {
        this.packageType = packageType;
    }

    public Dosage getDosage() {
        return dosage;
    }

    public void setDosage(Dosage dosage) {
        this.dosage = dosage;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MedicineVersion that = (MedicineVersion) o;
        return Objects.equals(certificate, that.certificate) &&
                Objects.equals(packageType, that.packageType) &&
                Objects.equals(dosage, that.dosage);
    }

    @Override
    public int hashCode() {
        return Objects.hash(certificate, packageType, dosage);
    }

    @Override
    public String toString() {
        return "MedicineVersion{" +
                "certificate=" + certificate +
                ", packageType=" + packageType +
                ", dosage=" + dosage +
                '}';
    }
}
