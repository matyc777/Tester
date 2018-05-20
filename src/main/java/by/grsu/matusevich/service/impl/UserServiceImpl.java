package by.grsu.matusevich.service.impl;

import by.grsu.matusevich.dataaccess.impl.UserProfileDao;
import by.grsu.matusevich.datamodel.UserProfile;
import by.grsu.matusevich.service.UserService;

import java.util.List;


public class UserServiceImpl implements UserService {

    private UserProfileDao userProfileDao;

    public UserServiceImpl(String rootFolderPath){
        super();
        this.userProfileDao = new UserProfileDao(rootFolderPath);
    }

    @Override
    public void register(UserProfile userProfile){
        userProfileDao.saveNew(userProfile);
    }

    @Override
    public UserProfile getProfile(Long id){
        return userProfileDao.get(id);
    }

    @Override
    public List<UserProfile> getAll(){return userProfileDao.getAll();}
}
