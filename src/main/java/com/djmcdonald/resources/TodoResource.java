package com.djmcdonald.resources;

import com.djmcdonald.model.Todo;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

@Path("/service/todos")
@Produces("application/json")
public class TodoResource {

    @GET
    @Path("{id}")
    public Todo getTodo(@PathParam("id") String id) {
        return new Todo(id);
    }
}
