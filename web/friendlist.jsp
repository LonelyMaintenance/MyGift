<%-- 
    Document   : eventlist
    Created on : Jan 1, 2019, 11:07:32 AM
    Author     : nikolaj, Victor
--%>

<%@page import="web.Friend"%>
<%@page import="bean.FriendsBean"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<jsp:useBean id="event" class="bean.FriendsBean"/>  

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Lato">
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Montserrat">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
                        <link rel="stylesheet" type="text/css" href="styles.css">
        <title>Friends</title>
                <ul>
            <ul><a href="logout.jsp">Log out</a></ul>
            <ul><a href="transactionnewuser.jsp">Give a gift to a new user</a>  </ul>
        </ul>        
    </head>
    <body>
        <header class="w3-container w3-red w3-center" style="padding:128px 16px">
            <h1 class="w3-margin w3-jumbo">Pick a friend!</h1>


                <%
                    // <option value="1">1</option>
                    // <option value="2">2</option>
                    // <option value="3">3</option>

                //int m=obj.cube(5);  
                //out.print("cube of 5 is "+m);
                    FriendsBean e = new FriendsBean();
                    List<Friend> list = event.getData();

           for (int i = 0; i < list.size(); i++) {

                out.println("<td>");
                out.println("<span>");
                out.println("<a href=\"transaction.jsp?taker="+list.get(i).getName()+" \">"+list.get(i).getName()+"</a>");
                out.println("</span>");
                out.println("</td><br>");

            }

                %>  
        </body>
         


        </header>
        <footer class="w3-container w3-padding-64 w3-center w3-opacity">  
            <p>Powered by <a href="https://www.w3schools.com/w3css/default.asp" target="_blank">w3.css</a></p>
        </footer>
    </body>
</html>

<%-- To display selected value from dropdown list. --%>