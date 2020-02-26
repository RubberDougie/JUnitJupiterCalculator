package com.rubberdougie.calc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.Test;

class CalculatorTest {

	final Calculator calculator = new Calculator();

	// @Test void testGetInput() { fail("Not yet implemented"); }

	@Test
	void testGetOperatorIndex() {
		assertEquals(5, Calculator.getOperatorIndex("34213-342"));
		assertNotEquals(6, Calculator.getOperatorIndex("34213-+342"));
		assertNotEquals(6, Calculator.getOperatorIndex("34213-342"));
	}

	@Test
	void testEvaluate() {
		assertEquals(4, Calculator.evaluate(2, 2, '+'));
		assertEquals(2, Calculator.evaluate(5, 3, '-'));
		assertEquals(6, Calculator.evaluate(3, 2, 'x'));
		assertEquals(6, Calculator.evaluate(3, 2, '*'));
		assertEquals(4, Calculator.evaluate(12, 3, '/'));
		assertEquals(null, Calculator.evaluate(12, 0, '/'));
		assertEquals(3, Calculator.evaluate(7, 4, '%'));
		assertEquals(null, Calculator.evaluate(12, 0, '%'));
		assertNotEquals(7, Calculator.evaluate(2, 2, '+'));
	}

	@Test
	void testPlus() {
		assertEquals(4, Calculator.plus(3, 1));
		assertNotEquals(5, Calculator.plus(3, 1));
	}

	@Test
	void testMinus() {
		assertEquals(2, Calculator.minus(3, 1));
		assertNotEquals(5, Calculator.minus(3, 1));
	}

	@Test
	void testTimes() {
		assertEquals(6, Calculator.times(3, 2));
	}

	@Test
	void testDividedBy() throws Exception {
		assertEquals(4, Calculator.dividedBy(12, 3));
	}

	@Test
	void testModulo() throws Exception {
		assertEquals(3, Calculator.modulo(7, 4));
	}

}
