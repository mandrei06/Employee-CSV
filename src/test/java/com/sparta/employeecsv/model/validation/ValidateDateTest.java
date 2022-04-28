package com.sparta.employeecsv.model.validation;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ValidateDateTest {

    @Test
    void isValidTrue() {
        assertTrue(ValidateDate.isValid("13/10/1990"));
    }
    @Test
    void isValidInvalidDay() {
        assertFalse(ValidateDate.isValid("32/10/1990"));
    }
    @Test
    void isValidInvalidMonth() {
        assertFalse(ValidateDate.isValid("30/13/1990"));
    }

    @Test
    void isValidInvalidCombination() {
        assertFalse(ValidateDate.isValid("31/2/1990"));
    }
}