package com.webApp.groceryBookingApp.CustomExceptions;

public class NotEnoughStockException extends Exception{

    public NotEnoughStockException(String message) {
        super(message);
    }

    public NotEnoughStockException(String message, Throwable cause) {
        super(message, cause);
    }

}
