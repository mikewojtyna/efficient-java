package pro.buildmysoftware.efficientjava.serialization;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;
import java.util.UUID;

public class Order {
	private List<Product> products;
	private double cost;
	@JsonIgnore
	private UUID uuid;

	public Order(List<Product> products) {
		this.products = products;
		cost = products.stream().mapToDouble(Product::getPrice).sum();
		uuid = UUID.randomUUID().randomUUID();
	}

	public List<Product> getProducts() {
		return products;
	}

	public double getCost() {
		return cost;
	}
}
