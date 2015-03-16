/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testWS;

import dao.Person;
import dao.PersonDAO;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author Peter Vargovcik
 */
@WebService(serviceName = "TheTestWebService")
public class TheTestWebService {
    private PersonDAO personDAO = new PersonDAO();

    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "hello")
    public String hello(@WebParam(name = "name") String txt) {
        return "Hello " + txt + " !";
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "getPerson")
    public String getPerson(@WebParam(name = "emailAddress") String emailAddress) {
        Person person = personDAO.getPerson(emailAddress);
        return person.toString();
    }
}
