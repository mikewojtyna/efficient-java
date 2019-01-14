package pro.buildmysoftware.efficientjava.bad.algorithms;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Java6Assertions.assertThat;

class SumCalculatorTest {

	// @formatter:off
	@DisplayName("should sum range")
	@CsvSource({
		"0,0, 0",
		"0,2, 3",
		"1,10, 55"
	})
	// @formatter:on
	@ParameterizedTest(name = "given: start={0}, end={1}; expected " +
		"sum={2}")
	void test(int start, int end, int expectedSum) {
		assertThat(SumCalculator.sumRange(start, end))
			.isEqualTo(expectedSum);
	}
}