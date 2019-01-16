package pro.buildmysoftware.efficientjava.classloader;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FlatPathClassLoader extends ClassLoader {

	private Path classpath;

	public FlatPathClassLoader(Path classpath) {
		this.classpath = classpath;
	}

	@Override
	protected Class<?> findClass(String name) throws ClassNotFoundException {
		try {
			byte[] classData = Files.readAllBytes(classpath
				.resolve(name + ".class"));
			return defineClass(name, classData, 0,
				classData.length);
		}
		catch (IOException e) {
			throw new ClassNotFoundException(e.getMessage(), e);
		}
	}
}
