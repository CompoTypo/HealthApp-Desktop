package healthapp;
import healthapp.utilities.InputValidation;

import org.junit.*;
import static org.junit.Assert.*;

public class InputValidationTest {
    private InputValidation IV;

    public InputValidationTest() {
        this.IV = new InputValidation();
    }

    @Test
    public void isValidUN() {
        assertTrue(this.IV.isValidUN("1234asdfg"));
        assertTrue(this.IV.isValidUN("ISValidYes"));
        assertTrue(this.IV.isValidUN("1234567890000asdf"));

        assertFalse(this.IV.isValidUN("12345678901234567890toolong"));
        assertFalse(this.IV.isValidUN("small"));
        assertFalse(this.IV.isValidUN("rightsizebut!"));
    }

    @Test
    public void isValidPW() {
        assertTrue(this.IV.isValidPW("1234asdfg"));
        assertTrue(this.IV.isValidPW("ISValidYes"));
        //assertTrue(this.IV.isValidPW("1234567veryllooooobnfg890000asdf"));

        assertFalse(this.IV.isValidPW("12345678901234&567890toolong"));
    //    assertFalse(this.IV.isValidPW("small"));
        assertFalse(this.IV.isValidPW("rightsize_but_______"));
    }

    @Test
    public void isValidName() {
        assertTrue(this.IV.isValidName("Jeffasdfg"));
        assertTrue(this.IV.isValidName("ISValidYes"));
        assertTrue(this.IV.isValidName("Extralongnameasdf"));

        assertFalse(this.IV.isValidName("SuperlongnameDascheltoolong"));
        assertFalse(this.IV.isValidName("A"));
        assertFalse(this.IV.isValidName("rightsizebut8"));
    }

    @Test
    public void isValidEmail() {
        assertTrue(this.IV.isValidEmail("name@gmail.com"));
        assertTrue(this.IV.isValidEmail("trythins@hotmail.com"));
        assertTrue(this.IV.isValidEmail("goodjob@yahoo.com"));

        assertFalse(this.IV.isValidEmail("notanemail"));
        assertFalse(this.IV.isValidEmail("whatabout@"));
        assertFalse(this.IV.isValidEmail("@gmail"));
    }

    @Test
    public void isValidYear() {
        assertTrue(this.IV.isValidYear("1999"));
        assertTrue(this.IV.isValidYear("2004"));
        assertTrue(this.IV.isValidYear("1967"));

        assertFalse(this.IV.isValidYear("2021"));
        assertFalse(this.IV.isValidYear("8"));
        assertFalse(this.IV.isValidYear("11111"));
    }

    @Test
    public void isValidMonth() {
        assertTrue(this.IV.isValidMonth("1"));
        assertTrue(this.IV.isValidMonth("6"));
        assertTrue(this.IV.isValidMonth("12"));

        assertFalse(this.IV.isValidMonth("0"));
        assertFalse(this.IV.isValidMonth("13"));
        assertFalse(this.IV.isValidMonth("11111"));
    }

    @Test
    public void isValidDay() {
        assertTrue(this.IV.isValidDay("1"));
        assertTrue(this.IV.isValidDay("6"));
        assertTrue(this.IV.isValidDay("31"));

        assertFalse(this.IV.isValidDay("0"));
        assertFalse(this.IV.isValidDay("32"));
        assertFalse(this.IV.isValidDay("11111"));
    }

    @Test
    public void isValidSex() {
        assertTrue(this.IV.isValidSex("Male"));
        assertTrue(this.IV.isValidSex("Female"));
        assertTrue(this.IV.isValidSex("Other"));

        assertFalse(this.IV.isValidSex("Attack Helicopter"));
        assertFalse(this.IV.isValidSex("26"));
        assertFalse(this.IV.isValidSex("%^#$ADGFHAS"));
    }

    @Test
    public void isValidRace() {
        assertTrue(this.IV.isValidRace("Black"));
        assertTrue(this.IV.isValidRace("White"));
        assertTrue(this.IV.isValidRace("Other"));

        assertFalse(this.IV.isValidRace("Attack Helicopter"));
        assertFalse(this.IV.isValidRace("26"));
        assertFalse(this.IV.isValidRace("%^#$ADGFHAS"));
    }
}