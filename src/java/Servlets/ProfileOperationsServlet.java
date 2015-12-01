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
import Models.User;
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
public class ProfileOperationsServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String command = (String) request.getParameter("command");

        HttpSession session = request.getSession();
        String loggedUser = (String) session.getAttribute("user");
        Users users = new Users();
        if (command.equals("show")) {

            String htmlImg = users.getProfilePicForUserHtml(loggedUser);
            String htmlNumber = users.getNumberOfRequest(loggedUser);
            String html = htmlImg + "<br>" + htmlNumber;
            out.println(html);
        }
        if (command.equals("showRequests")) {
            java.util.LinkedList<User> usrsList = users.getUsersIdWhoSentReq(loggedUser);
            String htmlUsers = users.getHtmlUsers(usrsList, loggedUser);
            out.println(htmlUsers);

        }

        out.close();
    }

}