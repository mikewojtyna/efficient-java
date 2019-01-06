package pro.buildmysoftware.efficientjava.review.user;

import java.time.LocalDate;
import java.util.Objects;

class Profile {
	private String login;
	private String firstName;
	private String lastName;
	private LocalDate birthDate;

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	@Override
	public String toString() {
		return "Profile{" + "login='" + login + '\'' + ", firstName='" + firstName + '\'' + ", lastName='" + lastName + '\'' + ", birthDate=" + birthDate + '}';
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Profile profile = (Profile) o;
		return Objects.equals(login, profile.login) && Objects
			.equals(firstName, profile.firstName) && Objects
			.equals(lastName, profile.lastName) && Objects
			.equals(birthDate, profile.birthDate);
	}

	@Override
	public int hashCode() {
		return Objects.hash(login, firstName, lastName, birthDate);
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public LocalDate getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}
}
