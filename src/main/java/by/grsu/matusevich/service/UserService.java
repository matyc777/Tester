package by.grsu.matusevich.service;

import by.grsu.matusevich.datamodel.UserProfile;

import java.util.List;

public interface UserService {

    void register(UserProfile userProfile);

    UserProfile getProfile(Long id);

    List<UserProfile> getAll();
}
