package by.lashkevich.xml.service.handler;

import by.lashkevich.xml.entity.*;
import by.lashkevich.xml.service.builder.MedicineTag;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class MedicineSaxHandler extends DefaultHandler {
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    private List<Medicine> medicines;
    private List<MedicineVersion> versions;
    private List<String> currentAnalogNames;
    private MedicineVersion currentVersion;
    private MedicinePackageType currentMedicinePackageType;
    private Dosage currentDosage;
    private MedicineCertificate currentCertificate;
    private MedicineTag currentTag;
    private Medicine currentMedicine;

    public MedicineSaxHandler() {
        medicines = new ArrayList<>();
        versions = new ArrayList<>();
        currentVersion = new MedicineVersion();
        currentMedicinePackageType = new MedicinePackageType();
        currentDosage = new Dosage();
        currentCertificate = new MedicineCertificate();
        currentAnalogNames = new ArrayList<>();
    }

    public List<Medicine> getMedicines() {
        List<Medicine> copyMedicineList = new ArrayList<>(medicines);
        medicines = new ArrayList<>();
        return copyMedicineList;
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (MedicineTag.ORIGINAL_MEDICINE == MedicineTag.findMedicineTag(qName)) {
            OriginalMedicine originalMedicine = new OriginalMedicine();
            originalMedicine.setId(attributes.getValue(0));
            originalMedicine.setGroup(attributes.getValue(1));
            currentMedicine = originalMedicine;
        } else if (MedicineTag.ANALOG == MedicineTag.findMedicineTag(qName)) {
            Analog analog = new Analog();
            analog.setId(attributes.getValue(0));
            analog.setGroup(attributes.getValue(1));
            analog.setEfficiency(Double.parseDouble(attributes.getValue(2)));
            currentMedicine = analog;
        } else if (MedicineTag.DOSAGE == MedicineTag.findMedicineTag(qName)) {
            currentDosage.setMedicationFrequency(attributes.getValue(0));
        } else {
            currentTag = MedicineTag.findMedicineTag(qName);
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        String data = new String(ch, start, length).trim();
        if (currentTag != null) {
            switch (currentTag) {
                case NAME:
                    currentMedicine.setName(data);
                    break;
                case PHARM:
                    currentMedicine.setPharmaceuticalCompanyName(data);
                    break;
                case PACKAGE_TYPE:
                    currentMedicinePackageType.setPackageType(data);
                    break;
                case PRICE:
                    currentMedicinePackageType.setPrice(Double.parseDouble(data));
                    break;
                case AMOUNT_IN_PACKAGE:
                    currentMedicinePackageType.setAmount(data);
                    break;
                case DOSE:
                    currentDosage.setDose(data);
                    break;
                case MEDICATION_FREQUENCY:
                    currentDosage.setMedicationFrequency(data);
                    break;
                case NUMBER:
                    currentCertificate.setNumber(data);
                    break;
                case ISSUE_DATE:
                    currentCertificate.setIssueDate(LocalDate.parse(data, FORMATTER));
                    break;
                case EXPIRY_DATE:
                    currentCertificate.setExpiryDate(LocalDate.parse(data, FORMATTER));
                    break;
                case REGISTRATION_ORGANIZATION:
                    currentCertificate.setRegistrationOrganization(data);
                    break;
            }

            if (currentMedicine instanceof OriginalMedicine) {
                if (currentTag == MedicineTag.ANALOG_NAME) {
                    currentAnalogNames.add(data);
                }
            }

            if (currentMedicine instanceof Analog) {
                Analog analog = (Analog) currentMedicine;
                if (currentTag == MedicineTag.TITLE_OF_ORIGINAL) {
                    analog.setTitleOfOriginal(data);
                }
            }
        }

        currentTag = null;
    }

    @Override
    public void endElement(String uri, String localName, String qName) {
        if (MedicineTag.ANALOG == MedicineTag.findMedicineTag(qName)
                || MedicineTag.ORIGINAL_MEDICINE == MedicineTag.findMedicineTag(qName)) {
            medicines.add(currentMedicine);
        }

        switch (MedicineTag.findMedicineTag(qName)) {
            case PACKAGE:
                currentVersion.setPackageType(currentMedicinePackageType);
                currentMedicinePackageType = new MedicinePackageType();
                break;
            case VERSION:
                versions.add(currentVersion);
                currentVersion = new MedicineVersion();
                break;
            case DOSAGE:
                currentVersion.setDosage(currentDosage);
                currentDosage = new Dosage();
                break;
            case CERTIFICATE:
                currentVersion.setCertificate(currentCertificate);
                currentCertificate = new MedicineCertificate();
                break;
            case VERSIONS:
                currentMedicine.setVersions(versions);
                versions = new ArrayList<>();
                break;
            case ANALOGS:
                OriginalMedicine originalMedicine = (OriginalMedicine) currentMedicine;
                originalMedicine.setAnalogs(currentAnalogNames);
                currentAnalogNames = new ArrayList<>();
                break;
        }
    }
}