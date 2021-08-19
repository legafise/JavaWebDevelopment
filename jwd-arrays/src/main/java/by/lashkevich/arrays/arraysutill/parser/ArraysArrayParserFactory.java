package by.lashkevich.arrays.arraysutill.parser;

import by.lashkevich.arrays.arraysutill.parser.impl.ArrayParserType;
import by.lashkevich.arrays.exception.ArraysParserException;

/**
 * Factory for choosing parser implementation.
 * @author Roman Lashkevich
 */
public class ArraysArrayParserFactory {
    private static ArraysArrayParserFactory instance;
    private int parserNumber;

    private ArraysArrayParserFactory() {
    }

    public static ArraysArrayParserFactory getInstance() {
        if (instance == null) {
            instance = new ArraysArrayParserFactory();
            instance.setStandardParserNumber();
        }

        return instance;
    }

    public void setStandardParserNumber() {
        this.parserNumber = 1;
    }

    public void setParserNumber(int parserNumber) {
        this.parserNumber = parserNumber;
    }

    public ArrayParser createArrayParser() throws ArraysParserException {
        return ArrayParserType.findArrayParser(parserNumber).getParser();
    }
}
