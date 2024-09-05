package com.munwar.wipro.milestone3;


import java.util.HashMap;
import java.util.Map;

public class UserProfileService {
    private Map<String, UserProfile> userProfiles = new HashMap<>();

    // Create User Profile
    public boolean createUserProfile(String userId, UserProfile userProfile) {
        if (userProfiles.containsKey(userId)) {
            return false; // User ID already exists
        }
        userProfiles.put(userId, userProfile);
        return true;
    }

    // Retrieve User Profile
    public UserProfile getUserProfile(String userId) {
        return userProfiles.get(userId); // Returns null if user ID does not exist
    }

    // Update User Profile
    public boolean updateUserProfile(String userId, UserProfile updatedProfile) {
        if (!userProfiles.containsKey(userId)) {
            return false; // User ID does not exist
        }
        userProfiles.put(userId, updatedProfile);
        return true;
    }

    // Delete User Profile
    public boolean deleteUserProfile(String userId) {
        if (userProfiles.remove(userId) != null) {
            return true; // Successfully deleted
        }
        return false; // User ID does not exist
    }
}
