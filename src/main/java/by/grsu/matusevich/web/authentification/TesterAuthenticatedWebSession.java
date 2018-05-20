package by.grsu.matusevich.web.authentification;

import by.grsu.matusevich.dataaccess.impl.UserProfileDao;
import by.grsu.matusevich.datamodel.UserProfile;
import by.grsu.matusevich.datamodel.UserRole;
import by.grsu.matusevich.web.Student.StudentPage;
import by.grsu.matusevich.web.Tutor.TutorPage;
import org.apache.wicket.authroles.authentication.AuthenticatedWebSession;
import org.apache.wicket.authroles.authorization.strategies.role.Roles;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.request.Request;
import org.apache.wicket.Component;
import org.apache.wicket.RestartResponseException;
import org.apache.wicket.request.mapper.parameter.PageParameters;

import java.util.List;

public class TesterAuthenticatedWebSession extends AuthenticatedWebSession {
    /**
     * Construct.
     *
     * @param request
     *            The current request object
     */

    public TesterAuthenticatedWebSession(Request request)
    {
        super(request);
    }

    /**
     * @see org.apache.wicket.authroles.authentication.AuthenticatedWebSession#authenticate(java.lang.String,
     *      java.lang.String)
     */
    @Override
    public boolean authenticate(final String username, final String password)
    {
        UserProfileDao userProfileDao = new UserProfileDao("testXmlFolder");
        List<UserProfile> users = userProfileDao.getAll();
        for (UserProfile userProfile : users)
            if (userProfile.getLogin().equals(username) && userProfile.getPassword().equals(password)) {
                if (userProfile.getRole().equals(UserRole.student)) throw new RestartResponseException(new StudentPage());
                else throw new RestartResponseException(new TutorPage());
            }

        return false;
        // Check username and password
        //return adminData.equals(username) && adminData.equals(password);
    }

    /**
     * @see org.apache.wicket.authroles.authentication.AuthenticatedWebSession#getRoles()
     */
    @Override
    public Roles getRoles()
    {
        return null;
    }
}
