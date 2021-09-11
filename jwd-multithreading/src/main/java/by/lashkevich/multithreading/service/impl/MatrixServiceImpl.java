package by.lashkevich.multithreading.service.impl;

import by.lashkevich.multithreading.dao.DaoFactory;
import by.lashkevich.multithreading.dao.MatrixDao;
import by.lashkevich.multithreading.entity.Matrix;
import by.lashkevich.multithreading.service.MatrixService;
import by.lashkevich.multithreading.service.ServiceException;
import by.lashkevich.multithreading.service.validator.MatrixServiceValidator;

public class MatrixServiceImpl implements MatrixService {
    private static final String INCORRECT_MATRIX_RANGE_MESSAGE = "You are out of range of the matrix";
    private final MatrixDao matrixDao;
    private final MatrixServiceValidator matrixValidator;

    public MatrixServiceImpl() {
        matrixValidator = new MatrixServiceValidator();
        matrixDao = DaoFactory.getInstance().getMatrixDao();
    }

    @Override
    public void setElement(int i, int j, int element) throws ServiceException {
        Matrix matrix = matrixDao.findMatrix();
        if (!matrixValidator.isValidRange(matrix, i, j)) {
            throw new ServiceException(INCORRECT_MATRIX_RANGE_MESSAGE);
        }

        matrix.setElement(i, j, element);
    }

    @Override
    public int getElement(int i, int j) throws ServiceException {
        Matrix matrix = matrixDao.findMatrix();
        if (!matrixValidator.isValidRange(matrix, i, j)) {
            throw new ServiceException(INCORRECT_MATRIX_RANGE_MESSAGE);
        }

        return matrix.getElement(i, j);
    }

    @Override
    public Matrix findMatrix() throws ServiceException {
        return matrixDao.findMatrix();
    }
}
