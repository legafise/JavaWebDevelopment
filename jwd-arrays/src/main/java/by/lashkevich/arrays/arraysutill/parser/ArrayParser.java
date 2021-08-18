package by.lashkevich.arrays.arraysutill.parser;

import by.lashkevich.arrays.entity.ArraysArray;

import java.util.List;

public interface ArrayParser {
    ArraysArray<Number> parseArray(List<String> arrayData);

    String getType();
}
