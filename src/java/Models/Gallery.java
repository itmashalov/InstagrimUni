/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import DataBases.MySql;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author imashalov
 */
public class Gallery {

    private String user;

    public Gallery(String user) {
        this.user = user;
    }

    ;
    
    public List showGallery() {
        List images = new ArrayList();
        //images.add(user);
        //images.add("Vending Machine");
        MySql sql = new MySql();
        images = sql.showGallery(user);
        return (images);
    }

    public java.util.LinkedList<Image> getPicsForUser(String User) {
        java.util.LinkedList<Image> Pics = new java.util.LinkedList();

        MySql sql = new MySql();
        Pics = sql.getPicsForUser(user);

        return Pics;
    }

}