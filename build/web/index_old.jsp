<%-- 
    Document   : register
    Created on : Oct 10, 2014, 8:09:27 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <script type="text/javascript" src="java.js"></script>

    </head>
    <body>

        <div id="wrap">
            <div id="header">
                

            </div>                   
            <div id="footer">
                <%
                    if (session.getAttribute("is_logged") == "True") {
                %>    

                <center> 
                    <div id='log'>
                        <a href='searchImg.jsp'>search img</a>&nbsp | &nbsp 
                         <form method="post" action="GalleryServlet" >
                        <!--<a href='gallery.jsp'>gallery</a>&nbsp | &nbsp  -->
                        <input type="hidden" name="user" value=<%=   session.getAttribute("user")%>>
                        <input type="submit" value="gallery">
                        
                         </form>
                        <a href="LogoutServlet">log out &nbsp&nbsp</a>

                    </div>

                    </p></center></div>

            <center>
                <h2>
                    
                     
                    <% if (session.getAttribute("uploaded") == "True") {
                    %>
                    Image Uploaded Successfully, You can Visit Gallery(link) to see your images.
                    <%
                    }
                    %>

                    <% if (session.getAttribute("uploaded") == "False") {
                    %>
                    No Image Selected!!!
                    <%
                    }
                    %>
                    
                     <% if (session.getAttribute("uploaded") == "TooBig") {
                     %>
                    The Selected Image is Larger than 1MB!
                    <%
                    }
                    %>

                    <% if (session.getAttribute("uploaded") == null){
                    %>
                    hello <%=   session.getAttribute("user")%>
                     Upload Your Picture Here
                    <%
                        }
                    %>

                </h2>
                <form method="post" action="UploadImageServlet"  enctype="multipart/form-data">
                    <table border="0">
                        <tr>
                            <td>Tag of your pic </td>
                            <td><input type="text" name="nametag" size="50"/></td>
                        </tr>
                        <tr>
                            <td>Public Pic? </td>
                            <td><input type="checkbox" name="type" ></td>
                        </tr>
                        <tr>
                            <td>Portrait Photo: </td>
                            <td><input type="file" name="photo" size="50"/></td>
                        </tr>
                        <tr>
                            <td colspan="2">
                                <input type="submit" value="Save">
                            </td>
                        </tr>
                    </table>
                </form>
                <form method="post" action="show" enctype="multipart/form-data">
                    <table border="0">

                        <tr>
                            <td colspan="2">
                                <input type="submit" value="Show your latest pictures">
                            </td>
                        </tr>
                    </table>
                </form>

            </center>    

 
            <%
            } else {
            %>
            <center><p>The world is Your pictures<div id='log'>
                    <a href='gallery.jsp'>gallery</a>&nbsp | &nbsp                 
                    <a href='login.jsp'>log in</a>&nbsp | &nbsp
                    <a href='register.jsp'>sign up &nbsp&nbsp</a>
                </div></p></center></div>  
                <%
                    }
                %>             
 
    </body>
</html> 

