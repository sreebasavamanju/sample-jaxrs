package org.sree.tutorial.messanger.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.sree.tutorial.messanger.database.DatabaseClass;
import org.sree.tutorial.messanger.model.Profile;

public class ProfileService {

	private Map<String, Profile> profiles = DatabaseClass.getProfiles();

	public ProfileService() {
		profiles.put("user1",new Profile(1, "user1","firt name", "last Name") );
		profiles.put("user2",new Profile(2, "user2","firt name", "last Name") );
	}

	public List<Profile> getAllProfiles() {
		return new ArrayList<Profile>(profiles.values());
	}

	public Profile getProfile(String profileName) {
		return profiles.get(profileName);
	}

	public Profile addProfile(Profile profile) {
		profile.setId(profiles.size() + 1);
		profiles.put(profile.getProfileName(), profile);
		return profile;
	}

	public Profile updateProfile(Profile profile) {
		if (profile.getProfileName().isEmpty()) {
			return null;
		}
		profiles.put(profile.getProfileName(), profile);
		return profile;
	}

	public Profile removeProfile(String profileName) {
		return profiles.remove(profileName);
	}
}
