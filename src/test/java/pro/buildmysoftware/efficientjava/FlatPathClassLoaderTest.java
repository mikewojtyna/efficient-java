package pro.buildmysoftware.efficientjava;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pro.buildmysoftware.efficientjava.classloader.FlatPathClassLoader;

import java.lang.reflect.Method;
import java.nio.file.Paths;

import static org.assertj.core.api.Assertions.assertThat;

public class FlatPathClassLoaderTest {
	// @formatter:off
	@DisplayName(
		"should load out of project StringCalculator class " +
		"from custom class path using FlatPathClassLoader, " +
		"when class file has flat name (no directories)"
	)
	// @formatter:on
	@Test
	void test() throws Exception {
		// given
		FlatPathClassLoader classLoader = new FlatPathClassLoader(Paths
			.get("files", "classes"));
		String stringCalculatorClassName =
			"pro.buildmysoftware.tdd" + ".stringcalculator" +
				".StringCalculator";

		// when
		Class<?> loadedClass = classLoader
			.loadClass(stringCalculatorClassName);

		// then
		assertThat(loadedClass.getName())
			.isEqualTo(stringCalculatorClassName);
	}

	// @formatter:off
	@DisplayName(
		"should be able to invoke sum method of loaded " +
			"StringCalculator class"
	)
	// @formatter:on
	@Test
	void test1() throws Exception {
		// given
		FlatPathClassLoader classLoader = new FlatPathClassLoader(Paths
			.get("files", "classes"));
		Class<?> stringCalculatorClass = classLoader
			.loadClass("pro.buildmysoftware.tdd" +
				".stringcalculator" + ".StringCalculator");
		// when
		Integer result = (Integer) addMethod(stringCalculatorClass)
			.invoke(null, "1,2,3");

		// then
		assertThat(result).isEqualTo(6);
	}

	private Method addMethod(Class<?> stringCalculatorClass) throws NoSuchMethodException {
		Method addMethod = stringCalculatorClass
			.getDeclaredMethod("add", String.class);
		addMethod.setAccessible(true);
		return addMethod;
	}
}
