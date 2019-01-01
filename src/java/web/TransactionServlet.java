/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web;

import bean.AdminTransactionBean;
import bean.LoginBean;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Random;
import java.util.Scanner;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author nikolaj
 */
@WebServlet(name = "TransactionServlet", urlPatterns = {"/TransactionServlet"})
public class TransactionServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            String amount=null;
            amount = request.getParameter("amount");
            String alias=null; 
            alias = request.getParameter("alias");
Scanner scanner = new Scanner( new File("chosenFriend.txt"), "UTF-8" );
String friend = scanner.useDelimiter("\\A").next();
scanner.close(); // Put this call in a finally block

System.out.println("Give to "+friend);


            callAdminTransactionExistingUserBean(friend, amount, alias);
            if((amount!=null && !amount.isEmpty())&&(alias!=null && !alias.isEmpty())){
              RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
            // RequestDispatcher rdServlet = request.getRequestDispatcher("BookTripFormHandler");
           // request.setAttribute("message", "Exchange rate ");
            request.setAttribute("message", "Money transfered to your friend");
            rd.forward(request, response);
        }else{
                              RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
            request.setAttribute("message", "Transfer did not go through");
            //request.setAttribute("login", login);
            rd.forward(request, response);
            }
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
    private void callAdminTransactionExistingUserBean(String emailReceiver, String amount, String alias){
       Random rn = new Random();

        AdminTransactionBean arb = new AdminTransactionBean(); //(TeacherInforRemRemote) Naming.lookup ("ava:global/CourseEJB/beans/TeacherInfoRem");
        arb.init();  
        float giftAmount = Float.valueOf(amount);
        int password = rn.nextInt(1000);
        arb.insertExistingUserStatement(emailReceiver, giftAmount, password, false, false, alias);
        arb.closeConnection();
    }
}