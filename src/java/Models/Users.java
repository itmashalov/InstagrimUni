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
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ivan
 */
public class Users extends MySql {

    public Users() {

    }

    public java.util.LinkedList<User> getUsersIdWhoSentReq(String loggedUser) {
        java.util.LinkedList<User> potentialFriends = new java.util.LinkedList();
        potentialFriends = super.getUsersIdWhoSentReq(loggedUser);

        return potentialFriends;
    }

    public java.util.LinkedList<User> getUsersByUserName(String User) {
        java.util.LinkedList<User> users = new java.util.LinkedList();
        users = super.getUsersByUserName(User);
        return users;
    }

    public boolean sendFriendRequest(String sender, String receiver) {
        boolean sent;

        sent = super.sendFriendRequest(sender, receiver);
        return sent;
    }

    public String getFriendsStatus(String user, String friend) {
        String status = "";
        status = super.getFriendsStatus(user, friend);

        return status;
    }

    public String getHtmlUsers(java.util.LinkedList<User> users, String loggedUser) {
        String htm = "";
        Iterator<User> it = users.iterator();
        String status = "none";
        String options = "";

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
                status = getFriendsStatus(loggedUser, u.getUserName());
                if (status.equals("sent")) {
                    options = "<button onclick=\"javascript:ajaxConfirmFriend('" + u.getUserName() + "')\">Confirm</button>"
                            + "<br>"
                            + "<button onclick=\"javascript:ajaxDeclineFriend('" + u.getUserName() + "')\">Decline</button>"
                            + "<button disabled data-toggle=\"disabledMsgButton\" title=\"You can Send Messages only to Friends!\" id=\"disabledMsgButton\">Send Message</button>"
                            + "<button onclick=\"javascript:ajaxGetGallery('" + u.getUserName() + "')\">Show Gallery</button>";
                } else if (status.equals("confirmed")) {

                } else if (status.equals("")) {
                    options = "<button onclick=\"javascript:ajaxGetGallery('" + u.getUserName() + "')\">Show Gallery</button>"
                            + "<br>"
                            + "<button id=\"opener-3\" onclick=\"javascript:ajaxSendFriendRequest('" + loggedUser + "','" + u.getUserName() + "')\">Send Friend Request</button>"
                            + "<button disabled data-toggle=\"disabledMsgButton\" title=\"You can Send Messages only to Friends!\" id=\"disabledMsgButton\">Send Message</button>";

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
                        + options
                        + "                            <br>\n"
                        + "                        </div>\n"
                        + "                    </header>"
                        + "                </article>";

            }
        }
        htm = htm + "  <div id=\"galleryLights\"   style=\"position:absolute;width:100%;height:100%;background-color:black;opacity:0.0;display:none\"></div>";
        return htm;
    }

    public String getProfilePicForUserHtml(String usr) {
        String html = "";

        User u = new User();

        boolean isProfilePicSet = u.isProfilePicSet(usr);
        String img = "";
        if (isProfilePicSet == true) {
            Image profilePic = u.getProfilePic(usr);
            byte[] imgData = new byte[10];
            try {
                imgData = profilePic.getImgBlob().getBytes(1, (int) profilePic.getImgBlob().length());
            } catch (SQLException ex) {
                Logger.getLogger(GalleryServlet.class.getName()).log(Level.SEVERE, null, ex);
            }

            String b64 = javax.xml.bind.DatatypeConverter.printBase64Binary(imgData);
            html = "<div> <img src='data:image/png;base64," + b64 + "'  width=\"200px\"  style=\"margin-top: 8px;clip: rect(0px,200px,100px,0px); position: absolute;\"  /></div>";
        }

        return html;
    }

    public String getNumberOfRequest(String usr) {
        String html = "";
        User u = new User();
        int number = u.getNumberOfRequest(usr);

        if (number < 1) {
            html = "<div  style=\"margin-top:110px;\">You dont have any friend requests </div>";
        } else if (number == 1) {
            html = "<div style=\"margin-top:110px;\">One Person has sent you friend request.</div>";
        } else {
            html = "<div  style=\"margin-top:100px;\">" + number + " people have sent you friend requests.</div>";
        }

        return html;
    }
}
