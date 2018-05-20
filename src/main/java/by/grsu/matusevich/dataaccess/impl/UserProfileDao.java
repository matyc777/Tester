package by.grsu.matusevich.dataaccess.impl;

import java.io.Serializable;
import java.util.List;

import by.grsu.matusevich.dataaccess.AbstractDao;
import by.grsu.matusevich.datamodel.UserProfile;
import by.grsu.matusevich.table.UserProfileTable;

public class UserProfileDao extends AbstractDao<UserProfileTable,UserProfile> implements Serializable {
    public UserProfileDao(final String rootFolderPath){
        super(rootFolderPath);
    }

    @Override
    public void saveNew(UserProfile newUserProfile) {
        newUserProfile.setId(getNextId());
        final UserProfileTable userProfileTable = deserializeFromXml();
        userProfileTable.getRows().add(newUserProfile);
        serializeToXml(userProfileTable);
    }

    @Override
    public void update(UserProfile entity) {
        final UserProfileTable userProfileTable = deserializeFromXml();

        for (final UserProfile row : userProfileTable.getRows()) {
            if (row.getId().equals(entity.getId())) {
                row.setLogin(entity.getLogin());
                row.setPassword(entity.getPassword());
                row.setRole(entity.getRole());
                break;
            }
        }

        serializeToXml(userProfileTable);
    }

    @Override
    public UserProfile get(Long id) {
        final UserProfileTable userProfileTable = deserializeFromXml();

        for (final UserProfile row : userProfileTable.getRows()) {
            if (row.getId().equals(id)) {
                return row;
            }
        }
        return null;
    }

    @Override
    public List<UserProfile> getAll() {
        final UserProfileTable userProfileTable = deserializeFromXml();
        return userProfileTable.getRows();
    }

    @Override
    public void delete(Long id) {
        final UserProfileTable userProfileTable = deserializeFromXml();

        UserProfile toBeDeleted = null;
        for (final UserProfile row : userProfileTable.getRows()) {
            if (row.getId().equals(id)) {

                toBeDeleted = row;
                break;
            }
        }

        userProfileTable.getRows().remove(toBeDeleted);

        serializeToXml(userProfileTable);
    }
    protected Class<UserProfileTable> getTableClass(){
        return UserProfileTable.class;
    }
}
