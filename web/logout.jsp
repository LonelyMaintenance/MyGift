<%-- 
    Document   : logout
    Created on : Jan 9, 2019, 9:09:05 PM
    Author     : nikolaj, Victor
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Lato">
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Montserrat">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
                        <link rel="stylesheet" type="text/css" href="styles.css">
          <ul>
            <ul><a href="index.html">Main</a></ul>
            
        </ul>
        <title>Log out</title>
    </head>
    <body>
        <header class="w3-container w3-red w3-center" style="padding:128px 16px">
            <h1 class="w3-margin w3-jumbo">You have been logged out!</h1>
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

        </header>
        <footer class="w3-container w3-padding-64 w3-center w3-opacity">  
            <p>Powered by <a href="https://www.w3schools.com/w3css/default.asp" target="_blank">w3.css</a></p>
        </footer>
    </body>
</html>
