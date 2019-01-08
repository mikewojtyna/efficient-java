package pro.buildmysoftware.efficientjava.tests;


import java.util.Arrays;
import java.util.Collection;

/**
 * A class used to find and manage products.
 */
public class ProductRepository {

	private Product product;

	/**
	 * Finds all products with the given name.
	 *
	 * @param name a name of the product
	 * @return all products with the given name
	 */
	Collection<Product> findByName(String name) {
		return Arrays.asList(product);
	}

	/**
	 * Adds a product to the repository;
	 *
	 * @param product a product to add
	 */
	void addProduct(Product product) {
		this.product = product;
	}
}
