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

/**
 * Loops and branching reader implementation for
 * reading data from file
 * @author Roman Lashkevich
 * @see by.lashkevich.lb.reader.LoopsAndBranchingReader
 */
public class LoopsAndBranchingFileReader implements LoopsAndBranchingReader {
    public LoopsAndBranchingFileReader() {
    }

    @Override
    public List<String> readTriangleData() throws LoopsAndBranchingReaderException {
        return readInformation(FilePath.TRIANGLE_CALCULATOR_INFO_PATH.getURL());
    }

    @Override
    public List<String> readPointOnAreaData() throws LoopsAndBranchingReaderException {
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

    @Override
    public List<String> readTwoConditionFunctionData() throws LoopsAndBranchingReaderException {
        return readInformation(FilePath.TWO_CONDITION_FUNCTION_INFO_PATH.getURL());
    }

    @Override
    public List<String> readDateValidatorTaskData() throws LoopsAndBranchingReaderException {
        return readInformation(FilePath.DATE_VALIDATOR_INFO_PATH.getURL());
    }

    @Override
    public List<String> readLeastSquareFinderTaskData() throws LoopsAndBranchingReaderException {
        return readInformation(FilePath.LEAST_SQUARE_FINDER_INFO_PATH.getURL());
    }

    @Override
    public List<String> readPointDistanceFromOriginData() throws LoopsAndBranchingReaderException {
        return readInformation(FilePath.POINT_DISTANCE_FROM_ORIGIN_INFO_PATH.getURL());
    }

    @Override
    public List<String> readAccessCheckerData() throws LoopsAndBranchingReaderException {
        return readInformation(FilePath.ACCESS_CHECKER_INFO_PATH.getURL());
    }

    @Override
    public List<String> readFunctionWithStepData() throws LoopsAndBranchingReaderException {
        return readInformation(FilePath.FUNCTION_WITH_STEP_INFO_PATH.getURL());
    }

    @Override
    public List<String> readTrigonometricFunctionData() throws LoopsAndBranchingReaderException {
        return readInformation(FilePath.TRIGONOMETRIC_FUNCTION_INFO_PATH.getURL());
    }

    @Override
    public List<String> readLargestDigitFinderData() throws LoopsAndBranchingReaderException {
        return readInformation(FilePath.LARGEST_DIGIT_FINDER_INFO_PATH.getURL());
    }

    @Override
    public List<String> readArithmeticProgressionCheckerData() throws LoopsAndBranchingReaderException {
        return readInformation(FilePath.ARITHMETIC_PROGRESSION_CHECKER_INFO_PATH.getURL());
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
