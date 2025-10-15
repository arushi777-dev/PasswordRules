package org.authentication.exceptionhandler;

public class MissingLowerCaseException extends InvalidPasswordException {

    public MissingLowerCaseException() {
        super("Invalid password : Password should have atleast one lowercase letter");
    }
}
