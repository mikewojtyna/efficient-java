package pro.buildmysoftware.efficientjava.queue;

import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.stream.Stream;

public class LogEntryPublisher {

	private final BlockingQueue<LogEntry> eventsQueue;
	private Random random;

	public LogEntryPublisher(BlockingQueue<LogEntry> eventsQueue) {
		this.eventsQueue = eventsQueue;
		random = new Random();
	}

	void publishEntries() {
		Stream.generate(this::nextEntry).limit(100)
			.forEach(eventsQueue::add);
	}

	private LogEntry nextEntry() {
		LogLevel[] possibleLogLevels = LogLevel.values();

		LogLevel randomLogLevel = possibleLogLevels[random
			.nextInt(possibleLogLevels.length)];

		return new LogEntry("this is a message", randomLogLevel);
	}
}
