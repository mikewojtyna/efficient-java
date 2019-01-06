package pro.buildmysoftware.efficientjava.review.user;

import java.util.Arrays;
import java.util.Collection;

class UserRepository {
	Collection<User> findAll() {
		return someUsers();
	}

	private Collection<User> someUsers() {
		User user = new User();
		user.setLogin("login");
		return Arrays.asList(user);
	}
}
