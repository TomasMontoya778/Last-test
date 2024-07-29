package com.riwi.diagnostic.test.api.excections;

public class BadRequestException extends RuntimeException{
    public BadRequestException(String message) {
        super(message);
    }
}
