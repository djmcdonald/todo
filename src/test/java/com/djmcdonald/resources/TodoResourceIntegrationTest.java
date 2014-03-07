package com.djmcdonald.resources;

import com.djmcdonald.model.Todo;
import com.djmcdonald.repositories.TodosRepository;
import com.sun.jersey.api.client.ClientResponse;
import com.yammer.dropwizard.testing.ResourceTest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.List;

import static com.google.common.collect.Lists.newArrayList;
import static com.yammer.dropwizard.testing.JsonHelpers.asJson;
import static java.lang.String.format;
import static org.fest.assertions.Assertions.assertThat;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class TodoResourceIntegrationTest extends ResourceTest {

    @Mock
    private TodosRepository todosRepository;

    @Override
    protected void setUpResources() throws Exception {
        addResource(new TodoResource(todosRepository));
    }

    @Test
    public void shouldReturnASingleTodo() throws Exception {
        String id = "1";
        Todo expectedTodo = new Todo("thing");

        when(todosRepository.todo(id)).thenReturn(expectedTodo);

        assertThat(client().resource(format("/todos/%s", id)).get(Todo.class))
            .isEqualTo(expectedTodo);
    }

    @Test
    public void shouldThrow404WhenTryingToFindANonExistentTodo() throws Exception {
        String id = "42";
        when(todosRepository.todo(id)).thenReturn(null);

        assertThat(client().resource(format("/todos/%s", id)).get(ClientResponse.class).getStatus())
            .isEqualTo(404);
    }

    @Test
    public void shouldReturnAListOfTodos() throws Exception {
        List<Todo> expectedTodos = newArrayList(new Todo("1"), new Todo("2"));
        when(todosRepository.todos()).thenReturn(expectedTodos);

        assertThat(client().resource("/todos").get(String.class))
            .isEqualTo(asJson(expectedTodos));
    }
}
