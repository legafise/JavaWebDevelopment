package by.lashkevich.xml.service.builder;

import by.lashkevich.xml.entity.*;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public class DomMedicineBuilderTest {
    private String xmlFilePath;
    private MedicineBuilder staxBuilder;
    private List<Medicine> medicineList;

    @BeforeTest
    public void setUp() {
        xmlFilePath = "D:\\JavaWebDevelopment\\jwd-xml\\src\\test\\java\\resources\\testMedecines.xml";
        staxBuilder = new DomMedicineBuilder();
        medicineList = Arrays.asList(new OriginalMedicine("G-563", "ointment", "Mekol", "Aktavis",
                        Arrays.asList(new MedicineVersion(new MedicineCertificate("b-423",
                                LocalDate.of(2021, 8, 10),
                                LocalDate.of(2023, 8, 10), "Minzdrav"),
                                new MedicinePackageType("tube", "50g", 4.35),
                                new Dosage("", "1g"))), Arrays.asList("Levomekol")),
                new Analog("G-562", "ointment", "Levomekol", "Aktaves",
                        Arrays.asList(new MedicineVersion(new MedicineCertificate("b-422",
                                LocalDate.of(2021, 8, 10),
                                LocalDate.of(2023, 8, 10), "Minzdrav"),
                                new MedicinePackageType("tube", "60g", 5.2),
                                new Dosage("", "1g"))), 90.4, "Mekol"));
    }

    @Test
    public void buildMedicineListTest() {
        staxBuilder.buildMedicineList(xmlFilePath);
        Assert.assertEquals(staxBuilder.getMedicineList(), medicineList);
    }

}