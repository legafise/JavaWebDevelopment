package by.lashkevich.arrays.arraysutill.reporter;

import by.lashkevich.arrays.entity.ArraysArray;

import static by.lashkevich.arrays.arraysutill.reader.ArraysPropertiesReader.getInstance;

public class ArraysArrayReporter {
    private static final String RECEIVED_ARRAY_INFO_MESSAGE_KEY = "reporter.received.array.info.message";
    private static final String BUBBLE_SORT_RESULT_MESSAGE_KEY = "reporter.bubble.sort.result.info.message";
    private static final String COCKTAIL_SORT_RESULT_MESSAGE_KEY = "reporter.cocktail.sort.result.info.message";
    private static final String NEW_LINE_BREAK = "\n";

    public static void reportReceivedArrayInfo(ArraysArray array) {
        System.out.println(array.getArray().toString());
        System.out.println(getInstance().readMessageFromBundle(RECEIVED_ARRAY_INFO_MESSAGE_KEY)
                + NEW_LINE_BREAK + array);
    }

    public static void reportCocktailSortResult(ArraysArray array) {
        reportResult(array, COCKTAIL_SORT_RESULT_MESSAGE_KEY);
    }

    public static void reportBubbleSortResult(ArraysArray array) {
        reportResult(array, BUBBLE_SORT_RESULT_MESSAGE_KEY);
    }

    private static void reportResult(ArraysArray result, String resultMessageKey) {
        System.out.println(getInstance().readMessageFromBundle(resultMessageKey) + NEW_LINE_BREAK + result);
    }
}
