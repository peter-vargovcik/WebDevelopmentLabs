/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rswspcg;

import dao.Person;
import dao.PersonDAO;
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
@Path("/people")
public class PeopleResource {
    PersonDAO personDAO;

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of PeopleResource
     */
    public PeopleResource() {
        personDAO = new PersonDAO();
    }

    /**
     * Retrieves representation of an instance of rswspcg.PeopleResource
     * @return an instance of java.lang.String
     */
    @GET
    @Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Response getXml() {
        
        List<Person> list = personDAO.getPersons(20);
//        List<Person> list = new ArrayList<>();
//        Person p = new Person();
//        p.setEmailAddress("peter.vargovcik@gmail.com");
//        list.add(p);
//        list.add(p);
        GenericEntity<List<Person>> output = new GenericEntity<List<Person>>(list){};
        
        //TODO return proper representation object
       return Response
                   .status(Response.Status.OK)
                   .entity(output)
                   .build();
    }

    /**
     * POST method for creating an instance of PersonResource
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
     * Sub-resource locator method for {emailAddress}
     */
    @Path("{emailAddress}")
    public PersonResource getPersonResource(@PathParam("emailAddress") String emailAddress) {
        return PersonResource.getInstance(emailAddress);
    }
}
