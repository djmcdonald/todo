package com.djmcdonald.resources;

import com.djmcdonald.model.Todo;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import java.util.List;

import static com.google.common.collect.Lists.newArrayList;

@Path("/service/todos")
@Produces("application/json")
public class TodoResource {

    @GET
    @Path("{id}")
    public Todo todo(@PathParam("id") String id) {
        return new Todo(id);
    }

    @GET
    public List<Todo> todos() {
        return newArrayList(new Todo("1"), new Todo("2"));
    }
}
