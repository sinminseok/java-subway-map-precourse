package subway.utils;

import java.util.function.Supplier;

public class Retry {
    public static <T> T retryOnExceptionWithResult(final Supplier<T> operation) {
        try {
            return operation.get();
        } catch (IllegalArgumentException exception) {
            return retryOnExceptionWithResult(operation);
        }
    }

    public static void retryOnExceptionWithoutResult(final Runnable operation) {
        try {
            operation.run();
        } catch (IllegalArgumentException exception) {
            retryOnExceptionWithoutResult(operation);
        }
    }
}
