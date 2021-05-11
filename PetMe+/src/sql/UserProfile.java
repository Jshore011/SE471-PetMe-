package sql;

import utils.Constants;

import java.util.Date;

/**
 * Settings and user information representing a user's profile
 */
public class UserProfile {
    public String name;
    public String icon;
    public String email;
    public String phone;
    public boolean lightmode;

    @Override
    public String toString() {
        return name + " | " + email + " | " + lightmode;
    }

}
