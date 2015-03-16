/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package responseErrors;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author Peter Vargovcik
 */
@XmlRootElement (name = "personNotFound")
@XmlType(propOrder={"emailAddress"})
public class PersonNotFound {
    private String emailAddress;

    public PersonNotFound() {
    }

    public PersonNotFound(String emailAddress) {
        this.emailAddress = emailAddress;
    }
    
    @XmlElement(name="emailAddress")
    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }
    
    
    
}
