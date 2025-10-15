package org.authentication.exceptionhandler;

public class EmptyPasswordException extends InvalidPasswordException {

    public EmptyPasswordException() {
        super("Invalid password : Password should not be null or empty");
    }
}
