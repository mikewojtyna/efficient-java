package pro.buildmysoftware.efficientjava.io;

import java.util.Collection;
import java.util.UUID;

public interface ProductReader {

	Collection<Product> readAllProducts();

	Collection<Product> readProductsByName(String name);

	Collection<Product> readProductById(UUID id);
}
