package by.lashkevich.lb.access;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.testng.Assert.*;

public class AccessTypeTest {
    @DataProvider(name = "allPositiveDataForAccessChecking")
    public Object[][] createPositiveDataForAccessChecking() {
        return new Object[][]{
                {9583, Arrays.asList("A", "B", "C")},
                {1747, Arrays.asList("A", "B", "C")},
                {3331, Arrays.asList("B", "C")},
                {7922, Arrays.asList("B", "C")},
                {9455, Collections.singletonList("C")},
                {8997, Collections.singletonList("C")},
        };
    }

    @Test (description = "All positive scenario of password checking", dataProvider = "positiveDataAccessChecking")
    public void checkAccessPositiveScenarioTest(int password, List<String> expectedAccesses) {
        Assert.assertEquals(AccessType.checkAccess(password), expectedAccesses);
    }
}