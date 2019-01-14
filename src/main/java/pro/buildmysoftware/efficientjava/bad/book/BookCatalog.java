package pro.buildmysoftware.efficientjava.bad.book;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class BookCatalog {

	private Path catalog;

	public BookCatalog(Path catalog) {
		this.catalog = catalog;
	}

	public Book findBookInCatalog(String isbn) throws IOException {
		List<String> allLines = Files
			.readAllLines(catalog, Charset.forName("UTF-8"));
		for (String line : allLines) {
			if (line.startsWith(isbn)) {
				return new Book(isbn, line
					.substring(isbn.length() + 1));
			}
		}
		return null;
	}
}
