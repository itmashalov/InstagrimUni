/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import DataBases.MySql;
import java.io.InputStream;

/**
 *
 * @author Ivan
 */
public class Image {

    private int type;
    private String nametag;
    private String user;
    private InputStream image;

    public Image(int type, String nametag, String user, InputStream image) {
        this.type = type;
        this.nametag = nametag;
        this.user = user;
        this.image = image;
    }

    public boolean addImage() {
        boolean success = false;
        MySql sql = new MySql();
        success = sql.addImage(type, nametag, user, image);

        if(success==true){
            sql.createImageGallery(user);
        }
        return success;
    }
}
