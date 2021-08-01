package by.lashkevich.lb.reader.impl;

import by.lashkevich.lb.exception.LoopsAndBranchingReaderException;
import by.lashkevich.lb.reader.FilePath;
import by.lashkevich.lb.reader.LoopsAndBranchingReader;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class LoopsAndBranchingFileReader implements LoopsAndBranchingReader {
    public LoopsAndBranchingFileReader() {
    }

    @Override
    public List<String> readTriangleData() throws LoopsAndBranchingReaderException {
        return readInformation(FilePath.TRIANGLE_CALCULATOR_INFO_PATH.getURL());
    }

    @Override
    public List<String> readPointData() throws LoopsAndBranchingReaderException {
        return readInformation(FilePath.CHECK_POINT_INFO_PATH.getURL());
    }

    @Override
    public List<String> readSquareRootFormulaData() throws LoopsAndBranchingReaderException {
        return readInformation(FilePath.SQUARE_ROOT_FORMULA_INFO_PATH.getURL());
    }

    @Override
    public List<String> readRingData() throws LoopsAndBranchingReaderException {
        return readInformation(FilePath.RING_CALCULATOR_INFO_PATH.getURL());
    }

    @Override
    public List<String> readSymbolNumbersData() throws LoopsAndBranchingReaderException {
        return readInformation(FilePath.SYMBOL_NUMBERS_INFO_PATH.getURL());
    }

    private List<String> readInformation(String filePath) throws LoopsAndBranchingReaderException {
        try {
            List<String> lines = new ArrayList<>();
            Files.lines(Paths.get(filePath), StandardCharsets.UTF_8).forEach(lines::add);
            return lines;
        } catch (IOException e) {
            throw new LoopsAndBranchingReaderException(e);
        }
    }
}
