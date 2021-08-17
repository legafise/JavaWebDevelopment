package by.lashkevich.arrays.arraysutill.creator;


import by.lashkevich.arrays.entity.ArraysArray;
import by.lashkevich.arrays.entity.ArraysMatrix;

public interface ArraysDataCreator {
    ArraysMatrix createSquareMatrix();

    ArraysMatrix createRectangularMatrix();

    <T extends Number> ArraysArray<T> createArray();
}
