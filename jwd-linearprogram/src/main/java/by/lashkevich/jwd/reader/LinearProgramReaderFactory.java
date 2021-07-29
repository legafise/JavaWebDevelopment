package by.lashkevich.jwd.reader;

import by.lashkevich.jwd.exception.LinearProgramReaderException;

public class LinearProgramReaderFactory {
    private static LinearProgramReaderFactory instance;
    private int dataReaderNumber;

    private LinearProgramReaderFactory() {
    }

    public static LinearProgramReaderFactory getInstance() {
        if (instance == null) {
            instance = new LinearProgramReaderFactory();
            instance.setConsoleReaderNumber();
        }

        return instance;
    }

    public void setConsoleReaderNumber() {
        this.dataReaderNumber = 1;
    }

    public void setFileReaderNumber() {
        this.dataReaderNumber = 2;
    }

    public void setDataReaderNumber(int dataReaderNumber) {
        this.dataReaderNumber = dataReaderNumber;
    }

    public LinearProgramReader createDataCreator() throws LinearProgramReaderException {
        return DataReaderType.findDataReader(dataReaderNumber).getDataReader();
    }
}
