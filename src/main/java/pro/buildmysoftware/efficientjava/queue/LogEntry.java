package pro.buildmysoftware.efficientjava.queue;

import java.util.Objects;

public class LogEntry implements Comparable<LogEntry> {
	private String msg;
	private LogLevel level;

	public LogEntry(String msg, LogLevel level) {
		this.msg = msg;
		this.level = level;
	}

	@Override
	public String toString() {
		return String.format("Msg: %s, Level: %s", msg, level);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		LogEntry logEntry = (LogEntry) o;
		return Objects
			.equals(msg, logEntry.msg) && level == logEntry.level;
	}

	@Override
	public int hashCode() {
		return Objects.hash(msg, level);
	}

	@Override
	public int compareTo(LogEntry otherEntry) {
		return otherEntry.level.getLevelNumber() - level
			.getLevelNumber();
	}
}
