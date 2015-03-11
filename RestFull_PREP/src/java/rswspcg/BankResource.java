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
public class BankResource {

    private String NSCode, AccounNo;

    /**
     * Creates a new instance of BankResource
     */
    private BankResource(String NSCode, String AccounNo) {
        this.NSCode = NSCode;
        this.AccounNo = AccounNo;
    }

    /**
     * Get instance of the BankResource
     */
    public static BankResource getInstance(String NSCode, String AccounNo) {
        // The user may use some kind of persistence mechanism
        // to store and restore instances of BankResource class.
        return new BankResource(NSCode, AccounNo);
    }

    /**
     * Retrieves representation of an instance of rswspcg.BankResource
     * @return an instance of java.lang.String
     */
    @GET
    @Produces("application/xml")
    public String getXml() {
        //TODO return proper representation object
        throw new UnsupportedOperationException();
    }

    /**
     * PUT method for updating or creating an instance of BankResource
     * @param content representation for the resource
     * @return an HTTP response with content of the updated or created resource.
     */
    @PUT
    @Consumes("application/xml")
    public void putXml(String content) {
    }

    /**
     * DELETE method for resource BankResource
     */
    @DELETE
    public void delete() {
    }
}
