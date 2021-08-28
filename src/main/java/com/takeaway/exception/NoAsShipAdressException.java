package com.takeaway.exception;

public class NoAsShipAdressException extends Exception{
    public NoAsShipAdressException() {
        super();
    }

    public NoAsShipAdressException(String message) {
        super(message);
    }
}
