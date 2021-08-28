package com.takeaway.exception;

public class NoAsGoodsException extends Exception{
    public NoAsGoodsException() {
        super();
    }

    public NoAsGoodsException(String message) {
        super(message);
    }
}
