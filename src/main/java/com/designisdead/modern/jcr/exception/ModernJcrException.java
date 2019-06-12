package com.designisdead.modern.jcr.exception;

public class ModernJcrException extends RuntimeException {

    public ModernJcrException(String message, Throwable cause) {
        super(message, cause);
    }

    public ModernJcrException(Throwable cause) {
        super(cause);
    }

    protected ModernJcrException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
