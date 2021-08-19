package by.lashkevich.arrays.arraysutill.parser.impl;

import by.lashkevich.arrays.arraysutill.parser.ArrayParser;
import by.lashkevich.arrays.entity.ArraysArray;

import java.util.List;

/**
 * @see by.lashkevich.arrays.arraysutill.parser.ArrayParser
 */
public class ArraysByteArrayParser implements ArrayParser {
    private static final String READABLE_TYPE = "Byte";

    @Override
    public ArraysArray<Number> parseArray(List<String> arrayData) {
        return new ArraysArray<>(arrayData.stream()
                .map(Double::parseDouble)
                .map(Double::byteValue)
                .toArray(Byte[]::new));
    }

    @Override
    public String getType() {
        return READABLE_TYPE;
    }
}
