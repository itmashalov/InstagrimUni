package Servlets;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import Models.User;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Admin
 */
//
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        PrintWriter out = response.getWriter();

        String u = request.getParameter("u");
        String p = request.getParameter("p");

        try {
            User user = new User(u, p, "", "");
            boolean auth = false;
            auth = user.isAuthenticated();
            if (auth == true) {
                HttpSession session = request.getSession();
                session.setAttribute("user", u);

                session.setAttribute("is_logged", "True");
                out.println("Success");
            } else {
                out.println("Wrong Username or Password");
            }
        } catch (Exception e2) {
            out.println("Something went wrong");
        }
        out.close();
        
    }

}

/**
 * Returns a short description of the servlet.
 *
 * @return a String containing servlet description
 */
