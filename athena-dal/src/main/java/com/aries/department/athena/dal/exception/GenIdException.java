package com.aries.department.athena.dal.exception;

public class GenIdException extends Exception {
    public GenIdException(String message) {
        super(message);
    }

    public GenIdException(String message, Throwable e) {
        super(message, e);
    }
}
