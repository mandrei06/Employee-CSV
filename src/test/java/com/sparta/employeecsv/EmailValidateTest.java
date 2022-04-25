package com.sparta.employeecsv;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmailValidateTest {

    @Test
    void isValidTrue() {
        EmailValidate val = new EmailValidate();

        assertEquals(true, EmailValidate.isValid("a.b@gmail.com"));
    }

    @Test
    void isValidFalse() {
        EmailValidate val = new EmailValidate();

        assertEquals(false, EmailValidate.isValid("a/b@gmail,com"));
    }
}