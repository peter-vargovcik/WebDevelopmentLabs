/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.io.Serializable;
import java.util.List;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author Peter Vargovcik
 */
@XmlRootElement (name = "bankaccount")
@XmlType(propOrder={"branchCode", "accountNumber", "custName", "link"})
public class BankAccount{
    String branchCode, accountNumber, custName;    
    private List<Link> link;

    public BankAccount(String branchCode, String accountNumber, String custName) {
        this.branchCode = branchCode;
        this.accountNumber = accountNumber;
        this.custName = custName;
    }

    public BankAccount() {
    }

    @XmlElement(name="branchCode")
    public String getBranchCode() {
        return branchCode;
    }

    @XmlElement(name="accountNumber")
    public String getAccountNumber() {
        return accountNumber;
    }
    
    @XmlElement(name="custName")
    public String getCustName() {
        return custName;
    }

    @XmlElement(name="link")
    public List<Link> getLink() {
        return link;
    }

    public void setBranchCode(String branchCode) {
        this.branchCode = branchCode;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public void setCustName(String custName) {
        this.custName = custName;
    }

    public void setLink(List<Link> link) {
        this.link = link;
    }
    
    
    
}
