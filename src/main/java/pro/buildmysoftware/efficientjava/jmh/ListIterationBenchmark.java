package pro.buildmysoftware.efficientjava.jmh;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@Fork(2)
public class ListIterationBenchmark {
	private static final int ELEMENTS = 10_000;

	@Benchmark
	@Warmup(iterations = 5)
	@Measurement(iterations = 10)
	public void arrayListBenchmark(ArrayListState state,
				       Blackhole blackhole) {
		for (int i = 0; i < ELEMENTS; i++) {
			blackhole.consume(state.list.get(i));
		}
	}

	@Benchmark
	@Warmup(iterations = 5)
	@Measurement(iterations = 10)
	public void linkedListBenchmark(LinkedListState state,
					Blackhole blackhole) {
		for (int i = 0; i < ELEMENTS; i++) {
			blackhole.consume(state.list.get(i));
		}
	}

	@State(Scope.Benchmark)
	public static class LinkedListState {
		public List<Integer> list;

		@Setup
		public void setup() {
			list = new LinkedList<>();
			for (int i = 0; i < ELEMENTS; i++) {
				list.add(i);
			}
		}
	}

	@State(Scope.Benchmark)
	public static class ArrayListState {
		public List<Integer> list;

		@Setup
		public void setup() {
			list = new ArrayList<>();
			for (int i = 0; i < ELEMENTS; i++) {
				list.add(i);
			}
		}
	}
}
