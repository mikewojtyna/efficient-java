package pro.buildmysoftware.efficientjava.tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Collection;

import static org.assertj.core.api.Assertions.assertThat;

public class ProductRepositoryTest {
	@DisplayName("should find a single product, when there's only one " +
		"product in the database")
	@Test
	void test() throws Exception {
		// given
		String productName = "product";
		ProductRepository finder = new ProductRepository();
		Product product = productWithName(productName);
		finder.addProduct(product);

		// when
		Collection<Product> products = finder.findByName(productName);

		// then
		assertThat(products).containsOnly(product);
	}

	private Product productWithName(String name) {
		return new Product(name);
	}
}
