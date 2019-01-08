package pro.buildmysoftware.efficientjava.equals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class EqualsExample {
	@DisplayName("show equals quirks")
	@Test
	void test() throws Exception {
		// given
		Set<Product> products = new HashSet<>();
		Product product = new Product("product 0");

		// when
		products.add(product);
		product.setName("something different");

		// then
		assertThat(products.contains(product)).isFalse();
	}

	private static class Product {
		private String name;

		public Product() {
		}

		public Product(String name) {
			this.name = name;
		}

		public void setName(String name) {
			this.name = name;
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) {
				return true;
			}
			if (o == null || getClass() != o.getClass()) {
				return false;
			}
			Product product = (Product) o;
			return Objects.equals(name, product.name);
		}

		@Override
		public int hashCode() {
			return Objects.hash(name);
		}
	}
}
