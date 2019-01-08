package pro.buildmysoftware.efficientjava.queue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

import static org.assertj.core.api.Assertions.assertThat;

public class QueueExample {
	@DisplayName("show queue interface example")
	@Test
	void test0() throws Exception {
		Queue<Integer> queue = linkedList();
		queue.add(1);
		queue.add(2);

		assertThat(queue.remove()).isEqualTo(1);
		assertThat(queue.remove()).isEqualTo(2);
	}

	@DisplayName("show how to use priority queue using reversed " +
		"comparator")
	@Test
	void test1() throws Exception {
		PriorityQueue<Integer> priorityQueue =
			new PriorityQueue<>(Comparator
			.reverseOrder());
		priorityQueue.add(1);
		priorityQueue.add(2);

		assertThat(priorityQueue.remove()).isEqualTo(2);
		assertThat(priorityQueue.remove()).isEqualTo(1);
	}

	private Queue<Integer> linkedList() {
		return new LinkedList<>();
	}
}
