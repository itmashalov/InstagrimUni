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
        <script type="text/javascript" src="validation.js"></script>
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
            <center><p>The world is Your pictures</p></center>
            </div>
<form name="myForm" onsubmit="return validateForm()" method="post" action="Register">
                <table id="register" align="Center" >
                    
                    <tr>
                       <td class="p1"> Username*: </td> 
                       <td class="">    <input type="text" onKeyDown="usrcheck1()" onBlur="usrcheck1()" name="usr"></td>
                        
                      
                    </tr>
                    
                    <tr>
                       <td class="">  Password*:</td> 
                       <td class=""><input type="password" onKeyDown="passcheck1()" onBlur="passcheck1()" name="pass"></td>
                       <td height="8" id="pchk">
                       </td>
                    </tr>
                           
                    <tr>
                       <td class=""> Confirm Password*:</td> 
                       <td class=""> <input type="password" onKeyDown="passcheck2()" onBlur="passcheck2()" name="re-pass"></td>
                       <td height="8" id="repass">	 
                           
                       </td>
                    </tr>
                    
                     <tr>
                       <td class="">Name*:</td> 
                       <td class="">     <input type="text" onKeyDown="namecheck()" onBlur="namecheck()" name="name"></td>
                          <td height="8" id="nam">
                    </tr>
                    <tr>
                       <td class="">Email*:</td> 
                       <td class="">     <input type="text" onKeyDown="mailchk()" onBlur="mailchk()" name="email"></td>
                       <td height="8" id="mchk">
                    </tr>
               
                    
                    <tr>
                       <td class=""> <input type="submit" value="Create Account"> </td>
                       
                       <td class="p1"> Username Already Exist! </td> 
                      
                        
                      
                    
                    </tr>       
                </table>
            </form>
            
             </div>

