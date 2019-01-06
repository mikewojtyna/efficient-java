package pro.buildmysoftware.efficientjava.review.product;

import java.math.BigDecimal;
import java.util.Random;

class Product {
	private String name;

	Product(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Product{" + "name='" + name + '\'' + ", price=" + calculatePrice() + "}";
	}

	String getName() {
		return name;
	}

	BigDecimal calculatePrice() {
		return performSomeHeavyCalculation();
	}

	private BigDecimal performSomeHeavyCalculation() {
		try {
			Thread.sleep(2000);
			return BigDecimal
				.valueOf(new Random().nextInt(1_000_000 + 1));
		}
		catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
	}
}
