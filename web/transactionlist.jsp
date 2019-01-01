<%-- 
    Document   : transactionlist
    Created on : Jan 1, 2019, 8:11:50 PM
    Author     : nikolaj
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="bean.AdminGiftBean"%>
<%@page import="bean.AdminTransactionBean"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
                 <link rel="stylesheet" href="styles.css">

        <title>Transaction list</title>
    </head>
    <body>
        <h1>List of transactions</h1>
   
<%  
    // <option value="1">1</option>
   // <option value="2">2</option>
   // <option value="3">3</option>
    
//int m=obj.cube(5);  
//out.print("cube of 5 is "+m);
AdminGiftBean e = new AdminGiftBean();
e.init();
ArrayList<String> tList = e.getTransactionsStatement();
e.closeConnection();


for(int i = 0; i < tList.size(); i++){
    out.print("<h3>");
    out.print(tList.get(i));
    out.print("</h3><br>");
}

%>  

  
    </body>
</html>

    <%-- To display selected value from dropdown list. --%>
  
           
     
</body>
