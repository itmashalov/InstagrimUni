package Servlets;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import Models.User;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Cookie;

/**
 *
 * @author Admin
 */
//
public class LoginServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String u = request.getParameter("u");
        String p = request.getParameter("p");

        try {
            User user = new User(u, p, "", "");
            boolean auth =false;
            auth=user.isAuthenticated();
            if (auth==true) {
                HttpSession session = request.getSession();
                session.setAttribute("user", u);

                session.setAttribute("is_logged", "True");
                response.sendRedirect("index.jsp");
            }
            else{
              response.sendRedirect("login_fail.jsp");
            }
 
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
