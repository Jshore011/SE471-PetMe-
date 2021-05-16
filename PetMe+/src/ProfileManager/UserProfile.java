package ProfileManager;

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

    String getName() {
        return name;
    }
    void setName(String name){
        this.name=name;
    }

    String getIcon() {
        return icon;
    }
    void seticon(String icon){
        this.icon=icon;
    }
    String getPhone() {
        return phone;
    }
    void setPhone(String phone){
        this.phone=phone;
    }

    String getEmail() {
        return email;
    }
    void setEmail(String email){
        this.email=email;
    }
    
    boolean getlightmode(){
        return lightmode;
    }
    
    void setlightmode(boolean lightmode){
        this.lightmode=lightmode;
    }
}
