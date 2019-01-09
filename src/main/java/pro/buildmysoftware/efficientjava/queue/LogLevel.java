package pro.buildmysoftware.efficientjava.queue;

public enum LogLevel {
	DEBUG(0), INFO(1), WARN(2), ERROR(3);

	private final int levelNumber;

	LogLevel(int levelNumber) {
		this.levelNumber = levelNumber;
	}

	public int getLevelNumber() {
		return levelNumber;
	}
}
