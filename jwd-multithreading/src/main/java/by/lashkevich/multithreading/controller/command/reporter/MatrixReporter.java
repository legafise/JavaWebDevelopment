package by.lashkevich.multithreading.controller.command.reporter;

import by.lashkevich.multithreading.entity.Matrix;
import by.lashkevich.multithreading.view.locale.LocaleReader;

public class MatrixReporter {
    private static final String MATRIX_BEFORE_CHANGING_INFO_MESSAGE_KEY = "reporter.matrix.before.changing.message";
    private static final String MATRIX_AFTER_FILLING_INFO_MESSAGE_KEY = "reporter.matrix.after.changing.message";
    private static final String QUEUE_FILLING_METHOD_MESSAGE_KEY = "reporter.queue.filling.method.message";
    private static final String SET_FILLING_METHOD_MESSAGE_KEY = "reporter.set.filling.method.message";
    private static final String LOCK_FILLING_METHOD_MESSAGE_KEY = "reporter.lock.filling.method.message";
    private static final String SEMAPHORE_FILLING_METHOD_MESSAGE_KEY = "reporter.semaphore.filling.method.message";
    private static final String BOOLEAN_VARIABLE_FILLING_METHOD_MESSAGE_KEY = "reporter.boolean.variable" +
            ".filling.method.message";
    private final LocaleReader localeReader;

    public MatrixReporter() {
        localeReader = LocaleReader.getInstance();
    }

    public void reportMatrixInfoBeforeChange(Matrix matrix) {
        System.out.println(localeReader.readMessageFromBundle(MATRIX_BEFORE_CHANGING_INFO_MESSAGE_KEY) + matrix);
    }

    public void reportMatrixInfoAfterFillWithQueue(Matrix matrix) {
        reportMatrixInfoAfterFilling(matrix, QUEUE_FILLING_METHOD_MESSAGE_KEY);
    }

    public void reportMatrixInfoAfterFillWithLock(Matrix matrix) {
        reportMatrixInfoAfterFilling(matrix, LOCK_FILLING_METHOD_MESSAGE_KEY);
    }

    public void reportMatrixInfoAfterFillWithSemaphore(Matrix matrix) {
        reportMatrixInfoAfterFilling(matrix, SEMAPHORE_FILLING_METHOD_MESSAGE_KEY);
    }

    public void reportMatrixInfoAfterFillWithBooleanVariable(Matrix matrix) {
        reportMatrixInfoAfterFilling(matrix, BOOLEAN_VARIABLE_FILLING_METHOD_MESSAGE_KEY);
    }

    public void reportMatrixInfoAfterFillWithSet(Matrix matrix) {
        reportMatrixInfoAfterFilling(matrix, SET_FILLING_METHOD_MESSAGE_KEY);
    }

    private void reportMatrixInfoAfterFilling(Matrix matrix, String fillingMethodKey) {
        System.out.println(String.format(localeReader.readMessageFromBundle(MATRIX_AFTER_FILLING_INFO_MESSAGE_KEY),
                localeReader.readMessageFromBundle(fillingMethodKey)) + matrix);
    }
}
