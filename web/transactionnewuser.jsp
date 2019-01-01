<%-- 
    Document   : transaction
    Created on : Dec 28, 2018, 6:16:27 PM
    Author     : nikolaj
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
                 <link rel="stylesheet" href="styles.css">

        <title>Gift to new user</title>
    </head>
    <body>
          <form action="NewFriendTransactionServlet" method="POST">
            Your friends email  <input type="text" name="emailReceiver" value="" /><br>
            Amount to give <input type="text" name="amount" value="" /><br>
            Your alias <input type="text" name="alias" value="" /><br>
            <input type="submit" value="Give" name="submit" />
        </form>

                    <% out.println("<b>"+request.getAttribute("message") + "</b>"); %>
    </body>
</html>
