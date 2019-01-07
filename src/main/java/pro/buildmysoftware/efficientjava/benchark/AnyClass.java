package pro.buildmysoftware.efficientjava.benchark;

public class AnyClass {
	@MethodBenchmark(value = 10_000)
	int anyMethod() throws InterruptedException {
		int res = 0;
		for (int i = 0; i < 1000; i++) {
			res += i * i;
		}
		return res;
	}
}
