<%-- 
    Document   : accounthistory
    Created on : Jan 10, 2019, 4:53:02 PM
    Author     : nikolaj
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="bean.AdminGiftBean"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Account History</title>
    </head>
    <body>
        <h1>Account History</h1>
        <%
            String email = null;
            Cookie[] cookies = request.getCookies();
            if (cookies != null) {
                for (Cookie cookie : cookies) {
                    
                    if (cookie.getName().contains("user")) {
                        email =  cookie.getValue();
            AdminGiftBean agb = new AdminGiftBean();
            agb.init();
            ArrayList<String> list = agb.getTransactionsHistory(email);
            agb.closeConnection();
            
            for(int i = 0; i < list.size(); i++){
                out.println(list.get(i));
                out.println("<br><br>");
            }

                    

                }
            }
            }
            
            %>
    </body>
</html>