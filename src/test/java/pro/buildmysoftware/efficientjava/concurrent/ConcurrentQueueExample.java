package pro.buildmysoftware.efficientjava.concurrent;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

import static org.assertj.core.api.Assertions.assertThat;

public class ConcurrentQueueExample {
	@DisplayName("show concurrent queues in a single thread")
	@Test
	void test() throws Exception {
		// This example is inefficient! You can use concurrent queues
		// in a single thread if you want to, but instead you should
		// use a single-threaded queues (because of the overhead).
		Queue<Integer> queue = concurrentLinkedQueue();

		queue.add(1);
		queue.add(2);

		assertThat(queue.poll()).isEqualTo(1);
		assertThat(queue.poll()).isEqualTo(2);
	}

	@DisplayName("show concurrent queues in multiple threads")
	@Test
	void test1() throws Exception {
		Queue<Integer> queue = concurrentLinkedQueue();

		new Thread(() -> queue.add(1)).start();
		new Thread(() -> queue.add(2)).start();
		new Thread(() -> queue.add(3)).start();

		// we cannot guarantee the order!
		// this test will sometimes pass and sometimes not - run it
		// multiple times to see the results
		assertThat(queue.poll()).isEqualTo(1);
		assertThat(queue.poll()).isEqualTo(2);
		assertThat(queue.poll()).isEqualTo(3);
	}

	private Queue<Integer> concurrentLinkedQueue() {
		return new ConcurrentLinkedQueue<>();
	}
}
