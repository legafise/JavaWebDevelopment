package by.lashkevich.jwd.creator;

import by.lashkevich.jwd.creator.impl.ConsoleDataCreator;
import by.lashkevich.jwd.creator.impl.FileDataCreator;
import by.lashkevich.jwd.exception.LinearProgramDataCreatorException;

import java.util.Arrays;

public enum DataCreatorType {
    CONSOLE_DATA_CREATOR(new ConsoleDataCreator()),
    FILE_DATA_CREATOR(new FileDataCreator());

    private static final String INVALID_VALUE_ERROR_MESSAGE = "Invalid value was entered";
    private final DataCreator dataCreator;

    DataCreatorType(DataCreator dataCreator) {
        this.dataCreator = dataCreator;
    }

    public DataCreator getDataCreator() {
        return dataCreator;
    }

    public static DataCreatorType findDataCreator(int number) throws LinearProgramDataCreatorException {
        return Arrays.stream(DataCreatorType.values())
                .filter(dataCreatorType -> number == dataCreatorType.ordinal())
                .findAny().orElseThrow(() -> new LinearProgramDataCreatorException(INVALID_VALUE_ERROR_MESSAGE));
    }
}
