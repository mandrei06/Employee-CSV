package com.sparta.employeecsv;

import com.sparta.employeecsv.model.validation.ValidateEmail;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ValidateEmailTest {

    @Test
    void isValidTrue() {

        assertTrue(ValidateEmail.isValid("a.b@gmail.com"));
    }

    @Test
    void isValidNull() {
        assertFalse(ValidateEmail.isValid(null));
    }

    @Test
    void isValidFalse() {

        assertFalse(ValidateEmail.isValid("a/b@gmail,com"));
    }
}