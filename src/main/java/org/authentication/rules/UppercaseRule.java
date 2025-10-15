package org.authentication.rules;

public class UppercaseRule implements PasswordRules {

    @Override
    public boolean validate(String password) {
        return password.chars().anyMatch(Character::isUpperCase);
    }
}
