package by.lashkevich.arrays.arraysutill.reporter;

import by.lashkevich.arrays.entity.ArraysMatrix;

import java.util.Arrays;

import static by.lashkevich.arrays.arraysutill.reader.ArraysPropertiesReader.getInstance;

public final class ArraysMatrixReporter {
    private static final String RECEIVED_MATRICES_INFO_MESSAGE_KEY = "reporter.received.matrices.info.message";
    private static final String MULTIPLICATION_RESULT_MESSAGE_KEY = "reporter.multiplication.result.info.message";
    private static final String ADDITION_RESULT_MESSAGE_KEY = "reporter.addition.result.info.message";
    private static final String SUBTRACTION_RESULT_MESSAGE_KEY = "reporter.subtraction.result.info.message";
    private static final String TRANSPOSE_RESULT_MESSAGE_KEY = "reporter.transpose.result.info.message";
    private static final String NEW_LINE_BREAK = "\n";

    public static void reportReceivedMatricesInfo(ArraysMatrix... matrices) {
        System.out.println(getInstance().readMessageFromBundle(RECEIVED_MATRICES_INFO_MESSAGE_KEY));
        Arrays.stream(matrices)
                .forEach(System.out::println);
    }

    public static void reportMultiplyResult(ArraysMatrix multiplicationResult) {
        reportResult(multiplicationResult, MULTIPLICATION_RESULT_MESSAGE_KEY);
    }

    public static void reportAdditionResult(ArraysMatrix additionResult) {
        reportResult(additionResult, ADDITION_RESULT_MESSAGE_KEY);
    }

    public static void reportSubtractionResult(ArraysMatrix subtractionResult) {
        reportResult(subtractionResult, SUBTRACTION_RESULT_MESSAGE_KEY);
    }

    public static void reportTransposeResult(ArraysMatrix transposeResult) {
        reportResult(transposeResult, TRANSPOSE_RESULT_MESSAGE_KEY);
    }

    private static void reportResult(ArraysMatrix result, String resultMessageKey) {
        System.out.println(getInstance().readMessageFromBundle(resultMessageKey) + NEW_LINE_BREAK + result);
    }
}
