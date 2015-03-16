/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rswspcg;

import dao.Link;
import dao.Person;
import dao.PersonDAO;
import java.util.ArrayList;
import java.util.Set;
import java.util.TreeSet;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.DELETE;
import javax.ws.rs.HEAD;
import javax.ws.rs.OPTIONS;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import responseErrors.PersonNotFound;

/**
 * REST Web Service
 *
 * @author Peter Vargovcik
 */
public class PersonResource {

    private String emailAddress;
    PersonDAO personDAO;

    /**
     * Creates a new instance of PersonResource
     */
    private PersonResource(String emailAddress) {
        this.emailAddress = emailAddress;
        personDAO = new PersonDAO();
    }

    /**
     * Get instance of the PersonResource
     */
    public static PersonResource getInstance(String emailAddress) {
        // The user may use some kind of persistence mechanism
        // to store and restore instances of PersonResource class.
        return new PersonResource(emailAddress);
    }

    /**
     * Retrieves representation of an instance of rswspcg.PersonResource
     *
     * @return an instance of java.lang.String
     */
    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Response getXml() {

        Person person = personDAO.getPerson(emailAddress);

        if (person == null) {
            return Response
                    .status(Response.Status.NOT_FOUND)
                    .entity(new PersonNotFound(emailAddress))
                    .build();
        }

        person.setLink(new ArrayList<Link>());

        Link linkSelf = new Link();
        linkSelf.setRel("self");
        linkSelf.setHref("/" + emailAddress);

        Link deleteLink = new Link();
        deleteLink.setRel("/linkrels/person/delete");
        deleteLink.setHref("/" + emailAddress);

        Link updateLink = new Link();
        updateLink.setRel("/linkrels/person/update");
        updateLink.setHref("/" + emailAddress);

        person.getLink().add(linkSelf);
        person.getLink().add(deleteLink);
        person.getLink().add(updateLink);

        return Response
                .status(Response.Status.OK)
                .entity(person)
                .build();
    }

    /**
     * PUT method for updating or creating an instance of PersonResource
     *
     * @param content representation for the resource
     * @return an HTTP response with content of the updated or created resource.
     */
    @PUT
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Response putXml(Person updatedPerson) {
        final int DB_UPDATE_OK = 1;
        System.out.println("emailAddress : "+emailAddress.equals(updatedPerson.getEmailAddress()));
        if(emailAddress.equals(updatedPerson.getEmailAddress())){
            if(personDAO.updatePerson(updatedPerson)== DB_UPDATE_OK){
                return Response.status(Response.Status.OK).entity(updatedPerson).build();
            }else{
                return Response
                        .status(Response.Status.CONFLICT)
                        .entity(new PersonNotFound(emailAddress)) 
                        .build();
            }
        }else{
            return Response
                        .status(Response.Status.CONFLICT)
                        .entity(new PersonNotFound(emailAddress)) 
                        .build();
        }        
    }

    /**
     * DELETE method for resource PersonResource
     */
    @DELETE
    public Response delete() {
        personDAO.deletePerson(emailAddress);
        
        return Response.noContent().status(Response.Status.NO_CONTENT).build();
    }

    // HEAD is the same as GET except there is no entity body
    //  - useful for testing
    @HEAD
    public Response doHead() {
        return Response
                .noContent()
                .status(Response.Status.OK)
                .build();
    }

    // OPTIONS enables a client to find out what verbs a particular resource supports
    @OPTIONS
    public Response doOptions() {
        Set<String> allowedVerbs = new TreeSet<>(); // will sort them
        allowedVerbs.add("GET");
        allowedVerbs.add("PUT");
        allowedVerbs.add("DELETE");
        allowedVerbs.add("HEAD");
        allowedVerbs.add("OPTIONS");
//        return "ok";
        return Response
                .noContent()
                .allow(allowedVerbs)
                .status(Response.Status.OK)
                .build();
    }
}
