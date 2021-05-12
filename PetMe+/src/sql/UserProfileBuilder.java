/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sql;

/**
 *
 * @author Owner
 */
public class UserProfileBuilder {
    private String name;
    private String email;
    private String phone;
    private String icon;
    private boolean lightmode;
    
    UserProfileBuilder(String name, String icon, String phone, boolean lightmode, String email){
        this.name=name;
        this.email=email;
        this.phone=phone;
        this.icon=icon;
        this.lightmode=lightmode;
    }

    UserProfileBuilder() {
    }
    
    UserProfileBuilder setName(String name) {
        this.name=name;
        return this;
    }

    UserProfileBuilder setIcon(String icon) {
        return this;
    }

    UserProfileBuilder setPhone(String phone) {
        return this;
    }

    UserProfileBuilder setEmail(String email) {
        return this;
    }
    
    UserProfileBuilder setlightmode(boolean lightmode){
        return this;
    }
    
    public UserProfile build(){
        return new UserProfile(name, icon, phone, lightmode, email);
    }
}
