package pro.buildmysoftware.efficientjava.queue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;

public class LogEventSystem {
	public static void main(String[] args) {
		BlockingQueue<LogEntry> eventsQueue =
			new PriorityBlockingQueue<>();

		LogProcessor logProcessor = new LogProcessor(eventsQueue);
		new Thread(() -> logProcessor.processEntries()).start();

		LogEntryPublisher publisher =
			new LogEntryPublisher(eventsQueue);
		new Thread(() -> publisher.publishEntries()).start();
	}
}
