package by.lashkevich.arrays.creator;

import by.lashkevich.arrays.exception.ArraysDataCreatorException;

/**
 * Factory for choosing implementation.
 * @author Roman Lashkevich
 */
public class ArraysDataCreatorFactory {
    private static ArraysDataCreatorFactory instance;
    private int dataCreatorNumber;

    private ArraysDataCreatorFactory() {
    }

    public static ArraysDataCreatorFactory getInstance() {
        if (instance == null) {
            instance = new ArraysDataCreatorFactory();
            instance.setRandomCreatorNumber();
        }

        return instance;
    }

    public void setRandomCreatorNumber() {
        this.dataCreatorNumber = 1;
    }

    public void setFileCreatorNumber() {
        this.dataCreatorNumber = 2;
    }

    public void setDataCreatorNumber(int dataCreatorNumber) {
        this.dataCreatorNumber = dataCreatorNumber;
    }

    public ArraysDataCreator createDataCreator() throws ArraysDataCreatorException {
        return DataCreatorType.findDataCreator(dataCreatorNumber).getDataCreator();
    }
}
