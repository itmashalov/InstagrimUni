package Main;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import DataBases.MySql;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import DataBases.MySql;

/**
 *
 * @author Admin
 */
public class RegisterServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String us = request.getParameter("usr");
        String pas = request.getParameter("pass");
        String rep = request.getParameter("re-pass");
        String name = request.getParameter("name");
        String em = request.getParameter("email");

        try {
            User user = new User(us, pas, em, name);
            
            if (user.isValid()) {
                user.registerUser();
                response.sendRedirect("login.jsp");
            } else {
                response.sendRedirect("user_exists.jsp");
            }

        } catch (Exception e2) {
            response.sendRedirect("error.jsp");
        }

        out.close();
    }

}
 
