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
import java.text.DateFormat;
import java.text.SimpleDateFormat;
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
            while (rs.next()) {
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

    public Person getPerson(String emailAddress) {
        Person person = null;

        try {
            PreparedStatement pstmt = con.prepareStatement("SELECT * FROM persons WHERE emailAddress=?;");
            pstmt.setString(1, emailAddress);

            ResultSet rs = pstmt.executeQuery();

            // move the cursor to the start
            if (rs.next()) {
                person = new Person();
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
            }
            else{
        }
        } catch (SQLException ex) {
            Logger.getLogger(PersonDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return person;
    }

    public static void main(String[] args) {
        PersonDAO doa = new PersonDAO();
        List<Person> people = doa.getPersons(10);
        System.out.println(people.size());
    }

    public int addPerson(Person person) {
        if (getPerson(person.getEmailAddress()) != null) {            
            return -1;  //ERROR: account is in the db
        } else {
            try {
                PreparedStatement ps
                        = con.prepareStatement(
                                "INSERT INTO persons_db.persons (emailAddress,name,surname,street,city,country,postCode,phone,username,"
                                        + "password,mothersMaidenname,birthday,creditCardType,creditCardNumber,creditCardExpires,creditCardNumberSecureNo,"
                                        + "occupation,company,vehicle,bloodType,weightPounds,weightKilograms,heightImperial,heightCentimeters,latitude,"
                                        + "longitude)VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)"
                        );
                
                ps.setString(1, person.getEmailAddress());
                ps.setString(2, person.getName());
                ps.setString(3, person.getSurname());
                ps.setString(4, person.getStreet());
                ps.setString(5, person.getCity());
                ps.setString(6, person.getCountry());
                ps.setString(7, person.getPostCode());
                ps.setString(8, person.getPhone());
                ps.setString(9, person.getUsername());
                ps.setString(10, person.getPassword());
                ps.setString(11, person.getMothersMaidenname());
                
                DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
                String birthDay = df.format(person.getBirthday());
                ps.setString(12, birthDay);
                ps.setString(13, person.getCreditCardType());
                ps.setString(14, person.getCreditCardNumber());
                ps.setString(15, person.getCreditCardExpires());
                ps.setString(16, person.getCreditCardNumberSecureNo());
                ps.setString(17, person.getOccupation());
                ps.setString(18, person.getCompany());
                ps.setString(19, person.getVehicle());
                ps.setString(20, person.getBloodType());
                ps.setDouble(21, person.getWeightPounds());
                ps.setDouble(22, person.getWeightKilograms());
                ps.setString(23, person.getHeightImperial());
                ps.setDouble(24, person.getHeightCentimeters());
                ps.setFloat(25, person.getLatitude());
                ps.setFloat(26, person.getLongitude());
                ps.executeUpdate();
            } catch (SQLException ex) {
                Logger.getLogger(PersonDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
            return 1;
        }
    }

    public boolean deletePerson(String emailAddress) {
        boolean res = false;
        try {
            PreparedStatement ps
                    = con.prepareStatement(
                            "DELETE FROM persons_db.persons WHERE emailAddress=?;"
                    );
            ps.setString(1, emailAddress);

            if (ps.executeUpdate() == 1) {
                res = true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(PersonDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return res;
    }

    public int updatePerson(Person updatedPerson) {
        try {
            // make sure that the account exists
            if (getPerson(updatedPerson.getEmailAddress()) != null) {            
            return -1;  //ERROR: account is in the db
        } else  {
                PreparedStatement ps
                        = con.prepareStatement(
                                "UPDATE persons_db.persons SET emailAddress=?,name=?,surname=?,street=?,city=?,country=?,postCode=?,phone=?,username=?,"
                                        + "password=?,mothersMaidenname=?,birthday=?,creditCardType=?,creditCardNumber=?,creditCardExpires=?,creditCardNumberSecureNo=?,"
                                        + "occupation=?,company=?,vehicle=?,bloodType=?,weightPounds=?,weightKilograms=?,heightImperial=?,heightCentimeters=?,latitude=?,"
                                        + "longitude=? WHERE emailAddress=?"
                        );
                
                ps.setString(1, updatedPerson.getEmailAddress());
                ps.setString(2, updatedPerson.getName());
                ps.setString(3, updatedPerson.getSurname());
                ps.setString(4, updatedPerson.getStreet());
                ps.setString(5, updatedPerson.getCity());
                ps.setString(6, updatedPerson.getCountry());
                ps.setString(7, updatedPerson.getPostCode());
                ps.setString(8, updatedPerson.getPhone());
                ps.setString(9, updatedPerson.getUsername());
                ps.setString(10, updatedPerson.getPassword());
                ps.setString(11, updatedPerson.getMothersMaidenname());
                
                DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
                String birthDay = df.format(updatedPerson.getBirthday());
                ps.setString(12, birthDay);
                ps.setString(13, updatedPerson.getCreditCardType());
                ps.setString(14, updatedPerson.getCreditCardNumber());
                ps.setString(15, updatedPerson.getCreditCardExpires());
                ps.setString(16, updatedPerson.getCreditCardNumberSecureNo());
                ps.setString(17, updatedPerson.getOccupation());
                ps.setString(18, updatedPerson.getCompany());
                ps.setString(19, updatedPerson.getVehicle());
                ps.setString(20, updatedPerson.getBloodType());
                ps.setDouble(21, updatedPerson.getWeightPounds());
                ps.setDouble(22, updatedPerson.getWeightKilograms());
                ps.setString(23, updatedPerson.getHeightImperial());
                ps.setDouble(24, updatedPerson.getHeightCentimeters());
                ps.setFloat(25, updatedPerson.getLatitude());
                ps.setFloat(26, updatedPerson.getLongitude());
                ps.setString(27, updatedPerson.getEmailAddress());
                ps.executeUpdate();
            }
        } catch (SQLException ex) {
            Logger.getLogger(PersonDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 1;// success
    }

}
