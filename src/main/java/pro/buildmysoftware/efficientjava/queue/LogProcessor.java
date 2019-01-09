package pro.buildmysoftware.efficientjava.queue;

import java.util.concurrent.BlockingQueue;

public class LogProcessor {
	void processLogEntry(BlockingQueue<LogEntry> eventsQueue) {
		try {
			while (true) {
				LogEntry nextEntry = eventsQueue.take();
				System.out
					.printf("Processing log entry %s\n",
						nextEntry);
				Thread.sleep(500);
			}
		}
		catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
