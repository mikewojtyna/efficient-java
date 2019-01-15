package pro.buildmysoftware.efficientjava.serialization;

public class Product {
	private String name;
	private double price;
	private Order order;

	public Product(String name, double price) {
		this.name = name;
		this.price = price;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public String getName() {
		return name;
	}

	public double getPrice() {
		return price;
	}
}
