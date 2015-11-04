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
        <link rel="stylesheet" type="text/css" href="style.css">
        <link href='http://fonts.googleapis.com/css?family=Eater' rel='stylesheet' type='text/css'>
        <title></title> 

    </head>
    <body>

        <div id="wrap">
            <div id="header">
                <table id="head"  align="center" >
                    <tr>
                        <td>Instagram Baby</td>

                    </tr>
                </table>

            </div>                   
            <div id="footer">
                <center><p>The world is Your pictures<div id='log'>

                        <a href='register.jsp'>sign up &nbsp&nbsp</a>

                    </div>

                    </p></center>

            </div>
            <form name="myForm"  method="post" action="LoginServlet">
                <table id="register" align="Center" >
                    <tr>
                        <td class="p1"> Username: </td> 
                        <td class="">    <input type="text" onKeyDown="usrcheck1()" onBlur="usrcheck1()" name="u"></td>


                    </tr>

                    <tr>
                        <td class="">  Password:</td> 
                        <td class=""><input type="password" " onBlur="passcheck1()" name="p"></td>
                        <td height="8" id="pchk">
                        </td>
                    </tr>




                    <tr>
                        <td class=""> <input type="submit" value="Log in"> </td>
                        <td class="">  Wrong Username or Password</td> 
                    </tr>       
                </table>
            </form>

        </div>
    </body>
</html>
