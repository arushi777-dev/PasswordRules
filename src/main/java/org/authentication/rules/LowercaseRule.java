package org.authentication.rules;

public class LowercaseRule implements PasswordRules {

    @Override
    public boolean validate(String password) {
        return password.chars().anyMatch(Character::isLowerCase);
    }
}
