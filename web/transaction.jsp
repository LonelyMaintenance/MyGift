<%-- 
    Document   : transaction
    Created on : Dec 28, 2018, 6:16:27 PM
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
            <ul><a href="logout.jsp">Log out</a></ul>
        </ul>
        <title>Send gift to friend</title>
    </head>
    <body>
        <header class="w3-container w3-red w3-center" style="padding:128px 16px">
            <h1 class="w3-margin w3-jumbo">Send gift to friend</h1>
        

                              <form action="TransactionServlet" method="POST">
<%
            String t = request.getParameter("taker");
            String user = null;
            Cookie[] cookies = request.getCookies();
            if (cookies != null) {
                for (Cookie cookie : cookies) {
                    if (cookie.getName().contains("user")) {
                        user = cookie.getValue();

                        if (t != null && user != null) {
                                          out.println("<input type=\"text\" name=\"friend\" value=\""+t+"\" /><br>");

                            out.println("<h3>Receiver "+t+" for logged in user "+user+"</h3>");

                   

                        }

                    }
                }
            }

            /* TODO output your page here. You may use following sample code. */

        %>

              <label>Amount</label><br>
              <input type="text" name="amount" value="" /><br>
              <label>Alias</label><br>
              <input type="text" name="alias" value="" /><br>
              <input type="submit" value="Ok" name="submit" />
          </form>
        </header>
        <footer class="w3-container w3-padding-64 w3-center w3-opacity">  
            <p>Powered by <a href="https://www.w3schools.com/w3css/default.asp" target="_blank">w3.css</a></p>
        </footer>
    </body>
</html>
