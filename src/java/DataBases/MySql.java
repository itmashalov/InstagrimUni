package DataBases;

import Models.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import static java.lang.System.out;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import static sun.misc.MessageUtils.out;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.sql.Blob;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.imageio.ImageIO;
import javax.servlet.ServletContext;
import org.apache.tomcat.util.http.fileupload.FileUtils;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItemFactory;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Ivan
 */
public class MySql {

    private String driver = "com.mysql.jdbc.Driver";
    private String dataBaseName = "instagram";
//Local DB:
    private String dataBase = "jdbc:mysql://localhost/" + dataBaseName;
    private String user = "ivan";
    private String password = "ivankriskitchen";
//Local DB in OpenShift: 
//    private String dataBase = "jdbc:mysql://127.3.255.130/" + dataBaseName;
//    private String user = "admint2B46ui";
//    private String password = "bVv5gL2JT7VT";
//Remote DB using portfordwardind  (portforwarding must be started!!!): 
//    private String dataBase = "jdbc:mysql://localhost/" + dataBaseName;
//    private String user = "admint2B46ui";
//    private String password = "bVv5gL2JT7VT";  
//    
    private String uploadLimit = "SET GLOBAL max_allowed_packet=104857600;";  // 10 MB

    public MySql() {

    }

    //CONIFGURATION FUNCTIONS**********************************************************************************************************************************
    public void configure() {
        createDatabase();
        createTables();
        setUploadLimit();

    }

    private void createDatabase() {
        try {
            //-----------------Getting Connection-----------------------------------------        
            Class.forName(driver);

            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/mysql", this.user, password);
           //Connection con = DriverManager.getConnection("jdbc:mysql://127.3.225.130/mysql", this.user, password);
            //-----------------Getting Connection----------------------------------------- 

            PreparedStatement createDataBase = con.prepareStatement("CREATE DATABASE IF NOT EXISTS " + dataBaseName);

            int crDb = 0;
            crDb = createDataBase.executeUpdate();
            if (crDb != 0) {
                System.out.println("Database created!");
            }

            con.close();

        } catch (Exception e2) {
            System.out.println(e2);
        }
    }

    private void createTables() {
        try {
            //-----------------Getting Connection-----------------------------------------        
            Class.forName(driver);

            Connection con = DriverManager.getConnection(dataBase, this.user, password);
            //-----------------Getting Connection----------------------------------------- 

            PreparedStatement createUsers = con.prepareStatement(
                    "CREATE TABLE IF NOT EXISTS users(id integer,username varchar(255),pass varchar(255),name varchar(255),email varchar(255))");

            PreparedStatement createImages = con.prepareStatement(
                    "CREATE TABLE IF NOT EXISTS images(id integer, username varchar(255),nametag varchar(255),type BOOL, image mediumblob) ");

            PreparedStatement createComments = con.prepareStatement(
                    "CREATE TABLE IF NOT EXISTS comments( id integer,comment varchar(255),img_id integer, username varchar(20)) ");

            createUsers.executeUpdate();
            createImages.executeUpdate();
            createComments.executeUpdate();

            con.close();

        } catch (Exception e2) {
            System.out.println(e2);
        }

    }

    private void setUploadLimit() {
        try {
            //-----------------Getting Connection-----------------------------------------        
            Class.forName(driver);
            Connection con = DriverManager.getConnection(dataBase, this.user, password);
            //-----------------Getting Connection----------------------------------------- 
            String querySetLimit = uploadLimit;  // 10 MB
            // Statement stSetLimit = conn.createStatement();
            PreparedStatement stSetLimit = con.prepareStatement(querySetLimit);
            stSetLimit.execute(querySetLimit);

            con.close();
        } catch (Exception e2) {
            System.out.println(e2);
        }
    }
    //CONIFGURATION FUNCTIONS END******************************************************************************************************************************

    //USER FUNCTIONS ******************************************************************************************************************************************
    public boolean isAuthenticated(String u, String p) {
        boolean auth = false;
        try {
            //-----------------Getting Connection-----------------------------------------        
            Class.forName(driver);

            Connection con = DriverManager.getConnection(dataBase, this.user, password);
            //-----------------Getting Connection----------------------------------------- 
            PreparedStatement query = con.prepareStatement("select count(*) from users where pass=? and username=?");

            query.setString(1, p);
            query.setString(2, u);

            ResultSet rs = query.executeQuery();
            rs.next();
            int rowCount = rs.getInt(1);

            if (rowCount > 0) {
                auth = true;
            }
            con.close();

        } catch (Exception e2) {
            System.out.println(e2);
        }

        return auth;
    }

    public boolean isExistingUser(String user) {
        boolean isExisting = true;
        try {
            //-----------------Getting Connection-----------------------------------------        
            Class.forName(driver);

            Connection con = DriverManager.getConnection(dataBase, this.user, password);
            //-----------------Getting Connection----------------------------------------- 
            PreparedStatement query = con.prepareStatement("select count(*) from users where username=? ");

            query.setString(1, user);
            ResultSet rs = query.executeQuery();

            rs.next();

            int rowCount = rs.getInt(1);
            if (rowCount == 0) {
                isExisting = false;
            }
            con.close();

        } catch (Exception e2) {
            System.out.println(e2);
        }

        return isExisting;
    }

