package com.Three_Tyre_Auth_System.HandleGlobalException;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(String message) {
        super(message);
    }
}
