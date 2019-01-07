package pro.buildmysoftware.efficientjava.benchark;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.stream.Stream;

class BenchmarkRunner {
	/**
	 * Runs a benchmark of all methods on the given object.
	 *
	 * @param object the object to bencharm
	 */
	void benchmarkMethods(Object object) {
		Class<?> clazz = object.getClass();
		Method[] methods = clazz.getDeclaredMethods();
		Stream.of(methods).forEach(m -> benchmarkMethod(m, object));
	}

	private void benchmarkMethod(Method method, Object object) {
		Method currentMethod = method;
		MethodBenchmark methodBenchmark = currentMethod
			.getAnnotation(MethodBenchmark.class);
		if (methodBenchmark != null) {
			try {
				long start = System.currentTimeMillis();
				for (int i = 0; i < methodBenchmark
					.value(); i++) {
					currentMethod.invoke(object);
				}
				long end = System.currentTimeMillis();
				System.out.println("Method " + method
					.getName() + " " + "took" + ": " + (end - start));
			}
			catch (IllegalAccessException | InvocationTargetException e) {
				throw new RuntimeException(String
					.format("Failed to bencharm method %s"
						, method
						.getName()), e);
			}
		}
	}
}
