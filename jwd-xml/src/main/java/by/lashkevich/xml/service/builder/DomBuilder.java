package by.lashkevich.xml.service.builder;

import by.lashkevich.xml.entity.*;
import by.lashkevich.xml.service.ServiceException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class DomBuilder {
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    private List<Medicine> medicines;
    private DocumentBuilder documentBuilder;

    public DomBuilder() {
        medicines = new ArrayList<>();
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            documentBuilder = factory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            throw new ServiceException(e);
        }
    }

    public List<Medicine> getMedicines() {
        return medicines;
    }

    public void buildMedicineList(String filePath) {
        try {
            Document document = documentBuilder.parse(filePath);
            Element root = document.getDocumentElement();
            NodeList originalMedicineList = root.getElementsByTagName(MedicineTag.ORIGINAL_MEDICINE.getTagName());
            NodeList analogList = root.getElementsByTagName(MedicineTag.ANALOG.getTagName());

            for (int i = 0; i < originalMedicineList.getLength(); i++) {
                Element medicineElement = (Element) originalMedicineList.item(i);
                Medicine originalMedicine = buildOriginalMedicine(medicineElement);
                medicines.add(originalMedicine);
            }

            for (int i = 0; i < analogList.getLength(); i++) {
                Element medicineElement = (Element) analogList.item(i);
                Medicine analog = buildAnalog(medicineElement);
                medicines.add(analog);
            }
        } catch (IOException | org.xml.sax.SAXException e) {
            throw new ServiceException(e.getMessage());
        }
    }

    private Medicine buildOriginalMedicine(Element medicineElement) {
        OriginalMedicine originalMedicine = new OriginalMedicine();
        List<String> analogList = new ArrayList<>();
        NodeList nodeAnalogs = medicineElement.getElementsByTagName(MedicineTag.ANALOG_NAME.getTagName());

        for (int i = 0; i < nodeAnalogs.getLength(); i++) {
            analogList.add(nodeAnalogs.item(i).getTextContent());
        }
        originalMedicine.setAnalogs(analogList);

        return buildMedicine(medicineElement, originalMedicine);
    }

    private Medicine buildAnalog(Element medicineElement) {
        Analog analog = new Analog();
        analog.setTitleOfOriginal(getElementTextContent(medicineElement, MedicineTag.TITLE_OF_ORIGINAL.getTagName()));
        analog.setEfficiency(Double.parseDouble(medicineElement.getAttribute(MedicineTag.EFFICIENCY.getTagName())));

        return buildMedicine(medicineElement, analog);
    }

    private Medicine buildMedicine(Element medicineElement, Medicine medicine) {
        medicine.setId(medicineElement.getAttribute(MedicineTag.ID.getTagName()));
        medicine.setGroup(medicineElement.getAttribute(MedicineTag.GROUP.getTagName()));
        medicine.setName(getElementTextContent(medicineElement, MedicineTag.NAME.getTagName()));
        medicine.setPharmaceuticalCompanyName(getElementTextContent(medicineElement, MedicineTag.PHARM.getTagName()));
        medicine.setVersions(buildVersions(medicineElement));

        return medicine;
    }

    private List<MedicineVersion> buildVersions(Element medicineElement) {
        List<MedicineVersion> versions = new ArrayList<>();
        NodeList nodeList = medicineElement.getElementsByTagName(MedicineTag.VERSION.getTagName());

        for (int i = 0; i < nodeList.getLength(); i++) {
            Element versionElement = (Element) nodeList.item(i);
            MedicineVersion version = new MedicineVersion();
            version.setCertificate(buildCertificate(versionElement));
            version.setPackageType(buildPackage(versionElement));
            version.setDosage(buildDosage(versionElement));
            versions.add(version);
        }

        return versions;
    }

    private Dosage buildDosage(Element versionElement) {
        Dosage dosage = new Dosage();

        dosage.setMedicationFrequency(versionElement.getAttribute(MedicineTag.MEDICATION_FREQUENCY.getTagName()));
        dosage.setDose(getElementTextContent(versionElement, MedicineTag.DOSE.getTagName()));

        return dosage;
    }

    private MedicinePackageType buildPackage(Element versionElement) {
        MedicinePackageType packageType = new MedicinePackageType();

        packageType.setPackageType(getElementTextContent(versionElement, MedicineTag.PACKAGE_TYPE.getTagName()));
        packageType.setAmount(getElementTextContent(versionElement, MedicineTag.AMOUNT_IN_PACKAGE.getTagName()));
        packageType.setPrice(Double.parseDouble(getElementTextContent(versionElement, MedicineTag.PRICE.getTagName())));

        return packageType;
    }

    private MedicineCertificate buildCertificate(Element versionElement) {
        MedicineCertificate certificate = new MedicineCertificate();

        certificate.setNumber(getElementTextContent(versionElement, MedicineTag.NUMBER.getTagName()));
        certificate.setIssueDate(LocalDate.parse(getElementTextContent(versionElement,
                MedicineTag.ISSUE_DATE.getTagName()), FORMATTER));
        certificate.setExpiryDate(LocalDate.parse(getElementTextContent(versionElement,
                MedicineTag.EXPIRY_DATE.getTagName()), FORMATTER));
        certificate.setRegistrationOrganization(getElementTextContent(versionElement,
                MedicineTag.REGISTRATION_ORGANIZATION.getTagName()));

        return certificate;
    }

    private String getElementTextContent(Element element, String elementName) {
        NodeList nList = element.getElementsByTagName(elementName);
        Node node = nList.item(0);
        return node.getTextContent();
    }
}
