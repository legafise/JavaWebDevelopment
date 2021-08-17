package by.lashkevich.arrays.entity;

import by.lashkevich.arrays.exception.ArraysArrayException;

import java.util.Arrays;

public class ArraysArray<T extends Number> {
    private static final String INCORRECT_ELEMENT_INDEX_MESSAGE = "Incorrect element index was entered";
    private static final String NEW_LINE_BREAK = "\n";
    private static final String ARRAY_INFO_MESSAGE = "Array: ";
    private T[] array;

    public ArraysArray(T[] array) {
        this.array = array;
    }

    public ArraysArray(int arrayCapacity) {
        this.array = (T[]) new Number[arrayCapacity];
    }

    public T getElement(int index) throws ArraysArrayException {
        if (checkIndex(index)) {
            return array[index];
        }

        throw new ArraysArrayException(INCORRECT_ELEMENT_INDEX_MESSAGE);
    }

    public int getLenght() {
        return array.length;
    }

    public void setElement(int index, T element) throws ArraysArrayException {
        if (checkIndex(index)) {
            array[index] = element;
        } else {
            throw new ArraysArrayException(INCORRECT_ELEMENT_INDEX_MESSAGE);
        }
    }

    private boolean checkIndex(int index) {
        return index >= 0 && index < array.length;
    }

    public T[] getArray() {
        return array;
    }

    public void setArray(T[] array) {
        this.array = array;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ArraysArray<?> that = (ArraysArray<?>) o;
        return Arrays.equals(array, that.array);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(array);
    }

    @Override
    public String toString() {
        return ARRAY_INFO_MESSAGE + NEW_LINE_BREAK + Arrays.toString(array) + NEW_LINE_BREAK;
    }
}
