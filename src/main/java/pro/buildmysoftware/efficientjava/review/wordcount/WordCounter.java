package pro.buildmysoftware.efficientjava.review.wordcount;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

class WordCounter {

	static Collection<Word> countWords(String text) {
		List<String> wordsAsString = Arrays.asList(text.split("\\s"));
		Collection<Word> words = new ArrayList<>();
		for (String wordString : wordsAsString) {
			boolean newWord = true;
			for (Word word : words) {
				if (wordString.equals(word.getValue())) {
					newWord = false;
					word.setTimes(word.getTimes() + 1);
				}
			}
			if (newWord) {
				Word word = new Word();
				word.setValue(wordString);
				word.setTimes(1);
				words.add(word);
			}
		}
		return words;
	}
}
