package com.designisdead.modern.jcr.utils;

import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;

import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;

@UtilityClass
@Slf4j
public class ExceptionUtils {

    /**
     * Ignore exceptions of given clazz thrown by function, return empty Optional instead.
     *
     * @throws RuntimeException wrapping the original Exception for other exceptions.
     */
    public static <T, R extends Optional, E extends Exception> Function<T, Optional<R>>
    ignoreExceptionInFunctionReturningOptional(ThrowingFunction<T, R, E> function, Class<E> clazz) {

        return i -> {
            try {
                return function.apply(i);
            } catch (Exception e) {
                throwIfNotOfClass(e, clazz);
                log.debug("Ignoring exception: " + e);
                return Optional.empty();
            }
        };
    }

    /**
     * Ignore exceptions of given clazz thrown by function, return null instead.
     *
     * @throws RuntimeException wrapping the original Exception for other exceptions.
     */
    public static <T, R, E extends Exception> Function<T, R>
    ignoreExceptionInFunction(ThrowingFunction<T, R, E> function, Class<E> clazz) {

        return i -> {
            try {
                return function.apply(i);
            } catch (Exception e) {
                throwIfNotOfClass(e, clazz);
                log.debug("Ignoring exception: " + e);
                return null;
            }
        };
    }

    /**
     * Wrap any exception thrown by the function in a RuntimeException
     */
    public static <T, R, E extends Exception> Function<T, R> wrapExceptionInFunction(ThrowingFunction<T, R, E> function) {

        return i -> {
            try {
                return function.apply(i);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        };
    }

    /**
     * Ignore exceptions of given clazz thrown by consumer.
     *
     * @throws RuntimeException wrapping the original Exception for other exceptions.
     */
    public static <T, E extends Exception> Consumer<T>
    ignoreExceptionInConsumer(ThrowingConsumer<T, Exception> throwingConsumer, Class<E> clazz) {

        return i -> {
            try {
                throwingConsumer.accept(i);
            } catch (Exception e) {
                throwIfNotOfClass(e, clazz);
                log.debug("Ignoring exception: " + e);
            }
        };
    }

    /**
     * Wrap any exception thrown by the consumer in a RuntimeException
     */
    public static <T, E extends Exception> Consumer<T> wrapExceptionInConsumer(ThrowingConsumer<T, E> throwingConsumer) {

        return i -> {
            try {
                throwingConsumer.accept(i);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        };
    }

    /**
     * If exception is of clazz, return exception cast as clazz, otherwise throw RuntimeException that wraps exception.
     */
    private static <E extends Exception> E throwIfNotOfClass(Exception e, Class<E> clazz) {
        try {
            return clazz.cast(e);
        } catch (ClassCastException ccEx) {
            throw new RuntimeException(e);
        }
    }

    @FunctionalInterface
    public interface ThrowingFunction<T, R, E extends Exception> {
        R apply(T t) throws E;
    }

    @FunctionalInterface
    public interface ThrowingConsumer<T, E extends Exception> {
        void accept(T t) throws E;
    }
}
