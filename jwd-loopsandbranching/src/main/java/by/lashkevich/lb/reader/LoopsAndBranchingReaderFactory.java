package by.lashkevich.lb.reader;

import by.lashkevich.lb.exception.LoopsAndBranchingReaderException;

/**
 * Factory for choosing implementation.
 * @author Roman Lashkevich
 */
public class LoopsAndBranchingReaderFactory {
    private static LoopsAndBranchingReaderFactory instance;
    private int dataReaderNumber;

    private LoopsAndBranchingReaderFactory() {
    }

    public static LoopsAndBranchingReaderFactory getInstance() {
        if (instance == null) {
            instance = new LoopsAndBranchingReaderFactory();
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

    public LoopsAndBranchingReader createDataCreator() throws LoopsAndBranchingReaderException {
        return DataReaderType.findDataReader(dataReaderNumber).getDataReader();
    }
}
