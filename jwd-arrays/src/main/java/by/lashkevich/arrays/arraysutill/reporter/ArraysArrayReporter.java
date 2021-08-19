package by.lashkevich.arrays.arraysutill.reporter;

import by.lashkevich.arrays.entity.ArraysArray;

import static by.lashkevich.arrays.arraysutill.reader.ArraysPropertiesReader.getInstance;

public class ArraysArrayReporter {
    private static final String RECEIVED_FILE_ARRAY_INFO_MESSAGE_KEY = "reporter.received.file.array.info.message";
    private static final String RECEIVED_RANDOM_ARRAY_INFO_MESSAGE_KEY = "reporter.received.random.array.info.message";
    private static final String BUBBLE_SORT_RESULT_MESSAGE_KEY = "reporter.bubble.sort.result.info.message";
    private static final String COCKTAIL_SORT_RESULT_MESSAGE_KEY = "reporter.cocktail.sort.result.info.message";
    private static final String SELECTION_SORT_RESULT_MESSAGE_KEY = "reporter.selection.sort.result.info.message";
    private static final String INSERTION_SORT_RESULT_MESSAGE_KEY = "reporter.insertion.sort.result.info.message";
    private static final String SHELL_SORT_RESULT_MESSAGE_KEY = "reporter.shell.sort.result.info.message";
    private static final String NEW_LINE_BREAK = "\n";

    public static void reportReceivedFileArrayInfo(ArraysArray<Number> array, String arrayTypeInfo) {
        System.out.println(String.format(getInstance().readMessageFromBundle(RECEIVED_FILE_ARRAY_INFO_MESSAGE_KEY),
                arrayTypeInfo) + NEW_LINE_BREAK + array);
    }

    public static void reportReceivedRandomArrayInfo(ArraysArray<Number> array) {
        System.out.println(getInstance().readMessageFromBundle(RECEIVED_RANDOM_ARRAY_INFO_MESSAGE_KEY)
                + NEW_LINE_BREAK + array);
    }

    public static void reportCocktailSortResult(ArraysArray<Number> array) {
        reportResult(array, COCKTAIL_SORT_RESULT_MESSAGE_KEY);
    }

    public static void reportBubbleSortResult(ArraysArray<Number> array) {
        reportResult(array, BUBBLE_SORT_RESULT_MESSAGE_KEY);
    }

    public static void reportSelectionSortResult(ArraysArray<Number> array) {
        reportResult(array, SELECTION_SORT_RESULT_MESSAGE_KEY);
    }

    public static void reportInsertionSortResult(ArraysArray<Number> array) {
        reportResult(array, INSERTION_SORT_RESULT_MESSAGE_KEY);
    }

    public static void reportShellSortResult(ArraysArray<Number> array) {
        reportResult(array, SHELL_SORT_RESULT_MESSAGE_KEY);
    }

    private static void reportResult(ArraysArray<Number> result, String resultMessageKey) {
        System.out.println(getInstance().readMessageFromBundle(resultMessageKey) + NEW_LINE_BREAK + result);
    }
}
