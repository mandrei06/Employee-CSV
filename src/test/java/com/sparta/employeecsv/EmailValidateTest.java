package com.sparta.employeecsv;

import com.sparta.employeecsv.model.EmailValidate;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmailValidateTest {

    @Test
    void isValidTrue() {

        assertTrue(EmailValidate.isValid("a.b@gmail.com"));
    }

    @Test
    void isValidFalse() {

        assertFalse(EmailValidate.isValid("a/b@gmail,com"));
    }
}