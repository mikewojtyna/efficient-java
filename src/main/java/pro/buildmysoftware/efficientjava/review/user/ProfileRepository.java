package pro.buildmysoftware.efficientjava.review.user;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collection;

class ProfileRepository {
	Collection<Profile> findAll() {
		return someProfiles();
	}

	private Collection<Profile> someProfiles() {
		Profile profile = new Profile();
		profile.setLogin("login");
		profile.setBirthDate(LocalDate.now());
		profile.setFirstName("first name");
		profile.setLastName("last name");
		return Arrays.asList(profile);
	}
}
