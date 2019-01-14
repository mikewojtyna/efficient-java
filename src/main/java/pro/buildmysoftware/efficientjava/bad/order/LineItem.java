package pro.buildmysoftware.efficientjava.bad.order;

public class LineItem {
	private Product product;
	private int count;

	public LineItem(Product product, int count) {
		this.product = product;
		this.count = count;
	}

	public int getCount() {
		return count;
	}

	public Product getProduct() {
		return product;
	}
}
