package pro.buildmysoftware.efficientjava.set;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.EnumSet;

import static org.assertj.core.api.Assertions.assertThat;

public class EnumSetExample {
	@DisplayName("show how to use enum sets")
	@Test
	void test() throws Exception {
		// given
		EnumSet<TestEnum> enums = EnumSet
			.of(TestEnum.VALUE0, TestEnum.VALUE2);

		// when
		boolean containsValue1 = enums.contains(TestEnum.VALUE1);
		boolean containsValue2 = enums.contains(TestEnum.VALUE2);

		// then
		assertThat(containsValue1).isFalse();
		assertThat(containsValue2).isTrue();
	}

	private enum TestEnum {
		VALUE0, VALUE1, VALUE2
	}
}
