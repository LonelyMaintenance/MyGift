<%-- 
    Document   : menucustomer
    Created on : Jan 9, 2019, 10:05:24 PM
    Author     : nikolaj
--%>

<%@page import="java.io.File"%>
<%@page import="java.util.Scanner"%>
<%@page import="bean.AdminTransactionBean"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>,
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
        <title>Menu Customer</title>
    </head>
    <body>
        <header class="w3-container w3-red w3-center" style="padding:128px 16px">
            <h1 class="w3-margin w3-jumbo">Menu Customer</h1>
        <%
AdminTransactionBean agb = new AdminTransactionBean();
            agb.init();
                   Scanner scanner = new Scanner(new File("loggedIn.txt"), "UTF-8");
        String user = scanner.useDelimiter("\\A").next();
        scanner.close(); // Put this call in a finally block
            float accountValue = agb.getAccountValueStatement(user);
            
            out.println(String.format("Money on you account %s<br><br>", String.valueOf(accountValue)));

                    

            
            %>
        
        <a href="accounthistory.jsp">View history of gifts given to you</a><br>
        <a href="friendlist.jsp">Give a gift to a friend</a><br>
        <a href="giftlist.jsp">Cash in gifts</a><br>
        <a href="index.html">Main page</a><br>
        <a href="logout.jsp">Log out</a><br>
        </header>
            <footer class="w3-container w3-padding-64 w3-center w3-opacity">  
            <p>Powered by <a href="https://www.w3schools.com/w3css/default.asp" target="_blank">w3.css</a></p>
        </footer>
    </body>
</html>
