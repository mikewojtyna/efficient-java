package pro.buildmysoftware.efficientjava.queue;

import java.util.concurrent.BlockingQueue;

public class LogProcessor {
	private BlockingQueue<LogEntry> eventsQueue;

	public LogProcessor(BlockingQueue<LogEntry> eventsQueue) {
		this.eventsQueue = eventsQueue;
	}

	void processEntries() {
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
