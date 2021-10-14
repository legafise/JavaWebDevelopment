package by.lashkevich.xml.service.builder;

import by.lashkevich.xml.entity.*;
import by.lashkevich.xml.service.ServiceException;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class StaxBuilder {
    private static final String UNKNOWN_ELEMENT_MESSAGE = "Unknown element";
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    public List<Medicine> buildMedicineList(String xmlFilePath) {
        try {
            XMLInputFactory inputFactory = XMLInputFactory.newInstance();
            InputStream inputStream = new FileInputStream(xmlFilePath);
            XMLStreamReader reader = inputFactory.createXMLStreamReader(inputStream);
            List<Medicine> medicineList = new ArrayList<>();

            while (reader.hasNext()) {
                int type = reader.next();
                if (type == XMLStreamReader.START_ELEMENT) {
                    if (MedicineTag.ORIGINAL_MEDICINE == MedicineTag.findMedicineTag(reader.getLocalName())) {
                        OriginalMedicine originalMedicine = buildOriginalMedicine(reader);
                        medicineList.add(originalMedicine);
                    } else if (MedicineTag.ANALOG == MedicineTag.findMedicineTag(reader.getLocalName())) {
                        Analog analog = buildAnalog(reader);
                        medicineList.add(analog);
                    }
                }
            }

            return medicineList;
        } catch (FileNotFoundException | XMLStreamException e) {
            throw new ServiceException(e.getMessage());
        }
    }

    private Analog buildAnalog(XMLStreamReader reader) throws XMLStreamException {
        Analog analog = new Analog();
        setMedicineAttributes(reader, analog);
        analog.setEfficiency(Double.parseDouble(reader
                .getAttributeValue(null, MedicineTag.EFFICIENCY.getTagName())));
        while (reader.hasNext()) {
            int type = reader.next();
            switch (type) {
                case XMLStreamReader.START_ELEMENT:
                    MedicineTag medicineTag = MedicineTag.findMedicineTag(reader.getLocalName());
                    if (medicineTag == MedicineTag.TITLE_OF_ORIGINAL) {
                        analog.setTitleOfOriginal(getXmlText(reader));
                    } else {
                        buildMedicine(medicineTag, analog, reader);
                    }
                    break;
                case XMLStreamReader.END_ELEMENT:
                    String endElement = reader.getLocalName();
                    if (MedicineTag.findMedicineTag(endElement) == MedicineTag.ANALOG) {
                        return analog;
                    }
            }
        }

        throw new ServiceException(UNKNOWN_ELEMENT_MESSAGE);
    }

    private OriginalMedicine buildOriginalMedicine(XMLStreamReader reader) throws XMLStreamException {
        OriginalMedicine medicine = new OriginalMedicine();
        setMedicineAttributes(reader, medicine);

        while (reader.hasNext()) {
            int type = reader.next();
            switch (type) {
                case XMLStreamReader.START_ELEMENT:
                    MedicineTag medicineTag = MedicineTag.findMedicineTag(reader.getLocalName());
                    if (medicineTag == MedicineTag.ANALOGS) {
                        medicine.setAnalogs(buildAnalogs(reader));
                    } else {
                        buildMedicine(medicineTag, medicine, reader);
                    }
                    break;
                case XMLStreamReader.END_ELEMENT:
                    String endElement = reader.getLocalName();
                    if (MedicineTag.findMedicineTag(endElement) == MedicineTag.ORIGINAL_MEDICINE) {
                        return medicine;
                    }
            }
        }

        throw new ServiceException(UNKNOWN_ELEMENT_MESSAGE);
    }

    private List<String> buildAnalogs(XMLStreamReader reader) throws XMLStreamException {
        List<String> analogs = new ArrayList<>();

        while (reader.hasNext()) {
            int type = reader.next();
            switch (type) {
                case XMLStreamReader.START_ELEMENT:
                    if (MedicineTag.findMedicineTag(reader.getLocalName()) == MedicineTag.ANALOG_NAME) {
                        analogs.add(getXmlText(reader));
                    }
                    break;
                case XMLStreamConstants.END_ELEMENT:
                    if (MedicineTag.findMedicineTag(reader.getLocalName()) == MedicineTag.ANALOGS) {
                        return analogs;
                    }
                    break;
            }
        }

        throw new ServiceException(UNKNOWN_ELEMENT_MESSAGE);
    }

    private void buildMedicine(MedicineTag medicineTag, Medicine medicine,
                               XMLStreamReader reader) throws XMLStreamException {
        switch (medicineTag) {
            case NAME:
                medicine.setName(getXmlText(reader));
                break;
            case PHARM:
                medicine.setPharmaceuticalCompanyName(getXmlText(reader));
                break;
            case VERSIONS:
                medicine.setVersions(buildVersions(reader));
                break;
        }
    }

    private List<MedicineVersion> buildVersions(XMLStreamReader reader) throws XMLStreamException {
        List<MedicineVersion> medicineVersions = new ArrayList<>();

        while (reader.hasNext()) {
            int type = reader.next();
            switch (type) {
                case XMLStreamReader.END_ELEMENT:
                    if (MedicineTag.findMedicineTag(reader.getLocalName()) == MedicineTag.VERSIONS) {
                        return medicineVersions;
                    }
                case XMLStreamReader.START_ELEMENT: {
                    if (MedicineTag.findMedicineTag(reader.getLocalName()) == MedicineTag.VERSION) {
                        medicineVersions.add(buildVersion(reader));
                    }
                    break;
                }
            }
        }

        throw new ServiceException(UNKNOWN_ELEMENT_MESSAGE);
    }

    private MedicineVersion buildVersion(XMLStreamReader reader) throws XMLStreamException {
        MedicineVersion version = new MedicineVersion();

        while (reader.hasNext()) {
            switch (reader.next()) {
                case XMLStreamReader.START_ELEMENT:
                    switch (MedicineTag.findMedicineTag(reader.getLocalName())) {
                        case CERTIFICATE:
                            version.setCertificate(buildCertificate(reader));
                            break;
                        case PACKAGE:
                            version.setPackageType(buildPackage(reader));
                            break;
                        case DOSAGE:
                            version.setDosage(buildDosage(reader));
                            break;
                    }
                    break;
                case XMLStreamReader.END_ELEMENT:
                    if (MedicineTag.findMedicineTag(reader.getLocalName()) == MedicineTag.VERSION) {
                        return version;
                    }
            }
        }

        throw new ServiceException(UNKNOWN_ELEMENT_MESSAGE);
    }

    private Dosage buildDosage(XMLStreamReader reader) throws XMLStreamException {
        Dosage dosage = new Dosage();
        dosage.setMedicationFrequency(reader
                .getAttributeValue(null, MedicineTag.MEDICATION_FREQUENCY.getTagName()));
        while (reader.hasNext()) {
            int type = reader.next();
            switch (type) {
                case XMLStreamReader.END_ELEMENT:
                    if (MedicineTag.findMedicineTag(reader.getLocalName()) == MedicineTag.DOSAGE) {
                        return dosage;
                    }
                    break;
                case XMLStreamReader.START_ELEMENT:
                    switch (MedicineTag.findMedicineTag(reader.getLocalName())) {
                        case MEDICATION_FREQUENCY:
                            dosage.setMedicationFrequency(getXmlText(reader));
                            break;
                        case DOSE:
                            dosage.setDose(getXmlText(reader));
                            break;
                    }
            }
        }

        throw new ServiceException(UNKNOWN_ELEMENT_MESSAGE);
    }

    private MedicinePackageType buildPackage(XMLStreamReader reader) throws XMLStreamException {
        MedicinePackageType packageType = new MedicinePackageType();
        while (reader.hasNext()) {
            int type = reader.next();
            switch (type) {
                case XMLStreamReader.END_ELEMENT:
                    if (MedicineTag.findMedicineTag(reader.getLocalName()) == MedicineTag.PACKAGE) {
                        return packageType;
                    }
                    break;
                case XMLStreamReader.START_ELEMENT:
                    switch (MedicineTag.findMedicineTag(reader.getLocalName())) {
                        case PACKAGE_TYPE:
                            packageType.setPackageType(getXmlText(reader));
                            break;
                        case AMOUNT_IN_PACKAGE:
                            packageType.setAmount(getXmlText(reader));
                            break;
                        case PRICE:
                            packageType.setPrice(Double.parseDouble(getXmlText(reader)));
                            break;
                    }
            }
        }

        throw new ServiceException(UNKNOWN_ELEMENT_MESSAGE);
    }

    private MedicineCertificate buildCertificate(XMLStreamReader reader) throws XMLStreamException {
        MedicineCertificate certificate = new MedicineCertificate();
        while (reader.hasNext()) {
            switch (reader.next()) {
                case XMLStreamReader.END_ELEMENT:
                    if (MedicineTag.findMedicineTag(reader.getLocalName()) == MedicineTag.CERTIFICATE) {
                        return certificate;
                    }
                    break;

                case XMLStreamReader.START_ELEMENT:
                    switch (MedicineTag.findMedicineTag(reader.getLocalName())) {
                        case NUMBER:
                            certificate.setNumber(getXmlText(reader));
                            break;
                        case ISSUE_DATE:
                            certificate.setIssueDate(LocalDate.parse(getXmlText(reader), FORMATTER));
                            break;
                        case EXPIRY_DATE:
                            certificate.setExpiryDate(LocalDate.parse(getXmlText(reader), FORMATTER));
                            break;
                        case REGISTRATION_ORGANIZATION:
                            certificate.setRegistrationOrganization(getXmlText(reader));
                            break;
                    }
            }
        }

        throw new ServiceException(UNKNOWN_ELEMENT_MESSAGE);
    }

    private void setMedicineAttributes(XMLStreamReader reader, Medicine medicine) {
        medicine.setId(reader.getAttributeValue(null, MedicineTag.ID.getTagName()));
        medicine.setGroup(reader.getAttributeValue(null, MedicineTag.GROUP.getTagName()));
    }

    private String getXmlText(XMLStreamReader reader) throws XMLStreamException {
        String text = "";
        if (reader.hasNext()) {
            reader.next();
            text = reader.getText();
        }

        return text;
    }
}
