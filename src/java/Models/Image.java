/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import DataBases.MySql;
import java.io.InputStream;
import java.sql.Blob;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Ivan
 */
public class Image extends MySql {

    private int type;
    private String nametag;
    private String user;
    private InputStream image;
    private int id;
    private Blob img;
    private int profile;

    public Image() {

    }

    public Image(int type, int profile, String nametag, String user, InputStream image) {
        this.type = type;
        this.profile = profile;
        this.nametag = nametag;
        this.user = user;
        this.image = image;
    }

    public void setOwner(String user) {
        this.user = user;
    }

    public String getOwner() {
        return user;
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

    public void setImgBlob(Blob img) {
        this.img = img;
    }

    public Blob getImgBlob() {
        return img;
    }

    public int getCommentsCount(int id) {
        int count;

        count = super.getCommentsCount(id);

        return count;
    }

    public List getComments(int id) {
        List comments = new ArrayList();

        comments = super.getCommentsForID(id);
        return comments;
    }

    public List getUsers(int id) {
        List usernames = new ArrayList();

        usernames = super.getUserForImageID(id);
        return usernames;
    }

    public boolean isPublicPic(int id) {
        boolean isPublicPic = super.isPublicPic(id);
        return isPublicPic;
    }

    public boolean addImage() {
        boolean success = false;

        success = super.addImage(type, profile, nametag, user, image);
        return success;
    }

    public boolean deleteImage(int id) {
        boolean success = false;

        success = super.deleteImage(id);

        if (success == true) {
            boolean deletedComments = deleteComments(id);
        }
        return success;
    }

    public boolean deleteComments(int id) {
        boolean success = false;

        success = super.deleteComments(id);
        return success;
    }
}
