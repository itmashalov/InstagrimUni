/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import DataBases.MySql;
import Servlets.GalleryServlet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author imashalov
 * We are using this class for different operations with multiple images 
 * and displaying the galleries for users or for tags
 */
public class Gallery extends MySql {

    public Gallery() {

    }

    //this function is used to return list of images for a certain user
    //we later pass this list to getHtmlForImages function.
    public java.util.LinkedList<Image> getPicsForUser(String User) {
        java.util.LinkedList<Image> Pics = new java.util.LinkedList();

        Pics = super.getPicsForUser(User);
        return Pics;
    }

    //this function returns the latest image for an user
    public Image getLatestImgForUser(String User) {
        Image Pic = new Image();

        Pic = super.getLatestImgForUser(User);

        return Pic;
    }

    //this function returns a list of images for a selected tag.
    public java.util.LinkedList<Image> getPicsForTag(String tag, String loggedUser) {
        java.util.LinkedList<Image> Pics = new java.util.LinkedList();

        Pics = super.getPicsForTag(tag, loggedUser);

        return Pics;
    }

    //this function is used to return html gallery for certain user.
    public String getHtmlForImages(java.util.LinkedList<Image> images, String user) {
        String htm = "";
        Iterator<Image> it = images.iterator();
        while (it.hasNext()) {

            Image p = (Image) it.next();
            boolean isPublicPic = p.isPublicPic(p.getId());

            //here we check if the image is public or the owner of the image is the same as the user selected
            //we need this check because when we search for images we must show only our images or public images.
            if (isPublicPic == true || user.equals(p.getOwner())) {
                byte[] imgData = new byte[10];
                try {
                    imgData = p.getImgBlob().getBytes(1, (int) p.getImgBlob().length());
                } catch (SQLException ex) {
                    Logger.getLogger(GalleryServlet.class.getName()).log(Level.SEVERE, null, ex);
                }

                String b64 = javax.xml.bind.DatatypeConverter.printBase64Binary(imgData);
                String del = "";
                //we are checking if the image is owned by the logged user if yes then we add the option to delete the image
                if (user.equals(p.getOwner())) {
                    del = "<a  href=\"#\" onclick=\"javascript:deleteImgConf(" + p.getId() + ")\" ><img src=\"icons/bin_icon.png\" alt=\"Delete\" width=\"14%\"  ></a>\n";
                }
                htm = htm + "<article onmouseover=\"javascrtipt:ajaxGetCommentsCount(" + p.getId() + ");\""
                        + "  style=\"height:140px;width:200px;margin-left:47px;\" id='" + p.getId() + "'"
                        + "  onclick=\"javascript:openImageFrame(" + p.getId() + "," + p.getCommentsCount(p.getId()) + ") ;"
                        + "   ajaxOpenFrame('comment" + p.getId() * 2.31111 + "'," + p.getId() + "); \">"
                        + "                    <header> "
                        + "<p>" + "#" + p.getTag() + "   Owner:" + p.getOwner() + "</p>"
                        + " <img src='data:image/png;base64," + b64 + "'  width=\"200px\"  style=\"margin-top: 8px;clip: rect(0px,200px,100px,0px); position: absolute;\" id='" + p.getId() * 2.41111 + "'/>"
                        + "<br><p  style=\"position: absolute;margin-top: 90px;\" id='" + p.getId() * 2.21111 + "'>"
                        + "</p>"
                        + "  <div style=\"display:none;margin-top: 10px; position: absolute;\"  id='" + p.getId() * 2.31111 + "'>"
                        + del
                        + "                            <br>\n"
                        + "                            <form name=\"myForm\"   method=\"post\" >"
                        + "  <input type=\"hidden\"   name=\"id\"  value=\"" + p.getId() + "\"> "
                        + "   <textarea   id=\"comment" + p.getId() * 2.31111 + "\"  rows=\"4\" cols=\"30\" autofocus>      </textarea>\n"
                        + "  <br>\n"
                        + "   <input type=\"button\" onclick=\"javascript:ajaxAddComment('comment" + p.getId() * 2.31111 + "'," + p.getId() + ");"
                        + "  increaseSizeCom(" + p.getId() + ");\" value=\"Post Comment\"> </td>"
                        + "   </form> "
                        + "  <p  id=\"commentscomment" + p.getId() * 2.31111 + "\">"
                        + "                            </p>\n"
                        + "                        </div>\n"
                        + "                    </header>"
                        + "                </article>";

            }
        }
        htm = htm + "  <div id=\"galleryLights\"   style=\"position:absolute;width:100%;height:100%;background-color:black;opacity:0.0;display:none\"></div>";

        return htm;
    }

}
