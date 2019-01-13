/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
 */
package web;

import bean.LoginBean;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author nikolaj
 */
@WebServlet(name = "LoginServlet", urlPatterns = {"/LoginServlet"})
public class LoginServlet extends HttpServlet {

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
            String login = null;
            login = request.getParameter("login");
            String password = null;
            password = request.getParameter("password");
            boolean check = checkGivenPassword(login, password);
            if ((login != null && !login.isEmpty()) && (password != null && !password.isEmpty()) && check == true) {
                // RequestDispatcher rdServlet = request.getRequestDispatcher("BookTripFormHandler");
                // request.setAttribute("message", "Exchange rate ");
                request.setAttribute("login", login);
                request.setAttribute("message", "You are logged in");
                              try (PrintStream print = new PrintStream(new FileOutputStream("loggedIn.txt"))) {
    print.print(login);
    
}
                Cookie receiverCookie = new Cookie(("user"), login);
                //setting cookie to expiry in 30 mins
                receiverCookie.setMaxAge(30 * 60);
                response.addCookie(receiverCookie);
                if(checkIfAdmin(login)==false){
                RequestDispatcher red = request.getRequestDispatcher("menucustomer.jsp");
                
                try{
                red.forward(request, response);
                }catch(Exception e){
                RequestDispatcher re = request.getRequestDispatcher("login.jsp");
                request.setAttribute("message", "Error logging in");
                //request.setAttribute("login", login);
                re.forward(request, response);

                    }
                } else {
                    RequestDispatcher red = request.getRequestDispatcher("menuadmin.jsp");

                    try {
                        red.forward(request, response);
                    } catch (Exception e) {
                        RequestDispatcher re = request.getRequestDispatcher("login.jsp");
                        request.setAttribute("message", "Error logging in");
                        //request.setAttribute("login", login);
                        re.forward(request, response);

                }
                }
            } else {
                RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
                request.setAttribute("message", "Please insert login and password");
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

    private boolean checkGivenPassword(String email, String password) {

        LoginBean lb = new LoginBean(); //(TeacherInforRemRemote) Naming.lookup ("ava:global/CourseEJB/beans/TeacherInfoRem");
        lb.init();
        boolean check = lb.checkPassword(email, password);
        lb.closeConnection();

        return check;
    }
    
    private boolean checkIfAdmin(String email) {

        LoginBean lb = new LoginBean(); //(TeacherInforRemRemote) Naming.lookup ("ava:global/CourseEJB/beans/TeacherInfoRem");
        lb.init();
        boolean admin = lb.checkIfAdmin(email);
        lb.closeConnection();

        return admin;
    }

}
