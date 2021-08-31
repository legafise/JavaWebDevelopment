package by.lashkevich.bills.service;

import by.lashkevich.bills.entity.Client;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

class ServiceValidatorTest {
    private final ServiceValidator serviceValidator = new ServiceValidator();

    @Test()
    void isValidClientTestWithPositiveValidationScenario() {
        Assert.assertTrue(serviceValidator
                .isValidClient(new Client(1, "Roman", "Lashkevich", 18)));
    }

    @Test
    void isValidClientTestWithInvalidIdValidationScenario() {
        Assert.assertFalse(serviceValidator
                .isValidClient(new Client(-2, "Roman", "Lashkevich", 18)));
    }

    @Test
    void isValidClientTestWithInvalidNameValidationScenario() {
        Assert.assertFalse(serviceValidator
                .isValidClient(new Client(1, "g", "Lashkevich", 18)));
    }

    @Test
    void isValidClientTestWithInvalidSurnameValidationScenario() {
        Assert.assertFalse(serviceValidator
                .isValidClient(new Client(1, "Roman", "H", 18)));
    }

    @Test
    void isValidClientTestWithInvalidAgeValidationScenario() {
        Assert.assertFalse(serviceValidator
                .isValidClient(new Client(1, "Roman", "Lashkevich", 4)));
    }

    @Test
    void isValidClientTestWithNullValidationScenario() {
        Assert.assertFalse(serviceValidator
                .isValidClient(null));
    }

    @Test
    void isValidClientTestWithNullInFieldsValidationScenario() {
        Assert.assertFalse(serviceValidator
                .isValidClient(new Client(1, null, null, 18)));
    }
}