package pro.buildmysoftware.efficientjava.review.user;

import java.util.Collection;

class UserFinder {
	private UserRepository repository;
	private ProfileRepository profileRepository;

	public UserFinder(UserRepository repository,
			  ProfileRepository profileRepository) {
		this.repository = repository;
		this.profileRepository = profileRepository;
	}

	User findUserByFirstName(String firstName) {
		Collection<User> allUsers = repository.findAll();
		allUsers.stream().forEach(u -> {
			profileRepository.findAll().stream()
				.filter(p -> u.getLogin().equals(p.getLogin()))
				.findAny().ifPresent(p -> u.setProfile(p));
		});
		return allUsers.stream()
			.filter(user -> user.getProfile().getFirstName()
				.equals(firstName)).findAny().get();
	}
}
