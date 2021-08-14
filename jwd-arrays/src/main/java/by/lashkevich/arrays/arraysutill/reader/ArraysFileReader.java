package by.lashkevich.arrays.arraysutill.reader;

import by.lashkevich.arrays.exception.ArraysReaderException;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class ArraysFileReader {
    private final List<Integer> matrixData;
    private int returnedValuesCounter;

    public ArraysFileReader(String filePath) throws ArraysReaderException {
        try {
            matrixData = Files.lines(Paths.get(filePath))
                    .map(Integer::parseInt).collect(Collectors.toList());
        } catch (IOException e) {
            throw new ArraysReaderException();
        }
    }

    public int getNextElement() {
        if (matrixData.size() == returnedValuesCounter) {
            returnedValuesCounter = 0;
        }

        return matrixData.get(returnedValuesCounter++);
    }
}
