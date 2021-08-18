package by.lashkevich.arrays.arraysutill.reader;

import by.lashkevich.arrays.exception.ArraysDataCreatorException;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class ArraysFileDataReader {
    private static final String SQUARE_MATRIX_INFO_FILE_PATH =
            "jwd-arrays/src/main/resources/info/SquareMatrixInfo.txt";
    private static final String RECTANGULAR_MATRIX_INFO_FILE_PATH =
            "jwd-arrays/src/main/resources/info/RectangularMatrixInfo.txt";
    private static final String ARRAY_INFO_FILE_PATH =
            "jwd-arrays/src/main/resources/info/ArrayInfo.txt";

    public List<String> readSquareMatrixData() throws ArraysDataCreatorException {
        return readDataFromFile(SQUARE_MATRIX_INFO_FILE_PATH);
    }

    public List<String> readRectangularMatrixData() throws ArraysDataCreatorException {
        return readDataFromFile(RECTANGULAR_MATRIX_INFO_FILE_PATH);
    }

    public List<String> readArrayData() throws ArraysDataCreatorException {
        return readDataFromFile(ARRAY_INFO_FILE_PATH);
    }

    private List<String> readDataFromFile(String filePath) throws ArraysDataCreatorException {
        try {
            return Files.lines(Paths.get(filePath))
                    .collect(Collectors.toList());
        } catch (IOException e) {
            throw new ArraysDataCreatorException(e);
        }
    }
}
