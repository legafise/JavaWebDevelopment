package by.lashkevich.arrays.creator;

import by.lashkevich.arrays.creator.impl.ArraysFileDataCreator;
import by.lashkevich.arrays.creator.impl.ArraysRandomDataCreator;
import by.lashkevich.arrays.exception.ArraysDataCreatorException;

import java.util.Arrays;

public enum DataCreatorType {
    RANDOM_DATA_CREATOR(1) {
        @Override
        ArraysDataCreator getDataCreator() {
            return new ArraysRandomDataCreator();
        }
    },
    FILE_DATA_CREATOR(2) {
        @Override
        ArraysDataCreator getDataCreator() throws ArraysDataCreatorException {
            try {
                return new ArraysFileDataCreator();
            } catch (ArraysDataCreatorException e) {
                throw new ArraysDataCreatorException(e.getMessage());
            }
        }
    };

    private static final String INVALID_VALUE_ERROR_MESSAGE = "Invalid value was entered";
    private int dataCreatorNumber;

    DataCreatorType(int dataCreatorNumber) {
        this.dataCreatorNumber = dataCreatorNumber;
    }

    public int getDataCreatorNumber() {
        return dataCreatorNumber;
    }

    abstract ArraysDataCreator getDataCreator() throws ArraysDataCreatorException;

    public static DataCreatorType findDataCreator(int number) throws ArraysDataCreatorException {
        return Arrays.stream(DataCreatorType.values())
                .filter(dataCreatorType -> number == dataCreatorType.getDataCreatorNumber())
                .findAny().orElseThrow(() -> new ArraysDataCreatorException(INVALID_VALUE_ERROR_MESSAGE));
    }
}
