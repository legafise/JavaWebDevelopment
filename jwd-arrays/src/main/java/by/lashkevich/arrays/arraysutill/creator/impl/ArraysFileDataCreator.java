package by.lashkevich.arrays.arraysutill.creator.impl;

import by.lashkevich.arrays.arraysutill.reader.ArraysMatrixFileReader;
import by.lashkevich.arrays.arraysutill.creator.ArraysDataCreator;
import by.lashkevich.arrays.entity.ArraysArray;
import by.lashkevich.arrays.entity.ArraysMatrix;
import by.lashkevich.arrays.exception.ArraysDataCreatorException;
import by.lashkevich.arrays.exception.ArraysReaderException;

public class ArraysFileDataCreator implements ArraysDataCreator {
    private static final String SQUARE_MATRIX_INFO_FILE_PATH =
            "jwd-arrays/src/main/resources/info/SquareMatrixInfo.txt";
    private static final String RECTANGULAR_MATRIX_INFO_FILE_PATH =
            "jwd-arrays/src/main/resources/info/RectangularMatrixInfo.txt";
    private final ArraysMatrixFileReader squareMatrixReader;
    private final ArraysMatrixFileReader rectangularMatrixReader;

    public ArraysFileDataCreator() throws ArraysDataCreatorException {
        try {
            squareMatrixReader = new ArraysMatrixFileReader(SQUARE_MATRIX_INFO_FILE_PATH);
            rectangularMatrixReader = new ArraysMatrixFileReader(RECTANGULAR_MATRIX_INFO_FILE_PATH);
        } catch (ArraysReaderException e) {
            throw new ArraysDataCreatorException(e);
        }
    }

    @Override
    public ArraysMatrix createSquareMatrix() {
        return createMatrix(squareMatrixReader);
    }

    @Override
    public ArraysMatrix createRectangularMatrix() {
        return createMatrix(rectangularMatrixReader);
    }

    @Override
    public <T extends Number> ArraysArray<T> createArray() {
        return null;
    }

    private ArraysMatrix createMatrix(ArraysMatrixFileReader reader) {
        int verticalSize = reader.getNextElement();
        int horizontalSize = reader.getNextElement();
        int[][] matrix = new int[verticalSize][horizontalSize];

        for (int i = 0; i < verticalSize; i++) {
            for (int j = 0; j < horizontalSize; j++) {
                int value = reader.getNextElement();
                matrix[i][j] = value;
            }
        }

        return new ArraysMatrix(matrix);
    }
}
