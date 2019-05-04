package com.aries.department.athena.client.thrift.exception;

public class CallFailedException extends Exception {
    public CallFailedException() {
    }

    public CallFailedException(String message) {
        super(message);
    }

    public CallFailedException(String message, Throwable cause) {
        super(message, cause);
    }

    public CallFailedException(Throwable cause) {
        super(cause);
    }

    public CallFailedException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
