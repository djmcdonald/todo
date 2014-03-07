package com.djmcdonald.resources;

import com.djmcdonald.model.Todo;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("/service/todos")
@Produces("application/json")
public class TodoResource {

    @GET
    public Todo getTodo() {
        return new Todo("id");
    }
}
