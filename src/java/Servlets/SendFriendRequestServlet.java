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
import Models.Users;
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
public class SendFriendRequestServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String sender = (String) request.getParameter("sender");
        String receiver = (String) request.getParameter("receiver");
        
        Users users = new Users();
        users.sendFriendRequest(sender, receiver);
//        String imgID = request.getParameter("tag");
//
//        Gallery gal = new Gallery();
//        HttpSession session = request.getSession();
//        String loggedUser = (String) session.getAttribute("user");
//        java.util.LinkedList<Image> images = gal.getPicsForUser(user);
//
//        String htmlGal = gal.getHtmlForImages(images, loggedUser);
      out.println(sender+receiver);
//
      out.close();
    }

}
