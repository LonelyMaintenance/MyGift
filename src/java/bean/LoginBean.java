/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
 */
package bean;

import bean.*;
import com.mysql.jdbc.PreparedStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;

/**
 *
 * @author nikolaj
 */
@Stateless
public class LoginBean {

    Connection con;
    Statement stmt;
    String correctPassword = null;
    String adminMail = null;
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    //In the real world, this method should have madtoe a call to database objects to query data
    public void init() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            this.con = DriverManager.getConnection("jdbc:mysql://localhost/mygift?autoReconnect=true&useSSL=false", "root", "root");
        } catch (ClassNotFoundException ex) {
        } catch (SQLException ex) {
        }
    }

    public boolean checkPassword(String email, String password) {

        try {
            this.stmt = con.createStatement();
            ResultSet resultSet = stmt.executeQuery("SELECT password from giftTaker where email='" + email + "';");

            while (resultSet.next()) {
                if (resultSet != null) {
                    this.correctPassword = resultSet.getString(1);

                }
                if (password.equalsIgnoreCase(correctPassword)) {
                    return true;
                }
            }
        } catch (SQLException ex) {
            System.err.println(new java.util.Date() + " : " + ex.getMessage());
        }
        return false;
    }

    public void closeConnection() {
        try {
            stmt.close();
            con.close();
        } catch (SQLException ex) {
        }
    }
}
