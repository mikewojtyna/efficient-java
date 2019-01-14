package pro.buildmysoftware.efficientjava.bad.book;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.nio.file.Paths;

import static org.assertj.core.api.Java6Assertions.assertThat;

class BookCatalogTest {

	@DisplayName("should find existing book by isbn")
	@Test
	void test() throws Exception {
		// given
		BookCatalog catalog = new BookCatalog(Paths
			.get("files", "book-catalog.txt"));
		String isbn = "9781607102113";

		// when
		Book bookInCatalog = catalog.findBookInCatalog(isbn);

		// then
		assertThat(bookInCatalog.getIsbn()).isEqualTo(isbn);
		assertThat(bookInCatalog.getTitle())
			.isEqualTo("The Adventures of Sherlock Holmes, and " + "Other Stories");
	}
}