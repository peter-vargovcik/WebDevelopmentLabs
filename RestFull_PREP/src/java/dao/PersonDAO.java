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
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Peter Vargovcik
 */
public class PersonDAO {
    
    private Connection con = null;
    
    public PersonDAO() {
        try {
            System.out.println("Loading db driver...");
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/persons_db",
                    "vargi83",
                    "admin");
            
            System.out.println("Connection established...");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PersonDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(PersonDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(PersonDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(PersonDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public List<Person> getPersons(int noOfPersons) {
        List<Person> persons = new ArrayList<>();
        try {
            PreparedStatement pstmt = con.prepareStatement("SELECT * FROM persons LIMIT ?;");
            pstmt.setInt(1, noOfPersons);

            ResultSet rs = pstmt.executeQuery();

            // move the cursor to the start
            while (rs.next()){
                Person person = new Person();
                
                person.setEmailAddress(rs.getString("emailAddress"));
                person.setName(rs.getString("name"));
                person.setSurname(rs.getString("surname"));
                person.setBirthday(rs.getDate("birthday"));
                person.setStreet(rs.getString("street"));
                person.setCity(rs.getString("city"));
                person.setCountry(rs.getString("country"));
                person.setPostCode(rs.getString("postCode"));
                person.setPhone(rs.getString("phone"));
                person.setUsername(rs.getString("username"));
                person.setPassword(rs.getString("password"));
                person.setMothersMaidenname(rs.getString("mothersMaidenname"));
                person.setCreditCardNumber(rs.getString("creditCardNumber"));
                person.setCreditCardExpires(rs.getString("creditCardExpires"));
                person.setCreditCardNumberSecureNo(rs.getString("creditCardNumberSecureNo"));
                person.setOccupation(rs.getString("occupation"));
                person.setCompany(rs.getString("company"));
                person.setVehicle(rs.getString("vehicle"));
                person.setBloodType(rs.getString("bloodType"));
                person.setHeightImperial(rs.getString("heightImperial"));
                person.setWeightPounds(rs.getDouble("weightPounds"));
                person.setWeightKilograms(rs.getDouble("weightKilograms"));
                person.setHeightCentimeters(rs.getDouble("heightCentimeters"));
                person.setLatitude(rs.getFloat("latitude"));
                person.setLongitude(rs.getFloat("longitude"));
                
                persons.add(person);
            }
        } catch (SQLException ex) {
            Logger.getLogger(PersonDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return persons;
    }
    
    public static void main(String[] args){
         PersonDAO doa = new PersonDAO();
       List<Person> people = doa.getPersons(10);
        System.out.println(people.size());
    }
    
}
//"", "", "", "", "", "", "", "",
//    "", "", "", "", "", "", "",
//    "", "", "", "", "", "", "",
//    "", "", "", ""