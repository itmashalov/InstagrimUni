/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import DataBases.MySql;
import Servlets.GalleryServlet;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ivan
 */
public class Users {

    public Users() {

    }

    public java.util.LinkedList<User> getUsersByUserName(String User) {
        java.util.LinkedList<User> users = new java.util.LinkedList();

        MySql sql = new MySql();
        users = sql.getUsersByUserName(User);

        return users;
    }

    public void sendFriendRequest(String sender, String receiver) {

        MySql sql = new MySql();
        sql.sendFriendRequest(sender, receiver);
    }

    public String getHtmlUsers(java.util.LinkedList<User> users, String loggedUser) {
        String htm = "";
        Iterator<User> it = users.iterator();
        while (it.hasNext()) {
            User u = (User) it.next();
            if (loggedUser.equals(u.getUserName())) {

            } else {
                boolean isProfilePicSet = u.isProfilePicSet(u.getUserName());
                String img = "";
                if (isProfilePicSet == true) {
                    Image profilePic = u.getProfilePic();
                    byte[] imgData = new byte[10];
                    try {
                        imgData = profilePic.getImgBlob().getBytes(1, (int) profilePic.getImgBlob().length());
                    } catch (SQLException ex) {
                        Logger.getLogger(GalleryServlet.class.getName()).log(Level.SEVERE, null, ex);
                    }

                    String b64 = javax.xml.bind.DatatypeConverter.printBase64Binary(imgData);
                    img = " <img src='data:image/png;base64," + b64 + "'  width=\"200px\"  style=\"margin-top: 8px;clip: rect(0px,200px,100px,0px); position: absolute;\" id='" + u.getId() * 2.41111 + "'/>";
                }
                htm = htm + "<article   style=\"height:140px;width:200px;margin-left:47px;\" id='" + u.getId()
                        + "' onclick=\"javascript:openImageFrame(" + u.getId() + ", 180); \">"
                        //     + "   ajaxOpenFrame('comment" + p.getId() * 2.31111 + "'," + p.getId() + "); \">"
                        + "                    <header> "
                        + "<p>" + "Username: " + u.getUserName() + " </p>"
                        + img
                        + "<br><p  style=\"position: absolute;margin-top: 90px;\" id='" + u.getId() * 2.21111 + "'>"
                        + "</p>"
                        + "  <div style=\"display:none;margin-top: 10px; position: absolute;\"  id='" + u.getId() * 2.31111 + "'>"
                        + "<button onclick=\"javascript:ajaxGetGallery('" + u.getUserName() + "')\">Show Gallery</button>"
                        + "<br>"
                        + "<button onclick=\"javascript:ajaxSendFriendRequest('" + loggedUser + "','" + u.getUserName() + "')\">Send Friend Request</button>"
                        + "<button disabled data-toggle=\"disabledMsgButton\" title=\"You can Send Messages only to Friends!\" id=\"disabledMsgButton\">Send Message</button>"
                        + "                            <br>\n"
                        + "                        </div>\n"
                        + "                    </header>"
                        + "                </article>";

            }
        }
        htm = htm + "  <div id=\"galleryLights\"   style=\"position:absolute;width:100%;height:100%;background-color:black;opacity:0.0;display:none\"></div>";
        return htm;
    }
}
