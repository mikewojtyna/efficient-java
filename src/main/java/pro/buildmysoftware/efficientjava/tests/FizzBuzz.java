package pro.buildmysoftware.efficientjava.tests;

public class FizzBuzz {
	/**
	 * Returns a "Fizz" string, when number is divisible by 3, "Buzz"
	 * when divisible by 5, "FizzBuzz" when divisible by 3 and 5. In
	 * other cases - simply return the string representation of a number,
	 * e.g. for 1 the result should "1".
	 *
	 * @param number any integer number
	 * @return the string according to the specification
	 */
	public static String fizzBuzz(int number) {
		if (number % 15 == 0) {
			return "FizzBuzz";
		}
		if (number % 5 == 0) {
			return "Buzz";
		}
		if (number % 3 == 0) {
			return "Fizz";
		}
		return String.valueOf(number);
	}
}
