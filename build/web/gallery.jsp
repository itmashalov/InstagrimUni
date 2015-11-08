<%-- 
    Document   : gallery
    Created on : Nov 6, 2015, 7:12:43 AM
    Author     : imashalov
--%>

<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
         

            <%
                List images = (List) request.getAttribute("images");
                Iterator it = images.iterator();
                while (it.hasNext()) {
                   out.print("<br><img src='" + it.next()+"'   width='50%' height='100px'/>");
                    //out.print("<br>" + it.next());
                    
                }
                           // out.print(System.getProperty("java.io.tmpdir"));

            %>
          
            
    </body>
</html>
