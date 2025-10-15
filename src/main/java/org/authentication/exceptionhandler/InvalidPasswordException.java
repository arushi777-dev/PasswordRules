package org.authentication.exceptionhandler;

public class InvalidPasswordException extends Exception {

    public InvalidPasswordException(String message) {
        super(message);
    }
}
