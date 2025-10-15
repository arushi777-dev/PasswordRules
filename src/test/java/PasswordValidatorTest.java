
import org.authentication.PasswordValidator;
import org.authentication.exceptionhandler.InvalidPasswordException;
import org.junit.Test;

import static org.junit.Assert.*;

public class PasswordValidatorTest {

    @Test
    public void testValidPassword() {
        try {
            assertTrue(PasswordValidator.validatePassword("Zabc123478"));
        } catch (InvalidPasswordException e) {
            fail("Exception should not have been thrown for valid passwords");
        }
    }

    @Test
    public void testPasswordMissingLowercaseCharacter() {
        try {
            PasswordValidator.validatePassword("ABCDER123");
            fail("Exception should have been thrown for an invalid password");
        } catch (InvalidPasswordException e) {
            assertEquals("Invalid password : Password should have atleast one lowercase letter", e.getMessage());
        }
    }

    @Test
    public void testPasswordNotSatisfyingThreeRuleCriteria() {
        try {
            PasswordValidator.validatePassword("abcvfftyjjhjh");
            fail("Exception should have been thrown for an invalid password");
        } catch (InvalidPasswordException e) {
            assertEquals("Invalid password : Password does not meet required criteria", e.getMessage());
        }
    }

}
