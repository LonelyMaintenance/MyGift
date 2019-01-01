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
public class AdminTransactionBean {
        Connection con;
    PreparedStatement stmt;
            Statement searchStmt;

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    
    //In the real world, this method should have madtoe a call to database objects to query data
   
    public void init(){
         try {    
            Class.forName("com.mysql.jdbc.Driver");
            this.con = DriverManager.getConnection("jdbc:mysql://localhost/mygift?autoReconnect=true&useSSL=false", "root", "root");
        } catch (ClassNotFoundException ex) {
        } catch (SQLException ex) {
        }
    }
   
    public void activateGift(String idOfGift, String giftTaker, String amount) throws SQLException{
        this.stmt = (PreparedStatement) con.prepareStatement("UPDATE gift SET activated=1 WHERE id=?;");
            stmt.setInt(1, Integer.valueOf(idOfGift));
            stmt.executeUpdate();

            this.stmt = (PreparedStatement) con.prepareStatement("UPDATE giftTaker SET moneyOnAccount=moneyOnAccount+? WHERE email=?;");
            stmt.setFloat(1, Float.valueOf(amount));
            stmt.setString(2, giftTaker);
            stmt.executeUpdate();
        
            


    }
    public void insertExistingUserStatement(String email, float amount, int password, boolean isAdmin, boolean isInactive, String alias){
        try{
            //Creates new customer account
            this.stmt = (PreparedStatement) con.prepareStatement("UPDATE giftTaker SET moneyOnAccount=moneyOnAccount+? WHERE email=?;");
            stmt.setFloat(1, amount);
            stmt.setString(2, email);
            stmt.executeUpdate();
            //Creates alias
            this.stmt = (PreparedStatement) con.prepareStatement("INSERT INTO giftGiver VALUES(?);");
            stmt.setString(1, alias);
            stmt.executeUpdate();
            //Creates gift
            this.stmt = (PreparedStatement) con.prepareStatement("INSERT INTO gift(amount, activated, giftTaker_email, giftGiver_alias) VALUES(?, ?, ?, ?);");
            stmt.setFloat(1, amount);
            stmt.setBoolean(2, false);
            stmt.setString(3, email);
            stmt.setString(4, alias);
            stmt.executeUpdate();
            

        } catch (SQLException ex) {
        }
    }
    public void withdrawFromUserStatement(String email, String amount){
        try{
            //Creates new customer account
            this.stmt = (PreparedStatement) con.prepareStatement("UPDATE giftTaker SET moneyOnAccount=moneyOnAccount-? WHERE email=?;");
            stmt.setFloat(1, Float.valueOf(amount));
            stmt.setString(2, email);
            stmt.executeUpdate();
    
        } catch (SQLException ex) {
        }
    }
    
    public void insertNewUserStatement(String email, float amount, int password, boolean isAdmin, boolean isInactive, String alias){
        try{
            //Creates new customer account
            this.stmt = (PreparedStatement) con.prepareStatement("INSERT INTO giftTaker VALUES(?,?,?,?,?);");
            stmt.setString(1, email);
            stmt.setFloat(2, amount);
            stmt.setString(3, String.valueOf(password));
            stmt.setBoolean(4, isAdmin);
            stmt.setBoolean(5, isInactive);
            stmt.executeUpdate();
            //Creates alias
            this.stmt = (PreparedStatement) con.prepareStatement("INSERT INTO giftGiver VALUES(?);");
            stmt.setString(1, alias);
            stmt.executeUpdate();
            //Creates gift
            this.stmt = (PreparedStatement) con.prepareStatement("INSERT INTO gift(amount, activated, giftTaker_email, giftGiver_alias) VALUES(?, ?, ?, ?);");
            stmt.setFloat(1, amount);
            stmt.setBoolean(2, false);
            stmt.setString(3, email);
            stmt.setString(4, alias);
            stmt.executeUpdate();
            

        } catch (SQLException ex) {
        }
    }
    
    public void closeConnection(){
        try {
            stmt.close();
            con.close();
        } catch (SQLException ex) {
        }
    }
}
