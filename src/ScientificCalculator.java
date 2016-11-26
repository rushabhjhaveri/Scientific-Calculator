import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class ScientificCalculator {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		squareRoot(2);
		System.out.print("Enter expression: ");
		String exp = sc.nextLine();

		Queue<String> queueOperator = new LinkedList<String>();
		Queue<String> queueNumber = new LinkedList<String>();

		// double total = 0;

		String[] arr = exp.split(" ");

		String[] ops = { "+", "-", "*", "/", "^", "tan", "cos", "sin", "(", ")" };

		ArrayList<String> k = new ArrayList<String>();

		for (int x = 0; x < arr.length; x++) {
			k.add(arr[x]);
		}

		double total = 0;

		for (int x = k.size() - 1; x >= 0; x--) {
			// "3 * 5 + 3 * 6"
			// sqrt(8)
			if (k.get(x).equals("*")) {

				if (k.get(x - 1).contains("sqrt")) {
					k.set(x - 1,
							squareRoot(Double.parseDouble(k.get(x - 1)
									.substring(k.get(x - 1).length() - 2,
											k.get(x - 1).length() - 1)))
									+ "");
				}
				if (k.get(x + 1).contains("sqrt")) {
					k.set(x + 1,
							squareRoot(Double.parseDouble(k.get(x + 1)
									.substring(k.get(x + 1).length() - 2,
											k.get(x + 1).length() - 1)))
									+ "");
				}

				if (k.get(x - 1).contains("cbrt")) {
					k.set(x - 1,
							cubeRoot(Double.parseDouble(k.get(x - 1).substring(
									k.get(x - 1).length() - 2,
									k.get(x - 1).length() - 1)))
									+ "");
				}
				if (k.get(x + 1).contains("cbrt")) {
					k.set(x + 1,
							cubeRoot(Double.parseDouble(k.get(x + 1).substring(
									k.get(x + 1).length() - 2,
									k.get(x + 1).length() - 1)))
									+ "");
				}

				if (k.get(x - 1).contains("cos")) {
					k.set(x - 1,
							cosFunction(Double.parseDouble(k.get(x - 1).substring(
									k.get(x - 1).length() - 2,
									k.get(x - 1).length() - 1)))
									+ "");
				}
				if (k.get(x + 1).contains("cos")) {
					k.set(x + 1,
							cosFunction(Double.parseDouble(k.get(x + 1).substring(
									k.get(x + 1).length() - 2,
									k.get(x + 1).length() - 1)))
									+ "");
				}
				if (k.get(x - 1).contains("sin")) {
					k.set(x - 1,
							sinFunction(Double.parseDouble(k.get(x - 1).substring(
									k.get(x - 1).length() - 2,
									k.get(x - 1).length() - 1)))
									+ "");
				}
				if (k.get(x + 1).contains("sin")) {
					k.set(x + 1,
							sinFunction(Double.parseDouble(k.get(x + 1).substring(
									k.get(x + 1).length() - 2,
									k.get(x + 1).length() - 1)))
									+ "");
				}
				if (k.get(x - 1).contains("tan")) {
					k.set(x - 1,
							tanFunction(Double.parseDouble(k.get(x - 1).substring(
									k.get(x - 1).length() - 2,
									k.get(x - 1).length() - 1)))
									+ "");
				}
				if (k.get(x + 1).contains("tan")) {
					k.set(x + 1,
							tanFunction(Double.parseDouble(k.get(x + 1).substring(
									k.get(x + 1).length() - 2,
									k.get(x + 1).length() - 1)))
									+ "");
				}


				total = (Double.parseDouble(k.get(x - 1)) * Double
						.parseDouble(k.get(x + 1)));

				k.remove(x - 1);
				k.remove(x - 1);
				k.remove(x - 1);
				k.add(x - 1, total + "");

			}

			else if (k.get(x).equals("/")) {
				if (k.get(x - 1).contains("sqrt")) {
					k.set(x - 1,
							squareRoot(Double.parseDouble(k.get(x - 1)
									.substring(k.get(x - 1).length() - 2,
											k.get(x - 1).length() - 1)))
									+ "");
				}
				if (k.get(x + 1).contains("sqrt")) {
					k.set(x + 1,
							squareRoot(Double.parseDouble(k.get(x + 1)
									.substring(k.get(x + 1).length() - 2,
											k.get(x + 1).length() - 1)))
									+ "");
				}
				if (k.get(x - 1).contains("cbrt")) {
					k.set(x - 1,
							cubeRoot(Double.parseDouble(k.get(x - 1).substring(
									k.get(x - 1).length() - 2,
									k.get(x - 1).length() - 1)))
									+ "");
				}
				if (k.get(x + 1).contains("cbrt")) {
					k.set(x + 1,
							cubeRoot(Double.parseDouble(k.get(x + 1).substring(
									k.get(x + 1).length() - 2,
									k.get(x + 1).length() - 1)))
									+ "");
				}
				if (k.get(x - 1).contains("cos")) {
					k.set(x - 1,
							cosFunction(Double.parseDouble(k.get(x - 1).substring(
									k.get(x - 1).length() - 2,
									k.get(x - 1).length() - 1)))
									+ "");
				}
				if (k.get(x + 1).contains("cos")) {
					k.set(x + 1,
							cosFunction(Double.parseDouble(k.get(x + 1).substring(
									k.get(x + 1).length() - 2,
									k.get(x + 1).length() - 1)))
									+ "");
				}
				if (k.get(x - 1).contains("sin")) {
					k.set(x - 1,
							sinFunction(Double.parseDouble(k.get(x - 1).substring(
									k.get(x - 1).length() - 2,
									k.get(x - 1).length() - 1)))
									+ "");
				}
				if (k.get(x + 1).contains("sin")) {
					k.set(x + 1,
							sinFunction(Double.parseDouble(k.get(x + 1).substring(
									k.get(x + 1).length() - 2,
									k.get(x + 1).length() - 1)))
									+ "");
				}
				if (k.get(x - 1).contains("tan")) {
					k.set(x - 1,
							tanFunction(Double.parseDouble(k.get(x - 1).substring(
									k.get(x - 1).length() - 2,
									k.get(x - 1).length() - 1)))
									+ "");
				}
				if (k.get(x + 1).contains("tan")) {
					k.set(x + 1,
							tanFunction(Double.parseDouble(k.get(x + 1).substring(
									k.get(x + 1).length() - 2,
									k.get(x + 1).length() - 1)))
									+ "");
				}
				
			

				total = (Double.parseDouble(k.get(x - 1)) / Double
						.parseDouble(k.get(x + 1)));

				k.remove(x - 1);
				k.remove(x - 1);
				k.remove(x - 1);
				k.add(x - 1, total + "");

			}

		}

		for (int x = k.size() - 1; x >= 0; x--) {
			// "3 * 5 + 3 * 6"
			if (k.get(x).equals("+")) {

				if (k.get(x - 1).contains("sqrt")) {
					k.set(x - 1,
							squareRoot(Double.parseDouble(k.get(x - 1)
									.substring(k.get(x - 1).length() - 2,
											k.get(x - 1).length() - 1)))
									+ "");
				}
				if (k.get(x + 1).contains("sqrt")) {
					k.set(x + 1,
							squareRoot(Double.parseDouble(k.get(x + 1)
									.substring(k.get(x + 1).length() - 2,
											k.get(x + 1).length() - 1)))
									+ "");
				}

				if (k.get(x - 1).contains("cbrt")) {
					k.set(x - 1,
							cubeRoot(Double.parseDouble(k.get(x - 1).substring(
									k.get(x - 1).length() - 2,
									k.get(x - 1).length() - 1)))
									+ "");
				}
				if (k.get(x + 1).contains("cbrt")) {
					k.set(x + 1,
							cubeRoot(Double.parseDouble(k.get(x + 1).substring(
									k.get(x + 1).length() - 2,
									k.get(x + 1).length() - 1)))
									+ "");
				}
				if (k.get(x - 1).contains("cos")) {
					k.set(x - 1,
							cosFunction(Double.parseDouble(k.get(x - 1).substring(
									k.get(x - 1).length() - 2,
									k.get(x - 1).length() - 1)))
									+ "");
				}
				if (k.get(x + 1).contains("cos")) {
					k.set(x + 1,
							cosFunction(Double.parseDouble(k.get(x + 1).substring(
									k.get(x + 1).length() - 2,
									k.get(x + 1).length() - 1)))
									+ "");
				}
				if (k.get(x - 1).contains("sin")) {
					k.set(x - 1,
							sinFunction(Double.parseDouble(k.get(x - 1).substring(
									k.get(x - 1).length() - 2,
									k.get(x - 1).length() - 1)))
									+ "");
				}
				if (k.get(x + 1).contains("sin")) {
					k.set(x + 1,
							sinFunction(Double.parseDouble(k.get(x + 1).substring(
									k.get(x + 1).length() - 2,
									k.get(x + 1).length() - 1)))
									+ "");
				}
				if (k.get(x - 1).contains("tan")) {
					k.set(x - 1,
							tanFunction(Double.parseDouble(k.get(x - 1).substring(
									k.get(x - 1).length() - 2,
									k.get(x - 1).length() - 1)))
									+ "");
				}
				if (k.get(x + 1).contains("tan")) {
					k.set(x + 1,
							tanFunction(Double.parseDouble(k.get(x + 1).substring(
									k.get(x + 1).length() - 2,
									k.get(x + 1).length() - 1)))
									+ "");
				}

			
				
				total = (Double.parseDouble(k.get(x - 1)) + Double
						.parseDouble(k.get(x + 1)));

				k.remove(x - 1);
				k.remove(x - 1);
				k.remove(x - 1);
				k.add(x - 1, total + "");

			} else if (k.get(x).equals("-")) {

				if (k.get(x - 1).contains("sqrt")) {
					k.set(x - 1,
							squareRoot(Double.parseDouble(k.get(x - 1)
									.substring(k.get(x - 1).length() - 2,
											k.get(x - 1).length() - 1)))
									+ "");
				}
				if (k.get(x + 1).contains("sqrt")) {
					k.set(x + 1,
							squareRoot(Double.parseDouble(k.get(x + 1)
									.substring(k.get(x + 1).length() - 2,
											k.get(x + 1).length() - 1)))
									+ "");
				}
				
				if (k.get(x - 1).contains("cos")) {
					k.set(x - 1,
							cosFunction(Double.parseDouble(k.get(x - 1).substring(
									k.get(x - 1).length() - 2,
									k.get(x - 1).length() - 1)))
									+ "");
				}
				if (k.get(x + 1).contains("cos")) {
					k.set(x + 1,
							cosFunction(Double.parseDouble(k.get(x + 1).substring(
									k.get(x + 1).length() - 2,
									k.get(x + 1).length() - 1)))
									+ "");
				}
				if (k.get(x - 1).contains("sin")) {
					k.set(x - 1,
							sinFunction(Double.parseDouble(k.get(x - 1).substring(
									k.get(x - 1).length() - 2,
									k.get(x - 1).length() - 1)))
									+ "");
				}
				if (k.get(x + 1).contains("sin")) {
					k.set(x + 1,
							sinFunction(Double.parseDouble(k.get(x + 1).substring(
									k.get(x + 1).length() - 2,
									k.get(x + 1).length() - 1)))
									+ "");
				}
				if (k.get(x - 1).contains("tan")) {
					k.set(x - 1,
							tanFunction(Double.parseDouble(k.get(x - 1).substring(
									k.get(x - 1).length() - 2,
									k.get(x - 1).length() - 1)))
									+ "");
				}
				if (k.get(x + 1).contains("tan")) {
					k.set(x + 1,
							tanFunction(Double.parseDouble(k.get(x + 1).substring(
									k.get(x + 1).length() - 2,
									k.get(x + 1).length() - 1)))
									+ "");
				}


				total = (Double.parseDouble(k.get(x - 1)) - Double
						.parseDouble(k.get(x + 1)));

				k.remove(x - 1);
				k.remove(x - 1);
				k.remove(x - 1);
				k.add(x - 1, total + "");

			}

		}

		System.out.println(k.get(0));
	}

	public static boolean contains(String[] arr, String toFind) {

		for (int x = 0; x < arr.length; x++) {
			if (arr[x].equals(toFind)) {
				return true;
			}
		}

		return false;
	}

	public static double squareRoot(double number) {
		double squareRoot = 0;
		double temp = 0;
		boolean isPositiveNumber = true;
		if (number == 0) {
			squareRoot = 0;
		}

		if (number < 0) {
			isPositiveNumber = false;
			number = -number;
		}

		squareRoot = number / 2;
		do {
			temp = squareRoot;
			squareRoot = (temp + (number / temp)) / 2;
		} while ((temp - squareRoot) != 0);

		return squareRoot;
	}

	public static double cubeRoot(double number) {
		double cubeRoot = 0;
		cubeRoot = Math.cbrt(number);
		return cubeRoot;
	}

	public static double cosFunction(double value) {
		return Math.cos(value);
	}

	public static double sinFunction(double value) {
		return Math.sin(value);
	}

	public static double tanFunction(double value) {
		return Math.tan(value);
	}

	public static double fracToDecimal(String fraction) {
		return Double.parseDouble(fraction.substring(0, fraction.indexOf('/')))
				/ Double.parseDouble(fraction.substring(
						fraction.indexOf('/') + 1, fraction.length()));

	}

	public static double maxNumber(double num1, double num2) {
		return Math.max(num1, num2);
	}

	public static double factorial(int x) {

		if (x == 0 || x == 1) {
			return 1;
		} else
			return x * factorial(x - 1);

	}

	public static double random() {

		return Math.random();

	}

}