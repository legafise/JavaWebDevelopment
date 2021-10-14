package by.lashkevich.xml.service.builder;

import by.lashkevich.xml.service.ServiceException;

import java.util.Arrays;

public enum MedicineTag {
    MEDICINES("medicines"),
    ORIGINAL_MEDICINE("original-medicine"),
    ID("id"),
    GROUP("group"),
    NAME("name"),
    PHARM("pharm"),
    VERSION("version"),
    VERSIONS("versions"),
    CERTIFICATE("certificate"),
    NUMBER("number"),
    ISSUE_DATE("issue-date"),
    EXPIRY_DATE("expiry-date"),
    REGISTRATION_ORGANIZATION("registration-organisation"),
    PACKAGE("package"),
    PACKAGE_TYPE("package-type"),
    AMOUNT_IN_PACKAGE("amount-in-package"),
    PRICE("price"),
    DOSAGE("dosage"),
    MEDICATION_FREQUENCY("medication-frequency"),
    DOSE("dose"),
    TITLE_OF_ORIGINAL("title-of-original"),
    ANALOGS("analogs"),
    ANALOG("analog"),
    ANALOG_NAME("analog-name"),
    EFFICIENCY("efficiency");

    private static final String NONEXISTENT_MEDICINE_TAG_NAME_MESSAGE = "Nonexistent medicine tag name was received";
    private String tagName;

    MedicineTag(String tagName) {
        this.tagName = tagName;
    }

    public String getTagName() {
        return tagName;
    }

    public static MedicineTag findMedicineTag(String name) {
        return Arrays.stream(MedicineTag.values())
                .filter(currentMedicineTag -> currentMedicineTag.getTagName().equals(name))
                .findFirst()
                .orElseThrow(() -> new ServiceException(NONEXISTENT_MEDICINE_TAG_NAME_MESSAGE));
    }
}
