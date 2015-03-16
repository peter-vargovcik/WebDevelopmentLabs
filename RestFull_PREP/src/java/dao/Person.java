/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.Date;
import java.util.List;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author Peter Vargovcik
 */
@XmlRootElement(name = "person")
@XmlType(propOrder = {"emailAddress", "name", "surname", "birthday", "street", "city", "country", "postCode",
    "phone", "username", "password", "mothersMaidenname", "creditCardType", "creditCardNumber", "creditCardExpires",
    "creditCardNumberSecureNo", "occupation", "company", "vehicle", "bloodType", "heightImperial", "weightPounds",
    "weightKilograms", "heightCentimeters", "latitude", "longitude", "link"})
public class Person {

    private String emailAddress, name, surname, street, city, country, postCode, phone, username, password,
            mothersMaidenname, creditCardType, creditCardNumber, creditCardExpires, creditCardNumberSecureNo,
            occupation, company, vehicle, bloodType, heightImperial;
    private double weightPounds, weightKilograms, heightCentimeters;
    private float latitude, longitude;
    
    private List<Link> link;

    Date birthday;

    public Person() {
    }

    @XmlElement(name="emailAddress")
    public String getEmailAddress() {
        return emailAddress;
    }

    @XmlElement(name="name")
    public String getName() {
        return name;
    }

    @XmlElement(name="surname")
    public String getSurname() {
        return surname;
    }

    @XmlElement(name="street")
    public String getStreet() {
        return street;
    }

    @XmlElement(name="city")
    public String getCity() {
        return city;
    }

    @XmlElement(name="country")
    public String getCountry() {
        return country;
    }

    @XmlElement(name="postCode")
    public String getPostCode() {
        return postCode;
    }

    @XmlElement(name="username")
    public String getPhone() {
        return username;
    }

    @XmlElement(name="username")
    public String getUsername() {
        return username;
    }

    @XmlElement(name="password")
    public String getPassword() {
        return password;
    }

    @XmlElement(name="mothersMaidenname")
    public String getMothersMaidenname() {
        return mothersMaidenname;
    }

    @XmlElement(name="creditCardType")
    public String getCreditCardType() {
        return creditCardType;
    }

    @XmlElement(name="creditCardNumber")
    public String getCreditCardNumber() {
        return creditCardNumber;
    }

    @XmlElement(name="creditCardExpires")
    public String getCreditCardExpires() {
        return creditCardExpires;
    }

    @XmlElement(name="creditCardNumberSecureNo")
    public String getCreditCardNumberSecureNo() {
        return creditCardNumberSecureNo;
    }

    @XmlElement(name="occupation")
    public String getOccupation() {
        return occupation;
    }

    @XmlElement(name="company")
    public String getCompany() {
        return company;
    }

    @XmlElement(name="vehicle")
    public String getVehicle() {
        return vehicle;
    }

    @XmlElement(name="bloodType")
    public String getBloodType() {
        return bloodType;
    }

    @XmlElement(name="heightImperial")
    public String getHeightImperial() {
        return heightImperial;
    }

    @XmlElement(name="weightPounds")
    public double getWeightPounds() {
        return weightPounds;
    }

    @XmlElement(name="weightKilograms")
    public double getWeightKilograms() {
        return weightKilograms;
    }

    @XmlElement(name="heightCentimeters")
    public double getHeightCentimeters() {
        return heightCentimeters;
    }

    @XmlElement(name="latitude")
    public float getLatitude() {
        return latitude;
    }

    @XmlElement(name="longitude")
    public float getLongitude() {
        return longitude;
    }

    @XmlElement(name="birthday")
    public Date getBirthday() {
        return birthday;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setMothersMaidenname(String mothersMaidenname) {
        this.mothersMaidenname = mothersMaidenname;
    }

    public void setCreditCardType(String creditCardType) {
        this.creditCardType = creditCardType;
    }

    public void setCreditCardNumber(String creditCardNumber) {
        this.creditCardNumber = creditCardNumber;
    }

    public void setCreditCardExpires(String creditCardExpires) {
        this.creditCardExpires = creditCardExpires;
    }

    public void setCreditCardNumberSecureNo(String creditCardNumberSecureNo) {
        this.creditCardNumberSecureNo = creditCardNumberSecureNo;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public void setVehicle(String vehicle) {
        this.vehicle = vehicle;
    }

    public void setBloodType(String bloodType) {
        this.bloodType = bloodType;
    }

    public void setHeightImperial(String heightImperial) {
        this.heightImperial = heightImperial;
    }

    public void setWeightPounds(double weightPounds) {
        this.weightPounds = weightPounds;
    }

    public void setWeightKilograms(double weightKilograms) {
        this.weightKilograms = weightKilograms;
    }

    public void setHeightCentimeters(double heightCentimeters) {
        this.heightCentimeters = heightCentimeters;
    }

    public void setLatitude(float latitude) {
        this.latitude = latitude;
    }

    public void setLongitude(float longitude) {
        this.longitude = longitude;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }    
    
    @XmlElement(name="link")
    public List<Link> getLink() {
        return link;
    }

    public void setLink(List<Link> link) {
        this.link = link;
    }

    @Override
    public String toString() {
        return "Person{" + "emailAddress=" + emailAddress + ", name=" + name + ", surname=" + surname + ", street=" + street + 
                ", city=" + city + ", country=" + country + ", postCode=" + postCode + ", phone=" + phone + ", username=" + 
                username + ", password=" + password + ", mothersMaidenname=" + mothersMaidenname + ", creditCardType=" + 
                creditCardType + ", creditCardNumber=" + creditCardNumber + ", creditCardExpires=" + creditCardExpires + 
                ", creditCardNumberSecureNo=" + creditCardNumberSecureNo + ", occupation=" + occupation + ", company=" + 
                company + ", vehicle=" + vehicle + ", bloodType=" + bloodType + ", heightImperial=" + heightImperial + 
                ", weightPounds=" + weightPounds + ", weightKilograms=" + weightKilograms + ", heightCentimeters=" + 
                heightCentimeters + ", latitude=" + latitude + ", longitude=" + longitude + ", birthday=" + birthday + '}';
    }
    
    

}
