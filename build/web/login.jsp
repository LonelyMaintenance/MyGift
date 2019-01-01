<%-- 
    Document   : login
    Created on : Dec 17, 2018, 9:05:29 AM
    Author     : nikolaj
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
                 <link rel="stylesheet" href="styles.css">

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
    </head>
    <body>
          <form action="LoginServlet" method="POST">
            Login<input type="text" name="login" value="" /><br>
            Password <input type="text" name="password" value="" /><br>
            <input type="submit" value="Login" name="submit" />
        </form>
                    <% out.println("<b>"+request.getAttribute("message") + "</b>"); %>

    </body>

</html>
