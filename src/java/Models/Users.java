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

    public String getHtmlUsers(java.util.LinkedList<User> users, String loggedUser) {
        String htm = "";
        Iterator<User> it = users.iterator();
        while (it.hasNext()) {
            User u = (User) it.next();
            Image profilePic =u.getProfilePic();
            byte[] imgData = new byte[10];
            try {
                imgData = profilePic.getImgBlob().getBytes(1, (int) profilePic.getImgBlob().length());
            } catch (SQLException ex) {
                Logger.getLogger(GalleryServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
//
             String b64 = javax.xml.bind.DatatypeConverter.printBase64Binary(imgData);
//            String del = "";
//            if (user.equals(p.getOwner())) {
//                del = "<a  href=\"#\" onclick=\"javascript:deleteImgConf(" + p.getId() + ")\" ><img src=\"icons/bin_icon.png\" alt=\"Delete\" width=\"14%\"  ></a>\n";
//            }
//            htm = htm + "<article onmouseover=\"javascrtipt:ajaxGetCommentsCount(" + p.getId() + ");\""
//                    + "  style=\"height:140px;width:200px;margin-left:47px;\" id='" + p.getId() + "'"
//                    + "  onclick=\"javascript:openImageFrame(" + p.getId() + "," + p.getCommentsCount(p.getId()) + ") ;"
//                    + "   ajaxOpenFrame('comment" + p.getId() * 2.31111 + "'," + p.getId() + "); \">"
//                    + "                    <header> "
//                    + "<p>" + "#" + p.getTag() + "   Owner:" + p.getOwner() + "</p>"
//                    + " <img src='data:image/png;base64," + b64 + "'  width=\"200px\"  style=\"margin-top: 8px;clip: rect(0px,200px,100px,0px); position: absolute;\" id='" + p.getId() * 2.41111 + "'/>"
//                    + "<br><p  style=\"position: absolute;margin-top: 90px;\" id='" + p.getId() * 2.21111 + "'>"
//                    + "</p>"
//                    + "  <div style=\"display:none;margin-top: 10px; position: absolute;\"  id='" + p.getId() * 2.31111 + "'>"
//                    + del
//                    + "                            <br>\n"
//                    + "                            <form name=\"myForm\"   method=\"post\" >"
//                    + "  <input type=\"hidden\"   name=\"id\"  value=\"" + p.getId() + "\"> "
//                    + "   <textarea   id=\"comment" + p.getId() * 2.31111 + "\"  rows=\"4\" cols=\"30\" autofocus>      </textarea>\n"
//                    + "  <br>\n"
//                    + "   <input type=\"button\" onclick=\"javascript:ajaxAddComment('comment" + p.getId() * 2.31111 + "'," + p.getId() + ");"
//                    + "  increaseSizeCom(" + p.getId() + ");\" value=\"Post Comment\"> </td>"
//                    + "   </form> "
//                    + "  <p  id=\"commentscomment" + p.getId() * 2.31111 + "\">"
//                    + "                            </p>\n"
//                    + "                        </div>\n"
//                    + "                    </header>"
//                    + "                </article>";
//
         }
//        htm = htm + "  <div id=\"galleryLights\"   style=\"position:absolute;width:100%;height:100%;background-color:black;opacity:0.0;display:none\"></div>";
       return htm;
    }
}
