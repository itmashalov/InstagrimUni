package Servlets;

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
import Models.User;
import java.util.regex.Pattern;

/**
 *
 * @author Admin
 */
public class RegisterServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
        Pattern rfc2822 = Pattern.compile(
                "^[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?$"
        );

        PrintWriter out = response.getWriter();

        String us = (String) request.getParameter("usr");
        String pas = request.getParameter("pass");
        String repas = request.getParameter("repass");
        String name = request.getParameter("name");
        String em = request.getParameter("email");

        try {
            User user = new User(us, pas, em, name);
            if (us.equals("")) {
                out.println("Please Enter Username");
            } else if (!user.isValid()) {
                out.println("User already exists!");
            } else if (pas.equals("")) {
                out.println("Please Enter Password");
            } else if (name.equals("")) {
                out.println("Please Enter Name");
            } else if (em.equals("")) {
                out.println("Please Enter Email");
            } else if (pas.length() < 6) {
                out.println("The password must be 6 or more symbols");
            } else if (!pas.equals(repas)) {
                out.println("The passwords dont match");
            } else if (!rfc2822.matcher(em).matches()) {
                out.println("Please Enter Valid Email");
            } else if (user.isExistingEmail()) {
                out.println("The email already exists!");
            } else {
                user.registerUser();
                out.println("Success");
            }

        } catch (Exception e2) {
            out.println("Something went wrong!");
        }

        out.close();
    }

}
