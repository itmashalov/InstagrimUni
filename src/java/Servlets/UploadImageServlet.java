package Servlets;

import Models.Image;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

@WebServlet("/uploadServlet")
@MultipartConfig(maxFileSize = 1617721500)
public class UploadImageServlet extends HttpServlet {

    private Object session;

    //private  int BUFFER_SIZE = 4096;
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // gets values of text fields
        String nametag = request.getParameter("nametag");
        String checkBox = request.getParameter("type");
        int type = 0;
        if (checkBox != null) {
            type = 1;
        }

        InputStream inputStream = null; // input stream of the upload file
        int size = 1024 * 1024 * 10;//1MB

        // obtains the upload file part in this multipart request
        Part filePart = request.getPart("photo");

        if (filePart.getSize()
                > 0) {
            inputStream = filePart.getInputStream();
        }

        Connection conn = null; // connection to the database
        String message = null; // message will be sent back to client

        try {
            if (inputStream != null && filePart.getSize() <= size) {
                HttpSession session = request.getSession();
                String user = (String) session.getAttribute("user");
                if(nametag.isEmpty()){
                    nametag="untagged";
                }
                Image image = new Image(type, nametag, user, inputStream);
                boolean success = false;
                success = image.addImage();
                if (success == true) {
                    response.sendRedirect("index.jsp");
                    session.setAttribute("uploaded", "True");
                } else {
                    response.sendRedirect("register.jsp");
                }
            } else {
                if (filePart.getSize() > size) {
                    HttpSession session = request.getSession();
                    session.setAttribute("uploaded", "TooBig");
                    response.sendRedirect("index.jsp");
                }
                if (inputStream == null) {
                    HttpSession session = request.getSession();
                    session.setAttribute("uploaded", "False");
                    response.sendRedirect("index.jsp");
                }
            }

//            try {
//                Class.forName("com.mysql.jdbc.Driver");
//            } catch (ClassNotFoundException ex) {
//                Logger.getLogger(UploadImageServlet.class.getName()).log(Level.SEVERE, null, ex);
//            }
//
//            conn = DriverManager.getConnection(
//                    "jdbc:mysql://localhost/instagram", "ivan", "ivankriskitchen");
//            // constructs SQL statement
//            String querySetLimit = "SET GLOBAL max_allowed_packet=104857600;";  // 10 MB
//            // Statement stSetLimit = conn.createStatement();
//            PreparedStatement stSetLimit = conn.prepareStatement(querySetLimit);
//            stSetLimit.execute(querySetLimit);
//
//            PreparedStatement sel2 = conn.prepareStatement(
//                    "select max(id) from images");
//            ResultSet rs2 = sel2.executeQuery();
//
//            rs2.next();
//
//            int rowCount2 = rs2.getInt(1);
//            int id = rowCount2 + 1;
//            HttpSession session = request.getSession();
//            // String user= session.getAttribute("user").toString();
//            String sql2 = "INSERT INTO images (id, username,nametag,type,image) values (?, ?, ?, ?, ?)";
//            PreparedStatement statement = conn.prepareStatement(sql2);
//            statement.setInt(1, id);
//            statement.setObject(2, session.getAttribute("user"));
//            statement.setString(3, nametag);
//            statement.setInt(4, type);
//
//            if (inputStream != null) {
//                // fetches input stream of the upload file for the blob column
//                statement.setBlob(5, inputStream);
//            }
//
//            // sends the statement to the database server
//            int row = statement.executeUpdate();
//
//            RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
//            rd.include(request, response);
//            if (row > 0) {
//
//                // message = "File uploaded and saved into database";
//            }
        } catch (Exception ex) {

            message = "ERROR: " + ex.getMessage();
            ex.printStackTrace();
        }
//        } finally {
//            if (conn != null) {
//                // closes the database connection
//                try {
//                    conn.close();
//
//                } catch (SQLException ex) {
//                    ex.printStackTrace();
//                }
//            }
//            // sets the message in request scope
//            request.setAttribute("Message", message);
//
//            // forwards to the message page
//            //getServletContext().getRequestDispatcher("/Message.jsp").forward(request, response);
//        }
    }
}
