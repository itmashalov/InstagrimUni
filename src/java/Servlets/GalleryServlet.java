/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Models.Gallery;

import java.util.List;
import javax.servlet.RequestDispatcher;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Models.Image;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Admin
 */
//
public class GalleryServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String user = (String) request.getParameter("userID");
        String imgID = request.getParameter("tag");
      //  user = "qweqwe";//test purposes;
        Gallery gal = new Gallery(user);
        HttpSession session = request.getSession();
        java.util.LinkedList<Image> images = gal.getPicsForUser(user);

        Iterator<Image> it = images.iterator();
        while (it.hasNext()) {
            Image p = (Image) it.next();

            byte[] imgData = new byte[10];
            try {
                imgData = p.getImgBlob().getBytes(1, (int) p.getImgBlob().length());
            } catch (SQLException ex) {
                Logger.getLogger(GalleryServlet.class.getName()).log(Level.SEVERE, null, ex);
            }

            String b64 = javax.xml.bind.DatatypeConverter.printBase64Binary(imgData);
            out.println("<article onmouseover=\"javascrtipt:ajaxGetCommentsCount(" + p.getId() + ");\""
                    + "  style=\"height:140px;width:200px;margin-left:47px;\" id='" + p.getId() + "'"
                    + "  onclick=\"javascript:openImageFrame(" + p.getId() + "," + p.getCommentsCount(p.getId()) + ") ;"
                    + "   ajaxOpenFrame('comment" + p.getId() * 2.31111 + "'," + p.getId() + "); \">"
                    + "                    <header> "
                    + "<p>" + p.getTag() + "</p>"
                    + " <img src='data:image/png;base64," + b64 + "'  width=\"200px\"  style=\"margin-top: 8px;clip: rect(0px,200px,100px,0px); position: absolute;\" id='" + p.getId() * 2.41111 + "'/>"
                    + "<br><p  style=\"position: absolute;margin-top: 90px;\" id='" + p.getId() * 2.21111 + "'>"
                    + "</p>"
                    + "  <div style=\"display:none;margin-top: 10px; position: absolute;\"  id='" + p.getId() * 2.31111 + "'>"
                    + "<a  href=\"#\" onclick=\"javascript:deleteImgConf(" + p.getId() + ")\" ><img src=\"icons/bin_icon.png\" alt=\"Delete\" width=\"14%\"  ></a>\n"
                    + "                            <br>\n"
                    + "                            <form name=\"myForm\"   method=\"post\" >"
                    + "   <input type=\"hidden\"   name=\"u\"  value=\"" + session.getAttribute("user") + "\"> "
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
                    + "                </article>"
                     
            );
        }
         out.println("  <div id=\"galleryLights\"   style=\"position:absolute;width:100%;height:100%;background-color:black;opacity:0.0;display:none\"></div>");

//        try {
//            HttpSession session = request.getSession();
//            String user = (String) session.getAttribute("user");
//            Gallery gal = new Gallery(user);
//            //   List pics = gal.showGallery();
//            java.util.LinkedList<Image> images = gal.getPicsForUser(user);
//
//            request.setAttribute("images", images);
//
//            RequestDispatcher view = request.getRequestDispatcher("gallery.jsp");
//            view.forward(request, response);
//            //test
        //out.println("<article  style='height:25px;margin-left:47px;'><header> <h3> test2</h3></header></article>");
        //  out.println("<article  style='height:25px;margin-left:47px;'><header> <h3> test3</h3></header></article>");
//
//        } catch (Exception e2) {
//            System.out.println(e2);
//        }
        out.close();
    }

}
