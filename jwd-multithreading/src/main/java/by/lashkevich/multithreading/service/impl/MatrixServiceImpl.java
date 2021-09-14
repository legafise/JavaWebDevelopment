package by.lashkevich.multithreading.service.impl;

import by.lashkevich.multithreading.dao.DaoFactory;
import by.lashkevich.multithreading.entity.Matrix;
import by.lashkevich.multithreading.service.MatrixService;
import by.lashkevich.multithreading.service.ServiceException;
import by.lashkevich.multithreading.service.validator.MatrixServiceValidator;

import java.util.List;

public class MatrixServiceImpl implements MatrixService {
    private static final String INCORRECT_MATRIX_RANGE_MESSAGE = "You are out of range of the matrix";
    private static final String INCORRECT_MATRIX_READ_MESSAGE = "Incorrect matrix was read";
    private final MatrixServiceValidator matrixValidator;

    public MatrixServiceImpl() {
        matrixValidator = new MatrixServiceValidator();
    }

    @Override
    public void setElement(int i, int j, int element) throws ServiceException {
        validateMatrixSize();
        if (!matrixValidator.isValidRange(DaoFactory.getInstance().getMatrixDao().findMatrix(), i, j)) {
            throw new ServiceException(INCORRECT_MATRIX_RANGE_MESSAGE);
        }

        DaoFactory.getInstance().getMatrixDao().updateElement(i, j, element);
    }

    @Override
    public int findElement(int i, int j) throws ServiceException {
        validateMatrixSize();
        if (!matrixValidator.isValidRange(DaoFactory.getInstance().getMatrixDao().findMatrix(), i, j)) {
            throw new ServiceException(INCORRECT_MATRIX_RANGE_MESSAGE);
        }

        return DaoFactory.getInstance().getMatrixDao().findElement(i, j);
    }

    @Override
    public Matrix findMatrix() throws ServiceException {
        validateMatrixSize();
        return DaoFactory.getInstance().getMatrixDao().findMatrix();
    }

    @Override
    public void fillMainDiagonalWithZeros() {
        for (int i = 0; i < findMatrix().getHorizontalSize(); i++) {
            setElement(i, i,0);
        }
    }

    private void validateMatrixSize() {
        List<Integer> matrixSizeRange = DaoFactory.getInstance().getMatrixDao().getMatrixSizeRange();
        int minSize = matrixSizeRange.get(0);
        int maxSize = matrixSizeRange.get(1);
        if (!matrixValidator.isValidSize(DaoFactory.getInstance().getMatrixDao().findMatrix(), minSize, maxSize)) {
            throw new ServiceException(INCORRECT_MATRIX_READ_MESSAGE);
        }
    }
}
