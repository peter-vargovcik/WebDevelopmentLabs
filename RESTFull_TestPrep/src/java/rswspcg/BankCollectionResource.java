/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rswspcg;

import dao.BankAccount;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.PathParam;
import javax.ws.rs.POST;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * REST Web Service
 *
 * @author Peter Vargovcik
 */
@Path("/bank")
public class BankCollectionResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of BankCollectionResource
     */
    public BankCollectionResource() {
    }

    /**
     * Retrieves representation of an instance of rswspcg.BankCollectionResource
     * @return an instance of java.lang.String
     */
    @GET
    @Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Response getXml() {
        List<BankAccount> list = new ArrayList<>();
        
        list.add(new BankAccount("11111", "123456", "Peter Vargovcik"));
        list.add(new BankAccount("11111", "123457", "Kevin  Vargovcik"));
        list.add(new BankAccount("11112", "198765", "Mark Vargovcik"));
        list.add(new BankAccount("11112", "154321", "Krister Vargovcik"));
        
       GenericEntity<List<BankAccount>> output = new GenericEntity<List<BankAccount>>(list){};
        
        return Response
                   .status(Response.Status.OK)
                   .entity(output)
                   .build();
    }

    /**
     * POST method for creating an instance of BankResource
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
     * Sub-resource locator method for {NSCode}/{AccounNo}
     */
    @Path("{NSCode}/{AccounNo}")
    public BankResource getBankResource(@PathParam("NSCode") String NSCode, @PathParam("AccounNo") String AccounNo) {
        return BankResource.getInstance(NSCode, AccounNo);
    }
}
