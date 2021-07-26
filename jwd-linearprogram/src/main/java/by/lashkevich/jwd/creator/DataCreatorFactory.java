package by.lashkevich.jwd.creator;

import by.lashkevich.jwd.exception.LinearProgramDataCreatorException;

public final class DataCreatorFactory {
    private static DataCreatorFactory instance;
    private int dataCreatorNumber;

    private DataCreatorFactory() {
    }

    public static DataCreatorFactory getInstance() {
        if (instance == null) {
           instance = new DataCreatorFactory();
           instance.setDefaultDataCreatorNumber();
        }

        return instance;
    }

    public void setDataCreatorNumber(int dataCreatorNumber) {
        this.dataCreatorNumber = dataCreatorNumber;
    }

    public void setDefaultDataCreatorNumber() {
        this.dataCreatorNumber = 0;
    }

    public DataCreator createDataCreator() throws LinearProgramDataCreatorException {
        return DataCreatorType.findDataCreator(dataCreatorNumber).getDataCreator();
    }
}
