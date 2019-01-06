package pro.buildmysoftware.efficientjava.review.wordcount;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Collection;

import static org.assertj.core.api.Java6Assertions.assertThat;

class WordCounterTest {
	@DisplayName("should count words")
	@Test
	void test() throws Exception {
		// given
		String text = "this repeats oranges oranges two times and " +
			"bananas three bananas bananas times";

		// when
		Collection<Word> words = WordCounter.countWords(text);

		// then
		Word orangesWord = new Word();
		orangesWord.setValue("oranges");
		orangesWord.setTimes(2);
		Word bananasWord = new Word();
		bananasWord.setValue("bananas");
		bananasWord.setTimes(3);
		Word timesWord = new Word();
		timesWord.setValue("times");
		timesWord.setTimes(2);
		Word thisWord = new Word();
		thisWord.setValue("this");
		thisWord.setTimes(1);
		assertThat(words).contains(orangesWord).contains(bananasWord)
			.contains(timesWord).contains(thisWord);
	}
}