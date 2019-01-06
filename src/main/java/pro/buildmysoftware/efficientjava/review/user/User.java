package pro.buildmysoftware.efficientjava.review.user;

import java.util.Objects;

class User {
	private String login;
	private Profile profile;

	@Override
	public String toString() {
		return "User{" + "login='" + login + '\'' + ", profile=" + profile + '}';
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		User user = (User) o;
		return Objects.equals(login, user.login);
	}

	@Override
	public int hashCode() {
		return Objects.hash(login);
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public Profile getProfile() {
		return profile;
	}

	public void setProfile(Profile profile) {
		this.profile = profile;
	}
}
