
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Models.Comment;
import Models.Gallery;
import Models.Image;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Ivan
 */
@WebServlet(name = "AddCommentServlet", urlPatterns = {"/AddCommentServlet"})
public class AddCommentServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

//        response.setContentType("text/html");
//
//        String user = request.getParameter("u");
//        String comment = request.getParameter("comment");
//        String idImg = request.getParameter("id");
//        int id_img = Integer.parseInt(idImg);
        PrintWriter out = response.getWriter();
        String comment = (String)request.getParameter("comment");
        int imgID = Integer.parseInt(request.getParameter("imgID"));
        
        if (comment.isEmpty()==false){//comment.equals("NoCommentAddedToTheServlet")==false) {
            HttpSession session = request.getSession();
            String user = (String) session.getAttribute("user");
            Comment comObj = new Comment();
            comObj.addComment(comment, user, imgID);
        }
        Image p = new Image();
        List comments = p.getComments(imgID);
        List users = p.getUsers(imgID);
        for (int i = 0; i < comments.size(); i++) {
            out.println("<br>" + users.get(i) + ": " + comments.get(i));
        }

//        Date df = new Date();
//        out.println(df.getTime());
//        List test = new ArrayList();
//        int i = 10;
//        while (i > 0) {
//            i = i - 1;
//            test.add("test");
//        }
//        for (int j = 0; j <= test.size(); j++) {
//            out.println("<br> " + test.get(i));
//        }
//        out.println("<br>" + comment);
//        out.println("<br>" + imgID);
//        try {
//            Comment comObj = new Comment();
//            comObj.addComment(comment, user, id_img);
//
//            response.sendRedirect("/GalleryServlet");
//        } catch (Exception e2) {
//            System.out.println(e2);
//        }
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        doPost(request, response);
    }

}
