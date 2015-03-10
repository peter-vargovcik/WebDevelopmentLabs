/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rswspcg;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.PathParam;
import javax.ws.rs.POST;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

/**
 * REST Web Service
 *
 * @author Peter Vargovcik
 */
@Path("/account")
public class AccountCollectionResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of AccountCollectionResource
     */
    public AccountCollectionResource() {
    }

    /**
     * Retrieves representation of an instance of rswspcg.AccountCollectionResource
     * @return an instance of java.lang.String
     */
    @GET
    @Produces("application/xml")
    public String getXml() {
        //TODO return proper representation object
        throw new UnsupportedOperationException();
    }

    /**
     * POST method for creating an instance of AccountResource
     * @param content representation for the new resource
     * @return an HTTP response with content of the created resource
     */
    @POST
    @Consumes("application/xml")
    @Produces("application/xml")
    public Response postXml(String content) {
        //TODO
        return Response.created(context.getAbsolutePath()).build();
    }

    /**
     * Sub-resource locator method for {AccountNumber}
     */
    @Path("{AccountNumber}")
    public AccountResource getAccountResource(@PathParam("AccountNumber") String AccountNumber) {
        return AccountResource.getInstance(AccountNumber);
    }
}
