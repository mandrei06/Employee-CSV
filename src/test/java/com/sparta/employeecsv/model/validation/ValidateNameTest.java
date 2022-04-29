package com.sparta.employeecsv.model.validation;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ValidateNameTest {

    @Test
    void isValidTrue() {
        assertTrue(ValidateName.isValid("Callum"));
    }

    @Test
    void isValidNumber() {
        assertFalse(ValidateName.isValid("123456"));
    }
    @Test
    void isValidCharacter() {
        assertFalse(ValidateName.isValid("A"));
    }


}