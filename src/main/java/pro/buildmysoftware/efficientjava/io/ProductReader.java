package pro.buildmysoftware.efficientjava.io;

import java.util.Collection;
import java.util.Optional;
import java.util.UUID;

public interface ProductReader {

	Collection<Product> readAllProducts();

	Collection<Product> readProductsByName(String name);

	Optional<Product> readProductById(UUID id);
}
