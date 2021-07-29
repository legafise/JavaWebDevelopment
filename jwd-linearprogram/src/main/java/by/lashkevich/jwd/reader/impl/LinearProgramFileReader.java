package by.lashkevich.jwd.reader.impl;

import by.lashkevich.jwd.exception.LinearProgramReaderException;
import by.lashkevich.jwd.reader.FilePath;
import by.lashkevich.jwd.reader.LinearProgramReader;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class LinearProgramFileReader implements LinearProgramReader {
    public LinearProgramFileReader() {
    }

    @Override
    public List<String> readTriangleData() throws LinearProgramReaderException {
        return readInformation(FilePath.TRIANGLE_CALCULATOR_INFO_PATH.getURL());
    }

    @Override
    public List<String> readPointData() throws LinearProgramReaderException {
        return readInformation(FilePath.CHECK_POINT_INFO_PATH.getURL());
    }

    @Override
    public List<String> readSquareRootFormulaData() throws LinearProgramReaderException {
        return readInformation(FilePath.SQUARE_ROOT_FORMULA_INFO_PATH.getURL());
    }

    @Override
    public List<String> readRingData() throws LinearProgramReaderException {
        return readInformation(FilePath.RING_CALCULATOR_INFO_PATH.getURL());
    }

    @Override
    public List<String> readSymbolNumbersData() throws LinearProgramReaderException {
        return readInformation(FilePath.SYMBOL_NUMBERS_INFO_PATH.getURL());
    }

    private List<String> readInformation(String filePath) throws LinearProgramReaderException {
        try {
            List<String> lines = new ArrayList<>();
            Files.lines(Paths.get(filePath), StandardCharsets.UTF_8).forEach(lines::add);
            return lines;
        } catch (IOException e) {
            throw new LinearProgramReaderException(e);
        }
    }
}
