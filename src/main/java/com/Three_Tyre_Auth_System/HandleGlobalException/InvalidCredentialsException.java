package com.Three_Tyre_Auth_System.HandleGlobalException;

public class InvalidCredentialsException extends RuntimeException {
    public InvalidCredentialsException(String message) {
        super(message);
    }
}
