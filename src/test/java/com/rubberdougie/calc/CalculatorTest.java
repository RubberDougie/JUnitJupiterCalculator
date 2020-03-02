package com.rubberdougie.calc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.aggregator.ArgumentsAccessor;
import org.junit.jupiter.params.provider.CsvSource;

@Execution(ExecutionMode.CONCURRENT)
class CalculatorTest {

	final Calculator calculator = new Calculator();

	// @Test void testGetInput() { fail("Not yet implemented"); }

	@DisplayName("Test extraction of the operator")
	@Test
	void testGetOperatorIndex() {
		assertEquals(5, Calculator.getOperatorIndex("34213-342"));
		assertNotEquals(6, Calculator.getOperatorIndex("34213-+342"));
		assertNotEquals(6, Calculator.getOperatorIndex("34213-342"));
	}

	@DisplayName("Test successful evaluation")
	@ParameterizedTest
	@CsvSource({ "4,2,2,+", "2,5,3,-", "6,3,2,x", "6,3,2,*", "4,12,3,/", "null,12,0,/", "3,7,4,%", "null,12,0,%" })
	void testEvaluate(ArgumentsAccessor arguments) {

		if (arguments.getString(0).equals("null")) {
			assertEquals(null,
					Calculator.evaluate(arguments.getInteger(1), arguments.getInteger(2), arguments.getCharacter(3)));
		} else {
			assertEquals(arguments.getLong(0),
					Calculator.evaluate(arguments.getInteger(1), arguments.getInteger(2), arguments.getCharacter(3)));
		}

	}
	/*
	 * void testEvaluate() { assertEquals(4, Calculator.evaluate(2, 2, '+'));
	 * assertEquals(2, Calculator.evaluate(5, 3, '-')); assertEquals(6,
	 * Calculator.evaluate(3, 2, 'x')); assertEquals(6, Calculator.evaluate(3, 2,
	 * '*')); assertEquals(4, Calculator.evaluate(12, 3, '/')); assertEquals(null,
	 * Calculator.evaluate(12, 0, '/')); assertEquals(3, Calculator.evaluate(7, 4,
	 * '%')); assertEquals(null, Calculator.evaluate(12, 0, '%')); }
	 */

	@Test
	void testFailureEvaluate() {
		assertNotEquals(7, Calculator.evaluate(2, 2, '+'));
	}

	@DisplayName("Test the plus function")
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
