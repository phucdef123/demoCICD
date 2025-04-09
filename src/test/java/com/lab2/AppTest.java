package com.lab2;

import static org.junit.jupiter.api.Assertions.assertTrue;

import com.lab2.App;
import org.junit.jupiter.api.Test;

public class AppTest{
	@Test
	public void testIsEventNumber2() {
		App demo = new App();
		boolean result = demo.isEventNumber(2);
		assertTrue(result);
	}
	@Test
	public void testIsEventNumber4() {
		App demo = new App();
		boolean result = demo.isEventNumber(4);
		assertTrue(result);
	}
}
