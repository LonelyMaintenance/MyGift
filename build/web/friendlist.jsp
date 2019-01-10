<%-- 
    Document   : eventlist
    Created on : Jan 1, 2019, 11:07:32 AM
    Author     : nikolaj
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
        <link rel="stylesheet" href="styles.css">
        <title>Friends</title>
    </head>
    <body>
        <h1>Pick a friend!</h1>
        <form action="FriendServlet" method="POST">
            <select name="item">


                <%
                    // <option value="1">1</option>
                    // <option value="2">2</option>
                    // <option value="3">3</option>

                //int m=obj.cube(5);  
                //out.print("cube of 5 is "+m);
                    FriendsBean e = new FriendsBean();
                    List<Friend> list = event.getData();

                    for (int i = 0; i < list.size(); i++) {
                        out.print("<option value=\"" + i + "\">");
                        out.print(list.get(i).getName());
                        out.print("</option>");
                    }

                    out.print("</option>");
                %>  
            </select>

            <input type="submit" value="Submit">
        </form>

    </body>
</html>

<%-- To display selected value from dropdown list. --%>



</body>