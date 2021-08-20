package by.lashkevich.arrays.arraysutill.parser;

import by.lashkevich.arrays.entity.ArraysMatrix;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Class for parsing matrices from different information
 * @author Roman Lashkevich
 */
public class ArraysMatrixParser {
    public ArraysMatrixParser() {
    }

    public ArraysMatrix parseOneMatrix(List<String> matrixData) {
        Iterator matrixDataIterator = matrixData.iterator();
        return parseMatrix(matrixDataIterator);
    }

    public List<ArraysMatrix> parseMatrixList(List<String> matrixData) {
        ArrayList<ArraysMatrix> matrices = new ArrayList<>();
        Iterator matrixDataIterator = matrixData.iterator();

        while (matrixDataIterator.hasNext()) {
            matrices.add(parseMatrix(matrixDataIterator));
        }

        return matrices;
    }

    private ArraysMatrix parseMatrix(Iterator matrixDataIterator) {
        int verticalSize = Integer.parseInt((String) matrixDataIterator.next());
        int horizontalSize = Integer.parseInt((String) matrixDataIterator.next());
        int[][] matrix = new int[verticalSize][horizontalSize];

        for (int i = 0; i < verticalSize; i++) {
            for (int j = 0; j < horizontalSize; j++) {
                matrix[i][j] = Integer.parseInt((String) matrixDataIterator.next());
            }
        }

        return new ArraysMatrix(matrix);
    }
}
