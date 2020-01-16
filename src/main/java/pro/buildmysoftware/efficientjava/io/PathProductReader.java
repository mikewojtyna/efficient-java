package pro.buildmysoftware.efficientjava.io;

import java.nio.file.Path;
import java.util.Collection;
import java.util.UUID;

public class PathProductReader implements ProductReader {

	private Path pathToDbFile;

	public PathProductReader(Path pathToDbFile) {
		this.pathToDbFile = pathToDbFile;
	}

	@Override
	public Collection<Product> readAllProducts() {
		return null;
	}

	@Override
	public Collection<Product> readProductsByName(String name) {
		return null;
	}

	@Override
	public Collection<Product> readProductById(UUID id) {
		return null;
	}
}
