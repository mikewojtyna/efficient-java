package pro.buildmysoftware.efficientjava.bad.algorithms;

class Fibonacci {
	static int fibonacci(int n) {
		// return recursiveFibonacci(n);
		// uncomment this
		return dynamicFibonacci(n);
	}

	private static int dynamicFibonacci(int n) {
		if (n < 2) {
			return n;
		}
		int current = 1;
		int previous = 1;
		for (int i = 2; i < n; i++) {
			int oldPrevious = current;
			current += previous;
			previous = oldPrevious;
		}
		return current;
	}

	private static int recursiveFibonacci(int n) {
		if (n < 2) {
			return n;
		}
		return recursiveFibonacci(n - 1) + recursiveFibonacci(n - 2);
	}
}
