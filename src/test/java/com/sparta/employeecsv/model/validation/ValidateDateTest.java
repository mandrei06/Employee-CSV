package com.sparta.employeecsv.model.validation;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ValidateDateTest {

    @Test
    void isValidTrue() {
        assertTrue(ValidateDate.isValid("11/27/1983"));
    }
    @Test
    void isValidInvalidDay() {
        assertFalse(ValidateDate.isValid("11/41/1990"));
    }
    @Test
    void isValidInvalidMonth() {
        assertFalse(ValidateDate.isValid("13/2/1990"));
    }
    @Test
    void isValidInvalidCombination() {
        assertFalse(ValidateDate.isValid("2/31/1990"));
    }
}