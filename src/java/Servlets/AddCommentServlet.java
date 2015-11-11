/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

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
import javax.servlet.RequestDispatcher;

/**
 *
 * @author Ivan
 */
@WebServlet(name = "AddCommentServlet", urlPatterns = {"/AddCommentServlet"})
public class AddCommentServlet extends HttpServlet {
 
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
      
        response.setContentType("text/html");
       
        String user = request.getParameter("u");
        String comment = request.getParameter("comment");
        String idImg = request.getParameter("id");
        int id_img  = Integer.parseInt(idImg);

        try {
            Comment comObj = new Comment();
            comObj.addComment(comment, user, id_img);

           response.sendRedirect("index.jsp");
        } catch (Exception e2) {
            System.out.println(e2);
        }
    }

}
