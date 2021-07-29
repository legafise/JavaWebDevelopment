package by.lashkevich.jwd.linearprogramutil.transformer;

import by.lashkevich.jwd.exception.LinearProgramTransformerException;

import java.util.List;
import java.util.stream.Collectors;

public final class LinearProgramTransformer {
    private static final String INCORRECT_DATA_WAS_ENTERED = "Incorrect data was entered";

    private LinearProgramTransformer() {
    }

    public static List<Double> transformStringsToDoubles(List<String> strings) throws LinearProgramTransformerException {
        try {
            return strings.stream()
                    .map(Double::parseDouble)
                    .collect(Collectors.toList());
        } catch (NumberFormatException e) {
            System.out.println(INCORRECT_DATA_WAS_ENTERED);
            throw new LinearProgramTransformerException(e);
        }
    }

    public static char transformStringsToCharacter(List<String> strings) {
        return strings.get(0).charAt(0);
    }
}
