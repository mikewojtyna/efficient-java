package pro.buildmysoftware.efficientjava.bad.order;

import java.util.ArrayList;
import java.util.List;

public class Order {
	private List<LineItem> items;

	public Order() {
		items = new ArrayList<>();
	}

	public double totalCost() {
		double sum = 0;
		for (LineItem item : items) {
			sum += item.getProduct().getPrice() * item.getCount();
		}
		return sum;
	}

	public double totalCostExceptOf(String... products) {
		double totalCost = totalCost();
		double costOfProductsToExclude = 0;
		for (String productToExclude : products) {
			for (LineItem item : items) {
				if (item.getProduct().getName()
					.equals(productToExclude)) {
					costOfProductsToExclude += item
						.getProduct().getPrice() * item
						.getCount();
				}
			}
		}
		return totalCost - costOfProductsToExclude;
	}

	void addProduct(Product product) {
		items.add(new LineItem(product, 1));
	}

	void addProduct(Product product, int count) {
		items.add(new LineItem(product, count));
	}
}
