package pro.buildmysoftware.efficientjava.bad.order;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Java6Assertions.assertThat;

public class OrderCostTest {
	@DisplayName("should calculate total cost of all items")
	@Test
	void test() throws Exception {
		// given
		// create an order with three products
		Order order = new Order();
		Product product0 = new Product("product0", 10.00);
		Product product1 = new Product("product1", 5.00);
		Product product2 = new Product("product2", 2.00);
		// add products to the order
		order.addProduct(product0);
		order.addProduct(product1, 2);
		order.addProduct(product2);
		order.addProduct(product2);
		order.addProduct(product2);

		// when
		double totalCost = order.totalCost();

		// then
		assertThat(totalCost).isEqualTo(26.00);
	}

	@DisplayName("should calculate total cost except of some items")
	@Test
	void test1() throws Exception {
		// given
		// create an order with three products
		Order order = new Order();
		Product product0 = new Product("product0", 10.00);
		Product product1 = new Product("product1", 5.00);
		Product product2 = new Product("product2", 2.00);
		// add products to the order
		order.addProduct(product0);
		order.addProduct(product1, 2);
		order.addProduct(product2);
		order.addProduct(product2);
		order.addProduct(product2);

		// when
		double totalCost = order
			.totalCostExceptOf("product2", "product0");

		// then
		assertThat(totalCost).isEqualTo(10.00);
	}
}
