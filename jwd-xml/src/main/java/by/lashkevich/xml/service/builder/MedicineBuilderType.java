package by.lashkevich.xml.service.builder;

import by.lashkevich.xml.service.ServiceException;

import java.util.Arrays;

public enum MedicineBuilderType {
    DOM_BUILDER(new DomMedicineBuilder(), 1),
    SAX_BUILDER(new SaxMedicineBuilder(), 2),
    STAX_BUILDER(new StaxMedicineBuilder(), 3);

    private static final String INVALID_BUILDER_NUMBER_MESSAGE = "Invalid builder number message";
    private final MedicineBuilder medicineBuilder;
    private final int builderNumber;

    MedicineBuilderType(MedicineBuilder medicineBuilder, int builderNumber) {
        this.medicineBuilder = medicineBuilder;
        this.builderNumber = builderNumber;
    }

    public MedicineBuilder getMedicineBuilder() {
        return medicineBuilder;
    }

    public int getBuilderNumber() {
        return builderNumber;
    }

    public static MedicineBuilder findBuilderByNumber(int number) {
        return Arrays.stream(MedicineBuilderType.values())
                .filter(currentBuilder -> currentBuilder.getBuilderNumber() == number)
                .findFirst()
                .map(MedicineBuilderType::getMedicineBuilder)
                .orElseThrow(() -> new ServiceException(INVALID_BUILDER_NUMBER_MESSAGE));
    }
}
