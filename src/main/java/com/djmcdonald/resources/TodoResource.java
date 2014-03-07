package com.djmcdonald.resources;

import com.djmcdonald.model.Todo;
import com.djmcdonald.repositories.TodosRepository;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import java.util.List;

@Path("/todos")
@Produces("application/json")
public class TodoResource {

    private final TodosRepository todosRepository;

    public TodoResource(TodosRepository todosRepository) {
        this.todosRepository = todosRepository;
    }

    @GET
    @Path("{id}")
    public Todo todo(@PathParam("id") String id) {
        return new Todo(id);
    }

    @GET
    public List<Todo> todos() {
        return todosRepository.todos();
    }
}
