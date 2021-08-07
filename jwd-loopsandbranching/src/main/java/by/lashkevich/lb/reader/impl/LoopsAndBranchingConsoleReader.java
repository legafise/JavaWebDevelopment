package by.lashkevich.lb.reader.impl;

import by.lashkevich.lb.reader.LoopsAndBranchingPropertiesReader;
import by.lashkevich.lb.reader.LoopsAndBranchingReader;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Loops and branching reader implementation for
 * reading data from console
 *
 * @author Roman Lashkevich
 * @see by.lashkevich.lb.reader.LoopsAndBranchingReader
 */
public class LoopsAndBranchingConsoleReader implements LoopsAndBranchingReader {
    private static final String ENTER_POINT_COORDINATES_MESSAGE_KEY = "console.reader.enter.point.coordinates.message";
    private static final String ENTER_X_COORDINATE_MESSAGE_KEY = "console.reader.enter.x.coordinate.message";
    private static final String ENTER_Y_COORDINATE_MESSAGE_KEY = "console.reader.enter.y.coordinate.message";
    private static final String ENTER_INNER_RADIUS_MESSAGE_KEY = "console.reader.enter.inner.radius.coordinate.message";
    private static final String ENTER_OUTER_RADIUS_MESSAGE_KEY = "console.reader.enter.inner.outer.coordinate.message";
    private static final String ENTER_SYMBOL_COORDINATE_MESSAGE_KEY = "console.reader.enter.symbol.message";
    private static final String ENTER_VARIABLE_A_MESSAGE_KEY = "console.reader.enter.variable.a.message";
    private static final String ENTER_VARIABLE_B_MESSAGE_KEY = "console.reader.enter.variable.b.message";
    private static final String ENTER_VARIABLE_C_MESSAGE_KEY = "console.reader.enter.variable.c.message";
    private static final String ENTER_VARIABLE_X_MESSAGE_KEY = "console.reader.enter.variable.x.message";
    private static final String ENTER_DAY_MESSAGE_KEY = "console.reader.enter.day.message";
    private static final String ENTER_MONTH_MESSAGE_KEY = "console.reader.enter.month.message";
    private static final String ENTER_FIRST_NUMBER_MESSAGE_KEY = "console.reader.enter.first.number.message";
    private static final String ENTER_SECOND_NUMBER_MESSAGE_KEY = "console.reader.enter.second.number.message";
    private static final String ENTER_PASSWORD_MESSAGE_KEY = "console.reader.enter.password.message";
    private static final String ENTER_FIRST_LINE_POINT_MESSAGE_KEY = "console.reader.enter.first.line.point.message";
    private static final String ENTER_SECOND_LINE_POINT_MESSAGE_KEY = "console.reader.enter.second.line.point.message";
    private static final String ENTER_LINE_STEP_MESSAGE_KEY = "console.reader.line.step.message";
    private static final String ENTER_NUMBER_MESSAGE_KEY = "console.reader.enter.number.message";
    private static final String ENTER_NUMBER_OF_FOUR_OR_MORE_DIGITS_MESSAGE_KEY =
            "console.reader.enter.number.of.three.digits.message";
    private final Scanner SCANNER = new Scanner(System.in);
    private final LoopsAndBranchingPropertiesReader propertiesReader;

    public LoopsAndBranchingConsoleReader() {
        propertiesReader = LoopsAndBranchingPropertiesReader.getInstance();
    }

    @Override
    public List<String> readTriangleData() {
        List<String> coordinateList = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            System.out.println(propertiesReader.readMessageFromBundle(ENTER_POINT_COORDINATES_MESSAGE_KEY) + (i + 1));

            System.out.println(propertiesReader.readMessageFromBundle(ENTER_X_COORDINATE_MESSAGE_KEY));
            coordinateList.add(SCANNER.next());

            System.out.println(propertiesReader.readMessageFromBundle(ENTER_Y_COORDINATE_MESSAGE_KEY));
            coordinateList.add(SCANNER.next());
        }

