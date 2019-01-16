package pro.buildmysoftware.efficientjava.tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Collection;

import static org.assertj.core.api.Assertions.assertThat;

public class ProductRepositoryTest {

	private ProductRepository repository;

	@BeforeEach
	void beforeEach() {
		repository = new ProductRepository();
	}

	@DisplayName("should find a single product, when there's only one " +
		"product in the database")
	@Test
	void test() throws Exception {
		// given
		String productName = "product";
		Product product = productWithName(productName);
		repository.addProduct(product);

		// when
		Collection<Product> products = repository
			.findByName(productName);

		// then
		assertThat(products).containsOnly(product);
	}

	@DisplayName("should find two products from the db, when both of them" + " have matching name and they are the only products in the db")
	@Test
	void test1() throws Exception {
		// given
		Product product0 = productWithName("product");
		Product product1 = productWithName("product");
		repository.addProduct(product0);
		repository.addProduct(product1);

		// when
		Collection<Product> foundProducts = repository
			.findByName(product0.getName());

		// then
		assertThat(foundProducts)
			.containsExactlyInAnyOrder(product0, product1);
	}

	@DisplayName("should find only a matching product, when there are two" + " products with different names in the db")
	@Test
	void test2() throws Exception {
		// given
		Product product0 = productWithName("product0");
		Product product1 = productWithName("product1");
		repository.addProduct(product0);
		repository.addProduct(product1);

		// when
		Collection<Product> foundProducts = repository
			.findByName("product1");

		// then
		assertThat(foundProducts).containsOnly(product1);
	}

	@DisplayName("should find all matching products")
	@Test
	void test3() throws Exception {
		// given
		Product apple = productWithName("apple");
		Product orange0 = productWithName("orange");
		Product orange1 = productWithName("orange");
		Product pineapple = productWithName("pineapple");
		repository.addProduct(apple);
		repository.addProduct(orange0);
		repository.addProduct(orange1);
		repository.addProduct(pineapple);

		// when
		Collection<Product> foundProducts = repository
			.findByName("orange");

		// then
		assertThat(foundProducts)
			.containsExactlyInAnyOrder(orange0, orange1);
	}

	private Product productWithName(String name) {
		return new Product(name);
	}
}
