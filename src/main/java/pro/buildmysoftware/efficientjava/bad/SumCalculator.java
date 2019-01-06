package pro.buildmysoftware.efficientjava.bad;

import java.util.stream.IntStream;

class SumCalculator {
	static int sumRange(int start, int end) {
		return IntStream.range(start, end + 1).sum();

		// now, try to uncomment this
		// https://en.wikipedia.org/wiki/Arithmetic_progression#Sum
		// return (end - start + 1) * (start + end) / 2;
	}
}
