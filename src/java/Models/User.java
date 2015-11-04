package Models;

import DataBases.MySql;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Ivan
 */
public class User {

    private String username;
    private String password;
    private String email;
    private String name;
    private boolean isValid = false;

    public User(String username, String password, String email, String name) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.name = name;
    }

    public boolean isValid() {
        boolean isExistingUser;
        MySql sql = new MySql();
        sql.configure();
        isExistingUser = sql.isExistingUser(username);

        if (isExistingUser == false) {
            isValid = true;

        }
        return this.isValid;
    }

    public void registerUser() {
        MySql sql = new MySql();
        sql.register(username, password, name, email);

    }

    public boolean isAuthenticated() {
        MySql sql = new MySql();
        boolean auth = sql.isAuthenticated(username, password);
        return auth;
    }

}
