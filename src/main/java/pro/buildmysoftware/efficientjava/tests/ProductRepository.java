package pro.buildmysoftware.efficientjava.tests;


import java.util.*;

/**
 * A class used to find and manage products.
 */
public class ProductRepository {

	private Map<String, Collection<Product>> products;

	public ProductRepository() {
		products = new HashMap<>();
	}

	/**
	 * Finds all products with the given name.
	 *
	 * @param name a name of the products
	 * @return all products with the given name
	 */
	Collection<Product> findByName(String name) {
		return products.get(name);
	}

	/**
	 * Adds a products to the repository;
	 *
	 * @param product a products to add
	 */
	void addProduct(Product product) {
		String name = product.getName();
		Collection<Product> matchingProducts = products.get(name);
		if (matchingProducts == null) {
			List<Product> initialProduct = new ArrayList<>();
			initialProduct.add(product);
			products.put(name, initialProduct);
		}
		else {
			matchingProducts.add(product);
		}
	}
}