    public void register(String user, String pass, String name, String email) {
        try {
            //-----------------Getting Connection-----------------------------------------        
            Class.forName(driver);

            Connection con = DriverManager.getConnection(dataBase, this.user, password);
            //-----------------Getting Connection----------------------------------------- 
            int id = getMaxUserID();

            PreparedStatement insertUser = con.prepareStatement(
                    "insert into users values(?,?,?,?,?)");
            id = id + 1;
            insertUser.setInt(1, id);
            insertUser.setString(2, user);
            insertUser.setString(3, pass);
            insertUser.setString(4, name);
            insertUser.setString(5, email);
            int i = insertUser.executeUpdate();
            con.close();

        } catch (Exception e2) {
            System.out.println(e2);
        }
    }

    private int getMaxUserID() {
        int maxID = -1;
        try {
            //-----------------Getting Connection-----------------------------------------        
            Class.forName(driver);

            Connection con = DriverManager.getConnection(dataBase, this.user, password);
            //-----------------Getting Connection----------------------------------------- 
            Statement s2 = con.createStatement();
            s2.execute("SELECT MAX(id) FROM users");
            ResultSet rs2 = s2.getResultSet();
            if (rs2.next()) {
                maxID = rs2.getInt(1);
            }

            con.close();

        } catch (Exception e2) {
            System.out.println(e2);
        }
        return maxID;
    }
    //USER FUNCTIONS END***************************************************************************************************************************************

    //IMAGES FUNCTIONS*****************************************************************************************************************************************
    private int getMaxImgID() {
        int maxID = -1;
        try {
            //-----------------Getting Connection-----------------------------------------        
            Class.forName(driver);

            Connection con = DriverManager.getConnection(dataBase, this.user, password);
            //-----------------Getting Connection----------------------------------------- 
            Statement s2 = con.createStatement();
            s2.execute("SELECT MAX(id) FROM images");
            ResultSet rs2 = s2.getResultSet();
            if (rs2.next()) {
                maxID = rs2.getInt(1);
            }

            con.close();

        } catch (Exception e2) {
            System.out.println(e2);
        }
        return maxID;
    }

    public boolean addImage(int type, String nametag, String usr, InputStream img) {
        boolean success = false;
        try {
            //-----------------Getting Connection-----------------------------------------        
            Class.forName(driver);

            Connection con = DriverManager.getConnection(dataBase, this.user, password);
            //-----------------Getting Connection----------------------------------------- 
            int id = getMaxImgID();

            PreparedStatement insertImage = con.prepareStatement("insert into images values(?,?,?,?,?)");

            id = id + 1;
            insertImage.setInt(1, id);
            insertImage.setString(2, usr);
            insertImage.setString(3, nametag);
            insertImage.setInt(4, type);
            insertImage.setBlob(5, img);

            int i = insertImage.executeUpdate();
            con.close();

            int newID = getMaxImgID();
            if (newID > id - 1) {
                success = true;
            }
        } catch (Exception e2) {
            System.out.println(e2);
        }
        return success;
    }

    public boolean deleteImage(int id) {
        boolean success = false;
        try {
            //-----------------Getting Connection-----------------------------------------        
            Class.forName(driver);

            Connection con = DriverManager.getConnection(dataBase, this.user, password);
            //-----------------Getting Connection----------------------------------------- 

            PreparedStatement deleteImage = con.prepareStatement("DELETE FROM images WHERE id=?");

            deleteImage.setInt(1, id);

            int i = 0;
            i = deleteImage.executeUpdate();
            con.close();

            int newID = getMaxImgID();
            if (i != 0) {
                success = true;
            }
        } catch (Exception e2) {
            System.out.println(e2);
        }
        return success;
    }

    public boolean deleteComments(int id) {
        boolean success = false;
        try {
            //-----------------Getting Connection-----------------------------------------        
            Class.forName(driver);

            Connection con = DriverManager.getConnection(dataBase, this.user, password);
            //-----------------Getting Connection----------------------------------------- 

            PreparedStatement deleteComments = con.prepareStatement("DELETE FROM comments WHERE img_id=?");

            deleteComments.setInt(1, id);

            int i = 0;
            i = deleteComments.executeUpdate();
            con.close();

            int newID = getMaxImgID();
            if (i != 0) {
                success = true;
            }
        } catch (Exception e2) {
            System.out.println(e2);
        }
        return success;
    }

