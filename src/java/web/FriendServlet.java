/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
 */
package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
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
@WebServlet(name = "FriendServlet", urlPatterns = {"/FriendServlet"})
public class FriendServlet extends HttpServlet {

    String login;

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

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        String chosenUser = (String) request.getAttribute("item");
        
        
                
                Cookie friendCookie = new Cookie(("receiver"), chosenUser);
                //setting cookie to expiry in 30 mins
                friendCookie.setMaxAge(30 * 60);
                response.addCookie(friendCookie);

        RequestDispatcher rd = request.getRequestDispatcher("transaction.jsp");
        rd.forward(request, response);
    }

}
