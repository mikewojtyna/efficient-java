package pro.buildmysoftware.efficientjava.proxy;

public interface Product {
	@Cache
	String getName();
}
