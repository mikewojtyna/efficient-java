package pro.buildmysoftware.efficientjava.review.product;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;


class ProductCrudServiceTest {

	@DisplayName("should save and find product")
	@Test
	void test0() {
		// given
		ProductCrudService service = new ProductCrudService();
		Product product = productWithName("Gyokuro Miyazaki Tea");

		// when
		service.save(product);

		// then
		Optional<Product> foundProduct = service
			.findByName(product.getName());
		assertThat(foundProduct).isNotEmpty();
	}

	private Product productWithName(String name) {
		return new Product(name);
	}

}