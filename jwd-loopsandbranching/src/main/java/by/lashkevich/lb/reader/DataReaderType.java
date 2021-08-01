package by.lashkevich.lb.reader;

import by.lashkevich.lb.exception.LoopsAndBranchingReaderException;
import by.lashkevich.lb.reader.impl.LoopsAndBranchingConsoleReader;
import by.lashkevich.lb.reader.impl.LoopsAndBranchingFileReader;

import java.util.Arrays;

public enum DataReaderType {
    CONSOLE_DATA_READER(new LoopsAndBranchingConsoleReader(), 1),
    FILE_DATA_READER(new LoopsAndBranchingFileReader(), 2);

    private static final String INVALID_VALUE_ERROR_MESSAGE = "Invalid value was entered";
    private final LoopsAndBranchingReader reader;
    private int dataReaderNumber;

    DataReaderType(LoopsAndBranchingReader reader, int dataReaderNumber) {
        this.reader = reader;
        this.dataReaderNumber = dataReaderNumber;
    }

    public LoopsAndBranchingReader getDataReader() {
        return reader;
    }

    public int getDataReaderNumber() {
        return dataReaderNumber;
    }

    public static DataReaderType findDataReader(int number) throws LoopsAndBranchingReaderException {
        return Arrays.stream(DataReaderType.values())
                .filter(dataCreatorType -> number == dataCreatorType.getDataReaderNumber())
                .findAny().orElseThrow(() -> new LoopsAndBranchingReaderException(INVALID_VALUE_ERROR_MESSAGE));
    }
}
