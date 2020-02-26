package com.rubberdougie.calc;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Calculator {

	static int index = 1;

	public static void main(String[] args) {

		/*
		 * private void validate(String input) { String decimalRegex =
		 * "-?((\\d*\\.\\d+)|(\\d+))"; String operatorsRegex = "[-+*x\\/]"; String
		 * expressionRegex = decimalRegex + operatorsRegex + decimalRegex; Pattern
		 * operandPattern = Pattern.compile(decimalRegex); Matcher matcher =
		 * operandPattern.matcher(input); if (input.matches(expressionRegex)) {
		 * matcher.find(); double operand1 =
		 * Double.parseDouble(input.substring(matcher.start(), matcher.end())); char
		 * operator = input.charAt(matcher.end()); double operand2 =
		 * Double.parseDouble(input.substring(matcher.end() + 1)); calculate(operand1,
		 * operator, operand2); } else { System.out.println("Invalid Expression"); } }
		 */
		String token = getInput();
		System.out.println();

		int operatorIndex = getOperatorIndex(token);

		char operator = token.charAt(operatorIndex);

		Long result = evaluate(Integer.parseInt(token.substring(0, operatorIndex)),
				Integer.parseInt(token.substring(operatorIndex + 1, token.length())), operator);

		try {
			if (!result.equals(null)) {
				System.out.println(result);
			}
		} catch (NullPointerException e) {
			System.out.println("third divide or mod by zero case");
		}
	}

	static String getInput() {
		Scanner scan = new Scanner(System.in);
		System.out.println(
				"Enter the integral (whole number), 2-component arithmetic expression to be evaluated, without whitespace.");
		String result = scan.next();
		scan.close();
		return result;
	}

	static int getOperatorIndex(String input) {
		List<Character> operators = new ArrayList<Character>(List.of('+', '-', 'x', '*', '/', '%'));

		for (; !operators.contains(input.charAt(index)); index++) {

		}

		return index;
	}

	static Long evaluate(int arg1, int arg2, char operator) {
		Long result = 0L;

		switch (operator) {
		case '+': {
			result = plus(arg1, arg2);
			break;
		}

		case '-': {
			result = minus(arg1, arg2);
			break;
		}

		case 'x': {
		}

		case '*': {
			result = times(arg1, arg2);
			break;
		}

		case '/': {
			try {
				result = dividedBy(arg1, arg2);
			} catch (Exception e) {
				System.out.println("You again!?");
				result = null;
			} finally {
				break;
			}
		}

		case '%': {
			try {
				result = modulo(arg1, arg2);
			} catch (Exception e) {
				System.out.println("You again!?");
				result = null;
			} finally {
				break;
			}
		}
		}

		return result;
	}

	static long plus(int arg1, int arg2) {
		return arg1 + arg2;
	}

	static long minus(int arg1, int arg2) {
		return arg1 - arg2;
	}

	static long times(int arg1, int arg2) {
		return arg1 * arg2;
	}

	static long dividedBy(int arg1, int arg2) throws Exception {
		long result = 0;

		try {
			result = arg1 / arg2;
		} catch (ArithmeticException e) {
			System.out.println("Why are you dividng by 0, fool?");
			throw new Exception("message", e);
		}
		return result;
	}

	static long modulo(int arg1, int arg2) throws Exception {
		long result = 0;

		try {
			result = arg1 % arg2;
		} catch (ArithmeticException e) {
			System.out.println("Why are you modding by 0, fool?");
			throw new Exception("message", e);
		}
		return result;
	}

}
