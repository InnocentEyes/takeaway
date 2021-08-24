package com.takeaway.exception;

public class NotEnoughtException extends RuntimeException{
    public NotEnoughtException() {
        super();
    }

    public NotEnoughtException(String message) {
        super(message);
    }
}
