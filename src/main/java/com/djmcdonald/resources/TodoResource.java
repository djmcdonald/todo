package com.djmcdonald.resources;

import com.djmcdonald.model.Todo;
import com.djmcdonald.repositories.TodosRepository;

import javax.ws.rs.*;
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
        Todo todo = todosRepository.todo(id);
        if (todo == null) {
            throw new WebApplicationException(404);
        }
        return todo;
    }

    @GET
    public List<Todo> todos() {
        return todosRepository.todos();
    }
}
