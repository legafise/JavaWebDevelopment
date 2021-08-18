package by.lashkevich.arrays.arraysutill.parser.impl;

import by.lashkevich.arrays.arraysutill.parser.ArrayParser;
import by.lashkevich.arrays.entity.ArraysArray;

import java.util.List;

public class ArraysFloatArrayParser implements ArrayParser {
    private static final String READABLE_TYPE = "Float";

    @Override
    public ArraysArray<Number> parseArray(List<String> arrayData) {
        return new ArraysArray<>(arrayData.stream()
                .map(Float::parseFloat)
                .toArray(Float[]::new));
    }

    @Override
    public String getType() {
        return READABLE_TYPE;
    }
}
