/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProfileManager;

/**
 *
 * @author Owner
 */
public class UserProfileBuilder {
    public String name;
    public String email;
    public String phone;
    public String icon;
    public boolean lightmode;
    
    public UserProfileBuilder(String name, String icon, String phone, boolean lightmode, String email){
        this.name=name;
        this.email=email;
        this.phone=phone;
        this.icon=icon;
        this.lightmode=lightmode;
    }

    public UserProfileBuilder() {
    }


    public UserProfileBuilder setName(String name) {
        this.name=name;
        return this;
    }

    public UserProfileBuilder setIcon(String icon) {
        return this;
    }

    public UserProfileBuilder setPhone(String phone) {
        return this;
    }

    public UserProfileBuilder setEmail(String email) {
        return this;
    }
    
    public UserProfileBuilder setlightmode(boolean lightmode){
        return this;
    }
    
    public UserProfile build(){
        return new UserProfile(this);
    }
}
