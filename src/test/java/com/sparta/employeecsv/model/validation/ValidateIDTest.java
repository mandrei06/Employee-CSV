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
        assertTrue(ValidateID.isValid("-123456"));
    }
    @Test
    void isValidString() {
        assertTrue(ValidateID.isValid("abcdef"));
    }
    @Test
    void isValidMixed() {
        assertTrue(ValidateID.isValid("1a3b5"));
    }
}