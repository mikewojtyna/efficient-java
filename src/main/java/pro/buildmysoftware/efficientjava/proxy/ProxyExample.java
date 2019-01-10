package pro.buildmysoftware.efficientjava.proxy;

import java.lang.reflect.Proxy;

public class ProxyExample {
	public static void main(String[] args) {
		Product apple = new Apple();

		Product product =
			(Product) Proxy.newProxyInstance(Product.class
			.getClassLoader(), new Class[]{Product.class},
				new DelegatingCacheInvocationHandler(apple));

		System.out.println(product.getName());
	}
}