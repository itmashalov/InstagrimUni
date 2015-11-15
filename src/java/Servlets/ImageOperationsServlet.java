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
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Ivan
 */
@WebServlet(name = "ImageOperationsServlet", urlPatterns = {"/ImageOperationsServlet"})
public class ImageOperationsServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        PrintWriter out = response.getWriter();
        String command = (String) request.getParameter("command");
        int imgID = Integer.parseInt(request.getParameter("imgID"));

        if (command.equals("delete")) {//comment.equals("NoCommentAddedToTheServlet")==false) {
            boolean deletedImage = false;

            Image img = new Image();
            deletedImage = img.deleteImage(imgID);

            if (deletedImage == true) {
                out.println("deleted!");
            } else {
                out.println("something went wrong!");
            }
        }
        if (command.equals("getCommentsCount")) {//comment.equals("NoCommentAddedToTheServlet")==false) {
            int count = 0;
            
            Image img = new Image();
            count = img.getCommentsCount(imgID);

            out.println(count);
        }

    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        doPost(request, response);
    }

}
