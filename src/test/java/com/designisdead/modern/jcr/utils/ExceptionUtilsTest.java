package com.designisdead.modern.jcr.utils;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class ExceptionUtilsTest {

    private static void throwException() throws Exception {
        throw new Exception("some checked exception");
    }

    private static Optional throwExceptionInsteadOfReturningOptional() throws Exception {
        throw new Exception("some checked exception");
    }

    private static Object throwExceptionInsteadOfReturning() throws Exception {
        throw new Exception("some checked exception");
    }

    @Test
    void ignoreConsumerException() {
        Arrays.asList("one", "two", "three").forEach(ExceptionUtils.ignoreExceptionInConsumer(e -> throwException(), Exception.class));
    }

    @Test
    void wrapConsumerException() {
        assertThrows(RuntimeException.class, () ->
                Arrays.asList("one", "two", "three").forEach(ExceptionUtils.wrapExceptionInConsumer(e -> throwException())));
    }

    @SuppressWarnings("ResultOfMethodCallIgnored")
    @Test
    void ignoreFunctionExceptionUsingOptional() {
        Stream.of("one", "two", "three")
                .map(ExceptionUtils.ignoreExceptionInFunctionReturningOptional(e -> throwExceptionInsteadOfReturningOptional(), Exception.class))
                .peek(e -> assertFalse(e.isPresent()))
                .collect(Collectors.toList());
    }

    @SuppressWarnings("ResultOfMethodCallIgnored")
    @Test
    void ignoreFunctionException() {
        Stream.of("one", "two", "three")
                .map(ExceptionUtils.ignoreExceptionInFunction(e -> throwExceptionInsteadOfReturning(), Exception.class))
                .peek(Assertions::assertNull)
                .collect(Collectors.toList());
    }

    @SuppressWarnings("ResultOfMethodCallIgnored")
    @Test
    void wrapFunctionException() {
        assertThrows(RuntimeException.class, () ->
                Stream.of("one", "two", "three")
                        .map(ExceptionUtils.wrapExceptionInFunction(e -> throwExceptionInsteadOfReturning()))
                        .collect(Collectors.toList()));
    }
}