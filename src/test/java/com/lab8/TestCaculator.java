package com.lab8;

import com.lab2.Calculator;
import org.testng.Assert;
import org.testng.annotations.Test;



public class TestCaculator {
    private final Calculator calculator = new Calculator();

    @Test
    void testAddition() {
        Assert.assertEquals(calculator.add(5,6), 11);
        Assert.assertNotEquals(calculator.add(5,6), 12);
    }

    @Test
    void testSubtraction() {
        Assert.assertEquals(calculator.add(9,6), 3);
        Assert.assertNotEquals(calculator.add(5,6), 12);
    }
}
