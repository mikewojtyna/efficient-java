package pro.buildmysoftware.efficientjava.tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class FizzBuzzTest {

	@DisplayName("given any number, returned msg should be according to " + "the examples")
	@ParameterizedTest(name = "given: {0}, expected: {1}")
	// @formatter:off
	@CsvSource({
		"1, 1",
		"2, 2",
		"3, Fizz",
		"5, Buzz",
		"6, Fizz",
		"10, Buzz",
		"15, FizzBuzz",
		"30, FizzBuzz",
		"0, FizzBuzz"
	})
	// @formatter:on
	void testFizzBuzz(int number, String expectedMsg) throws Exception {
		// when
		String msg = FizzBuzz.msg(number);

		// then
		assertThat(msg).isEqualTo(expectedMsg);
	}

}
