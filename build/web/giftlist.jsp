<%-- 
    Document   : eventlist
    Created on : Jan 1, 2019, 11:07:32 AM
    Author     : nikolaj, Victor
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
        <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Lato">
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Montserrat">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
                        <link rel="stylesheet" type="text/css" href="styles.css">

        <title>Gifts</title>
          <ul>
            <ul><a href="logout.jsp">Log out</a></ul>
            
        </ul>
    </head>
<header class="w3-container w3-red w3-center" style="padding:128px 16px">
            <h1 class="w3-margin w3-jumbo">Gift list</h1>
  


    <%

        //int m=obj.cube(5);  
        //out.print("cube of 5 is "+m);
        try {
            GiftsBean e = new GiftsBean();
            List<Gift> list = event.getData();
            out.println("<body>");
            out.println("<h3>Got any gifts?</h3>");

            out.println("</body>");
           
 
            
            for (int i = 0; i < list.size(); i++) {

                out.println("<td>");
                out.println("<span>");
                out.println("<a href=\"chosengift.jsp?giver=" + (list.get(i).getGiver()) + "&id=" + list.get(i).getId() + "&amount=" + (list.get(i).getAmount()) + "\">" + String.format(list.get(i).getAmount() + " from " + list.get(i).getGiver()) + "</a>");
                out.println("</span>");
                out.println("</td><br>");

            }

        } catch (IndexOutOfBoundsException e) {
            out.println("<body>");

            out.println("<td>");
            out.println("<span>");
            out.println("<h1>No records available</h1>");
            out.println("</span>");
            out.println("</td><br>");
            out.println("</header>");
            out.println("</body>");

        }catch(Exception e){
              out.println("<body>");

            out.println("<td>");
            out.println("<span>");
            out.println("<h1>No records available</h1>");
            out.println("</span>");
            out.println("</td><br>");
            }
    %>  
    </header>
            </body>
        
    <footer class="w3-container w3-padding-64 w3-center w3-opacity">  
            <p>Powered by <a href="https://www.w3schools.com/w3css/default.asp" target="_blank">w3.css</a></p>
        </footer>

</html>

<%-- To display selected value from dropdown list. --%>



