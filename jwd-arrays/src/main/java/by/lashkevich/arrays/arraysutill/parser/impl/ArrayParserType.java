package by.lashkevich.arrays.arraysutill.parser.impl;

import by.lashkevich.arrays.arraysutill.parser.ArrayParser;
import by.lashkevich.arrays.exception.ArraysParserException;

import java.util.Arrays;

public enum ArrayParserType {
    BYTE_ARRAY_PARSER(new ArraysByteArrayParser(), 1),
    INTEGER_ARRAY_PARSER(new ArraysIntegerArrayParser(), 2),
    LONG_ARRAY_PARSER(new ArraysLongArrayParser(), 3),
    DOUBLE_ARRAY_PARSER(new ArraysDoubleArrayParser(), 4),
    FLOAT_ARRAY_PARSER(new ArraysFloatArrayParser(), 5);

    private static final String INVALID_VALUE_ERROR_MESSAGE = "Invalid parser number was entered";
    private final ArrayParser parser;
    private final int parserNumber;

    ArrayParserType(ArrayParser parser, int parserNumber) {
        this.parser = parser;
        this.parserNumber = parserNumber;
    }

    public ArrayParser getParser() {
        return parser;
    }

    public int getParserNumber() {
        return parserNumber;
    }

    public static ArrayParserType findArrayParser(int number) throws ArraysParserException {
        return Arrays.stream(ArrayParserType.values())
                .filter(parserType -> number == parserType.getParserNumber())
                .findAny().orElseThrow(() -> new ArraysParserException(INVALID_VALUE_ERROR_MESSAGE));
    }
}
