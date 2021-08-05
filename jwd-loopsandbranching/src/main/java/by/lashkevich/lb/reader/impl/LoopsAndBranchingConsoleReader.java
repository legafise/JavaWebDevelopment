package by.lashkevich.lb.reader.impl;

import by.lashkevich.lb.reader.LoopsAndBranchingReader;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LoopsAndBranchingConsoleReader implements LoopsAndBranchingReader {
    private static final String ENTER_POINT_COORDINATES_MESSAGE = "Enter the coordinates of the point №";
    private static final String ENTER_X_COORDINATE_MESSAGE = "Enter the x coordinate";
    private static final String ENTER_Y_COORDINATE_MESSAGE = "Enter the y coordinate";
    private static final String ENTER_INNER_RADIUS_MESSAGE = "Enter the inner radius";
    private static final String ENTER_OUTER_RADIUS_MESSAGE = "Enter the outer radius";
    private static final String ENTER_SYMBOL_COORDINATE_MESSAGE = "Enter any symbol";
    private static final String ENTER_VARIABLE_A_MESSAGE = "Enter variable a";
    private static final String ENTER_VARIABLE_B_MESSAGE = "Enter variable b";
    private static final String ENTER_VARIABLE_C_MESSAGE = "Enter variable c";
    private static final String ENTER_VARIABLE_X_MESSAGE = "Enter variable x";
    private static final String ENTER_DAY_MESSAGE = "Enter day";
    private static final String ENTER_MONTH_MESSAGE = "Enter month";
    private static final String ENTER_FIRST_NUMBER_MESSAGE = "Enter the first number";
    private static final String ENTER_SECOND_NUMBER_MESSAGE = "Enter the second number";
    private static final String ENTER_PASSWORD_MESSAGE = "Enter your password to gain access";
    private static final String ENTER_FIRST_LINE_POINT_MESSAGE = "Enter the first point of the line";
    private static final String ENTER_SECOND_LINE_POINT_MESSAGE = "Enter the second point of the line";
    private static final String ENTER_LINE_STEP_MESSAGE = "Enter the line step";
    private static final String ENTER_NUMBER_MESSAGE = "Enter number";
    private static final String ENTER_NUMBER_OF_FOUR_OR_MORE_DIGITS_MESSAGE = "Enter a number of" +
            " three or more digits";
    private final Scanner SCANNER = new Scanner(System.in);

    @Override
    public List<String> readTriangleData() {
        List<String> coordinateList = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            System.out.println(ENTER_POINT_COORDINATES_MESSAGE + (i + 1));

            System.out.println(ENTER_X_COORDINATE_MESSAGE);
            coordinateList.add(SCANNER.next());

            System.out.println(ENTER_Y_COORDINATE_MESSAGE);
            coordinateList.add(SCANNER.next());
        }

        return coordinateList;
    }

    @Override
    public List<String> readPointOnAreaData() {
        List<String> coordinateList = new ArrayList<>();

        System.out.println(ENTER_X_COORDINATE_MESSAGE);
        coordinateList.add(SCANNER.next());

        System.out.println(ENTER_Y_COORDINATE_MESSAGE);
        coordinateList.add(SCANNER.next());

        return coordinateList;
    }

    @Override
    public List<String> readSquareRootFormulaData() {
        List<String> variables = new ArrayList<>();

        System.out.println(ENTER_VARIABLE_A_MESSAGE);
        variables.add(SCANNER.next());

        System.out.println(ENTER_VARIABLE_B_MESSAGE);
        variables.add(SCANNER.next());

        System.out.println(ENTER_VARIABLE_C_MESSAGE);
        variables.add(SCANNER.next());

        return variables;
    }

    @Override
    public List<String> readRingData() {
        List<String> radii = new ArrayList<>();

        System.out.println(ENTER_INNER_RADIUS_MESSAGE);
        radii.add(SCANNER.next());

        System.out.println(ENTER_OUTER_RADIUS_MESSAGE);
        radii.add(SCANNER.next());

        return radii;
    }

    @Override
    public List<String> readSymbolNumbersData() {
        List<String> symbols = new ArrayList<>();
        System.out.println(ENTER_SYMBOL_COORDINATE_MESSAGE);
        symbols.add(SCANNER.next());
        return symbols;
    }

    @Override
    public List<String> readTwoConditionFunctionData() {
        List<String> functionVariables = new ArrayList<>();
        System.out.println(ENTER_VARIABLE_X_MESSAGE);
        functionVariables.add(SCANNER.next());
        return functionVariables;
    }

    @Override
    public List<String> readDateValidatorTaskData() {
        List<String> dateData = new ArrayList<>();

        System.out.println(ENTER_MONTH_MESSAGE);
        dateData.add(SCANNER.next());

        System.out.println(ENTER_DAY_MESSAGE);
        dateData.add(SCANNER.next());

        return dateData;
    }

    @Override
    public List<String> readLeastSquareFinderTaskData() {
        List<String> numbers = new ArrayList<>();

        System.out.println(ENTER_FIRST_NUMBER_MESSAGE);
        numbers.add(SCANNER.next());

        System.out.println(ENTER_SECOND_NUMBER_MESSAGE);
        numbers.add(SCANNER.next());

        return numbers;
    }

    @Override
    public List<String> readPointDistanceFromOriginData() {
        List<String> coordinateList = new ArrayList<>();

        for (int i = 0; i < 2; i++) {
            System.out.println(ENTER_POINT_COORDINATES_MESSAGE + (i + 1));

            System.out.println(ENTER_X_COORDINATE_MESSAGE);
            coordinateList.add(SCANNER.next());

            System.out.println(ENTER_Y_COORDINATE_MESSAGE);
            coordinateList.add(SCANNER.next());
        }

        return coordinateList;
    }

    @Override
    public List<String> readAccessCheckerData() {
        List<String> passwords = new ArrayList<>();
        System.out.println(ENTER_PASSWORD_MESSAGE);
        passwords.add(SCANNER.next());
        return passwords;
    }

    @Override
    public List<String> readFunctionWithStepData() {
        List<String> functionData = new ArrayList<>();
        System.out.println(ENTER_FIRST_LINE_POINT_MESSAGE);
        functionData.add(SCANNER.next());

        System.out.println(ENTER_SECOND_LINE_POINT_MESSAGE);
        functionData.add(SCANNER.next());

        System.out.println(ENTER_LINE_STEP_MESSAGE);
        functionData.add(SCANNER.next());

        return functionData;
    }

    @Override
    public List<String> readTrigonometricFunctionData() {
        List<String> functionData = new ArrayList<>();
        System.out.println(ENTER_FIRST_LINE_POINT_MESSAGE);
        functionData.add(SCANNER.next());

        System.out.println(ENTER_SECOND_LINE_POINT_MESSAGE);
        functionData.add(SCANNER.next());

        System.out.println(ENTER_LINE_STEP_MESSAGE);
        functionData.add(SCANNER.next());

        return functionData;
    }

    @Override
    public List<String> readLargestDigitFinderData() {
        List<String> numbers = new ArrayList<>();
        System.out.println(ENTER_NUMBER_MESSAGE);
        numbers.add(SCANNER.next());
        return numbers;
    }

    @Override
    public List<String> readArithmeticProgressionCheckerData() {
        List<String> numbers = new ArrayList<>();
        System.out.println(ENTER_NUMBER_OF_FOUR_OR_MORE_DIGITS_MESSAGE);
        numbers.add(SCANNER.next());
        return numbers;
    }
}
