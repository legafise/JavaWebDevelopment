package by.lashkevich.jwd.reader.impl;

import by.lashkevich.jwd.reader.LinearProgramReader;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LinearProgramConsoleReader implements LinearProgramReader {
    private static final String ENTER_POINT_COORDINATES_MESSAGE = "Enter the coordinates of the point №";
    private static final String ENTER_X_COORDINATE_MESSAGE = "Enter the x coordinate";
    private static final String ENTER_Y_COORDINATE_MESSAGE = "Enter the y coordinate";
    private static final String ENTER_INNER_RADIUS_MESSAGE = "Enter the inner radius";
    private static final String ENTER_OUTER_RADIUS_MESSAGE = "Enter the outer radius";
    private static final String ENTER_SYMBOL_COORDINATE_MESSAGE = "Enter any symbol";
    private static final String ENTER_VARIABLE_A_MESSAGE = "Enter variable a";
    private static final String ENTER_VARIABLE_B_MESSAGE = "Enter variable b";
    private static final String ENTER_VARIABLE_C_MESSAGE = "Enter variable c";
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
    public List<String> readPointData() {
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
}
