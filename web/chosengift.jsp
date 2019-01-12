<%-- 
    Document   : chosengift
    Created on : Jan 7, 2019, 9:32:03 PM
    Author     : nikolaj, Victor
--%>

<%@page import="bean.GiftsBean"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Lato">
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Montserrat">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <style>
            body,h1,h2,h3,h4,h5,h6 {font-family: "Lato", sans-serif}
            .w3-bar,h1,button {font-family: "Montserrat", sans-serif}
            .fa-anchor,.fa-coffee {font-size:200px}
        </style>
        <title>Your gift</title>
    </head>
    <body>
        <header class="w3-container w3-red w3-center" style="padding:128px 16px">
            <h1 class="w3-margin w3-jumbo">Chosen gift</h1>
        

        <%
            String g = request.getParameter("giver");
            String i = request.getParameter("id");
            String a = request.getParameter("amount");
            String user = null;
            Cookie[] cookies = request.getCookies();
            if (cookies != null) {
                for (Cookie cookie : cookies) {
                    if (cookie.getName().contains("user")) {
                        user = cookie.getValue();

                        if (g != null && i != null && user != null & a != null) {
                            out.println("<h3>Chosen giver at " + g + " at id " + i + " for logged in user " + user + " with amount" + a + "</h3>");

                            GiftsBean e = new GiftsBean();
                            e.activateGift(i, user, a);

                        }

                    }
                }
            }

            /* TODO output your page here. You may use following sample code. */

        %>
                <a href="menucustomer.jsp">Menu</a>

                <a href="logout.jsp">Log out</a><br>
        </header>
        <footer class="w3-container w3-padding-64 w3-center w3-opacity">  
            <p>Powered by <a href="https://www.w3schools.com/w3css/default.asp" target="_blank">w3.css</a></p>
        </footer>
    </body>
</html>
