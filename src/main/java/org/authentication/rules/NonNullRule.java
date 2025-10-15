package org.authentication.rules;

public class NonNullRule implements PasswordRules {

    private static final String NULL = "null";
    @Override
    public boolean validate(String password) {
        return password != null && !password.trim().isEmpty() && !password.equalsIgnoreCase("null") && password.length() > 8;
    }
}
