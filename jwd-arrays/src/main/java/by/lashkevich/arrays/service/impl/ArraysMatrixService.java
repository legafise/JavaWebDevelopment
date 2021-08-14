package by.lashkevich.arrays.service.impl;

import by.lashkevich.arrays.arraysutill.calculator.ArraysMatrixCalculator;
import by.lashkevich.arrays.entity.ArraysMatrix;
import by.lashkevich.arrays.exception.ArraysMatrixCalculatorException;
import by.lashkevich.arrays.exception.ArraysServiceException;
import by.lashkevich.arrays.service.MatrixService;

import static by.lashkevich.arrays.arraysutill.validator.ArraysMatrixValidator.*;

public class ArraysMatrixService implements MatrixService {
    private static final String INCORRECT_MATRICES_MESSAGE = "Incorrect matrices received";

    @Override
    public ArraysMatrix multiplyMatrices(ArraysMatrix firstMatrix, ArraysMatrix secondMatrix) throws ArraysServiceException {
        try {
            if (validateForNull(firstMatrix, secondMatrix)
                    && validateMultiplyMatrices(firstMatrix, secondMatrix)) {
                return ArraysMatrixCalculator.multiply(firstMatrix, secondMatrix);
            }

            throw new ArraysServiceException(INCORRECT_MATRICES_MESSAGE);
        } catch (ArraysMatrixCalculatorException e) {
            throw new ArraysServiceException(e.getMessage());
        }
    }

    @Override
    public ArraysMatrix addMatrices(ArraysMatrix firstMatrix, ArraysMatrix secondMatrix) throws ArraysServiceException {
        try {
            if (validateForNull(firstMatrix, secondMatrix)
                    && validateAddOrSubtractMatrices(firstMatrix, secondMatrix)) {
                return ArraysMatrixCalculator.add(firstMatrix, secondMatrix);
            }

            throw new ArraysServiceException(INCORRECT_MATRICES_MESSAGE);
        } catch (ArraysMatrixCalculatorException e) {
            throw new ArraysServiceException(e.getMessage());
        }
    }

    @Override
    public ArraysMatrix subtractMatrices(ArraysMatrix firstMatrix, ArraysMatrix secondMatrix) throws ArraysServiceException {
        try {
            if (validateForNull(firstMatrix, secondMatrix)
                    && validateAddOrSubtractMatrices(firstMatrix, secondMatrix)) {
                return ArraysMatrixCalculator.subtract(firstMatrix, secondMatrix);
            }

            throw new ArraysServiceException(INCORRECT_MATRICES_MESSAGE);
        } catch (ArraysMatrixCalculatorException e) {
            throw new ArraysServiceException(e.getMessage());
        }
    }

    @Override
    public ArraysMatrix transposeMatrix(ArraysMatrix matrix) throws ArraysServiceException {
        try {
            if (validateForNull(matrix)) {
                return ArraysMatrixCalculator.transpose(matrix);
            }

            throw new ArraysServiceException(INCORRECT_MATRICES_MESSAGE);
        } catch (ArraysMatrixCalculatorException e) {
            throw new ArraysServiceException(e.getMessage());
        }
    }
}
