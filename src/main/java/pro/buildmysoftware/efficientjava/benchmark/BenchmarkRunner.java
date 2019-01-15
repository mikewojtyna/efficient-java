package pro.buildmysoftware.efficientjava.benchmark;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class BenchmarkRunner {
	/**
	 * Runs a benchmark of all methods on the given object.
	 *
	 * @param object the object to bencharm
	 */
	public void benchmarkMethods(Object object) {
		Class<?> clazz = object.getClass();
		Method[] methods = clazz.getDeclaredMethods();
		Stream.of(methods).forEach(m -> benchmarkMethod(m, object));
	}

	private void benchmarkMethod(Method method, Object object) {
		MethodBenchmark methodBenchmark = method
			.getAnnotation(MethodBenchmark.class);
		if (methodBenchmark == null) {
			return;
		}

		try {
			long start = System.currentTimeMillis();
			for (int i = 0; i < methodBenchmark.value(); i++) {
				Object[] intParams = IntStream
					.of(methodBenchmark.intParams()).boxed()
					.toArray();
				method.invoke(object, intParams);
			}
			long end = System.currentTimeMillis();
			System.out.println(String
				.format("Method %s took %s ms", method
					.getName(), end - start));
		}
		catch (IllegalAccessException | InvocationTargetException e) {
			throw new RuntimeException(String
				.format("Failed to benchmark method " + "%s",
					method
					.getName()), e);
		}
	}
}
