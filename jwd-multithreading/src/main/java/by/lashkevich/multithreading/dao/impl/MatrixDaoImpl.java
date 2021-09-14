package by.lashkevich.multithreading.dao.impl;

import by.lashkevich.multithreading.dao.DaoException;
import by.lashkevich.multithreading.dao.FileFinder;
import by.lashkevich.multithreading.dao.MatrixDao;
import by.lashkevich.multithreading.entity.Matrix;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MatrixDaoImpl implements MatrixDao {
    private static final String MATRIX_INFO_FILE_NAME = "SquareMatrixInfo.txt";
    private static final String MATRIX_ELEMENTS_SEPARATION_SIGN = " ";
    private Matrix parsedMatrix;
    private List<Integer> matrixRange;

    public MatrixDaoImpl() {
        readMatrixData();
    }

    @Override
    public Matrix findMatrix() {
        return parsedMatrix;
    }

    @Override
    public int findElement(int verticalSize, int horizontalSize) {
        return parsedMatrix.getElement(verticalSize, horizontalSize);
    }

    @Override
    public void updateElement(int verticalSize, int horizontalSize, int element) {
        parsedMatrix.setElement(verticalSize, horizontalSize, element);
    }

    @Override
    public List<Integer> getMatrixSizeRange() {
        return matrixRange;
    }

    private void readMatrixData() {
        try {
            FileFinder fileFinder = new FileFinder();
            Stream<String> matrixData = Files.lines(Paths.get(fileFinder
                    .findInfoFile(MATRIX_INFO_FILE_NAME).getPath()));
            Iterator<String> matrixDataIterator = matrixData.iterator();
            matrixRange = Arrays.stream(matrixDataIterator.next().split(MATRIX_ELEMENTS_SEPARATION_SIGN))
                    .map(Integer::parseInt).collect(Collectors.toList());
            parsedMatrix = mapMatrix(matrixDataIterator);
        } catch (IOException e) {
            throw new DaoException(e.getMessage());
        }
    }

    private Matrix mapMatrix(Iterator<String> matrixDataIterator) {
        List<Integer> matrixSizes = Arrays.stream(matrixDataIterator.next().split(MATRIX_ELEMENTS_SEPARATION_SIGN))
                .map(Integer::parseInt).collect(Collectors.toList());
        int verticalSize = matrixSizes.get(0);
        int horizontalSize = matrixSizes.get(1);
        int[][] matrix = new int[verticalSize][horizontalSize];
        for (int i = 0; i < verticalSize; i++) {
            List<String> matrixValues = Arrays.asList(matrixDataIterator
                    .next().split(MATRIX_ELEMENTS_SEPARATION_SIGN));
            Iterator<String> matrixValuesIterator = matrixValues.iterator();
            for (int j = 0; j < horizontalSize; j++) {
                matrix[i][j] = Integer.parseInt(matrixValuesIterator.next());
            }
        }

        return new Matrix(matrix);
    }
}
