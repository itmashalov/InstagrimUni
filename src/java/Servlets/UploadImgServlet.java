package Servlets;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Models.Comment;
import Models.Gallery;
import Models.Image;
import static com.sun.corba.se.spi.presentation.rmi.StubAdapter.request;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpSession;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.Part;

/**
 *
 * @author Ivan
 */
@WebServlet(name = "UploadImgServlet", urlPatterns = {"/UploadImgServlet"})
@MultipartConfig
public class UploadImgServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        PrintWriter out = response.getWriter();
        String nametag = request.getParameter("nametag");

        String checkBox = request.getParameter("type");
        String profile = request.getParameter("profile");
        Part filePart = request.getPart("photo");
        int type = 0;
        if (checkBox != null) {
            type = 1;
        }

        InputStream inputStream = null; // input stream of the upload file
        int size = 1024 * 1024 * 10;//1MB
        if (filePart.getSize()>1000) {
            inputStream = filePart.getInputStream();

            if (inputStream != null && filePart.getSize() <= size) {
                HttpSession session = request.getSession();
                String user = (String) session.getAttribute("user");
                if (nametag.isEmpty()) {
                    nametag = "untagged";
                }
                Image image = new Image(type, nametag, user, inputStream);
                boolean success = false;
                success = image.addImage();
                if (success == true) {
                    out.println(AddTheNewImage(user));


                } else {
                    out.println("Something went wrong");
                }

            }
        } else {
            
        }

    }

    public String AddTheNewImage(String user) {

        Gallery gal = new Gallery(user);
        String newArticle;
        Image p = gal.getLatestImgForUser(user);

        byte[] imgData = new byte[10];
        try {
            imgData = p.getImgBlob().getBytes(1, (int) p.getImgBlob().length());
        } catch (SQLException ex) {
            Logger.getLogger(GalleryServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

        String b64 = javax.xml.bind.DatatypeConverter.printBase64Binary(imgData);
        newArticle = "<article onmouseover=\"javascrtipt:ajaxGetCommentsCount(" + p.getId() + ");\""
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
                + "   <input type=\"hidden\"   name=\"u\"  value=\"" + user + "\"> "
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

        return newArticle;
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        doPost(request, response);
    }

}
