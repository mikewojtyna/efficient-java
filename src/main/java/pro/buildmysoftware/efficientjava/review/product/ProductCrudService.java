package pro.buildmysoftware.efficientjava.review.product;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

class ProductCrudService {
	private static final Logger LOGGER = LoggerFactory
		.getLogger(ProductCrudService.class);
	private Collection<Product> products;

	ProductCrudService() {
		products = new ArrayList<>();
	}

	void save(Product product) {
		LOGGER.info(String.format("Saving product %s", product));
		saveInRepository(product);
	}

	Optional<Product> findByName(String name) {
		LOGGER.info(String
			.format("Finding product with name %s", name));
		Optional<Product> foundProduct = findInRepositoryByName(name);
		foundProduct.ifPresent(p -> LOGGER.info(String
			.format("Product %s with name %s found!", p, name)));
		return foundProduct;
	}

	private Optional<Product> findInRepositoryByName(String name) {
		return products.stream().filter(p -> p.getName().equals(name))
			.findAny();
	}

	private void saveInRepository(Product product) {
		products.add(product);
	}
}
