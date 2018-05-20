package datamodel;

public class UserProfile extends AbstractModel {
    private String login;
    private String password;
    private UserRole role;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }

    public UserRole getRole() {
        return role;
    }
}
