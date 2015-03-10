/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Peter Vargovcik
 */
public class BankServiceDAO {
    
    private Connection con = null;
    
    public BankServiceDAO() {
        try {
            System.out.println("Loading db driver...");
            //Class.forName("org.apache.derby.jdbc.ClientDriver");
            System.out.println("Driver loaded...");
            con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/persons_db",
                    "vargi83",
                    "admin");
//        } catch (ClassNotFoundException ex) {
//            Logger.getLogger(BankServiceDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(BankServiceDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public BankAccount getPersons(int noOfPersons) {
//        List<Person> persons = null;
//        try {
//            PreparedStatement pstmt = con.prepareStatement(
//                    "CALL getPersons(?);");
//            pstmt.setInt(1, noOfPersons);
//
//            ResultSet rs = pstmt.executeQuery();
//
//            // move the cursor to the start
//            if (!rs.next()) {
//                return null;
//            }
//
//            // create a BankAccount based on the result of the db query
//            bankAccount
//                    = new BankAccount(rs.getString(1), rs.getString(2),
//                            rs.getString(3), rs.getString(4),
//                            rs.getString(5), rs.getString(6),
//                            rs.getDouble(7));
//        } catch (SQLException ex) {
//            Logger.getLogger(BankServiceDAO.class.getName()).log(Level.SEVERE, null, ex);
//        }
//
//        return bankAccount;
        return null;
    }
    
    public static void main(String[] args){
        new BankServiceDAO();
    }
    
}
