package pro.buildmysoftware.efficientjava.tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;


class FizzBuzzTest {
	@DisplayName("should return string according to the specifcation of " + "FizzBuzz")
	@ParameterizedTest(name = "given: {0}; expected: {1}")
	// @formatter:off
	@CsvSource({
		"1, '1'",
		"2, '2'",
		"3, 'Fizz'",
		"6, 'Fizz'",
		"5, 'Buzz'",
		"10, 'Buzz'",
		"15, 'FizzBuzz'",
		"30, 'FizzBuzz'",
		"0, 'FizzBuzz'"
	})
	// @formatter:on
	void test(int inputNumber, String expectedMsg) throws Exception {
		// when
		String msg = FizzBuzz.fizzBuzz(inputNumber);

		// then
		assertThat(msg).isEqualTo(expectedMsg);
	}
}