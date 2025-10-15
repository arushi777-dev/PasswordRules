package org.authentication;

import org.authentication.exceptionhandler.CriteriaNotMetException;
import org.authentication.exceptionhandler.EmptyPasswordException;
import org.authentication.exceptionhandler.InvalidPasswordException;
import org.authentication.exceptionhandler.MissingLowerCaseException;
import org.authentication.rules.DigitRule;
import org.authentication.rules.LowercaseRule;
import org.authentication.rules.NonNullRule;
import org.authentication.rules.UppercaseRule;

import java.util.Scanner;

/**
 * Validates password for the following criteria
 * password length > 8 and should not be null or empty (mandatory)
 * password should have atleast 1 lowercase letter (mandatory)
 * password should have atleast 1 uppercase letter
 * password should have atleast 1 digit
 * password should satisfy atleast 3 criteria
 */
public class PasswordValidator {

    public static final Integer THREE = 3;

    public static void main(String[] args) {
        //Input from user
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a password : ");
        String password = scanner.nextLine();

        try {
            validatePassword(password);
            System.out.println("Valid password");
        } catch (InvalidPasswordException e) {
            System.out.println(e.getMessage());
        }
        scanner.close();
    }

    public static boolean validatePassword(String password) throws InvalidPasswordException{

        boolean isValidPassword;
        int passwordValidityRuleCount = 0;
        boolean hasLowerCase = new LowercaseRule().validate(password);
        boolean isNotNull = new NonNullRule().validate(password);
        boolean hasUpperCase = new UppercaseRule().validate(password);
        boolean hasDigit = new DigitRule().validate(password);

        if (isNotNull)
            passwordValidityRuleCount++;
        else
            throw new EmptyPasswordException();

        if (hasLowerCase) {
            passwordValidityRuleCount++;
        }

        if (hasUpperCase)
            passwordValidityRuleCount++;

        if (hasDigit)
            passwordValidityRuleCount++;

        //return true if any 3 criteria are met, lower case being a mandate and null password is not accepted
            if ((passwordValidityRuleCount >= THREE) && hasLowerCase) {
                isValidPassword = true;
            } else if (!hasLowerCase) {
                throw new MissingLowerCaseException();
            } else {
                throw new CriteriaNotMetException();
            }
            return isValidPassword;
    }
}




