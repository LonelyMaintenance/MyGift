<%-- 
    Document   : menucustomer
    Created on : Jan 9, 2019, 10:05:24 PM
    Author     : nikolaj
--%>

<%@page import="bean.AdminTransactionBean"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Menu Customer</title>
    </head>
    <body>
        <h1>Menu Customer</h1>
        <%
            String email = null;
            Cookie[] cookies = request.getCookies();
            if (cookies != null) {
                for (Cookie cookie : cookies) {
                    
                    if (cookie.getName().contains("user")) {
                        email =  cookie.getValue();
            AdminTransactionBean agb = new AdminTransactionBean();
            agb.init();
            float accountValue = agb.getAccountValueStatement(email);
            
            out.println(String.format("Money on you account %s<br><br>", String.valueOf(accountValue)));

                    

                }
            }
            }
            
            %>
        
        <a href="accounthistory.jsp">View history of gifts given to you</a><br>
        <a href="friendlist.jsp">Give a gift to a friend</a><br>
        <a href="giftlist.jsp">Cash in gifts</a><br>
        <a href="index.html">Main page</a><br>
        <a href="logout.jsp">Log out</a><br>

    </body>
</html>
