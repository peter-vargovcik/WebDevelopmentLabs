/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rswspcg;

import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.DELETE;

/**
 * REST Web Service
 *
 * @author Peter Vargovcik
 */
public class AccountResource {

    private String AccountNumber;

    /**
     * Creates a new instance of AccountResource
     */
    private AccountResource(String AccountNumber) {
        this.AccountNumber = AccountNumber;
    }

    /**
     * Get instance of the AccountResource
     */
    public static AccountResource getInstance(String AccountNumber) {
        // The user may use some kind of persistence mechanism
        // to store and restore instances of AccountResource class.
        return new AccountResource(AccountNumber);
    }

    /**
     * Retrieves representation of an instance of rswspcg.AccountResource
     * @return an instance of java.lang.String
     */
    @GET
    @Produces("application/xml")
    public String getXml() {
        //TODO return proper representation object
        throw new UnsupportedOperationException();
    }

    /**
     * PUT method for updating or creating an instance of AccountResource
     * @param content representation for the resource
     * @return an HTTP response with content of the updated or created resource.
     */
    @PUT
    @Consumes("application/xml")
    public void putXml(String content) {
    }

    /**
     * DELETE method for resource AccountResource
     */
    @DELETE
    public void delete() {
    }
}
