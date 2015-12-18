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
 * @author Ivan This class is a container class for a user and offer some
 * functions related to an user.
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

    // we set the id of the user
    public void setId(int id) {
        this.id = id;
    }

    //we get the id of the user
    public int getId() {
        return id;
    }

    //we set the user name of the user
    public void setUserName(String username) {
        this.username = username;
    }

    //we get the username of the user
    public String getUserName() {
        return username;
    }

    //we set the name of the user
    public void setName(String name) {
        this.name = name;
    }

    //we get the name of the user
    public String getName() {
        return name;
    }

    //we set the profile image
    public void setProfilePic(Image img) {
        this.img = img;
    }

    //we get profile pic using this function
    public Image getProfilePic() {

        return img;
    }

    //we get profile profitle pick having a user parameter
    public Image getProfilePic(String User) {
        Image prof = new Image();
        prof = super.getProfilePic(User);
        return prof;
    }

    //this function returns the number of friend request for user
    public int getNumberOfRequest(String usr) {
        int num = 0;
        num = super.getNumberOfRequests(usr);
        return num;
    }

    //this function returns the number of friends for a certain user
    public int getNumberOfFriends(String usr) {
        int num = 0;
        num = super.getNumberOfFriends(usr);
        return num;
    }

    // using this function we can check if the user has set profile image
    public boolean isProfilePicSet(String user) {
        boolean isSet = false;

        isSet = super.isProfilePicSet(user);
        return isSet;
    }

    //this function checks if there is an existing user
    public boolean isValid() {
        boolean isExistingUser;

        super.configure();
        isExistingUser = super.isExistingUser(username);

        if (isExistingUser == false) {
            isValid = true;

        }
        return this.isValid;
    }

    //this function checks if the email alreary exists
    public boolean isExistingEmail() {
        boolean isExistingEmail = true;

        isExistingEmail = super.isExistingEmail(email);
        return isExistingEmail;
    }

    //thsi function adds a new user
    public void registerUser() {

        super.register(username, password, name, email);
    }

    //we can authenticate a user using this function
    public boolean isAuthenticated() {
        boolean auth = super.isAuthenticated(username, password);
        return auth;
    }

    // 
    public void logOutUser() {
        MySql sql = new MySql();
    }

}
