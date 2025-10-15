package org.authentication.rules;

import org.authentication.exceptionhandler.InvalidPasswordException;

public interface PasswordRules {
    /**
     * validates the given password against this rule
     *
     * @param password password to check
     * @return true if the rule passes
     * @throws InvalidPasswordException
     */
    boolean validate(String password) throws InvalidPasswordException;
}
