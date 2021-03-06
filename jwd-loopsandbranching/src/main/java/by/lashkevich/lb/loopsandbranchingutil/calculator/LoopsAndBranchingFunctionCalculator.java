package by.lashkevich.lb.loopsandbranchingutil.calculator;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Utilitarian class for calculation formulas
 * @author Roman Lashkevich
 */
public final class LoopsAndBranchingFunctionCalculator {
    private LoopsAndBranchingFunctionCalculator() {
    }

    /**
     * @param x - variable
     * @return calculation result
     */
    public static double calculateTwoConditionFunction(double x) {
        return x >= 0 && x <= 3 ? Math.pow(x, 2) : 4;
    }

    /**
     * @param a - first segment value
     * @param b - second segment value
     * @param h - step
     * @return calculation result
     */
    public static Map<Double, Double> calculateTrigonometricFunctionWithStep(double a, double b, double h) {
        Map<Double, Double> functionValues = new LinkedHashMap<>();
        for (double x = a; x < b; x += h) {
            double functionResult = (1.0 / Math.tan(x / 3)) + (1.0 / 2.0 * Math.sin(x));
            functionValues.put(x, functionResult);
        }

        return functionValues;
    }

    /**
     * @param a - first segment value
     * @param b - second segment value
     * @param h - step
     * @return calculation result
     */
    public static List<Double> calculateFunctionWithStep(double a, double b, double h) {
        List<Double> functionValues = new ArrayList<>();

        for (double i = a; i <= b; i += h) {
            functionValues.add(i);
        }

        return functionValues.stream()
                .map(currentValue -> currentValue <= 2 && currentValue != 0 ? currentValue * -1 : currentValue * 1)
                .collect(Collectors.toList());
    }


    /**
     * The function specified by the condition
     * Accepts nothing
     * @return calculation result
     */
    public static Map<Double, Double> calculateFunctionWithoutDataEntry() {
        Map<Double, Double> functionValues = new LinkedHashMap<>();
        for (double x = -5; x <= 5; x += 0.5) {
            double functionResult = 5 - Math.pow(x, 2) / 2;
            functionValues.put(x, functionResult);
        }

        return functionValues;
    }
}