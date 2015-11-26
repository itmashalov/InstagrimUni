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

        PrintWriter out = response.getWriter();
        String sender = (String) request.getParameter("sender");
        String receiver = (String) request.getParameter("receiver");

        Users users = new Users();
        boolean sent = users.sendFriendRequest(sender, receiver);
        String msg = "";
        if (sent == true) {
            msg = "<div style=\"color:green;\">The friend request has been sent successfully</div>";
        } else {
            msg = "<div style=\"color:red;\">The friend request has been sent already and you need to wait for your friend to confirm it.</div>";
        }
        out.println(msg);

        out.close();
    }

}
