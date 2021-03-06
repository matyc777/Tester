package by.grsu.matusevich.test;

import by.grsu.matusevich.dataaccess.impl.UserProfileDao;

import by.grsu.matusevich.datamodel.UserProfile;
import by.grsu.matusevich.datamodel.UserRole;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;


import junit.framework.Assert;

public class UserProfileDaoTest {

    private static final String TEST_XML_FOLDER = "testXmlFolder";
    private static UserProfileDao userProfileDao;

    @BeforeClass
    public static void createDao() {
        userProfileDao = new UserProfileDao(TEST_XML_FOLDER);
    }


    @AfterClass
    public static void deleteTestXmlData() {
        //	 write code to clean up by.grsu.matusevich.test results from FS

    }

    @Test
    public void testAdd() {
        System.out.println("Start 'save' by.grsu.matusevich.test for UserProfile");
        final UserProfile newUserProfile = saveNewTest();
        Assert.assertNotNull(userProfileDao.get(newUserProfile.getId()));
    }

    @Test
    public void testDelete() {
        System.out.println("Start 'delete' by.grsu.matusevich.test for UserProfile");
        final UserProfile newUserProfile = saveNewTest();
        userProfileDao.delete(newUserProfile.getId());
        Assert.assertNull(userProfileDao.get(newUserProfile.getId()));
    }

    @Test
    public void testGetAll() {
        System.out.println("Start 'getAll' by.grsu.matusevich.test for UserProfile");
        final int initialRowsCount = userProfileDao.getAll().size();
        saveNewTest();
        Assert.assertEquals(userProfileDao.getAll().size(), initialRowsCount + 1);
    }

    private UserProfile saveNewTest() {
        final UserProfile newUserProfile = new UserProfile();
        newUserProfile.setLogin("admin");
        newUserProfile.setPassword("admin");
        newUserProfile.setRole(UserRole.tutor);
        userProfileDao.saveNew(newUserProfile);
        return newUserProfile;
    }
}