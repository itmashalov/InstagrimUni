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
import Models.Message;
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

        PrintWriter out = response.getWriter();
        String command = (String) request.getParameter("command");
        String friend = (String) request.getParameter("friend");
        String msgToUsr = (String) request.getParameter("msg");

        HttpSession session = request.getSession();
        String loggedUser = (String) session.getAttribute("user");
        Users users = new Users();
        if (command.equals("show")) {

            String htmlImg = users.getProfilePicForUserHtml(loggedUser);
            String htmlNumber = users.getNumberOfRequest(loggedUser);
            String friendsCount = users.getFriendsCount(loggedUser);
            String html = htmlImg + "<br>" + htmlNumber + "<br>" + friendsCount;
            out.println(html);
        }
        if (command.equals("showRequests")) {
            java.util.LinkedList<User> usrsList = users.getUsersIdWhoSentReq(loggedUser);
            String htmlUsers = users.getHtmlUsers(usrsList, loggedUser);
            out.println(htmlUsers);
        }
        if (command.equals("confirmRequest")) {
            String status = users.getFriendsStatus(loggedUser, friend);
            String msg = "Error";
            if (status.equals("sent")) {
                boolean isAdded = users.confirmFriendRequest(loggedUser, friend);

                if (isAdded == true) {
                    msg = "<div style=\"color:green;\">The friend has beed added successfully.</div>";
                } else {
                    msg = "<div style=\"color:red;\">Something went wrong</div>";
                }
            } else if (status.equals("confirmed")) {
                msg = "<div style=\"color:blue;\">You are already friends</div>";
            }
            out.println(msg);
        }
        if (command.equals("declineRequest")) {

            boolean isDeclined = users.declineFriendRequest(loggedUser, friend);
            if (isDeclined == true) {
                java.util.LinkedList<User> usrsList = users.getUsersIdWhoSentReq(loggedUser);
                String htmlUsers = users.getHtmlUsers(usrsList, loggedUser);
                out.println(htmlUsers);
            } else {
                out.println("Error");
            }

        }
        if (command.equals("removeFriend")) {

            boolean isRemoved = users.removeFriend(loggedUser, friend);
            if (isRemoved == true) {
                java.util.LinkedList<User> usrsList = users.getFriends(loggedUser);
                String htmlUsers = users.getHtmlUsers(usrsList, loggedUser);
                out.println(htmlUsers);
            } else {
                out.println("Error");
            }

        }
        if (command.equals("showConversation")) {

             if (!msgToUsr.equals("")) {
                Message message = new Message(loggedUser,friend,msgToUsr);
                message.recordMessage();
            }
            java.util.LinkedList<Message> conversation = users.getConversation(loggedUser, friend);
            String htm = users.getHtmlMsges(conversation, loggedUser,friend);
            out.println(htm);
           

//            boolean isRemoved = users.removeFriend(loggedUser, friend);
//            if (isRemoved == true) {
//                java.util.LinkedList<User> usrsList = users.getFriends(loggedUser);
//                String htmlUsers = users.getHtmlUsers(usrsList, loggedUser);
//                out.println(htmlUsers);
//            } else {
//                out.println("Error");
//            }
        }
        if (command.equals("showFriends")) {
            java.util.LinkedList<User> usrsList = users.getFriends(loggedUser);
            String htmlUsers = users.getHtmlUsers(usrsList, loggedUser);
            out.println(htmlUsers);
        }

        out.close();
    }

}
