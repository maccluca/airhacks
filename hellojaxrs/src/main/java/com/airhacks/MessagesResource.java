
package com.airhacks;

import java.net.URI;
import java.util.concurrent.TimeUnit;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.json.Json;
import javax.json.JsonObject;
import javax.validation.constraints.Size;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.container.AsyncResponse;
import javax.ws.rs.container.Suspended;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

/**
 *
 * @author airhacks.com
 */
@Stateless
@Path("messages")
public class MessagesResource {

    @Inject
    MessagesStore store;

    @GET
    public JsonObject message() {
        return Json.createObjectBuilder().
                add("content", "good afternoon").
                build();
    }

    @GET
    @Path("{id}")
    public Message find(@PathParam("id") long id) {
        return this.store.find(id);
    }


    @GET
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Path("/pojo/{payload}-{age}")
    public Message pojoMessage(@PathParam("payload") String payload, @PathParam("age") int age) {
        return new Message(payload, age);
    }

    @POST
    public Response save(JsonObject input, @Context UriInfo info) {
        System.out.println("input = " + input);
        String payload = input.getString("payload", "unknown");
        long id = this.store.saveOrUpdate(new Message(payload, 42));
        URI uri = info.getAbsolutePathBuilder().
                path("/" + id).build();
        return Response.created(uri).header("status", "java ee is boring").build();
    }

    @POST
    public void saveString(@Size(min = 1, max = 2, message = "stupid") String input) {
        System.out.println("input = " + input);
    }


    @GET
    @Path("/async")
    public void asyncMessage(@Suspended AsyncResponse response) {
        response.setTimeout(2, TimeUnit.SECONDS);
        response.resume("hey joe");
    }





}
