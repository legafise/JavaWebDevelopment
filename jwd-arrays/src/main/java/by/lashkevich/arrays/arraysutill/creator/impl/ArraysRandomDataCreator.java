package by.lashkevich.arrays.arraysutill.creator.impl;

import by.lashkevich.arrays.arraysutill.creator.ArrayCreator;
import by.lashkevich.arrays.arraysutill.creator.ArraysDataCreator;
import by.lashkevich.arrays.entity.ArraysArray;
import by.lashkevich.arrays.entity.ArraysMatrix;

public class ArraysRandomDataCreator implements ArraysDataCreator {
    private int squareMatrixRandomSize;
    private int rectangularMatrixRandomVerticalSize;
    private int rectangularMatrixRandomHorizontalSize;
    private int squareMatrixRandomizerCounter;
    private int rectangularMatrixRandomizerCounter;

    public ArraysRandomDataCreator() {
        generateRandomSquareMatrixSize();
        generateRandomRectangularMatrixSizes();
    }

    @Override
    public ArraysMatrix createSquareMatrix() {
        squareMatrixRandomizerCounter++;
        if (squareMatrixRandomizerCounter > 2) {
            generateRandomSquareMatrixSize();
            squareMatrixRandomizerCounter = 0;
        }

        return createMatrix(squareMatrixRandomSize, squareMatrixRandomSize);
    }

    @Override
    public ArraysMatrix createRectangularMatrix() {
        rectangularMatrixRandomizerCounter++;
        if (rectangularMatrixRandomizerCounter > 2) {
            generateRandomRectangularMatrixSizes();
            rectangularMatrixRandomizerCounter = 0;
        }

        return createMatrix(rectangularMatrixRandomVerticalSize, rectangularMatrixRandomHorizontalSize);
    }

    @Override
    public <T extends Number> ArraysArray<T> createArray() {
        int arrayTypeNumber = (int) (Math.random() * (6 - 1) + 1);
        return new ArraysArray<>(ArrayCreator.findArrayType(arrayTypeNumber).createArray());
    }

    private ArraysMatrix createMatrix(int verticalSize, int horizontalSize) {
        int[][] matrix = new int[verticalSize][horizontalSize];

        for (int i = 0; i < verticalSize; i++) {
            for (int j = 0; j < horizontalSize; j++) {
                int value = (int) ((Math.random() * (11 - 1)) + 1);
                matrix[i][j] = value;
            }
        }

        return new ArraysMatrix(matrix);
    }

    private void generateRandomSquareMatrixSize() {
        squareMatrixRandomSize = (int) (Math.random() * (11 - 1) + 1);
    }

    private void generateRandomRectangularMatrixSizes() {
        rectangularMatrixRandomHorizontalSize = (int) (Math.random() * (11 - 1) + 1);
        rectangularMatrixRandomVerticalSize = (int) (Math.random() * (11 - 1) + 1);
    }
}