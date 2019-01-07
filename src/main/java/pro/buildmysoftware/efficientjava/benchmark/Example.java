package pro.buildmysoftware.efficientjava.benchmark;

public class Example {
	public static void main(String[] args) {
		AnyClass anyObject = new AnyClass();
		BenchmarkRunner runner = new BenchmarkRunner();

		runner.benchmarkMethods(anyObject);
		runner.benchmarkMethods(anyObject);
		runner.benchmarkMethods(anyObject);
		runner.benchmarkMethods(anyObject);
		runner.benchmarkMethods(anyObject);
		runner.benchmarkMethods(anyObject);
		runner.benchmarkMethods(anyObject);
		runner.benchmarkMethods(anyObject);
		runner.benchmarkMethods(anyObject);

	}
}
