package com.lab3;

import com.lab2.Calculator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CalculatorTest {
    private Calculator cal;

    @BeforeEach
    void setUp(){
        cal = new Calculator();
    }

    @Test
    void testDivideByZero() {
        Exception exception = assertThrows(ArithmeticException.class, () -> cal.divide(10, 0));
        assertEquals("Cannot divide by zero", exception.getMessage());
    }

    @Test
    void testParseInvalidNumber() {
        assertThrows(NumberFormatException.class, () -> cal.parseNumber("asd"));
    }

    @Test
    void testParseNull(){
        Exception exception = assertThrows(NullPointerException.class, () -> cal.parseNumber(null));
        assertEquals("Input is null", exception.getMessage());
    }
}
