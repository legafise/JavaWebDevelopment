package by.lashkevich.multithreading.dao.impl;

import by.lashkevich.multithreading.dao.DaoException;
import by.lashkevich.multithreading.dao.FileFinder;
import by.lashkevich.multithreading.dao.MatrixDao;
import by.lashkevich.multithreading.entity.Matrix;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.stream.Stream;

public class MatrixDaoImpl implements MatrixDao {
    private static final String MATRIX_INFO_FILE_NAME = "SquareMatrixInfo.txt";
    private Matrix parsedMatrix;

    public MatrixDaoImpl() {
        parsedMatrix = readMatrix();
    }

    @Override
    public Matrix findMatrix() {
        return parsedMatrix;
    }

    private Matrix readMatrix() {
        try {
            FileFinder fileFinder = new FileFinder();
            Stream<String> matrixData = Files.lines(Paths.get(fileFinder
                    .findInfoFile(MATRIX_INFO_FILE_NAME).getPath()));
            Iterator<String> matrixDataIterator = matrixData.iterator();
            return mapMatrix(matrixDataIterator);
        } catch (IOException e) {
            throw new DaoException(e.getMessage());
        }
    }

    private Matrix mapMatrix(Iterator<String> matrixDataIterator) {
        int verticalSize = Integer.parseInt(matrixDataIterator.next());
        int horizontalSize = Integer.parseInt(matrixDataIterator.next());
        int[][] matrix = new int[verticalSize][horizontalSize];

        for (int i = 0; i < verticalSize; i++) {
            for (int j = 0; j < horizontalSize; j++) {
                matrix[i][j] = Integer.parseInt(matrixDataIterator.next());
            }
        }

        return new Matrix(matrix);
    }
}
