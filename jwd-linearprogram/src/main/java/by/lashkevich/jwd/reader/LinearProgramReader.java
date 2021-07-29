package by.lashkevich.jwd.reader;

import by.lashkevich.jwd.exception.LinearProgramReaderException;

import java.util.List;

public interface LinearProgramReader {
    List<String> readTriangleData() throws LinearProgramReaderException;

    List<String> readPointData() throws LinearProgramReaderException;

    List<String> readSquareRootFormulaData() throws LinearProgramReaderException;

    List<String> readRingData() throws LinearProgramReaderException;

    List<String> readSymbolNumbersData() throws LinearProgramReaderException;
}
