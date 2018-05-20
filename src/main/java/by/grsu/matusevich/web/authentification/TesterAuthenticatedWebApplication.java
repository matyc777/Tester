package by.grsu.matusevich.web.authentification;

import org.apache.wicket.Page;
import org.apache.wicket.authroles.authentication.AbstractAuthenticatedWebSession;
import org.apache.wicket.authroles.authentication.AuthenticatedWebApplication;
import org.apache.wicket.markup.html.WebPage;


/**
 * A role-authorized, authenticated web application in just a few lines of code.
 *
 * @author Jonathan Locke
 */
public class TesterAuthenticatedWebApplication extends AuthenticatedWebApplication
{
    /**
     * @see org.apache.wicket.Application#getHomePage()
     */
    @Override
    public Class<? extends Page> getHomePage()
    {
        return HomePage.class;
    }

    /**
     * @see org.apache.wicket.authentication.AuthenticatedWebApplication#getWebSessionClass()
     */
    @Override
    protected Class<? extends AbstractAuthenticatedWebSession> getWebSessionClass()
    {
        return TesterAuthenticatedWebSession.class;
    }

    /**
     * @see org.apache.wicket.authentication.AuthenticatedWebApplication#getSignInPageClass()
     */
    @Override
    protected Class<? extends WebPage> getSignInPageClass()
    {
        return TesterSignInPage.class;
    }

    /**
     * @see org.apache.wicket.authentication.AuthenticatedWebApplication#init()
     */
    @Override
    protected void init()
    {
        super.init();
        getDebugSettings().setDevelopmentUtilitiesEnabled(true);
    }
}