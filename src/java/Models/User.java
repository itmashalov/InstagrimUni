package Models;

import DataBases.MySql;
import java.sql.Blob;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Ivan
 */
public class User extends MySql {

    private String username;
    private String password;
    private String email;
    private String name;
    private int id;
    private Image img = new Image();

    private boolean isValid = false;

    public User() {

    }

    public User(String username, String password, String email, String name) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setUserName(String username) {
        this.username = username;
    }

    public String getUserName() {
        return username;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setProfilePic(Image img) {
        this.img = img;
    }

    public Image getProfilePic() {

        return img;
    }

    public Image getProfilePic(String User) {
        Image prof = new Image();
        prof = super.getProfilePic(User);
        return prof;
    }

    public int getNumberOfRequest(String usr) {
        int num = 0;
        num = super.getNumberOfRequests(usr);
        return num;
    }

    public boolean isProfilePicSet(String user) {
        boolean isSet = false;

        isSet = super.isProfilePicSet(user);
        return isSet;
    }

    public boolean isValid() {
        boolean isExistingUser;

        super.configure();
        isExistingUser = super.isExistingUser(username);

        if (isExistingUser == false) {
            isValid = true;

        }
        return this.isValid;
    }

    public boolean isExistingEmail() {
        boolean isExistingEmail = true;

        isExistingEmail = super.isExistingEmail(email);
        return isExistingEmail;
    }

    public void registerUser() {

        super.register(username, password, name, email);
    }

    public boolean isAuthenticated() {
        boolean auth = super.isAuthenticated(username, password);
        return auth;
    }

    public void logOutUser() {
        MySql sql = new MySql();
    }

}
