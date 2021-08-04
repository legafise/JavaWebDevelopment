package by.lashkevich.lb.reader;

import by.lashkevich.lb.exception.LoopsAndBranchingReaderException;

import java.util.List;

public interface LoopsAndBranchingReader {
    List<String> readTriangleData() throws LoopsAndBranchingReaderException;

    List<String> readPointOnAreaData() throws LoopsAndBranchingReaderException;

    List<String> readSquareRootFormulaData() throws LoopsAndBranchingReaderException;

    List<String> readRingData() throws LoopsAndBranchingReaderException;

    List<String> readSymbolNumbersData() throws LoopsAndBranchingReaderException;

    List<String> readTwoConditionFunctionData() throws LoopsAndBranchingReaderException;

    List<String> readDateValidatorTaskData() throws LoopsAndBranchingReaderException;

    List<String> readLeastSquareFinderTaskData() throws LoopsAndBranchingReaderException;

    List<String> readPointDistanceFromOriginData() throws LoopsAndBranchingReaderException;

    List<String> readAccessCheckerData() throws LoopsAndBranchingReaderException;

    List<String> readFunctionWithStepData() throws LoopsAndBranchingReaderException;

    List<String> readTrigonometricFunctionData() throws LoopsAndBranchingReaderException;

    List<String> readLargestDigitFinderData() throws LoopsAndBranchingReaderException;
}
