package DataBases;

import Models.Image;
import Models.Message;
import Models.User;
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
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
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
    protected void configure() {
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
                    "CREATE TABLE IF NOT EXISTS images(id integer, username varchar(255),nametag varchar(255),profile BOOL,type BOOL, image mediumblob) ");

            PreparedStatement createComments = con.prepareStatement(
                    "CREATE TABLE IF NOT EXISTS comments( id integer,comment varchar(255),img_id integer, username varchar(20)) ");

            PreparedStatement createFriends = con.prepareStatement(
                    "CREATE TABLE IF NOT EXISTS friends( id integer,username varchar(255),friend varchar(255),status varchar(255), date DATE) ");

            PreparedStatement createMsges = con.prepareStatement(
                    "CREATE TABLE IF NOT EXISTS messages( id integer,sender varchar(255),receiver varchar(255),message varchar(255), date DATETIME) ");

            createUsers.executeUpdate();
            createImages.executeUpdate();
            createComments.executeUpdate();
            createFriends.executeUpdate();
            createMsges.executeUpdate();

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
    protected boolean isAuthenticated(String u, String p) {
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

    protected boolean isExistingUser(String user) {
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

    protected boolean isExistingEmail(String email) {
        boolean isExisting = true;
        try {
            //-----------------Getting Connection-----------------------------------------        
            Class.forName(driver);

            Connection con = DriverManager.getConnection(dataBase, this.user, password);
            //-----------------Getting Connection----------------------------------------- 
            PreparedStatement query = con.prepareStatement("select count(*) from users where email=? ");

            query.setString(1, email);
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

    protected void register(String user, String pass, String name, String email) {
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

    protected java.util.LinkedList<User> getUsersByUserName(String usr) {
        java.util.LinkedList<User> users = new java.util.LinkedList();
        try {
            //-----------------Getting Connection-----------------------------------------        
            Class.forName(driver);

            Connection con = DriverManager.getConnection(dataBase, this.user, password);
            //-----------------Getting Connection----------------------------------------- 
            PreparedStatement query = con.prepareStatement("select id,username,name from users where username like ?  ORDER BY `id`  DESC");
            usr = "%" + usr + "%";
            query.setString(1, usr);
            ResultSet rs = query.executeQuery();

            while (rs.next()) {
                User user = new User("", "", "", "");

                int id = rs.getInt("id");
                String username = rs.getString("username");
                String name = rs.getString("name");

                user.setId(id);
                user.setUserName(username);
                user.setName(name);
                user.setProfilePic(getProfilePic(username));

                users.add(user);

            }

            con.close();

        } catch (Exception e2) {
            System.out.println(e2);
        }

        return users;
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

    protected boolean isProfilePicSet(String usr) {
        boolean isSet = false;
        try {
            //-----------------Getting Connection-----------------------------------------        
            Class.forName(driver);

            Connection con = DriverManager.getConnection(dataBase, this.user, password);
            //-----------------Getting Connection----------------------------------------- 
            int id = getMaxImgID();

            PreparedStatement isProfilePicSet = con.prepareStatement("SELECT * From images WHERE profile=? and username=?");

            isProfilePicSet.setInt(1, 1);
            isProfilePicSet.setString(2, usr);
            ResultSet rs = isProfilePicSet.executeQuery();

            if (rs.next()) {
                isSet = true;
            }

        } catch (Exception e2) {
            System.out.println(e2);
        }
        return isSet;
    }

    protected void unsetProfilePicForUser(String user) {
        try {
            //-----------------Getting Connection-----------------------------------------        
            Class.forName(driver);

            Connection con = DriverManager.getConnection(dataBase, this.user, password);
            //-----------------Getting Connection----------------------------------------- 

            PreparedStatement unsetProfilePic = con.prepareStatement("update images set profile=? where username=?");
            unsetProfilePic.setInt(1, 0);
            unsetProfilePic.setString(2, user);
            int i = unsetProfilePic.executeUpdate();
            con.close();

        } catch (Exception e2) {
            System.out.println(e2);
        }
    }

    protected boolean addImage(int type, int profile, String nametag, String usr, InputStream img) {
        boolean success = false;
        try {
            //-----------------Getting Connection-----------------------------------------        
            Class.forName(driver);

            Connection con = DriverManager.getConnection(dataBase, this.user, password);
            //-----------------Getting Connection----------------------------------------- 
            int id = getMaxImgID();

            PreparedStatement insertImage = con.prepareStatement("insert into images values(?,?,?,?,?,?)");

            id = id + 1;
            insertImage.setInt(1, id);
            insertImage.setString(2, usr);
            insertImage.setString(3, nametag);
            insertImage.setInt(4, profile);
            insertImage.setInt(5, type);
            insertImage.setBlob(6, img);
            if (profile == 1) {
                unsetProfilePicForUser(usr);
            }

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

    protected boolean deleteImage(int id) {
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

    protected boolean deleteComments(int id) {
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

    protected boolean isPublicPic(int id) {
        boolean isPublicPic = false;
        try {
            //-----------------Getting Connection-----------------------------------------        
            Class.forName(driver);

            Connection con = DriverManager.getConnection(dataBase, this.user, password);
            //-----------------Getting Connection----------------------------------------- 
            PreparedStatement query = con.prepareStatement("select * from images where  type=?  and id=? ORDER BY `id`  DESC");

            query.setInt(1, 1);
            query.setInt(2, id);
            ResultSet rs = query.executeQuery();
            if (rs.next()) {
                isPublicPic = true;
            }

            con.close();

        } catch (Exception e2) {
            System.out.println(e2);
        }

        return isPublicPic;
    }

    protected java.util.LinkedList<Image> getPicsForUser(String usr) {
        java.util.LinkedList<Image> Pics = new java.util.LinkedList();
        try {
            //-----------------Getting Connection-----------------------------------------        
            Class.forName(driver);

            Connection con = DriverManager.getConnection(dataBase, this.user, password);
            //-----------------Getting Connection----------------------------------------- 
            PreparedStatement query = con.prepareStatement("select id,image,nametag,username from images where username=?  ORDER BY `id`  DESC");

            query.setString(1, usr);
            ResultSet rs = query.executeQuery();

            while (rs.next()) {
                Image img = new Image();
                String nametag = rs.getString("nametag");
                String id = rs.getString("id");
                String user = rs.getString("username");
                Blob blob = rs.getBlob("image");

                img.setTag(nametag);
                img.setImgBlob(blob);
                img.setOwner(user);

                img.setId(Integer.parseInt(id));
                Pics.add(img);

            }

            con.close();

        } catch (Exception e2) {
            System.out.println(e2);
        }

        return Pics;
    }

    protected Image getProfilePic(String usr) {
        Image img = new Image();
        try {
            //-----------------Getting Connection-----------------------------------------        
            Class.forName(driver);

            Connection con = DriverManager.getConnection(dataBase, this.user, password);
            //-----------------Getting Connection----------------------------------------- 
            PreparedStatement query = con.prepareStatement("select id,image,nametag,username from images where username=?  and profile=? ORDER BY `id`  DESC");

            query.setString(1, usr);
            query.setInt(2, 1);
            ResultSet rs = query.executeQuery();

            if (rs.next()) {

                String nametag = rs.getString("nametag");
                String id = rs.getString("id");
                String user = rs.getString("username");
                Blob blob = rs.getBlob("image");

                img.setTag(nametag);
                img.setImgBlob(blob);
                img.setOwner(user);

                img.setId(Integer.parseInt(id));

            }

            con.close();

        } catch (Exception e2) {
            System.out.println(e2);
        }

        return img;
    }

    protected java.util.LinkedList<Image> getPicsForTag(String tag, String loggedUser) {
        java.util.LinkedList<Image> Pics = new java.util.LinkedList();
        try {
            //-----------------Getting Connection-----------------------------------------        
            Class.forName(driver);

            Connection con = DriverManager.getConnection(dataBase, this.user, password);
            //-----------------Getting Connection----------------------------------------- 
            PreparedStatement query = con.prepareStatement("select id,image,nametag,username from images where (type=? or username=?) and nametag like ?  ORDER BY `id`  DESC");
            tag = "%" + tag + "%";
            query.setInt(1, 1);
            query.setString(2, loggedUser);
            query.setString(3, tag);
            ResultSet rs = query.executeQuery();

            while (rs.next()) {
                Image img = new Image();
                String nametag = rs.getString("nametag");
                String id = rs.getString("id");
                String user = rs.getString("username");
                Blob blob = rs.getBlob("image");

                img.setOwner(user);
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

    protected Image getLatestImgForUser(String usr) {
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
    protected List getCommentsForID(int id) {
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

    protected List getUserForImageID(int id) {
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

    protected int getCommentsCount(int id) {
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

    protected void addComment(String comment, String user, int img_id) {
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
    //FRIENDS FUNCTIONS*****************************************************************************************************************************************
    private int getMaxFriendsID() {
        int maxID = -1;
        try {
            //-----------------Getting Connection-----------------------------------------        
            Class.forName(driver);

            Connection con = DriverManager.getConnection(dataBase, this.user, password);
            //-----------------Getting Connection----------------------------------------- 
            Statement s2 = con.createStatement();
            s2.execute("SELECT MAX(id) FROM friends");
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

    protected boolean sendFriendRequest(String sender, String receiver) {
        boolean success = false;
        try {
            //-----------------Getting Connection-----------------------------------------        
            Class.forName(driver);

            Connection con = DriverManager.getConnection(dataBase, this.user, password);
            //-----------------Getting Connection----------------------------------------- 
            //check if request exist already;

            PreparedStatement query = con.prepareStatement("SELECT * FROM friends WHERE username =? and friend=?");

            query.setString(1, receiver);
            query.setString(2, sender);
            ResultSet rs = query.executeQuery();

            if (rs.next()) {
                success = false;
            } else {
                success = true;

                int id = getMaxFriendsID();

                PreparedStatement insertUser = con.prepareStatement(
                        "insert into friends values(?,?,?,?,?)");
                Date date = new Date();

                java.sql.Date sqlDate = new java.sql.Date(date.getTime());

                id = id + 1;
                insertUser.setInt(1, id);
                insertUser.setString(2, receiver);
                insertUser.setString(3, sender);
                insertUser.setString(4, "sent");
                insertUser.setDate(5, sqlDate);
                int i = insertUser.executeUpdate();
            }
            con.close();

        } catch (Exception e2) {
            System.out.println(e2);
        }
        return success;
    }

    protected int getNumberOfRequests(String username) {
        int count = 0;
        try {
            //-----------------Getting Connection-----------------------------------------        
            Class.forName(driver);

            Connection con = DriverManager.getConnection(dataBase, this.user, password);
            //-----------------Getting Connection----------------------------------------- 
            PreparedStatement query = con.prepareStatement("SELECT count(*) FROM friends where username=? and status=? ");
            String status = "sent";
            query.setString(1, username);
            query.setString(2, status);
            ResultSet rs = query.executeQuery();
            rs.next();
            count = rs.getInt(1);

            con.close();

        } catch (Exception e2) {
            System.out.println(e2);
        }

        return count;
    }

    protected int getNumberOfFriends(String username) {
        int count = 0;
        try {
            //-----------------Getting Connection-----------------------------------------        
            Class.forName(driver);

            Connection con = DriverManager.getConnection(dataBase, this.user, password);
            //-----------------Getting Connection----------------------------------------- 
            PreparedStatement query = con.prepareStatement("SELECT count(*) FROM friends where username=? and status=? ");
            String status = "confirmed";
            query.setString(1, username);
            query.setString(2, status);
            ResultSet rs = query.executeQuery();
            rs.next();
            count = rs.getInt(1);

            con.close();

        } catch (Exception e2) {
            System.out.println(e2);
        }

        return count;
    }

    protected java.util.LinkedList<User> getUsersIdWhoSentReq(String usr) {
        java.util.LinkedList<User> users = new java.util.LinkedList();
        try {
            //-----------------Getting Connection-----------------------------------------        
            Class.forName(driver);

            Connection con = DriverManager.getConnection(dataBase, this.user, password);
            //-----------------Getting Connection----------------------------------------- 
            PreparedStatement query = con.prepareStatement("SELECT u.id,u.username,u.name FROM users AS u INNER JOIN friends as f ON u.username = f.friend WHERE f.status =? AND f.username=?");

            String status = "sent";
            query.setString(1, status);
            query.setString(2, usr);
            ResultSet rs = query.executeQuery();

            while (rs.next()) {
                User user = new User("", "", "", "");

                int id = rs.getInt("id");
                String username = rs.getString("username");
                String name = rs.getString("name");

                user.setId(id);
                user.setUserName(username);
                user.setName(name);
                user.setProfilePic(getProfilePic(username));

                users.add(user);

            }

            con.close();

        } catch (Exception e2) {
            System.out.println(e2);
        }

        return users;
    }

    protected java.util.LinkedList<User> getFriends(String usr) {
        java.util.LinkedList<User> users = new java.util.LinkedList();
        try {
            //-----------------Getting Connection-----------------------------------------        
            Class.forName(driver);

            Connection con = DriverManager.getConnection(dataBase, this.user, password);
            //-----------------Getting Connection----------------------------------------- 
            PreparedStatement query = con.prepareStatement("SELECT u.id,u.username,u.name FROM users AS u INNER JOIN friends as f ON u.username = f.friend WHERE f.status =? AND f.username=?");

            String status = "confirmed";
            query.setString(1, status);
            query.setString(2, usr);
            ResultSet rs = query.executeQuery();

            while (rs.next()) {
                User user = new User("", "", "", "");

                int id = rs.getInt("id");
                String username = rs.getString("username");
                String name = rs.getString("name");

                user.setId(id);
                user.setUserName(username);
                user.setName(name);
                user.setProfilePic(getProfilePic(username));

                users.add(user);

            }

            con.close();

        } catch (Exception e2) {
            System.out.println(e2);
        }

        return users;
    }

    protected String getFriendsStatus(String user, String friend) {
        String status = "";
        try {
            //-----------------Getting Connection-----------------------------------------        
            Class.forName(driver);

            Connection con = DriverManager.getConnection(dataBase, this.user, password);
            //-----------------Getting Connection----------------------------------------- 
            PreparedStatement query = con.prepareStatement("SELECT status FROM friends where username=? and friend=? ");

            query.setString(1, user);
            query.setString(2, friend);
            ResultSet rs = query.executeQuery();
            rs.next();
            status = rs.getString("status");

            con.close();

        } catch (Exception e2) {
            System.out.println(e2);
        }

        return status;
    }

    protected boolean confirmFriendRequest(String user, String friend) {
        boolean success = false;
        try {
            //-----------------Getting Connection-----------------------------------------        
            Class.forName(driver);

            Connection con = DriverManager.getConnection(dataBase, this.user, password);
            //-----------------Getting Connection----------------------------------------- 

            Date date = new Date();

            java.sql.Date sqlDate = new java.sql.Date(date.getTime());
            int id = getMaxFriendsID();

            PreparedStatement confirmFriend = con.prepareStatement("update friends set status=?, date=? where username=? and friend=?");
            confirmFriend.setString(1, "confirmed");
            confirmFriend.setDate(2, sqlDate);
            confirmFriend.setString(3, user);
            confirmFriend.setString(4, friend);
            int i = confirmFriend.executeUpdate();

            PreparedStatement insertUser = con.prepareStatement("insert into friends values(?,?,?,?,?)");

            id = id + 1;
            insertUser.setInt(1, id);
            insertUser.setString(2, friend);
            insertUser.setString(3, user);
            insertUser.setString(4, "confirmed");
            insertUser.setDate(5, sqlDate);
            int j = insertUser.executeUpdate();
            int newId = getMaxFriendsID();
            if (newId > id - 1) {
                success = true;
            } else {
                success = false;
            }
            con.close();

        } catch (Exception e2) {
            System.out.println(e2);
        }
        return success;
    }

    protected boolean declineFriendRequest(String user, String friend) {
        boolean success = false;
        try {
            //-----------------Getting Connection-----------------------------------------        
            Class.forName(driver);

            Connection con = DriverManager.getConnection(dataBase, this.user, password);
            //-----------------Getting Connection----------------------------------------- 

            PreparedStatement declineFriend = con.prepareStatement("Delete from friends where status=? and username=? and friend=?");
            declineFriend.setString(1, "sent");

            declineFriend.setString(2, user);
            declineFriend.setString(3, friend);
            int i = declineFriend.executeUpdate();

            if (i != 0) {
                success = true;
            } else {
                success = false;
            }
            con.close();

        } catch (Exception e2) {
            System.out.println(e2);
        }
        return success;
    }

    protected boolean removeFriend(String user, String friend) {
        boolean success = false;
        try {
            //-----------------Getting Connection-----------------------------------------        
            Class.forName(driver);

            Connection con = DriverManager.getConnection(dataBase, this.user, password);
            //-----------------Getting Connection----------------------------------------- 

            int id = getNumberOfFriends(user);

            PreparedStatement removeFriendFirst = con.prepareStatement("Delete from friends where status=? and username=? and friend=?");
            removeFriendFirst.setString(1, "confirmed");

            removeFriendFirst.setString(2, user);
            removeFriendFirst.setString(3, friend);
            int i = removeFriendFirst.executeUpdate();

            PreparedStatement removeFriendSecond = con.prepareStatement("Delete from friends where status=? and username=? and friend=?");
            removeFriendSecond.setString(1, "confirmed");

            removeFriendSecond.setString(2, friend);
            removeFriendSecond.setString(3, user);
            int j = removeFriendSecond.executeUpdate();

            int newId = getNumberOfFriends(user);
            if (newId < id) {
                success = true;
            } else {
                success = false;
            }
            con.close();

        } catch (Exception e2) {
            System.out.println(e2);
        }
        return success;
    }

    //FRIENDS FUNCTIONS END***************************************************************************************************************************************
    //Message FUNCTIONS *****************************************************************************************************************************************
    private int getMaxMessageID() {
        int maxID = -1;
        try {
            //-----------------Getting Connection-----------------------------------------        
            Class.forName(driver);

            Connection con = DriverManager.getConnection(dataBase, this.user, password);
            //-----------------Getting Connection----------------------------------------- 
            Statement s2 = con.createStatement();
            s2.execute("SELECT MAX(id) FROM messages");
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

    protected void recordMessage(String sender, String receiver, String message) {
        try {
            //-----------------Getting Connection-----------------------------------------        
            Class.forName(driver);

            Connection con = DriverManager.getConnection(dataBase, this.user, password);
            //-----------------Getting Connection----------------------------------------- 
            int id = getMaxMessageID();

            PreparedStatement addMessage = con.prepareStatement(
                    "insert into messages values(?,?,?,?,?)");

            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
            Calendar cal = Calendar.getInstance();
            System.out.println(dateFormat.format(cal.getTime()));
            java.sql.Timestamp timestamp = new java.sql.Timestamp(cal.getTimeInMillis());

            id = id + 1;
            addMessage.setInt(1, id);
            addMessage.setString(2, sender);
            addMessage.setString(3, receiver);
            addMessage.setString(4, message);
            addMessage.setTimestamp(5, timestamp);
            int i = addMessage.executeUpdate();
            con.close();

        } catch (Exception e2) {
            System.out.println(e2);
        }
    }

    protected java.util.LinkedList<Message> getConversation(String sender, String receiver) {
        java.util.LinkedList<Message> messages = new java.util.LinkedList();
        try {
            //-----------------Getting Connection-----------------------------------------        
            Class.forName(driver);

            Connection con = DriverManager.getConnection(dataBase, this.user, password);
            //-----------------Getting Connection----------------------------------------- 
            PreparedStatement query = con.prepareStatement("select sender,receiver,message,date from messages where (sender=? and receiver=?) or  (sender=? and receiver=?)  ORDER BY `date` ");

            query.setString(1, sender);
            query.setString(2, receiver);
            query.setString(3, receiver);
            query.setString(4, sender);

            ResultSet rs = query.executeQuery();

            while (rs.next()) {
                Message msg = new Message();
                String sendeR = rs.getString("sender");
                String receiveR = rs.getString("receiver");
                String message = rs.getString("message");
                java.sql.Timestamp timestamp = rs.getTimestamp("date");

                msg.setSender(sendeR);
                msg.setReceiver(receiveR);
                msg.setMessage(message);
                msg.setDateTime(timestamp);
                messages.add(msg);
            }

            con.close();

        } catch (Exception e2) {
            System.out.println(e2);
        }

        return messages;
    }

    //Message FUNCTIONS END***************************************************************************************************************************************
}
