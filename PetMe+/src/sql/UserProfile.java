package sql;

/**
 * Settings and user information representing a user's profile
 */
public class UserProfile {
    public String name;
    public String icon;
    public String email;
    public String phone;
    public boolean lightmode;
    
    UserProfile(UserProfileBuilder builder) {
        
    }

    @Override
    public String toString() {
        return name + " | " + email + " | " + lightmode;
    }

}
