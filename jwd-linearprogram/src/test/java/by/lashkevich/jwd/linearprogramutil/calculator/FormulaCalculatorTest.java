package by.lashkevich.jwd.linearprogramutil.calculator;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static by.lashkevich.jwd.linearprogramutil.calculator.FormulaCalculator.calculateSquareRootFormula;

public class FormulaCalculatorTest {
    private double firstValue;
    private double secondValue;
    private double thirdValue;
    private double expectedSquareRootFormulaResult;

    @BeforeMethod
    public void setUp() {
        firstValue = 1;
        secondValue = 2;
        thirdValue = 3;
        expectedSquareRootFormulaResult = 0.25;
    }

    @Test
    public void calculateSquareRootFormulaPositiveTest() {
        Assert.assertEquals(expectedSquareRootFormulaResult,
                calculateSquareRootFormula(firstValue, secondValue, thirdValue), 0.1);
    }

    @Test
    public void calculateSquareRootFormulaNegativeTest() {
        firstValue = 4;

        Assert.assertNotEquals(expectedSquareRootFormulaResult,
                calculateSquareRootFormula(firstValue, secondValue, thirdValue), 0.1);
    }
}