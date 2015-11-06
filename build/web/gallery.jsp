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
        <p>

            <%
                List images = (List) request.getAttribute("images");
                Iterator it = images.iterator();
                while (it.hasNext()) {
                    out.print("<br>try: " + it.next());
                }
            %>
    </body>
</html>
