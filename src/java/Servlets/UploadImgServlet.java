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
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
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
        if (filePart.getSize() > 0) {
            inputStream = filePart.getInputStream();
            inputStream = filePart.getInputStream();
        }
        if (inputStream != null && filePart.getSize() <= size) {
            HttpSession session = request.getSession();
            String user = (String) session.getAttribute("user");
            if (nametag.isEmpty()) {
                nametag = "untagged";
            }
            Image image = new Image(0, nametag, user, inputStream);
            boolean success = false;
            success = image.addImage();
            if (success == true) {
                out.println("<p>Successfuly Uploaded</p>");

            } else {
                out.println("<p>Something went wrong</p>");
            }

        }
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        doPost(request, response);
    }

}
