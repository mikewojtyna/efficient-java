package pro.buildmysoftware.efficientjava.review.wordcount;

import java.util.Objects;

class Word {
	private String value;
	private int times;

	@Override
	public String toString() {
		return "Word{" + "value='" + value + '\'' + ", times=" + times + '}';
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public int getTimes() {
		return times;
	}

	public void setTimes(int times) {
		this.times = times;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Word word = (Word) o;
		return times == word.times && Objects.equals(value,
			word.value);
	}

	@Override
	public int hashCode() {
		return Objects.hash(value, times);
	}
}
