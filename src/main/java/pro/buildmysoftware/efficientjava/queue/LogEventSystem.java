package pro.buildmysoftware.efficientjava.queue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;

public class LogEventSystem {
	public static void main(String[] args) {
		BlockingQueue<LogEntry> eventsQueue =
			new PriorityBlockingQueue<>();

		LogProcessor logProcessor = new LogProcessor();
		new Thread(() -> logProcessor.processLogEntry(eventsQueue))
			.start();

		LogEntryEventPublisher publisher =
			new LogEntryEventPublisher();
		new Thread(() -> publisher.start(eventsQueue)).start();
	}
}
