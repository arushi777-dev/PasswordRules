package org.authentication.rules;

    public class DigitRule implements PasswordRules {

        @Override
        public boolean validate(String password) {
            return password.chars().anyMatch(Character::isDigit);
        }
    }

