package com.sparta.employeecsv;

import com.sparta.employeecsv.model.validation.ValidateEmail;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmailValidateTest {

    @Test
    void isValidTrue() {

        assertTrue(ValidateEmail.isValid("a.b@gmail.com"));
    }

    @Test
    void isValidFalse() {

        assertFalse(ValidateEmail.isValid("a/b@gmail,com"));
    }
}