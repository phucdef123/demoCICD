package com.lab3;

import com.lab2.Calculator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.IOException;
import java.time.Duration;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

public class ParameterizedTestDemo {
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 6, 5, 9})
    void testIsPositive(int a) {
        assertTrue(a > 0);
    }

    @Test
    void testWithAssertAll(){
        Calculator cal = new Calculator();
        Calculator cal2 = new Calculator();
        assertAll(
                "Group of assertions",
                () -> assertTimeout(Duration.ofSeconds(2), () -> cal.divide(5, 3)),
                () -> assertNotSame(cal, cal2),
                () -> assertInstanceOf(Boolean.class, true),
                () -> assertDoesNotThrow(() -> cal.parseNumber("1"))
        );
    }
}
