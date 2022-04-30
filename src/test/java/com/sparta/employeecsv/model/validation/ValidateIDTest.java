package com.sparta.employeecsv.model.validation;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ValidateIDTest {

    @Test
    void isValidTrue() {
        assertTrue(ValidateID.isValid("123456"));
    }
    @Test
    void isValidNegative() {
        assertFalse(ValidateID.isValid("-123456"));
    }
    @Test
    void isValidString() {
        assertFalse(ValidateID.isValid("abcdef"));
    }
    @Test
    void isValidMixed() {
        assertFalse(ValidateID.isValid("1a3b5"));
    }
}