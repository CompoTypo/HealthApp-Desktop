import org.junit.jupiter.api.Test;
import org.junit.*;

import static org.junit.Assert.*;

class InputValidationTest {

    @Test
    void isValidUN() {
        InputValidation IV = new InputValidation();
        assertTrue(IV.isValidUN("1234asdfg"));
        assertTrue(IV.isValidUN("ISValidYes"));
        assertTrue(IV.isValidUN("1234567890000asdf"));

        assertFalse(IV.isValidUN("12345678901234567890toolong"));
        assertFalse(IV.isValidUN("small"));
        assertFalse(IV.isValidUN("rightsizebut!"));
    }

    @Test
    void isValidPW() {
        InputValidation IV = new InputValidation();
        assertTrue(IV.isValidPW("1234asdfg"));
        assertTrue(IV.isValidPW("ISValidYes"));
        assertTrue(IV.isValidPW("1234567veryllooooobnfg890000asdf"));

        assertFalse(IV.isValidPW("12345678901234&567890toolong"));
        assertFalse(IV.isValidPW("small"));
        assertFalse(IV.isValidPW("rightsize_but_______"));
    }

    @Test
    void isValidName() {
        InputValidation IV = new InputValidation();
        assertTrue(IV.isValidName("Jeffasdfg"));
        assertTrue(IV.isValidName("ISValidYes"));
        assertTrue(IV.isValidName("Extralongnameasdf"));

        assertFalse(IV.isValidName("SuperlongnameDascheltoolong"));
        assertFalse(IV.isValidName("A"));
        assertFalse(IV.isValidName("rightsizebut8"));
    }

    @Test
    void isValidEmail() {
        InputValidation IV = new InputValidation();
        assertTrue(IV.isValidEmail("name@gmail.com"));
        assertTrue(IV.isValidEmail("trythins@hotmail.com"));
        assertTrue(IV.isValidEmail("goodjob@yahoo.com"));

        assertFalse(IV.isValidEmail("notanemail"));
        assertFalse(IV.isValidEmail("whatabout@"));
        assertFalse(IV.isValidEmail("@gmail"));
    }

    @Test
    void isValidYear() {
        InputValidation IV = new InputValidation();
        assertTrue(IV.isValidYear(1999));
        assertTrue(IV.isValidYear(2004));
        assertTrue(IV.isValidYear(1967));

        assertFalse(IV.isValidYear(2021));
        assertFalse(IV.isValidYear(8));
        assertFalse(IV.isValidYear(11111));
    }

    @Test
    void isValidMonth() {
        InputValidation IV = new InputValidation();
        assertTrue(IV.isValidMonth(1));
        assertTrue(IV.isValidMonth(6));
        assertTrue(IV.isValidMonth(12));

        assertFalse(IV.isValidMonth(0));
        assertFalse(IV.isValidMonth(13));
        assertFalse(IV.isValidMonth(11111));
    }

    @Test
    void isValidDay() {
        InputValidation IV = new InputValidation();
        assertTrue(IV.isValidDay(1));
        assertTrue(IV.isValidDay(6));
        assertTrue(IV.isValidDay(31));

        assertFalse(IV.isValidDay(0));
        assertFalse(IV.isValidDay(32));
        assertFalse(IV.isValidDay(11111));
    }

    @Test
    void isValidSex() {
        InputValidation IV = new InputValidation();
        assertTrue(IV.isValidSex("Male"));
        assertTrue(IV.isValidSex("Female"));
        assertTrue(IV.isValidSex("Other"));

        assertFalse(IV.isValidSex("Attack Helicopter"));
        assertFalse(IV.isValidSex("26"));
        assertFalse(IV.isValidSex("%^#$ADGFHAS"));
    }

    @Test
    void isValidRace() {
        InputValidation IV = new InputValidation();
        assertTrue(IV.isValidRace("Black"));
        assertTrue(IV.isValidRace("White"));
        assertTrue(IV.isValidRace("Other"));

        assertFalse(IV.isValidRace("Attack Helicopter"));
        assertFalse(IV.isValidRace("26"));
        assertFalse(IV.isValidRace("%^#$ADGFHAS"));
    }
}