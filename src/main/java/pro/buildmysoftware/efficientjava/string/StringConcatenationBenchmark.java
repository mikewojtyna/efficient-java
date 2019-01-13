package pro.buildmysoftware.efficientjava.string;

import org.apache.commons.lang3.RandomStringUtils;
import pro.buildmysoftware.efficientjava.benchmark.BenchmarkRunner;
import pro.buildmysoftware.efficientjava.benchmark.MethodBenchmark;

import java.util.Collection;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StringConcatenationBenchmark {
	public static void main(String[] args) {
		new BenchmarkRunner()
			.benchmarkMethods(new StringConcatenationBenchmark());
	}

	@MethodBenchmark(value = 1, intParams = 5_000)
	public String concatenateStringsUsingOperator(int numberOfStrings) {
		Collection<String> strings =
			generateRandomStrings(numberOfStrings);
		String result = "";
		for (String string : strings) {
			result += string;
		}
		return result;
	}

	@MethodBenchmark(value = 1, intParams = 5_000)
	public String concatenateStringsUsingStringBuilder(int numberOfStrings) {
		Collection<String> strings =
			generateRandomStrings(numberOfStrings);
		StringBuilder builder = new StringBuilder();
		for (String string : strings) {
			builder.append(string);
		}
		return builder.toString();
	}

	private Collection<String> generateRandomStrings(int numberOfStrings) {
		return IntStream.range(0, numberOfStrings)
			.mapToObj(i -> RandomStringUtils.randomAlphabetic(100))
			.collect(Collectors.toList());
	}
}
