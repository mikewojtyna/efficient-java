package pro.buildmysoftware.efficientjava.queue;

import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.stream.Stream;

public class LogEntryEventPublisher {

	private Random random;

	public LogEntryEventPublisher() {
		random = new Random();
	}

	void start(BlockingQueue<LogEntry> eventsQueue) {
		Stream.generate(this::nextEntry).limit(100)
			.forEach(eventsQueue::add);
	}

	private LogEntry nextEntry() {
		int randomLevel = random.nextInt(4);
		LogLevel randomLogLevelEnum;
		switch (randomLevel) {
			case 1:
				randomLogLevelEnum = LogLevel.INFO;
				break;
			case 2:
				randomLogLevelEnum = LogLevel.WARN;
				break;
			case 3:
				randomLogLevelEnum = LogLevel.ERROR;
				break;
			default:
				randomLogLevelEnum = LogLevel.DEBUG;
				break;
		}
		return new LogEntry("this is a message", randomLogLevelEnum);
	}
}
