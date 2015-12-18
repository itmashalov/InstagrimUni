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
 * This class is a container for images and it's properties
 * we have different functions related to a certain image
 *
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
    
    //here we set the owner
    public void setOwner(String user) {
        this.user = user;
    }
    
    //here we get the owner
    public String getOwner() {
        return user;
    }
    
    //set the tag of the image
    public void setTag(String nametag) {
        this.nametag = nametag;
    }
    
    //get the tag of the image
    public String getTag() {
        return nametag;
    }

    //set the id of the image
    public void setId(int id) {
        this.id = id;
    }

    //get the id
    public int getId() {
        return id;
    }

    //we use this function the set the actual image as a blob
    public void setImgBlob(Blob img) {
        this.img = img;
    }

    //we get the actual image as a blob
    public Blob getImgBlob() {
        return img;
    }

    //we get the comments count for this image using this function
    public int getCommentsCount(int id) {
        int count;

        count = super.getCommentsCount(id);

        return count;
    }

    //this function is used to get a list of comments for a image id
    public List getComments(int id) {
        List comments = new ArrayList();

        comments = super.getCommentsForID(id);
        return comments;
    }

    //we get the owner with this function 
    public List getUsers(int id) {
        List usernames = new ArrayList();

        usernames = super.getUserForImageID(id);
        return usernames;
    }

    //we check if the image is public using this function
    public boolean isPublicPic(int id) {
        boolean isPublicPic = super.isPublicPic(id);
        return isPublicPic;
    }

    //we add new image using this function
    public boolean addImage() {
        boolean success = false;

        success = super.addImage(type, profile, nametag, user, image);
        return success;
    }
    
    //we delete an image with this function and returning the if successful
    public boolean deleteImage(int id) {
        boolean success = false;

        success = super.deleteImage(id);

        if (success == true) {
            boolean deletedComments = deleteComments(id);
        }
        return success;
    }

    //we delete comments for an image;
    public boolean deleteComments(int id) {
        boolean success = false;

        success = super.deleteComments(id);
        return success;
    }
}
