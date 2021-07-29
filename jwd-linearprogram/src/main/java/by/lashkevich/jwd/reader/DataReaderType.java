package by.lashkevich.jwd.reader;

import by.lashkevich.jwd.exception.LinearProgramReaderException;
import by.lashkevich.jwd.reader.impl.LinearProgramConsoleReader;
import by.lashkevich.jwd.reader.impl.LinearProgramFileReader;

import java.util.Arrays;

public enum DataReaderType {
    CONSOLE_DATA_READER(new LinearProgramConsoleReader(), 1),
    FILE_DATA_READER(new LinearProgramFileReader(), 2);

    private static final String INVALID_VALUE_ERROR_MESSAGE = "Invalid value was entered";
    private final LinearProgramReader reader;
    private int dataReaderNumber;

    DataReaderType(LinearProgramReader reader, int dataReaderNumber) {
        this.reader = reader;
        this.dataReaderNumber = dataReaderNumber;
    }

    public LinearProgramReader getDataReader() {
        return reader;
    }

    public int getDataReaderNumber() {
        return dataReaderNumber;
    }

    public static DataReaderType findDataReader(int number) throws LinearProgramReaderException {
        return Arrays.stream(DataReaderType.values())
                .filter(dataCreatorType -> number == dataCreatorType.getDataReaderNumber())
                .findAny().orElseThrow(() -> new LinearProgramReaderException(INVALID_VALUE_ERROR_MESSAGE));
    }
}
