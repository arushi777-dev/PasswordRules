package org.authentication.exceptionhandler;

public class CriteriaNotMetException extends InvalidPasswordException {

    public CriteriaNotMetException() {
        super("Invalid password : Password does not meet required criteria");
    }
}
