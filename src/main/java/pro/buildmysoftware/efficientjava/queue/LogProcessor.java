package pro.buildmysoftware.efficientjava.queue;

import java.util.concurrent.BlockingQueue;

public class LogProcessor {
	void processLogEntry(BlockingQueue<LogEntry> eventsQueue) {
		while (true) {
			try {
				LogEntry nextEntry = eventsQueue.take();
				System.out
					.printf("Processing log entry %s\n",
						nextEntry);
			}
			catch (InterruptedException e) {
				// restore the flag, so the caller can know
				// the thread was interrupted and not handled
				// properly
				Thread.currentThread().interrupt();
				throw new RuntimeException(e);
			}
		}
	}
}
