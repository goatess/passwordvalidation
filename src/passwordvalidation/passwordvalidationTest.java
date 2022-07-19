package passwordvalidation;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class passwordvalidationTest {
 
    @Test 
    public void validate_password_when_it_has_more_than_8_characters(){
        final String MORE_THAN_EIGHT_CHAR_PASSWORD = "1234567890"; 
        PasswordValidation validation = new PasswordValidation();
        assertTrue(MORE_THAN_EIGHT_CHAR_PASSWORD, validation.isLargerThanEightChar(MORE_THAN_EIGHT_CHAR_PASSWORD));
    }

    @Test 
    public void dont_validate_password_when_it_has_less_than_8_characters(){
        final String EIGHT_OR_LESS_CHAR_PASSWORD = "12345678"; 
        PasswordValidation validation = new PasswordValidation();
        assertFalse(EIGHT_OR_LESS_CHAR_PASSWORD, validation.isLargerThanEightChar(EIGHT_OR_LESS_CHAR_PASSWORD));
    }

    @Test
    public void validate_password_when_it_has_a_capital_letter(){
        final String CAPITAL_LETTER_PASSWORD = "A";
        PasswordValidation validation = new PasswordValidation();
        assertTrue(validation.hasCapitalLetter(CAPITAL_LETTER_PASSWORD));
    }

    @Test
    public void dont_validate_password_when_it_doesnt_have_a_capital_letter(){
        final String WITHOUT_CAPITAL_LETTER_PASSWORD = "a";
        PasswordValidation validation = new PasswordValidation();
        assertFalse(validation.hasCapitalLetter(WITHOUT_CAPITAL_LETTER_PASSWORD));
    }

    @Test
    public void validate_password_when_it_has_a_lower_letter(){
        final String LOWER_LETTER_PASSWORD = "a";
        PasswordValidation validation = new PasswordValidation();
        assertTrue(validation.hasLowerLetter(LOWER_LETTER_PASSWORD));
    }

    @Test
    public void dont_validate_password_when_it_doesnt_have_a_lower_letter(){
        final String WITHOUT_LOWER_LETTER_PASSWORD = "A";
        PasswordValidation validation = new PasswordValidation();
        assertFalse(validation.hasLowerLetter(WITHOUT_LOWER_LETTER_PASSWORD));
    }

    @Test
    public void validate_password_when_it_has_a_number(){
        final String NUMBER_PASSWORD = "12";
        PasswordValidation validation = new PasswordValidation();
        assertTrue(validation.hasNumber(NUMBER_PASSWORD));
    }

    @Test
    public void dont_validate_password_when_it_doesnt_have_a_number(){
        final String WITHOUT_NUMBER_PASSWORD = "armario";
        PasswordValidation validation = new PasswordValidation();
        assertFalse(validation.hasNumber(WITHOUT_NUMBER_PASSWORD));
    }
    @Test
    public void validate_password_when_it_has_an_underscore(){
        final String UNDERSCORE_PASSWORD = "armario_";
        PasswordValidation validation = new PasswordValidation();
        assertTrue(validation.hasUnderscore(UNDERSCORE_PASSWORD));
    }

    @Test
    public void dont_validate_password_when_it_doesnt_have_an_underscore(){
        final String WITHOUT_UNDERSCORE_PASSWORD = "armario";
        PasswordValidation validation = new PasswordValidation();
        assertFalse(validation.hasUnderscore(WITHOUT_UNDERSCORE_PASSWORD));
    }

    @Test
    public void return_when_a_password_is_valid(){
        final String VALID_PASSWORD = "A_rmari_0";
        PasswordValidation validation = new PasswordValidation();
        assertTrue(validation.isValid(VALID_PASSWORD));
    }

    @Test
    public void return_when_a_password_is_invalid(){
        final String NO_UNDERSCORE_PASSWORD = "ArmariII0";
        final String NO_CAPITAL_PASSWORD = "a_rmari_0";
        final String NO_LOWER_PASSWORD = "A_RMARI_0";
        final String EIGHT_CHAR_PASSWORD = "Armari_0";
        final String NO_NUMBER_PASSWORD = "A_rmari_O";

        PasswordValidation validation = new PasswordValidation();
        assertFalse(validation.isValid(NO_UNDERSCORE_PASSWORD));
        assertFalse(validation.isValid(NO_CAPITAL_PASSWORD));
        assertFalse(validation.isValid(NO_LOWER_PASSWORD));
        assertFalse(validation.isValid(EIGHT_CHAR_PASSWORD));
        assertFalse(validation.isValid(NO_NUMBER_PASSWORD));
    }
}
