package by.lashkevich.xml.entity;

import java.time.LocalDate;
import java.util.Objects;

public class MedicineCertificate {
    private String number;
    private LocalDate issueDate;
    private LocalDate expiryDate;
    private String registrationOrganization;

    public MedicineCertificate(String number, LocalDate issueDate, LocalDate expiryDate,
                               String registrationOrganization) {
        this.number = number;
        this.issueDate = issueDate;
        this.expiryDate = expiryDate;
        this.registrationOrganization = registrationOrganization;
    }

    public MedicineCertificate() {
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public LocalDate getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(LocalDate issueDate) {
        this.issueDate = issueDate;
    }

    public LocalDate getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(LocalDate expiryDate) {
        this.expiryDate = expiryDate;
    }

    public String getRegistrationOrganization() {
        return registrationOrganization;
    }

    public void setRegistrationOrganization(String registrationOrganization) {
        this.registrationOrganization = registrationOrganization;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MedicineCertificate that = (MedicineCertificate) o;
        return Objects.equals(number, that.number) &&
                Objects.equals(issueDate, that.issueDate) &&
                Objects.equals(expiryDate, that.expiryDate) &&
                Objects.equals(registrationOrganization, that.registrationOrganization);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number, issueDate, expiryDate, registrationOrganization);
    }

    @Override
    public String toString() {
        return "MedicineCertificate{" +
                "number='" + number + '\'' +
                ", issueDate=" + issueDate +
                ", expiryDate=" + expiryDate +
                ", registrationOrganization='" + registrationOrganization + '\'' +
                '}';
    }
}
