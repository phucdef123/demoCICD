package com.lab2;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.lab2.Calculator;
import org.junit.jupiter.api.Test;

public class CalculatorTest {
	private final Calculator calculator = new Calculator();
	
	@Test
	void testAddition() {
		assertEquals(6, calculator.add(2, 4), "Kết quả phải bằng 6");
		assertNotEquals(6, calculator.add(5, 7), "Kết quả phải khác 6");
	}
	
	@Test
	void testSubtraction() {
		assertEquals(6, calculator.subtract(10, 4), "Kết quả phải bằng 6");
		assertNotEquals(5, calculator.subtract(10, 4), "Kết quả phải khác 5");
	}
	
	@Test
	void testMultiplication() {
		assertEquals(6, calculator.multiply(2, 3), "Kết quả phải bằng 6");
		assertNotEquals(6, calculator.multiply(5, 7), "Kết quả phải khác 6");
	}
	
	@Test
	void testDivision() {
		assertEquals(6, calculator.divide(12, 2), "Kết quả phải bằng 6");
		assertNotEquals(6, calculator.divide(5, 7), "Kết quả phải khác 6");
	}
	
	@Test
	void testNull() {
		assertNull(null, "Giá trị phải null");
	}
	
	@Test
	void testIsPositiveNumber() {
        assertTrue(calculator.divide(1, 1) > 0, "Kết quả phép chia phải lớn hơn 0");
        assertFalse(calculator.divide(-2, 1) > 0, "Kết quả phép chia phải nhỏ hơn 0");
    }
}
