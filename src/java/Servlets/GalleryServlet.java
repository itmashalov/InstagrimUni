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

/**
 *
 * @author Admin
 */
//
public class GalleryServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String usr = request.getParameter("user");
        try {
            Gallery gal = new Gallery(usr);
         //   List pics = gal.showGallery();
            java.util.LinkedList<Image> images = gal.getPicsForUser(usr);
     
            request.setAttribute("images", images);

            RequestDispatcher view = request.getRequestDispatcher("gallery.jsp");
            view.forward(request, response);

        } catch (Exception e2) {
            System.out.println(e2);
        }

        out.close();
    }

}

/**
 * Returns a short description of the servlet.
 *
 * @return a String containing servlet description
 */




