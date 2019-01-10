<%-- 
    Document   : eventlist
    Created on : Jan 1, 2019, 11:07:32 AM
    Author     : nikolaj
--%>

<%@page import="web.Gift"%>
<%@page import="bean.GiftsBean"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<jsp:useBean id="event" class="bean.GiftsBean"/>  

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="styles.css">
        <title>Gifts</title>
    </head>



    <%

        //int m=obj.cube(5);  
        //out.print("cube of 5 is "+m);
        try {
            GiftsBean e = new GiftsBean();
            List<Gift> list = event.getData();
            out.println("<body>");
            out.println("<h1>Activate a gift!</h1>");
            for (int i = 0; i < list.size(); i++) {

                out.println("<td>");
                out.println("<span>");
                out.println("<a href=\"chosengift.jsp?giver=" + (list.get(i).getGiver()) + "&id=" + list.get(i).getId() + "&amount=" + (list.get(i).getAmount()) + "\">" + String.format(list.get(i).getAmount() + " from " + list.get(i).getGiver()) + "</a>");
                out.println("</span>");
                out.println("</td><br>");

            }
            out.println("<a href=\"index.html\">Get back to main</a>");
            out.println("<a href=\"logout.jsp\">Log out</a>");
            out.println("</body>");
        } catch (Exception e) {
            out.println("<body>");

            out.println("<td>");
            out.println("<span>");
            out.println("<h1>No records available</h1>");
            out.println("</span>");
            out.println("</td><br>");
            out.println("</body>");

        }
    %>  

</html>

<%-- To display selected value from dropdown list. --%>



