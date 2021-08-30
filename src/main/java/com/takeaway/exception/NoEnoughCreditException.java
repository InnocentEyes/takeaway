package com.takeaway.exception;

public class NoEnoughCreditException extends Exception{
    public NoEnoughCreditException() {
        super();
    }

    public NoEnoughCreditException(String message) {
        super(message);
    }
}
