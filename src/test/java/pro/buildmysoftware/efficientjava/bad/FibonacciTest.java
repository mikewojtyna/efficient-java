package pro.buildmysoftware.efficientjava.bad;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Java6Assertions.assertThat;

class FibonacciTest {
	// @formatter:off
	@DisplayName("should sum fibonacci numbers")
	@CsvSource({
		"0, 0",
		"1, 1",
		"2, 1",
		"3, 2",
		"4, 3",
		"5, 5",
		"6, 8",
		"7, 13",
		"8, 21"
	})
	// @formatter:on
	@ParameterizedTest(name = "given: n={0}; expected: sum={1}")
	void test(int n, int expectedSum) throws Exception {
		assertThat(Fibonacci.fibonacci(n)).isEqualTo(expectedSum);
	}
}
