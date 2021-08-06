package by.lashkevich.lb.loopsandbranchingutil.transformer;

import by.lashkevich.lb.exception.LoopsAndBranchingTransformerException;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Utilitarian class for transform String lists to
 * other data types
 * @author Roman Lashkevich
 */
public final class LoopsAndBranchingTransformer {
    private static final String INCORRECT_DATA_WAS_ENTERED = "Incorrect data was entered";

    private LoopsAndBranchingTransformer() {
    }

    public static List<Double> transformStringsToDoubles(List<String> strings) throws LoopsAndBranchingTransformerException {
        try {
            return strings.stream()
                    .map(Double::parseDouble)
                    .collect(Collectors.toList());
        } catch (NumberFormatException e) {
            System.out.println(INCORRECT_DATA_WAS_ENTERED);
            throw new LoopsAndBranchingTransformerException(e);
        }
    }

    public static List<Integer> transformStringsToIntegers(List<String> strings) throws LoopsAndBranchingTransformerException {
        try {
            return strings.stream()
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
        } catch (NumberFormatException e) {
            System.out.println(INCORRECT_DATA_WAS_ENTERED);
            throw new LoopsAndBranchingTransformerException(e);
        }
    }

    public static List<Long> transformStringsToLong(List<String> strings) throws LoopsAndBranchingTransformerException {
        try {
            return strings.stream()
                    .map(Long::parseLong)
                    .collect(Collectors.toList());
        } catch (NumberFormatException e) {
            System.out.println(INCORRECT_DATA_WAS_ENTERED);
            throw new LoopsAndBranchingTransformerException(e);
        }
    }

    public static char transformStringsToCharacter(List<String> strings) {
        return strings.get(0).charAt(0);
    }
}