    public java.util.LinkedList<Image> getPicsForUser(String usr) {
        java.util.LinkedList<Image> Pics = new java.util.LinkedList();
        try {
            //-----------------Getting Connection-----------------------------------------        
            Class.forName(driver);

            Connection con = DriverManager.getConnection(dataBase, this.user, password);
            //-----------------Getting Connection----------------------------------------- 
            PreparedStatement query = con.prepareStatement("select id,image,nametag from images where username=?  ORDER BY `id`  DESC");

            query.setString(1, usr);
            ResultSet rs = query.executeQuery();

            while (rs.next()) {
                Image img = new Image();
                String nametag = rs.getString("nametag");
                String id = rs.getString("id");
                Blob blob = rs.getBlob("image");

                img.setTag(nametag);
                img.setImgBlob(blob);

                img.setId(Integer.parseInt(id));
                Pics.add(img);

            }

            con.close();

        } catch (Exception e2) {
            System.out.println(e2);
        }

        return Pics;
    }
        public  Image getLatestImgForUser(String usr) {
        Image img = new Image();
        try {
            //-----------------Getting Connection-----------------------------------------        
            Class.forName(driver);

            Connection con = DriverManager.getConnection(dataBase, this.user, password);
            //-----------------Getting Connection----------------------------------------- 
            PreparedStatement query = con.prepareStatement("select id,image,nametag from images where username=? ORDER BY `id` DESC LIMIT 1");

            query.setString(1, usr);
            ResultSet rs = query.executeQuery();

            if (rs.next()) {
                 
                String nametag = rs.getString("nametag");
                String id = rs.getString("id");
                Blob blob = rs.getBlob("image");

                img.setTag(nametag);
                img.setImgBlob(blob);

                img.setId(Integer.parseInt(id));
             

            }

            con.close();

        } catch (Exception e2) {
            System.out.println(e2);
        }

        return img;
    }

    //Image functions end FUNCTIONS ***************************************************************************************************************************
    //Comments FUNCTIONS ***************************************************************************************************************************************
    public List getCommentsForID(int id) {
        List comments = new ArrayList();
        try {
            //-----------------Getting Connection-----------------------------------------        
            Class.forName(driver);

            Connection con = DriverManager.getConnection(dataBase, this.user, password);
            //-----------------Getting Connection----------------------------------------- 
            PreparedStatement query = con.prepareStatement("SELECT * FROM comments where  img_id=? ");

            query.setInt(1, id);
            ResultSet rs = query.executeQuery();

            while (rs.next()) {
                String comment = rs.getString("comment");
                comments.add(comment);

            }

            con.close();

        } catch (Exception e2) {
            System.out.println(e2);
        }

        return (comments);
    }

    public List getUserForImageID(int id) {
        List usernames = new ArrayList();
        try {
            //-----------------Getting Connection-----------------------------------------        
            Class.forName(driver);

            Connection con = DriverManager.getConnection(dataBase, this.user, password);
            //-----------------Getting Connection----------------------------------------- 
            PreparedStatement query = con.prepareStatement("SELECT * FROM comments where  img_id=? ");

            query.setInt(1, id);
            ResultSet rs = query.executeQuery();

            while (rs.next()) {
                String comment = rs.getString("username");
                usernames.add(comment);

            }

            con.close();

        } catch (Exception e2) {
            System.out.println(e2);
        }

        return (usernames);
    }

    public int getCommentsCount(int id) {
        int count = 0;
        try {
            //-----------------Getting Connection-----------------------------------------        
            Class.forName(driver);

            Connection con = DriverManager.getConnection(dataBase, this.user, password);
            //-----------------Getting Connection----------------------------------------- 
            PreparedStatement query = con.prepareStatement("SELECT count(*) FROM comments where img_id=? ");

            query.setInt(1, id);
            ResultSet rs = query.executeQuery();
            rs.next();
            count = rs.getInt(1);

            con.close();

        } catch (Exception e2) {
            System.out.println(e2);
        }

        return count;
    }

    private int getMaxCommentID() {
        int maxID = -1;
        try {
            //-----------------Getting Connection-----------------------------------------        
            Class.forName(driver);

            Connection con = DriverManager.getConnection(dataBase, this.user, password);
            //-----------------Getting Connection----------------------------------------- 
            Statement s2 = con.createStatement();
            s2.execute("SELECT MAX(id) FROM comments");
            ResultSet rs2 = s2.getResultSet();
            if (rs2.next()) {
                maxID = rs2.getInt(1);
            }

            con.close();

        } catch (Exception e2) {
            System.out.println(e2);
        }
        return maxID;
    }

    public void addComment(String comment, String user, int img_id) {
        try {
            //-----------------Getting Connection-----------------------------------------        
            Class.forName(driver);

            Connection con = DriverManager.getConnection(dataBase, this.user, password);
            //-----------------Getting Connection----------------------------------------- 
            int id = getMaxCommentID();

            PreparedStatement insertComment = con.prepareStatement("insert into comments values(?,?,?,?)");

            id = id + 1;
            insertComment.setInt(1, id);
            insertComment.setString(2, comment);
            insertComment.setInt(3, img_id);
            insertComment.setString(4, user);

            int i = insertComment.executeUpdate();
            con.close();

        } catch (Exception e2) {
            System.out.println(e2);
        }
    }

    //Comments FUNCTIONS END*************************************************************************************************************************************
}
