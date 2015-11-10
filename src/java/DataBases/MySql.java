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
    private String dataBase = "jdbc:mysql://localhost/" + dataBaseName;
    private String user = "ivan";
    private String password = "ivankriskitchen";
    private String uploadLimit = "SET GLOBAL max_allowed_packet=104857600;";  // 10 MB
    private String dir = "/htdocs/InstagrimUni/web/";

    public MySql() {

    }

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
    //IMAGES FUNCTIONS END*************************************************************************************************************************************

    public List showGallery(String usr) {
        List images = new ArrayList();
        try {
            //-----------------Getting Connection-----------------------------------------        
            Class.forName(driver);

            Connection con = DriverManager.getConnection(dataBase, this.user, password);
            //-----------------Getting Connection----------------------------------------- 
            PreparedStatement query = con.prepareStatement("select id,image,nametag from images where username=? ");

            query.setString(1, usr);
            ResultSet rs = query.executeQuery();

            while (rs.next()) {

                String nametag = rs.getString("nametag");
                String id = rs.getString("id");
                String name = usr + "_" + nametag + "_" + id;
                String newDir = "instapics/" + usr;

                String filePath = newDir + "/" + name + ".jpg";

                images.add(filePath);

            }

            con.close();

        } catch (Exception e2) {
            System.out.println(e2);
        }

        return (images);
    }

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

    public int getCommentsCount(int id) {
        int count=0;
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

    public java.util.LinkedList<Image> getPicsForUser(String usr) {
        java.util.LinkedList<Image> Pics = new java.util.LinkedList();
        try {
            //-----------------Getting Connection-----------------------------------------        
            Class.forName(driver);

            Connection con = DriverManager.getConnection(dataBase, this.user, password);
            //-----------------Getting Connection----------------------------------------- 
            PreparedStatement query = con.prepareStatement("select id,image,nametag from images where username=? ");

            query.setString(1, usr);
            ResultSet rs = query.executeQuery();

            while (rs.next()) {
                Image img = new Image();
                String nametag = rs.getString("nametag");
                String id = rs.getString("id");
                String name = usr + "_" + nametag + "_" + id;
                String newDir = "instapics/" + usr;

                String filePath = newDir + "/" + name + ".jpg";
                img.setPath(filePath);

                img.setId(Integer.parseInt(id));
                Pics.add(img);

            }

            con.close();

        } catch (Exception e2) {
            System.out.println(e2);
        }

        return Pics;
    }

    public void createImageGallery(String usr) {

        try {
            //-----------------Getting Connection-----------------------------------------        
            Class.forName(driver);

            Connection con = DriverManager.getConnection(dataBase, this.user, password);
            //-----------------Getting Connection----------------------------------------- 
            PreparedStatement query = con.prepareStatement("select id,image,nametag from images where username=? ");

            query.setString(1, usr);
            ResultSet rs = query.executeQuery();

            int BUFFER_SIZE = 4096;
            byte[] imgData = new byte[1000];

            while (rs.next()) {

                String nametag = rs.getString("nametag");
                String id = rs.getString("id");
                String name = usr + "_" + nametag + "_" + id;
                String newDir = "instapics/" + usr;

                String parentDir = new File(".").getCanonicalPath();
                File folder = new File(parentDir + dir + newDir);
                folder.mkdir();
                String path = folder.getPath();
                String fullPath = path + "/" + name + ".jpg";

                Blob blob = rs.getBlob("image");
                imgData = blob.getBytes(1, (int) blob.length());
                InputStream inputStream = blob.getBinaryStream();
                OutputStream outputStream = new FileOutputStream(fullPath);

                int bytesRead = -1;
                byte[] buffer = new byte[BUFFER_SIZE];
                while ((bytesRead = inputStream.read(buffer)) != -1) {
                    outputStream.write(buffer, 0, bytesRead);
                }
            }

            con.close();

        } catch (Exception e2) {
            System.out.println(e2);
        }
    }

    public void deleteImageGallery(String usr) {
        try {
            String newDir = "instapics\\" + usr;
            String parentDir = new File(".").getCanonicalPath();
            File folder = new File(parentDir + dir + newDir);

            FileUtils.deleteDirectory(new File(parentDir + dir + newDir));
        } catch (Exception e2) {
            System.out.println(e2);
        }
    }

//    public static boolean removeDirectory(File directory) {
//
//  // System.out.println("removeDirectory " + directory);
//        if (directory == null) {
//            return false;
//        }
//        if (!directory.exists()) {
//            return true;
//        }
//        if (!directory.isDirectory()) {
//            return false;
//        }
//
//        String[] list = directory.list();
//
//  // Some JVMs return null for File.list() when the
//        // directory is empty.
//        if (list != null) {
//            for (int i = 0; i < list.length; i++) {
//                File entry = new File(directory, list[i]);
//
//      //        System.out.println("\tremoving entry " + entry);
//                if (entry.isDirectory()) {
//                    if (!removeDirectory(entry)) {
//                        return false;
//                    }
//                } else {
//                    if (!entry.delete()) {
//                        return false;
//                    }
//                }
//            }
//        }
//
//        return directory.delete();
//    }
    //Gallery FUNCTIONS ***************************************************************************************************************************************
    //Gallery FUNCTIONS END*************************************************************************************************************************************
}
