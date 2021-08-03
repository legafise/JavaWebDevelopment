package by.lashkevich.lb.reader;

import by.lashkevich.lb.exception.LoopsAndBranchingReaderException;

import java.util.List;

public interface LoopsAndBranchingReader {
    List<String> readTriangleData() throws LoopsAndBranchingReaderException;

    List<String> readPointData() throws LoopsAndBranchingReaderException;

    List<String> readSquareRootFormulaData() throws LoopsAndBranchingReaderException;

    List<String> readRingData() throws LoopsAndBranchingReaderException;

    List<String> readSymbolNumbersData() throws LoopsAndBranchingReaderException;

    List<String> readTwoConditionFunctionData() throws LoopsAndBranchingReaderException;

    List<String> readDateValidatorTaskData() throws LoopsAndBranchingReaderException;
}