        return coordinateList;
    }

    @Override
    public List<String> readPointOnAreaData() {
        return readTwoParameters(ENTER_X_COORDINATE_MESSAGE_KEY, ENTER_Y_COORDINATE_MESSAGE_KEY);
    }

    @Override
    public List<String> readSquareRootFormulaData() {
        return readThreeParameters(ENTER_VARIABLE_A_MESSAGE_KEY, ENTER_VARIABLE_B_MESSAGE_KEY,
                ENTER_VARIABLE_C_MESSAGE_KEY);
    }

    @Override
    public List<String> readRingData() {
        return readTwoParameters(ENTER_INNER_RADIUS_MESSAGE_KEY, ENTER_OUTER_RADIUS_MESSAGE_KEY);
    }

    @Override
    public List<String> readSymbolNumbersData() {
        List<String> symbols = new ArrayList<>();
        System.out.println(propertiesReader.readMessageFromBundle(ENTER_SYMBOL_COORDINATE_MESSAGE_KEY));
        symbols.add(SCANNER.next());
        return symbols;
    }

    @Override
    public List<String> readTwoConditionFunctionData() {
        List<String> functionVariables = new ArrayList<>();
        System.out.println(propertiesReader.readMessageFromBundle(ENTER_VARIABLE_X_MESSAGE_KEY));
        functionVariables.add(SCANNER.next());
        return functionVariables;
    }

    @Override
    public List<String> readDateValidatorTaskData() {
        return readTwoParameters(ENTER_MONTH_MESSAGE_KEY, ENTER_DAY_MESSAGE_KEY);
    }

    @Override
    public List<String> readLeastSquareFinderTaskData() {
        return readTwoParameters(ENTER_FIRST_NUMBER_MESSAGE_KEY, ENTER_SECOND_NUMBER_MESSAGE_KEY);
    }

    @Override
    public List<String> readPointDistanceFromOriginData() {
        List<String> coordinateList = new ArrayList<>();

        for (int i = 0; i < 2; i++) {
            System.out.println(propertiesReader.readMessageFromBundle(ENTER_POINT_COORDINATES_MESSAGE_KEY) + (i + 1));

            System.out.println(propertiesReader.readMessageFromBundle(ENTER_X_COORDINATE_MESSAGE_KEY));
            coordinateList.add(SCANNER.next());

            System.out.println(propertiesReader.readMessageFromBundle(ENTER_Y_COORDINATE_MESSAGE_KEY));
            coordinateList.add(SCANNER.next());
        }

        return coordinateList;
    }

    @Override
    public List<String> readAccessCheckerData() {
        List<String> passwords = new ArrayList<>();
        System.out.println(propertiesReader.readMessageFromBundle(ENTER_PASSWORD_MESSAGE_KEY));
        passwords.add(SCANNER.next());
        return passwords;
    }

    @Override
    public List<String> readFunctionWithStepData() {
        return readThreeParameters(ENTER_FIRST_LINE_POINT_MESSAGE_KEY, ENTER_SECOND_LINE_POINT_MESSAGE_KEY,
                ENTER_LINE_STEP_MESSAGE_KEY);
    }

    @Override
    public List<String> readTrigonometricFunctionData() {
        return readThreeParameters(ENTER_FIRST_LINE_POINT_MESSAGE_KEY, ENTER_SECOND_LINE_POINT_MESSAGE_KEY,
                ENTER_LINE_STEP_MESSAGE_KEY);
    }

    @Override
    public List<String> readLargestDigitFinderData() {
        List<String> numbers = new ArrayList<>();
        System.out.println(propertiesReader.readMessageFromBundle(ENTER_NUMBER_MESSAGE_KEY));
        numbers.add(SCANNER.next());
        return numbers;
    }

    @Override
    public List<String> readArithmeticProgressionCheckerData() {
        List<String> numbers = new ArrayList<>();
        System.out.println(propertiesReader.readMessageFromBundle(ENTER_NUMBER_OF_FOUR_OR_MORE_DIGITS_MESSAGE_KEY));
        numbers.add(SCANNER.next());
        return numbers;
    }

    private List<String> readThreeParameters(String firstMessage, String secondMessage, String thirdMessage) {
        List<String> parameters = new ArrayList<>();
        System.out.println(propertiesReader.readMessageFromBundle(firstMessage));
        parameters.add(SCANNER.next());

        System.out.println(propertiesReader.readMessageFromBundle(secondMessage));
        parameters.add(SCANNER.next());

        System.out.println(propertiesReader.readMessageFromBundle(thirdMessage));
        parameters.add(SCANNER.next());

        return parameters;
    }

    private List<String> readTwoParameters(String firstMessage, String secondMessage) {
        List<String> parameters = new ArrayList<>();

        System.out.println(propertiesReader.readMessageFromBundle(firstMessage));
        parameters.add(SCANNER.next());

        System.out.println(propertiesReader.readMessageFromBundle(secondMessage));
        parameters.add(SCANNER.next());

        return parameters;
    }
}
