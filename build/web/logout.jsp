<%-- 
    Document   : logout
    Created on : Jan 9, 2019, 9:09:05 PM
    Author     : kat
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>You have been logged out!</h1>
        <%

    	Cookie[] cookies = request.getCookies();
    	if(cookies != null){
    	for(Cookie cookie : cookies){
    	             if (cookie.getName().contains("user")) {
                        Cookie loginCookie = new Cookie(cookie.getName(), "");
                        //setting cookie to expiry in 30 mins
                        loginCookie.setMaxAge(0);
                        response.addCookie(loginCookie);

                    }
       }
        }
            %>
        <a href="index.html">Main page</a><br>
        <a href="login.jsp">Login page</a><br>

    </body>
</html>
