/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import DataBases.MySql;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Ivan
 */
public class Image {

    private int type;
    private String nametag;
    private String user;
    private InputStream image;
    private String path;
    private List comments;
    private int id;

    public Image() {

    }

    public Image(int type, String nametag, String user, InputStream image) {
        this.type = type;
        this.nametag = nametag;
        this.user = user;
        this.image = image;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }

    public void setTag(String nametag) {
        this.nametag = nametag;
    }

    public String getTag() {
        return nametag;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public int getCommentsCount(int id) {
        int count;
        MySql sql = new MySql();
        count = sql.getCommentsCount(id);

        return count;
    }

    public List getComments(int id) {
        List comments = new ArrayList();
        MySql sql = new MySql();
        comments = sql.getCommentsForID(id);

        return comments;
    }

    public List getUsers(int id) {
        List usernames = new ArrayList();
        MySql sql = new MySql();
        usernames = sql.getUserForImageID(id);

        return usernames;
    }

    public boolean addImage() {
        boolean success = false;
        MySql sql = new MySql();
        success = sql.addImage(type, nametag, user, image);

        if (success == true) {
            sql.createImageGallery(user);
        }
        return success;
    }

    public boolean deleteImage(int id) {
        boolean success = false;
        MySql sql = new MySql();
        success = sql.deleteImage(id);

        if (success == true) {
            boolean deletedComments = deleteComments(id);
        }
        return success;
    }

    private boolean deleteComments(int id) {
        boolean success = false;
        MySql sql = new MySql();
        success = sql.deleteComments(id);

        if (success == true) {
            sql.createImageGallery(user);
        }
        return success;
    }
}
