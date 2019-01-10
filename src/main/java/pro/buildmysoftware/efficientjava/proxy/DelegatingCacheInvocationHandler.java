package pro.buildmysoftware.efficientjava.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class DelegatingCacheInvocationHandler implements InvocationHandler {
	private Object target;

	public DelegatingCacheInvocationHandler(Object target) {
		this.target = target;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		if (method.isAnnotationPresent(Cache.class)) {
			return "cached result";
		}
		return method.invoke(target, args);
	}
}
